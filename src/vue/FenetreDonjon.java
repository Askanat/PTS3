package vue;

import controleur.ControlFenetreDonjon;
import model.Jeu;

import javax.swing.*;
import java.awt.*;

import static vue.Fenetre.X;
import static vue.Fenetre.Y;

/**
 * Created by bastien on 29/09/16.
 */

public class FenetreDonjon extends JPanel {

    private Jeu jeu;

    public FenetreDonjon(Jeu jeu) {
        this.jeu = jeu;

        this.setLayout(null);
        setPreferredSize(new Dimension(X, Y));
    }

    public void setControl(ControlFenetreDonjon controlFenetreDonjon) {
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
    }
}