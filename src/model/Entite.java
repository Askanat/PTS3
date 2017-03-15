package model;

import vue.Fenetre;

import java.awt.*;

import static java.lang.Math.abs;
import static vue.FenetreJeu.TAILLE_TUILE;
import static vue.FenetreJeu.tuileInt;

/**
 * Created by bastien on 06/02/17.
 */
public class Entite {

    protected String nom, texture;

    protected int positionX, positionY;
    protected int vecteurDeplacementEnX, vecteurDeplacementEnY, vitesseDeDeplacementEnX, vitesseDeDeplacementEnY, vitesseDeSaut;
    protected int largeurDevant, largeurDerriere, hauteurHaut, hauteurBas;
    protected Direction directionOrientation;

    protected boolean descendre;

    protected boolean collision, deplacement, attaquer;

    protected Rectangle hitBoxCorps;

    public Entite(String nom, String texture) {

        this.nom = nom;
        this.texture = texture;

        vitesseDeDeplacementEnY = 0;
        vecteurDeplacementEnX = 0;
        vecteurDeplacementEnY = 0;
        directionOrientation = new Direction(Direction.DROITE);

        collision = false;
        deplacement = false;
        attaquer = false;

        hitBoxCorps = new Rectangle();
    }

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
        directionOrientation = new Direction(Direction.DROITE);

        descendre = false;

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
        int x = getPositionX() / TAILLE_TUILE;
        int y = (getPositionY() + hauteurBas) / TAILLE_TUILE;
        this.collision = !getDescendre() && (63 <= tuileInt[y - 1][x] && tuileInt[y - 1][x] <= 79);

        if (!(63 <= tuileInt[y - 1][x] && tuileInt[y - 1][x] <= 79))
            setDescendre(false);

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

    public void setDirectionOrientation(int directionOrientation) {
        this.directionOrientation.setDirection(directionOrientation);
    }

    public void deplacer() {
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

    public void setDescendre(boolean descendre) {
        this.descendre = descendre;
    }

    public boolean getDescendre() {
        return descendre;
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
                getPositionX() - (getDirectionOrientation().getDirection() == Direction.GAUCHE ? getLargeurDevant() : getLargeurDerriere()),
                getPositionY() - getHauteurHaut(),
                getLargeurDevant() + getLargeurDerriere(),
                getHauteurHaut() + getHauteurBas()
        );
        return hitBoxCorps;
    }

    public String toString() {
        return ", nom : " + nom + ", texture : " + texture + ", positionX : " + positionX + ", positionY : " + positionY +
                ", vecteurDeplacementEnX : " + vecteurDeplacementEnX + ", vecteurDeplacementEnY : " + vecteurDeplacementEnY +
                ", vitesseDeDeplacementEnX : " + vitesseDeDeplacementEnX + ", vitesseDeDeplacementEnY : " + vitesseDeDeplacementEnY +
                ", vitesseDeSaut : " + vitesseDeSaut + ", largeurDevant : " + largeurDevant + ", largeurDerriere : " + largeurDerriere +
                ", hauteurHaut : " + hauteurHaut + ", hauteurBas : " + hauteurBas + ", directionOrientation : " + directionOrientation;
    }
}
