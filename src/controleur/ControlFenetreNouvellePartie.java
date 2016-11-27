package controleur;

import model.Jeu;
import vue.Fenetre;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by bastien on 29/09/16.
 */

public class ControlFenetreNouvellePartie extends Control implements ActionListener {

    private int valeurSupprimerPartieHero;

    public ControlFenetreNouvellePartie(Jeu jeu, Fenetre fenetre) {
        super(jeu, fenetre);
        fenetre.setControlFenetreNouvellePartie(this);

        valeurSupprimerPartieHero = 0;
    }

    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "Slot n°1":
                valeurSupprimerPartieHero = 1;
                break;
            case "Slot n°2":
                valeurSupprimerPartieHero = 2;
                break;
            case "Slot n°3":
                valeurSupprimerPartieHero = 3;
                break;
            case "Continuer":

                try {
                    // supprimer la partie correspondant a valeurSupprimerPartieHero
                    valeurSupprimerPartieHero = 0;
                    jeu.supprimerPartie(valeurSupprimerPartieHero);
                    fenetre.setContentPane(fenetre.panelFenetreCreationPersonnage);
                    changerVue();
                } catch (Exception e1) {
                    fenetre.setPaneSelectionnePersonnageASupprimer();
                }
                break;
            case "Retour":
                fenetre.setContentPane(fenetre.panelMenuPrincipal);
                changerVue();
                valeurSupprimerPartieHero = 0;
                break;
        }
    }
}
