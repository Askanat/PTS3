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

    private Sort sort;

    private BDD bdd;

    private int tempsAttaque;
    private int tempsDeplacement, TEMPS_DEPLACEMENT;
    private boolean mouvementAleatoire, mouvementAleatoireDirection;
    private int nbDeDeplacement, NB_DE_DEPLACEMENT;
    private Rectangle hitBoxVue;

    public Monstre(String nom, int niveau, int largeurDevant, int largeurDerriere, int hauteurHaut, int hauteurBas, double coeffArmure, double coeffVie, double coeffMana, double coeffDegat,
                   String texture, int positionX, int positionY, int vitesseDeDeplacementEnPixelX, int vitesseDeDeplacementEnPixelY, int distanceVisibilite, Sort sort, Jeu jeu) {

        super(nom, niveau, largeurDevant, largeurDerriere, hauteurHaut, hauteurBas, texture, positionX, positionY, vitesseDeDeplacementEnPixelX, vitesseDeDeplacementEnPixelY, 0, 0, 0, jeu);

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

        this.sort = sort;

        directionOrientation = new Direction(Direction.GAUCHE);

        tempsAttaque = 0;
        tempsDeplacement = 0;
        TEMPS_DEPLACEMENT = (int) (100 + (Math.random() * (300 - 100)));
        nbDeDeplacement = 0;
        NB_DE_DEPLACEMENT = (int) (3 + (Math.random() * (7 - 3)));
        mouvementAleatoire = false;
        mouvementAleatoireDirection = false;

        bdd = new BDD();

        hitBoxVue = new Rectangle();
    }

    public Monstre(Monstre monstre) {
        super(monstre.nom, monstre.niveau, monstre.texture, monstre.jeu);

        this.vieMax = monstre.vieMax;
        this.vie = monstre.vie;

        this.manaMax = monstre.manaMax;
        this.mana = monstre.mana;

        this.degatMax = monstre.degatMax;
        this.degats = monstre.degats;

        this.armureMax = monstre.armureMax;
        this.armure = monstre.armure;

        this.coeffVie = monstre.coeffVie;
        this.coeffMana = monstre.coeffMana;
        this.coeffDegat = monstre.coeffDegat;
        this.coeffArmure = monstre.coeffArmure;

        this.distanceVisibilite = monstre.distanceVisibilite;

        this.sort = monstre.sort;

        this.directionOrientation = monstre.directionOrientation;

        this.tempsAttaque = monstre.tempsAttaque;
        this.tempsDeplacement = monstre.tempsDeplacement;
        this.TEMPS_DEPLACEMENT = monstre.TEMPS_DEPLACEMENT;
        this.nbDeDeplacement = monstre.nbDeDeplacement;
        this.NB_DE_DEPLACEMENT = monstre.NB_DE_DEPLACEMENT;
        this.mouvementAleatoire = monstre.mouvementAleatoire;
        this.mouvementAleatoireDirection = monstre.mouvementAleatoireDirection;

        this.bdd = monstre.bdd;

        this.hitBoxVue = monstre.hitBoxVue;

        this.porteeDeAttaque = monstre.porteeDeAttaque;
        this.distanceDeAttaqueDeOrigineAX = monstre.distanceDeAttaqueDeOrigineAX;
        this.distanceDeAttaqueDeOrigineAY = monstre.distanceDeAttaqueDeOrigineAY;

        this.positionX = monstre.positionX;
        this.positionY = monstre.positionY;
        this.vitesseDeDeplacementEnX = monstre.vitesseDeDeplacementEnX;
        this.vitesseDeSaut = monstre.vitesseDeSaut;

        this.largeurDevant = monstre.largeurDevant;
        this.largeurDerriere = monstre.largeurDerriere;
        this.hauteurHaut = monstre.hauteurHaut;
        this.hauteurBas = monstre.hauteurBas;
    }

    public int donneExperience() {
        return (int) (niveau * (coeffArmure + coeffDegat + coeffMana + coeffVie));
    }

    public void attaquer(Personnage cible) {
        if (collision(getHitBoxAttaque(), cible.getHitBoxCorps())) { // attaque de près
            tempsAttaque++;

            if (tempsAttaque % 25 == 0) {
                setAttaquer(true);
                cible.recevoirDegats(getDegats());
            }

        } else if (collision(getHitBoxZoneAttaque(), cible.getHitBoxCorps())) { // attaque de loin (avec sort)
            tempsAttaque++;

            if (tempsAttaque % sort.getTempsDeRechargement() == 0 && getMana() >= sort.getCoutManaSpell()) {
                setAttaquer(true);
                jeu.getTableauSortMonstre().add(appelleSort(sort));
            }
        } else {
            tempsAttaque = 0;
        }
    }

    public boolean update(Hero hero) {
        boolean destruction = false;
        temps++;

        // regénère mana et régénère vie
        if (temps % tempsRegeneration == 0) {
            regenerationMana();
            regenerationVie();
        }

        // si le héro est dans le champs d'attaque du monstre
        attaquer(hero);

        // Si le hero est dans le champs de vision du monstre
        if (collision(getHitBoxVue(), hero.getHitBoxCorps())) {
            // déplacement
            if (positionY - hauteurHaut > hero.positionY + hero.hauteurBas) // si le héro est plus haut que le monstre
                sauter();
            if (positionX < hero.positionX && !collision(getHitBoxCorps(), hero.getHitBoxCorps())) // si le héro est à droite
                deplacerADroite();
            else if (positionX > hero.positionX && !collision(getHitBoxCorps(), hero.getHitBoxCorps())) // si héro est à gauche
                deplacerAGauche();

            tempsDeplacement = 0;
        } else { // le héro est pas dans le champs de vision du monstre
            tempsDeplacement++;
            if (tempsDeplacement % TEMPS_DEPLACEMENT == 0)
                mouvementAleatoire = true;

            if (mouvementAleatoire) {
                if (nbDeDeplacement == 0)
                    mouvementAleatoireDirection = getDirectionOrientation().getDirection() == Direction.GAUCHE;
                if (mouvementAleatoireDirection)
                    deplacerADroite();
                else
                    deplacerAGauche();

                nbDeDeplacement++;
            }
            if (nbDeDeplacement == NB_DE_DEPLACEMENT) {
                nbDeDeplacement = 0;
                tempsDeplacement = 0;
                mouvementAleatoire = false;
            }
        }

        // test si il est mort
        if (!estVivant())
            destruction = true;

        return destruction;
    }

    public void upgrade() {
        deplacer();
    }


    public int getDistanceVisibilite() {
        return distanceVisibilite;
    }

    public Rectangle getHitBoxVue() {
        hitBoxVue = new Rectangle(
                getPositionX() - (getDirectionOrientation().getDirection() == Direction.GAUCHE ? getLargeurDevant() : getLargeurDerriere()) - getDistanceVisibilite(),
                getPositionY() - getHauteurHaut() - getDistanceVisibilite(),
                getLargeurDevant() + getLargeurDerriere() + getDistanceVisibilite() + getDistanceVisibilite(),
                getHauteurHaut() + getDistanceVisibilite() + getHauteurBas() + getDistanceVisibilite()
        );

        return hitBoxVue;
    }

    public Rectangle getHitBoxZoneAttaque() {
        hitBoxVue = new Rectangle(
                getPositionX() - (getDirectionOrientation().getDirection() == Direction.GAUCHE ? getLargeurDevant() : getLargeurDerriere()) - sort.getPorteSpell(),
                getPositionY() - getHauteurHaut() - getDistanceVisibilite(),
                sort.getPorteSpell() * 2 + getLargeurDerriere() + getLargeurDevant(),
                getHauteurHaut() + getDistanceVisibilite() + getHauteurBas() + getDistanceVisibilite()
        );

        return hitBoxVue;
    }

    public Equipement dropItem() {
        return bdd.dropEquipement((int) (Math.random() * (bdd.nbItem() - 1) + 1));
    }
}
