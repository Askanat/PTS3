package model;

import java.util.Random;

/**
 * Created by leo on 02/10/16.
 */

public class Niveau {

    private int tableau[][];

    private static int TAILLE_X_MIN = 500;
    private static int TAILLE_X_MAX = 1000;

    private static int TAILLE_Y_MIN = 500;
    private static int TAILLE_Y_MAX = 1000;

    private static int NUM_MAX_BLOCK_VIDE = 0;
    private static int NUM_MAX_BLOCK_COLLISION = 100;
    private static int NUM_MAX_BLOCK_DESTRUCTIBLE = 200;

    public Niveau() {
        Random rand = new Random();
        int tailleX = rand.nextInt((TAILLE_X_MAX - TAILLE_X_MIN) + 1) + TAILLE_X_MIN;
        int tailleY = rand.nextInt((TAILLE_Y_MAX - TAILLE_Y_MIN) + 1) + TAILLE_Y_MIN;

        tableau = new int[tailleX][tailleY];
        generer(tailleX, tailleY);
    }

    public Niveau(int tailleX, int tailleY) {
        tableau = new int[tailleX][tailleY];
        generer(tailleX, tailleY);
    }

    public void generer(int tailleX, int tailleY) {
        int i, j;

        for(i = 0; i < tailleX; i++) {
            for(j = 0; j < tailleY; j++) {
                // A compléter
            }
        }
    }
}
