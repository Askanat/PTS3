package vue;

import controleur.ControlFenetreDonjon;
import model.Jeu;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

import static vue.Fenetre.X;
import static vue.Fenetre.Y;


/**
 * Created by bastien on 29/09/16.
 */

public class FenetreDonjon extends JPanel {

    private Jeu jeu;

    private final int NOMBRE_DE_EQUIPEMENT = 0;

    public Entite[] hero; // le héro et ses équipements
    public ArrayList<Entite> monstre; // a enlever d'ici

    public FenetreDonjon(Jeu jeu) {

        this.jeu = jeu;

        this.setLayout(null);
        setPreferredSize(new Dimension(X, Y));

        hero = new Entite[NOMBRE_DE_EQUIPEMENT + 1]; // tableau qui regroupe le héro + ses équipements
        for (int i = 0; i < hero.length; i++)
            hero[i] = new Entite();

        monstre = new ArrayList<Entite>();
    }

    public void dessineHero() {
        hero[0].creationEntite(jeu.getHero());
    }

    public void dessineMonstre(int id) {
        monstre.add(new Entite());
        monstre.get(monstre.size() - 1).creationEntite(jeu.getMonstre(id - 1));
    }

    public void setControl(ControlFenetreDonjon controlFenetreDonjon) {
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        for (Entite e : monstre)
            e.paintComponent(g);

        for (Entite e : hero)
            e.paintComponent(g);
    }
}