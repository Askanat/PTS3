package controleur;

import model.Jeu;
import vue.Fenetre;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by bastien on 29/09/16.
 */

public class ControlFenetreCredits extends Control implements ActionListener {

    public ControlFenetreCredits(Jeu jeu, Fenetre fenetre) {
        super(jeu, fenetre);
        fenetre.setControlFenetreCredits(this);
    }

    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "Retour":
                fenetre.setContentPane(fenetre.panelMenuPrincipal);
                changerVue();
                break;
        }
    }
}