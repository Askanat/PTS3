package model;

import static java.lang.Math.pow;

/**
 * Created by bastien on 29/09/16.
 */

public class Hero extends Personnage {

    private double experience, experienceMax;
    private int or;
    private int charge, chargeMax, pointCaracteristique, pointCompetence;
    private double constiPerso, forcePerso, intelPerso, armurePerso, resiPerso;

    private final int POINTCOMPETENCE = 1;
    private final int POINTCARACTERISQUE = 15;
    private final int COEF_VIE = 3;
    private final int COEF_MANA = 3;
    private final int COEF_DEGATS = 1;
    private final int COEF_ARMURE = 1;

    private final int VIE_DE_BASE = 100;
    private final int MANA_DE_BASE = 100;
    private final int DEGATS_DE_BASE = 1;

    public Hero(String nom, int niveau, double experience, double experienceMax, double forcePerso, double intelPerso,
                double constiPerso, double armurePerso, double resiPerso, double degatArmePerso, int gold, String texturePerso, int positionX, int positionY) {

        super(nom, niveau, 104, 179, positionX, positionY, 30, 60);

        vieMax = (int) (constiPerso * COEF_VIE + VIE_DE_BASE);
        vie = vieMax;
        manaMax = (int) (intelPerso * COEF_MANA + MANA_DE_BASE);
        mana = manaMax;
        degatMax = (int) (forcePerso * COEF_DEGATS + DEGATS_DE_BASE);
        degats = degatMax;
        armureMax = (int) (resiPerso * COEF_ARMURE);
        armure = armureMax;

        this.experience = experience;
        this.experienceMax = experienceMax;

        if(niveau == 1){
            pointCaracteristique = POINTCARACTERISQUE;
            pointCompetence = POINTCOMPETENCE;
        }else{
            //this.pointCaracteristique = pointCaracteristique;
            //this.pointCompetence = pointCompetence;
        }

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

    public void afficherEtat() {
        System.out.println(

                "nom : " + nom +
                ", vie : " + vie +
                ", vieMax : " + vieMax +
                ", degats : " + degats +
                ", positionX : " + positionX +
                ", positionY : " + positionY +
                ", experience: " + experience +
                ", experienceMax :" + experienceMax
        );
    }

    public boolean checkNiveauSup() {
        return getExperience() >= getExperienceMax();
    }

    public void upNiveau() {
        if (getExperience() == getExperienceMax()){
            setNiveau(getNiveau() + 1);
            update_ExperienceMax();
            setPointCaractéristique();
            setPointCompetence();
        }
    }

    public void setPointCaractéristique(){
        pointCaracteristique = getPointCaracteristique() + 10;
    }

    public int getPointCaracteristique() {
        return pointCaracteristique;
    }

    public void setPointCompetence(){
        pointCompetence = getPointCompetence() + 1;
    }

    public int getPointCompetence() {
        return pointCompetence;
    }

    public void recevoirExperience(Monstre m) {
        setExperience(getExperience() + m.donneExperience());
    }

    public void update_ExperienceMax() {
        setExperienceMax(2 * (-700 + (500 * (getNiveau() + 1)) - (80 * pow((getNiveau() + 1), 2)) + (10 * pow((getNiveau() + 1), 3))));
    }

    public double getExperience() {
        return experience;
    }

    public void setExperience(double experience) {
        this.experience = experience;
    }

    public void setExperienceMax(double experienceMax) {
        this.experienceMax = experienceMax;
    }

    public double getExperienceMax() {
        return experienceMax;
    }
}
