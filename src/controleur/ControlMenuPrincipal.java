package controleur;

import model.Direction;
import model.Jeu;
import model.Niveau;
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
                    fenetre.setContentPane(fenetre.panelFenetreCreationPersonnage);
                    changerVue();
                } else {
                    fenetre.panelFenetreNouvellePartie.init();

                    fenetre.setContentPane(fenetre.panelFenetreNouvellePartie);
                    changerVue();
                    fenetre.panelFenetreNouvellePartie.setPaneSelectionnePersonnageASupprimer();
                }
                break;
            case "Charger Partie":
                if (3 - jeu.getNbPartieLibre() > 0) {
                    fenetre.panelFenetreCharger.init();

                    fenetre.setContentPane(fenetre.panelFenetreCharger);
                    changerVue();
                } else {
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