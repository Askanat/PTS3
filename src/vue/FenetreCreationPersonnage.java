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
    public JButton cheveuxCouleur[];
    public JButton yeuxCouleur[];
    public JButton pilositeCouleur[];
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
        cheveuxCouleur = new JButton[NB_COULEUR];
        yeuxCouleur = new JButton[NB_COULEUR];
        pilositeCouleur = new JButton[NB_COULEUR];
        for (int i = 0; i < NB_COULEUR; i++) {
            cheveuxCouleur[i] = new JButton("" + i);
            cheveuxCouleur[i].setActionCommand("cheveuxCouleur" + i);
            yeuxCouleur[i] = new JButton("" + i);
            yeuxCouleur[i].setActionCommand("yeuxCouleur" + i);
            pilositeCouleur[i] = new JButton("" + i);
            pilositeCouleur[i].setActionCommand("pilositeCouleur" + i);
        }

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
        for (int i = 0; i < NB_COULEUR; i++) {
            add(cheveuxCouleur[i]);
            add(yeuxCouleur[i]);
            add(pilositeCouleur[i]);
        }

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
        String strSexe = "";
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
            ImageIO.write(image, "png", new File("images/Save/texture_hero" + idHero + ".png"));
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
        for (int i = 0; i < NB_COULEUR; i++) {
            cheveuxCouleur[i].addActionListener(controlFenetreCreationPersonnage);
            yeuxCouleur[i].addActionListener(controlFenetreCreationPersonnage);
            pilositeCouleur[i].addActionListener(controlFenetreCreationPersonnage);
        }
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

        int a = 0;
        for (int i = 0; i < NB_COULEUR; i++) {
            if (i % 2 == 0) {
                cheveuxCouleur[i].setBounds(Fenetre.adapterResolutionEnX(555), Fenetre.adapterResolutionEnY(258 + 58 * (i - a)), Fenetre.adapterResolutionEnX(57), Fenetre.adapterResolutionEnY(57));
                cheveuxCouleur[i].setBackground(new Color(0, 0, 0, 0));
                cheveuxCouleur[i].setFocusable(false);
                cheveuxCouleur[i].setCursor(new Cursor(Cursor.HAND_CURSOR));
                cheveuxCouleur[i].setBorder(null);

                yeuxCouleur[i].setBounds(Fenetre.adapterResolutionEnX(555), Fenetre.adapterResolutionEnY(583 + 58 * (i - a)), Fenetre.adapterResolutionEnX(57), Fenetre.adapterResolutionEnY(57));
                yeuxCouleur[i].setBackground(new Color(0, 0, 0, 0));
                yeuxCouleur[i].setFocusable(false);
                yeuxCouleur[i].setCursor(new Cursor(Cursor.HAND_CURSOR));
                yeuxCouleur[i].setBorder(null);

                pilositeCouleur[i].setBounds(Fenetre.adapterResolutionEnX(1219), Fenetre.adapterResolutionEnY(583 + 58 * (i - a)), Fenetre.adapterResolutionEnX(57), Fenetre.adapterResolutionEnY(57));
                pilositeCouleur[i].setBackground(new Color(0, 0, 0, 0));
                pilositeCouleur[i].setFocusable(false);
                pilositeCouleur[i].setCursor(new Cursor(Cursor.HAND_CURSOR));
                pilositeCouleur[i].setBorder(null);
            } else {
                cheveuxCouleur[i].setBounds(Fenetre.adapterResolutionEnX(613), Fenetre.adapterResolutionEnY(258 + 58 * (i - a - 1)), Fenetre.adapterResolutionEnX(57), Fenetre.adapterResolutionEnY(57));
                cheveuxCouleur[i].setBackground(new Color(0, 0, 0, 0));
                cheveuxCouleur[i].setFocusable(false);
                cheveuxCouleur[i].setCursor(new Cursor(Cursor.HAND_CURSOR));
                cheveuxCouleur[i].setBorder(null);

                yeuxCouleur[i].setBounds(Fenetre.adapterResolutionEnX(613), Fenetre.adapterResolutionEnY(583 + 58 * (i - a - 1)), Fenetre.adapterResolutionEnX(57), Fenetre.adapterResolutionEnY(57));
                yeuxCouleur[i].setBackground(new Color(0, 0, 0, 0));
                yeuxCouleur[i].setFocusable(false);
                yeuxCouleur[i].setCursor(new Cursor(Cursor.HAND_CURSOR));
                yeuxCouleur[i].setBorder(null);

                pilositeCouleur[i].setBounds(Fenetre.adapterResolutionEnX(1277), Fenetre.adapterResolutionEnY(583 + 58 * (i - a - 1)), Fenetre.adapterResolutionEnX(57), Fenetre.adapterResolutionEnY(57));
                pilositeCouleur[i].setBackground(new Color(0, 0, 0, 0));
                pilositeCouleur[i].setFocusable(false);
                pilositeCouleur[i].setCursor(new Cursor(Cursor.HAND_CURSOR));
                pilositeCouleur[i].setBorder(null);

                a++;
            }
        }


        if (choixSexe == 0) {
            pilositeGauche.setVisible(true);
            pilositeDroite.setVisible(true);
            pilositeGauche.setEnabled(true);
            pilositeDroite.setEnabled(true);
            for (int i = 0; i < NB_COULEUR; i++) {
                pilositeCouleur[i].setVisible(true);
                pilositeCouleur[i].setEnabled(true);
            }
        } else {
            pilositeGauche.setVisible(false);
            pilositeDroite.setVisible(false);
            pilositeGauche.setEnabled(false);
            pilositeDroite.setEnabled(false);
            for (int i = 0; i < NB_COULEUR; i++) {
                pilositeCouleur[i].setVisible(false);
                pilositeCouleur[i].setEnabled(false);
            }
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
