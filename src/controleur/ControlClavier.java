package controleur;

import model.Jeu;
import vue.Fenetre;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Created by bastien on 30/09/16.
 */

public class ControlClavier extends Control implements KeyListener {

    private int dernierPresse = KeyEvent.VK_UNDEFINED;

    public ControlClavier(Jeu jeu, Fenetre fenetre) {
        super(jeu, fenetre);
        fenetre.setControlClavier(this);
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

        jeu.getHero().setGauche(false);
        jeu.getHero().setSauter(false);
        jeu.getHero().setDroite(false);
        jeu.getHero().setAccroupir(false);

        switch(e.getKeyCode()) {
            case KeyEvent.VK_A : {
                jeu.getHero().setGauche(true);
                dernierPresse = KeyEvent.VK_A;
                break;
            }
            case KeyEvent.VK_B : {
                jeu.getHero().setSauter(true);
                dernierPresse = KeyEvent.VK_B;
                break;
            }
            case KeyEvent.VK_A : {
                jeu.getHero().setDroite(true);
                dernierPresse = KeyEvent.VK_A;
                break;
            }
            case KeyEvent.VK_B : {
                jeu.getHero().setAccroupir(true);
                dernierPresse = KeyEvent.VK_B;
                break;
            }
        }

        if (e.getKeyCode() == 27) // echap
            jeu.setPause(!jeu.getPause());



        if (e.getKeyCode() == 37) // fleche de gauche
            jeu.getHero().setGauche(true);
        if (e.getKeyCode() == 38)  // fleche du haut
            jeu.getHero().setSauter(true);
        if (e.getKeyCode() == 39)  // feche de droite
            jeu.getHero().setDroite(true);
        if (e.getKeyCode() == 40)  // fleche du bas
            jeu.getHero().setAccroupir(true);

        System.out.println(jeu.getHero().getGauche() + " " +
        jeu.getHero().getSauter());
        // System.out.println("Touche pressée : " + e.getKeyCode() + " (" + e.getKeyChar() + ")"); // savoir la touche appuyer
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}