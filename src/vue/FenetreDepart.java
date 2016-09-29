package vue;

import controleur.ControlFenetreDepart;
import model.Jeu;

import javax.swing.*;
import java.awt.*;

/**
 * Created by bastien on 29/09/16.
 */

public class FenetreDepart extends JPanel {

    public Jeu jeu;

    public FenetreDepart(Jeu jeu) {
        this.jeu = jeu;
    }

    public void setControl(ControlFenetreDepart controlFenetreDepart) {
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
    }
}
