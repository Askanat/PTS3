package model;

/**
 * Created by leo on 24/01/17.
 */
public class Effet {

    private int duree, degatParSec, idEffet;
    private String libelleEffet, textureEffet;

    public Effet(int idEffet, String libelleEffet, int duree, int degatParSec, String textureEffet) {
        this.idEffet = idEffet;
        this.libelleEffet = libelleEffet;
        this.duree = duree;
        this.degatParSec = degatParSec;
        this.textureEffet = textureEffet;
    }

    public int getIdEffet() {
        return idEffet;
    }

    public int getDuree() {
        return duree;
    }

    public int getDegatParSec() {
        return degatParSec;
    }

    public String getLibelleEffet() {
        return libelleEffet;
    }

    public String getTextureEffet() {
        return textureEffet;
    }

    public String toString() {
        return "Effet : idEffet : " + idEffet + " libelleEffet : " + libelleEffet + " duree : " + duree + " degatParSec : " + degatParSec + " textureEffet : " + textureEffet;
    }
}
