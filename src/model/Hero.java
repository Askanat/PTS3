package model;

/**
 * Created by bastien on 29/09/16.
 */

public class Hero extends Personnage {


    public Hero(String nom, int vie, int vieMax, int degats, int positionX, int positionY) {
        super(nom, vie, vieMax, degats, positionX, positionY);
    }

    public void deplacer(int destinationX, int destinationY) {
    }

    public void selectionnerMorceauSpriteDeplacement() {

    }
}