package src;
import java.util.ArrayList;

public class Inventory {
    
    private ArrayList<CaseItem> items;

    public Inventory() {
        this.items = new ArrayList<>();
    }

    public void addItem(CaseItem item) {
        items.add(item);
    }

    public ArrayList<CaseItem> getItems() {
        return items;
    }
}
