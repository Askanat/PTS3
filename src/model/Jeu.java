package model;

import controleur.Control;
import vue.Fenetre;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by bastien on 28/09/16.
 */

public class Jeu {

    public static final int GRAVITE = Fenetre.adapterResolutionEnY(8);

    private int temps;

    private Niveau niveau;
    private Hero hero;
    private ArrayList<Monstre> tableauMonstre;
    private BDD bdd;

    private boolean pause;

    public Jeu() throws SQLException {

        tableauMonstre = new ArrayList<>();
        temps = 0;
        pause = false;

        bdd = new BDD();
    }

    public void nouvellePartie() {

    }

    public void continuerPartie() {

    }

    public void supprimerPartie(int idPartie) {
        bdd.resetPartie(idPartie);
    }

    public BDD getBDD() {
        return bdd;
    }

    public void setPause(boolean pause) {
        this.pause = pause;
    }

    public final boolean getPause() {
        return pause;
    }

    public void setHero(int id) {
        ArrayList<String> donneesHero;

        donneesHero = bdd.readHero(id);

        hero = new Hero(donneesHero.get(0), Integer.parseInt(donneesHero.get(1)), Double.parseDouble(donneesHero.get(2)),
                Double.parseDouble(donneesHero.get(3)), Double.parseDouble(donneesHero.get(4)), Double.parseDouble(donneesHero.get(5)),
                Double.parseDouble(donneesHero.get(6)), Double.parseDouble(donneesHero.get(7)), Double.parseDouble(donneesHero.get(8)),
                Double.parseDouble(donneesHero.get(9)), Integer.parseInt(donneesHero.get(10)), donneesHero.get(11), Fenetre.adapterResolutionEnX(500), Fenetre.adapterResolutionEnY(500));
    }

    public Hero getHero() {
        return hero;
    }

    public void setMonstre(int id, int positionX, int positionY) {
        // Pour le moment on sélectionne le hero 1
        if (hero == null)
            setHero(1); // je ne comprend pas

        ArrayList<String> donneesMonstre;

        donneesMonstre = bdd.readMonstre(id);

        tableauMonstre.add(new Monstre(donneesMonstre.get(0), Double.parseDouble(donneesMonstre.get(1)), Double.parseDouble(donneesMonstre.get(2)),
                Double.parseDouble(donneesMonstre.get(3)), Double.parseDouble(donneesMonstre.get(4)), Double.parseDouble(donneesMonstre.get(5)), positionX, positionY,
                1, 1, hero));
    }

    public Monstre getMonstre(int i) {

        return tableauMonstre.get(i);
    }

    public int getSizeTabMonstre() {
        return tableauMonstre.size();
    }

    public void inversePause() {
        if (Control.enPartie) setPause(!getPause());
    }

    public void incrementeTemps() {
        temps++;
    }

    public int getTemps() {
        return temps;
    }

    public int getidPartieLibre() {

        ArrayList<Integer> idPartieDispo = bdd.idPartieLibre();
        int partieDispo = 0;

        for(int i=0;i<idPartieDispo.size();i++){
            if(idPartieDispo.get(i) > 0)
                System.out.println(i);
                partieDispo = idPartieDispo.get(i);
        }

        if(partieDispo > 0) {
            return partieDispo;
        } else {
            return 0;
        }
    }

    public int getNbPartieLibre() {
        int nbPartieLibre = bdd.nbPartieLibre();
        return nbPartieLibre;
    }

    public void createHeroBDD(String nom, int id) {
        bdd.createPerso(nom, id);
    }
}