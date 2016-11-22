package model;

import vue.Fenetre;

/**
 * Created by bastien on 29/09/16.
 */

public class Hero extends Personnage {

    private double experience, experienceMax;
    private int or;
    private int charge, chargeMax;
    private double constiPerso, forcePerso, intelPerso, armurePerso, resiPerso;

    private final int COEF_VIE = 3;
    private final int COEF_MANA = 3;
    private final int COEF_DEGATS = 1;
    private final int COEF_ARMURE = 1;

    private final int VIE_DE_BASE = 100;
    private final int MANA_DE_BASE = 100;
    private final int DEGATS_DE_BASE = 1;

    public Hero(String nom, int niveau, double experience, double experienceMax, double forcePerso, double intelPerso,
                double constiPerso, double armurePerso, double resiPerso, double degatArmePerso,int gold, String texturePerso, int positionX, int positionY) {

        super(nom, niveau, positionX, positionY, Fenetre.adapterResolutionEnX(30), Fenetre.adapterResolutionEnY(60));

        vieMax = constiPerso * COEF_VIE + VIE_DE_BASE;
        vie = vieMax;

        manaMax = intelPerso * COEF_MANA + MANA_DE_BASE;
        mana = manaMax;

        degatMax = forcePerso * COEF_DEGATS + DEGATS_DE_BASE;
        degats = degatMax;

        armureMax = resiPerso * COEF_ARMURE;
        armure = armureMax;

        this.experience = experience;
        this.experienceMax = experienceMax;

        this.forcePerso = forcePerso;
        this.constiPerso = constiPerso;
        this.intelPerso = intelPerso;
        this.forcePerso = forcePerso;
        this.resiPerso = resiPerso;

        this.or = or;

        this.chargeMax = chargeMax;
        charge = 0;

        System.out.println("nom:" + nom + ", niveau:" + niveau + ", vieMax:" + vieMax + ", manaMax:" + manaMax + ", degatMax:" +
                degatMax + ", armureMax:" + armureMax + ", experience:" + experience + ", experienceMax:" + experienceMax +
                ", or:" + or + ", chargeMax:" + chargeMax + ", forcePerso:" + forcePerso + ", pointConstitution:" +
                constiPerso + ", pointIntelligence:" + intelPerso + ", pointForce:" + forcePerso + ", pointResistance:" + resiPerso);
    }
}
