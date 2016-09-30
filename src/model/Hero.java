package model;

import java.awt.*;

/**
 * Created by bastien on 29/09/16.
 */

public class Hero extends Personnage {

    private boolean accroupir, sauter, gauche, droite;


    public Hero(String nom, int vie, int vieMax, int degats, int positionX, int positionY, Image texture) {
        super(nom, vie, vieMax, degats, positionX, positionY, texture);
        accroupir = false;
        sauter = false;
        gauche = false;
        droite = false;
    }

    public void deplacer(int destinationX, int destinationY) {
    }

    public void selectionnerMorceauSpriteDeplacement() {

    }

    public void setAccroupir(boolean accroupir) {
        this.accroupir = accroupir;
    }

    public boolean getAccroupir() {
        return  accroupir;
    }

    public void setSauter(boolean sauter) {
        this.sauter = sauter;
    }

    public boolean getSauter() {
        return  sauter;
    }

    public void setGauche(boolean gauche) {
        this.gauche = gauche;
    }

    public boolean getGauche() {
        return  gauche;
    }

    public void setDroite(boolean droite) {
        this.droite = droite;
    }

    public boolean getDroite() {
        return  droite;
    }
}