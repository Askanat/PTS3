package model;

/**
 * Created by bastien on 29/09/16.
 */

public class Monstre extends Personnage {

    public Monstre(String nom, int vie, int vieMax, int degats, int positionX, int positionY) {
        super(nom, vie, vieMax, degats, positionX, positionY);
    }

    public void deplacer() {
    } // déplace aléatoirement

    public void deplacer(Hero cible) {
    } // poursuit le hero
}