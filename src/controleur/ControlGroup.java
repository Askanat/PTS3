package controleur;

import model.Jeu;
import vue.Fenetre;

/**
 * Created by bastien on 28/09/16.
 */

public class ControlGroup {

    public Jeu jeu = new Jeu();
    public Fenetre fenetre;

    public ControlGroup(Jeu jeu) {
        this.jeu = jeu;
        fenetre = new Fenetre(this.jeu);

        ControlFenetreCharger controlFenetreCharger = new ControlFenetreCharger(this.jeu, fenetre);
        ControlFenetreCredits controlFenetreCredits = new ControlFenetreCredits(this.jeu, fenetre);
        ControlFenetreDepart controlFenetreDepart = new ControlFenetreDepart(this.jeu, fenetre);
        ControlFenetreDonjon controlFenetreDonjon = new ControlFenetreDonjon(this.jeu, fenetre);
        ControlFenetreNouvellePartie controlFenetreNouvellePartie = new ControlFenetreNouvellePartie(this.jeu, fenetre);
        ControlMenuPrincipal controlMenuPrincipal = new ControlMenuPrincipal(this.jeu, fenetre);
    }
}