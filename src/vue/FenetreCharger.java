package vue;

import controleur.ControlFenetreCharger;
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

public class FenetreCharger extends JPanel {

    public static final int NOMBRE_DE_SLOT = 3;

    private Jeu jeu;

    private Image imagePorte, imageFenetreCharger;
    private Font taillePolice;

    public JButton tabSlot[];
    public JLabel tabNomSlot[];
    public JLabel tabNiveauSlot[];

    public JButton jouer, retour;


    public FenetreCharger(Jeu jeu) {

        this.jeu = jeu;

        this.setLayout(null);
        this.setPreferredSize(new Dimension(X, Y));

        imagePorte = getToolkit().getImage("images/feuPorte.png");
        imageFenetreCharger = getToolkit().getImage("images/chargerPartie.png");
        taillePolice = new Font("Arial", Font.BOLD, Fenetre.adapterResolutionEnX(20));

        tabSlot = new JButton[NOMBRE_DE_SLOT];
        tabNomSlot = new JLabel[NOMBRE_DE_SLOT];
        tabNiveauSlot = new JLabel[NOMBRE_DE_SLOT];

        for (int i = 0; i < NOMBRE_DE_SLOT; i++) {
            tabSlot[i] = new JButton("");
            tabSlot[i].setActionCommand("Slot de Sauvegarde n°" + (i + 1));
            tabNomSlot[i] = new JLabel(jeu.readNomPerso(i + 1), JLabel.CENTER);
            tabNiveauSlot[i] = new JLabel("Niveau " + jeu.readLVLPerso(i + 1), JLabel.CENTER);
        }

        jouer = new JButton("");
        jouer.setActionCommand("Jouer");
        retour = new JButton("");
        retour.setActionCommand("Retour");

        for (int i = 0; i < NOMBRE_DE_SLOT; i++) {
            this.add(tabSlot[i]);
            this.add(tabNomSlot[i]);
            this.add(tabNiveauSlot[i]);
        }

        this.add(jouer);
        this.add(retour);
    }

    public void setControl(ControlFenetreCharger controlFenetreCharger) {
        for (int i = 0; i < NOMBRE_DE_SLOT; i++)
            tabSlot[i].addActionListener(controlFenetreCharger);

        jouer.addActionListener(controlFenetreCharger);
        retour.addActionListener(controlFenetreCharger);
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.drawImage(imageFenetreCharger, 0, 0, getWidth(), getHeight(), this);

        for (int i = 0; i < NOMBRE_DE_SLOT; i++) {
            if (!jeu.readLVLPerso(i + 1).equals("0")) {
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
        }

        jouer.setBounds(Fenetre.adapterResolutionEnX(704), Fenetre.adapterResolutionEnY(792), Fenetre.adapterResolutionEnX(480), Fenetre.adapterResolutionEnY(90));
        jouer.setBackground(new Color(0, 0, 0, 0));
        jouer.setFocusable(false);
        jouer.setCursor(new Cursor(Cursor.HAND_CURSOR));
        jouer.setBorder(null);

        retour.setBounds(Fenetre.adapterResolutionEnX(64), Fenetre.adapterResolutionEnY(985), Fenetre.adapterResolutionEnX(256), Fenetre.adapterResolutionEnY(41));
        retour.setBackground(new Color(0, 0, 0, 0));
        retour.setFocusable(false);
        retour.setCursor(new Cursor(Cursor.HAND_CURSOR));
        retour.setBorder(null);

        try {
            for (int i = 0; i < NOMBRE_DE_SLOT; i++) {
                if (!jeu.readLVLPerso(i + 1).equals("0"))
                    g.drawImage(decoupage(ImageIO.read(new File("images/Save/texture_hero" + (i + 1) + ".png")), 3, 11)[1], Fenetre.adapterResolutionEnX(310 + i * 500), Fenetre.adapterResolutionEnY(262), EntiteVue.TAILLE_SPRITE_LARGEUR, EntiteVue.TAILLE_SPRITE_HAUTEUR, this);
            }
            g.drawImage(imagePorte, Fenetre.adapterResolutionEnX(-194 + 500 * Fenetre.numeroPorte), Fenetre.adapterResolutionEnY(200), EntiteVue.TAILLE_SPRITE_LARGEUR, EntiteVue.TAILLE_SPRITE_HAUTEUR, this);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void init() {
        for (int i = 0; i < NOMBRE_DE_SLOT; i++) {
            tabNomSlot[i].setText(jeu.readNomPerso(i + 1));
            tabNiveauSlot[i].setText("Niveau " + jeu.readLVLPerso(i + 1));
        }
    }

    public void setPaneSelectionnePersonnage() {
        JOptionPane.showMessageDialog(this, "Selectionnez un personnage avant de cliquer sur jouer !", "message", JOptionPane.INFORMATION_MESSAGE);
    }
}