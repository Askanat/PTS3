package model;

import vue.Fenetre;

import static model.Jeu.GRAVITE;
import static vue.FenetreJeu.ZONE;

/**
 * Created by leo on 23/01/17.
 */
public class Sort extends Entite implements Cloneable {

    private int degatSpell, effet_id, porteSpell, coutManaSpell, idSpell;
    private boolean unlock;

    public Sort(int idSpell, int degatSpell, int largeurDevant, int largeurDerriere, int hauteurHaut, int hauteurBas, int effet_id, int porteSpell, int coutManaSpell, String libelleSpell, String textureSpell, boolean unlock, int vitesseDeplacement) {
        super(libelleSpell, largeurDevant, largeurDerriere, hauteurHaut, hauteurBas, textureSpell, 0, 0, vitesseDeplacement, 0);
        this.idSpell = idSpell;
        this.degatSpell = degatSpell;
        this.effet_id = effet_id;
        this.porteSpell = porteSpell;
        this.coutManaSpell = coutManaSpell;
        this.unlock = unlock;
    }

    public Object clone() {
        Sort sort = null;
        try {
            sort = (Sort) super.clone();
        } catch(CloneNotSupportedException cnse) {
            cnse.printStackTrace(System.err);
        }

        return sort;
    }

    public void deplacer() {
        setPositionX(getPositionX() + getVecteurDeplacementEnX() * getVitesseDeDeplacementEnX());

        if (vitesseDeSaut != 0) {
            setPositionY(getPositionY() + getVitesseDeDeplacementEnY());

            setCollision();
            if (!getCollision())
                setVitesseDeDeplacementEnY(getVitesseDeDeplacementEnY() + GRAVITE);
            else if (getCollision()) {
                setPositionY(-Fenetre.adapterResolutionEnY(200) + ZONE.height - hauteurBas);
                setVitesseDeDeplacementEnY(0);
            }
        }
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
        return super.toString() + ", SPELL : id : " + idSpell + ", degatSpell : " + degatSpell + ", effet_id : " + effet_id +
                ", porteSpell : " + porteSpell + ", coutManaSpell : " + coutManaSpell;
    }
}

