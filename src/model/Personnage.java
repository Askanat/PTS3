package model;

import java.awt.*;

/**
 * Created by bastien on 29/09/16.
 */

public abstract class Personnage {


    protected String nom;

    protected int vie, vieMax;
    protected int degats;

    protected int positionX, positionY;

    protected Image texture;


    public Personnage(String nom, int vie, int vieMax, int degats, int positionX, int positionY, Image texture) {
        this.nom = nom;
        this.vie = vie;
        this.vieMax = vieMax;
        this.degats = degats;
        this.positionX = positionX;
        this.positionY = positionY;
        this.texture = texture;

        // découpe la texture et la met dans un tableau pour pouvoir faire l'animation déplacement
    }

    public void recevoirDegats(int degats) {

        if (getDegats() < 0) setDegats(0);

        System.out.println(getNom() + " perd " + getDegats() + " point de vie.");

        setVie(getVie() - getDegats());

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


}