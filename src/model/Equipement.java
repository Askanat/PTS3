package model;

/**
 * Created by leo on 02/10/16.
 */

public class Equipement {

    String nom;
    int armure;
    int pointConstitution, pointIntelligence, pointForce, pointResistance;

    public Equipement() {

    }

    public Equipement(String nom, int armure, int pointConstitution, int pointIntelligence, int pointForce, int pointResistance) {
        this.pointConstitution = pointConstitution;
        this.pointForce = pointForce;
        this.pointIntelligence = pointIntelligence;
        this.pointResistance = pointResistance;
        this.nom = nom;
        this.armure = armure;
    }
}
