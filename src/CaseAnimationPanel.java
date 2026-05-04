package src;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;

public class CaseAnimationPanel extends JPanel {
    private Navigator nav;
    private List<CaseItem> spinItems;
    private CaseItem winningItem;
    
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
        
        setOpaque(false);
        this.setPreferredSize(new Dimension(800, 300));
        
        prepareStrip(selectedCase);

        animTimer = new Timer(16, e -> {
            updatePhysics();
            repaint();
        });
    }

    private void prepareStrip(Case c) {
        spinItems = new ArrayList<>();
        this.winningItem = caseOpenManager.openCase(c);

        for (int i = 0; i < 40; i++) {
            if (i == WINNING_INDEX) {
                spinItems.add(winningItem);
            } else {
                spinItems.add(caseOpenManager.openCase(c));
            }
        }
    }

    public void startSpin() {
        currentX = 0;
        double targetDistance = (WINNING_INDEX * ITEM_WIDTH);
        this.velocity = (targetDistance * (1 - FRICTION)) / FRICTION;
        animTimer.start();
    }

    private void updatePhysics() {
        currentX += velocity; 
        velocity *= FRICTION;     

        if (velocity < 1) { 
            velocity = 0;
            animTimer.stop();
            nav.showResult(winningItem);
            System.out.println("You won: " + winningItem.getName() + " (Rarity: " + winningItem.getRarity() + ")");
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;

        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);

        int centerY = (getHeight() - ITEM_HEIGHT) / 2;
        int centerX = getWidth() / 2;

        g2.setColor(new Color(15, 17, 20));
        g2.fillRect(0, centerY - 20, getWidth(), ITEM_HEIGHT + 40);

        for (int i = 0; i < spinItems.size(); i++) {
            int xPos = (int) (i * ITEM_WIDTH - currentX + centerX - (ITEM_WIDTH / 2));

            if (xPos + ITEM_WIDTH > 0 && xPos < getWidth()) {
                CaseItem item = spinItems.get(i);
                
                g2.setColor(getRarityColor(item.getRarity()));
                g2.fillRect(xPos + 5, centerY + ITEM_HEIGHT - 5, ITEM_WIDTH - 10, 5);

                if (item.getIcon() != null) {
                    Image img = item.getIcon().getImage();
                    int iw = img.getWidth(null);
                    int ih = img.getHeight(null);

                    double ratio = Math.min((double) (ITEM_WIDTH - 20) / iw, (double) (ITEM_HEIGHT - 20) / ih);
                    int dw = (int) (iw * ratio);
                    int dh = (int) (ih * ratio);
                    int offX = (ITEM_WIDTH - dw) / 2;
                    int offY = (ITEM_HEIGHT - dh) / 2;

                    g2.drawImage(img, xPos + offX, centerY + offY, dw, dh, null);
                }
                
                g2.setColor(Color.LIGHT_GRAY);
                g2.setFont(new Font("SansSerif", Font.PLAIN, 11));
                String name = item.getName();
                if(name.length() > 40) name = name.substring(0, 18) + "...";
                g2.drawString(name, xPos + 10, centerY + ITEM_HEIGHT + 15);
            }
        }

        g2.setColor(new Color(255, 215, 0)); 
        g2.setStroke(new BasicStroke(3));
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