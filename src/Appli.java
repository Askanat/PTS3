import controleur.ControlGroup;
import model.Direction;
import model.Jeu;
import model.Niveau;

/**
 * Created by bastien on 22/09/16.
 */

public class Appli {

    public static void main(String[] args) {

        Jeu jeu = new Jeu();
        ControlGroup controlGroup = new ControlGroup(jeu);

        //Niveau niveau = new Niveau(50, 1, Direction.GAUCHE);
        //niveau.print();
    }
}