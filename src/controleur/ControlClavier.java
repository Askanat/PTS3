package controleur;

import model.Jeu;
import vue.Fenetre;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Created by bastien on 30/09/16.
 */

public class ControlClavier extends Control implements KeyListener {

    private ControlTouche controlTouche;
    public static boolean toucheEnfoncer[];
    public static boolean toucheRelacher[];


    public ControlClavier(Jeu jeu, Fenetre fenetre) {
        super(jeu, fenetre);
        fenetre.setControlClavier(this);

        controlTouche = new ControlTouche();
        toucheEnfoncer = new boolean[controlTouche.getNbActions()];
        toucheRelacher = new boolean[controlTouche.getNbActions()];

        for (int i = 0; i < toucheEnfoncer.length; i++)
            toucheEnfoncer[i] = false;

        for (int i = 0; i < toucheRelacher.length; i++)
            toucheRelacher[i] = false;
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {

        int i = 0;
        for (int key : controlTouche.getTouches()) {
            if (e.getKeyCode() == key)
                toucheEnfoncer[i] = true;
            i++;
        }

        //System.out.println("Touche pressée : " + e.getKeyCode() + " (" + e.getKeyChar() + ")"); // savoir la touche appuyer
    }

    @Override
    public void keyReleased(KeyEvent e) {

        int i = 0;
        for (int key : controlTouche.getTouches()) {
            if (e.getKeyCode() == key)
                toucheEnfoncer[i] = false;
            i++;
        }

        i = 0;
        for (int key : controlTouche.getTouches()) {
            if (e.getKeyCode() == key)
                toucheRelacher[i] = true;
            i++;
        }
    }
}