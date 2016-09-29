package vue;

import controleur.ControlFenetreNouvellePartie;
import model.Jeu;

import javax.swing.*;
import java.awt.*;

/**
 * Created by bastien on 29/09/16.
 */

public class FenetreNouvellePartie extends JPanel {

    public Jeu jeu;

    public FenetreNouvellePartie(Jeu jeu) {
        this.jeu = jeu;
    }

    public void setControl(ControlFenetreNouvellePartie controlFenetreNouvellePartie) {
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
    }
}
