package model;

import vue.Fenetre;

import static model.Jeu.GRAVITE;
import static vue.FenetreJeu.ZONE;

/**
 * Created by leo on 23/01/17.
 */
public class Sort extends Entite {

    private int degatSpell, effet_id, porteSpell, coutManaSpell, idSpell;
    private boolean unlock;

    public Sort(int idSpell, int degatSpell, int effet_id, int porteSpell, int coutManaSpell, String libelleSpell, String textureSpell, boolean unlock, int vitesseDeplacement) {
        super(libelleSpell, 10, 10, 10, 10, textureSpell, 0, 0, vitesseDeplacement, 0);
        this.idSpell = idSpell;
        this.degatSpell = degatSpell;
        this.effet_id = effet_id;
        this.porteSpell = porteSpell;
        this.coutManaSpell = coutManaSpell;
        this.unlock = unlock;
    }

    public Sort(Sort s) {
        super(s.nom, 10, 10, 10, 10, s.texture, 0, 0, s.vitesseDeDeplacementEnX, 0);
        this.idSpell = s.idSpell;
        this.degatSpell = s.degatSpell;
        this.effet_id = s.effet_id;
        this.porteSpell = s.porteSpell;
        this.coutManaSpell = s.coutManaSpell;
        this.unlock = s.unlock;
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

