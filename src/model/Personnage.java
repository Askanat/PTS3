package model;

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
    protected int vecteurDeplacementEnX, vecteurDeplacementEnY, vitesseDeDeplacementEnPixel;
    protected boolean sauter, dessendre;

    // Nécessaire pour gérer l'orientation d'un personnage
    public static final int GAUCHE = 0;
    public static final int DROITE = 1;

    public Personnage(String nom, int niveau, int positionX, int positionY, int vitesseDeDeplacementEnPixel) {

        this.nom = nom;
        this.niveau = niveau;

        this.positionX = positionX;
        this.positionY = positionY;
        this.vitesseDeDeplacementEnPixel = vitesseDeDeplacementEnPixel;

        vecteurDeplacementEnX = 0;
        vecteurDeplacementEnY = 0;
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

    public void deplacerADroite() {
        setVecteurDeplacementEnX(1);
    }

    public void sauter() {
        if (!dessendre)
            setVecteurDeplacementEnY(-1);
    }

    public void deplacerAGauche() {
        setVecteurDeplacementEnX(-1);
    }

    public void dessendre(boolean collision) {
        if (!collision && !sauter) {
            dessendre = true;
            setVecteurDeplacementEnY(1);
        }
        else
            dessendre = false;
    }

    public void deplacer() {
        setPositionX(getPositionX() + getVecteurDeplacementEnX() * getVitesseDeDeplacementEnPixel());
        setPositionY(getPositionY() + getVecteurDeplacementEnY() * getVitesseDeDeplacementEnPixel());
        setVecteurDeplacementEnX(0);
        setVecteurDeplacementEnY(0);
    }

    public void setSauter(boolean sauter) {
        this.sauter = sauter;
    }

    public boolean getSauter() {
        return sauter;
    }

    public void setVecteurDeplacementEnX(int x) {
        vecteurDeplacementEnX = x;
    }

    public void setVecteurDeplacementEnY(int y) {
        vecteurDeplacementEnY = y;
    }

    public int getVecteurDeplacementEnX() {
        return vecteurDeplacementEnX;
    }

    public int getVecteurDeplacementEnY() {
        return vecteurDeplacementEnY;
    }

    public int getVitesseDeDeplacementEnPixel() {
        return vitesseDeDeplacementEnPixel;
    }

    public boolean getDessendre() {
        return dessendre;
    }
}