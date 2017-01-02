package model;

import vue.Fenetre;

import java.util.Random;

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

        super(nom, (int) coeffMonstre, positionX, positionY, vitesseDeDeplacementEnPixelX, vitesseDeDeplacementEnPixelY);

        vieMax = coeffVie * niveau + 1;
        vie = vieMax;

        manaMax = coeffMana * niveau + 1;
        mana = manaMax;

        degatMax = coeffDegat * niveau + 1;
        degats = degatMax;

        armureMax = coeffArmure * niveau + 1;
        armure = armureMax;

        this.coeffVie = coeffVie;
        this.coeffMana = coeffMana;
        this.coeffDegat = coeffDegat;
        this.coeffArmure = coeffArmure;

        // Le monstre peut voir jusqu'à 100 px devant ou derrière lui, pour 1920/1080 reporter à la taille de l'écran
        this.distanceVue = Fenetre.adapterResolutionEnX(200);

        this.hero = hero;

        System.out.println("nom:" + nom + ", niveau:" + coeffMonstre + ", vieMax:" + vieMax + ", manaMax:" + manaMax + ", degatMax:" +
                degatMax + ", armureMax:" + armureMax + "xpdonne" + (int) (niveau * (coeffArmure + coeffDegat + coeffMana + coeffVie) * 10));
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

        // Pour tester, les monstres bougeront au ralenti
        
        try {
            System.out.wait(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        /*
        try {
            Thread.sleep(60);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        */
    }

    public int donneExperience() {
        return (int) (niveau * (coeffArmure + coeffDegat + coeffMana + coeffVie) * 10);
    }

    // Thread destiné à gérer les interactions d'un monstre (déplacement, attaque, etc...)
    @Override
    public void run() {
        int largeur = Fenetre.adapterResolutionEnX(200);
        boolean deplacementAleatoire = true;

        // Si le héro n'est ni trop bas et ni trop haut
        
        if(!(positionY + largeur < hero.positionY || positionY > hero.positionY + largeur)) {
            // Si le hero est dans le champ de vision et à droite, déplace le monstre à droite

            if (positionX + largeur <= hero.positionX + largeur && positionX + largeur + distanceVue >= hero.positionX) {
                int newPosx = hero.positionX + largeur * 2;
                deplacerTete(Direction.DROITE);

                while (positionX <= newPosx) {
                    deplacer(Direction.DROITE);
                }

                deplacementAleatoire = false;
            }

            // Sinon si le hero est dans le champ de vision et à gauche, déplace le monstre à gauche

            else if (positionX >= hero.positionX && positionX - distanceVue <= hero.positionX + largeur) {
                int newPosx = hero.positionX - largeur;
                deplacerTete(Direction.GAUCHE);

                while (positionX >= newPosx) {
                    deplacer(Direction.GAUCHE);
                }

                deplacementAleatoire = false;
            }
        }

        // Deplacement aléatoire si le héro n'est pas dans le champ de vision
        
        if(deplacementAleatoire) {

        }
    }
}
