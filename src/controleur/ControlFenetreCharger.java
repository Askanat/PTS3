package controleur;

import model.Jeu;
import vue.Fenetre;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by bastien on 29/09/16.
 */

public class ControlFenetreCharger extends Control implements ActionListener {

    public static boolean ChargerPartie;
    private int valeurHero;

    public ControlFenetreCharger(Jeu jeu, Fenetre fenetre) {
        super(jeu, fenetre);
        fenetre.setControlFenetreCharger(this);

        ChargerPartie = false;
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
                spawnHero(valeurHero);
                fenetre.barreMenu.test(); // ajout du composant vie dans la bare menu
                spawnMonstre(1);
                spawnMonstre(2);
                spawnMonstre(3);
                valeurHero = 0;
                ChargerPartie = true;
                break;
            case "Retour":
                fenetre.setContentPane(fenetre.panelMenuPrincipal);
                fenetre.repaint();
                fenetre.pack();
                fenetre.setLocationRelativeTo(null);
                fenetre.requestFocus();
                valeurHero = 0;
                break;
        }
    }

    private void spawnHero(int i) {
        jeu.setHero(i);
        fenetre.panelFenetreDepart.dessineHero(i);
    }

    private void spawnMonstre(int i) {
        jeu.setMonstre(i);
        fenetre.panelFenetreDepart.dessineMonstre(i);
    }
}