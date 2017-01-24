package controleur;

import model.Jeu;
import vue.Fenetre;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by bastien on 29/09/16.
 */

public class ControlFenetreNouvellePartie extends Control implements ActionListener {

    private int choixSupprimerPartieHero;

    public ControlFenetreNouvellePartie(Jeu jeu, Fenetre fenetre) {
        super(jeu, fenetre);
        fenetre.setControlFenetreNouvellePartie(this);

        choixSupprimerPartieHero = 0;
    }

    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "Slot n°1":
                choixSupprimerPartieHero = 1;
                Fenetre.numeroPorte = 1;
                break;
            case "Slot n°2":
                choixSupprimerPartieHero = 2;
                Fenetre.numeroPorte = 2;
                break;
            case "Slot n°3":
                choixSupprimerPartieHero = 3;
                Fenetre.numeroPorte = 3;
                break;
            case "Continuer":
                Fenetre.numeroPorte = -1;
                try {
                    jeu.supprimerPartie(choixSupprimerPartieHero);
                    choixSupprimerPartieHero = 0;

                    jeu.setNbPartieLibre(jeu.getBDDNbPartieLibre());


                    fenetre.setContentPane(fenetre.panelFenetreCreationPersonnage);
                    changerVue();
                } catch (Exception e1) {
                    fenetre.panelFenetreNouvellePartie.setPaneSelectionnePersonnageASupprimer();
                }
                break;
            case "Retour":
                Fenetre.numeroPorte = -1;
                fenetre.setContentPane(fenetre.panelMenuPrincipal);
                changerVue();
                choixSupprimerPartieHero = 0;
                break;
        }
    }
}
