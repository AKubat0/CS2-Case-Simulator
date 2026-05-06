package src;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class AdminPanel extends JPanel {
    private Navigator nav;
    private JButton adminButton;
    private final String ADMIN_PASSWORD = "123";

    public AdminPanel(Navigator nav) {
        this.nav = nav;
        setLayout(new FlowLayout(FlowLayout.LEFT));
        setBackground(new Color(10, 9, 13));
        setBorder(new EmptyBorder(10, 20, 10, 20));

        adminButton = createStyledButton("ADMIN PANEL");
        add(adminButton);
        adminButton.addActionListener(e -> showPasswordDialog());
    }

    private void showPasswordDialog() {
        JDialog dialog = new JDialog((JFrame) SwingUtilities.getWindowAncestor(this), "Admin Access", true);
        dialog.getContentPane().setBackground(new Color(25, 25, 30));

        JPanel content = new JPanel();
        content.setLayout(new BoxLayout(content, BoxLayout.Y_AXIS));
        content.setOpaque(false);
        content.setBorder(new EmptyBorder(25, 30, 25, 30));

        JLabel label = new JLabel("Enter Admin Password:");
        label.setForeground(Color.WHITE);
        label.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        JPasswordField passField = new JPasswordField(15);
        passField.setMaximumSize(new Dimension(200, 30));
        passField.setBackground(new Color(45, 45, 50));
        passField.setForeground(Color.WHITE);
        passField.setCaretColor(Color.WHITE);
        passField.setBorder(BorderFactory.createLineBorder(new Color(70, 70, 75)));
        passField.setAlignmentX(Component.CENTER_ALIGNMENT);

        JButton loginBtn = createStyledButton("LOGIN");
        loginBtn.setAlignmentX(Component.CENTER_ALIGNMENT);
        loginBtn.addActionListener(e -> {
            if (new String(passField.getPassword()).equals(ADMIN_PASSWORD)) {
                dialog.dispose();
                SwingUtilities.invokeLater(() -> showSettingsDialog());
            } else {
                label.setText("Invalid Password!");
                label.setForeground(new Color(235, 75, 75));
            }
        });

        content.add(label);
        content.add(Box.createVerticalStrut(15)); 
        content.add(passField);
        content.add(Box.createVerticalStrut(15));
        content.add(loginBtn);

        dialog.add(content);
        dialog.pack();
        dialog.setLocationRelativeTo(SwingUtilities.getWindowAncestor(this));
        dialog.setVisible(true);
    }

    private void showSettingsDialog() {
        JDialog dialog = new JDialog((JFrame) SwingUtilities.getWindowAncestor(this), "Admin Settings", true);
        dialog.getContentPane().setBackground(new Color(10, 9, 13));

        // Using a clean 5 Row, 3 Column GridLayout
        JPanel mainPanel = new JPanel(new GridLayout(5, 3, 10, 15));
        mainPanel.setOpaque(false);
        mainPanel.setBorder(new EmptyBorder(20, 20, 20, 20));

        // --- ROW 1: Master Enable ---
        mainPanel.add(createLabel("Master Admin Mode:"));
        mainPanel.add(new JLabel()); // Empty spacer for the middle column
        JCheckBox masterToggle = createStyledToggle(AdminSettings.enabled);
        masterToggle.addActionListener(e -> AdminSettings.enabled = masterToggle.isSelected());
        mainPanel.add(masterToggle);

        // --- ROW 2: Rarity Setting ---
        mainPanel.add(createLabel("Override Rarity:"));
        JCheckBox rarityToggle = createStyledToggle(AdminSettings.desiredRarityEnabled);
        rarityToggle.addActionListener(e -> AdminSettings.desiredRarityEnabled = rarityToggle.isSelected());
        mainPanel.add(rarityToggle);

        JComboBox<ItemRarity> rarityBox = new JComboBox<>(ItemRarity.values());
        rarityBox.setSelectedItem(AdminSettings.getDesiredRarity());
        rarityBox.addActionListener(e -> AdminSettings.setDesiredRarity((ItemRarity) rarityBox.getSelectedItem()));
        mainPanel.add(rarityBox);

        // --- ROW 3: Wear Setting ---
        mainPanel.add(createLabel("Set Wear (0-1):"));
        JCheckBox wearToggle = createStyledToggle(AdminSettings.desiredWearEnabled);
        wearToggle.addActionListener(e -> AdminSettings.desiredWearEnabled = wearToggle.isSelected());
        mainPanel.add(wearToggle);

        JSlider wearSlider = new JSlider(0, 100, (int)(AdminSettings.getDesiredWear() * 100));
        wearSlider.setOpaque(false);
        wearSlider.addChangeListener(e -> AdminSettings.setDesiredWear(wearSlider.getValue() / 100f));
        mainPanel.add(wearSlider);

        // --- ROW 4: StatTrak Setting ---
        mainPanel.add(createLabel("Force StatTrak:"));
        JCheckBox stToggle = createStyledToggle(AdminSettings.forceStatTrakEnabled);
        stToggle.addActionListener(e -> AdminSettings.forceStatTrakEnabled = stToggle.isSelected());
        mainPanel.add(stToggle);

        JCheckBox stValue = createStyledToggle(AdminSettings.getForceStatTrak());
        stValue.setText("Yes");
        stValue.setForeground(Color.WHITE);
        stValue.addActionListener(e -> AdminSettings.setForceStatTrak(stValue.isSelected()));
        mainPanel.add(stValue);

        // --- ROW 5: Pattern Setting ---
        mainPanel.add(createLabel("Desired Pattern:"));
        JCheckBox patternToggle = createStyledToggle(AdminSettings.desiredPatternEnabled);
        patternToggle.addActionListener(e -> AdminSettings.desiredPatternEnabled = patternToggle.isSelected());
        mainPanel.add(patternToggle);

        JSlider patternSlider = new JSlider(1, 1000, AdminSettings.getDesiredPattern());
        patternSlider.setOpaque(false);
        patternSlider.addChangeListener(e -> AdminSettings.setDesiredPattern(patternSlider.getValue()));
        mainPanel.add(patternSlider);

        dialog.add(mainPanel, BorderLayout.CENTER);
        
        JButton closeBtn = createStyledButton("SAVE & CLOSE");
        closeBtn.addActionListener(e -> dialog.dispose());
        dialog.add(closeBtn, BorderLayout.SOUTH);

        dialog.pack();
        dialog.setMinimumSize(new Dimension(500, 400));
        dialog.setLocationRelativeTo(SwingUtilities.getWindowAncestor(this));
        dialog.setVisible(true);
    }

    private JLabel createLabel(String text) {
        JLabel l = new JLabel(text);
        l.setForeground(Color.WHITE);
        l.setFont(new Font("SansSerif", Font.BOLD, 12));
        return l;
    }

    private JCheckBox createStyledToggle(boolean initial) {
        JCheckBox cb = new JCheckBox();
        cb.setSelected(initial);
        cb.setOpaque(false);
        return cb;
    }

    private JButton createStyledButton(String text) {
        JButton btn = new JButton(text);
        btn.setFont(new Font("SansSerif", Font.BOLD, 12));
        btn.setForeground(Color.WHITE);
        btn.setBackground(new Color(45, 45, 50));
        btn.setFocusPainted(false);
        btn.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
        return btn;
    }

    public static class AdminSettings {
        public static boolean enabled = false;

   
        private static ItemRarity desiredRarity = ItemRarity.MIL_SPEC;
        public static boolean desiredRarityEnabled = false;

        private static float desiredWear = 0.05f;
        public static boolean desiredWearEnabled = false;

        private static int desiredPattern = 1; 
        public static boolean desiredPatternEnabled = false;

        private static boolean forceStatTrak = false;
        public static boolean forceStatTrakEnabled = false;

        public static void setDesiredRarity(ItemRarity rarity) { desiredRarity = rarity; }   
        public static ItemRarity getDesiredRarity() { return desiredRarity; }

        public static void setDesiredWear(float wear) { 
            desiredWear = Math.max(0, Math.min(1, wear)); 
        }
        public static float getDesiredWear() { return desiredWear; }

        public static void setDesiredPattern(int pattern) { 
            desiredPattern = Math.max(1, Math.min(1000, pattern));
        }
        public static int getDesiredPattern() { return desiredPattern; }

        public static void setForceStatTrak(boolean statTrak) { forceStatTrak = statTrak; }
        public static boolean getForceStatTrak() { return forceStatTrak; }
    }
}   
