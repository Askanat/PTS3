package controleur;

import model.Jeu;
import vue.Fenetre;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by bastien on 30/09/16.
 */

public class ControlTimer extends Control implements ActionListener {

    public ControlTimer(Jeu jeu, Fenetre fenetre) {
        super(jeu, fenetre);

        Timer timer = new Timer(60, this);
        timer.start();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        int x=0, y=0;
        if (ControlFenetreCharger.boutonEnfoncer[0] || ControlFenetreCharger.boutonEnfoncer[1] || ControlFenetreCharger.boutonEnfoncer[2] || ControlFenetreNouvellePartie.boutonEnfoncer[0] || ControlFenetreNouvellePartie.boutonEnfoncer[1] || ControlFenetreNouvellePartie.boutonEnfoncer[2]) {
            if (ControlClavier.toucheEnfoncer[0]) // echap
                jeu.setPause(true);
            else
                jeu.setPause(false);

            if (ControlClavier.toucheEnfoncer[1]) {// touche de gauche
                x = -1;
                y = 0;
            }
            if (ControlClavier.toucheEnfoncer[2]) {// touche du haut
                x = 0;
                y = -1;
            }
            if (ControlClavier.toucheEnfoncer[3]) {// touche de droite
                x = 1;
                y = 0;
            }
            if (ControlClavier.toucheEnfoncer[4]) {// touche du bas
                x = 0;
                y = 1;

            }

            jeu.getHero().selectionnerMorceauSpriteDeplacement(x, y);
            jeu.getHero().deplacer(x, y);
        }


        fenetre.repaint();
    }
}
