package controleur;

import model.Jeu;
import vue.Fenetre;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by bastien on 29/09/16.
 */

public class ControlMenuPrincipal extends Control implements ActionListener {
    protected ControlMenuPrincipal(Jeu jeu, Fenetre fenetre) {
        super(jeu, fenetre);
        fenetre.setControlMenuPrincipal(this);
    }

    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "Nouvelle Partie":
                System.out.print("test1");
                break;
            case "Charger Partie":
                System.out.print("test2");
                break;
            case "Crédits":
                System.out.print("test2");
                break;
            case "Quitter":
                System.out.print("test3");
                break;
        }
    }
}
