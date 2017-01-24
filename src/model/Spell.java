package model;

/**
 * Created by leo on 23/01/17.
 */
public class Spell {

    private int degatSpell, effet_id, porteSpell, coutManaSpell, idSpell;
    private String libelleSpell, textureSpell;

    public Spell(int idSpell, int degatSpell,int effet_id, int porteSpell, int coutManaSpell, String libelleSpell, String textureSpell) {
        this.idSpell = idSpell;
        this.degatSpell = degatSpell;
        this.effet_id = effet_id;
        this.porteSpell = porteSpell;
        this.coutManaSpell = coutManaSpell;
        this.libelleSpell = libelleSpell;
        this.textureSpell = textureSpell;
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

    public String toString() {
        return "SPELL : idSpell : " + idSpell +  " degatSpell : " + degatSpell + " effet_id : " + effet_id + " porteSpell : " + porteSpell + " coutManaSpell : " + coutManaSpell + " libelleSpell : " + libelleSpell + " textureSpell : " + textureSpell;
    }
}

