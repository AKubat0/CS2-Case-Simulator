package src;

import java.awt.*;
import java.net.URL;
import java.util.ArrayList;
import javax.swing.*;

public class Main implements Navigator {

    private ArrayList<Case> allCases = new ArrayList<>();
    private Inventory userInventory = new Inventory(); // Assuming you have an Inventory class

    static Case dreamsAndNightmares;
    static Case glove;
    static Case kilowatt;
    static Case operationBreakout;
    static Case recoil;

    static JFrame frame;
    private CardLayout cardLayout;
    private JPanel mainContainer;

    public Main() {

        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1920, 1080);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setLocationRelativeTo(null);
        frame.setTitle("CS2 Case Simulator");

        cardLayout = new CardLayout();
        mainContainer = new JPanel(cardLayout);
        mainContainer.setBackground(new Color(10, 9, 13));

        URL iconURL = Main.class.getResource("/SourceImages/main-icon.png");
        if (iconURL != null) {
            ImageIcon icon = new ImageIcon(iconURL);
            frame.setIconImage(icon.getImage());
        }

        initData();

        OpenCasePanel selectionPanel = new OpenCasePanel(allCases, this);
        mainContainer.add(selectionPanel, "SELECTION");

        frame.add(mainContainer);
        frame.setVisible(true);
    }

    @Override
    public void showInventory() {
        // We create a new panel each time to ensure it shows the latest items
        InventoryPanel invPanel = new InventoryPanel(userInventory, this);
        mainContainer.add(invPanel, "INVENTORY");
        cardLayout.show(mainContainer, "INVENTORY");
    }

    @Override
    public void showCaseSelection() {
        cardLayout.show(mainContainer, "SELECTION");
    }

    @Override
    public void startCaseOpening(Case selectedCase) {
        // Switch to animation screen
        CaseAnimationPanel animPanel = new CaseAnimationPanel(selectedCase, this);
        mainContainer.add(animPanel, "ANIMATION");
        cardLayout.show(mainContainer, "ANIMATION");
        
        // Trigger the spin
        animPanel.startSpin();
    }

    @Override
    public void showResult(CaseItem wonItem) {
        // Save item to inventory and show result
        userInventory.addItem(wonItem);
        
        CaseResultPanel resultPanel = new CaseResultPanel(wonItem, this);
        mainContainer.add(resultPanel, "RESULT");
        cardLayout.show(mainContainer, "RESULT");
    }

    private void initData(){
        dreamsAndNightmares = new Case("Dreams And Nightmares", "/SourceImages/Cases/DreamsAndNightmares/DreamsAndNightmaresCase.png");
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

        glove = new Case("Glove", "/SourceImages/Cases/Glove/GloveCase1.png");



        kilowatt = new Case("Kilowatt", "/SourceImages/Cases/Kilowatt/KilowattCase.png");



        operationBreakout = new Case("Operation Breakout", "/SourceImages/Cases/OperationBreakout/BreakoutCase.png");
        

        
        recoil = new Case("Recoil", "/SourceImages/Cases/RecoilCase/RecoilCase.png");

        allCases.add(dreamsAndNightmares);
        allCases.add(glove);
        allCases.add(kilowatt);
        allCases.add(operationBreakout);
        allCases.add(recoil);
    }

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {
            Main main = new Main();

        });


        
    }

}