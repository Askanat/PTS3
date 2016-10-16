package model;

import vue.Entite;

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
    protected int deplacementEnX, deplacementEnY, coefDeplacement;

    // Nécessaire pour gérer l'orientation d'un personnage
    public static final int GAUCHE = 0;
    public static final int DROITE = 1;

    public Personnage(String nom, int niveau, int positionX, int positionY, int coefDeplacement) {

        this.nom = nom;
        this.niveau = niveau;

        this.positionX = positionX;
        this.positionY = positionY;
        this.coefDeplacement = coefDeplacement;

        deplacementEnX = 0;
        deplacementEnY = 0;
    }

    public void recevoirDegats(int degats) {

        if (degats < 0) degats = 0;

        System.out.println(getNom() + " perd " + degats + " point de vie.");

        setVie(getVie() - degats);

        if (getVie() < 0) setVie(0);
    }

    public void attaquer(Personnage cible) {
        System.out.println(getNom() + " attaque " + cible.getNom() + " !");
        cible.recevoirDegats(getDegats());
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

    public void dessendre() {
        setDeplacementEnY(1);
    }

    public void deplacerADroite() {
        setDeplacementEnX(1);
    }

    public void sauter() {
        setDeplacementEnY(-1);
    }

    public void deplacerAGauche() {
        setDeplacementEnX(-1);
    }

    public void deplacer() {
        setPositionX(getPositionX() + getDeplacementEnX() * getCoefDeplacement());
        setPositionY(getPositionY() + getDeplacementEnY() * getCoefDeplacement());
        setDeplacementEnX(0);
        setDeplacementEnY(0);
    }

    public void setDeplacementEnX(int x) {
        deplacementEnX = x;
    }

    public void setDeplacementEnY(int y) {
        deplacementEnY = y;
    }

    public int getDeplacementEnX() {
        return deplacementEnX;
    }

    public int getDeplacementEnY() {
        return deplacementEnY;
    }

    public int getCoefDeplacement() {
        return coefDeplacement;
    }
}