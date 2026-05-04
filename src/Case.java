package src;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import javax.swing.ImageIcon;

public class Case {
    
    private String caseName;
    private ImageIcon caseIcon;
    private ArrayList<CaseItem> items;
    
    public Case(String caseName, java.net.URL caseIconPath) {
        this.caseName = caseName;
        this.caseIcon = caseIconPath != null ? new ImageIcon(caseIconPath) : null;
        this.items = new ArrayList<>();
    }

    public Case(String caseName, String caseIconPath) {
        this(caseName, loadResource(caseIconPath));
    }

    private static URL loadResource(String path) {
        URL url = Case.class.getResource(path);
        if (url == null) {
            try {
                File file = new File(System.getProperty("user.dir") + path);
                if (file.exists()) {
                    url = file.toURI().toURL();
                }
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
        }
        return url;
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
