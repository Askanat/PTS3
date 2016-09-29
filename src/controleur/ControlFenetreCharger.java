package controleur;

import model.Jeu;
import vue.Fenetre;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by bastien on 29/09/16.
 */

public class ControlFenetreCharger extends Control implements ActionListener {
    protected ControlFenetreCharger(Jeu jeu, Fenetre fenetre) {
        super(jeu, fenetre);
    }

    public void actionPerformed(ActionEvent e) {

    }
}
