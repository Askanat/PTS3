package model;

import vue.Fenetre;

import java.util.ArrayList;

/**
 * Created by bastien on 28/09/16.
 */

public class Jeu {

    public static final int GRAVITE = Fenetre.adapterResolutionEnY(8);

    private Etat etat;
    private BDD bdd;

    private Hero hero;
    private ArrayList<Monstre> tableauMonstre;
    private ArrayList<Sort> tableauSortHero;
    private ArrayList<Sort> tableauSortMonstre;

    private int niveauDonjonActuelle;
    private int nbPartieLibre;


    public Jeu() {

        etat = new Etat();
        bdd = new BDD();

        hero = null;
        tableauSortHero = new ArrayList<Sort>();
        tableauMonstre = new ArrayList<>();
        tableauSortMonstre = new ArrayList<Sort>();

        niveauDonjonActuelle = 0;
        nbPartieLibre = 0;
    }


    public void updateEntite() {
        // supprime les monstres
        for (int i = getEtat().getIndiceSuppressionMonstre().size(); i > 0; i--) {
            getHero().recevoirExperience(getTableauMonstre().get(getEtat().getIndiceSuppressionMonstre().get(i - 1)));
            getTableauMonstre().remove((int) getEtat().getIndiceSuppressionMonstre().get(i - 1));
            if (bdd.placeInventaire(hero.getIdHero()) < 30) {
                hero.addInventaire(addItemInInventaire(bdd.dropEquipement((int) (Math.random() * (bdd.nbItem() - 1) + 1))));
                System.out.println("Place inventaire : " + (bdd.placeInventaire(hero.getIdHero())-1));
                System.out.println("Tu as récuperé : " + hero.getInventaire().get(bdd.placeInventaire(hero.getIdHero())-1).getNom());
            } else {
                System.out.println("Tu es plein !!");
            }
        }

        // supprime les sorts des mosntres
        for (int i = getEtat().getIndiceSuppressionSortMonstre().size(); i > 0; i--)
            getTableauSortMonstre().remove((int) getEtat().getIndiceSuppressionSortMonstre().get(i - 1));

        // supprime les sorts du hero
        for (int i = getEtat().getIndiceSuppressionSortHero().size(); i > 0; i--)
            getTableauSortHero().remove((int) getEtat().getIndiceSuppressionSortHero().get(i - 1));

        // met à jour le niveau et sauvegarde si gain de niveau
        int niveau = getHero().getNiveau();
        getHero().upNiveau();
        if (niveau < getHero().getNiveau()) {
            sauvegardeHero();
        }
    }


    public Etat getEtat() {
        return etat;
    }

    public BDD getBdd() {
        return bdd;
    }


    public void setHero(Hero hero) {
        this.hero = hero;
    }

    public Hero getHero() {
        return hero;
    }

    public ArrayList<Sort> getTableauSortHero() {
        return tableauSortHero;
    }

    public ArrayList<Monstre> getTableauMonstre() {
        return tableauMonstre;
    }

    public ArrayList<Sort> getTableauSortMonstre() {
        return tableauSortMonstre;
    }


    public void setNbPartieLibre(int nbPartieLibre) {
        this.nbPartieLibre = nbPartieLibre;
    }

    public int getNbPartieLibre() {
        return nbPartieLibre;
    }

    public void sauvegardeHero() {
        bdd.updateHero(hero.getIdHero(), hero.sauvegardeDonneesHeros());
    }

    public void supprimerPartie(int idPartie) {
        bdd.resetPartie(idPartie);
    }

    public void setHero(int id) {
        hero = new Hero(bdd.readHero(id, this, hero));
    }


    public void setMonstre(int id, int positionX, int positionY) {
        tableauMonstre.add(new Monstre(bdd.readMonstre(id, this, positionX, positionY)));
    }

    public int getNiveauDonjonActuelle() {
        return niveauDonjonActuelle;
    }

    public void setNiveauDonjonActuelle(int niveauDonjonActuelle) {
        this.niveauDonjonActuelle = niveauDonjonActuelle;
    }

    public int getidPartieLibre() {

        ArrayList<Integer> idPartieDispo = bdd.idPartieLibre();
        int partieDispo = 0;

        for (int i = 0; i < idPartieDispo.size(); i++) {
            if (idPartieDispo.get(i) > 0)
                System.out.println(i);
            partieDispo = idPartieDispo.get(i);
        }

        if (partieDispo > 0) {
            return partieDispo;
        } else {
            return 0;
        }
    }

    public int getBDDNbPartieLibre() {
        return bdd.nbPartieLibre();
    }

    public void createHeroBDD(String nom, int id) {
        bdd.createPerso(nom, id);
    }

    public String readLVLPerso(int id) {
        if (bdd.isBDD()) {
            return bdd.readNiveauPerso(id);
        } else {
            return "" + hero.getNieau();
        }
    }

    public String readNomPerso(int id) {
        return bdd.readNomPerso(id);
    }

    public Equipement addItemInInventaire(Equipement equipement) {
        bdd.possede(hero.getIdHero(), equipement.getIdItem());
        return equipement;
    }
}