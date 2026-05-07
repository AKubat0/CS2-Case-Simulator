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

    private final Object fileLock = new Object();

    public void saveInventory() {
        new Thread(() -> {

            synchronized (fileLock) {
                try (PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(inventoryFile, false)))) {
                    for (CaseItem item : items) {
                        pw.println(String.join("|", 
                            item.getName(), 
                            item.getRarity().toString(), 
                            item.getIcon().toString(), //Fix later
                            String.valueOf(item.getWear()), 
                            String.valueOf(item.getPatternIndex()), 
                            String.valueOf(item.isStatTrak())
                        ));
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    public void loadInventory() {
        items.clear();
        try (BufferedReader br = new BufferedReader(new FileReader(inventoryFile))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split("\\|");
                if (parts.length == 6) {
                    try {
                        CaseItem item = new CaseItem(parts[0], ItemRarity.valueOf(parts[1]), parts[2]);
                        item.setWear(Float.parseFloat(parts[3]));
                        item.setPatternIndex(Integer.parseInt(parts[4]));
                        item.setStatTrak(Boolean.parseBoolean(parts[5]));
                        items.add(item);
                    } catch (Exception e) {
                        System.err.println("Skipping corrupted line: " + line);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
