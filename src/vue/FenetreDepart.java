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

    private final int NOMBRE_DE_EQUIPEMENT = 0;
    private final int NOMBRE_DE_PNG = 0;

    public Entite[] hero; // le héro et ses équipements
    public Entite[] png; // tous les png présents sur la carte de départ
    public ArrayList<Entite> monstre; // a enlever d'ici

    public FenetreDepart(Jeu jeu) {

        this.jeu = jeu;

        this.setLayout(null);
        setPreferredSize(new Dimension(X, Y));

        hero = new Entite[NOMBRE_DE_EQUIPEMENT + 1]; // tableau qui regroupe le héro + ses équipements
        for (int i = 0; i < hero.length; i++)
            hero[i] = new Entite();

        png = new Entite[NOMBRE_DE_PNG];
        for (int i = 0; i < png.length; i++)
            png[i] = new Entite();

        monstre = new ArrayList<Entite>(); // a enlever d'ici
    }

    public void dessineHero(int id) {
        hero[0].creationEntite(jeu.getHero(), jeu.getBDD().readHeroTexture(id));
    }

    public void dessinePng() {
    }

    public void dessineMonstre(int id) {
        monstre.add(new Entite());
        monstre.get(monstre.size() - 1).creationEntite(jeu.getMonstre(id - 1), jeu.getBDD().readMonstreTexture(id));
    }

    public void setControl(ControlFenetreDepart controlFenetreDepart) {
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        for (Entite e : monstre)
            e.paintComponent(g);

        for (Entite e : png)
            e.paintComponent(g);

        for (Entite e : hero)
            e.paintComponent(g);

        //hero[0].paintComponent(g);
    }
}