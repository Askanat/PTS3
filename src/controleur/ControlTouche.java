package controleur;

import java.awt.event.KeyEvent;
import java.lang.reflect.Field;

/**
 * Created by raphael on 11/8/16.
 * <p>
 * Le fichier contient la liste des actions possible en cours de jeu. Il associe à chaque action une touche.
 * Lors de l'ajout d'une action : ne pas oublier de mettre à jour le constructeur afin d'y associer une touche par défaut.
 */

public class ControlTouche {
    // Liste des actions possibles en cours de jeu

    public static final int
            ACTION_MENU = 0,
            ACTION_GAUCHE = 1,
            ACTION_DROITE = 2,
            ACTION_SAUT = 3,
            ACTION_DESCENDRE = 4,
            ACTION_ATTAQUE = 5,
            ACTION_SORT1 = 6,
            ACTION_SORT2 = 7,
            ACTION_SORT3 = 8,
            ACTION_SORT4 = 9,
            ACTION_SORT5 = 10,
            ACTION_SORT6 = 11,
            ACTION_SORT7 = 12,
            ACTION_SORT8 = 13;
    private int[] touches;
    private int nbActions;

    public ControlTouche() {
        Field[] fields = ControlTouche.class.getDeclaredFields();

        nbActions = fields.length - 2;
        touches = new int[nbActions];

        // Touches par défaut

        touches[ACTION_MENU] = KeyEvent.VK_ESCAPE;
        touches[ACTION_GAUCHE] = KeyEvent.VK_LEFT;
        touches[ACTION_DROITE] = KeyEvent.VK_RIGHT;
        touches[ACTION_SAUT] = KeyEvent.VK_UP;
        touches[ACTION_DESCENDRE] = KeyEvent.VK_DOWN;
        touches[ACTION_ATTAQUE] = KeyEvent.VK_A;
        touches[ACTION_SORT1] = KeyEvent.VK_F1;
        touches[ACTION_SORT2] = KeyEvent.VK_F2;
        touches[ACTION_SORT3] = KeyEvent.VK_F3;
        touches[ACTION_SORT4] = KeyEvent.VK_F4;
        touches[ACTION_SORT5] = KeyEvent.VK_F5;
        touches[ACTION_SORT6] = KeyEvent.VK_F6;
        touches[ACTION_SORT7] = KeyEvent.VK_F7;
        touches[ACTION_SORT8] = KeyEvent.VK_F8;
    }

    public int getNbActions() {
        return nbActions;
    }

    public int[] getTouches() {
        return touches;
    }

    public String getNomTouche(int codeAction) {
        return KeyEvent.getKeyText(touches[codeAction]);
    }

    /*
     * setActionTouche : Change la touche associée à une action
     *
     * @codeAction : une des constantes définie dans ControlTouche
     * @touche : une touche définie dans la classe KeyEvent
     */

    public void setActionTouche(int codeAction, int touche) {
        touches[codeAction] = touche;
    }
}
