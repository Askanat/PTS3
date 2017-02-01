package model;

/**
 * Created by leo on 23/01/17.
 */
public class Spell {

    private int degatSpell, effet_id, porteSpell, coutManaSpell, idSpell;
    private String libelleSpell, textureSpell;
    private boolean unlock;

    private int vitesseDeplacement;
    private int positionX, positionY;
    private Direction directionOrientation;

    public Spell(int idSpell, int degatSpell, int effet_id, int porteSpell, int coutManaSpell, String libelleSpell, String textureSpell, int vitesseDeplacement, boolean unlock) {
        this.idSpell = idSpell;
        this.degatSpell = degatSpell;
        this.effet_id = effet_id;
        this.porteSpell = porteSpell;
        this.coutManaSpell = coutManaSpell;
        this.libelleSpell = libelleSpell;
        this.textureSpell = textureSpell;
        this.unlock = unlock;
        this.vitesseDeplacement = vitesseDeplacement;
    }

    public int getIdSpell() {
        return idSpell;
    }

    public int getCoutManaSpell() {
        return coutManaSpell;
    }

    public int getDegatSpell() {
        return degatSpell;
    }

    public int getEffet_id() {
        return effet_id;
    }

    public int getPorteSpell() {
        return porteSpell;
    }

    public String getLibelleSpell() {
        return libelleSpell;
    }

    public String getTextureSpell() {
        return textureSpell;
    }

    public void unlockSpell() {
        unlock = true;
    }

    public int getVitesseDeplacement() {
        return vitesseDeplacement;
    }

    public void setPositionX(int positionX) {
        this.positionX = positionX;
    }

    public int getPositionX() {
        return positionX;
    }

    public void setPositionY(int positionY) {
        this.positionY = positionY;
    }

    public int getPositionY() {
        return positionY;
    }

    public void setDirectionOrientation(Direction directionOrientation) {
        this.directionOrientation = directionOrientation;
    }

    public String toString() {
        return "SPELL : idSpell : " + idSpell + " degatSpell : " + degatSpell + " effet_id : " + effet_id + " porteSpell : " + porteSpell + " coutManaSpell : " + coutManaSpell + " libelleSpell : " + libelleSpell + " textureSpell : " + textureSpell;
    }
}

