package vue;

import controleur.ControlFenetreCreationPersonnage;
import model.Jeu;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import static vue.Entite.createComposite;
import static vue.Entite.decoupage;
import static vue.Fenetre.X;
import static vue.Fenetre.Y;

/**
 * Created by bastien on 21/11/16.
 */
public class FenetreCreationPersonnage extends JPanel {

    private Jeu jeu;
    public JButton jouer, retour;
    public JButton cheveuxGauche, cheveuxDroite, yeuxGauche, yeuxDroite, sexeFemme, sexeHomme, peauGauche, peauDroite, pilositeGauche, pilositeDroite;
    public JButton cheveuxCouleur0, cheveuxCouleur1, cheveuxCouleur2, cheveuxCouleur3, cheveuxCouleur4, cheveuxCouleur5, cheveuxCouleur6, cheveuxCouleur7;
    public JButton yeuxCouleur0, yeuxCouleur1, yeuxCouleur2, yeuxCouleur3, yeuxCouleur4, yeuxCouleur5, yeuxCouleur6, yeuxCouleur7;
    public JButton pilositeCouleur0, pilositeCouleur1, pilositeCouleur2, pilositeCouleur3, pilositeCouleur4, pilositeCouleur5, pilositeCouleur6, pilositeCouleur7;
    public JLabel lNomHero;
    public JTextField tfNomHero;

    // nombre de texture différente
    public static final int NB_YEUX = 1;
    public static final int NB_PEAUX = 3;
    public static final int NB_CHEVEUX = 1;
    public static final int NB_PILOSITE = 1;
    public static final int NB_COULEUR = 8;

    // tableau qui stock les images pour la création du personnage
    private BufferedImage[][][] spriteCheveux;
    private BufferedImage[][] spritePeau;
    private BufferedImage[][] spriteYeux;
    private BufferedImage[][] spritePilosite;

    // variable pour le choix des caractéristiques physique
    public int choixSexe;
    public int choixCouleurCheveux;
    public int choixCheveux;
    public int choixPeau;
    public int choixCouleurYeux;
    public int choixYeux;
    public int choixCouleurPilosite;
    public int choixPilosite;


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

        // boutton pour chosir les caractéristique
        cheveuxGauche = new JButton("");
        cheveuxGauche.setActionCommand("cheveuxGauche");
        cheveuxDroite = new JButton("");
        cheveuxDroite.setActionCommand("cheveuxDroite");
        yeuxGauche = new JButton("");
        yeuxGauche.setActionCommand("yeuxGauche");
        yeuxDroite = new JButton("");
        yeuxDroite.setActionCommand("yeuxDroite");
        sexeFemme = new JButton("");
        sexeFemme.setActionCommand("sexeFemme");
        sexeHomme = new JButton("");
        sexeHomme.setActionCommand("sexeHomme");
        peauGauche = new JButton("");
        peauGauche.setActionCommand("peauGauche");
        peauDroite = new JButton("");
        peauDroite.setActionCommand("peauDroite");
        pilositeGauche = new JButton("");
        pilositeGauche.setActionCommand("pilositeGauche ");
        pilositeDroite = new JButton("");
        pilositeDroite.setActionCommand("pilositeDroite");

