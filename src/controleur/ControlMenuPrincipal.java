package controleur;

import model.Jeu;
import vue.Fenetre;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by bastien on 29/09/16.
 */

public class ControlMenuPrincipal extends Control implements ActionListener {

    public ControlMenuPrincipal(Jeu jeu, Fenetre fenetre) {
        super(jeu, fenetre);
        fenetre.setControlMenuPrincipal(this);
    }

    public void actionPerformed(ActionEvent e) {
        jeu.setNbPartieLibre(jeu.getBDDNbPartieLibre());
        switch (e.getActionCommand()) {
            case "Nouvelle Partie":
                if (jeu.getNbPartieLibre() >= 1) {
                    fenetre.panelFenetreCreationPersonnage.initialiseCaracteristiquePhysique();
                    fenetre.setContentPane(fenetre.panelFenetreCreationPersonnage);
                    changerVue();
                } else {
                    fenetre.panelFenetreNouvellePartie.setLabelNom1(jeu.readNomPerso(1));
                    fenetre.panelFenetreNouvellePartie.setLabelLVL1(jeu.readLVLPerso(1));
                    fenetre.panelFenetreNouvellePartie.setLabelNom2(jeu.readNomPerso(2));
                    fenetre.panelFenetreNouvellePartie.setLabelLVL2(jeu.readLVLPerso(2));
                    fenetre.panelFenetreNouvellePartie.setLabelNom3(jeu.readNomPerso(3));
                    fenetre.panelFenetreNouvellePartie.setLabelLVL3(jeu.readLVLPerso(3));

                    fenetre.setContentPane(fenetre.panelFenetreNouvellePartie);
                    changerVue();
                    fenetre.panelFenetreNouvellePartie.setPaneSelectionnePersonnageASupprimer();
                }
                break;
            case "Charger Partie":

                if (3 - jeu.getNbPartieLibre() > 0) {
                    fenetre.panelFenetreCharger.setLabelNom1(jeu.readNomPerso(1));
                    fenetre.panelFenetreCharger.setLabelLVL1(jeu.readLVLPerso(1));
                    fenetre.panelFenetreCharger.setLabelNom2(jeu.readNomPerso(2));
                    fenetre.panelFenetreCharger.setLabelLVL2(jeu.readLVLPerso(2));
                    fenetre.panelFenetreCharger.setLabelNom3(jeu.readNomPerso(3));
                    fenetre.panelFenetreCharger.setLabelLVL3(jeu.readLVLPerso(3));

                    fenetre.setContentPane(fenetre.panelFenetreCharger);
                    changerVue();
                } else {
                    fenetre.panelFenetreCreationPersonnage.initialiseCaracteristiquePhysique();
                    fenetre.setContentPane(fenetre.panelFenetreCreationPersonnage);
                    changerVue();
                }
                break;
            case "Options":
                fenetre.setContentPane(fenetre.panelFenetreOptions);
                changerVue();
                break;
            case "Crédits":
                fenetre.setContentPane(fenetre.panelFenetreCredits);
                changerVue();
                break;
            case "Quitter":
                System.exit(0);
                break;
        }
    }
}