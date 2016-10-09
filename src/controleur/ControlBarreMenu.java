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
                if(jeu.getPause())
                    jeu.setPause(false);
                else
                    jeu.setPause(true);
                break;
        }
        fenetre.repaint();
    }
}