package model;

import vue.Entite;

import java.util.Random;

/**
 * Created by bastien on 29/09/16.
 */

public class Monstre extends Personnage implements Runnable {

    private int coefVie;
    private int coefMana;
    private int coefDegat;
    private int coefArmure;
    private int distanceVue;
    private Hero hero;

    public Monstre(String nom, int niveau, int coefVie, int coefMana, int coefDegat, int coefArmure,
                   int positionX, int positionY, int coefDeplacement, Hero hero) {
        super(nom, niveau, positionX, positionY, coefDeplacement);

        vieMax = coefVie * niveau;
        vie = vieMax;

        manaMax = coefMana * niveau;
        mana = manaMax;

        degatMax = coefDegat * niveau;
        degats = degatMax;

        armureMax = coefArmure * niveau;
        armure = armureMax;

        this.coefVie = coefVie;
        this.coefMana = coefMana;
        this.coefDegat = coefDegat;
        this.coefArmure = coefArmure;

        // Le monstre peut voir jusqu'à 100 px devant ou derrière lui
        this.distanceVue = 100;

        this.hero = hero;

        System.out.println("nom:" + nom + ", niveau:" + niveau + ", vieMax:" + vieMax + ", manaMax:" + manaMax + ", degatMax:" +
                degatMax + ", armureMax:" + armureMax);
    }

    public void deplacer(int sens) {
        switch (sens) {
            case GAUCHE:
                deplacerAGauche();
                break;
            case DROITE:
                deplacerADroite();
        }
    }

    // Thread destiné à gérer les interactions d'un monstre (déplacement, attaque, etc...)

    @Override
    public void run() {
        // Si le hero est dans le champ de vision et à droite, déplace le monstre à droite

        if(positionX <= hero.positionX &&
                (positionX + distanceVue) >= hero.positionX) {
           while(positionX <= hero.positionX &&
                    (positionX + distanceVue) >= hero.positionX) {
               deplacer(DROITE);
           }
        }

        // Sinon si le hero est dans le champ de vision et à gaiche, déplace le monstre à gauche

        else if(positionX >= (hero.positionX) &&
                (positionX - distanceVue) <= hero.positionX) {
            while(positionX >= hero.positionX &&
                    (positionX - distanceVue) <= hero.positionX) {
                deplacer(GAUCHE);
            }
        }

        // Sinon déplace aléatoire à gauche ou à droite, selon une distance aléatoire comprise entre
        // (distanceVue / 4) et distanceVue

        else {
            Random rand = new Random();
            int sens = rand.nextInt(2);
            int longueur = rand.nextInt((distanceVue - (distanceVue / 4)) + 1) + (distanceVue / 4);

            for(int i = 0; i < longueur; i++) {
                deplacer(sens);
            }
        }
    }
}