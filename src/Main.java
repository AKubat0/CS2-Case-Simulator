package src;
import javax.swing.*;

public class Main{

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame();
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(400, 300);
            frame.setLocationRelativeTo(null);
            frame.setTitle("CS2 Case Simulator");

            frame.setVisible(true);
        });


        
    }

}