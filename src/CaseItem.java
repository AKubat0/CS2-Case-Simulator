package src;
import javax.swing.ImageIcon;

public class CaseItem {
    
    private String name;
    private ItemRarity rarity;
    private ImageIcon icon;
    private float wear;
    private int patternIndex;
    private boolean isStatTrak;
    

    public CaseItem(String name, ItemRarity rarity, String iconPath) {
    this.name = name;
    this.rarity = rarity;

    java.net.URL imgURL = getClass().getResource(iconPath);

    if (imgURL != null) {
        this.icon = new ImageIcon(imgURL);
        if (this.icon.getImageLoadStatus() != java.awt.MediaTracker.COMPLETE) {
            System.err.println("[ERROR] Corrupted image file: " + name + " @ " + iconPath);
        }
    } 
    else {
        System.err.println("[MISSING] Resource not found for: " + name + " @ " + iconPath);
    }
}
    
    public String getName() {
        return name;
    }

    public ItemRarity getRarity() {
        return rarity;
    }

    public ImageIcon getIcon() {
        return icon;
    }

    public float getWear() {
        return wear;
    }

    public void setWear(float wear) {
        this.wear = wear;
    }

    public int getPatternIndex() {
        return patternIndex;
    }

    public void setPatternIndex(int patternIndex) {
        this.patternIndex = patternIndex;
    }

    public boolean isStatTrak() {
        return isStatTrak;
    }

    public void setStatTrak(boolean isStatTrak) {
        this.isStatTrak = isStatTrak;
    }
    
}
