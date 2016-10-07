package controleur;

import model.Jeu;
import vue.Fenetre;

/**
 * Created by bastien on 28/09/16.
 */

public class Control {

    public static boolean enPartie;
    Jeu jeu;
    Fenetre fenetre;

    protected Control(Jeu jeu, Fenetre fenetre) {
        this.jeu = jeu;
        this.fenetre = fenetre;

        enPartie = false;
    }
}
