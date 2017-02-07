package vue;

import controleur.ControlFenetreDepart;
import model.Direction;
import model.Jeu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

import static vue.Fenetre.*;

/**
 * Created by bastien on 29/09/16.
 */

public class FenetreJeu extends JPanel {

    private Jeu jeu;
    private ActionListener control;

    public EntiteVue hero;
    public ArrayList<EntiteVue> monstre;

    public ArrayList<EntiteVue> sortMonstre;
    public ArrayList<EntiteVue> sortHero;

    public JButton menu;
    private Image imageIconeSave;

    private int tailleMapX, tailleMapY;
    private final int TAILLE_TUILE = Fenetre.adapterResolutionEnX(50);
    private int tuileInt[][];
    public BufferedImage tuileImage[][];
    public static Dimension ZONE;


    public FenetreJeu(Jeu jeu) {

        this.jeu = jeu;

        this.setLayout(null);

        readMap("map/mapFenetreDepart.txt");
        tuileImage = new BufferedImage[tailleMapY][tailleMapX];
        chargerMap();

        ZONE = new Dimension(TAILLE_TUILE * tailleMapX, TAILLE_TUILE * tailleMapY);
        this.setPreferredSize(ZONE);

        hero = new EntiteVue(jeu);
        monstre = new ArrayList<EntiteVue>();

        imageIconeSave = getToolkit().getImage("images/iconeSave.png");

        menu = new JButton("");
        menu.setActionCommand("Menu");
        Image img = getToolkit().getImage("images/iconeMenu.png").getScaledInstance(Fenetre.adapterResolutionEnX(40), Fenetre.adapterResolutionEnY(40), java.awt.Image.SCALE_SMOOTH);
        menu.setIcon(new ImageIcon(img));
        this.add(menu);
        menu.addActionListener(control);
    }

    public void updateEntite() {

        // création du héro graphiquement
        if (jeu.getHero() != null && hero.entite == null)
            hero.creationEntite(jeu.getHero());

        // création des monstres graphiquement
        System.out.println("tabVue"+(monstre.size()));
        System.out.println("tabJeu"+jeu.getSizeTabMonstre());
        for (int i = monstre.size(); i<jeu.getSizeTabMonstre(); i++) {
            monstre.add(new EntiteVue(jeu));
            monstre.get(monstre.size() - 1).creationEntite(jeu.getMonstre(monstre.size() - 1));
        }

    }

    public void changerMap(String chemin) {
        readMap(chemin);
        tuileImage = new BufferedImage[tailleMapY][tailleMapX];
        chargerMap();

        ZONE = new Dimension(TAILLE_TUILE * tailleMapX, TAILLE_TUILE * tailleMapY);
        this.setPreferredSize(ZONE);

        jeu.getHero().setPositionY(-Fenetre.adapterResolutionEnY(200) + ZONE.height - jeu.getHero().getHauteurBas());
        if (jeu.getHero().getDirectionOrientation() == Direction.DROITE) {
            jeu.getHero().setPositionX(0);
            scrollPane.getViewport().setViewPosition(new Point(jeu.getHero().getPositionX(), (int) scrollPane.getViewport().getViewPosition().getY()));
        } else { // putin de gros bug ici je ne sais pas pourquoi !!! si je ne mets pas 2 fois setViewPosition il me met à la positon x = 293 pour une résolution de 960*540
            jeu.getHero().setPositionX(ZONE.width);
            scrollPane.getViewport().setViewPosition(new Point(jeu.getHero().getPositionX() - X, (int) scrollPane.getViewport().getViewPosition().getY()));
            scrollPane.getViewport().setViewPosition(new Point(jeu.getHero().getPositionX() - X, (int) scrollPane.getViewport().getViewPosition().getY()));
        }
    }

    public void readMap(String chemin) {
        ArrayList<String> listS = new ArrayList<>();
        int indice = 0;

        File fichier = new File(chemin);
        try {
            FileReader reader = new FileReader(fichier);
            BufferedReader br = new BufferedReader(reader);
            String s;

            while ((s = br.readLine()) != null) {
                indice++;
                listS.add(s);
            }
            reader.close();
        } catch (Exception e) {
            System.out.println("Impossible de lire le fichier");
        }

        tailleMapX = listS.get(0).split(",").length;
        tailleMapY = indice;

        tuileInt = new int[tailleMapY][tailleMapX];
        String tableau[][] = new String[tailleMapY][tailleMapX];

        for (int i = 0; i < tailleMapY; i++)
            tableau[i] = listS.get(i).split(",");

        for (int i = 0; i < tailleMapY; i++)
            for (int j = 0; j < tailleMapX; j++)

                tuileInt[i][j] = Integer.parseInt(tableau[i][j]);
    }

    public void chargerMap() {
        for (int i = 0; i < tailleMapY; i++)
            for (int j = 0; j < tailleMapX; j++)
                if (tuileInt[i][j] != -1)
                    tuileImage[i][j] = tableauTuile[tuileInt[i][j]];
    }

    public void setControl(ControlFenetreDepart controlFenetreDepart) {
        menu.addActionListener(controlFenetreDepart);
        control = controlFenetreDepart;
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        for (int i = 0; i < tailleMapY; i++)
            for (int j = 0; j < tailleMapX; j++)
                g.drawImage(tuileImage[i][j], TAILLE_TUILE * j, TAILLE_TUILE * i, TAILLE_TUILE, TAILLE_TUILE, this);

        menu.setBounds((int) (scrollPane.getViewport().getViewPosition().getX() + Fenetre.adapterResolutionEnX(1860)), (int) (scrollPane.getViewport().getViewPosition().getY() + Fenetre.adapterResolutionEnY(10)), Fenetre.adapterResolutionEnX(40), Fenetre.adapterResolutionEnY(40));
        menu.setBackground(new Color(0, 0, 0, 0));
        menu.setFocusable(false);
        menu.setCursor(new Cursor(Cursor.HAND_CURSOR));
        menu.setBorder(null);

        if (jeu.getSave())
            g.drawImage(imageIconeSave, (int) (scrollPane.getViewport().getViewPosition().getX() + Fenetre.adapterResolutionEnX(5)), (int) (scrollPane.getViewport().getViewPosition().getY() + Fenetre.adapterResolutionEnY(5)), Fenetre.adapterResolutionEnX(50), Fenetre.adapterResolutionEnY(50), this);

        for (EntiteVue e : monstre)
            e.paintComponent(g);

        hero.paintComponent(g);
    }
}