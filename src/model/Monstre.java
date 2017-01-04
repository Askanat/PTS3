package model;

import vue.Fenetre;

/**
 * Created by bastien on 29/09/16.
 */

public class Monstre extends Personnage {

    private double coeffVie;
    private double coeffMana;
    private double coeffDegat;
    private double coeffArmure;
    private int distanceVue;
    private Hero hero;

    public Monstre(String nom, double coeffMonstre, double coeffArmure, double coeffVie, double coeffMana, double coeffDegat,
                   int positionX, int positionY, int vitesseDeDeplacementEnPixelX, int vitesseDeDeplacementEnPixelY, Hero hero) {

        super(nom, (int) coeffMonstre, positionX, positionY, Fenetre.adapterResolutionEnX(vitesseDeDeplacementEnPixelX), Fenetre.adapterResolutionEnY(vitesseDeDeplacementEnPixelY));

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

    public int donneExperience() {
        return (int) (niveau * (coeffArmure + coeffDegat + coeffMana + coeffVie) * 10);
    }

    public void update() {
        int largeur = Fenetre.adapterResolutionEnX(200);
        // Si le héro est trop haut
        if (positionY > hero.positionY + largeur && ((positionX + largeur <= hero.positionX + largeur && positionX + largeur + distanceVue >= hero.positionX)|| (positionX >= hero.positionX && positionX - distanceVue <= hero.positionX + largeur))) {
            sauter();
        }

        // Si le héro n'est ni trop bas et ni trop haut
        if (!(positionY + largeur < hero.positionY || positionY > hero.positionY + largeur)) {
            // Si le hero est dans le champ de vision et à droite, déplace le monstre à droite
            if (positionX + largeur <= hero.positionX + largeur && positionX + largeur + distanceVue >= hero.positionX) {
                    deplacerADroite();
            }

            // Sinon si le hero est dans le champ de vision et à gauche, déplace le monstre à gauche
            else if (positionX >= hero.positionX && positionX - distanceVue <= hero.positionX + largeur) {
                    deplacerAGauche();
            }
        }

    }

    // interactions d'un monstre (déplacement, attaque, etc...)
    public void upgrade() {

        deplacer();
    }
}
