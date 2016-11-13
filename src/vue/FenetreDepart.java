package vue;

import controleur.ControlFenetreDepart;
import model.Jeu;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

import static model.Jeu.X;
import static model.Jeu.Y;

/**
 * Created by bastien on 29/09/16.
 */

public class FenetreDepart extends JPanel {

    private Jeu jeu;
    public Entite hero;
    public ArrayList<Entite> monstre;

    public FenetreDepart(Jeu jeu) {

        this.jeu = jeu;

        this.setLayout(null);
        setPreferredSize(new Dimension(X, Y));

        hero = new Entite();
        monstre = new ArrayList<Entite>();
    }

    public void dessineHero(int id) {
        hero.creationEntite(jeu.getHero(), jeu.getBDD().readHeroTexture(id));
    }

    public void dessineMonstre(int id) {
        monstre.add(new Entite());
        monstre.get(monstre.size() - 1).creationEntite(jeu.getMonstre(id - 1), jeu.getBDD().readMonstreTexture(id));
    }

    public void setControl(ControlFenetreDepart controlFenetreDepart) {
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        hero.paintComponent(g);

        for (Entite e : monstre)
            e.paintComponent(g);
    }
}