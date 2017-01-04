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
    private int distanceVisibilite;

    public Monstre(String nom, int niveau, int largeur, int hauteur, double coeffArmure, double coeffVie, double coeffMana, double coeffDegat,
                   int positionX, int positionY, int vitesseDeDeplacementEnPixelX, int vitesseDeDeplacementEnPixelY, int distanceVisibilite) {

        super(nom, niveau, largeur, hauteur, positionX, positionY, vitesseDeDeplacementEnPixelX, vitesseDeDeplacementEnPixelY);

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

        this.distanceVisibilite = Fenetre.adapterResolutionEnX(2 * distanceVisibilite);

        System.out.println("nom:" + nom + ", niveau:" + niveau + ", vieMax:" + vieMax + ", manaMax:" + manaMax + ", degatMax:" +
                degatMax + ", armureMax:" + armureMax + "xpdonne" + donneExperience());
    }

    public int donneExperience() {
        return (int) (niveau * (coeffArmure + coeffDegat + coeffMana + coeffVie));
    }

    public void update(Hero hero) {
        // Si le hero est dans le champs de vision du monstre
        if ((positionX + largeur / 2.0 + distanceVisibilite >= hero.positionX - hero.largeur / 2.0 ||
                positionX - largeur / 2.0 - distanceVisibilite <= hero.positionX + hero.largeur / 2.0) &&
                (positionY - distanceVisibilite - hauteur / 2.0 <= hero.positionY + hero.hauteur / 2.0 ||
                        positionY + hauteur / 2.0 + distanceVisibilite >= hero.positionY - hero.hauteur / 2.0)) {
            // déplacement
            if (positionY - hauteur / 2.0 > hero.positionY + hero.hauteur / 2.0) // si le héro est plus haut que le monstre
                sauter();
            if (positionX + largeur / 2.0 <= hero.positionX - hero.largeur / 2.0) // si le héro est à droite
                deplacerADroite();
            else if (positionX - largeur / 2.0 >= hero.positionX + hero.largeur / 2.0) // si héro est à gauche
                deplacerAGauche();
        }
    }

    public void upgrade() {
        deplacer();
    }
}
