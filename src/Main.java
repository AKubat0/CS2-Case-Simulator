package src;
import java.awt.*;
import java.net.URL;
import javax.swing.*;

public class Main{

    public Main(){
        JFrame frame = new JFrame();
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

        JPanel openCasePanel = new JPanel(new BorderLayout());
        JPanel centeringWrapper = new JPanel(new GridBagLayout());
        centeringWrapper.setBackground(new Color(10, 9, 13));
        JPanel caseCardHolder = new JPanel();
        caseCardHolder.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 20));
        caseCardHolder.setBackground(new Color(10, 9, 13));
        centeringWrapper.add(caseCardHolder);
        openCasePanel.add(centeringWrapper, BorderLayout.CENTER);


        Case dreamsAndNightmares = new Case("Dreams And Nightmares", Main.class.getResource("/SourceImages/Cases/DreamsAndNightmares/DreamsAndNightmaresCase.png"));
        dreamsAndNightmares.addItem(new CaseItem("SCAR-20 | Poultrygeist", ItemRarity.MIL_SPEC, "/SourceImages/Cases/DreamsAndNightmares/Scar20,Poultrygeist.png"));
        dreamsAndNightmares.addItem(new CaseItem("MAG-7 | Foresight", ItemRarity.MIL_SPEC, "/SourceImages/Cases/DreamsAndNightmares/Scar20,Poultrygeist.png"));
        dreamsAndNightmares.addItem(new CaseItem("Sawed-Off | Spirit Board", ItemRarity.MIL_SPEC, "/SourceImages/Cases/DreamsAndNightmares/Scar20,Poultrygeist.png"));
        dreamsAndNightmares.addItem(new CaseItem("P2000 | Lifted Spirits", ItemRarity.MIL_SPEC, "/SourceImages/Cases/DreamsAndNightmares/Scar20,Poultrygeist.png"));
        dreamsAndNightmares.addItem(new CaseItem("MAC-10 | Ensnared", ItemRarity.MIL_SPEC, "/SourceImages/Cases/DreamsAndNightmares/Scar20,Poultrygeist.png"));
        dreamsAndNightmares.addItem(new CaseItem("MP5-SD | Necro Jr.", ItemRarity.MIL_SPEC, "/SourceImages/Cases/DreamsAndNightmares/Scar20,Poultrygeist.png"));
        dreamsAndNightmares.addItem(new CaseItem("Five-SeveN | Scrawl", ItemRarity.MIL_SPEC, "/SourceImages/Cases/DreamsAndNightmares/Scar20,Poultrygeist.png"));
        dreamsAndNightmares.addItem(new CaseItem("XM1014 | Zombie Offensive", ItemRarity.RESTRICTED, "/SourceImages/Cases/DreamsAndNightmares/Scar20,Poultrygeist.png"));
        dreamsAndNightmares.addItem(new CaseItem("PP-Bizon | Space Cat", ItemRarity.RESTRICTED, "/SourceImages/Cases/DreamsAndNightmares/Scar20,Poultrygeist.png"));
        dreamsAndNightmares.addItem(new CaseItem("G3SG1 | Dream Glade", ItemRarity.RESTRICTED, "/SourceImages/Cases/DreamsAndNightmares/Scar20,Poultrygeist.png"));
        dreamsAndNightmares.addItem(new CaseItem("USP-S | Ticket to Hell", ItemRarity.RESTRICTED, "/SourceImages/Cases/DreamsAndNightmares/Scar20,Poultrygeist.png"));
        dreamsAndNightmares.addItem(new CaseItem("M4A1-S | Night Terror", ItemRarity.RESTRICTED, "/SourceImages/Cases/DreamsAndNightmares/Scar20,Poultrygeist.png"));
        dreamsAndNightmares.addItem(new CaseItem("FAMAS | Rapid Eye Movement", ItemRarity.CLASSIFIED, "/SourceImages/Cases/DreamsAndNightmares/Scar20,Poultrygeist.png"));
        dreamsAndNightmares.addItem(new CaseItem("Dual Berettas | Melondrama", ItemRarity.CLASSIFIED, "/SourceImages/Cases/DreamsAndNightmares/Scar20,Poultrygeist.png"));
        dreamsAndNightmares.addItem(new CaseItem("MP7 | Abyssal Apparition", ItemRarity.CLASSIFIED, "/SourceImages/Cases/DreamsAndNightmares/Scar20,Poultrygeist.png"));
        dreamsAndNightmares.addItem(new CaseItem("MP9 | Starlight Protector", ItemRarity.COVERT, "/SourceImages/Cases/DreamsAndNightmares/Scar20,Poultrygeist.png"));
        dreamsAndNightmares.addItem(new CaseItem("AK-47 | Nightwish", ItemRarity.COVERT, "/SourceImages/Cases/DreamsAndNightmares/Scar20,Poultrygeist.png"));
        dreamsAndNightmares.addItem(new CaseItem("Shadow Daggers | Bright Water", ItemRarity.RARE_SPECIAL_ITEM, "/SourceImages/Cases/DreamsAndNightmares/Scar20,Poultrygeist.png"));
        dreamsAndNightmares.addItem(new CaseItem("Shadow Daggers | Freehand", ItemRarity.RARE_SPECIAL_ITEM, "/SourceImages/Cases/DreamsAndNightmares/Scar20,Poultrygeist.png"));
        dreamsAndNightmares.addItem(new CaseItem("Shadow Daggers | Autotronic", ItemRarity.RARE_SPECIAL_ITEM, "/SourceImages/Cases/DreamsAndNightmares/Scar20,Poultrygeist.png"));
        dreamsAndNightmares.addItem(new CaseItem("Shadow Daggers | Black Laminate", ItemRarity.RARE_SPECIAL_ITEM, "/SourceImages/Cases/DreamsAndNightmares/Scar20,Poultrygeist.png"));
        dreamsAndNightmares.addItem(new CaseItem("Shadow Daggers | Lore", ItemRarity.RARE_SPECIAL_ITEM, "/SourceImages/Cases/DreamsAndNightmares/Scar20,Poultrygeist.png"));
        dreamsAndNightmares.addItem(new CaseItem("Shadow Daggers | Gamma Doppler", ItemRarity.RARE_SPECIAL_ITEM, "/SourceImages/Cases/DreamsAndNightmares/Scar20,Poultrygeist.png"));
        dreamsAndNightmares.addItem(new CaseItem("Huntsman Knife | Bright Water", ItemRarity.RARE_SPECIAL_ITEM, "/SourceImages/Cases/DreamsAndNightmares/Scar20,Poultrygeist.png"));
        dreamsAndNightmares.addItem(new CaseItem("Huntsman Knife | Black Laminate", ItemRarity.RARE_SPECIAL_ITEM, "/SourceImages/Cases/DreamsAndNightmares/Scar20,Poultrygeist.png"));
        dreamsAndNightmares.addItem(new CaseItem("Huntsman Knife | Freehand", ItemRarity.RARE_SPECIAL_ITEM, "/SourceImages/Cases/DreamsAndNightmares/Scar20,Poultrygeist.png"));
        dreamsAndNightmares.addItem(new CaseItem("Huntsman Knife | Lore", ItemRarity.RARE_SPECIAL_ITEM, "/SourceImages/Cases/DreamsAndNightmares/Scar20,Poultrygeist.png"));
        dreamsAndNightmares.addItem(new CaseItem("Huntsman Knife | Autotronic", ItemRarity.RARE_SPECIAL_ITEM, "/SourceImages/Cases/DreamsAndNightmares/Scar20,Poultrygeist.png"));
        dreamsAndNightmares.addItem(new CaseItem("Huntsman Knife | Gamma Doppler", ItemRarity.RARE_SPECIAL_ITEM, "/SourceImages/Cases/DreamsAndNightmares/Scar20,Poultrygeist.png"));
        dreamsAndNightmares.addItem(new CaseItem("Falchion Knife | Bright Water", ItemRarity.RARE_SPECIAL_ITEM, "/SourceImages/Cases/DreamsAndNightmares/Scar20,Poultrygeist.png"));
        dreamsAndNightmares.addItem(new CaseItem("Falchion Knife | Black Laminate", ItemRarity.RARE_SPECIAL_ITEM, "/SourceImages/Cases/DreamsAndNightmares/Scar20,Poultrygeist.png"));
        dreamsAndNightmares.addItem(new CaseItem("Falchion Knife | Freehand", ItemRarity.RARE_SPECIAL_ITEM, "/SourceImages/Cases/DreamsAndNightmares/Scar20,Poultrygeist.png"));
        dreamsAndNightmares.addItem(new CaseItem("Falchion Knife | Lore", ItemRarity.RARE_SPECIAL_ITEM, "/SourceImages/Cases/DreamsAndNightmares/Scar20,Poultrygeist.png"));
        dreamsAndNightmares.addItem(new CaseItem("Falchion Knife | Autotronic", ItemRarity.RARE_SPECIAL_ITEM, "/SourceImages/Cases/DreamsAndNightmares/Scar20,Poultrygeist.png"));
        dreamsAndNightmares.addItem(new CaseItem("Falchion Knife | Gamma Doppler", ItemRarity.RARE_SPECIAL_ITEM, "/SourceImages/Cases/DreamsAndNightmares/Scar20,Poultrygeist.png"));
        dreamsAndNightmares.addItem(new CaseItem("Butterfly Knife | Gamma Doppler", ItemRarity.RARE_SPECIAL_ITEM, "/SourceImages/Cases/DreamsAndNightmares/Scar20,Poultrygeist.png"));
        dreamsAndNightmares.addItem(new CaseItem("Butterfly Knife | Autotronic", ItemRarity.RARE_SPECIAL_ITEM, "/SourceImages/Cases/DreamsAndNightmares/Scar20,Poultrygeist.png"));
        dreamsAndNightmares.addItem(new CaseItem("Butterfly Knife | Bright Water", ItemRarity.RARE_SPECIAL_ITEM, "/SourceImages/Cases/DreamsAndNightmares/Scar20,Poultrygeist.png"));
        dreamsAndNightmares.addItem(new CaseItem("Butterfly Knife | Freehand", ItemRarity.RARE_SPECIAL_ITEM, "/SourceImages/Cases/DreamsAndNightmares/Scar20,Poultrygeist.png"));
        dreamsAndNightmares.addItem(new CaseItem("Butterfly Knife | Lore", ItemRarity.RARE_SPECIAL_ITEM, "/SourceImages/Cases/DreamsAndNightmares/Scar20,Poultrygeist.png"));
        dreamsAndNightmares.addItem(new CaseItem("Butterfly Knife | Black Laminate", ItemRarity.RARE_SPECIAL_ITEM, "/SourceImages/Cases/DreamsAndNightmares/Scar20,Poultrygeist.png"));
        dreamsAndNightmares.addItem(new CaseItem("Bowie Knife | Black Laminate", ItemRarity.RARE_SPECIAL_ITEM, "/SourceImages/Cases/DreamsAndNightmares/Scar20,Poultrygeist.png"));
        dreamsAndNightmares.addItem(new CaseItem("Bowie Knife | Bright Water", ItemRarity.RARE_SPECIAL_ITEM, "/SourceImages/Cases/DreamsAndNightmares/Scar20,Poultrygeist.png"));
        dreamsAndNightmares.addItem(new CaseItem("Bowie Knife | Freehand", ItemRarity.RARE_SPECIAL_ITEM, "/SourceImages/Cases/DreamsAndNightmares/Scar20,Poultrygeist.png"));
        dreamsAndNightmares.addItem(new CaseItem("Bowie Knife | Autotronic", ItemRarity.RARE_SPECIAL_ITEM, "/SourceImages/Cases/DreamsAndNightmares/Scar20,Poultrygeist.png"));
        dreamsAndNightmares.addItem(new CaseItem("Bowie Knife | Lore", ItemRarity.RARE_SPECIAL_ITEM, "/SourceImages/Cases/DreamsAndNightmares/Scar20,Poultrygeist.png"));
        dreamsAndNightmares.addItem(new CaseItem("Bowie Knife | Gamma Doppler", ItemRarity.RARE_SPECIAL_ITEM, "/SourceImages/Cases/DreamsAndNightmares/Scar20,Poultrygeist.png"));

        CaseCard dreamsAndNightmaresCard = new CaseCard(dreamsAndNightmares, e -> {
        });
        caseCardHolder.add(dreamsAndNightmaresCard);

        

        frame.add(openCasePanel);


        frame.setVisible(true);
    }

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {
            Main main = new Main();
        });


        
    }

}