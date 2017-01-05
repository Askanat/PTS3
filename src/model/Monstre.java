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

    public Monstre(String nom, int niveau, int largeurDevant, int largeurDerriere, int hauteurHaut, int hauteurBas, double coeffArmure, double coeffVie, double coeffMana, double coeffDegat,
                   int positionX, int positionY, int vitesseDeDeplacementEnPixelX, int vitesseDeDeplacementEnPixelY, int distanceVisibilite) {

        super(nom, niveau, largeurDevant, largeurDerriere, hauteurHaut, hauteurBas, positionX, positionY, vitesseDeDeplacementEnPixelX, vitesseDeDeplacementEnPixelY);

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

        System.out.println("nom:" + nom + ", niveau:" + niveau + ", vieMax:" + vieMax + ", manaMax:" + manaMax + ", degatMax:" +
                degatMax + ", armureMax:" + armureMax + "xpdonne" + donneExperience());
    }

    public int donneExperience() {
        return (int) (niveau * (coeffArmure + coeffDegat + coeffMana + coeffVie));
    }

    public void update(Hero hero) {
        // Si le hero est dans le champs de vision du monstre
        if ((positionX + largeurDerriere + distanceVisibilite >= hero.positionX - hero.largeurDevant ||
                positionX - largeurDevant - distanceVisibilite <= hero.positionX + hero.largeurDerriere) &&
                (positionY - hauteurHaut - distanceVisibilite <= hero.positionY + hero.hauteurBas ||
                        positionY + hauteurBas + distanceVisibilite >= hero.positionY - hero.hauteurHaut)) {
            // déplacement
            if (positionY - hauteurHaut > hero.positionY + hero.hauteurBas) // si le héro est plus haut que le monstre
                sauter();
            if (positionX + largeurDerriere <= hero.positionX - hero.largeurDevant) // si le héro est à droite
                deplacerADroite();
            else if (positionX - largeurDevant >= hero.positionX + hero.largeurDerriere) // si héro est à gauche
                deplacerAGauche();
        }
    }

    public void upgrade() {
        deplacer();
    }
}
