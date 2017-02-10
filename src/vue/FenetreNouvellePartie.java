package vue;

import controleur.ControlFenetreNouvellePartie;
import model.Jeu;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

import static vue.Fenetre.*;


/**
 * Created by bastien on 29/09/16.
 */

public class FenetreNouvellePartie extends JPanel {

    public static final int NOMBRE_DE_SLOT_FENETRE_NOUVELLE_PARTIE = 3;

    private Jeu jeu;

    private Image imagePorte, imageFenetreNouvellePartie;
    private Font taillePolice;

    public JButton tabSlot[];
    public JLabel tabNomSlot[];
    public JLabel tabNiveauSlot[];

    public JButton continuer, retour;

    public FenetreNouvellePartie(Jeu jeu) {

        this.jeu = jeu;

        this.setLayout(null);
        this.setPreferredSize(new Dimension(X, Y));

        imagePorte = getToolkit().getImage("images/feuPorte.png");
        imageFenetreNouvellePartie = getToolkit().getImage("images/menuNouvellePartie.png");
        taillePolice = new Font("Arial", Font.BOLD, Fenetre.adapterResolutionEnX(20));

        tabSlot = new JButton[NOMBRE_DE_SLOT_FENETRE_NOUVELLE_PARTIE];
        tabNomSlot = new JLabel[NOMBRE_DE_SLOT_FENETRE_NOUVELLE_PARTIE];
        tabNiveauSlot = new JLabel[NOMBRE_DE_SLOT_FENETRE_NOUVELLE_PARTIE];

        for (int i = 0; i < NOMBRE_DE_SLOT_FENETRE_NOUVELLE_PARTIE; i++) {
            tabSlot[i] = new JButton("");
            tabSlot[i].setActionCommand("Slot n°" + (i + 1));
            tabNomSlot[i] = new JLabel(jeu.readNomPerso(i + 1), JLabel.CENTER);
            tabNiveauSlot[i] = new JLabel("Niveau " + jeu.readLVLPerso(i + 1), JLabel.CENTER);
        }

        continuer = new JButton("");
        continuer.setActionCommand("Continuer");
        retour = new JButton("");
        retour.setActionCommand("Retour");

        for (int i = 0; i < NOMBRE_DE_SLOT_FENETRE_NOUVELLE_PARTIE; i++) {
            this.add(tabSlot[i]);
            this.add(tabNomSlot[i]);
            this.add(tabNiveauSlot[i]);
        }

        this.add(continuer);
        this.add(retour);
    }

    public void setControl(ControlFenetreNouvellePartie controlFenetreNouvellePartie) {
        for (int i = 0; i < NOMBRE_DE_SLOT_FENETRE_NOUVELLE_PARTIE; i++)
            tabSlot[i].addActionListener(controlFenetreNouvellePartie);
        continuer.addActionListener(controlFenetreNouvellePartie);
        retour.addActionListener(controlFenetreNouvellePartie);
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.drawImage(imageFenetreNouvellePartie, 0, 0, getWidth(), getHeight(), this);

        for (int i = 0; i < NOMBRE_DE_SLOT_FENETRE_NOUVELLE_PARTIE; i++) {
            tabSlot[i].setBounds(Fenetre.adapterResolutionEnX(340 + i * 500), Fenetre.adapterResolutionEnY(240), Fenetre.adapterResolutionEnX(240), Fenetre.adapterResolutionEnY(280));
            tabSlot[i].setBackground(new Color(0, 0, 0, 0));
            tabSlot[i].setFocusable(false);
            tabSlot[i].setCursor(new Cursor(Cursor.HAND_CURSOR));
            tabSlot[i].setBorder(null);

            tabNomSlot[i].setBounds(Fenetre.adapterResolutionEnX(360 + i * 500), Fenetre.adapterResolutionEnY(524), Fenetre.adapterResolutionEnX(200), Fenetre.adapterResolutionEnY(20));
            tabNomSlot[i].setForeground(Color.WHITE);
            tabNomSlot[i].setBackground(new Color(0, 0, 0, 0));
            tabNomSlot[i].setFont(taillePolice);
            tabNomSlot[i].setFocusable(false);
            tabNomSlot[i].setCursor(new Cursor(Cursor.HAND_CURSOR));
            tabNomSlot[i].setBorder(null);

            tabNiveauSlot[i].setBounds(Fenetre.adapterResolutionEnX(360 + i * 500), Fenetre.adapterResolutionEnY(561), Fenetre.adapterResolutionEnX(200), Fenetre.adapterResolutionEnY(20));
            tabNiveauSlot[i].setForeground(Color.WHITE);
            tabNiveauSlot[i].setBackground(new Color(0, 0, 0, 0));
            tabNiveauSlot[i].setFont(taillePolice);
            tabNiveauSlot[i].setFocusable(false);
            tabNiveauSlot[i].setCursor(new Cursor(Cursor.HAND_CURSOR));
            tabNiveauSlot[i].setBorder(null);
        }

        continuer.setBounds(Fenetre.adapterResolutionEnX(706), Fenetre.adapterResolutionEnY(790), Fenetre.adapterResolutionEnX(480), Fenetre.adapterResolutionEnY(90));
        continuer.setBackground(new Color(0, 0, 0, 0));
        continuer.setFocusable(false);
        continuer.setCursor(new Cursor(Cursor.HAND_CURSOR));
        continuer.setBorder(null);

        retour.setBounds(Fenetre.adapterResolutionEnX(64), Fenetre.adapterResolutionEnY(985), Fenetre.adapterResolutionEnX(256), Fenetre.adapterResolutionEnY(41));
        retour.setBackground(new Color(0, 0, 0, 0));
        retour.setFocusable(false);
        retour.setCursor(new Cursor(Cursor.HAND_CURSOR));
        retour.setBorder(null);

        try {
            for (int i = 0; i < NOMBRE_DE_SLOT_FENETRE_NOUVELLE_PARTIE; i++) {
                g.drawImage(decoupage(ImageIO.read(new File("images/Save/texture_hero" + (i + 1) + ".png")), 3, 11)[1], Fenetre.adapterResolutionEnX(310 + i * 500), Fenetre.adapterResolutionEnY(262), EntiteVue.TAILLE_SPRITE_LARGEUR, EntiteVue.TAILLE_SPRITE_HAUTEUR, this);
            }
            g.drawImage(imagePorte, Fenetre.adapterResolutionEnX(-194 + 500 * Fenetre.numeroPorte), Fenetre.adapterResolutionEnY(200), EntiteVue.TAILLE_SPRITE_LARGEUR, EntiteVue.TAILLE_SPRITE_HAUTEUR, this);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void init() {
        for (int i = 0; i < NOMBRE_DE_SLOT_FENETRE_NOUVELLE_PARTIE; i++) {
            tabNomSlot[i].setText(jeu.readNomPerso(i + 1));
            tabNiveauSlot[i].setText("Niveau " + jeu.readLVLPerso(i + 1));
        }
    }

    public void setPaneSelectionnePersonnageASupprimer() {
        JOptionPane.showMessageDialog(this, "Selectionnez une partie à supprimer avant de cliquer sur continuer !", "message", JOptionPane.INFORMATION_MESSAGE);
    }
}
