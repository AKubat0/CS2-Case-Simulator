import javax.swing.*;
import java.awt.*;

public class Main{

    Swing.Utilities.invokeLater(() -> {
        JFrame frame = new JFrame("My Application");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setLocationRelativeTo(null); // Center the frame on the screen
        frame.setVisible(true);

        
    });



}