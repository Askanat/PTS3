package vue;

import controleur.ControlFenetreCreationPersonnage;
import model.Jeu;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import static vue.Entite.decoupage;
import static vue.Fenetre.X;
import static vue.Fenetre.Y;

/**
 * Created by bastien on 21/11/16.
 */
public class FenetreCreationPersonnage extends JPanel {

    private Jeu jeu;
    public JButton jouer, retour, cheveuxGauche, cheveuxDroite, yeuxGauche, yeuxDroite, sexeFemme, sexeHomme, peauGauche, peauDroite, pilositeGauche, pilositeDroite, personnageGauche, personnageDroite;
    public JLabel lNomHero;
    public JTextField tfNomHero;

    // nombre de texture différente
    private final int NB_YEUX = 1;
    private final int NB_PEAUX = 3;
    private final int NB_CHEVEUX = 1;
    private final int NB_PILOSITE = 1;
    private final int NB_COULEUR_YEUX = 3;
    private final int NB_COULEUR_CHEVEUX = 8;
    private final int NB_COULEUR_PILOSITE = 3;

    private Image[][][] spriteCheveux;
    private Image[][] spritePeau;
    private Image[][] spriteYeux;
    private Image[][] spritePilosite;


    public FenetreCreationPersonnage(Jeu jeu) {

        this.jeu = jeu;

        this.setLayout(null);
        setPreferredSize(new Dimension(X, Y));

        jouer = new JButton("");
        jouer.setActionCommand("Jouer");

        lNomHero = new JLabel("");
        tfNomHero = new JTextField("");
        tfNomHero.setColumns(10);

        retour = new JButton("");
        retour.setActionCommand("Retour");

        cheveuxGauche = new JButton("aaaa");
        cheveuxGauche.setActionCommand("cheveuxGauche");

        cheveuxDroite = new JButton("bbbb");
        cheveuxDroite.setActionCommand("cheveuxDroite");

        yeuxGauche = new JButton("cccc");
        yeuxGauche.setActionCommand("yeuxGauche");

        yeuxDroite = new JButton("dddd");
        yeuxDroite.setActionCommand("yeuxDroite");

        sexeFemme = new JButton("eeee");
        sexeFemme.setActionCommand("sexeFemme");

        sexeHomme = new JButton("ffff");
        sexeHomme.setActionCommand("sexeHomme");

        peauGauche = new JButton("gggg");
        peauGauche.setActionCommand("peauGauche");

        peauDroite = new JButton("hhhh");
        peauDroite.setActionCommand("peauDroite");

        pilositeGauche = new JButton("iiii");
        pilositeGauche.setActionCommand("pilositeGauche ");

        pilositeDroite = new JButton("jjjj");
        pilositeDroite.setActionCommand("pilositeDroite");

        add(jouer);
        add(lNomHero);
        add(tfNomHero);
        add(retour);
        add(cheveuxGauche);
        add(cheveuxDroite);
        add(yeuxDroite);
        add(yeuxGauche);
        add(sexeFemme);
        add(sexeHomme);
        add(peauGauche);
        add(peauDroite);
        add(pilositeGauche);
        add(pilositeDroite);

        spriteCheveux = new Image[2][NB_CHEVEUX][NB_COULEUR_CHEVEUX]; // [0 = femme, 1 homme][type][couleur]
        spriteYeux = new Image[NB_YEUX][NB_COULEUR_YEUX]; // [type][couleur]
        spritePeau = new Image[2][NB_PEAUX]; // [0 = femme, 1 homme][couleur]
        spritePilosite = new Image[NB_PILOSITE][NB_COULEUR_PILOSITE]; // [type][couleur]
    }

