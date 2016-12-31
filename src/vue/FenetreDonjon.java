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

    private ArrayList<JProgressBar> barreDeVie;

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
        barreDeVie = new ArrayList<>();
    }

    public void dessineHero(int id) {
        hero[0].creationEntite(jeu.getHero(), jeu.getBDD().readHeroTexture(id));
    }

    public void dessineMonstre(int id) {
        monstre.add(new Entite());
        monstre.get(monstre.size() - 1).creationEntite(jeu.getMonstre(id - 1), jeu.getBDD().readMonstreTexture(id));
    }

    public void setControl(ControlFenetreDonjon controlFenetreDonjon) {
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        for (Entite e : monstre)
            e.paintComponent(g);

        System.out.println("JE SUIS LAAAAA");

        for (int i = 0;i<=barreDeVie.size();i++) {
            barreDeVie.get(i).setMaximum((int)jeu.getMonstre(i).getVieMax());
            barreDeVie.get(i).setMinimum(0);
            barreDeVie.get(i).setAlignmentX(jeu.getMonstre(i).getPositionX());
            barreDeVie.get(i).setAlignmentY(jeu.getMonstre(i).getPositionY());
            barreDeVie.get(i).setBorderPainted(true);
            barreDeVie.get(i).setBackground(Color.red);
        }

        for(JProgressBar j : barreDeVie)
            j.paintComponents(g);

        for (Entite e : hero)
            e.paintComponent(g);
    }
}