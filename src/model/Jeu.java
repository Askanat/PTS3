package model;

import controleur.Control;

import java.awt.*;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by bastien on 28/09/16.
 */

public class Jeu {

    public static Dimension tailleEcran = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
    public static final int X = (int)tailleEcran.getWidth();
    public static final int Y = (int)tailleEcran.getHeight();

    public static final int GRAVITE = (int) (1 / 135.0 * Y);

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

        hero = new Hero(donneesHero.get(0), Integer.parseInt(donneesHero.get(1)), Integer.parseInt(donneesHero.get(2)),
                Integer.parseInt(donneesHero.get(3)), Integer.parseInt(donneesHero.get(4)), Integer.parseInt(donneesHero.get(5)),
                Integer.parseInt(donneesHero.get(6)), Integer.parseInt(donneesHero.get(7)), Integer.parseInt(donneesHero.get(8)),
                Integer.parseInt(donneesHero.get(9)), Integer.parseInt(donneesHero.get(10)), (int) (25 / 96.0 * X), (int) (25 / 51.0 * Y));
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

        tableauMonstre.add(new Monstre(donneesMonstre.get(0), Integer.parseInt(donneesMonstre.get(1)), Integer.parseInt(donneesMonstre.get(2)),
                Integer.parseInt(donneesMonstre.get(3)), Integer.parseInt(donneesMonstre.get(4)), Integer.parseInt(donneesMonstre.get(5)), positionX, positionY,
                Integer.parseInt(donneesMonstre.get(6)), Integer.parseInt(donneesMonstre.get(6)), hero));
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
}