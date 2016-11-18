package controleur;

import model.Jeu;
import vue.Fenetre;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by bastien on 14/10/16.
 */

public class ControlFenetreOptions extends Control implements ActionListener {

    public ControlFenetreOptions(Jeu jeu, Fenetre fenetre) {
        super(jeu, fenetre);
        fenetre.setControlFenetreOptions(this);
    }

    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "Retour":
                if (!jeu.getPause()) {
                    fenetre.setContentPane(fenetre.panelMenuPrincipal);
                } else {
                    fenetre.setContentPane(fenetre.panelMenuEnJeu);
                    Control.enPartie = true;
                }
                fenetre.setContentPane(fenetre.panelMenuPrincipal);
                changerVue();
                break;
        }
    }
}
