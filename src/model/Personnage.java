package model;

import vue.Fenetre;

import java.awt.*;
import java.io.Serializable;

import static model.Jeu.GRAVITE;
import static vue.FenetreJeu.*;


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

    public Personnage(String nom, int niveau, String texture, Jeu jeu) {
        super(nom, texture);

        this.jeu = jeu;

        this.niveau = niveau;
    }

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
        // déplacement sur l'axe X
        int x = getPositionX() / TAILLE_TUILE;
        int y = (getPositionY() + hauteurBas) / TAILLE_TUILE;

        // empeche l'erreur de test la collision avec le dehors de la map soit a gauche soit à droit quand on est a l'extrimité
        if (x == 0)
            x++;
        else if (x == tailleMapX - 1)
            x--;

        if ((!(63 <= tuileInt[y - 3][x - 1] && tuileInt[y - 3][x - 1] <= 79) && getDirectionOrientation().getDirection() == Direction.GAUCHE) || (!(63 <= tuileInt[y - 3][x + 1] && tuileInt[y - 3][x + 1] <= 79) && getDirectionOrientation().getDirection() == Direction.DROITE)) {
            setPositionX(getPositionX() + getVecteurDeplacementEnX() * getVitesseDeDeplacementEnX());

            // empeche le personnage de sortir de la map en x
            if (getPositionX() < 0) setPositionX(0);
            if (getPositionX() > ZONE.width - 1) setPositionX(ZONE.width - 1);
        }
        setVecteurDeplacementEnX(0);


        // déplacement sur l'axe Y
        if (vitesseDeSaut != 0) {
            setPositionY(getPositionY() + getVitesseDeDeplacementEnY());

            x = getPositionX() / TAILLE_TUILE;
            y = (getPositionY() + hauteurBas) / TAILLE_TUILE;

            // empeche l'erreur de test la collision avec le dehors de la map en haut
            if (y - 4 <= 0)
                y += 4;

            setCollision();
            if (72 == tuileInt[y - 3][x] && 72 == tuileInt[y - 4][x] && tuileInt[y - 4][x] == tuileInt[y - 3][x]) {
                setVitesseDeDeplacementEnY(0);
            }
            if (!getCollision())
                setVitesseDeDeplacementEnY(getVitesseDeDeplacementEnY() + GRAVITE);
            else if (getCollision() && getVitesseDeDeplacementEnY() >= 0) {
                if (63 <= tuileInt[y - 2][x] && tuileInt[y - 2][x] <= 79)
                    setPositionY((y - 1) * TAILLE_TUILE - hauteurBas);
                else
                    setPositionY((y) * TAILLE_TUILE - hauteurBas);

                setVitesseDeDeplacementEnY(0);
            }

            // enmpeche le personnage de sortir de la map en y
            if (getPositionY() - hauteurHaut <= 0)
                setPositionY(hauteurHaut);
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
        degats = degats - (int) (getArmure() * 0.2);
        if (degats < 0)
            degats = 0;
        setVie(getVie() - degats);
        if (getVie() < 0)
            setVie(0);
    }

    public void recevoirSoins(int soins) {
        setVie(getVie() + soins);
        if (getVie() > getVieMax())
            setVie(getVieMax());
    }

    public Sort appelleSort(Sort sort) {
        Sort sortUtilise = null;
        sortUtilise = new Sort(sort);
        setMana(getMana() - sortUtilise.getCoutManaSpell());
        if (sortUtilise.getDegatSpell() != 0)
            sortUtilise.setDegatSpell(sortUtilise.getDegatSpell() + (int) (getDegats() * 0.5));
        else if (sortUtilise.getSoin() != 0)
            sortUtilise.setSoin(sortUtilise.getSoin() + (int) (getManaMax() * 0.25));
        sortUtilise.setPositionX(getPositionX() + (getDirectionOrientation().getDirection() == Direction.GAUCHE ? -getLargeurDevant() : getLargeurDerriere()));
        sortUtilise.setPositionY(getPositionY());
        sortUtilise.setDeplacement(true);
        sortUtilise.setDirectionOrientation(getDirectionOrientation().getDirection());
        sortUtilise.setVecteurDeplacementEnX((getDirectionOrientation().getDirection() == Direction.GAUCHE ? -1 : 1));

        return sortUtilise;
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