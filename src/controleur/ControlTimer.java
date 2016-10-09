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

        Timer timer = new Timer(100, this);
        timer.start();
    }

    @Override
    public void actionPerformed(ActionEvent e) {


        if (Control.enPartie) {
            if (jeu.getPause()) {// echap
                fenetre.setContentPane(fenetre.panelMenuEnJeu);
                fenetre.repaint();
                fenetre.pack();
                fenetre.setLocationRelativeTo(null);
                fenetre.requestFocus();
            }
            else
            {
                fenetre.setContentPane(fenetre.panelFenetreDepart);
                fenetre.repaint();
                fenetre.pack();
                fenetre.setLocationRelativeTo(null);
                fenetre.requestFocus();
            }

            if (!jeu.getPause()) {
                int x = 0, y = 0;

                if (ControlClavier.toucheEnfoncer[1]) {// touche de gauche
                    x += -1;
                    y += 0;
                }
                if (ControlClavier.toucheEnfoncer[2]) {// touche du haut
                    x += 0;
                    y += -1;
                }
                if (ControlClavier.toucheEnfoncer[3]) {// touche de droite
                    x += 1;
                    y += 0;
                }
                if (ControlClavier.toucheEnfoncer[4]) {// touche du bas
                    x += 0;
                    y += 1;
                }

                fenetre.panelFenetreDepart.hero.selectionnerMorceauSpriteDeplacement(x, y);
                jeu.getHero().deplacer(x, y);
            }

            // jeu.getHero().setVie(jeu.getHero().getVie() - 1); // enleve vie du hero
        }

        fenetre.repaint();
    }
}