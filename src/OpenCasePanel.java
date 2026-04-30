package src;
import java.awt.*;
import java.util.List;
import javax.swing.*;

public class OpenCasePanel extends JPanel {

    public OpenCasePanel(List<Case> availableCases) {
        setLayout(new BorderLayout());

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
        // Switch to opening animation screen...
    }
}
