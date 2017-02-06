package model;

/**
 * Created by leo on 23/01/17.
 */
public class Sort extends Entite {

    private int degatSpell, effet_id, porteSpell, coutManaSpell, idSpell;
    private boolean unlock;

    public Sort(int idSpell, int degatSpell, int effet_id, int porteSpell, int coutManaSpell, String libelleSpell, String textureSpell, boolean unlock, int vitesseDeplacement) {
        super(libelleSpell, 10, 10, 10, 10, textureSpell, 0, 0, vitesseDeplacement, vitesseDeplacement);
        this.idSpell = idSpell;
        this.degatSpell = degatSpell;
        this.effet_id = effet_id;
        this.porteSpell = porteSpell;
        this.coutManaSpell = coutManaSpell;
        this.unlock = unlock;
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

    public void unlockSpell() {
        unlock = true;
    }

    public String toString() {
        return "SPELL : id : " + idSpell + " degatSpell : " + degatSpell + " effet_id : " + effet_id + " porteSpell : " + porteSpell + " coutManaSpell : " + coutManaSpell + " nom : " + nom + " texture : " + texture;
    }
}

