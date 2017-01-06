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
                if (!jeu.getHitBox()){
                    jeu.setHitBox(true);
                    fenetre.panelFenetreOptions.hitBox.setForeground(Color.GREEN);
                    changerVue();
                }else{
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
                    //Permet de réafficher le menu en jeu et superposer les vues
                        fenetre.setContentPane(fenetre.panelFenetreDepart);
                        Control.enPartie = true;
                        changerVue();
                        fenetre.getContentPane().setLayout( new GridBagLayout());
                        fenetre.getContentPane().isOpaque();
                        GridBagConstraints gbc = new GridBagConstraints();
                        gbc.weightx = 1;
                        gbc.weighty = 1;

                        gbc.gridx = 0;
                        gbc.gridwidth = 2;
                        gbc.gridheight = 2;
                        gbc.gridy = 0;

                        fenetre.getContentPane().add(fenetre.panelMenuEnJeu, gbc);
                        fenetre.getContentPane().validate();
                }
                break;
        }
    }
}
