package model;

/**
 * Created by bastien on 29/09/16.
 */

public class Monstre extends Personnage {

    private int coefVie;
    private int coefMana;
    private int coefDegat;
    private int coefArmure;

    public Monstre(String nom, int niveau, int coefVie, int coefMana, int coefDegat, int coefArmure, int positionX, int positionY, int coefDeplacement) {
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

        System.out.println("nom:" + nom + ", niveau:" + niveau + ", vieMax:" + vieMax + ", manaMax:" + manaMax + ", degatMax:" +
                degatMax + ", armureMax:" + armureMax);
    }

    public void deplacer() {
    } // déplace aléatoirement

    public void deplacer(Hero cible) {
    } // poursuit le hero
}