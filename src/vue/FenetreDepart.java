package vue;

import controleur.ControlFenetreDepart;
import model.Jeu;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

import static vue.Fenetre.X;
import static vue.Fenetre.Y;

/**
 * Created by bastien on 29/09/16.
 */

public class FenetreDepart extends JPanel {

    private Jeu jeu;

    private final int NOMBRE_DE_EQUIPEMENT = 0;
    private final int NOMBRE_DE_PNG = 0;

    public Entite hero; // le héro
    public Entite[] png; // tous les png présents sur la carte de départ
    public ArrayList<Entite> monstre; // a déplacer

    public FenetreDepart(Jeu jeu) {

        this.jeu = jeu;

        this.setLayout(null);
        setPreferredSize(new Dimension(X, Y));

        hero = new Entite(jeu);

        png = new Entite[NOMBRE_DE_PNG];
        for (int i = 0; i < png.length; i++)
            png[i] = new Entite(jeu);

        monstre = new ArrayList<Entite>(); // a enlever d'ici
    }

    public void dessineHero() {
        hero.creationEntite(jeu.getHero());
    }

    public void dessinePng() {
    }

    public void dessineMonstre(int id) {
        monstre.add(new Entite(jeu));
        monstre.get(monstre.size() - 1).creationEntite(jeu.getMonstre(jeu.getSizeTabMonstre() - 1));
    }

    public void setControl(ControlFenetreDepart controlFenetreDepart) {
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // a déplacer
        for (Entite e : monstre)
            e.paintComponent(g);

        for (Entite e : png)
            e.paintComponent(g);

        hero.paintComponent(g);

        Image img = null;
        if (jeu.getSave())
            img = getToolkit().getImage("images/iconeSave.png");
        g.drawImage(img, Fenetre.adapterResolutionEnX(5), Fenetre.adapterResolutionEnY(5), Fenetre.adapterResolutionEnX(50), Fenetre.adapterResolutionEnY(50), this);

    }
}