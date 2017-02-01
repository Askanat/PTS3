package model;

/**
 * Created by leo on 02/10/16.
 */

public class Equipement {

    private String nom;
    private float armure;
    private float pointConstitution, pointIntelligence, pointForce, pointResistance, degat;
    int typeItem;
    String texture;

    public Equipement() {

    }

    public Equipement(String nom, float armure, float pointConstitution, float pointIntelligence, float pointForce, float pointResistance, float degat, String texture, int typeItem) {
        this.pointConstitution = pointConstitution;
        this.pointForce = pointForce;
        this.pointIntelligence = pointIntelligence;
        this.pointResistance = pointResistance;
        this.nom = nom;
        this.armure = armure;
        this.typeItem = typeItem;
        this.degat = degat;
        this.texture = texture;
    }
}
