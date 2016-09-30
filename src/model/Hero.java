package model;

import java.awt.*;

/**
 * Created by bastien on 29/09/16.
 */

public class Hero extends Personnage {


    public Hero(String nom, int vie, int vieMax, int degats, int positionX, int positionY, Image texture) {
        super(nom, vie, vieMax, degats, positionX, positionY, texture);
    }

    public void deplacer(int destinationX, int destinationY) {
    }

    public void selectionnerMorceauSpriteDeplacement() {

    }
}