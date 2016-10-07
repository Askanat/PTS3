package controleur;

import model.Jeu;
import vue.Fenetre;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by bastien on 06/10/16.
 */

public class ControlBarreMenu extends Control implements ActionListener {

    protected ControlBarreMenu(Jeu jeu, Fenetre fenetre) {
        super(jeu, fenetre);
        fenetre.setControlBarreMenu(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "Menu":
                jeu.setPause(true);
                fenetre.setContentPane(fenetre.panelMenuEnJeu);
                fenetre.repaint();
                fenetre.pack();
                fenetre.setLocationRelativeTo(null);
                fenetre.requestFocus();

                break;
        }
        fenetre.repaint();
    }
}