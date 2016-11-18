package controleur;

import model.Jeu;
import vue.Fenetre;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by bastien on 29/09/16.
 */

public class ControlMenuPrincipal extends Control implements ActionListener {

    public ControlMenuPrincipal(Jeu jeu, Fenetre fenetre) {
        super(jeu, fenetre);
        fenetre.setControlMenuPrincipal(this);
    }

    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "Nouvelle Partie":
                fenetre.setContentPane(fenetre.panelFenetreNouvellePartie);
                changerVue();
                break;
            case "Charger Partie":
                jeu.setHero(1);
                fenetre.panelFenetreDepart.dessineHero(1);
                fenetre.setContentPane(fenetre.panelFenetreCharger);
                changerVue();
                break;
            case "Options":
                fenetre.setContentPane(fenetre.panelFenetreOptions);
                changerVue();
                break;
            case "Crédits":
                fenetre.setContentPane(fenetre.panelFenetreCredits);
                changerVue();
                break;
            case "Quitter":
                System.exit(0);
                break;
        }
    }
}