package model;

/**
 * Created by leo on 02/10/16.
 */

public class Equipement {

    private String nom;
    private float armure;
    private float pointConstitution, pointIntelligence, pointForce, pointResistance, degat;
    int typeItem, idItem;
    String texture;

    public Equipement(int idItem, String nom, float armure, float pointConstitution, float pointIntelligence, float pointForce, float pointResistance, float degat, String texture, int typeItem) {
        this.pointConstitution = pointConstitution;
        this.pointForce = pointForce;
        this.pointIntelligence = pointIntelligence;
        this.pointResistance = pointResistance;
        this.nom = nom;
        this.armure = armure;
        this.typeItem = typeItem;
        this.degat = degat;
        this.texture = texture;
        this.idItem =  idItem;
    }

    public float getArmure() {
        return armure;
    }

    public float getPointConstitution() {
        return pointConstitution;
    }

    public float getDegat() {
        return degat;
    }

    public float getPointForce() {
        return pointForce;
    }

    public float getPointIntelligence() {
        return pointIntelligence;
    }

    public float getPointResistance() {
        return pointResistance;
    }

    public int getTypeItem() {
        return typeItem;
    }

    public String getNom() {
        return nom;
    }

    public String getTexture() {
        return texture;
    }

    public int getIdItem() {
        return idItem;
    }
}
