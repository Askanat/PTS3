package model;
import java.sql.*;

/**
 * Created by bastien on 28/09/16.
 */

public class Jeu {

    private int temps;

    private Niveau niveau;
    private Hero hero;
    private Monstre tableauMonstre[];

    private boolean pause;

    public Jeu() {

        temps = 0;
        pause = false;

        //donneesHero = recupDonneesHeros();

        hero = new Hero("Hero", 1, 0, 100, 4, 0, 0, 0, 0, 100, 100, 500, 500);
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