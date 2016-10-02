package model;

import java.io.IOException;

/**
 * Created by bastien on 28/09/16.
 */

public class Jeu {

    private Hero hero;

    private boolean pause;

    public Jeu() throws IOException {
        hero = new Hero("testHero", 10, 10, 1, 0, 0, null);
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

}