package vue;

import controleur.ControlFenetreJeu;
import model.Direction;
import model.Jeu;
import model.Niveau;

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

    public static int tailleMapX, tailleMapY;
    public static final int TAILLE_TUILE = Fenetre.adapterResolutionEnX(50);
    public static int tuileInt[][];
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

        Niveau niveau = new Niveau(50, 2, Direction.GAUCHE, true);

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

        // changement de zone : zone-safe -> zone-donjon
        if (jeu.getHero().getPositionX() == ZONE.width - 1) {
            jeu.getEtat().setZoneSafe(false);
            changerMap("map/mapFenetreDonjon.txt");
            jeu.setNiveauDonjonActuelle(jeu.getNiveauDonjonActuelle() + 1);
        }

        // scroll
        int x = (int) scrollPane.getViewport().getViewPosition().getX();
        int y = (int) scrollPane.getViewport().getViewPosition().getY();
        if (jeu.getHero().getPositionX() < scrollPane.getViewport().getViewPosition().getX() + Fenetre.adapterResolutionEnX(200)) {
            x = (int) (scrollPane.getViewport().getViewPosition().getX() - (X - Fenetre.adapterResolutionEnX(400)));
            x = x < 0 ? 0 : x;
        } else if (scrollPane.getViewport().getViewPosition().getX() + Fenetre.adapterResolutionEnX(1720) < jeu.getHero().getPositionX() && x <= ZONE.width - X)
            x = (int) (scrollPane.getViewport().getViewPosition().getX() + (X - Fenetre.adapterResolutionEnX(400)));

        if (jeu.getHero().getPositionY() < scrollPane.getViewport().getViewPosition().getY() + Fenetre.adapterResolutionEnY(100)) {
            y = (int) (scrollPane.getViewport().getViewPosition().getY() - (Y - Fenetre.adapterResolutionEnY(200)));
            y = y < 0 ? 0 : y;
        } else if (scrollPane.getViewport().getViewPosition().getY() + Fenetre.adapterResolutionEnY(980) < jeu.getHero().getPositionY() && y <= ZONE.height - Y)
            y = (int) (scrollPane.getViewport().getViewPosition().getY() + (Y - Fenetre.adapterResolutionEnY(200)));

        scrollPane.getViewport().setViewPosition(new Point(x, y));
    }

    public void changerMap(String chemin) {

        readMap(chemin);
        tuileImage = new BufferedImage[tailleMapY][tailleMapX];
        chargerMap();

        if (hero != null) {
            if (!jeu.getEtat().getZoneSafe() && jeu.getNiveauDonjonActuelle() > 0) {
                if (jeu.getHero().getPositionY() < ZONE.height / 2.0)
                    jeu.getHero().setPositionY(-Fenetre.adapterResolutionEnY(200) + TAILLE_TUILE * tailleMapY - jeu.getHero().getHauteurBas());
                else
                    jeu.getHero().setPositionY(Fenetre.adapterResolutionEnY(550) - jeu.getHero().getHauteurBas());

                if (jeu.getHero().getPositionX() < ZONE.width / 2.0) {
                    jeu.getHero().setDirectionOrientation(Direction.GAUCHE);
                    jeu.getHero().setPositionX(-Fenetre.adapterResolutionEnX(150) + TAILLE_TUILE * tailleMapX);
                } else {
                    jeu.getHero().setDirectionOrientation(Direction.DROITE);
                    jeu.getHero().setPositionX(Fenetre.adapterResolutionEnX(150));
                }
            }
        }

        ZONE = new Dimension(TAILLE_TUILE * tailleMapX, TAILLE_TUILE * tailleMapY);
        this.setPreferredSize(ZONE);

        if (hero != null) {
            if (jeu.getNiveauDonjonActuelle() == 0) {
                jeu.getHero().setPositionX(Fenetre.adapterResolutionEnX(150));
                jeu.getHero().setPositionY((int) (-Fenetre.adapterResolutionEnY(200) + ZONE.getHeight() - jeu.getHero().getHauteurBas()));
            }

            if (jeu.getEtat().getZoneSafe())
                jeu.getHero().setPositionX(ZONE.width - 2);
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
    }
}
