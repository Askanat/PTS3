package controleur;

import model.Jeu;
import vue.Fenetre;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by bastien on 29/09/16.
 */

public class ControlFenetreCharger extends Control implements ActionListener {

    public static boolean ChargerPartie1, ChargerPartie2, ChargerPartie3;

    public ControlFenetreCharger(Jeu jeu, Fenetre fenetre) {
        super(jeu, fenetre);
        fenetre.setControlFenetreCharger(this);

        ChargerPartie1 = false;
        ChargerPartie2 = false;
        ChargerPartie3 = false;
    }

    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "Slot de Sauvegarde n°1":
                spawnHero(1);
                fenetre.barreMenu.test(); // ajout du composant vie dans la bare menu
                spawnMonstre(1);
                ChargerPartie1 = true;
                break;
            case "Slot de Sauvegarde n°2":
                spawnHero(2);
                fenetre.barreMenu.test(); // ajout du composant vie dans la bare menu
                spawnMonstre(2);
                ChargerPartie1 = true;
                break;
            case "Slot de Sauvegarde n°3":
                spawnHero(3);
                fenetre.barreMenu.test(); // ajout du composant vie dans la bare menu
                spawnMonstre(3);
                ChargerPartie1 = true;
                break;
            case "Retour":
                fenetre.setContentPane(fenetre.panelMenuPrincipal);
                fenetre.repaint();
                fenetre.pack();
                fenetre.setLocationRelativeTo(null);
                fenetre.requestFocus();
                break;
        }
    }

    private void spawnHero(int i) {
        jeu.setHero(1);
        fenetre.panelFenetreDepart.dessineHero(1);
    }

    private void spawnMonstre(int i) {
        jeu.setMonstre(1);
        fenetre.panelFenetreDepart.dessineMonstre(1);
    }
}
