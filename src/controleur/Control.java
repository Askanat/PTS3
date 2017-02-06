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

    protected void changerVue() {
        fenetre.repaint();
        fenetre.pack();
        fenetre.setLocationRelativeTo(null);
        fenetre.requestFocus();
    }

    protected void spawnHero(int i) {
        jeu.setHero(i);
        fenetre.panelFenetreJeu.dessineHero();

        // a enlever
        spawnMonstre(1, 900, 0);
        spawnMonstre(2, 1400, 0);
        spawnMonstre(3, 1900, 0);
        spawnMonstre(4, 2400, 0);
    }

    protected void spawnMonstre(int i, int positionX, int positionY) {
        jeu.setMonstre(i, positionX, positionY);
        fenetre.panelFenetreJeu.dessineMonstre();
    }
}