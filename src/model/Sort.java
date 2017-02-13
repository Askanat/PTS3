package model;

import vue.Fenetre;

import java.util.ArrayList;

import static model.Jeu.GRAVITE;
import static vue.FenetreJeu.ZONE;

/**
 * Created by leo on 23/01/17.
 */

public class Sort extends Entite {

    private int degatSpell, porteSpell, coutManaSpell, idSpell, tempsDeRechargement, niveauSpell, soin;

    private int tempsDeApparition;

    public Sort(int idSpell, int degatSpell, int largeurDevant, int largeurDerriere, int hauteurHaut, int hauteurBas, int porteSpell, int coutManaSpell, String libelleSpell, String textureSpell, int vitesseDeplacement, int tempsDeRechargement, int niveauSpell, int soin) {
        super(libelleSpell, largeurDevant, largeurDerriere, hauteurHaut, hauteurBas, textureSpell, 0, 0, vitesseDeplacement, 0);
        this.idSpell = idSpell;
        this.degatSpell = degatSpell;
        this.porteSpell = porteSpell;
        this.coutManaSpell = coutManaSpell;
        this.tempsDeRechargement = tempsDeRechargement;
        this.niveauSpell = niveauSpell;
        this.soin = soin;

        tempsDeApparition = 0;

        texture = "images/Sorts/goutte_Boule.png"; // à enlever quand les sorts auront tous une texture
    }

    public Sort(Sort sort) {
        super(sort.nom, sort.texture);

        this.idSpell = sort.idSpell;
        this.degatSpell = sort.degatSpell;
        this.porteSpell = sort.porteSpell;
        this.coutManaSpell = sort.coutManaSpell;
        this.tempsDeRechargement = sort.tempsDeRechargement;
        this.niveauSpell = sort.niveauSpell;
        this.soin = sort.soin;

        this.tempsDeApparition = sort.tempsDeApparition;

        this.positionX = sort.positionX;
        this.positionY = sort.positionY;
        this.vitesseDeDeplacementEnX = sort.vitesseDeDeplacementEnX;
        this.vitesseDeSaut = sort.vitesseDeSaut;

        this.largeurDevant = sort.largeurDevant;
        this.largeurDerriere = sort.largeurDerriere;
        this.hauteurHaut = sort.hauteurHaut;
        this.hauteurBas = sort.hauteurBas;
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

    public boolean update(Personnage cible) {
        boolean destruction = false;
        tempsDeApparition++;

        deplacer();

        if (collision(getHitBoxCorps(), cible.getHitBoxCorps()) && tempsDeApparition >= 2) {
            cible.recevoirDegats(getDegatSpell());
            destruction = true;
        }

        if (tempsDeApparition >= 50)
            destruction = true;

        return destruction;
    }

    public boolean update(ArrayList<Monstre> cible, Hero h) {
        boolean destruction = false;
        tempsDeApparition++;

        deplacer();

        if (tempsDeApparition >= 2)
            if (getDegatSpell() != 0)
                for (Monstre m : cible) {
                    if (collision(getHitBoxCorps(), m.getHitBoxCorps())) {
                        m.recevoirDegats(getDegatSpell());
                        destruction = true;
                    }
                }
            else if (getSoin() != 0) {
                if (collision(getHitBoxCorps(), h.getHitBoxCorps())) {
                    h.recevoirSoins(getSoin());
                    destruction = true;
                }
            }

        if (tempsDeApparition >= 50)
            destruction = true;

        return destruction;
    }

    public int getCoutManaSpell() {
        return coutManaSpell;
    }

    public void setDegatSpell(int degatSpell) {
        this.degatSpell = degatSpell;
    }

    public int getDegatSpell() {
        return degatSpell;
    }

    public void setSoin(int soin) {
        this.soin = soin;
    }

    public int getSoin() {
        return soin;
    }

    public int getPorteSpell() {
        return porteSpell;
    }

    public int getTempsDeRechargement() {
        return tempsDeRechargement;
    }

    public String toString() {
        return super.toString() + ", SPELL : id : " + idSpell + ", degatSpell : " + degatSpell + ", soin : " + soin +
                ", porteSpell : " + porteSpell + ", coutManaSpell : " + coutManaSpell;
    }
}