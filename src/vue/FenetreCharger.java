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

    private Jeu jeu;
    public JButton slot1, slot2, slot3, jouer, retour;
    public JLabel nomSlot1, nomSlot2, nomSlot3, niveauSlot1, niveauSlot2, niveauSlot3;

    private Image imagePorte, imageFenetreCharger;
    private Font taillePolice;

    public FenetreCharger(Jeu jeu) {

        this.jeu = jeu;

        this.setLayout(null);
        this.setPreferredSize(new Dimension(X, Y));

        imagePorte = getToolkit().getImage("images/feuPorte.png");
        imageFenetreCharger = getToolkit().getImage("images/chargerPartie.png");
        taillePolice = new Font("Arial", Font.BOLD, Fenetre.adapterResolutionEnX(20));

        slot1 = new JButton("");
        slot1.setActionCommand("Slot de Sauvegarde n°1");
        slot2 = new JButton("");
        slot2.setActionCommand("Slot de Sauvegarde n°2");
        slot3 = new JButton("");
        slot3.setActionCommand("Slot de Sauvegarde n°3");
        jouer = new JButton("");
        jouer.setActionCommand("Jouer");
        retour = new JButton("");
        retour.setActionCommand("Retour");
        nomSlot1 = new JLabel(jeu.readNomPerso(1), JLabel.CENTER);
        nomSlot2 = new JLabel(jeu.readNomPerso(2), JLabel.CENTER);
        nomSlot3 = new JLabel(jeu.readNomPerso(3), JLabel.CENTER);
        niveauSlot1 = new JLabel("Niveau " + jeu.readLVLPerso(1), JLabel.CENTER);
        niveauSlot2 = new JLabel("Niveau " + jeu.readLVLPerso(2), JLabel.CENTER);
        niveauSlot3 = new JLabel("Niveau " + jeu.readLVLPerso(3), JLabel.CENTER);


        this.add(slot1);
        this.add(slot2);
        this.add(slot3);
        this.add(jouer);
        this.add(retour);
        this.add(nomSlot1);
        this.add(nomSlot2);
        this.add(nomSlot3);
        this.add(niveauSlot1);
        this.add(niveauSlot2);
        this.add(niveauSlot3);
    }

    public void setControl(ControlFenetreCharger controlFenetreCharger) {
        slot1.addActionListener(controlFenetreCharger);
        slot2.addActionListener(controlFenetreCharger);
        slot3.addActionListener(controlFenetreCharger);
        jouer.addActionListener(controlFenetreCharger);
        retour.addActionListener(controlFenetreCharger);
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.drawImage(imageFenetreCharger, 0, 0, getWidth(), getHeight(), this);

        if (!jeu.readLVLPerso(1).equals("0")) {
            slot1.setBounds(Fenetre.adapterResolutionEnX(340), Fenetre.adapterResolutionEnY(240), Fenetre.adapterResolutionEnX(240), Fenetre.adapterResolutionEnY(280));
            slot1.setBackground(new Color(0, 0, 0, 0));
            slot1.setFocusable(false);
            slot1.setCursor(new Cursor(Cursor.HAND_CURSOR));
            slot1.setBorder(null);

            nomSlot1.setBounds(Fenetre.adapterResolutionEnX(360), Fenetre.adapterResolutionEnY(524), Fenetre.adapterResolutionEnX(200), Fenetre.adapterResolutionEnY(20));
            nomSlot1.setForeground(Color.WHITE);
            nomSlot1.setBackground(new Color(0, 0, 0, 0));
            nomSlot1.setFont(taillePolice);
            nomSlot1.setFocusable(false);
            nomSlot1.setCursor(new Cursor(Cursor.HAND_CURSOR));
            nomSlot1.setBorder(null);

            niveauSlot1.setBounds(Fenetre.adapterResolutionEnX(360), Fenetre.adapterResolutionEnY(561), Fenetre.adapterResolutionEnX(200), Fenetre.adapterResolutionEnY(20));
            niveauSlot1.setForeground(Color.WHITE);
            niveauSlot1.setBackground(new Color(0, 0, 0, 0));
            niveauSlot1.setFont(taillePolice);
            niveauSlot1.setFocusable(false);
            niveauSlot1.setCursor(new Cursor(Cursor.HAND_CURSOR));
            niveauSlot1.setBorder(null);
        }

        if (!jeu.readLVLPerso(2).equals("0")) {
            slot2.setBounds(Fenetre.adapterResolutionEnX(840), Fenetre.adapterResolutionEnY(240), Fenetre.adapterResolutionEnX(240), Fenetre.adapterResolutionEnY(280));
            slot2.setBackground(new Color(0, 0, 0, 0));
            slot2.setFocusable(false);
            slot2.setCursor(new Cursor(Cursor.HAND_CURSOR));
            slot2.setBorder(null);

            nomSlot2.setBounds(Fenetre.adapterResolutionEnX(860), Fenetre.adapterResolutionEnY(524), Fenetre.adapterResolutionEnX(200), Fenetre.adapterResolutionEnY(20));
            nomSlot2.setForeground(Color.WHITE);
            nomSlot2.setBackground(new Color(0, 0, 0, 0));
            nomSlot2.setFont(taillePolice);
            nomSlot2.setFocusable(false);
            nomSlot2.setCursor(new Cursor(Cursor.HAND_CURSOR));
            nomSlot2.setBorder(null);

            niveauSlot2.setBounds(Fenetre.adapterResolutionEnX(860), Fenetre.adapterResolutionEnY(561), Fenetre.adapterResolutionEnX(200), Fenetre.adapterResolutionEnY(20));
            niveauSlot2.setForeground(Color.WHITE);
            niveauSlot2.setBackground(new Color(0, 0, 0, 0));
            niveauSlot2.setFont(taillePolice);
            niveauSlot2.setFocusable(false);
            niveauSlot2.setCursor(new Cursor(Cursor.HAND_CURSOR));
            niveauSlot2.setBorder(null);
        }

        if (!jeu.readLVLPerso(3).equals("0")) {
            slot3.setBounds(Fenetre.adapterResolutionEnX(1338), Fenetre.adapterResolutionEnY(240), Fenetre.adapterResolutionEnX(240), Fenetre.adapterResolutionEnY(280));
            slot3.setBackground(new Color(0, 0, 0, 0));
            slot3.setFocusable(false);
            slot3.setCursor(new Cursor(Cursor.HAND_CURSOR));
            slot3.setBorder(null);

            nomSlot3.setBounds(Fenetre.adapterResolutionEnX(1360), Fenetre.adapterResolutionEnY(524), Fenetre.adapterResolutionEnX(200), Fenetre.adapterResolutionEnY(20));
            nomSlot3.setForeground(Color.WHITE);
            nomSlot3.setBackground(new Color(0, 0, 0, 0));
            nomSlot3.setFont(taillePolice);
            nomSlot3.setFocusable(false);
            nomSlot3.setCursor(new Cursor(Cursor.HAND_CURSOR));
            nomSlot3.setBorder(null);

            niveauSlot3.setBounds(Fenetre.adapterResolutionEnX(1360), Fenetre.adapterResolutionEnY(561), Fenetre.adapterResolutionEnX(200), Fenetre.adapterResolutionEnY(20));
            niveauSlot3.setForeground(Color.WHITE);
            niveauSlot3.setBackground(new Color(0, 0, 0, 0));
            niveauSlot3.setFont(taillePolice);
            niveauSlot3.setFocusable(false);
            niveauSlot3.setCursor(new Cursor(Cursor.HAND_CURSOR));
            niveauSlot3.setBorder(null);
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
            if (!jeu.readLVLPerso(1).equals("0")) {
                g.drawImage(decoupage(ImageIO.read(new File("images/Save/texture_hero1.png")), 3, 11)[1], Fenetre.adapterResolutionEnX(310), Fenetre.adapterResolutionEnY(262), EntiteVue.TAILLE_SPRITE_LARGEUR, EntiteVue.TAILLE_SPRITE_HAUTEUR, this);
            }
            if (!jeu.readLVLPerso(2).equals("0")) {
                g.drawImage(decoupage(ImageIO.read(new File("images/Save/texture_hero2.png")), 3, 11)[1], Fenetre.adapterResolutionEnX(810), Fenetre.adapterResolutionEnY(262), EntiteVue.TAILLE_SPRITE_LARGEUR, EntiteVue.TAILLE_SPRITE_HAUTEUR, this);
            }
            if (!jeu.readLVLPerso(3).equals("0")) {
                g.drawImage(decoupage(ImageIO.read(new File("images/Save/texture_hero3.png")), 3, 11)[1], Fenetre.adapterResolutionEnX(1310), Fenetre.adapterResolutionEnY(262), EntiteVue.TAILLE_SPRITE_LARGEUR, EntiteVue.TAILLE_SPRITE_HAUTEUR, this);
            }
            g.drawImage(imagePorte, Fenetre.adapterResolutionEnX(-194 + 500 * Fenetre.numeroPorte), Fenetre.adapterResolutionEnY(200), EntiteVue.TAILLE_SPRITE_LARGEUR, EntiteVue.TAILLE_SPRITE_HAUTEUR, this);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void init() {
        nomSlot1.setText(jeu.readNomPerso(1));
        niveauSlot1.setText("Niveau " + jeu.readLVLPerso(1));
        nomSlot2.setText(jeu.readNomPerso(2));
        niveauSlot2.setText("Niveau " + jeu.readLVLPerso(2));
        nomSlot3.setText(jeu.readNomPerso(3));
        niveauSlot3.setText("Niveau " + jeu.readLVLPerso(3));
    }

    public void setPaneSelectionnePersonnage() {
        JOptionPane.showMessageDialog(this, "Selectionnez un personnage avant de cliquer sur jouer !", "message", JOptionPane.INFORMATION_MESSAGE);
    }
}

