package controleur;

import model.Jeu;
import vue.Fenetre;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by bastien on 21/11/16.
 */
public class ControlFenetreCreationPersonnage extends Control implements ActionListener {

    public ControlFenetreCreationPersonnage(Jeu jeu, Fenetre fenetre) {
        super(jeu, fenetre);
        fenetre.setControlFenetreCreationPersonnage(this);
    }

    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "Jouer":
                String nomPerso = fenetre.panelFenetreCreationPersonnage.getTfNomHero().getText();
                int idHero = jeu.getidPartieLibre();
                jeu.createHeroBDD(nomPerso, idHero);
                jeu.setHero(idHero);
                fenetre.panelFenetreDepart.dessineHero(idHero);
                break;
            case "Retour":
                fenetre.setContentPane(fenetre.panelMenuPrincipal);
                changerVue();
                break;
        }
    }
}
