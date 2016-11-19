package model;

import java.util.Random;

import static model.Jeu.X;

/**
 * Created by bastien on 29/09/16.
 */

public class Monstre extends Personnage implements Runnable {

    private double coeffVie;
    private double coeffMana;
    private double coeffDegat;
    private double coeffArmure;
    private int distanceVue;
    private Hero hero;

    public Monstre(String nom, double coeffMonstre, double coeffArmure, double coeffVie, double coeffMana, double coeffDegat,
                   int positionX, int positionY, int vitesseDeDeplacementEnPixelX, int vitesseDeDeplacementEnPixelY, Hero hero) {

        super(nom, (int)coeffMonstre, positionX, positionY, vitesseDeDeplacementEnPixelX, vitesseDeDeplacementEnPixelY);

        vieMax = coeffVie * niveau;
        vie = vieMax;

        manaMax = coeffMana * niveau;
        mana = manaMax;

        degatMax = coeffDegat * niveau;
        degats = degatMax;

        armureMax = coeffArmure * niveau;
        armure = armureMax;

        this.coeffVie = coeffVie;
        this.coeffMana = coeffMana;
        this.coeffDegat = coeffDegat;
        this.coeffArmure = coeffArmure;

        // Le monstre peut voir jusqu'à 100 px devant ou derrière lui, pour 1920/1080 reporter à la taille de l'écran
        this.distanceVue = (int) (5 / 48.0 * X);

        this.hero = hero;

        System.out.println("nom:" + nom + ", niveau:" + coeffMonstre + ", vieMax:" + vieMax + ", manaMax:" + manaMax + ", degatMax:" +
                degatMax + ", armureMax:" + armureMax);
    }

    private void deplacerTete(Direction direction) {
        switch (direction) {
            case GAUCHE:
                deplacerAGauche();
                break;
            case DROITE:
                deplacerADroite();
        }
    }

    public void deplacer(Direction direction) {
        switch (direction) {
            case GAUCHE:
                setPositionX(positionX - 2);
                break;
            case DROITE:
                setPositionX(positionX + 2);
        }

        try {
            Thread.sleep(60);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    // Thread destiné à gérer les interactions d'un monstre (déplacement, attaque, etc...)

    @Override
    public void run() {
        try {
            int max = 4000, min = 2000;
            Thread.sleep(new Random().nextInt((max - min) + 1) + min);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // Si le hero est dans le champ de vision et à droite, déplace le monstre à droite

        if (positionX <= hero.positionX &&
                (positionX + distanceVue) >= hero.positionX) {
            int newPosx = hero.positionX;
            System.out.println("premier if");

            while (positionX <= newPosx) {
                deplacer(Direction.DROITE);
            }
        }

        // Sinon si le hero est dans le champ de vision et à gaiche, déplace le monstre à gauche

        else if (positionX >= (hero.positionX) &&
                (positionX - distanceVue) <= hero.positionX) {
            int newPosx = hero.positionX;
            System.out.println("deuxieme if");

            deplacerTete(Direction.GAUCHE);

            while (positionX >= newPosx) {
                deplacer(Direction.GAUCHE);
            }
        }

        // Sinon déplace aléatoire à gauche ou à droite, selon une distance aléatoire comprise entre
        // (distanceVue / 4) et distanceVue

        else {
            System.out.println("troisième if");
            Direction d = null;
            Random rand = new Random();
            int sens = rand.nextInt(2);
            switch (sens) {
                case 0:
                    d = Direction.GAUCHE;
                    break;
                case 1:
                    d = Direction.DROITE;
            }

            int longueur = rand.nextInt((distanceVue - (distanceVue / 4)) + 1) + (distanceVue / 4);

            deplacerTete(d);

            for (int i = 0; i < longueur; i++) {
                deplacer(d);
            }
        }
    }
}