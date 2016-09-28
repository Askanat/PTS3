import controleur.ControlGroup;
import model.Jeu;

/**
 * Created by bastien on 22/09/16.
 */
public class Appli {

    public static void main(String[] args) {

        Jeu jeu = new Jeu();
        ControlGroup controlGroup = new ControlGroup(jeu);
    }
}
