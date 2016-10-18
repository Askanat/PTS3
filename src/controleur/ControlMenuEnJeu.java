package controleur;

import model.Jeu;
import vue.Fenetre;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by bastien on 07/10/16.
 */

public class ControlMenuEnJeu extends Control implements ActionListener {

    protected ControlMenuEnJeu(Jeu jeu, Fenetre fenetre) {
        super(jeu, fenetre);
        fenetre.setControlMenuEnJeu(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "Retour":
                jeu.setPause(false);
                break;
            case "Inventaire":
                System.out.println("nventaire");
                break;
            case "Fiche Personnage":
                System.out.println("fiche inventaire");
                break;
            case "Retour au Menu Principal":
                Control.enPartie = false;
                jeu.setPause(false);
                fenetre.barreMenu.setVisible(false);
                fenetre.setContentPane(fenetre.panelMenuPrincipal);
                fenetre.repaint();
                fenetre.pack();
                fenetre.setLocationRelativeTo(null);
                fenetre.requestFocus();
                // quitte le perso : sauvegarde du perso + mise du perso à null
                break;
            case "Retour Au Bureau":
                System.exit(0);
                break;
        }
    }
}