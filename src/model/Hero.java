package model;

import java.awt.*;
import java.io.Serializable;
import java.util.ArrayList;

import static java.lang.Math.pow;
import static vue.FenetreJeu.TAILLE_TUILE;
import static vue.FenetreJeu.tuileInt;

/**
 * Created by bastien on 29/09/16.
 */

public class Hero extends Personnage implements Serializable {

    private double experience, experienceMax;
    private int or;
    private int pointCaracteristique, pointCompetence;
    private double force, intelligence, constitution, resistance, limiteForce = 0, limiteIntelligence = 0, limiteConstitution = 0, limiteResistance = 0;

    private ArrayList<Sort> heroSort;
    public ArrayList<Equipement> inventaire;

    private int tempsAvantDisponibiliteSort[];

    private final int COEF_VIE = 5;
    private final int COEF_MANA = 5;
    private final int COEF_DEGATS = 3;
    private final int COEF_ARMURE = 3;

    private final int VIE_DE_BASE = 100;
    private final int MANA_DE_BASE = 100;
    private final int DEGATS_DE_BASE = 5;

    public Hero(String nom, int niveau, int pointCompetence, int pointCaracteristique, double experience, double experienceMax, double forcePerso, double intelPerso,
                double constiPerso, double resiPerso, int or, String texture, int positionX, int positionY, Jeu jeu, ArrayList<Sort> heroSort, ArrayList<Equipement> inventaire) {

        super(nom, niveau, 52, 52, 81, 98, texture, positionX, positionY, 30, 60, 68, 8, 30, jeu);

        this.force = forcePerso;
        this.constitution = constiPerso;
        this.intelligence = intelPerso;
        this.resistance = resiPerso;

        vieMax = (int) (constitution * COEF_VIE + VIE_DE_BASE);
        vie = vieMax;
        manaMax = (int) (intelligence * COEF_MANA + MANA_DE_BASE);
        mana = manaMax;
        degatMax = (int) (force * COEF_DEGATS + DEGATS_DE_BASE);
        degats = degatMax;
        armureMax = (int) (resistance * COEF_ARMURE);
        armure = armureMax;

        this.experience = experience;
        this.experienceMax = experienceMax;

        this.pointCaracteristique = pointCaracteristique;
        this.pointCompetence = pointCompetence;

        this.or = or;

        this.heroSort = heroSort;
        tempsAvantDisponibiliteSort = new int[heroSort.size()];

        this.inventaire = inventaire;
    }

    public Hero(Hero hero) {

        super(hero.nom, hero.niveau, hero.texture, hero.jeu);

        this.force = hero.force;
        this.constitution = hero.constitution;
        this.intelligence = hero.intelligence;
        this.resistance = hero.resistance;

        this.vieMax = hero.vieMax;
        this.vie = hero.vie;
        this.manaMax = hero.manaMax;
        this.mana = hero.mana;
        this.degatMax = hero.degatMax;
        this.degats = hero.degats;
        this.armureMax = hero.armureMax;
        this.armure = hero.armure;

        this.experience = hero.experience;
        this.experienceMax = hero.experienceMax;

        this.pointCaracteristique = hero.pointCaracteristique;
        this.pointCompetence = hero.pointCompetence;

        this.or = hero.or;

        this.heroSort = hero.heroSort;
        this.tempsAvantDisponibiliteSort = hero.tempsAvantDisponibiliteSort;

        this.inventaire = hero.inventaire;

        this.porteeDeAttaque = hero.porteeDeAttaque;
        this.distanceDeAttaqueDeOrigineAX = hero.distanceDeAttaqueDeOrigineAX;
        this.distanceDeAttaqueDeOrigineAY = hero.distanceDeAttaqueDeOrigineAY;

        this.positionX = hero.positionX;
        this.positionY = hero.positionY;
        this.vitesseDeDeplacementEnX = hero.vitesseDeDeplacementEnX;
        this.vitesseDeSaut = hero.vitesseDeSaut;

        this.largeurDevant = hero.largeurDevant;
        this.largeurDerriere = hero.largeurDerriere;
        this.hauteurHaut = hero.hauteurHaut;
        this.hauteurBas = hero.hauteurBas;
    }

    //fonction qui renvoie un tableau de string contenant les informations à sauvegarder dans la bdd
    public String[] sauvegardeDonneesHeros() {
        String donnee[] = new String[11];

        donnee[0] = "" + nom;
        donnee[1] = "" + niveau;
        donnee[2] = "" + pointCompetence;
        donnee[3] = "" + pointCaracteristique;
        donnee[4] = "" + experience;
        donnee[5] = "" + experienceMax;
        donnee[6] = "" + force;
        donnee[7] = "" + intelligence;
        donnee[8] = "" + constitution;
        donnee[9] = "" + resistance;
        donnee[10] = "" + or;
        return donnee;
    }

    //Verification et Augmentation de Niveau avec ajout de Points de Compétences et Caractéristiques et augmentation du seuil d'expérience à atteindre
    public boolean checkNiveauSup() {
        return getExperience() >= getExperienceMax();
    }

