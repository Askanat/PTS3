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

        Timer timer = new Timer(90, this);
        timer.start();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (jeu.getHero().getGauche())
            jeu.getHero().deplacer(-1, 0);
        if (jeu.getHero().getSauter())
            jeu.getHero().deplacer(0, -1);
        if (jeu.getHero().getDroite())
            jeu.getHero().deplacer(1, 0);
        if (jeu.getHero().getAccroupir())
            jeu.getHero().deplacer(0, 1);

        //System.out.println(jeu.getHero().getPositionX() + ", " + jeu.getHero().getPositionY());

        fenetre.repaint();
    }
}