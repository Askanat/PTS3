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
    Hero hero;

    public FenetreDepart(Jeu jeu) {
        this.jeu = jeu;
        hero = new Hero("test", 10, 10, 5, 0, 0, null);
        this.setLayout(null);
        setPreferredSize(new Dimension(800, 600));
    }

    public void setControl(ControlFenetreDepart controlFenetreDepart) {
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // test sprite
        Image img = getToolkit().getImage("images/test1.png");
        g.drawImage(img, hero.getPositionX(), hero.getPositionY(), getWidth(), getHeight(), this);
    }
}