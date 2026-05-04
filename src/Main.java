package src;
import java.awt.*;
import java.net.URL;
import java.util.ArrayList;
import javax.swing.*;

public class Main{
    private ArrayList<Case> allCases = new ArrayList();
    static Case dreamsAndNightmares;
    static Case glove;
    static Case kilowatt;
    static Case operationBreakout;
    static Case recoil;
    static JFrame frame;

    public Main(){
        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1920, 1080);
        frame.setResizable(true);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setLocationRelativeTo(null);
        frame.setTitle("CS2 Case Simulator");
        frame.getContentPane().setBackground(new Color(10, 9, 13));

        URL iconURL = Main.class.getResource("/SourceImages/main-icon.png");
        if (iconURL != null) {
            ImageIcon icon = new ImageIcon(iconURL);
            frame.setIconImage(icon.getImage());
        } else {
            System.err.println("Icon image not found at: " + iconURL);
        }

        initData();

        OpenCasePanel openCasePanel = new OpenCasePanel(allCases);
        frame.add(openCasePanel);
        // CaseOpenManager caseOpenManager = new CaseOpenManager();
        // CaseItem wonItem = caseOpenManager.openCase(dreamsAndNightmares);
        // System.out.println("is it stattrak? " + wonItem.isStatTrak());
        // CaseResultPanel resultPanel = new CaseResultPanel(wonItem);
        // frame.add(resultPanel);


