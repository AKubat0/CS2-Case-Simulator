package src;
import java.awt.*;
import javax.swing.*;

public class AdminPanel extends JPanel {
    private Navigator nav;
    JButton adminButton;

    private final String ADMIN_PASSWORD = "admin123";

    public AdminPanel(Navigator nav) {
        this.nav = nav;
        setLayout(new FlowLayout(FlowLayout.LEFT));
        setBackground(new Color(10, 9, 13));
        setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));

        adminButton = createStyledButton("ADMIN PANEL");
        add(adminButton);
        adminButton.addActionListener(e -> { showAdminPanel(); });
    
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

    private void showAdminPanel() {
        JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(this);
        String input = JOptionPane.showInputDialog(frame, "Enter admin password:", "Admin Access", JOptionPane.PLAIN_MESSAGE);
        if (input != null && input.equals(ADMIN_PASSWORD)) {
            JOptionPane.showMessageDialog(frame, "Admin access granted.");
        } else {
            JOptionPane.showMessageDialog(frame, "Invalid admin password.", "Admin Access", JOptionPane.ERROR_MESSAGE);
        }
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
