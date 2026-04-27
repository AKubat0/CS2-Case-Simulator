package src;
import java.util.ArrayList;
import javax.swing.ImageIcon;

public class Case {
    
    private String caseName;
    private ImageIcon caseIcon;
    private ArrayList<CaseItem> items;
    
    public Case(String caseName, String caseIconPath) {
        this.caseName = caseName;
        this.caseIcon = new ImageIcon(caseIconPath);
        this.items = new ArrayList<>();
    }

    public String getCaseName() {
        return caseName;
    }

    public ImageIcon getCaseIcon() {
        return caseIcon;
    }

    public ArrayList<CaseItem> getItems() {
        return items;
    }

    public void addItem(CaseItem item) {
        items.add(item);
    }
    

}
