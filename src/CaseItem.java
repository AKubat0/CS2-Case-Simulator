package src;
import javax.swing.ImageIcon;

public class CaseItem {
    
    private String name;
    private ItemRarity rarity;
    private ImageIcon icon;
    private float wear;
    private int patternIndex;
    private boolean isStatTrak;
    


    //wear and pattern assigned later
    public CaseItem(String name, ItemRarity rarity, String iconPath) {
        this.name = name;
        this.rarity = rarity;
        this.icon = new ImageIcon(iconPath);
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