    public void initialiseCaracteristiquePhysique() {
        BufferedImage img = null;

        // cheveux
        String strSexe;
        for (int sexe = 0; sexe < 2; sexe++)
            for (int i = 0; i < NB_CHEVEUX; i++)
                for (int j = 0; j < NB_COULEUR_CHEVEUX; j++) {

                    if (sexe == 0)
                        strSexe = "Femme";
                    else
                        strSexe = "Homme";

                    try {
                        img = decoupage(ImageIO.read(new File("images/Personnages/" + strSexe + "/Cheveux/spriteCheveux" + i + "" + j + ".png")), 3, 11)[1];
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                    spriteCheveux[sexe][i][j] = img;
                }

        // peaux
        for (int sexe = 0; sexe < 2; sexe++)
            for (int i = 0; i < NB_PEAUX; i++) {
                if (sexe == 0)
                    strSexe = "Femme";
                else
                    strSexe = "Homme";

                try {
                    img = decoupage(ImageIO.read(new File("images/Personnages/" + strSexe + "/Peaux/spritePeau" + i + ".png")), 3, 11)[1];
                } catch (IOException e) {
                    e.printStackTrace();
                }

                spritePeau[sexe][i] = img;
            }

        // Pilosite
        for (int i = 0; i < NB_PILOSITE; i++)
            for (int j = 0; j < NB_COULEUR_PILOSITE; j++) {

                try {
                    img = decoupage(ImageIO.read(new File("images/Personnages/Pilosite/spritePilosite" + i + "" + j + ".png")), 3, 11)[1];
                } catch (IOException e) {
                    e.printStackTrace();
                }

                spritePilosite[i][j] = img;
            }

        // Yeux
        for (int i = 0; i < NB_YEUX; i++)
            for (int j = 0; j < NB_COULEUR_YEUX; j++) {

                try {
                    img = decoupage(ImageIO.read(new File("images/Personnages/Yeux/spriteYeux" + i + "" + j + ".png")), 3, 11)[1];
                } catch (IOException e) {
                    e.printStackTrace();
                }

                spriteYeux[i][j] = img;
            }
    }

    public void setControl(ControlFenetreCreationPersonnage controlFenetreCreationPersonnage) {
        jouer.addActionListener(controlFenetreCreationPersonnage);
        retour.addActionListener(controlFenetreCreationPersonnage);
        tfNomHero.addActionListener(controlFenetreCreationPersonnage);
        cheveuxGauche.addActionListener(controlFenetreCreationPersonnage);
        cheveuxDroite.addActionListener(controlFenetreCreationPersonnage);
        yeuxDroite.addActionListener(controlFenetreCreationPersonnage);
        yeuxGauche.addActionListener(controlFenetreCreationPersonnage);
        sexeFemme.addActionListener(controlFenetreCreationPersonnage);
        sexeHomme.addActionListener(controlFenetreCreationPersonnage);
        peauGauche.addActionListener(controlFenetreCreationPersonnage);
        peauDroite.addActionListener(controlFenetreCreationPersonnage);
        pilositeGauche.addActionListener(controlFenetreCreationPersonnage);
        pilositeDroite.addActionListener(controlFenetreCreationPersonnage);
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        jouer.setBounds(Fenetre.adapterResolutionEnX(1600), Fenetre.adapterResolutionEnY(985), Fenetre.adapterResolutionEnX(256), Fenetre.adapterResolutionEnY(41));
        jouer.setForeground(Color.WHITE);
        jouer.setBackground(new Color(0, 0, 0, 0));
        jouer.setFocusable(false);
        jouer.setCursor(new Cursor(Cursor.HAND_CURSOR));
        jouer.setBorder(null);

        lNomHero.setBounds(Fenetre.adapterResolutionEnX(940), Fenetre.adapterResolutionEnY(850), Fenetre.adapterResolutionEnX(230), Fenetre.adapterResolutionEnY(40));
        lNomHero.setForeground(Color.WHITE);
        lNomHero.setBackground(new Color(0, 0, 0, 0));
        lNomHero.setFocusable(false);
        lNomHero.setCursor(new Cursor(Cursor.HAND_CURSOR));
        lNomHero.setBorder(null);

        tfNomHero.setBounds(Fenetre.adapterResolutionEnX(845), Fenetre.adapterResolutionEnY(890), Fenetre.adapterResolutionEnX(230), Fenetre.adapterResolutionEnY(40));

        retour.setBounds(Fenetre.adapterResolutionEnX(64), Fenetre.adapterResolutionEnY(985), Fenetre.adapterResolutionEnX(256), Fenetre.adapterResolutionEnY(41));
        retour.setBackground(new Color(0, 0, 0, 0));
        retour.setFocusable(false);
        retour.setCursor(new Cursor(Cursor.HAND_CURSOR));
        retour.setBorder(null);


        cheveuxGauche.setBounds(Fenetre.adapterResolutionEnX(110), Fenetre.adapterResolutionEnY(322), Fenetre.adapterResolutionEnX(100), Fenetre.adapterResolutionEnY(100));
        cheveuxGauche.setForeground(Color.WHITE);
        cheveuxGauche.setBackground(new Color(0, 0, 0, 0));
        cheveuxGauche.setFocusable(false);
        cheveuxGauche.setCursor(new Cursor(Cursor.HAND_CURSOR));
        cheveuxGauche.setBorder(null);

        cheveuxDroite.setBounds(Fenetre.adapterResolutionEnX(500), Fenetre.adapterResolutionEnY(322), Fenetre.adapterResolutionEnX(100), Fenetre.adapterResolutionEnY(100));
        cheveuxDroite.setForeground(Color.WHITE);
        cheveuxDroite.setBackground(new Color(0, 0, 0, 0));
        cheveuxDroite.setFocusable(false);
        cheveuxDroite.setCursor(new Cursor(Cursor.HAND_CURSOR));
        cheveuxDroite.setBorder(null);

        yeuxGauche.setBounds(Fenetre.adapterResolutionEnX(110), Fenetre.adapterResolutionEnY(656), Fenetre.adapterResolutionEnX(100), Fenetre.adapterResolutionEnY(100));
        yeuxGauche.setForeground(Color.WHITE);
        yeuxGauche.setBackground(new Color(0, 0, 0, 0));
        yeuxGauche.setFocusable(false);
        yeuxGauche.setCursor(new Cursor(Cursor.HAND_CURSOR));
        yeuxGauche.setBorder(null);

        yeuxDroite.setBounds(Fenetre.adapterResolutionEnX(500), Fenetre.adapterResolutionEnY(656), Fenetre.adapterResolutionEnX(100), Fenetre.adapterResolutionEnY(100));
        yeuxDroite.setForeground(Color.WHITE);
        yeuxDroite.setBackground(new Color(0, 0, 0, 0));
        yeuxDroite.setFocusable(false);
        yeuxDroite.setCursor(new Cursor(Cursor.HAND_CURSOR));
        yeuxDroite.setBorder(null);

        sexeFemme.setBounds(Fenetre.adapterResolutionEnX(560), Fenetre.adapterResolutionEnY(912), Fenetre.adapterResolutionEnX(100), Fenetre.adapterResolutionEnY(100));
        sexeFemme.setForeground(Color.WHITE);
        sexeFemme.setBackground(new Color(0, 0, 0, 0));
        sexeFemme.setFocusable(false);
        sexeFemme.setCursor(new Cursor(Cursor.HAND_CURSOR));
        sexeFemme.setBorder(null);

        sexeHomme.setBounds(Fenetre.adapterResolutionEnX(445), Fenetre.adapterResolutionEnY(912), Fenetre.adapterResolutionEnX(100), Fenetre.adapterResolutionEnY(100));
        sexeHomme.setForeground(Color.WHITE);
        sexeHomme.setBackground(new Color(0, 0, 0, 0));
        sexeHomme.setFocusable(false);
        sexeHomme.setCursor(new Cursor(Cursor.HAND_CURSOR));
        sexeHomme.setBorder(null);

        peauGauche.setBounds(Fenetre.adapterResolutionEnX(1320), Fenetre.adapterResolutionEnY(322), Fenetre.adapterResolutionEnX(100), Fenetre.adapterResolutionEnY(100));
        peauGauche.setForeground(Color.WHITE);
        peauGauche.setBackground(new Color(0, 0, 0, 0));
        peauGauche.setFocusable(false);
        peauGauche.setCursor(new Cursor(Cursor.HAND_CURSOR));
        peauGauche.setBorder(null);

        peauDroite.setBounds(Fenetre.adapterResolutionEnX(1710), Fenetre.adapterResolutionEnY(322), Fenetre.adapterResolutionEnX(100), Fenetre.adapterResolutionEnY(100));
        peauDroite.setForeground(Color.WHITE);
        peauDroite.setBackground(new Color(0, 0, 0, 0));
        peauDroite.setFocusable(false);
        peauDroite.setCursor(new Cursor(Cursor.HAND_CURSOR));
        peauDroite.setBorder(null);

        pilositeGauche.setBounds(Fenetre.adapterResolutionEnX(1320), Fenetre.adapterResolutionEnY(656), Fenetre.adapterResolutionEnX(100), Fenetre.adapterResolutionEnY(100));
        pilositeGauche.setForeground(Color.WHITE);
        pilositeGauche.setBackground(new Color(0, 0, 0, 0));
        pilositeGauche.setFocusable(false);
        pilositeGauche.setCursor(new Cursor(Cursor.HAND_CURSOR));
        pilositeGauche.setBorder(null);

        pilositeDroite.setBounds(Fenetre.adapterResolutionEnX(1710), Fenetre.adapterResolutionEnY(656), Fenetre.adapterResolutionEnX(100), Fenetre.adapterResolutionEnY(100));
        pilositeDroite.setForeground(Color.WHITE);
        pilositeDroite.setBackground(new Color(0, 0, 0, 0));
        pilositeDroite.setFocusable(false);
        pilositeDroite.setCursor(new Cursor(Cursor.HAND_CURSOR));
        pilositeDroite.setBorder(null);

        Image img = getToolkit().getImage("images/menuCreationPersonnage.png");
        g.drawImage(img, 0, 0, getWidth(), getHeight(), this);
    }

    public JTextField getTfNomHero() {
        return tfNomHero;
    }
}
