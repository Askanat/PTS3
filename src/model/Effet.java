package model;

/**
 * Created by leo on 24/01/17.
 */
public class Effet extends Entite {

    private int duree, degatParSec, idEffet;

    public Effet(int idEffet, String libelleEffet, int duree, int degatParSec, String textureEffet) {
        super(libelleEffet, 10, 10, 10, 10, textureEffet, 0, 0, 0, 0);
        this.idEffet = idEffet;
        this.duree = duree;
        this.degatParSec = degatParSec;
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

    public String toString() {
        return "Effet : id : " + idEffet + " nom : " + nom + " duree : " + duree + " degatParSec : " + degatParSec + " texture : " + texture;
    }
}
