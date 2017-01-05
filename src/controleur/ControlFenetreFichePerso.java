package controleur;

import model.Jeu;
import vue.Fenetre;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by MSI-FlorianV on 05/01/2017.
 */
public class ControlFenetreFichePerso extends Control implements ActionListener {

    public ControlFenetreFichePerso(Jeu jeu, Fenetre fenetre) {
        super(jeu, fenetre);
        fenetre.setControlFenetreFichePerso(this);
    }

    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "Retour":
                    //Permet de réafficher le menu en jeu et superposer les vues
                    fenetre.setContentPane(fenetre.panelFenetreDepart);
                    Control.enPartie = true;
                    changerVue();
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
                break;
        }
    }
}
