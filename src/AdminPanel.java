package src;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class AdminPanel extends JPanel {
    private Navigator nav;
    private JButton adminButton;
    private final String ADMIN_PASSWORD = "admin123";

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
        Window parent = SwingUtilities.getWindowAncestor(this);
        JDialog dialog = new JDialog((JFrame) parent, "Admin Access", true);
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
                // Use invokeLater to ensure the password dialog is fully gone
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
        dialog.setLocationRelativeTo(parent);
        dialog.setVisible(true);
    }

    private void showSettingsDialog() {
        Window parent = SwingUtilities.getWindowAncestor(this);
        JDialog dialog = new JDialog((JFrame) parent, "Admin Settings", true);
        dialog.getContentPane().setBackground(new Color(10, 9, 13));

        JPanel mainPanel = new JPanel(new GridBagLayout());
        mainPanel.setOpaque(false);
        mainPanel.setBorder(new EmptyBorder(20, 20, 20, 20));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(8, 8, 8, 8);

        // Row 0: Master Toggle
        gbc.gridy = 0; gbc.gridx = 0;
        mainPanel.add(createLabel("MASTER ADMIN ENABLE:"), gbc);
        JCheckBox masterToggle = createStyledToggle(AdminSettings.enabled);
        masterToggle.addActionListener(e -> AdminSettings.enabled = masterToggle.isSelected());
        gbc.gridx = 2;
        mainPanel.add(masterToggle, gbc);

        // Row 1: Rarity
        gbc.gridy = 1; gbc.gridx = 0;
        mainPanel.add(createLabel("OVERRIDE RARITY:"), gbc);
        JCheckBox rarityToggle = createStyledToggle(AdminSettings.desiredRarityEnabled);
        rarityToggle.addActionListener(e -> AdminSettings.desiredRarityEnabled = rarityToggle.isSelected());
        gbc.gridx = 1; mainPanel.add(rarityToggle, gbc);

        JComboBox<ItemRarity> rarityBox = new JComboBox<>(ItemRarity.values());
        rarityBox.setSelectedItem(AdminSettings.getDesiredRarity());
        rarityBox.addActionListener(e -> AdminSettings.setDesiredRarity((ItemRarity) rarityBox.getSelectedItem()));
        gbc.gridx = 2; mainPanel.add(rarityBox, gbc);

        // Row 2: Wear
        gbc.gridy = 2; gbc.gridx = 0;
        mainPanel.add(createLabel("OVERRIDE WEAR:"), gbc);
        JCheckBox wearToggle = createStyledToggle(AdminSettings.desiredWearEnabled);
        wearToggle.addActionListener(e -> AdminSettings.desiredWearEnabled = wearToggle.isSelected());
        gbc.gridx = 1; mainPanel.add(wearToggle, gbc);

        JSlider wearSlider = new JSlider(0, 100, (int)(AdminSettings.getDesiredWear() * 100));
        wearSlider.setOpaque(false);
        wearSlider.addChangeListener(e -> AdminSettings.setDesiredWear(wearSlider.getValue() / 100f));
        gbc.gridx = 2; mainPanel.add(wearSlider, gbc);

        // Row 3: Pattern
        gbc.gridy = 3; gbc.gridx = 0;
        mainPanel.add(createLabel("OVERRIDE PATTERN:"), gbc);
        JCheckBox patternToggle = createStyledToggle(AdminSettings.desiredPatternEnabled);
        patternToggle.addActionListener(e -> AdminSettings.desiredPatternEnabled = patternToggle.isSelected());
        gbc.gridx = 1; mainPanel.add(patternToggle, gbc);

        JSpinner patternSpinner = new JSpinner(new SpinnerNumberModel(AdminSettings.getDesiredPattern(), 1, 1000, 1));
        patternSpinner.addChangeListener(e -> AdminSettings.setDesiredPattern((int) patternSpinner.getValue()));
        gbc.gridx = 2; mainPanel.add(patternSpinner, gbc);

        // Row 4: StatTrak
        gbc.gridy = 4; gbc.gridx = 0;
        mainPanel.add(createLabel("OVERRIDE STATTRAK:"), gbc);
        JCheckBox stToggle = createStyledToggle(AdminSettings.forceStatTrakEnabled);
        stToggle.addActionListener(e -> AdminSettings.forceStatTrakEnabled = stToggle.isSelected());
        gbc.gridx = 1; mainPanel.add(stToggle, gbc);

        JCheckBox stValue = createStyledToggle(AdminSettings.getForceStatTrak());
        stValue.setText("Force On");
        stValue.setForeground(Color.WHITE);
        stValue.addActionListener(e -> AdminSettings.setForceStatTrak(stValue.isSelected()));
        gbc.gridx = 2; mainPanel.add(stValue, gbc);

        dialog.add(mainPanel, BorderLayout.CENTER);
        
        JButton closeBtn = createStyledButton("SAVE & CLOSE");
        closeBtn.addActionListener(e -> dialog.dispose());
        dialog.add(closeBtn, BorderLayout.SOUTH);

        dialog.pack();
        dialog.setMinimumSize(new Dimension(500, 450));
        dialog.setLocationRelativeTo(parent);
        dialog.setVisible(true);
    }

    private JLabel createLabel(String text) {
        JLabel l = new JLabel(text);
        l.setForeground(Color.WHITE);
        l.setFont(new Font("SansSerif", Font.BOLD, 11));
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

    public static class AdminSettings{

        public static boolean enabled = false;

        static ItemRarity desiredRarity;
        public static boolean desiredRarityEnabled = false;

        public static void setDesiredRarity(ItemRarity rarity) {
            desiredRarity = rarity;
        }   
        public static ItemRarity getDesiredRarity() {
            return desiredRarity;
        }

        static float desiredWear;
        public static boolean desiredWearEnabled = false;

        public static void setDesiredWear(float wear) {
            desiredWear = Math.clamp(wear, 0, 1);
        }
        public static float getDesiredWear() {
            return desiredWear;
        }

        static int desiredPattern;
        public static boolean desiredPatternEnabled = false;

        public static void setDesiredPattern(int pattern) {
            desiredPattern = Math.clamp(pattern, 1, 1000);
        }
        public static int getDesiredPattern() {
            return desiredPattern;
        }

        static boolean forceStatTrak;
        public static boolean forceStatTrakEnabled = false;

        public static void setForceStatTrak(boolean statTrak) {
            forceStatTrak = statTrak;
        }
        public static boolean getForceStatTrak() {
            return forceStatTrak;
        }

    }
}   
