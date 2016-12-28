package controleur;

import java.awt.event.KeyEvent;
import java.lang.reflect.Field;

/**
 * Created by raphael on 11/8/16.
 *
 * Ce fichier contient la liste des touches utilisées dans le jeu.
 *
 * Si vous voulez ajouter une touche mettez la à la suite avec comme valeur la touche précédente + 1.
 * N'oubliez pas de mettre ensuite à jour la méthode getJavaTouches(). Faites attention à bien respecter l'ordre.
 *
 * C'est plus pratique que de se reférer à un numéro dans ControlTimer.
 */

public class ControlTouche {
    public static final int
    ECHAP = 0,
    GAUCHE = 1,
    HAUT = 2,
    DROITE = 3,
    BAS = 4,
    A = 5;

    public static int getNbTouches() {
        Field[] fields = ControlTouche.class.getDeclaredFields();
        return fields.length;
    }

    public static int[] getJavaTouches()
    {
        int touches[] = {
                KeyEvent.VK_ESCAPE,
                KeyEvent.VK_LEFT,
                KeyEvent.VK_UP,
                KeyEvent.VK_RIGHT,
                KeyEvent.VK_DOWN,
                KeyEvent.VK_A
        };
        return touches;
    }
}
