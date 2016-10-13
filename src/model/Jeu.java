package model;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by bastien on 28/09/16.
 */

public class Jeu {

    private int temps;

    private Niveau niveau;
    private Hero hero;
    private Monstre tableauMonstre[];
    private BDD bdd;

    private boolean pause;

    public Jeu() throws SQLException {

        temps = 0;
        pause = false;

        bdd = new BDD();
    }

    public void nouvellePartie() {

    }

    public void continuerPartie() {

    }

    public void setPause(boolean pause) {
        this.pause = pause;
    }

    public final boolean getPause() {
        return pause;
    }

    public void setHero(int id) {
        ArrayList<String> donneesHero;

        donneesHero = bdd.readHero(1);

        hero = new Hero(donneesHero.get(0), Integer.parseInt(donneesHero.get(1)), Integer.parseInt(donneesHero.get(2)),
                Integer.parseInt(donneesHero.get(3)), Integer.parseInt(donneesHero.get(4)), Integer.parseInt(donneesHero.get(5)),
                Integer.parseInt(donneesHero.get(6)), Integer.parseInt(donneesHero.get(7)), Integer.parseInt(donneesHero.get(8)),
                Integer.parseInt(donneesHero.get(9)), Integer.parseInt(donneesHero.get(10)), 500, 500);
    }

    public Hero getHero() {
        return hero;
    }

    public void inversePause() {
        setPause(!getPause());
    }

    public void incrementeTemps() {
        temps++;
    }

    public int getTemps() {
        return temps;
    }
}