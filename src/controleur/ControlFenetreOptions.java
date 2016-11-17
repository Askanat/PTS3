package controleur;

import model.Jeu;
import vue.Fenetre;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by bastien on 14/10/16.
 */

public class ControlFenetreOptions extends Control implements ActionListener{

    public ControlFenetreOptions(Jeu jeu, Fenetre fenetre) {
        super(jeu, fenetre);
        fenetre.setControlFenetreOptions(this);
    }

    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "Retour":
                if (Control.enPartie == false) {
                    fenetre.setContentPane(fenetre.panelMenuPrincipal);
                } else {
                    fenetre.setContentPane(fenetre.panelMenuEnJeu);
                }
                fenetre.repaint();
                fenetre.pack();
                fenetre.setLocationRelativeTo(null);
                fenetre.requestFocus();
                break;
        }
    }
}
