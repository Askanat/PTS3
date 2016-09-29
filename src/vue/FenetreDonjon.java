package vue;

import controleur.ControlFenetreDonjon;
import model.Jeu;

import javax.swing.*;
import java.awt.*;

/**
 * Created by bastien on 29/09/16.
 */

public class FenetreDonjon extends JPanel {

    public Jeu jeu;

    public FenetreDonjon(Jeu jeu) {
        this.jeu = jeu;
    }

    public void setControl(ControlFenetreDonjon controlFenetreDonjon) {
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
    }
}
