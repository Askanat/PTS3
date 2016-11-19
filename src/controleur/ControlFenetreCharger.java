package controleur;

import model.Jeu;
import vue.Fenetre;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static model.Jeu.X;
import static model.Jeu.Y;

/**
 * Created by bastien on 29/09/16.
 */

public class ControlFenetreCharger extends Control implements ActionListener {

    private int valeurHero;

    public ControlFenetreCharger(Jeu jeu, Fenetre fenetre) {
        super(jeu, fenetre);
        fenetre.setControlFenetreCharger(this);

        valeurHero = 0;
    }

    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "Slot de Sauvegarde n°1":
                valeurHero = 1;
                break;
            case "Slot de Sauvegarde n°2":
                valeurHero = 2;
                break;
            case "Slot de Sauvegarde n°3":
                valeurHero = 3;
                break;
            case "Jouer":
                if (valeurHero == 0) {
                    fenetre.setPaneSelectionnePersonnage();
                } else {
                    spawnHero(valeurHero);
                    fenetre.barreMenu.test(); // ajout du composant vie dans la bare menu
                    spawnMonstre(1, (int) (5 / 48.0 * X), (int) (5 / 27.0 * Y)); // a enlever d'ici
                    spawnMonstre(2, (int) (5 / 24.0 * X), (int) (10 / 27.0 * Y)); // a enlever d'ici
                    spawnMonstre(3, (int) (5 / 16.0 * X), (int) (5 / 9.0 * Y)); // a enlever d'ici
                    valeurHero = 0;
                    Control.enPartie = true;
                    fenetre.barreMenu.setVisible(true);
                    fenetre.setContentPane(fenetre.panelFenetreDepart);
                    changerVue();
                }
                break;
            case "Retour":
                fenetre.setContentPane(fenetre.panelMenuPrincipal);
                changerVue();
                valeurHero = 0;
                break;
        }
    }

    private void spawnHero(int i) {
        jeu.setHero(i);
        fenetre.panelFenetreDepart.dessineHero(i);
    }

    private void spawnMonstre(int i, int positionX, int positionY) { // a enlever d'ici
        jeu.setMonstre(i, positionX, positionY);
        fenetre.panelFenetreDepart.dessineMonstre(i);
    }
}