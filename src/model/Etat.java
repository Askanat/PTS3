package model;

import controleur.Control;

import java.util.ArrayList;

/**
 * Created by bastien on 10/02/17.
 */
public class Etat {

    private int temps;

    private boolean suppressionHero;
    private ArrayList<Integer> indiceSuppressionMonstre;
    private ArrayList<Integer> indiceSuppressionSortMonstre;
    private ArrayList<Integer> indiceSuppressionSortHero;

    private boolean hitBox;
    private boolean save;
    private boolean pause;
    private boolean zoneSafe;

    public Etat() {

        temps = 0;

        suppressionHero = false;
        indiceSuppressionMonstre = new ArrayList<Integer>();
        indiceSuppressionSortMonstre = new ArrayList<Integer>();
        indiceSuppressionSortHero = new ArrayList<Integer>();

        hitBox = false;
        save = false;
        pause = false;
        zoneSafe = true;

    }

    public void incrementeTemps() {
        temps++;
    }

    public void setTemps(int temps) {
        this.temps = temps;
    }

    public int getTemps() {
        return temps;
    }


    public void setSuppressionHero(boolean suppressionHero) {
        this.suppressionHero = suppressionHero;
    }

    public boolean getSuppressionHero() {
        return suppressionHero;
    }

    public ArrayList<Integer> getIndiceSuppressionMonstre() {
        return indiceSuppressionMonstre;
    }

    public ArrayList<Integer> getIndiceSuppressionSortMonstre() {
        return indiceSuppressionSortMonstre;
    }

    public ArrayList<Integer> getIndiceSuppressionSortHero() {
        return indiceSuppressionSortHero;
    }


    public void setHitBox(boolean hitBox) {
        this.hitBox = hitBox;
    }

    public boolean getHitBox() {
        return hitBox;
    }

    public void setSave(boolean save) {
        this.save = save;
    }

    public boolean getSave() {
        return save;
    }

    public void inversePause() {
        if (Control.enPartie) setPause(!getPause());
    }

    public void setPause(boolean pause) {
        this.pause = pause;
    }

    public final boolean getPause() {
        return pause;
    }

    public void setZoneSafe(boolean zoneSafe) {
        this.zoneSafe = zoneSafe;
    }

    public boolean getZoneSafe() {
        return zoneSafe;
    }
}