    public void upNiveau() {
        if (checkNiveauSup()) {
            setNiveau(getNiveau() + 1);
            setExperience(getExperience() - getExperienceMax());
            setVie(getVieMax());
            setMana(getManaMax());
            update_ExperienceMax();
            gainPointCaracteristique();
            setPointCompetence();
            // sauvegarde du hero quand il monte de niveau
        }
    }

    public void update() {
        temps++;

        // inflige dégats quand on marche sur des pics
        int x = getPositionX() / TAILLE_TUILE;
        int y = (getPositionY() + hauteurBas) / TAILLE_TUILE;
        if (tuileInt[y - 1][x] == 79)
            setVie((int) (getVie() - ((jeu.getNiveauDonjonActuelle()/100.0) * getVieMax())));

        // regénère mana et régénère vie
        if (temps % tempsRegeneration == 0) {
            regenerationMana();
            regenerationVie();
        }

        // gère le temps pour invoquer les sorts
        for (int i = 0; i < tempsAvantDisponibiliteSort.length; i++)
            if (tempsAvantDisponibiliteSort[i] > 0)
                tempsAvantDisponibiliteSort[i] += -1;


        // déplacement du héro
        deplacer();
    }

    // update les caracteristiques
    public void updateCaracteristique() {
        vieMax = (int) (constitution * COEF_VIE + VIE_DE_BASE);
        vie = vieMax;
        manaMax = (int) (intelligence * COEF_MANA + MANA_DE_BASE);
        mana = manaMax;
        degatMax = (int) (force * COEF_DEGATS + DEGATS_DE_BASE);
        degats = degatMax;
        armureMax = (int) (resistance * COEF_ARMURE);
        armure = armureMax;
        getIdHero();
    }

    //Modification Caractéristiques
    //Force
    public void setForce(double force) {
        this.force = force;
    }

    public double getForce() {
        return force;
    }

    //Intelligence
    public void setIntelligence(double intelligence) {
        this.intelligence = intelligence;
    }

    public double getIntelligence() {
        return intelligence;
    }

    //Constitution
    public void setConstitution(double constitution) {
        this.constitution = constitution;
    }

    public double getConstitution() {
        return constitution;
    }

    //Résistance
    public void setResistance(double resistance) {
        this.resistance = resistance;
    }

    public double getResistance() {
        return resistance;
    }

    //Gestion de l'ajout de Point de Caractéristique et le Return
    public void setPointCaracteristique(int pointCaracteristique) {
        this.pointCaracteristique = pointCaracteristique;
    }

    public void gainPointCaracteristique() {
        pointCaracteristique = getPointCaracteristique() + 10;
    }

    public int getPointCaracteristique() {
        return pointCaracteristique;
    }

    //Gestion de l'ajout de Point de Compétence et le Return
    public void setPointCompetence() {
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

    // retourne id de l'hero avec sa texture
    public int getIdHero() {
        return Integer.parseInt("" + texture.toCharArray()[texture.length() - 1 - 4]);
        // renvoie l'id de l'héro
    }

    //Fiche Perso Limite après mise à jour des caractéristiques
    //Limite Force
    public void setLimiteForce(double limiteForce) {
        this.limiteForce = limiteForce;
    }

    public double getLimiteForce() {
        return limiteForce;
    }

    //Limite Resistance
    public void setLimiteResistance(double limiteResistance) {
        this.limiteResistance = limiteResistance;
    }

    public double getLimiteResistance() {
        return limiteResistance;
    }

    //Limite Intelligence
    public void setLimiteIntelligence(double limiteIntelligence) {
        this.limiteIntelligence = limiteIntelligence;
    }

    public double getLimiteIntelligence() {
        return limiteIntelligence;
    }

    //Limite Constitution
    public void setLimiteConstitution(double limiteConstitution) {
        this.limiteConstitution = limiteConstitution;
    }

    public double getLimiteConstitution() {
        return limiteConstitution;
    }

    public int getNieau() {
        return this.niveau;
    }

    public Rectangle getHitBoxAttaque() {
        Rectangle r = new Rectangle(
                positionX + (getDirectionOrientation().getDirection() == Direction.GAUCHE ? -(distanceDeAttaqueDeOrigineAX + porteeDeAttaque) : distanceDeAttaqueDeOrigineAX),
                positionY - distanceDeAttaqueDeOrigineAY,
                porteeDeAttaque,
                porteeDeAttaque
        );
        return r;
    }

    public Sort getSort(int indice) {
        return heroSort.get(indice);
    }

    public int[] getTempsAvantDisponibiliteSort() {
        return tempsAvantDisponibiliteSort;
    }

    public void setOr(int or) {
        this.or = or;
    }

    public int getOr() {
        return or;
    }

    public ArrayList<Equipement> getInventaire() {
        return inventaire;
    }

    public void addInventaire(Equipement equipement) {
        System.out.println("Hero : " + equipement.getNom());
        inventaire.add(equipement);
    }
}