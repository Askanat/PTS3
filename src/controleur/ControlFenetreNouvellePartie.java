package controleur;

import model.Jeu;
import vue.Fenetre;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by bastien on 29/09/16.
 */

public class ControlFenetreNouvellePartie extends Control implements ActionListener{
    protected ControlFenetreNouvellePartie(Jeu jeu, Fenetre fenetre) {
        super(jeu, fenetre);
        fenetre.setControlFenetreNouvellePartie(this);
    }

    public void actionPerformed(ActionEvent e) {

    }
}
