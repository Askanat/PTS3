package controleur;

import model.Jeu;
import vue.Fenetre;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Timer;

/**
 * Created by bastien on 30/09/16.
 */

public class ControlTimer extends Control implements ActionListener {

    protected ControlTimer(Jeu jeu, Fenetre fenetre) {
        super(jeu, fenetre);
        Timer timer = new Timer(90, this);
        timer.start();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
