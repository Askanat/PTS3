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
    }
}