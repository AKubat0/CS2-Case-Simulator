package src;

import java.awt.*;
import javax.swing.*;

public class CaseResultPanel extends JPanel {
    private CaseItem wonItem;

    public CaseResultPanel(CaseItem wonItem) {
        this.wonItem = wonItem;
        setOpaque(false);
        this.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.gridx = 0;

        // 1. Title Label (Subtitle style)
        JLabel subtitle = new JLabel("YOU UNBOXED", SwingConstants.CENTER);
        subtitle.setFont(new Font("SansSerif", Font.BOLD, 14));
        subtitle.setForeground(new Color(200, 200, 200));
        gbc.gridy = 0;
        add(subtitle, gbc);

        // 2. Item Name Label (Main Header)
        JLabel nameLabel = new JLabel(wonItem.getName().toUpperCase(), SwingConstants.CENTER);
        nameLabel.setFont(new Font("SansSerif", Font.BOLD, 32));
        nameLabel.setForeground(Color.WHITE);
        gbc.gridy = 1;
        add(nameLabel, gbc);

        // 3. Icon (Proportional Scaling)
        ImageIcon icon = wonItem.getIcon();
        if (icon != null) {
            Image img = icon.getImage();
            // Scale to a larger size for the result screen
            Image scaledImg = img.getScaledInstance(400, 300, Image.SCALE_SMOOTH);
            JLabel iconLabel = new JLabel(new ImageIcon(scaledImg));
            gbc.gridy = 2;
            gbc.insets = new Insets(30, 10, 30, 10);
            add(iconLabel, gbc);
        }

        // 4. Details Panel (Rarity and Wear)
        JPanel details = new JPanel(new FlowLayout(FlowLayout.CENTER, 40, 0));
        details.setOpaque(false);
        
        JLabel rarityLabel = new JLabel(wonItem.getRarity().toString());
        rarityLabel.setForeground(getRarityColor(wonItem.getRarity()));
        rarityLabel.setFont(new Font("SansSerif", Font.BOLD, 18));
        
        JLabel wearLabel = new JLabel(String.format("WEAR: %.10f", wonItem.getWear()));
        wearLabel.setForeground(Color.GRAY);
        wearLabel.setFont(new Font("Monospaced", Font.PLAIN, 14));
        
        details.add(rarityLabel);
        details.add(wearLabel);
        gbc.gridy = 3;
        gbc.insets = new Insets(10, 10, 40, 10);
        add(details, gbc);

        // 5. Buttons
        JPanel buttons = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 0));
        buttons.setOpaque(false);

        JButton openAnother = createStyledButton("OPEN ANOTHER");
        JButton inventory = createStyledButton("TO INVENTORY");
        
        buttons.add(openAnother);
        buttons.add(inventory);
        gbc.gridy = 4;
        add(buttons, gbc);
    }

    private JButton createStyledButton(String text) {
        JButton btn = new JButton(text);
        btn.setFont(new Font("SansSerif", Font.BOLD, 12));
        btn.setForeground(Color.WHITE);
        btn.setBackground(new Color(45, 45, 50));
        btn.setFocusPainted(false);
        btn.setBorder(BorderFactory.createEmptyBorder(10, 25, 10, 25));
        return btn;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // Draw Dark Background
        g2.setColor(new Color(10, 9, 13));
        g2.fillRect(0, 0, getWidth(), getHeight());

        // Draw Radial Glow based on rarity
        Color rarityColor = getRarityColor(wonItem.getRarity());
        float[] dist = {0.0f, 0.7f};
        Color[] colors = {new Color(rarityColor.getRed(), rarityColor.getGreen(), rarityColor.getBlue(), 50), 
                          new Color(10, 9, 13, 0)};
        
        RadialGradientPaint gp = new RadialGradientPaint(
            new Point(getWidth()/2, getHeight()/2), 
            (float)getHeight()/2, dist, colors);
            
        g2.setPaint(gp);
        g2.fillRect(0, 0, getWidth(), getHeight());
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
