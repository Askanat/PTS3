package model;

import vue.Fenetre;

import static model.Jeu.GRAVITE;


/**
 * Created by bastien on 29/09/16.
 */

public abstract class Personnage {
    protected String nom;
    protected int niveau;
    protected int vie, vieMax;
    protected int mana, manaMax;
    protected int degats, degatMax;
    protected int armure, armureMax;
    protected int positionX, positionY;
    protected int vecteurDeplacementEnX, vecteurDeplacementEnY, vitesseDeDeplacementEnX, vitesseDeDeplacementEnY, vitesseDeSaut;
    protected boolean collision, deplacement;
    protected boolean attaquer;
    protected int largeurDevant, largeurDerriere, hauteurHaut, hauteurBas;
    protected Direction directionOrientation;

    public Personnage(String nom, int niveau, int largeurDevant, int largeurDerriere, int hauteurHaut, int hauteurBas, int positionX, int positionY, int vitesseDeDeplacementEnX, int vitesseDeSaut) {

        this.nom = nom;
        this.niveau = niveau;

        this.positionX = Fenetre.adapterResolutionEnX(positionX);
        this.positionY = Fenetre.adapterResolutionEnY(positionY);
        this.vitesseDeDeplacementEnX = Fenetre.adapterResolutionEnX(vitesseDeDeplacementEnX);
        this.vitesseDeSaut = Fenetre.adapterResolutionEnY(vitesseDeSaut);
        vitesseDeDeplacementEnY = 0;
        vecteurDeplacementEnX = 0;
        vecteurDeplacementEnY = 0;
        directionOrientation = null;
        collision = false;
        deplacement = false;

        this.largeurDevant = Fenetre.adapterResolutionEnX(largeurDevant);
        this.largeurDerriere = Fenetre.adapterResolutionEnX(largeurDerriere);
        this.hauteurHaut = Fenetre.adapterResolutionEnY(hauteurHaut);
        this.hauteurBas = Fenetre.adapterResolutionEnY(hauteurBas);

        attaquer = false;
    }

    public void recevoirDegats(int degats) {

        if (degats < 0) degats = 0;

        System.out.println(getNom() + " perd " + degats + " point de vie.");

        setVie(getVie() - degats);

        if (getVie() < 0) setVie(0);
    }

    // A ameliorer
    public void attaquer(Personnage cible) {
        // Le personnage ne touchera pas vraiment le monstre, il y aura un petit espace

        int portee = Fenetre.adapterResolutionEnX(1);

        // Si l'ennemi n'est pas trop haut et n'est pas trop bas

        if (cible.positionY <= positionY + hauteurBas && cible.positionY >= positionY - cible.hauteurHaut) {

            /* Les deux lignes du if :
            *  1. Si la cible n'est pas trop à gauche et n'est pas trop à droite
            *  2. Si la cible est sur la gauche et que le personnage est tourné vers la gauche
            *     ou si la cible est sur la droite et que le personnage est tourné vers la droite
            *
            *  Alors on inflige des dégâts
            */

           /* if (!(cible.positionX + cible.largeur < positionX - portee) && !(cible.positionX > positionX + largeur + portee) &&
                    ((cible.positionX < positionX && directionOrientation == Direction.GAUCHE) || (cible.positionX > positionX && directionOrientation == Direction.DROITE))) {
                cible.recevoirDegats(getDegats());
                System.out.println(getNom() + " attaque " + cible.getNom() + " !; posX = " + positionX + "; posY = " + positionY);
            }*/
        }
    }

    public final boolean estVivant() {
        return getVie() > 0;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public final String getNom() {
        return nom;
    }

    public void setNiveau(int niveau) {
        this.niveau = niveau;
    }

    public int getNiveau() {
        return niveau;
    }

    public void setVie(int vie) {
        this.vie = vie;
    }

    public final int getVie() {
        return vie;
    }

    public void setVieMax(int vieMax) {
        this.vieMax = vieMax;
    }

    public final int getVieMax() {
        return vieMax;
    }

    public void setDegats(int degats) {
        this.degats = degats;
    }

    public final int getDegats() {
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
        setDirectionOrientation(Direction.DROITE);
        setVecteurDeplacementEnX(1);
    }

    public void sauter() {
        if (getCollision()) setVitesseDeDeplacementEnY(0 - vitesseDeSaut);
    }

    public void deplacerAGauche() {
        setDeplacement(true);
        setDirectionOrientation(Direction.GAUCHE);
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
            setPositionY(Fenetre.adapterResolutionEnY(1000) - hauteurBas);
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
        this.collision = getPositionY() >= Fenetre.adapterResolutionEnY(1000) - hauteurBas; // sol de la fenetre - la hauteur du personnage - la hauteur de parterre
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

    public Direction getDirectionOrientation() {
        return directionOrientation;
    }

    public void setDirectionOrientation(Direction directionOrientation) {
        this.directionOrientation = directionOrientation;
    }

    public void setDeplacement(boolean deplacement) {
        this.deplacement = deplacement;
    }

    public boolean getDeplacement() {
        return deplacement;
    }
}