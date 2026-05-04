package src;

import java.awt.*;
import java.net.URL;
import java.util.ArrayList;
import javax.swing.*;

public class Main implements Navigator {

    private ArrayList<Case> allCases = new ArrayList<>();
    private Inventory userInventory = new Inventory();

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
        CaseAnimationPanel animPanel = new CaseAnimationPanel(selectedCase, this);
        mainContainer.add(animPanel, "ANIMATION");
        cardLayout.show(mainContainer, "ANIMATION");

        animPanel.startSpin();
    }

    @Override
    public void showResult(CaseItem wonItem) {
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
        glove.addItem(new CaseItem("CZ75-Auto | Polymer", ItemRarity.MIL_SPEC, "/SourceImages/Cases/Glove/Cz75-Auto,Polymer.png"));
        glove.addItem(new CaseItem("MAG-7 | Sonar", ItemRarity.MIL_SPEC, "/SourceImages/Cases/Glove/Mag-7,Sonar.png"));
        glove.addItem(new CaseItem("MP9 | Sand Scale", ItemRarity.MIL_SPEC, "/SourceImages/Cases/Glove/MP9,SandScale.png"));
        glove.addItem(new CaseItem("Galil AR | Black Sand", ItemRarity.MIL_SPEC, "/SourceImages/Cases/Glove/GalilAR,BlackSand.png"));
        glove.addItem(new CaseItem("P2000 | Turf", ItemRarity.MIL_SPEC, "/SourceImages/Cases/Glove/P2000,Turf.png"));
        glove.addItem(new CaseItem("Glock-18 | Ironwork", ItemRarity.MIL_SPEC, "/SourceImages/Cases/Glove/Glock18,Ironwork.png"));
        glove.addItem(new CaseItem("MP7 | Cirrus", ItemRarity.MIL_SPEC, "/SourceImages/Cases/Glove/MP7,Cirrus.png"));
        glove.addItem(new CaseItem("Nova | Gila", ItemRarity.RESTRICTED, "/SourceImages/Cases/Glove/Nova,Gila.png"));
        glove.addItem(new CaseItem("G3SG1 | Stinger", ItemRarity.RESTRICTED, "/SourceImages/Cases/Glove/G3SG1,Stinger.png"));
        glove.addItem(new CaseItem("Dual Berettas | Royal Consorts", ItemRarity.RESTRICTED, "/SourceImages/Cases/Glove/DualBerettas,RoyalConsorts.png"));
        glove.addItem(new CaseItem("USP-S | Cyrex", ItemRarity.RESTRICTED, "/SourceImages/Cases/Glove/USPS,Cyrex.png"));
        glove.addItem(new CaseItem("M4A1-S | Flashback", ItemRarity.RESTRICTED, "/SourceImages/Cases/Glove/M4A1S,Flashback.png"));
        glove.addItem(new CaseItem("P90 | Shallow Grave", ItemRarity.CLASSIFIED, "/SourceImages/Cases/Glove/P90,ShallowGrave.png"));
        glove.addItem(new CaseItem("Sawed-Off | Wasteland Princess", ItemRarity.CLASSIFIED, "/SourceImages/Cases/Glove/Sawed-Off,WastelandPrincess.png"));
        glove.addItem(new CaseItem("FAMAS | Mecha Industries", ItemRarity.CLASSIFIED, "/SourceImages/Cases/Glove/FAMAS,MechaIndustries.png"));
        glove.addItem(new CaseItem("SSG 08 | Dragonfire", ItemRarity.COVERT, "/SourceImages/Cases/Glove/SSG08,Dragonfire.png"));
        glove.addItem(new CaseItem("M4A4 | Buzz Kill", ItemRarity.COVERT, "/SourceImages/Cases/Glove/M4A4,BuzzKill.png"));
        glove.addItem(new CaseItem("Sport Gloves | Pandora's Box", ItemRarity.RARE_SPECIAL_ITEM, "/SourceImages/Cases/Glove/SportGloves,PandorasBox.png"));
        glove.addItem(new CaseItem("Sport Gloves | Hedge Maze", ItemRarity.RARE_SPECIAL_ITEM, "/SourceImages/Cases/Glove/SportGloves,HedgeMaze.png"));     
        glove.addItem(new CaseItem("Sport Gloves | Arid", ItemRarity.RARE_SPECIAL_ITEM, "/SourceImages/Cases/Glove/SportGloves,Arid.png"));
        glove.addItem(new CaseItem("Sport Gloves | Superconductor", ItemRarity.RARE_SPECIAL_ITEM, "/SourceImages/Cases/Glove/SportGloves,Superconductor.png"));
        glove.addItem(new CaseItem("Specialist Gloves | Forest DDPAT", ItemRarity.RARE_SPECIAL_ITEM, "/SourceImages/Cases/Glove/SpecialistGloves,ForestDDPAT.png"));
        glove.addItem(new CaseItem("Specialist Gloves | Crimson Kimono", ItemRarity.RARE_SPECIAL_ITEM, "/SourceImages/Cases/Glove/SpecialistGloves,CrimsonKimono.png"));
        glove.addItem(new CaseItem("Specialist Gloves | Foundation", ItemRarity.RARE_SPECIAL_ITEM, "/SourceImages/Cases/Glove/SpecialistGloves,Foundatiton.png"));
        glove.addItem(new CaseItem("Specialist Gloves | Emerald Web", ItemRarity.RARE_SPECIAL_ITEM, "/SourceImages/Cases/Glove/SpecialistGloves,EmeraldWeb.png"));
        glove.addItem(new CaseItem("Moto Gloves | Eclipse", ItemRarity.RARE_SPECIAL_ITEM, "/SourceImages/Cases/Glove/MotoGloves,Eclipse.png"));
        glove.addItem(new CaseItem("Moto Gloves | Boom!", ItemRarity.RARE_SPECIAL_ITEM, "/SourceImages/Cases/Glove/MotoGloves,Boom.png"));
        glove.addItem(new CaseItem("Moto Gloves | Spearmint", ItemRarity.RARE_SPECIAL_ITEM, "/SourceImages/Cases/Glove/MotoGloves,Spearmint.png"));
        glove.addItem(new CaseItem("Moto Gloves | Cool Mint", ItemRarity.RARE_SPECIAL_ITEM, "/SourceImages/Cases/Glove/MotoGloves,CoolMint.png"));
        glove.addItem(new CaseItem("Hand Wraps | Spruce DDPAT", ItemRarity.RARE_SPECIAL_ITEM, "/SourceImages/Cases/Glove/HandWraps,SpruceDDPAT.png"));
        glove.addItem(new CaseItem("Hand Wraps | Badlands", ItemRarity.RARE_SPECIAL_ITEM, "/SourceImages/Cases/Glove/HandWraps,Badlands.png"));
        glove.addItem(new CaseItem("Hand Wraps | Leather", ItemRarity.RARE_SPECIAL_ITEM, "/SourceImages/Cases/Glove/HandWraps,Leather.png"));
        glove.addItem(new CaseItem("Hand Wraps | Slaughter", ItemRarity.RARE_SPECIAL_ITEM, "/SourceImages/Cases/Glove/HandWraps,Slaughter.png"));
        glove.addItem(new CaseItem("Driver Gloves | Lunar Weave", ItemRarity.RARE_SPECIAL_ITEM, "/SourceImages/Cases/Glove/DriverGloves,LunarWave.png"));
        glove.addItem(new CaseItem("Driver Gloves | Convoy", ItemRarity.RARE_SPECIAL_ITEM, "/SourceImages/Cases/Glove/DriverGloves,Convoy.png"));
        glove.addItem(new CaseItem("Driver Gloves | Diamondback", ItemRarity.RARE_SPECIAL_ITEM, "/SourceImages/Cases/Glove/DriverGloves,Diamondback.png"));
        glove.addItem(new CaseItem("Driver Gloves | Crimson Weave", ItemRarity.RARE_SPECIAL_ITEM, "/SourceImages/Cases/Glove/DriverGloves,CrimsonWeave.png"));
        glove.addItem(new CaseItem("Bloodhound Gloves | Guerrilla", ItemRarity.RARE_SPECIAL_ITEM, "/SourceImages/Cases/Glove/BloodhoundGloves,Guerrilla.png"));
        glove.addItem(new CaseItem("Bloodhound Gloves | Charred", ItemRarity.RARE_SPECIAL_ITEM, "/SourceImages/Cases/Glove/BloodhoundGloves,Charred.png"));        
        glove.addItem(new CaseItem("Bloodhound Gloves | Snakebite", ItemRarity.RARE_SPECIAL_ITEM, "/SourceImages/Cases/Glove/BloodhoundGloves,Snakebite.png"));
        glove.addItem(new CaseItem("Bloodhound Gloves | Bronzed", ItemRarity.RARE_SPECIAL_ITEM, "/SourceImages/Cases/Glove/BloodhoundGloves,Bronzed.png"));


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