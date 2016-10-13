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
                jeu.setHero(1);
                fenetre.barreMenu.test(); // ajout du composant vie dans la bare menu
                fenetre.panelFenetreDepart.dessineHero();
                ChargerPartie1 = true;
                break;
            case "Slot de Sauvegarde n°2":
                jeu.setHero(2);
                fenetre.barreMenu.test(); // ajout du composant vie dans la bare menu
                fenetre.panelFenetreDepart.dessineHero();
                ChargerPartie2 = true;
                break;
            case "Slot de Sauvegarde n°3":
                jeu.setHero(3);
                fenetre.barreMenu.test(); // ajout du composant vie dans la bare menu
                fenetre.panelFenetreDepart.dessineHero();
                ChargerPartie3 = true;
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
}
