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

    public JButton menu;

    public FenetreDepart(Jeu jeu) {

        this.jeu = jeu;

        this.setLayout(null);
        setPreferredSize(new Dimension(X, Y));

        hero = new Entite(jeu);

        png = new Entite[NOMBRE_DE_PNG];
        for (int i = 0; i < png.length; i++)
            png[i] = new Entite(jeu);

        monstre = new ArrayList<Entite>(); // a enlever d'ici

        bouttonMenu();
    }

    public void bouttonMenu(){
        menu = new JButton("YOLO");
        menu.setActionCommand("Menu");

        add(menu);
    }

    public void dessineHero() {
        hero.creationEntite(jeu.getHero());
    }

    public void dessineMonstre(int id) {
        monstre.add(new Entite(jeu));
        monstre.get(monstre.size() - 1).creationEntite(jeu.getMonstre(jeu.getSizeTabMonstre() - 1));
    }

    public void setControl(ControlFenetreDepart controlFenetreDepart) {
        menu.addActionListener(controlFenetreDepart);
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Image img = getToolkit().getImage("images/fondJeux.png");
        g.drawImage(img, 0, 0, getWidth(), getHeight(), this);

        menu.setBounds(Fenetre.adapterResolutionEnX(1860), Fenetre.adapterResolutionEnY(10), Fenetre.adapterResolutionEnX(50), Fenetre.adapterResolutionEnY(50));
        menu.setBackground(new Color(0, 0, 0, 0));
        menu.setFocusable(false);
        menu.setCursor(new Cursor(Cursor.HAND_CURSOR));
        menu.setBorder(null);

        Image imageMenu = getToolkit().getImage("images/iconMenu.png");
        g.drawImage(imageMenu, Fenetre.adapterResolutionEnX(1860), Fenetre.adapterResolutionEnY(10), Fenetre.adapterResolutionEnX(50), Fenetre.adapterResolutionEnY(50), this);

        // a déplacer
        for (Entite e : monstre)
            e.paintComponent(g);

        for (Entite e : png)
            e.paintComponent(g);

        hero.paintComponent(g);
        img = null;
        if (jeu.getSave())
            img = getToolkit().getImage("images/iconeSave.png");
        g.drawImage(img, Fenetre.adapterResolutionEnX(5), Fenetre.adapterResolutionEnY(5), Fenetre.adapterResolutionEnX(50), Fenetre.adapterResolutionEnY(50), this);
    }
}