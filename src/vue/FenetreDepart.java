package vue;

import controleur.ControlFenetreDepart;
import model.Jeu;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;

import static vue.Fenetre.X;
import static vue.Fenetre.Y;

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
        monstre = new ArrayList<>();
    }

    public void dessineHero(int id) {
        hero.creationEntite(jeu.getHero(), jeu.getBDD().readHeroTexture(id));
    }

    public void dessineMonstre(int id) {
        monstre.get(id).creationEntite(jeu.getMonstre(id-1), jeu.getBDD().readMonstreTexture(id));
    }

    public void setControl(ControlFenetreDepart controlFenetreDepart) {
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        hero.paintComponent(g);
    }
}