        // boutton pour choisir la couleur
        cheveuxCouleur0 = new JButton("");
        cheveuxCouleur0.setActionCommand("cheveuxCouleur0");
        cheveuxCouleur1 = new JButton("");
        cheveuxCouleur1.setActionCommand("cheveuxCouleur1");
        cheveuxCouleur2 = new JButton("");
        cheveuxCouleur2.setActionCommand("cheveuxCouleur2");
        cheveuxCouleur3 = new JButton("");
        cheveuxCouleur3.setActionCommand("cheveuxCouleur3");
        cheveuxCouleur4 = new JButton("");
        cheveuxCouleur4.setActionCommand("cheveuxCouleur4");
        cheveuxCouleur5 = new JButton("");
        cheveuxCouleur5.setActionCommand("cheveuxCouleur5");
        cheveuxCouleur6 = new JButton("");
        cheveuxCouleur6.setActionCommand("cheveuxCouleur6");
        cheveuxCouleur7 = new JButton("");
        cheveuxCouleur7.setActionCommand("cheveuxCouleur7");
        yeuxCouleur0 = new JButton("");
        yeuxCouleur0.setActionCommand("yeuxCouleur0");
        yeuxCouleur1 = new JButton("");
        yeuxCouleur1.setActionCommand("yeuxCouleur1");
        yeuxCouleur2 = new JButton("");
        yeuxCouleur2.setActionCommand("yeuxCouleur2");
        yeuxCouleur3 = new JButton("");
        yeuxCouleur3.setActionCommand("yeuxCouleur3");
        yeuxCouleur4 = new JButton("");
        yeuxCouleur4.setActionCommand("yeuxCouleur4");
        yeuxCouleur5 = new JButton("");
        yeuxCouleur5.setActionCommand("yeuxCouleur5");
        yeuxCouleur6 = new JButton("");
        yeuxCouleur6.setActionCommand("yeuxCouleur6");
        yeuxCouleur7 = new JButton("");
        yeuxCouleur7.setActionCommand("yeuxCouleur7");
        pilositeCouleur0 = new JButton("");
        pilositeCouleur0.setActionCommand("pilositeCouleur0");
        pilositeCouleur1 = new JButton("");
        pilositeCouleur1.setActionCommand("pilositeCouleur1");
        pilositeCouleur2 = new JButton("");
        pilositeCouleur2.setActionCommand("pilositeCouleur2");
        pilositeCouleur3 = new JButton("");
        pilositeCouleur3.setActionCommand("pilositeCouleur3");
        pilositeCouleur4 = new JButton("");
        pilositeCouleur4.setActionCommand("pilositeCouleur4");
        pilositeCouleur5 = new JButton("");
        pilositeCouleur5.setActionCommand("pilositeCouleur5");
        pilositeCouleur6 = new JButton("");
        pilositeCouleur6.setActionCommand("pilositeCouleur6");
        pilositeCouleur7 = new JButton("");
        pilositeCouleur7.setActionCommand("pilositeCouleur7");

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
        add(cheveuxCouleur0);
        add(cheveuxCouleur1);
        add(cheveuxCouleur2);
        add(cheveuxCouleur3);
        add(cheveuxCouleur4);
        add(cheveuxCouleur5);
        add(cheveuxCouleur6);
        add(cheveuxCouleur7);
        add(yeuxCouleur0);
        add(yeuxCouleur1);
        add(yeuxCouleur2);
        add(yeuxCouleur3);
        add(yeuxCouleur4);
        add(yeuxCouleur5);
        add(yeuxCouleur6);
        add(yeuxCouleur7);
        add(pilositeCouleur0);
        add(pilositeCouleur1);
        add(pilositeCouleur2);
        add(pilositeCouleur3);
        add(pilositeCouleur4);
        add(pilositeCouleur5);
        add(pilositeCouleur6);
        add(pilositeCouleur7);


        spriteCheveux = new BufferedImage[2][NB_CHEVEUX][NB_COULEUR]; // [0 = femme, 1 homme][type][couleur]
        spriteYeux = new BufferedImage[NB_YEUX][NB_COULEUR]; // [type][couleur]
        spritePeau = new BufferedImage[2][NB_PEAUX]; // [0 = femme, 1 homme][couleur]
        spritePilosite = new BufferedImage[NB_PILOSITE][NB_COULEUR]; // [type][couleur]


