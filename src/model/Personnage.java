package model;

import static model.Jeu.GRAVITE;
import static model.Jeu.Y;

/**
 * Created by bastien on 29/09/16.
 */

public abstract class Personnage {


    protected String nom;
    protected int niveau;
    protected double vie, vieMax;
    protected double mana, manaMax;
    protected double degats, degatMax;
    protected double armure, armureMax;
    protected int positionX, positionY;
    protected int vecteurDeplacementEnX, vecteurDeplacementEnY, vitesseDeDeplacementEnX, vitesseDeDeplacementEnY, vitesseDeSaut;
    protected boolean collision, deplacement;
    protected boolean attaquer;

    // Nécessaire pour gérer l'orientation d'un personnage
    protected Direction direction;

    public Personnage(String nom, int niveau, int positionX, int positionY, int vitesseDeDeplacementEnX, int vitesseDeSaut) {

        this.nom = nom;
        this.niveau = niveau;

        this.positionX = positionX;
        this.positionY = positionY;
        this.vitesseDeDeplacementEnX = vitesseDeDeplacementEnX;
        this.vitesseDeSaut = vitesseDeSaut;
        direction = null;
        collision = false;
        attaquer = false;
        deplacement = false;
        vitesseDeDeplacementEnY = 0;
        vecteurDeplacementEnX = 0;
        vecteurDeplacementEnY = 0;
    }

    public void recevoirDegats(double degats) {

        if (degats < 0) degats = 0;

        System.out.println(getNom() + " perd " + degats + " point de vie.");

        setVie(getVie() - degats);

        if (getVie() < 0) setVie(0);
    }

    public void attaquer(Personnage cible) {
        int portee = 5;

        /* Il faut gérer l'orientation du Personnage
         * Pas fonctionnel pour le moment.
         */

        if ((positionX - portee >= cible.positionX) ||
                (positionX + portee <= cible.positionX))
            cible.recevoirDegats(getDegats());

        System.out.println(getNom() + " attaque " + cible.getNom() + " !");
    }

    public final boolean estVivant() {
        return getVie() > 0 ? true : false;
    }

    public void setNom(String nom) {
        this.nom = new String(nom);
    }

    public final String getNom() {
        return nom;
    }

    public void setVie(double vie) {
        this.vie = vie;
    }

    public final double getVie() {
        return vie;
    }

    public void setVieMax(int vieMax) {
        this.vieMax = vieMax;
    }

    public final double getVieMax() {
        return vieMax;
    }

    public void setDegats(int degats) {
        this.degats = degats;
    }

    public final double getDegats() {
        return degats;
    }

    public void setPositionX(int positionX) {
        this.positionX = positionX;
    }

    public final int getPositionX() {
        return positionX;
    }

    public void setPositionY(int positionY) {
        this.positionY = positionY;
    }

    public final int getPositionY() {
        return positionY;
    }


    public void afficherEtat() {
        System.out.println(

                "nom : " + nom +
                        ", vie : " + vie +
                        ", vieMax : " + vieMax +
                        ", degats : " + degats +
                        ", positionX : " + positionX +
                        ", positionY : " + positionY
        );
    }

    public void deplacerADroite() {
        setDeplacement(true);
        setDirection(Direction.DROITE);
        setVecteurDeplacementEnX(1);
    }

    public void sauter() {
        if (getCollision()) setVitesseDeDeplacementEnY(0 - vitesseDeSaut);
    }

    public void deplacerAGauche() {
        setDeplacement(true);
        setDirection(Direction.GAUCHE);
        setVecteurDeplacementEnX(-1);
    }

    public void deplacer() {
        setPositionX(getPositionX() + getVecteurDeplacementEnX() * getVitesseDeDeplacementEnX());
        setPositionY(getPositionY() + getVitesseDeDeplacementEnY());
        setVecteurDeplacementEnX(0);

        setCollision();

        if (!getCollision())
            setVitesseDeDeplacementEnY(getVitesseDeDeplacementEnY() + GRAVITE);
        else if (getCollision()) {
            setPositionY((int) (35 / 54.0 * Y));
            setVitesseDeDeplacementEnY(0);
        }

        setDeplacement(false);
    }

    public void setVecteurDeplacementEnX(int x) {
        vecteurDeplacementEnX = x;
    }

    public int getVecteurDeplacementEnX() {
        return vecteurDeplacementEnX;
    }

    public void setVitesseDeDeplacementEnY(int vitesseDeDeplacementEnY) {
        this.vitesseDeDeplacementEnY = vitesseDeDeplacementEnY;
    }

    public int getVitesseDeDeplacementEnX() {
        return vitesseDeDeplacementEnX;
    }

    public int getVitesseDeDeplacementEnY() {
        return vitesseDeDeplacementEnY;
    }

    public void setCollision() {
        this.collision = getPositionY() >= (int) (35 / 54.0 * Y);
    }

    public boolean getCollision() {
        return collision;
    }

    public boolean getAttaquer() {
        return attaquer;
    }

    public void setAttaquer(boolean attaquer) {
        this.attaquer = attaquer;
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public void setDeplacement(boolean deplacement) {
        this.deplacement = deplacement;
    }

    public boolean getDeplacement() {
        return deplacement;
    }
}