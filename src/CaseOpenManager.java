package src;
import java.util.ArrayList;
import java.util.Random;

public class CaseOpenManager{

    private Case currentCase;
    
    public void setCurrentCase(Case currentCase) {
        this.currentCase = currentCase;
    }

    public CaseItem openCase(Case caseToOpen) {
        this.currentCase = caseToOpen;
        return getRandomItemFromCase();
    }

    private CaseItem getRandomItemFromCase() {
        Random random = new Random();

        double sumOfDropRates = 0.0;
        for (ItemRarity rarity : ItemRarity.values()) {
            sumOfDropRates += rarity.getDropRate();
        }

        double randomValue = random.nextDouble() * sumOfDropRates;

        for (ItemRarity rarity : ItemRarity.values()) {
            randomValue -= rarity.getDropRate();
            if (randomValue <= 0) {
                return getRandomItemByRarity(rarity);
            }
        }
        return null;
    }

    private CaseItem getRandomItemByRarity(ItemRarity rarity){
        Random random = new Random();
        ArrayList<CaseItem> itemsOfRarity = new ArrayList<>();

        for (CaseItem item : currentCase.getItems()) {
            if (item.getRarity() == rarity) {
                itemsOfRarity.add(item);
            }
        }

        CaseItem randomItem = itemsOfRarity.get(random.nextInt(itemsOfRarity.size()));

        randomItem.setWear(random.nextFloat(0.00000000000000000000000000000000000001175f, 1.0f));
        randomItem.setPatternIndex(random.nextInt(1, 1000));
        int statTrakChance = random.nextInt(100);
        if (statTrakChance < 10) {
            randomItem.setStatTrak(true);
        } else {
            randomItem.setStatTrak(false);
        }
        return randomItem;
    }

    public static void main(String[] args) {
        CaseOpenManager manager = new CaseOpenManager();
        Case testCase = new Case("Dreams And Nightmares", "path/to/case/icon.png");
        
    }
    


}