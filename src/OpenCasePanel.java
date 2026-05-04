package src;
import java.awt.*;
import java.util.List;
import javax.swing.*;

public class OpenCasePanel extends JPanel {

    private Navigator nav;
    JButton inventoryButton;

    public OpenCasePanel(List<Case> availableCases, Navigator nav) {
        this.nav = nav;
        setLayout(new BorderLayout());

        JPanel headerPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        headerPanel.setBackground(new Color(10, 9, 13));
        headerPanel.setBorder(BorderFactory.createEmptyBorder(10, 20, 0, 20));

        inventoryButton = createStyledButton("GO TO INVENTORY");
        headerPanel.add(inventoryButton);
        add(headerPanel, BorderLayout.NORTH);
        inventoryButton.addActionListener(e -> nav.showInventory());

        JPanel centeringWrapper = new JPanel(new GridBagLayout());
        centeringWrapper.setBackground(new Color(10, 9, 13));
        
        JPanel caseCardHolder = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 20));
        caseCardHolder.setBackground(new Color(10, 9, 13));

        for (Case c : availableCases) {
            CaseCard card = new CaseCard(c, e -> handleSelection(c));
            caseCardHolder.add(card);
        }

        centeringWrapper.add(caseCardHolder);
        add(centeringWrapper, BorderLayout.CENTER);
    }

    private void handleSelection(Case selectedCase) {
        System.out.println("User chose: " + selectedCase.getCaseName());
        nav.startCaseOpening(selectedCase);
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
}
