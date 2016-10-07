package controleur;

import model.Jeu;
import vue.Fenetre;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by bastien on 29/09/16.
 */

public class ControlFenetreNouvellePartie extends Control implements ActionListener {

    public ControlFenetreNouvellePartie(Jeu jeu, Fenetre fenetre) {
        super(jeu, fenetre);
        fenetre.setControlFenetreNouvellePartie(this);
    }

    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "Slot de Sauvegarde n°1":
                Control.enPartie = true;
                fenetre.setContentPane(fenetre.panelFenetreDepart);
                fenetre.repaint();
                fenetre.pack();
                fenetre.setLocationRelativeTo(null);
                fenetre.requestFocus();
                break;
            case "Slot de Sauvegarde n°2":
                Control.enPartie = true;
                fenetre.setContentPane(fenetre.panelFenetreDepart);
                fenetre.repaint();
                fenetre.pack();
                fenetre.setLocationRelativeTo(null);
                fenetre.requestFocus();
                break;
            case "Slot de Sauvegarde n°3":
                Control.enPartie = true;
                fenetre.setContentPane(fenetre.panelFenetreDepart);
                fenetre.repaint();
                fenetre.pack();
                fenetre.setLocationRelativeTo(null);
                fenetre.requestFocus();
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
