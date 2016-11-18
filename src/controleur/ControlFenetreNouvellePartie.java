package controleur;

import model.Jeu;
import vue.Fenetre;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by bastien on 29/09/16.
 */

public class ControlFenetreNouvellePartie extends Control implements ActionListener {

    public static boolean nouvellePartie1, nouvellePartie2, nouvellePartie3;

    public ControlFenetreNouvellePartie(Jeu jeu, Fenetre fenetre) {
        super(jeu, fenetre);
        fenetre.setControlFenetreNouvellePartie(this);

        nouvellePartie1 = false;
        nouvellePartie2 = false;
        nouvellePartie3 = false;
    }

    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "Slot de Sauvegarde n°1":
                // verif suppresion hero
                // supprime hero 1
                // crée un nouveau hero avec le nom rentrer
                // commencer jeu
                nouvellePartie1 = true;
                break;
            case "Slot de Sauvegarde n°2":
                // verif suppresion hero
                // supprime hero 2
                // crée un nouveau hero avec le nom rentrer
                // commencer jeu
                nouvellePartie2 = true;
                break;
            case "Slot de Sauvegarde n°3":
                // verif suppresion hero
                // supprime hero 3
                // crée un nouveau hero avec le nom rentrer
                // commencer jeu
                nouvellePartie3 = true;
                break;
            case "Retour":
                fenetre.setContentPane(fenetre.panelMenuPrincipal);
                changerVue();
                break;
        }
    }
}
