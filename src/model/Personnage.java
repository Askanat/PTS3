package model;

import vue.Fenetre;

import java.awt.*;
import java.io.Serializable;


/**
 * Created by bastien on 29/09/16.
 */

public abstract class Personnage extends Entite implements Serializable {

    protected int niveau;
    protected int vie, vieMax;
    protected int mana, manaMax;
    protected int degats, degatMax;
    protected int armure, armureMax;

    protected int porteeDeAttaque;
    protected int distanceDeAttaqueDeOrigineAX;
    protected int distanceDeAttaqueDeOrigineAY;

    protected Sort sortUtilise;


    public Personnage(String nom, int niveau, int largeurDevant, int largeurDerriere, int hauteurHaut, int hauteurBas, String texture,
                      int positionX, int positionY, int vitesseDeDeplacementEnX, int vitesseDeSaut, int porteeDeAttaque,
                      int distanceDeAttaqueDeOrigineAX, int distanceDeAttaqueDeOrigineAY) {
        super(nom, largeurDevant, largeurDerriere, hauteurHaut, hauteurBas, texture, positionX, positionY, vitesseDeDeplacementEnX, vitesseDeSaut);

        this.niveau = niveau;

        this.porteeDeAttaque = Fenetre.adapterResolutionEnX(porteeDeAttaque);
        this.distanceDeAttaqueDeOrigineAX = Fenetre.adapterResolutionEnX(distanceDeAttaqueDeOrigineAX);
        this.distanceDeAttaqueDeOrigineAY = Fenetre.adapterResolutionEnY(distanceDeAttaqueDeOrigineAY);
    }

    public void recevoirDegats(int degats) {

        if (degats < 0) degats = 0;

        System.out.println(getNom() + " perd " + degats + " point de vie.");

        setVie(getVie() - degats);

        if (getVie() < 0) setVie(0);
    }

    public void attaquer(Personnage cible) {
        if (collision(getHitBoxAttaque(), cible.getHitBoxCorps())) {
            cible.recevoirDegats(getDegats());
        }
    }

    public final boolean estVivant() {
        return getVie() > 0;
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

    public final int getMana() {
        return mana;
    }

    public final int getManaMax() {
        return manaMax;
    }

    public void setMana(int mana) {
        this.mana = mana;
    }

    public void setManaMax(int manaMax) {
        this.manaMax = manaMax;
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

    public Rectangle getHitBoxAttaque() {
        Rectangle r = new Rectangle();
        return r;
    }
}