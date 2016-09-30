package controleur;

import model.Jeu;
import vue.Fenetre;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Created by bastien on 30/09/16.
 */

public class ControlClavier extends Control implements KeyListener {

    public ControlClavier(Jeu jeu, Fenetre fenetre) {
        super(jeu, fenetre);
        fenetre.setControlClavier(this);
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

        if (e.getKeyCode() == 27) { // echap
            jeu.setPause(!jeu.getPause());
        }
        if (e.getKeyCode() == 37) { // fleche de gauche
        }
        if (e.getKeyCode() == 38) { // fleche du haut
        }
        if (e.getKeyCode() == 39) { // feche de droite
        }
        if (e.getKeyCode() == 40) { // fleche du bas
        }


        // System.out.println("Touche pressée : " + e.getKeyCode() + " (" + e.getKeyChar() + ")"); // savoir la touche appuyer
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}