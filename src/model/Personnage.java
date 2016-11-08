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
    protected int vecteurDeplacementEnX, vecteurDeplacementEnY, vitesseDeDeplacementEnPixelX, vitesseDeDeplacementEnPixelY;
    protected boolean sauter, dessendre;
    protected boolean collision;

    // Nécessaire pour gérer l'orientation d'un personnage
    public static final int GAUCHE = 0;
    public static final int DROITE = 1;

    public Personnage(String nom, int niveau, int positionX, int positionY, int vitesseDeDeplacementEnPixelX, int vitesseDeDeplacementEnPixelY) {

        this.nom = nom;
        this.niveau = niveau;

        this.positionX = positionX;
        this.positionY = positionY;
        this.vitesseDeDeplacementEnPixelX = vitesseDeDeplacementEnPixelX;
        this.vitesseDeDeplacementEnPixelY = vitesseDeDeplacementEnPixelY;
        collision = false;
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
        int portee = 5;

        /* Il faut gérer l'orientation du Personnage
         * Pas fonctionnel pour le moment.
         */

        if((positionX - portee >= cible.positionX)||
        (positionX + portee <= cible.positionX ))
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
        setCollision(collision);
        if (!getCollision() && !sauter) {
            setDessendre(true);
            setVecteurDeplacementEnY(1);
        } else if (getDessendre()) {
            dessendre = false;
        }
    }

    public void deplacer() {
        setPositionX(getPositionX() + getVecteurDeplacementEnX() * getVitesseDeDeplacementEnPixelX());
        setPositionY(getPositionY() + getVecteurDeplacementEnY() * getVitesseDeDeplacementEnPixelY());
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

    public int getVitesseDeDeplacementEnPixelX() {
        return vitesseDeDeplacementEnPixelX;
    }
    public int getVitesseDeDeplacementEnPixelY() {
        return vitesseDeDeplacementEnPixelY;
    }

    public boolean getDessendre() {
        return dessendre;
    }

    public void setDessendre(boolean dessendre) {
        this.dessendre = dessendre;
    }

    public void setCollision(boolean collision) {
        this.collision = collision;
    }

    public boolean getCollision() {
        return collision;
    }
}