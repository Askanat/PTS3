package model;

import java.awt.*;

/**
 * Created by bastien on 29/09/16.
 */

public class Hero extends Personnage {

    int niveau;
    int experience, experienceMax;
    int or;
    int charge, chargeMax;
    int pointConstitution, pointIntelligence, pointForce, pointResistance, pointCompetence;

    public Hero(String nom, int vie, int vieMax, int degats, int positionX, int positionY, Image texture) {
        super(nom, vie, vieMax, degats, positionX, positionY, texture);
    }

    public void deplacer(int deplacementX, int deplacementY) {
        setPositionX(getPositionX() + deplacementX * 20);
        setPositionY(getPositionY() + deplacementY * 20);
    }
}
