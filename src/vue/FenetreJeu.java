package vue;

import controleur.ControlFenetreJeu;
import model.Direction;
import model.Jeu;

import javax.swing.*;
import java.awt.*;
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

    private int tailleMapX, tailleMapY;
    private final int TAILLE_TUILE = Fenetre.adapterResolutionEnX(50);
    private int tuileInt[][];
    public BufferedImage tuileImage[][];
    public static Dimension ZONE;


    public ArrayList<EntiteVue> monstre;
    public EntiteVue hero;
    public ArrayList<EntiteVue> sortMonstre;
    public ArrayList<EntiteVue> sortHero;

    private Image imageIconeSave;
    public JButton menu;


    public FenetreJeu(Jeu jeu) {

        this.jeu = jeu;

        this.setLayout(null);

        readMap("map/mapFenetreDepart.txt");
        tuileImage = new BufferedImage[tailleMapY][tailleMapX];
        chargerMap();

        ZONE = new Dimension(TAILLE_TUILE * tailleMapX, TAILLE_TUILE * tailleMapY);
        this.setPreferredSize(ZONE);


        monstre = new ArrayList<>();
        hero = null;
        sortMonstre = new ArrayList<>();
        sortHero = new ArrayList<>();

        imageIconeSave = getToolkit().getImage("images/iconeSave.png");
        menu = new JButton("");
        menu.setActionCommand("Menu");
        Image img = getToolkit().getImage("images/iconeMenu.png").getScaledInstance(Fenetre.adapterResolutionEnX(40), Fenetre.adapterResolutionEnY(40), java.awt.Image.SCALE_SMOOTH);
        menu.setIcon(new ImageIcon(img));
        this.add(menu);
    }

    public void updateEntite() {

        // création du héro graphiquement
        if (jeu.getHero() != null && hero == null) {
            hero = new EntiteVue(jeu);
            hero.creationEntite(jeu.getHero());
        }

        // création des monstres graphiquement
        for (int i = monstre.size(); i < jeu.getTableauMonstre().size(); i++) {
            monstre.add(new EntiteVue(jeu));
            monstre.get(monstre.size() - 1).creationEntite(jeu.getTableauMonstre().get(monstre.size() - 1));
        }

        //création des sorts des monstres graphiquement
        for (int i = sortMonstre.size(); i < jeu.getTableauSortMonstre().size(); i++) {
            sortMonstre.add(new EntiteVue(jeu));
            sortMonstre.get(sortMonstre.size() - 1).creationEntite(jeu.getTableauSortMonstre().get(sortMonstre.size() - 1));
        }

        //création des sorts du hero graphiquement
        for (int i = sortHero.size(); i < jeu.getTableauSortHero().size(); i++) {
            sortHero.add(new EntiteVue(jeu));
            sortHero.get(sortHero.size() - 1).creationEntite(jeu.getTableauSortHero().get(sortHero.size() - 1));
        }

        // suppression monstre graphiquement
        for (int i = jeu.getEtat().getIndiceSuppressionMonstre().size(); i > 0; i--) {
            int valeur = jeu.getEtat().getIndiceSuppressionMonstre().get(i - 1);
            monstre.remove(valeur);
            jeu.getEtat().getIndiceSuppressionMonstre().remove(i - 1);
        }

        // suppression sort Monstre graphiquement
        for (int i = jeu.getEtat().getIndiceSuppressionSortMonstre().size(); i > 0; i--) {
            int valeur = jeu.getEtat().getIndiceSuppressionSortMonstre().get(i - 1);
            sortMonstre.remove(valeur);
            jeu.getEtat().getIndiceSuppressionSortMonstre().remove(i - 1);
        }

        // suppression sort Hero graphiquement
        for (int i = jeu.getEtat().getIndiceSuppressionSortHero().size(); i > 0; i--) {
            int valeur = jeu.getEtat().getIndiceSuppressionSortHero().get(i - 1);
            sortHero.remove(valeur);
            jeu.getEtat().getIndiceSuppressionSortHero().remove(i - 1);
        }

        // changement de zone : zone-safe <-> zone-donjon
        if (jeu.getHero().getPositionX() > ZONE.width) {
            changerMap("map/mapFenetreDonjon.txt");
            jeu.getEtat().setZoneSafe(false);
        } else if (jeu.getHero().getPositionX() < 0 && !jeu.getEtat().getZoneSafe()) {
            changerMap("map/mapFenetreDepart.txt");
            jeu.getEtat().setZoneSafe(true);
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

    public void setControl(ControlFenetreJeu controlFenetreJeu) {
        menu.addActionListener(controlFenetreJeu);
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // dessine la carte
        for (int i = 0; i < tailleMapY; i++)
            for (int j = 0; j < tailleMapX; j++)
                g.drawImage(tuileImage[i][j], TAILLE_TUILE * j, TAILLE_TUILE * i, TAILLE_TUILE, TAILLE_TUILE, this);

        // dessine les entites
        for (EntiteVue e : monstre)
            e.paintComponent(g);

        hero.paintComponent(g);

        for (EntiteVue e : sortMonstre)
            e.paintComponent(g);

        for (EntiteVue e : sortHero)
            e.paintComponent(g);

        menu.setBounds((int) (scrollPane.getViewport().getViewPosition().getX() + Fenetre.adapterResolutionEnX(1860)), (int) (scrollPane.getViewport().getViewPosition().getY() + Fenetre.adapterResolutionEnY(10)), Fenetre.adapterResolutionEnX(40), Fenetre.adapterResolutionEnY(40));
        menu.setBackground(new Color(0, 0, 0, 0));
        menu.setFocusable(false);
        menu.setCursor(new Cursor(Cursor.HAND_CURSOR));
        menu.setBorder(null);

        if (jeu.getEtat().getSave())
            g.drawImage(imageIconeSave, (int) (scrollPane.getViewport().getViewPosition().getX() + Fenetre.adapterResolutionEnX(5)), (int) (scrollPane.getViewport().getViewPosition().getY() + Fenetre.adapterResolutionEnY(5)), Fenetre.adapterResolutionEnX(50), Fenetre.adapterResolutionEnY(50), this);



        // permet le défilement par rapport à la position du héro et centré sur le héro tout en évitant de scroll quand on ne peut pas (sortir de la zone-safe par exemple)
        if (jeu.getHero().getPositionX() <= scrollPane.getViewport().getViewPosition().getX() + Fenetre.adapterResolutionEnX(200))
            scrollPane.getViewport().setViewPosition(new Point((int) (scrollPane.getViewport().getViewPosition().getX() - (X -Fenetre.adapterResolutionEnX(400))), (int) scrollPane.getViewport().getViewPosition().getY()));
        else if (scrollPane.getViewport().getViewPosition().getX() + Fenetre.adapterResolutionEnX(1720) <= jeu.getHero().getPositionX())
            scrollPane.getViewport().setViewPosition(new Point((int) (scrollPane.getViewport().getViewPosition().getX() + (X - Fenetre.adapterResolutionEnX(400))), (int) scrollPane.getViewport().getViewPosition().getY()));
        if (jeu.getHero().getPositionY() <= scrollPane.getViewport().getViewPosition().getY() + Fenetre.adapterResolutionEnY(100))
            scrollPane.getViewport().setViewPosition(new Point((int) scrollPane.getViewport().getViewPosition().getX(), (int) (scrollPane.getViewport().getViewPosition().getY() - (Y-Fenetre.adapterResolutionEnY(200)))));
        else if (scrollPane.getViewport().getViewPosition().getY() + Fenetre.adapterResolutionEnY(980) <= jeu.getHero().getPositionY())
            scrollPane.getViewport().setViewPosition(new Point((int) scrollPane.getViewport().getViewPosition().getX(), (int) (scrollPane.getViewport().getViewPosition().getY() + (Y-Fenetre.adapterResolutionEnY(200)))));


/*
        if (jeu.getHero().getPositionY() > (int) (Y / 2.0) && jeu.getHero().getPositionY() < ZONE.height - (int) (Y / 2.0))
            scrollPane.getViewport().setViewPosition(new Point((int) scrollPane.getViewport().getViewPosition().getX(), (int) (jeu.getHero().getPositionY() - Y / 2.0)));
        if (jeu.getHero().getPositionX() > (int) (X / 2.0) && jeu.getHero().getPositionX() < ZONE.width - (int) (X / 2.0))
            scrollPane.getViewport().setViewPosition(new Point((int) (jeu.getHero().getPositionX() - X / 2.0), (int) scrollPane.getViewport().getViewPosition().getY()));
    */
    }
}