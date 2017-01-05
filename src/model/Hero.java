package model;

import static java.lang.Math.pow;

/**
 * Created by bastien on 29/09/16.
 */

public class Hero extends Personnage {

    private double experience, experienceMax;
    private int or;
    private int pointCaracteristique, pointCompetence;
    private double forcePerso, intelPerso, constiPerso, resiPerso;

    private final int POINTCOMPETENCE = 1;
    private final int POINTCARACTERISQUE = 15;
    private final int COEF_VIE = 3;
    private final int COEF_MANA = 3;
    private final int COEF_DEGATS = 1;
    private final int COEF_ARMURE = 1;

    private final int VIE_DE_BASE = 100;
    private final int MANA_DE_BASE = 100;
    private final int DEGATS_DE_BASE = 1;

    public Hero(String nom, int niveau, int pointCaracteristique, int pointCompetence, double experience, double experienceMax, double forcePerso, double intelPerso,
                double constiPerso, double resiPerso, int or, String texturePerso, int positionX, int positionY) {

        super(nom, niveau, 52, 52, 90, 90, positionX, positionY, 30, 60);

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
            this.pointCaracteristique = POINTCARACTERISQUE;
            this.pointCompetence = POINTCOMPETENCE;
        }else{
            this.pointCaracteristique = pointCaracteristique;
            this.pointCompetence = pointCompetence;
        }

        this.forcePerso = forcePerso;
        this.constiPerso = constiPerso;
        this.intelPerso = intelPerso;
        this.resiPerso = resiPerso;

        this.or = or;

        System.out.println("nom:" + nom + ", niveau:" + niveau + ", vieMax:" + vieMax + ", manaMax:" + manaMax + ", degatMax:" +
                degatMax + ", armureMax:" + armureMax + ", experience:" + experience + ", experienceMax:" + experienceMax +
                ", or:" + or + ", forcePerso:" + forcePerso + ", pointConstitution:" +
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

    //Verification et Augmentation de Niveau avec ajout de Points de Compétences et Caractéristiques et augmentation du seuil d'expérience à atteindre
        public boolean checkNiveauSup() {
            return getExperience() >= getExperienceMax();
        }

        public void upNiveau() {
            if (checkNiveauSup()){
                setNiveau(getNiveau() + 1);
                update_ExperienceMax();
                setPointCaractéristique();
                setPointCompetence();
            }
        }

    //Modification Caractéristiques
        //Force
            public void setForcePerso(double forcePerso){
                this.forcePerso = forcePerso;
            }

            public double getForcePerso() {
                return forcePerso;
            }
        //Intelligence
            public void setIntelPerso(double intelPerso) {
                this.intelPerso = intelPerso;
            }

            public double getIntelPerso() {
                return intelPerso;
            }
        //Constitution
            public void setConstiPerso(double constiPerso) {
                this.constiPerso = constiPerso;
            }

            public double getConstiPerso() {
                return constiPerso;
            }
        //Résistance
            public void setResiPerso(double resiPerso) {
                this.resiPerso = resiPerso;
            }

            public double getResiPerso() {
                return resiPerso;
            }

    //Gestion de l'ajout de Point de Caractéristique et le Return
        public void setPointCaractéristique(){
            pointCaracteristique = getPointCaracteristique() + 10;
        }

        public int getPointCaracteristique() {
            return pointCaracteristique;
        }

    //Gestion de l'ajout de Point de Compétence et le Return
        public void setPointCompetence(){
            pointCompetence = getPointCompetence() + 1;
        }

        public int getPointCompetence() {
            return pointCompetence;
        }

    //Ajout et update de l'Expérience
        //Ajout d'EXP
            //EXP ajouté au héros
                public void recevoirExperience(Monstre m) {
                    setExperience(getExperience() + m.donneExperience());
                }

            //EXP maximum augmenté
                public void update_ExperienceMax() {
                    setExperienceMax(2 * (-700 + (500 * (getNiveau() + 1)) - (80 * pow((getNiveau() + 1), 2)) + (10 * pow((getNiveau() + 1), 3))));
                }

        //Affichage EXP
            //EXP progression
                public void setExperience(double experience) {
                    this.experience = experience;
                }

                public double getExperience() {
            return experience;
        }

            //EXP MAX
                public void setExperienceMax(double experienceMax) {
                    this.experienceMax = experienceMax;
                }

                public double getExperienceMax() {
            return experienceMax;
        }
}
