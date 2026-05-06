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

    public CaseItem customOpenCase(Case caseToOpen){
        this.currentCase = caseToOpen;
        CaseItem item = (AdminPanel.AdminSettings.desiredRarityEnabled) ? getRandomItemByRarity(AdminPanel.AdminSettings.getDesiredRarity()) : getRandomItemFromCase();
        item.setWear((AdminPanel.AdminSettings.desiredWearEnabled) ? AdminPanel.AdminSettings.getDesiredWear() : getRandomWear());
        item.setPatternIndex((AdminPanel.AdminSettings.desiredPatternEnabled) ? AdminPanel.AdminSettings.getDesiredPattern() : getRandomPatternIndex());
        item.setStatTrak((AdminPanel.AdminSettings.forceStatTrakEnabled) ? AdminPanel.AdminSettings.getForceStatTrak() : getRandomStatTrak());
        return item;
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
                CaseItem item = getRandomItemByRarity(rarity);
                item.setWear((getRandomWear()));
                item.setPatternIndex(getRandomPatternIndex());
                item.setStatTrak(getRandomStatTrak());
                return item;
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
        return randomItem;
    }

    private float getRandomWear() {
        Random random = new Random();
        int maxInt = 2147483647;
        int randomInt = random.nextInt(0, maxInt);

        return (float)randomInt / maxInt;
    }

    private int getRandomPatternIndex() {
        Random random = new Random();
        return random.nextInt(1, 1000);
    }

    private boolean getRandomStatTrak() {
        Random random = new Random();
        int statTrakChance = random.nextInt(100);
        return statTrakChance < 10;
    }


    public static void main(String[] args) {
       
    }
}