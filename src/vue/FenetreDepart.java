package vue;

import controleur.ControlFenetreDepart;
import model.Hero;
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
        this.setLayout(null);
        setPreferredSize(new Dimension(800, 800));
    }

    public void setControl(ControlFenetreDepart controlFenetreDepart) {
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // test sprite
        g.drawImage(Hero.spriteActuelle, jeu.getHero().getPositionX(), jeu.getHero().getPositionY(), this);
    }
}