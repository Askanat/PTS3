package model;

import vue.Fenetre;

import java.awt.*;

import static java.lang.Math.abs;
import static model.Jeu.GRAVITE;
import static model.Jeu.ZONE_SAFE;
import static vue.Fenetre.Y;


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
    protected String texture;

    protected Rectangle hitBoxCorps;

    protected int porteeDeAttaque;
    protected int distanceDeAttaqueDeOrigineAX;
    protected int distanceDeAttaqueDeOrigineAY;


    public Personnage(String nom, int niveau, int largeurDevant, int largeurDerriere, int hauteurHaut, int hauteurBas, String texture,
                      int positionX, int positionY, int vitesseDeDeplacementEnX, int vitesseDeSaut, int porteeDeAttaque,
                      int distanceDeAttaqueDeOrigineAX, int distanceDeAttaqueDeOrigineAY) {

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

        this.texture = texture;

        hitBoxCorps = new Rectangle();

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
            setPositionY(Fenetre.adapterResolutionEnY((int) (945 * 1.5)) - hauteurBas); // ZONE_SAFE.height - (int) (Y / 1.5))
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
        this.collision = getPositionY() >= Fenetre.adapterResolutionEnY((int) (945 * 1.5)) - hauteurBas; // sol de la fenetre - la hauteur du personnage - la hauteur de parterre
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

    public String getTexture() {
        return texture;
    }

    public int getLargeurDerriere() {
        return largeurDerriere;
    }

    public int getLargeurDevant() {
        return largeurDevant;
    }

    public int getHauteurBas() {
        return hauteurBas;
    }

    public int getHauteurHaut() {
        return hauteurHaut;
    }

    public boolean collision(Rectangle A, Rectangle B) {
        return (abs((A.getLocation().x + (A.getSize().width / 2)) - (B.getLocation().x + (B.getSize().width / 2))) <
                (A.getSize().width + B.getSize().width) / 2)
                &&
                (abs((A.getLocation().y + (A.getSize().height / 2)) - (B.getLocation().y + (B.getSize().height / 2))) <
                        (A.getSize().height + B.getSize().height) / 2);
    }

    public Rectangle getHitBoxAttaque() {
        Rectangle r = new Rectangle(
                positionX + (getDirectionOrientation() == Direction.GAUCHE ? -(distanceDeAttaqueDeOrigineAX + porteeDeAttaque) : distanceDeAttaqueDeOrigineAX),
                positionY - distanceDeAttaqueDeOrigineAY,
                porteeDeAttaque,
                porteeDeAttaque
        );
        return r;
    }

    public Rectangle getHitBoxCorps() {
        hitBoxCorps = new Rectangle(
                getPositionX() - (getDirectionOrientation() == Direction.GAUCHE ? getLargeurDevant() : getLargeurDerriere()),
                getPositionY() - getHauteurHaut(),
                getLargeurDevant() + getLargeurDerriere(),
                getHauteurHaut() + getHauteurBas()
        );
        return hitBoxCorps;
    }
}