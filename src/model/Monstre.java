package model;

import vue.Fenetre;

import java.awt.*;

/**
 * Created by bastien on 29/09/16.
 */

public class Monstre extends Personnage {

    private double coeffVie;
    private double coeffMana;
    private double coeffDegat;
    private double coeffArmure;
    private int distanceVisibilite;

    private int temps, TEMPS;
    private boolean mouvementAleatoire, mouvementAleatoireDirection;
    private int nbDeDeplacement, NB_DE_DEPLACEMENT;
    private Rectangle hitBoxVue;

    public Monstre(String nom, int niveau, int largeurDevant, int largeurDerriere, int hauteurHaut, int hauteurBas, double coeffArmure, double coeffVie, double coeffMana, double coeffDegat,
                   String texture, int positionX, int positionY, int vitesseDeDeplacementEnPixelX, int vitesseDeDeplacementEnPixelY, int distanceVisibilite) {

        super(nom, niveau, largeurDevant, largeurDerriere, hauteurHaut, hauteurBas, texture, positionX, positionY, vitesseDeDeplacementEnPixelX, vitesseDeDeplacementEnPixelY, 0, 0, 0);

        vieMax = (int) (coeffVie * niveau);
        vie = vieMax;

        manaMax = (int) (coeffMana * niveau);
        mana = manaMax;

        degatMax = (int) (coeffDegat * niveau);
        degats = degatMax;

        armureMax = (int) (coeffArmure * niveau);
        armure = armureMax;

        this.coeffVie = coeffVie;
        this.coeffMana = coeffMana;
        this.coeffDegat = coeffDegat;
        this.coeffArmure = coeffArmure;

        this.distanceVisibilite = Fenetre.adapterResolutionEnX(distanceVisibilite);

        directionOrientation = Direction.GAUCHE;

        temps = 0;
        TEMPS = (int) (100 + (Math.random() * (300 - 100)));
        nbDeDeplacement = 0;
        NB_DE_DEPLACEMENT = (int) (3 + (Math.random() * (7 - 3)));
        mouvementAleatoire = false;
        mouvementAleatoireDirection = false;

        hitBoxVue = new Rectangle();
        System.out.println("nom:" + nom + ", niveau:" + niveau + ", vieMax:" + vieMax + ", manaMax:" + manaMax + ", degatMax:" +
                degatMax + ", armureMax:" + armureMax + ", xpdonne: " + donneExperience());
    }

    public int donneExperience() {
        return (int) (niveau * (coeffArmure + coeffDegat + coeffMana + coeffVie));
    }

    public void update(Hero hero) {
        // Si le hero est dans le champs de vision du monstre
        if (collision(getHitBoxVue(), hero.getHitBoxCorps())) {
            // déplacement
            if (positionY - hauteurHaut > hero.positionY + hero.hauteurBas) // si le héro est plus haut que le monstre
                sauter();
            if (positionX < hero.positionX && !collision(getHitBoxCorps(), hero.getHitBoxCorps())) // si le héro est à droite
                deplacerADroite();
            else if (positionX > hero.positionX && !collision(getHitBoxCorps(), hero.getHitBoxCorps())) // si héro est à gauche
                deplacerAGauche();

            temps = 0;
        } else { // le héro est pas dans le champs de vision du mosntre
            temps++;
            if (temps % TEMPS == 0)
                mouvementAleatoire = true;

            if (mouvementAleatoire) {
                if (nbDeDeplacement == 0)
                    mouvementAleatoireDirection = getDirectionOrientation() == Direction.GAUCHE;
                if (mouvementAleatoireDirection)
                    deplacerADroite();
                else
                    deplacerAGauche();

                nbDeDeplacement++;
            }
            if (nbDeDeplacement == NB_DE_DEPLACEMENT) {
                nbDeDeplacement = 0;
                temps = 0;
                mouvementAleatoire = false;
            }
        }
    }

    public void upgrade() {
        deplacer();
    }


    public int getDistanceVisibilite() {
        return distanceVisibilite;
    }

    public Rectangle getHitBoxVue() {
        hitBoxVue = new Rectangle(
                getPositionX() - (getDirectionOrientation() == Direction.GAUCHE ? getLargeurDevant() : getLargeurDerriere()) - getDistanceVisibilite(),
                getPositionY() - getHauteurHaut() - getDistanceVisibilite(),
                getLargeurDevant() + getLargeurDerriere() + getDistanceVisibilite() + getDistanceVisibilite(),
                getHauteurHaut() + getDistanceVisibilite() + getHauteurBas() + getDistanceVisibilite()
        );

        return hitBoxVue;
    }
}
