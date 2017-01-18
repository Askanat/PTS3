package controleur;

import model.Jeu;
import vue.Fenetre;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by bastien on 14/10/16.
 */

public class ControlFenetreOptions extends Control implements ActionListener {

    public ControlFenetreOptions(Jeu jeu, Fenetre fenetre) {
        super(jeu, fenetre);
        fenetre.setControlFenetreOptions(this);
    }

    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "Hitbox":
                if (!jeu.getHitBox()) {
                    jeu.setHitBox(true);
                    fenetre.panelFenetreOptions.hitBox.setForeground(Color.GREEN);
                    changerVue();
                } else {
                    jeu.setHitBox(false);
                    fenetre.panelFenetreOptions.hitBox.setForeground(Color.RED);
                    changerVue();
                }
                break;

            case "Retour":
                if (!jeu.getPause()) {
                    fenetre.setContentPane(fenetre.panelMenuPrincipal);
                    changerVue();
                } else {
                    Control.enPartie = true;
                    fenetre.setContentPane(fenetre.panelScrollFenetreDepart);
                    changerVue();
                    fenetre.vueMenuEnJeu();
                }
                break;
        }
    }
}
