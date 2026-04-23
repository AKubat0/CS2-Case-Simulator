import javax.swing.*;
import java.awt.*;

public class Main{

    Swing.Utilities.invokeLater(() -> {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setLocationRelativeTo(null);
        frame.setTitle("CS2 Case Simulator");
        
        
        frame.setVisible(true);


    });



}