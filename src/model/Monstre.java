package model;

import java.awt.*;

/**
 * Created by bastien on 29/09/16.
 */

public class Monstre extends Personnage {

    public Monstre(String nom, int vie, int vieMax, int degats, int positionX, int positionY, int coefDeplacement) {
        super(nom, vie, vieMax, degats, positionX, positionY, coefDeplacement);
    }

    public void deplacer() {
    } // déplace aléatoirement

    public void deplacer(Hero cible) {
    } // poursuit le hero
}