        frame.setVisible(true);
    }

    private void initData(){
        dreamsAndNightmares = new Case("Dreams And Nightmares", Main.class.getResource("/SourceImages/Cases/DreamsAndNightmares/DreamsAndNightmaresCase.png"));
        dreamsAndNightmares.addItem(new CaseItem("SCAR-20 | Poultrygeist", ItemRarity.MIL_SPEC, "/SourceImages/Cases/DreamsAndNightmares/Scar20,Poultrygeist.png"));
        dreamsAndNightmares.addItem(new CaseItem("MAG-7 | Foresight", ItemRarity.MIL_SPEC, "/SourceImages/Cases/DreamsAndNightmares/Mag7,Foresight.png"));
        dreamsAndNightmares.addItem(new CaseItem("Sawed-Off | Spirit Board", ItemRarity.MIL_SPEC, "/SourceImages/Cases/DreamsAndNightmares/SawedOff,SpiritBoard.png"));
        dreamsAndNightmares.addItem(new CaseItem("P2000 | Lifted Spirits", ItemRarity.MIL_SPEC, "/SourceImages/Cases/DreamsAndNightmares/P2000,LiftedSpirits.png"));
        dreamsAndNightmares.addItem(new CaseItem("MAC-10 | Ensnared", ItemRarity.MIL_SPEC, "/SourceImages/Cases/DreamsAndNightmares/Mac10,Ensnared.png"));
        dreamsAndNightmares.addItem(new CaseItem("MP5-SD | Necro Jr.", ItemRarity.MIL_SPEC, "/SourceImages/Cases/DreamsAndNightmares/Mp5Sd,NecroJr.png"));
        dreamsAndNightmares.addItem(new CaseItem("Five-SeveN | Scrawl", ItemRarity.MIL_SPEC, "/SourceImages/Cases/DreamsAndNightmares/FiveSeven,Scrawl.png"));
        dreamsAndNightmares.addItem(new CaseItem("XM1014 | Zombie Offensive", ItemRarity.RESTRICTED, "/SourceImages/Cases/DreamsAndNightmares/XM1014,ZombieOffensive.png"));
        dreamsAndNightmares.addItem(new CaseItem("PP-Bizon | Space Cat", ItemRarity.RESTRICTED, "/SourceImages/Cases/DreamsAndNightmares/PPBizon,SpaceCat.png"));
        dreamsAndNightmares.addItem(new CaseItem("G3SG1 | Dream Glade", ItemRarity.RESTRICTED, "/SourceImages/Cases/DreamsAndNightmares/G3SG1,DreamGlade.png"));
        dreamsAndNightmares.addItem(new CaseItem("USP-S | Ticket to Hell", ItemRarity.RESTRICTED, "/SourceImages/Cases/DreamsAndNightmares/USPS,TicketToHell.png"));
        dreamsAndNightmares.addItem(new CaseItem("M4A1-S | Night Terror", ItemRarity.RESTRICTED, "/SourceImages/Cases/DreamsAndNightmares/M4A1,NightTerror.png"));
        dreamsAndNightmares.addItem(new CaseItem("FAMAS | Rapid Eye Movement", ItemRarity.CLASSIFIED, "/SourceImages/Cases/DreamsAndNightmares/Famas,RapidEyeMovement.png"));
        dreamsAndNightmares.addItem(new CaseItem("Dual Berettas | Melondrama", ItemRarity.CLASSIFIED, "/SourceImages/Cases/DreamsAndNightmares/DualBerettas,Melondrama.png"));
        dreamsAndNightmares.addItem(new CaseItem("MP7 | Abyssal Apparition", ItemRarity.CLASSIFIED, "/SourceImages/Cases/DreamsAndNightmares/MP7,AbyssalApparition.png"));
        dreamsAndNightmares.addItem(new CaseItem("MP9 | Starlight Protector", ItemRarity.COVERT, "/SourceImages/Cases/DreamsAndNightmares/MP9,StarlightProtector.png"));
        dreamsAndNightmares.addItem(new CaseItem("AK-47 | Nightwish", ItemRarity.COVERT, "/SourceImages/Cases/DreamsAndNightmares/AK47,Nightwish.png"));
        dreamsAndNightmares.addItem(new CaseItem("Shadow Daggers | Bright Water", ItemRarity.RARE_SPECIAL_ITEM, "/SourceImages/Cases/DreamsAndNightmares/ShadowDaggers,BrightWater.png"));
        dreamsAndNightmares.addItem(new CaseItem("Shadow Daggers | Freehand", ItemRarity.RARE_SPECIAL_ITEM, "/SourceImages/Cases/DreamsAndNightmares/ShadowDaggers,Freehand.png"));
        dreamsAndNightmares.addItem(new CaseItem("Shadow Daggers | Autotronic", ItemRarity.RARE_SPECIAL_ITEM, "/SourceImages/Cases/DreamsAndNightmares/ShadowDaggers,Autotronic.png"));
        dreamsAndNightmares.addItem(new CaseItem("Shadow Daggers | Black Laminate", ItemRarity.RARE_SPECIAL_ITEM, "/SourceImages/Cases/DreamsAndNightmares/ShadowDaggers,BlackLaminate.png"));
        dreamsAndNightmares.addItem(new CaseItem("Shadow Daggers | Lore", ItemRarity.RARE_SPECIAL_ITEM, "/SourceImages/Cases/DreamsAndNightmares/ShadowDaggers,Lore.png"));
        dreamsAndNightmares.addItem(new CaseItem("Shadow Daggers | Gamma Doppler", ItemRarity.RARE_SPECIAL_ITEM, "/SourceImages/Cases/DreamsAndNightmares/ShadowDaggers,GammaDoppler.png"));
        dreamsAndNightmares.addItem(new CaseItem("Huntsman Knife | Bright Water", ItemRarity.RARE_SPECIAL_ITEM, "/SourceImages/Cases/DreamsAndNightmares/HuntsmanKnife,BrightWater.png"));
        dreamsAndNightmares.addItem(new CaseItem("Huntsman Knife | Black Laminate", ItemRarity.RARE_SPECIAL_ITEM, "/SourceImages/Cases/DreamsAndNightmares/HuntsmanKnife,BlackLaminate.png"));
        dreamsAndNightmares.addItem(new CaseItem("Huntsman Knife | Freehand", ItemRarity.RARE_SPECIAL_ITEM, "/SourceImages/Cases/DreamsAndNightmares/HuntsmanKnife,Freehand.png"));
        dreamsAndNightmares.addItem(new CaseItem("Huntsman Knife | Lore", ItemRarity.RARE_SPECIAL_ITEM, "/SourceImages/Cases/DreamsAndNightmares/HuntsmanKnife,Lore.png"));
        dreamsAndNightmares.addItem(new CaseItem("Huntsman Knife | Autotronic", ItemRarity.RARE_SPECIAL_ITEM, "/SourceImages/Cases/DreamsAndNightmares/HuntsmanKnife,Autotronic.png"));
        dreamsAndNightmares.addItem(new CaseItem("Huntsman Knife | Gamma Doppler", ItemRarity.RARE_SPECIAL_ITEM, "/SourceImages/Cases/DreamsAndNightmares/HuntsmanKnife,GammaDoppler.png"));
        dreamsAndNightmares.addItem(new CaseItem("Falchion Knife | Bright Water", ItemRarity.RARE_SPECIAL_ITEM, "/SourceImages/Cases/DreamsAndNightmares/FalchionKnife,BrightWater.png"));
        dreamsAndNightmares.addItem(new CaseItem("Falchion Knife | Black Laminate", ItemRarity.RARE_SPECIAL_ITEM, "/SourceImages/Cases/DreamsAndNightmares/FalchionKnife,BlackLaminate.png"));
        dreamsAndNightmares.addItem(new CaseItem("Falchion Knife | Freehand", ItemRarity.RARE_SPECIAL_ITEM, "/SourceImages/Cases/DreamsAndNightmares/FalchionKnife,Freehand.png"));
        dreamsAndNightmares.addItem(new CaseItem("Falchion Knife | Lore", ItemRarity.RARE_SPECIAL_ITEM, "/SourceImages/Cases/DreamsAndNightmares/FalchionKnife,Lore.png"));
        dreamsAndNightmares.addItem(new CaseItem("Falchion Knife | Autotronic", ItemRarity.RARE_SPECIAL_ITEM, "/SourceImages/Cases/DreamsAndNightmares/FalchionKnife,Autotronic.png"));
        dreamsAndNightmares.addItem(new CaseItem("Falchion Knife | Gamma Doppler", ItemRarity.RARE_SPECIAL_ITEM, "/SourceImages/Cases/DreamsAndNightmares/FalchionKnife,GammaDoppler.png"));
        dreamsAndNightmares.addItem(new CaseItem("Butterfly Knife | Gamma Doppler", ItemRarity.RARE_SPECIAL_ITEM, "/SourceImages/Cases/DreamsAndNightmares/ButterflyKnife,GammaDoppler.png"));
        dreamsAndNightmares.addItem(new CaseItem("Butterfly Knife | Autotronic", ItemRarity.RARE_SPECIAL_ITEM, "/SourceImages/Cases/DreamsAndNightmares/ButterflyKnife,Autotronic.png"));
        dreamsAndNightmares.addItem(new CaseItem("Butterfly Knife | Bright Water", ItemRarity.RARE_SPECIAL_ITEM, "/SourceImages/Cases/DreamsAndNightmares/ButterflyKnife,BrightWater.png"));
        dreamsAndNightmares.addItem(new CaseItem("Butterfly Knife | Freehand", ItemRarity.RARE_SPECIAL_ITEM, "/SourceImages/Cases/DreamsAndNightmares/ButterflyKnife,Freehand.png"));
        dreamsAndNightmares.addItem(new CaseItem("Butterfly Knife | Lore", ItemRarity.RARE_SPECIAL_ITEM, "/SourceImages/Cases/DreamsAndNightmares/ButterflyKnife,Lore.png"));
        dreamsAndNightmares.addItem(new CaseItem("Butterfly Knife | Black Laminate", ItemRarity.RARE_SPECIAL_ITEM, "/SourceImages/Cases/DreamsAndNightmares/ButterflyKnife,BlackLaminate.png"));
        dreamsAndNightmares.addItem(new CaseItem("Bowie Knife | Black Laminate", ItemRarity.RARE_SPECIAL_ITEM, "/SourceImages/Cases/DreamsAndNightmares/BowieKnife,BlackLaminate.png"));
        dreamsAndNightmares.addItem(new CaseItem("Bowie Knife | Bright Water", ItemRarity.RARE_SPECIAL_ITEM, "/SourceImages/Cases/DreamsAndNightmares/BowieKnife,BrightWater.png"));
        dreamsAndNightmares.addItem(new CaseItem("Bowie Knife | Freehand", ItemRarity.RARE_SPECIAL_ITEM, "/SourceImages/Cases/DreamsAndNightmares/BowieKnife,Freehand.png"));
        dreamsAndNightmares.addItem(new CaseItem("Bowie Knife | Autotronic", ItemRarity.RARE_SPECIAL_ITEM, "/SourceImages/Cases/DreamsAndNightmares/BowieKnife,Autotronic.png"));
        dreamsAndNightmares.addItem(new CaseItem("Bowie Knife | Lore", ItemRarity.RARE_SPECIAL_ITEM, "/SourceImages/Cases/DreamsAndNightmares/BowieKnife,Lore.png"));
        dreamsAndNightmares.addItem(new CaseItem("Bowie Knife | Gamma Doppler", ItemRarity.RARE_SPECIAL_ITEM, "/SourceImages/Cases/DreamsAndNightmares/BowieKnife,GammaDoppler.png"));

        glove = new Case("Glove", Main.class.getResource("/SourceImages/Cases/Glove/GloveCase1.png"));



        kilowatt = new Case("Kilowatt", Main.class.getResource("/SourceImages/Cases/Kilowatt/KilowattCase.png"));



        operationBreakout = new Case("Operation Breakout", Main.class.getResource("/SourceImages/Cases/OperationBreakout/BreakoutCase.png"));

        

        recoil = new Case("Recoil", Main.class.getResource("/SourceImages/Cases/RecoilCase/RecoilCase.png"));

        allCases.add(dreamsAndNightmares);
        allCases.add(glove);
        allCases.add(kilowatt);
        allCases.add(operationBreakout);
        allCases.add(recoil);
    }

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {
            Main main = new Main();

            // CaseAnimationPanel animPanel = new CaseAnimationPanel(dreamsAndNightmares);
            // frame.add(animPanel);

            // Timer startDelay = new Timer(1000, e -> animPanel.startSpin());
            // startDelay.setRepeats(false);
            // startDelay.start();

            // Inventory inventory = new Inventory();
            // CaseOpenManager caseOpenManager = new CaseOpenManager();

            // for (int i = 0; i < 20; i++) {
            //     CaseItem wonItem = caseOpenManager.openCase(dreamsAndNightmares);
            //     inventory.addItem(wonItem);
            //     System.out.println("You won: " + wonItem.getName() + " | Rarity: " + wonItem.getRarity() + " | StatTrak: " + wonItem.isStatTrak());
            // }

            // InventoryPanel inventoryPanel = new InventoryPanel(inventory);
            // frame.add(inventoryPanel);

        });


        
    }

}