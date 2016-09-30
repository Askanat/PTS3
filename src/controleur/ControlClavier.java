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

        switch (e.getKeyCode()) {
            case 27: {
                jeu.setPause(!jeu.getPause()); // echap
            }
            case 37: {
                jeu.getHero().setGauche(true);  // fleche de gauche
                break;
            }
            case 38: {
                jeu.getHero().setSauter(true); // fleche du haut
                break;
            }
            case 39: {
                jeu.getHero().setDroite(true); // feche de droite
                break;
            }
            case 40: {
                jeu.getHero().setAccroupir(true); // fleche du bas
                break;
            }
        }

        //System.out.println("Touche pressée : " + e.getKeyCode() + " (" + e.getKeyChar() + ")"); // savoir la touche appuyer
    }

    @Override
    public void keyReleased(KeyEvent e) {
        switch (e.getKeyCode()) {
            case 27: {
                jeu.setPause(!jeu.getPause()); // echap
            }
            case 37: {
                jeu.getHero().setGauche(false); // fleche de gauche
                break;
            }
            case 38: {
                jeu.getHero().setSauter(false); // fleche du haut
                break;
            }
            case 39: {
                jeu.getHero().setDroite(false); // feche de droite
                break;
            }
            case 40: {
                jeu.getHero().setAccroupir(false); // fleche du bas
                break;
            }
        }
    }
}