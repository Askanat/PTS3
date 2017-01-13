package controleur;

import model.Jeu;
import vue.Fenetre;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by bastien on 29/09/16.
 */

public class ControlFenetreDepart extends Control implements ActionListener {

    public ControlFenetreDepart(Jeu jeu, Fenetre fenetre) {
        super(jeu, fenetre);
        fenetre.setControlFenetreDepart(this);
    }

    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "Menu":
                jeu.inversePause();

                if (jeu.getPause()) {
                    fenetre.getContentPane().setLayout(new GridBagLayout());
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
                } else {
                    fenetre.getContentPane().removeAll();
                    fenetre.panelFenetreDepart.bouttonMenu();
                    fenetre.setContentPane(fenetre.panelFenetreDepart);
                    changerVue();
                }
                break;
        }
    }
}