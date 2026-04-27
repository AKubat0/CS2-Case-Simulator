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
        testCase.addItem(new CaseItem("SCAR-20 | Poultrygeist", ItemRarity.MIL_SPEC, "/SourceImages/Cases/DreamsAndNightmares/Scar20,Poultrygeist.png"));
        testCase.addItem(new CaseItem("MAG-7 | Foresight", ItemRarity.MIL_SPEC, "/SourceImages/Cases/DreamsAndNightmares/Scar20,Poultrygeist.png"));
        testCase.addItem(new CaseItem("Sawed-Off | Spirit Board", ItemRarity.MIL_SPEC, "/SourceImages/Cases/DreamsAndNightmares/Scar20,Poultrygeist.png"));
        testCase.addItem(new CaseItem("P2000 | Lifted Spirits", ItemRarity.MIL_SPEC, "/SourceImages/Cases/DreamsAndNightmares/Scar20,Poultrygeist.png"));
        testCase.addItem(new CaseItem("MAC-10 | Ensnared", ItemRarity.MIL_SPEC, "/SourceImages/Cases/DreamsAndNightmares/Scar20,Poultrygeist.png"));
        testCase.addItem(new CaseItem("MP5-SD | Necro Jr.", ItemRarity.MIL_SPEC, "/SourceImages/Cases/DreamsAndNightmares/Scar20,Poultrygeist.png"));
        testCase.addItem(new CaseItem("Five-SeveN | Scrawl", ItemRarity.MIL_SPEC, "/SourceImages/Cases/DreamsAndNightmares/Scar20,Poultrygeist.png"));
        testCase.addItem(new CaseItem("XM1014 | Zombie Offensive", ItemRarity.RESTRICTED, "/SourceImages/Cases/DreamsAndNightmares/Scar20,Poultrygeist.png"));
        testCase.addItem(new CaseItem("PP-Bizon | Space Cat", ItemRarity.RESTRICTED, "/SourceImages/Cases/DreamsAndNightmares/Scar20,Poultrygeist.png"));
        testCase.addItem(new CaseItem("G3SG1 | Dream Glade", ItemRarity.RESTRICTED, "/SourceImages/Cases/DreamsAndNightmares/Scar20,Poultrygeist.png"));
        testCase.addItem(new CaseItem("USP-S | Ticket to Hell", ItemRarity.RESTRICTED, "/SourceImages/Cases/DreamsAndNightmares/Scar20,Poultrygeist.png"));
        testCase.addItem(new CaseItem("M4A1-S | Night Terror", ItemRarity.RESTRICTED, "/SourceImages/Cases/DreamsAndNightmares/Scar20,Poultrygeist.png"));
        testCase.addItem(new CaseItem("FAMAS | Rapid Eye Movement", ItemRarity.CLASSIFIED, "/SourceImages/Cases/DreamsAndNightmares/Scar20,Poultrygeist.png"));
        testCase.addItem(new CaseItem("Dual Berettas | Melondrama", ItemRarity.CLASSIFIED, "/SourceImages/Cases/DreamsAndNightmares/Scar20,Poultrygeist.png"));
        testCase.addItem(new CaseItem("MP7 | Abyssal Apparition", ItemRarity.CLASSIFIED, "/SourceImages/Cases/DreamsAndNightmares/Scar20,Poultrygeist.png"));
        testCase.addItem(new CaseItem("MP9 | Starlight Protector", ItemRarity.COVERT, "/SourceImages/Cases/DreamsAndNightmares/Scar20,Poultrygeist.png"));
        testCase.addItem(new CaseItem("AK-47 | Nightwish", ItemRarity.COVERT, "/SourceImages/Cases/DreamsAndNightmares/Scar20,Poultrygeist.png"));
        testCase.addItem(new CaseItem("Shadow Daggers | Bright Water", ItemRarity.RARE_SPECIAL_ITEM, "/SourceImages/Cases/DreamsAndNightmares/Scar20,Poultrygeist.png"));
        testCase.addItem(new CaseItem("Shadow Daggers | Freehand", ItemRarity.RARE_SPECIAL_ITEM, "/SourceImages/Cases/DreamsAndNightmares/Scar20,Poultrygeist.png"));
        testCase.addItem(new CaseItem("Shadow Daggers | Autotronic", ItemRarity.RARE_SPECIAL_ITEM, "/SourceImages/Cases/DreamsAndNightmares/Scar20,Poultrygeist.png"));
        testCase.addItem(new CaseItem("Shadow Daggers | Black Laminate", ItemRarity.RARE_SPECIAL_ITEM, "/SourceImages/Cases/DreamsAndNightmares/Scar20,Poultrygeist.png"));
        testCase.addItem(new CaseItem("Shadow Daggers | Lore", ItemRarity.RARE_SPECIAL_ITEM, "/SourceImages/Cases/DreamsAndNightmares/Scar20,Poultrygeist.png"));
        testCase.addItem(new CaseItem("Shadow Daggers | Gamma Doppler", ItemRarity.RARE_SPECIAL_ITEM, "/SourceImages/Cases/DreamsAndNightmares/Scar20,Poultrygeist.png"));
        testCase.addItem(new CaseItem("Huntsman Knife | Bright Water", ItemRarity.RARE_SPECIAL_ITEM, "/SourceImages/Cases/DreamsAndNightmares/Scar20,Poultrygeist.png"));
        testCase.addItem(new CaseItem("Huntsman Knife | Black Laminate", ItemRarity.RARE_SPECIAL_ITEM, "/SourceImages/Cases/DreamsAndNightmares/Scar20,Poultrygeist.png"));
        testCase.addItem(new CaseItem("Huntsman Knife | Freehand", ItemRarity.RARE_SPECIAL_ITEM, "/SourceImages/Cases/DreamsAndNightmares/Scar20,Poultrygeist.png"));
        testCase.addItem(new CaseItem("Huntsman Knife | Lore", ItemRarity.RARE_SPECIAL_ITEM, "/SourceImages/Cases/DreamsAndNightmares/Scar20,Poultrygeist.png"));
        testCase.addItem(new CaseItem("Huntsman Knife | Autotronic", ItemRarity.RARE_SPECIAL_ITEM, "/SourceImages/Cases/DreamsAndNightmares/Scar20,Poultrygeist.png"));
        testCase.addItem(new CaseItem("Huntsman Knife | Gamma Doppler", ItemRarity.RARE_SPECIAL_ITEM, "/SourceImages/Cases/DreamsAndNightmares/Scar20,Poultrygeist.png"));
        testCase.addItem(new CaseItem("Falchion Knife | Bright Water", ItemRarity.RARE_SPECIAL_ITEM, "/SourceImages/Cases/DreamsAndNightmares/Scar20,Poultrygeist.png"));
        testCase.addItem(new CaseItem("Falchion Knife | Black Laminate", ItemRarity.RARE_SPECIAL_ITEM, "/SourceImages/Cases/DreamsAndNightmares/Scar20,Poultrygeist.png"));
        testCase.addItem(new CaseItem("Falchion Knife | Freehand", ItemRarity.RARE_SPECIAL_ITEM, "/SourceImages/Cases/DreamsAndNightmares/Scar20,Poultrygeist.png"));
        testCase.addItem(new CaseItem("Falchion Knife | Lore", ItemRarity.RARE_SPECIAL_ITEM, "/SourceImages/Cases/DreamsAndNightmares/Scar20,Poultrygeist.png"));
        testCase.addItem(new CaseItem("Falchion Knife | Autotronic", ItemRarity.RARE_SPECIAL_ITEM, "/SourceImages/Cases/DreamsAndNightmares/Scar20,Poultrygeist.png"));
        testCase.addItem(new CaseItem("Falchion Knife | Gamma Doppler", ItemRarity.RARE_SPECIAL_ITEM, "/SourceImages/Cases/DreamsAndNightmares/Scar20,Poultrygeist.png"));
        testCase.addItem(new CaseItem("Butterfly Knife | Gamma Doppler", ItemRarity.RARE_SPECIAL_ITEM, "/SourceImages/Cases/DreamsAndNightmares/Scar20,Poultrygeist.png"));
        testCase.addItem(new CaseItem("Butterfly Knife | Autotronic", ItemRarity.RARE_SPECIAL_ITEM, "/SourceImages/Cases/DreamsAndNightmares/Scar20,Poultrygeist.png"));
        testCase.addItem(new CaseItem("Butterfly Knife | Bright Water", ItemRarity.RARE_SPECIAL_ITEM, "/SourceImages/Cases/DreamsAndNightmares/Scar20,Poultrygeist.png"));
        testCase.addItem(new CaseItem("Butterfly Knife | Freehand", ItemRarity.RARE_SPECIAL_ITEM, "/SourceImages/Cases/DreamsAndNightmares/Scar20,Poultrygeist.png"));
        testCase.addItem(new CaseItem("Butterfly Knife | Lore", ItemRarity.RARE_SPECIAL_ITEM, "/SourceImages/Cases/DreamsAndNightmares/Scar20,Poultrygeist.png"));
        testCase.addItem(new CaseItem("Butterfly Knife | Black Laminate", ItemRarity.RARE_SPECIAL_ITEM, "/SourceImages/Cases/DreamsAndNightmares/Scar20,Poultrygeist.png"));
        testCase.addItem(new CaseItem("Bowie Knife | Black Laminate", ItemRarity.RARE_SPECIAL_ITEM, "/SourceImages/Cases/DreamsAndNightmares/Scar20,Poultrygeist.png"));
        testCase.addItem(new CaseItem("Bowie Knife | Bright Water", ItemRarity.RARE_SPECIAL_ITEM, "/SourceImages/Cases/DreamsAndNightmares/Scar20,Poultrygeist.png"));
        testCase.addItem(new CaseItem("Bowie Knife | Freehand", ItemRarity.RARE_SPECIAL_ITEM, "/SourceImages/Cases/DreamsAndNightmares/Scar20,Poultrygeist.png"));
        testCase.addItem(new CaseItem("Bowie Knife | Autotronic", ItemRarity.RARE_SPECIAL_ITEM, "/SourceImages/Cases/DreamsAndNightmares/Scar20,Poultrygeist.png"));
        testCase.addItem(new CaseItem("Bowie Knife | Lore", ItemRarity.RARE_SPECIAL_ITEM, "/SourceImages/Cases/DreamsAndNightmares/Scar20,Poultrygeist.png"));
        testCase.addItem(new CaseItem("Bowie Knife | Gamma Doppler", ItemRarity.RARE_SPECIAL_ITEM, "/SourceImages/Cases/DreamsAndNightmares/Scar20,Poultrygeist.png"));

        /*
        CaseItem openedItem;
        int counter = 0;
        while (true){
            openedItem = manager.openCase(testCase);
            counter++;
            if (openedItem.getRarity() == ItemRarity.RARE_SPECIAL_ITEM){
                System.out.println("You opened: " + openedItem.getName() + " | Rarity: " + openedItem.getRarity() + " | Wear: " + openedItem.getWear() + " | Pattern Index: " + openedItem.getPatternIndex() + " | StatTrak: " + openedItem.isStatTrak());
                System.out.println("It took you " + counter + " cases to get a rare special item.");
                break;
            }
        }
        */

        int milSpecCount = 0;
        int restrictedCount = 0;
        int classifiedCount = 0;
        int covertCount = 0;
        int rareSpecialItemCount = 0;

        for (int i = 0; i < 1000000; i++){
            CaseItem openedItem = manager.openCase(testCase);
            switch (openedItem.getRarity()) {
                case MIL_SPEC -> milSpecCount++;
                case RESTRICTED -> restrictedCount++;
                case CLASSIFIED -> classifiedCount++;
                case COVERT -> covertCount++;
                case RARE_SPECIAL_ITEM -> rareSpecialItemCount++;
            }
        }
        System.out.println("After opening 100000 cases:");
        System.out.println("Mil-Spec: " + milSpecCount);
        System.out.println("Restricted: " + restrictedCount);
        System.out.println("Classified: " + classifiedCount);
        System.out.println("Covert: " + covertCount);
        System.out.println("Rare Special Item: " + rareSpecialItemCount);

}
    


}