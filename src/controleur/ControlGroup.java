package controleur;

import model.Jeu;
import vue.Fenetre;

/**
 * Created by bastien on 28/09/16.
 */

public class ControlGroup {

    Jeu jeu = new Jeu();
    Fenetre fenetre;

    public ControlGroup(Jeu jeu) {
        this.jeu = jeu;
        fenetre = new Fenetre(jeu);

        ControlFenetreCharger controlFenetreCharger = new ControlFenetreCharger(jeu, fenetre);
        ControlFenetreCredits controlFenetreCredits = new ControlFenetreCredits(jeu, fenetre);
        ControlFenetreDepart controlFenetreDepart = new ControlFenetreDepart(jeu, fenetre);
        ControlFenetreDonjon controlFenetreDonjon = new ControlFenetreDonjon(jeu, fenetre);
        ControlFenetreNouvellePartie controlFenetreNouvellePartie = new ControlFenetreNouvellePartie(jeu, fenetre);
        ControlMenuPrincipal controlMenuPrincipal = new ControlMenuPrincipal(jeu, fenetre);
    }
}