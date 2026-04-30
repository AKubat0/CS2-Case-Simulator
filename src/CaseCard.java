package src;

import java.awt.*;
import java.awt.event.ActionListener;
import javax.swing.*;

public class CaseCard extends JPanel {
    public CaseCard(Case _case, ActionListener openAction) {

        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBorder(BorderFactory.createEtchedBorder());
        setBackground(new Color(35, 43, 56));

        JLabel imageLabel = new JLabel(new ImageIcon(_case.getCaseIcon().getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH)));
        imageLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel nameLabel = new JLabel(_case.getCaseName());
        nameLabel.setFont(new Font("SansSerif", Font.BOLD, 14));
        nameLabel.setForeground(Color.WHITE);
        nameLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        JButton openButton = new JButton("Open Case");
        openButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        openButton.addActionListener(openAction);

        add(Box.createVerticalStrut(10));
        add(imageLabel);
        add(Box.createVerticalStrut(10));
        add(nameLabel);
        add(Box.createVerticalStrut(10));
        add(openButton);
        add(Box.createVerticalStrut(10));
    }
}
