package model;

/**
 * Created by bastien on 29/09/16.
 */

public class Hero extends Personnage {

    int niveau;
    int experience, experienceMax;
    int or;
    int charge, chargeMax;
    int pointConstitution, pointIntelligence, pointForce, pointResistance, pointCompetence;

    public Hero(String nom, int vie, int vieMax, int degats, int positionX, int positionY, int coefDeplacement) {
        super(nom, vie, vieMax, degats, positionX, positionY, coefDeplacement);
    }
}