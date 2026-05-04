package src;

import java.awt.*;
import java.awt.event.ActionListener;
import javax.swing.*;

public class CaseCard extends JPanel {
    public CaseCard(Case _case, ActionListener openAction) {

        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBorder(BorderFactory.createEtchedBorder());
        setBackground(new Color(20, 23, 27));

        ImageIcon originalIcon = _case.getCaseIcon();

        ImageIcon fixedIcon = getScaledIcon(originalIcon, 200, 200);
        
        JLabel imageLabel = new JLabel(fixedIcon);

        Dimension imageSize = new Dimension(250, 250);
        imageLabel.setPreferredSize(imageSize);
        imageLabel.setMinimumSize(imageSize);
        imageLabel.setMaximumSize(imageSize);

        imageLabel.setHorizontalAlignment(JLabel.CENTER);
        imageLabel.setVerticalAlignment(JLabel.CENTER);

        imageLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel nameLabel = new JLabel(_case.getCaseName());
        nameLabel.setFont(new Font("SansSerif", Font.BOLD, 14));
        nameLabel.setForeground(Color.WHITE);
        nameLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        JButton openButton = new JButton("Open Case");
        openButton.setFont(new Font("SansSerif", Font.BOLD, 12));
        openButton.setForeground(Color.WHITE);
        openButton.setBackground(new Color(45, 45, 50));
        openButton.setFocusPainted(false);
        openButton.setBorder(BorderFactory.createEmptyBorder(10, 25, 10, 25));
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

    public ImageIcon getScaledIcon(ImageIcon srcIcon, int maxWidth, int maxHeight) {
    Image srcImg = srcIcon.getImage();
    int originalWidth = srcImg.getWidth(null);
    int originalHeight = srcImg.getHeight(null);

    double widthRatio = (double) maxWidth / originalWidth;
    double heightRatio = (double) maxHeight / originalHeight;
    double ratio = Math.min(widthRatio, heightRatio);

    int newWidth = (int) (originalWidth * ratio);
    int newHeight = (int) (originalHeight * ratio);

    Image scaledImg = srcImg.getScaledInstance(newWidth, newHeight, Image.SCALE_SMOOTH);
    return new ImageIcon(scaledImg);
    }
}
