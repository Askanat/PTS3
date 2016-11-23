package model;

import vue.Fenetre;

import static model.Jeu.GRAVITE;


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

    // A ameliorer
    public void attaquer(Personnage cible) {
        // Le personnage ne touchera pas vraiment le monstre, il y aura un petit espace

        int portee = Fenetre.adapterResolutionEnX(1);
        int largeur = Fenetre.adapterResolutionEnX(200), hauteur = Fenetre.adapterResolutionEnY(200);


        // Si l'ennemi n'est pas trop haut et n'est pas trop bas

        if(!(cible.positionY > positionY + hauteur) && !(cible.positionY + hauteur < positionY)) {

            /* Les deux lignes du if :
            *  1. Si la cible n'est pas trop à gauche et n'est pas trop à droite
            *  2. Si la cible est sur la gauche et que le personnage est tourné vers la gauche
            *     ou si la cible est sur la droite et que le personnage est tourné vers la droite
            *
            *  Alors on inflige des dégâts
            */

            if(!(cible.positionX + largeur < positionX - portee) && !(cible.positionX > positionX + largeur + portee) &&
              ((cible.positionX < positionX && direction == Direction.GAUCHE) || (cible.positionX > positionX && direction == Direction.DROITE))) {
                cible.recevoirDegats(getDegats());
                System.out.println(getNom() + " attaque " + cible.getNom() + " !; posX = " + positionX + "; posY = " + positionY);
            }
        }
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
            setPositionY(Fenetre.adapterResolutionEnY(700));
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
        this.collision = getPositionY() >= Fenetre.adapterResolutionEnY(700);
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