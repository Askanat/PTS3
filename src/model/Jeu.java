package model;

/**
 * Created by bastien on 28/09/16.
 */

public class Jeu {

    private Hero hero;

    private boolean pause;

    public Jeu() {
        hero = new Hero("testHero", 10, 10, 1, 300, 300);
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

}