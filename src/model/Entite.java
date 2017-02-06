package model;

import vue.Fenetre;

import java.awt.*;

import static java.lang.Math.abs;
import static model.Jeu.GRAVITE;
import static vue.FenetreJeu.ZONE;

/**
 * Created by bastien on 06/02/17.
 */
public class Entite {

    protected String nom, texture;

    protected int positionX, positionY;
    protected int vecteurDeplacementEnX, vecteurDeplacementEnY, vitesseDeDeplacementEnX, vitesseDeDeplacementEnY, vitesseDeSaut;
    protected int largeurDevant, largeurDerriere, hauteurHaut, hauteurBas;
    protected Direction directionOrientation;

    protected boolean collision, deplacement, attaquer;

    protected Rectangle hitBoxCorps;

    public Entite(String nom, int largeurDevant, int largeurDerriere, int hauteurHaut, int hauteurBas, String texture,
                  int positionX, int positionY, int vitesseDeDeplacementEnX, int vitesseDeSaut) {

        this.nom = nom;
        this.texture = texture;

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
        attaquer = false;

        this.largeurDevant = Fenetre.adapterResolutionEnX(largeurDevant);
        this.largeurDerriere = Fenetre.adapterResolutionEnX(largeurDerriere);
        this.hauteurHaut = Fenetre.adapterResolutionEnY(hauteurHaut);
        this.hauteurBas = Fenetre.adapterResolutionEnY(hauteurBas);

        hitBoxCorps = new Rectangle();
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public final String getNom() {
        return nom;
    }

    public String getTexture() {
        return texture;
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

    public void setDeplacement(boolean deplacement) {
        this.deplacement = deplacement;
    }

    public boolean getDeplacement() {
        return deplacement;
    }

    public void setCollision() {
        this.collision = getPositionY() >= -Fenetre.adapterResolutionEnY(200) + ZONE.height - hauteurBas;
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

    public Direction getDirectionOrientation() {
        return directionOrientation;
    }

    public void setDirectionOrientation(Direction directionOrientation) {
        this.directionOrientation = directionOrientation;
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
            setPositionY(-Fenetre.adapterResolutionEnY(200) + ZONE.height - hauteurBas);
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

    public boolean collision(Rectangle A, Rectangle B) {
        return (abs((A.getLocation().x + (A.getSize().width / 2)) - (B.getLocation().x + (B.getSize().width / 2))) <
                (A.getSize().width + B.getSize().width) / 2)
                &&
                (abs((A.getLocation().y + (A.getSize().height / 2)) - (B.getLocation().y + (B.getSize().height / 2))) <
                        (A.getSize().height + B.getSize().height) / 2);
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
