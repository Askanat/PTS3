package model;

import vue.Fenetre;

import java.awt.*;
import java.io.Serializable;

import static model.Jeu.GRAVITE;
import static vue.FenetreJeu.ZONE;


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

    protected int tempsRegeneration = 10, temps;

    protected Jeu jeu;


    public Personnage(String nom, int niveau, int largeurDevant, int largeurDerriere, int hauteurHaut, int hauteurBas, String texture,
                      int positionX, int positionY, int vitesseDeDeplacementEnX, int vitesseDeSaut, int porteeDeAttaque,
                      int distanceDeAttaqueDeOrigineAX, int distanceDeAttaqueDeOrigineAY, Jeu jeu) {
        super(nom, largeurDevant, largeurDerriere, hauteurHaut, hauteurBas, texture, positionX, positionY, vitesseDeDeplacementEnX, vitesseDeSaut);

        this.jeu = jeu;

        this.niveau = niveau;

        this.porteeDeAttaque = Fenetre.adapterResolutionEnX(porteeDeAttaque);
        this.distanceDeAttaqueDeOrigineAX = Fenetre.adapterResolutionEnX(distanceDeAttaqueDeOrigineAX);
        this.distanceDeAttaqueDeOrigineAY = Fenetre.adapterResolutionEnY(distanceDeAttaqueDeOrigineAY);
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
        setVecteurDeplacementEnX(0);

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

        setDeplacement(false);
    }

    public void regenerationMana() {
        setVie(getVie() + ((int) (getVieMax() * 0.01) > 1 ? ((int) (getVieMax() * 0.01)) : 1));

        if (getVie() > getVieMax())
            setVie(getVieMax());
    }

    public void regenerationVie() {
        setMana(getMana() + ((int) (getManaMax() * 0.02) > 1 ? ((int) (getManaMax() * 0.02)) : 1));

        if (getMana() > getManaMax())
            setMana(getManaMax());
    }

    public void recevoirDegats(int degats) {
        System.out.println(getNom() + " LVL :" + getNiveau() + " armure : " + getArmure() + ", perd " + degats + " - " + (int) (getArmure() * 0.2) + " point de vie.");

        degats = degats - (int) (getArmure() * 0.2);
        if (degats < 0)
            degats = 0;
        setVie(getVie() - degats);
        if (getVie() < 0)
            setVie(0);
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

    public void setArmure(int armure) {
        this.armure = armure;
    }

    public int getArmure() {
        return armure;
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

    public String toString() {
        return super.toString() + ", niveau : " + niveau + ", vie : " + vie + ", vieMax : " + vieMax + ", mana : " + mana + ", manaMax : " + manaMax +
                ", degats : " + degats + ", degatMax : " + degatMax + ", armure : " + armure + ", armureMax : " + armureMax +
                ", porteeDeAttaque : " + porteeDeAttaque + ", distanceDeAttaqueDeOrigineAX : " + distanceDeAttaqueDeOrigineAX +
                ", distanceDeAttaqueDeOrigineAY : " + distanceDeAttaqueDeOrigineAY;
    }

    public Rectangle getHitBoxAttaque() {
        Rectangle r = new Rectangle();
        return r;
    }
}