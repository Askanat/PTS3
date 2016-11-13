package model;

import vue.Entite;

import static model.Jeu.X;
import static model.Jeu.Y;

/**
 * Created by bastien on 29/09/16.
 */

public class Hero extends Personnage {

    private int experience, experienceMax;
    private int or;
    private int charge, chargeMax;
    private int pointCompetence, pointConstitution, pointIntelligence, pointForce, pointResistance;

    private final int COEF_VIE = 3;
    private final int COEF_MANA = 3;
    private final int COEF_DEGATS = 1;
    private final int COEF_ARMURE = 1;

    private final int VIE_DE_BASE = 100;
    private final int MANA_DE_BASE = 100;
    private final int DEGATS_DE_BASE = 1;

    public Hero(String nom, int niveau, int experience, int experienceMax, int pointCompetence, int pointConstitution,
                int pointIntelligence, int pointForce, int pointResistance, int or, int chargeMax, int positionX, int positionY) {
        super(nom, niveau, positionX, positionY, (int) (1/96.0 * X), (int) (1/27.0* Y));

        vieMax = pointConstitution * COEF_VIE + VIE_DE_BASE;
        vie = vieMax;

        manaMax = pointIntelligence * COEF_MANA + MANA_DE_BASE;
        mana = manaMax;

        degatMax = pointForce * COEF_DEGATS + DEGATS_DE_BASE;
        degats = degatMax;

        armureMax = pointResistance * COEF_ARMURE;
        armure = armureMax;

        this.experience = experience;
        this.experienceMax = experienceMax;

        this.pointCompetence = pointCompetence;
        this.pointConstitution = pointConstitution;
        this.pointIntelligence = pointIntelligence;
        this.pointForce = pointForce;
        this.pointResistance = pointResistance;

        this.or = or;

        this.chargeMax = chargeMax;
        charge = 0;

        System.out.println("nom:" + nom + ", niveau:" + niveau + ", vieMax:" + vieMax + ", manaMax:" + manaMax + ", degatMax:" +
                degatMax + ", armureMax:" + armureMax + ", experience:" + experience + ", experienceMax:" + experienceMax +
                ", or:" + or + ", chargeMax:" + chargeMax + ", pointCompetence:" + pointCompetence + ", pointConstitution:" +
                pointConstitution + ", pointIntelligence:" + pointIntelligence + ", pointForce:" + pointForce + ", pointResistance:" + pointResistance);
    }
}
