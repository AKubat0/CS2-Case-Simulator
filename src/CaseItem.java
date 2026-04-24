package src;
import java.awt.Image;

public class CaseItem {
    
    private String name;
    private ItemRarity rarity;
    private float wear;
    private Image icon;

    public CaseItem(String name, ItemRarity rarity, float wear, Image icon) {
        this.name = name;
        this.rarity = rarity;
        this.wear = wear;
        this.icon = icon;
    }
    
}
