package vue;

import controleur.ControlFenetreDepart;
import model.Jeu;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

import static vue.Fenetre.X;
import static vue.Fenetre.Y;

/**
 * Created by bastien on 29/09/16.
 */

public class FenetreDepart extends JPanel {

    private Jeu jeu;
    public Entite hero;

    public FenetreDepart(Jeu jeu) {

        this.jeu = jeu;

        this.setLayout(null);
        setPreferredSize(new Dimension(X, Y));

        try {
            hero = new Entite(jeu.getHero(), "images/test3.png");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void setControl(ControlFenetreDepart controlFenetreDepart) {
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        hero.paintComponent(g);
    }
}