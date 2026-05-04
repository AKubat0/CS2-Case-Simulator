package src;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.*;

public class CaseAnimationPanel extends JPanel {
    // --- Performance Constants (Prevents GC Stutter) ---
    private static final Color BG_COLOR = new Color(11, 13, 18);
    private static final Color NEEDLE_COLOR = new Color(255, 215, 0);
    private static final Color TEXT_COLOR = Color.LIGHT_GRAY;
    private static final Font NAME_FONT = new Font("SansSerif", Font.PLAIN, 11);
    private static final BasicStroke NEEDLE_STROKE = new BasicStroke(3);
    
    // Rendering hints for the best balance of speed and quality
    private static final Map<RenderingHints.Key, Object> HINTS = new HashMap<>();
    static {
        HINTS.put(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        HINTS.put(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        HINTS.put(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_SPEED);
    }

    private Navigator nav;
    private List<CaseItem> spinItems;
    private CaseItem winningItem;
    
    // Image Cache: Stores pre-scaled images so we don't scale during paintComponent
    private final Map<CaseItem, Image> scaledImageCache = new HashMap<>();

    private double currentX = 0;      
    private double velocity = 0;     
    private Timer animTimer;
    
    private final int ITEM_WIDTH = 220;
    private final int ITEM_HEIGHT = 200;
    private final int WINNING_INDEX = 27; 
    private final double FRICTION = 0.985; 
    
    private CaseOpenManager caseOpenManager;
    private Case currentCase;

    public CaseAnimationPanel(Case selectedCase, Navigator nav) {
        this.currentCase = selectedCase;
        this.nav = nav;
        this.caseOpenManager = new CaseOpenManager();
        
        // Setting opaque to true is faster if you don't need transparency
        setOpaque(true);
        setBackground(new Color(30, 30, 30)); 
        this.setPreferredSize(new Dimension(800, 300));
        
        prepareStrip(selectedCase);

        animTimer = new Timer(10, e -> {
            updatePhysics();
            repaint();
        });
    }

    private void prepareStrip(Case c) {
        spinItems = new ArrayList<>();
        scaledImageCache.clear();
        this.winningItem = caseOpenManager.openCase(c);

        for (int i = 0; i < 40; i++) {
            CaseItem item = (i == WINNING_INDEX) ? winningItem : caseOpenManager.openCase(c);
            spinItems.add(item);

            // Pre-scale images immediately so the UI doesn't lag later
            if (item.getIcon() != null && !scaledImageCache.containsKey(item)) {
                Image scaled = createCompatibleScaledImage(item.getIcon().getImage(), ITEM_WIDTH - 40, ITEM_HEIGHT - 60);
                scaledImageCache.put(item, scaled);
            }
        }
    }

    /**
     * Creates an image optimized for your specific hardware/monitor.
     * This is significantly faster than standard scaling.
     */
    private Image createCompatibleScaledImage(Image src, int targetW, int targetH) {
        GraphicsConfiguration config = GraphicsEnvironment.getLocalGraphicsEnvironment()
                .getDefaultScreenDevice().getDefaultConfiguration();
        
        // Calculate aspect ratio
        int iw = src.getWidth(null);
        int ih = src.getHeight(null);
        double ratio = Math.min((double) targetW / iw, (double) targetH / ih);
        int dw = (int) (iw * ratio);
        int dh = (int) (ih * ratio);

        BufferedImage result = config.createCompatibleImage(dw, dh, Transparency.TRANSLUCENT);
        Graphics2D g2d = result.createGraphics();
        
        g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BICUBIC);
        g2d.drawImage(src, 0, 0, dw, dh, null);
        g2d.dispose();
        
        return result;
    }

    public void startSpin() {
        currentX = 0;
        double targetDistance = (WINNING_INDEX * ITEM_WIDTH);
        // Physics formula to ensure we land near the target distance
        this.velocity = (targetDistance * (1 - FRICTION)) / FRICTION;
        animTimer.start();
    }

    private void updatePhysics() {
        currentX += velocity; 
        velocity *= FRICTION;     

        if (velocity < 0.5) { 
            velocity = 0;
            animTimer.stop();
            nav.showResult(winningItem);
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHints(HINTS);

        int panelHeight = getHeight();
        int panelWidth = getWidth();
        int centerY = (panelHeight - ITEM_HEIGHT) / 2;
        int centerX = panelWidth / 2;

        // Draw Background
        g2.setColor(BG_COLOR);
        g2.fillRect(0, centerY - 20, panelWidth, ITEM_HEIGHT + 40);

        // Draw Items
        for (int i = 0; i < spinItems.size(); i++) {
            // Calculate xPos based on current scroll
            int xPos = (int) (i * ITEM_WIDTH - currentX + centerX - (ITEM_WIDTH / 2));

            // Viewport Clipping: Only draw if the item is actually visible on screen
            if (xPos + ITEM_WIDTH > 0 && xPos < panelWidth) {
                CaseItem item = spinItems.get(i);
                
                // 1. Draw Rarity Bar
                g2.setColor(getRarityColor(item.getRarity()));
                g2.fillRect(xPos + 5, centerY + ITEM_HEIGHT - 5, ITEM_WIDTH - 10, 5);

                // 2. Draw Cached Scaled Image
                Image img = scaledImageCache.get(item);
                if (img != null) {
                    int offX = (ITEM_WIDTH - img.getWidth(null)) / 2;
                    int offY = (ITEM_HEIGHT - img.getHeight(null)) / 2;
                    g2.drawImage(img, xPos + offX, centerY + offY, null);
                }
                
                // 3. Draw Name Text
                g2.setColor(TEXT_COLOR);
                g2.setFont(NAME_FONT);
                String name = item.getName();
                if(name.length() > 30) name = name.substring(0, 27) + "...";
                g2.drawString(name, xPos + 10, centerY + ITEM_HEIGHT + 15);
            }
        }

        // Draw Center Needle
        g2.setColor(NEEDLE_COLOR); 
        g2.setStroke(NEEDLE_STROKE);
        g2.drawLine(centerX, centerY - 30, centerX, centerY + ITEM_HEIGHT + 30);

        int[] tx = {centerX - 10, centerX + 10, centerX};
        int[] ty = {centerY - 30, centerY - 30, centerY - 10};
        g2.fillPolygon(tx, ty, 3);
    }

    private Color getRarityColor(ItemRarity rarity) {
        return switch (rarity) {
            case MIL_SPEC -> new Color(75, 105, 255);
            case RESTRICTED -> new Color(136, 71, 255);
            case CLASSIFIED -> new Color(211, 44, 230);
            case COVERT -> new Color(235, 75, 75);
            case RARE_SPECIAL_ITEM -> new Color(255, 215, 0);
            default -> Color.GRAY;
        };
    }
}