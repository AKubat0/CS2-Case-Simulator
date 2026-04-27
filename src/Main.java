package src;
import java.net.URL;
import javax.swing.*;

public class Main{

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame();
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(1920, 1080);
            frame.setResizable(true);
            frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
            frame.setLocationRelativeTo(null);
            frame.setTitle("CS2 Case Simulator");

            URL iconURL = Main.class.getResource("/SourceImages/main-icon.png");
            if (iconURL != null) {
                ImageIcon icon = new ImageIcon(iconURL);
                frame.setIconImage(icon.getImage());
            } else {
                System.err.println("Icon image not found at: " + iconURL);
            }

            frame.setVisible(true);
        });


        
    }

}