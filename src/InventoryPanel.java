package src;

import java.awt.*;
import javax.swing.*;

public class InventoryPanel extends JPanel {
    private Inventory inventory;
    private JPanel gridPanel;

    public InventoryPanel(Inventory inventory) {
        this.inventory = inventory;
        this.setLayout(new BorderLayout());
        this.setBackground(new Color(10, 9, 13));

        gridPanel = new JPanel(new GridLayout(0, 4, 15, 15));
        gridPanel.setBackground(new Color(10, 9, 13));
        gridPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JScrollPane scrollPane = new JScrollPane(gridPanel);
        scrollPane.setBorder(null);
        scrollPane.getVerticalScrollBar().setUnitIncrement(16);
        scrollPane.getViewport().setBackground(new Color(10, 9, 13));
        
        add(scrollPane, BorderLayout.CENTER);
        refreshInventory();
    }

    public void refreshInventory() {
        gridPanel.removeAll();
        for (CaseItem item : inventory.getItems()) {
            gridPanel.add(createItemCard(item));
        }
        gridPanel.revalidate();
        gridPanel.repaint();
    }

    private JPanel createItemCard(CaseItem item) {
        JPanel card = new JPanel();
        card.setLayout(new BorderLayout());
        card.setBackground(new Color(30, 30, 35));
        card.setPreferredSize(new Dimension(180, 220));
        
        // Rarity border color
        Color rarityColor = getRarityColor(item.getRarity());
        card.setBorder(BorderFactory.createMatteBorder(0, 0, 4, 0, rarityColor));

        // 1. Icon Container
        JLabel iconLabel = new JLabel();
        if (item.getIcon() != null) {
            Image img = item.getIcon().getImage();
            // Scale keeping aspect ratio
            double ratio = Math.min(140.0 / img.getWidth(null), 100.0 / img.getHeight(null));
            Image scaled = img.getScaledInstance((int)(img.getWidth(null)*ratio), (int)(img.getHeight(null)*ratio), Image.SCALE_SMOOTH);
            iconLabel.setIcon(new ImageIcon(scaled));
        }
        iconLabel.setHorizontalAlignment(SwingConstants.CENTER);
        card.add(iconLabel, BorderLayout.CENTER);

        // 2. Info Panel (Bottom)
        JPanel infoPanel = new JPanel(new GridLayout(2, 1));
        infoPanel.setOpaque(false);
        infoPanel.setBorder(BorderFactory.createEmptyBorder(5, 10, 10, 10));

        // Name (truncate if long)
        String displayName = item.getName();
        if (item.isStatTrak()) {
            displayName = "<html><font color='#cf6a32'>StatTrak™</font> " + displayName + "</html>";
        }
        
        JLabel nameLabel = new JLabel(displayName);
        nameLabel.setFont(new Font("SansSerif", Font.BOLD, 11));
        nameLabel.setForeground(Color.WHITE);
        
        JLabel wearLabel = new JLabel(getWearName(item.getWear()));
        wearLabel.setFont(new Font("SansSerif", Font.PLAIN, 10));
        wearLabel.setForeground(Color.GRAY);

        infoPanel.add(nameLabel);
        infoPanel.add(wearLabel);
        
        card.add(infoPanel, BorderLayout.SOUTH);

        return card;
    }

    private String getWearName(float wear) {
        if (wear < 0.07) return "Factory New";
        if (wear < 0.15) return "Minimal Wear";
        if (wear < 0.38) return "Field-Tested";
        if (wear < 0.45) return "Well-Worn";
        return "Battle-Scarred";
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
