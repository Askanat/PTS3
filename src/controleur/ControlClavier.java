package controleur;

import model.Jeu;
import vue.Fenetre;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Created by bastien on 30/09/16.
 */

public class ControlClavier extends Control implements KeyListener {

    private final int TOUCHE_CLAVIER[] = ControlTouche.getJavaTouches();
    public static boolean toucheEnfoncer[];

    public ControlClavier(Jeu jeu, Fenetre fenetre) {
        super(jeu, fenetre);
        fenetre.setControlClavier(this);

        toucheEnfoncer = new boolean[ControlTouche.getNbTouches()];

        for (int i = 0; i < toucheEnfoncer.length; i++)
            toucheEnfoncer[i] = false;
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {

        int i = 0;
        for (int key : TOUCHE_CLAVIER) {
            if (e.getKeyCode() == key)
                toucheEnfoncer[i] = true;
            i++;
        }

        //System.out.println("Touche pressée : " + e.getKeyCode() + " (" + e.getKeyChar() + ")"); // savoir la touche appuyer
    }

    @Override
    public void keyReleased(KeyEvent e) {

        int i = 0;
        for (int key : TOUCHE_CLAVIER) {
            if (e.getKeyCode() == key)
                toucheEnfoncer[i] = false;
            i++;
        }

        if (e.getKeyCode() == KeyEvent.VK_ESCAPE)
            if (Control.enPartie)
                jeu.inversePause();
    }
}