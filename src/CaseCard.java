package src;

import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.geom.RoundRectangle2D;
import javax.swing.*;

public class CaseCard extends JPanel {
    private static final int CORNER_RADIUS = 24;

    public CaseCard(Case _case, ActionListener openAction) {

        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setOpaque(false);
        setBorder(BorderFactory.createEmptyBorder(12, 12, 12, 12));
        setBackground(new Color(18, 19, 22));

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

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        int width = getWidth();
        int height = getHeight();
        RoundRectangle2D rounded = new RoundRectangle2D.Float(0, 0, width, height, CORNER_RADIUS, CORNER_RADIUS);

        g2.setColor(getBackground());
        g2.fill(rounded);

        g2.setColor(new Color(255, 255, 255, 40));
        g2.setStroke(new BasicStroke(1.5f));
        g2.draw(rounded);

        g2.dispose();
        super.paintComponent(g);
    }

    private ImageIcon getScaledIcon(ImageIcon srcIcon, int maxWidth, int maxHeight) {
        return ImageUtils.getScaledIcon(srcIcon, maxWidth, maxHeight, false);
    }
}
