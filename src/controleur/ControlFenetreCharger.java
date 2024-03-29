package controleur;

import model.Jeu;
import vue.Fenetre;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by bastien on 29/09/16.
 */

public class ControlFenetreCharger extends Control implements ActionListener {

    private int choixHero;

    public ControlFenetreCharger(Jeu jeu, Fenetre fenetre) {
        super(jeu, fenetre);
        fenetre.setControlFenetreCharger(this);

        choixHero = 0;
    }

    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "Slot de Sauvegarde n°1":
                choixHero = 1;
                Fenetre.numeroPorte = 1;
                break;
            case "Slot de Sauvegarde n°2":
                choixHero = 2;
                Fenetre.numeroPorte = 2;
                break;
            case "Slot de Sauvegarde n°3":
                choixHero = 3;
                Fenetre.numeroPorte = 3;
                break;
            case "Jouer":
                Fenetre.numeroPorte = -1;
                try {
                    jeu.setHero(choixHero);
                    fenetre.panelFenetreJeu.updateEntite();
                    choixHero = 0;
                    Control.enPartie = true;
                    fenetre.setContentPane(fenetre.panelScrollFenetreJeu);
                    changerVue();
                } catch (Exception e1) {
                    fenetre.panelFenetreCharger.setPaneSelectionnePersonnage();
                }
                break;
            case "Retour":
                Fenetre.numeroPorte = -1;
                fenetre.setContentPane(fenetre.panelMenuPrincipal);
                changerVue();
                choixHero = 0;
                break;
        }
    }
}