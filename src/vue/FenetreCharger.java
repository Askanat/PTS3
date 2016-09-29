package vue;

import controleur.ControlFenetreCharger;
import model.Jeu;

import javax.swing.*;
import java.awt.*;

/**
 * Created by bastien on 29/09/16.
 */

public class FenetreCharger extends JPanel {

    public Jeu jeu;

    public FenetreCharger(Jeu jeu) {
        this.jeu = jeu;
    }

    public void setControl(ControlFenetreCharger controlFenetreCharger) {
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
    }
}
