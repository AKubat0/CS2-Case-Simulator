package src;
import java.io.*;
import java.util.ArrayList;

public class Inventory {

    File inventoryFile = new File("inventory.csv");
    
    private ArrayList<CaseItem> items;

    public Inventory() {
        this.items = new ArrayList<>();

        System.out.println("Inventory file exists: " + inventoryFile.exists() + " @ " + inventoryFile.getAbsolutePath());
        if (!inventoryFile.exists()){
            try {
                inventoryFile.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Loading inventory from file...");
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
                    System.out.println("[INVENTORY] Saving " + items.size() + " items to CSV");
                    for (CaseItem item : items) {
                        String iconPath = item.getIconPath() != null ? item.getIconPath() : "null";
                        pw.println(String.join("||", 
                            item.getName(), 
                            item.getRarity().toString(), 
                            iconPath,
                            String.valueOf(item.getWear()), 
                            String.valueOf(item.getPatternIndex()), 
                            String.valueOf(item.isStatTrak())
                        ));
                        System.out.println("[INVENTORY] Saved: " + item.getName() + " with icon path: " + iconPath);
                    }
                    System.out.println("[INVENTORY] Save complete!");
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
            int loadedCount = 0;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split("\\|\\|");
                if (parts.length == 6) {
                    try {
                        CaseItem item = new CaseItem(parts[0], ItemRarity.valueOf(parts[1]), parts[2]);
                        item.setWear(Float.parseFloat(parts[3]));
                        item.setPatternIndex(Integer.parseInt(parts[4]));
                        item.setStatTrak(Boolean.parseBoolean(parts[5]));
                        items.add(item);
                        loadedCount++;
                        System.out.println("[INVENTORY] Loaded item: " + parts[0]);
                    } catch (Exception e) {
                        System.err.println("Skipping corrupted line: " + line);
                        e.printStackTrace();
                    }
                } else {
                    System.out.println("[INVENTORY] Skipped line - wrong number of parts: " + parts.length + " (expected 6)");
                }
            }
            System.out.println("[INVENTORY] Successfully loaded " + loadedCount + " items from CSV");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
