package src;
import java.io.*;
import java.util.ArrayList;

public class Inventory {

    File inventoryFile = new File("inventory.csv");
    
    private ArrayList<CaseItem> items;

    public Inventory() {
        this.items = new ArrayList<>();

        if (!inventoryFile.exists()){
            try {
                inventoryFile.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            loadInventory();
        }
    }

    public void addItem(CaseItem item) {
        items.add(item);
    }

    public ArrayList<CaseItem> getItems() {
        return items;
    }

    public void saveInventory(){

        try(FileWriter fw = new FileWriter(inventoryFile, true)){
            for (CaseItem item : items) {
                fw.write(item.getName() + "," + item.getRarity() + "," + item.getIcon() + "," + item.getWear() + "," + item.getPatternIndex() + "," + item.isStatTrak() + System.lineSeparator());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void loadInventory(){

    }


}
