package model;

/**
 * Created by bastien on 16/11/16.
 */
public class Direction {
    public final static int DROITE = 0, GAUCHE = 1;

    private int direction;

    public Direction(int dir) {
    	direction = dir;
    }

    public void setDirection(int dir) {
    	direction = dir;
    }

    public int getDirection() {
    	return direction;
    }

    public void inverse() {
    	if(direction == DROITE)
    		direction = GAUCHE;
    	else
    		direction = DROITE;
    }

    public void print() {
    	if(direction == DROITE)
    		System.err.println("DROITE (" + DROITE + ")");
    	else
    		System.err.println("GAUCHE (" + GAUCHE + ")");
    }
}
