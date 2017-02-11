package model;

import vue.Fenetre;

import java.util.ArrayList;

import static model.Jeu.GRAVITE;
import static vue.FenetreJeu.ZONE;

/**
 * Created by leo on 23/01/17.
 */
public class Sort extends Entite implements Cloneable {

    private int degatSpell, porteSpell, coutManaSpell, idSpell, tempsDeRechargement;

    private int tempsDeApparition;

    public Sort(int idSpell, int degatSpell, int largeurDevant, int largeurDerriere, int hauteurHaut, int hauteurBas, int porteSpell, int coutManaSpell, String libelleSpell, String textureSpell, int vitesseDeplacement, int tempsDeRechargement) {
        super(libelleSpell, largeurDevant, largeurDerriere, hauteurHaut, hauteurBas, textureSpell, 0, 0, vitesseDeplacement, 0);
        this.idSpell = idSpell;
        this.degatSpell = degatSpell;
        this.porteSpell = porteSpell;
        this.coutManaSpell = coutManaSpell;
        this.tempsDeRechargement = tempsDeRechargement;

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

    public boolean update(ArrayList<Monstre> cible) {
        boolean destruction = false;
        tempsDeApparition++;

        deplacer();

        for (Monstre m : cible) {
            if (collision(getHitBoxCorps(), m.getHitBoxCorps()) && tempsDeApparition >= 2) {
                m.recevoirDegats(getDegatSpell());
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

    public int getPorteSpell() {
        return porteSpell;
    }

    public int getTempsDeRechargement() {
        return tempsDeRechargement;
    }

    public String toString() {
        return super.toString() + ", SPELL : id : " + idSpell + ", degatSpell : " + degatSpell +
                ", porteSpell : " + porteSpell + ", coutManaSpell : " + coutManaSpell;
    }
}