        choixSexe = 0;
        choixCouleurCheveux = 0;
        choixCheveux = 0;
        choixPeau = 0;
        choixCouleurYeux = 0;
        choixYeux = 0;
        choixCouleurPilosite = 0;
        choixPilosite = 0;
    }

    public void initialiseCaracteristiquePhysique() {
        BufferedImage img = null;

        // cheveux
        String strSexe;
        for (int sexe = 0; sexe < 2; sexe++)
            for (int i = 0; i < NB_CHEVEUX; i++)
                for (int j = 0; j < NB_COULEUR; j++) {

                    if (sexe == 1)
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
                if (sexe == 1)
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
            for (int j = 0; j < NB_COULEUR; j++) {

                try {
                    img = decoupage(ImageIO.read(new File("images/Personnages/Pilosite/spritePilosite" + i + "" + j + ".png")), 3, 11)[1];
                } catch (IOException e) {
                    e.printStackTrace();
                }

                spritePilosite[i][j] = img;
            }

        // Yeux
        for (int i = 0; i < NB_YEUX; i++)
            for (int j = 0; j < NB_COULEUR; j++) {

                try {
                    img = decoupage(ImageIO.read(new File("images/Personnages/Yeux/spriteYeux" + i + "" + j + ".png")), 3, 11)[1];
                } catch (IOException e) {
                    e.printStackTrace();
                }

                spriteYeux[i][j] = img;
            }
    }

    public void sauvegardeSprite(int idHero) {
        String strSexe ="";
        if (choixSexe == 1)
            strSexe = "Femme";
        else
            strSexe = "Homme";

        BufferedImage bufferPeau = null, bufferPilosite = null, bufferCheveux = null, bufferYeux = null;
        try {
            bufferPeau = ImageIO.read(new File("images/Personnages/" + strSexe + "/Peaux/spritePeau" + choixPeau + ".png"));
            bufferPilosite = ImageIO.read(new File("images/Personnages/Pilosite/spritePilosite" + choixPilosite + "" + choixCouleurPilosite + ".png"));
            bufferCheveux = ImageIO.read(new File("images/Personnages/" + strSexe + "/Cheveux/spriteCheveux" + choixCheveux + "" + choixCouleurCheveux + ".png"));
            bufferYeux = ImageIO.read(new File("images/Personnages/Yeux/spriteYeux" + choixYeux + "" + choixCouleurYeux + ".png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        BufferedImage image = createComposite(createComposite(createComposite(bufferPeau, bufferYeux, 1), bufferCheveux, 1), bufferPilosite, 1);

        try {
            ImageIO.write(image, "png", new File("images/Save/texture_hero"+idHero+".png"));
        } catch (IOException e) {
            e.printStackTrace();
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
        cheveuxCouleur0.addActionListener(controlFenetreCreationPersonnage);
        cheveuxCouleur1.addActionListener(controlFenetreCreationPersonnage);
        cheveuxCouleur2.addActionListener(controlFenetreCreationPersonnage);
        cheveuxCouleur3.addActionListener(controlFenetreCreationPersonnage);
        cheveuxCouleur4.addActionListener(controlFenetreCreationPersonnage);
        cheveuxCouleur5.addActionListener(controlFenetreCreationPersonnage);
        cheveuxCouleur6.addActionListener(controlFenetreCreationPersonnage);
        cheveuxCouleur7.addActionListener(controlFenetreCreationPersonnage);
        yeuxCouleur0.addActionListener(controlFenetreCreationPersonnage);
        yeuxCouleur1.addActionListener(controlFenetreCreationPersonnage);
        yeuxCouleur2.addActionListener(controlFenetreCreationPersonnage);
        yeuxCouleur3.addActionListener(controlFenetreCreationPersonnage);
        yeuxCouleur4.addActionListener(controlFenetreCreationPersonnage);
        yeuxCouleur5.addActionListener(controlFenetreCreationPersonnage);
        yeuxCouleur6.addActionListener(controlFenetreCreationPersonnage);
        yeuxCouleur7.addActionListener(controlFenetreCreationPersonnage);
        pilositeCouleur0.addActionListener(controlFenetreCreationPersonnage);
        pilositeCouleur1.addActionListener(controlFenetreCreationPersonnage);
        pilositeCouleur2.addActionListener(controlFenetreCreationPersonnage);
        pilositeCouleur3.addActionListener(controlFenetreCreationPersonnage);
        pilositeCouleur4.addActionListener(controlFenetreCreationPersonnage);
        pilositeCouleur5.addActionListener(controlFenetreCreationPersonnage);
        pilositeCouleur6.addActionListener(controlFenetreCreationPersonnage);
        pilositeCouleur7.addActionListener(controlFenetreCreationPersonnage);
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        jouer.setBounds(Fenetre.adapterResolutionEnX(1600), Fenetre.adapterResolutionEnY(985), Fenetre.adapterResolutionEnX(256), Fenetre.adapterResolutionEnY(41));
        jouer.setBackground(new Color(0, 0, 0, 0));
        jouer.setFocusable(false);
        jouer.setCursor(new Cursor(Cursor.HAND_CURSOR));
        jouer.setBorder(null);

        lNomHero.setBounds(Fenetre.adapterResolutionEnX(940), Fenetre.adapterResolutionEnY(850), Fenetre.adapterResolutionEnX(230), Fenetre.adapterResolutionEnY(40));
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


        cheveuxGauche.setBounds(Fenetre.adapterResolutionEnX(187), Fenetre.adapterResolutionEnY(339), Fenetre.adapterResolutionEnX(65), Fenetre.adapterResolutionEnY(65));
        cheveuxGauche.setBackground(new Color(0, 0, 0, 0));
        cheveuxGauche.setFocusable(false);
        cheveuxGauche.setCursor(new Cursor(Cursor.HAND_CURSOR));
        cheveuxGauche.setBorder(null);

        cheveuxDroite.setBounds(Fenetre.adapterResolutionEnX(450), Fenetre.adapterResolutionEnY(339), Fenetre.adapterResolutionEnX(65), Fenetre.adapterResolutionEnY(65));
        cheveuxDroite.setBackground(new Color(0, 0, 0, 0));
        cheveuxDroite.setFocusable(false);
        cheveuxDroite.setCursor(new Cursor(Cursor.HAND_CURSOR));
        cheveuxDroite.setBorder(null);

        yeuxGauche.setBounds(Fenetre.adapterResolutionEnX(187), Fenetre.adapterResolutionEnY(664), Fenetre.adapterResolutionEnX(65), Fenetre.adapterResolutionEnY(65));
        yeuxGauche.setBackground(new Color(0, 0, 0, 0));
        yeuxGauche.setFocusable(false);
        yeuxGauche.setCursor(new Cursor(Cursor.HAND_CURSOR));
        yeuxGauche.setBorder(null);

        yeuxDroite.setBounds(Fenetre.adapterResolutionEnX(450), Fenetre.adapterResolutionEnY(664), Fenetre.adapterResolutionEnX(65), Fenetre.adapterResolutionEnY(65));
        yeuxDroite.setBackground(new Color(0, 0, 0, 0));
        yeuxDroite.setFocusable(false);
        yeuxDroite.setCursor(new Cursor(Cursor.HAND_CURSOR));
        yeuxDroite.setBorder(null);

        sexeFemme.setBounds(Fenetre.adapterResolutionEnX(560), Fenetre.adapterResolutionEnY(912), Fenetre.adapterResolutionEnX(100), Fenetre.adapterResolutionEnY(100));
        sexeFemme.setBackground(new Color(0, 0, 0, 0));
        sexeFemme.setFocusable(false);
        sexeFemme.setCursor(new Cursor(Cursor.HAND_CURSOR));
        sexeFemme.setBorder(null);

        sexeHomme.setBounds(Fenetre.adapterResolutionEnX(445), Fenetre.adapterResolutionEnY(912), Fenetre.adapterResolutionEnX(100), Fenetre.adapterResolutionEnY(100));
        sexeHomme.setBackground(new Color(0, 0, 0, 0));
        sexeHomme.setFocusable(false);
        sexeHomme.setCursor(new Cursor(Cursor.HAND_CURSOR));
        sexeHomme.setBorder(null);

        peauGauche.setBounds(Fenetre.adapterResolutionEnX(1390), Fenetre.adapterResolutionEnY(339), Fenetre.adapterResolutionEnX(65), Fenetre.adapterResolutionEnY(65));
        peauGauche.setBackground(new Color(0, 0, 0, 0));
        peauGauche.setFocusable(false);
        peauGauche.setCursor(new Cursor(Cursor.HAND_CURSOR));
        peauGauche.setBorder(null);

        peauDroite.setBounds(Fenetre.adapterResolutionEnX(1650), Fenetre.adapterResolutionEnY(339), Fenetre.adapterResolutionEnX(65), Fenetre.adapterResolutionEnY(65));
        peauDroite.setBackground(new Color(0, 0, 0, 0));
        peauDroite.setFocusable(false);
        peauDroite.setCursor(new Cursor(Cursor.HAND_CURSOR));
        peauDroite.setBorder(null);

        pilositeGauche.setBounds(Fenetre.adapterResolutionEnX(1390), Fenetre.adapterResolutionEnY(664), Fenetre.adapterResolutionEnX(65), Fenetre.adapterResolutionEnY(65));
        pilositeGauche.setBackground(new Color(0, 0, 0, 0));
        pilositeGauche.setFocusable(false);
        pilositeGauche.setCursor(new Cursor(Cursor.HAND_CURSOR));
        pilositeGauche.setBorder(null);

        pilositeDroite.setBounds(Fenetre.adapterResolutionEnX(1650), Fenetre.adapterResolutionEnY(664), Fenetre.adapterResolutionEnX(65), Fenetre.adapterResolutionEnY(65));
        pilositeDroite.setBackground(new Color(0, 0, 0, 0));
        pilositeDroite.setFocusable(false);
        pilositeDroite.setCursor(new Cursor(Cursor.HAND_CURSOR));
        pilositeDroite.setBorder(null);

        cheveuxCouleur0.setBounds(Fenetre.adapterResolutionEnX(555), Fenetre.adapterResolutionEnY(258), Fenetre.adapterResolutionEnX(57), Fenetre.adapterResolutionEnY(57));
        cheveuxCouleur0.setBackground(new Color(0, 0, 0, 0));
        cheveuxCouleur0.setFocusable(false);
        cheveuxCouleur0.setCursor(new Cursor(Cursor.HAND_CURSOR));
        cheveuxCouleur0.setBorder(null);

        cheveuxCouleur1.setBounds(Fenetre.adapterResolutionEnX(613), Fenetre.adapterResolutionEnY(258), Fenetre.adapterResolutionEnX(57), Fenetre.adapterResolutionEnY(57));
        cheveuxCouleur1.setBackground(new Color(0, 0, 0, 0));
        cheveuxCouleur1.setFocusable(false);
        cheveuxCouleur1.setCursor(new Cursor(Cursor.HAND_CURSOR));
        cheveuxCouleur1.setBorder(null);

        cheveuxCouleur2.setBounds(Fenetre.adapterResolutionEnX(555), Fenetre.adapterResolutionEnY(316), Fenetre.adapterResolutionEnX(57), Fenetre.adapterResolutionEnY(57));
        cheveuxCouleur2.setBackground(new Color(0, 0, 0, 0));
        cheveuxCouleur2.setFocusable(false);
        cheveuxCouleur2.setCursor(new Cursor(Cursor.HAND_CURSOR));
        cheveuxCouleur2.setBorder(null);

        cheveuxCouleur3.setBounds(Fenetre.adapterResolutionEnX(613), Fenetre.adapterResolutionEnY(316), Fenetre.adapterResolutionEnX(57), Fenetre.adapterResolutionEnY(57));
        cheveuxCouleur3.setBackground(new Color(0, 0, 0, 0));
        cheveuxCouleur3.setFocusable(false);
        cheveuxCouleur3.setCursor(new Cursor(Cursor.HAND_CURSOR));
        cheveuxCouleur3.setBorder(null);

        cheveuxCouleur4.setBounds(Fenetre.adapterResolutionEnX(555), Fenetre.adapterResolutionEnY(374), Fenetre.adapterResolutionEnX(57), Fenetre.adapterResolutionEnY(57));
        cheveuxCouleur4.setBackground(new Color(0, 0, 0, 0));
        cheveuxCouleur4.setFocusable(false);
        cheveuxCouleur4.setCursor(new Cursor(Cursor.HAND_CURSOR));
        cheveuxCouleur4.setBorder(null);

        cheveuxCouleur5.setBounds(Fenetre.adapterResolutionEnX(613), Fenetre.adapterResolutionEnY(374), Fenetre.adapterResolutionEnX(57), Fenetre.adapterResolutionEnY(57));
        cheveuxCouleur5.setBackground(new Color(0, 0, 0, 0));
        cheveuxCouleur5.setFocusable(false);
        cheveuxCouleur5.setCursor(new Cursor(Cursor.HAND_CURSOR));
        cheveuxCouleur5.setBorder(null);

        cheveuxCouleur6.setBounds(Fenetre.adapterResolutionEnX(555), Fenetre.adapterResolutionEnY(432), Fenetre.adapterResolutionEnX(57), Fenetre.adapterResolutionEnY(57));
        cheveuxCouleur6.setBackground(new Color(0, 0, 0, 0));
        cheveuxCouleur6.setFocusable(false);
        cheveuxCouleur6.setCursor(new Cursor(Cursor.HAND_CURSOR));
        cheveuxCouleur6.setBorder(null);

        cheveuxCouleur7.setBounds(Fenetre.adapterResolutionEnX(613), Fenetre.adapterResolutionEnY(432), Fenetre.adapterResolutionEnX(57), Fenetre.adapterResolutionEnY(57));
        cheveuxCouleur7.setBackground(new Color(0, 0, 0, 0));
        cheveuxCouleur7.setFocusable(false);
        cheveuxCouleur7.setCursor(new Cursor(Cursor.HAND_CURSOR));
        cheveuxCouleur7.setBorder(null);

        yeuxCouleur0.setBounds(Fenetre.adapterResolutionEnX(555), Fenetre.adapterResolutionEnY(583), Fenetre.adapterResolutionEnX(57), Fenetre.adapterResolutionEnY(57));
        yeuxCouleur0.setBackground(new Color(0, 0, 0, 0));
        yeuxCouleur0.setFocusable(false);
        yeuxCouleur0.setCursor(new Cursor(Cursor.HAND_CURSOR));
        yeuxCouleur0.setBorder(null);

        yeuxCouleur1.setBounds(Fenetre.adapterResolutionEnX(613), Fenetre.adapterResolutionEnY(583), Fenetre.adapterResolutionEnX(57), Fenetre.adapterResolutionEnY(57));
        yeuxCouleur1.setBackground(new Color(0, 0, 0, 0));
        yeuxCouleur1.setFocusable(false);
        yeuxCouleur1.setCursor(new Cursor(Cursor.HAND_CURSOR));
        yeuxCouleur1.setBorder(null);

        yeuxCouleur2.setBounds(Fenetre.adapterResolutionEnX(555), Fenetre.adapterResolutionEnY(641), Fenetre.adapterResolutionEnX(57), Fenetre.adapterResolutionEnY(57));
        yeuxCouleur2.setBackground(new Color(0, 0, 0, 0));
        yeuxCouleur2.setFocusable(false);
        yeuxCouleur2.setCursor(new Cursor(Cursor.HAND_CURSOR));
        yeuxCouleur2.setBorder(null);

        yeuxCouleur3.setBounds(Fenetre.adapterResolutionEnX(613), Fenetre.adapterResolutionEnY(641), Fenetre.adapterResolutionEnX(57), Fenetre.adapterResolutionEnY(57));
        yeuxCouleur3.setBackground(new Color(0, 0, 0, 0));
        yeuxCouleur3.setFocusable(false);
        yeuxCouleur3.setCursor(new Cursor(Cursor.HAND_CURSOR));
        yeuxCouleur3.setBorder(null);

        yeuxCouleur4.setBounds(Fenetre.adapterResolutionEnX(555), Fenetre.adapterResolutionEnY(699), Fenetre.adapterResolutionEnX(57), Fenetre.adapterResolutionEnY(57));
        yeuxCouleur4.setBackground(new Color(0, 0, 0, 0));
        yeuxCouleur4.setFocusable(false);
        yeuxCouleur4.setCursor(new Cursor(Cursor.HAND_CURSOR));
        yeuxCouleur4.setBorder(null);

        yeuxCouleur5.setBounds(Fenetre.adapterResolutionEnX(613), Fenetre.adapterResolutionEnY(699), Fenetre.adapterResolutionEnX(57), Fenetre.adapterResolutionEnY(57));
        yeuxCouleur5.setBackground(new Color(0, 0, 0, 0));
        yeuxCouleur5.setFocusable(false);
        yeuxCouleur5.setCursor(new Cursor(Cursor.HAND_CURSOR));
        yeuxCouleur5.setBorder(null);

        yeuxCouleur6.setBounds(Fenetre.adapterResolutionEnX(555), Fenetre.adapterResolutionEnY(757), Fenetre.adapterResolutionEnX(57), Fenetre.adapterResolutionEnY(57));
        yeuxCouleur6.setBackground(new Color(0, 0, 0, 0));
        yeuxCouleur6.setFocusable(false);
        yeuxCouleur6.setCursor(new Cursor(Cursor.HAND_CURSOR));
        yeuxCouleur6.setBorder(null);

        yeuxCouleur7.setBounds(Fenetre.adapterResolutionEnX(613), Fenetre.adapterResolutionEnY(757), Fenetre.adapterResolutionEnX(57), Fenetre.adapterResolutionEnY(57));
        yeuxCouleur7.setBackground(new Color(0, 0, 0, 0));
        yeuxCouleur7.setFocusable(false);
        yeuxCouleur7.setCursor(new Cursor(Cursor.HAND_CURSOR));
        yeuxCouleur7.setBorder(null);

        pilositeCouleur0.setBounds(Fenetre.adapterResolutionEnX(1219), Fenetre.adapterResolutionEnY(583), Fenetre.adapterResolutionEnX(57), Fenetre.adapterResolutionEnY(57));
        pilositeCouleur0.setBackground(new Color(0, 0, 0, 0));
        pilositeCouleur0.setFocusable(false);
        pilositeCouleur0.setCursor(new Cursor(Cursor.HAND_CURSOR));
        pilositeCouleur0.setBorder(null);

        pilositeCouleur1.setBounds(Fenetre.adapterResolutionEnX(1277), Fenetre.adapterResolutionEnY(583), Fenetre.adapterResolutionEnX(57), Fenetre.adapterResolutionEnY(57));
        pilositeCouleur1.setBackground(new Color(0, 0, 0, 0));
        pilositeCouleur1.setFocusable(false);
        pilositeCouleur1.setCursor(new Cursor(Cursor.HAND_CURSOR));
        pilositeCouleur1.setBorder(null);

        pilositeCouleur2.setBounds(Fenetre.adapterResolutionEnX(1219), Fenetre.adapterResolutionEnY(641), Fenetre.adapterResolutionEnX(57), Fenetre.adapterResolutionEnY(57));
        pilositeCouleur2.setBackground(new Color(0, 0, 0, 0));
        pilositeCouleur2.setFocusable(false);
        pilositeCouleur2.setCursor(new Cursor(Cursor.HAND_CURSOR));
        pilositeCouleur2.setBorder(null);

        pilositeCouleur3.setBounds(Fenetre.adapterResolutionEnX(1277), Fenetre.adapterResolutionEnY(641), Fenetre.adapterResolutionEnX(57), Fenetre.adapterResolutionEnY(57));
        pilositeCouleur3.setBackground(new Color(0, 0, 0, 0));
        pilositeCouleur3.setFocusable(false);
        pilositeCouleur3.setCursor(new Cursor(Cursor.HAND_CURSOR));
        pilositeCouleur3.setBorder(null);

        pilositeCouleur4.setBounds(Fenetre.adapterResolutionEnX(1219), Fenetre.adapterResolutionEnY(699), Fenetre.adapterResolutionEnX(57), Fenetre.adapterResolutionEnY(57));
        pilositeCouleur4.setBackground(new Color(0, 0, 0, 0));
        pilositeCouleur4.setFocusable(false);
        pilositeCouleur4.setCursor(new Cursor(Cursor.HAND_CURSOR));
        pilositeCouleur4.setBorder(null);

        pilositeCouleur5.setBounds(Fenetre.adapterResolutionEnX(1277), Fenetre.adapterResolutionEnY(699), Fenetre.adapterResolutionEnX(57), Fenetre.adapterResolutionEnY(57));
        pilositeCouleur5.setBackground(new Color(0, 0, 0, 0));
        pilositeCouleur5.setFocusable(false);
        pilositeCouleur5.setCursor(new Cursor(Cursor.HAND_CURSOR));
        pilositeCouleur5.setBorder(null);

        pilositeCouleur6.setBounds(Fenetre.adapterResolutionEnX(1219), Fenetre.adapterResolutionEnY(757), Fenetre.adapterResolutionEnX(57), Fenetre.adapterResolutionEnY(57));
        pilositeCouleur6.setBackground(new Color(0, 0, 0, 0));
        pilositeCouleur6.setFocusable(false);
        pilositeCouleur6.setCursor(new Cursor(Cursor.HAND_CURSOR));
        pilositeCouleur6.setBorder(null);

        pilositeCouleur7.setBounds(Fenetre.adapterResolutionEnX(1277), Fenetre.adapterResolutionEnY(757), Fenetre.adapterResolutionEnX(57), Fenetre.adapterResolutionEnY(57));
        pilositeCouleur7.setBackground(new Color(0, 0, 0, 0));
        pilositeCouleur7.setFocusable(false);
        pilositeCouleur7.setCursor(new Cursor(Cursor.HAND_CURSOR));
        pilositeCouleur7.setBorder(null);


        if (choixSexe == 0) {
            pilositeGauche.setVisible(true);
            pilositeDroite.setVisible(true);
            pilositeCouleur0.setVisible(true);
            pilositeCouleur1.setVisible(true);
            pilositeCouleur2.setVisible(true);
            pilositeCouleur3.setVisible(true);
            pilositeCouleur4.setVisible(true);
            pilositeCouleur5.setVisible(true);
            pilositeCouleur6.setVisible(true);
            pilositeCouleur7.setVisible(true);
            pilositeGauche.setEnabled(true);
            pilositeDroite.setEnabled(true);
            pilositeCouleur0.setEnabled(true);
            pilositeCouleur1.setEnabled(true);
            pilositeCouleur2.setEnabled(true);
            pilositeCouleur3.setEnabled(true);
            pilositeCouleur4.setEnabled(true);
            pilositeCouleur5.setEnabled(true);
            pilositeCouleur6.setEnabled(true);
            pilositeCouleur7.setEnabled(true);
        } else {
            pilositeGauche.setVisible(false);
            pilositeDroite.setVisible(false);
            pilositeCouleur0.setVisible(false);
            pilositeCouleur1.setVisible(false);
            pilositeCouleur2.setVisible(false);
            pilositeCouleur3.setVisible(false);
            pilositeCouleur4.setVisible(false);
            pilositeCouleur5.setVisible(false);
            pilositeCouleur6.setVisible(false);
            pilositeCouleur7.setVisible(false);
            pilositeGauche.setEnabled(false);
            pilositeDroite.setEnabled(false);
            pilositeCouleur0.setEnabled(false);
            pilositeCouleur1.setEnabled(false);
            pilositeCouleur2.setEnabled(false);
            pilositeCouleur3.setEnabled(false);
            pilositeCouleur4.setEnabled(false);
            pilositeCouleur5.setEnabled(false);
            pilositeCouleur6.setEnabled(false);
            pilositeCouleur7.setEnabled(false);
        }

        Image img = null;
        if (choixSexe == 0)
            img = getToolkit().getImage("images/menuCreationPersonnageHomme.png");
        else
            img = getToolkit().getImage("images/menuCreationPersonnageFemme.png");
        g.drawImage(img, 0, 0, getWidth(), getHeight(), this);

        g.drawImage(spriteCheveux[choixSexe][choixCheveux][choixCouleurCheveux], Fenetre.adapterResolutionEnX(255), Fenetre.adapterResolutionEnY(272), Fenetre.adapterResolutionEnX(200), Fenetre.adapterResolutionEnY(200), this);
        g.drawImage(spriteYeux[choixYeux][choixCouleurYeux], Fenetre.adapterResolutionEnX(255), Fenetre.adapterResolutionEnY(606), Fenetre.adapterResolutionEnX(200), Fenetre.adapterResolutionEnY(200), this);
        g.drawImage(spritePeau[choixSexe][choixPeau], Fenetre.adapterResolutionEnX(1465), Fenetre.adapterResolutionEnY(272), Fenetre.adapterResolutionEnX(200), Fenetre.adapterResolutionEnY(200), this);
        if (choixSexe == 0)
            g.drawImage(spritePilosite[choixPilosite][choixCouleurPilosite], Fenetre.adapterResolutionEnX(1465), Fenetre.adapterResolutionEnY(606), Fenetre.adapterResolutionEnX(200), Fenetre.adapterResolutionEnY(200), this);

        BufferedImage image = createComposite(createComposite(createComposite(spritePeau[choixSexe][choixPeau], spriteYeux[choixYeux][choixCouleurYeux], 1), spriteCheveux[choixSexe][choixCheveux][choixCouleurCheveux], 1), spritePilosite[choixPilosite][choixCouleurPilosite], 1);
        g.drawImage(image, Fenetre.adapterResolutionEnX(810), Fenetre.adapterResolutionEnY(440), Fenetre.adapterResolutionEnX(300), Fenetre.adapterResolutionEnY(300), this);
    }

    public JTextField getTfNomHero() {
        return tfNomHero;
    }
}
