package vue;

import controleur.ControlFenetreCharger;
import model.Jeu;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

import static vue.Fenetre.X;
import static vue.Fenetre.Y;

/**
 * Created by bastien on 29/09/16.
 */

public class FenetreCharger extends JPanel {

    private Jeu jeu;
    public JButton slot1, slot2, slot3, jouer, retour;
    public JLabel nomSlot1, nomSlot2, nomSlot3, niveauSlot1, niveauSlot2, niveauSlot3;

    public FenetreCharger(Jeu jeu) {

        this.jeu = jeu;

        this.setLayout(null);
        setPreferredSize(new Dimension(X, Y));

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
        nomSlot1 = new JLabel(jeu.readNomPerso(1));
        nomSlot2 = new JLabel(jeu.readNomPerso(2));
        nomSlot3 = new JLabel(jeu.readNomPerso(3));
        niveauSlot1 = new JLabel(jeu.readLVLPerso(1));
        niveauSlot2 = new JLabel(jeu.readLVLPerso(2));
        niveauSlot3 = new JLabel(jeu.readLVLPerso(3));


        add(slot1);
        add(slot2);
        add(slot3);
        add(jouer);
        add(retour);
        add(nomSlot1);
        add(nomSlot2);
        add(nomSlot3);
        add(niveauSlot1);
        add(niveauSlot2);
        add(niveauSlot3);
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

        slot1.setBounds(Fenetre.adapterResolutionEnX(340), Fenetre.adapterResolutionEnY(240), Fenetre.adapterResolutionEnX(240), Fenetre.adapterResolutionEnY(280));
        slot1.setBackground(new Color(0, 0, 0, 0));
        slot1.setFocusable(false);
        slot1.setCursor(new Cursor(Cursor.HAND_CURSOR));
        slot1.setBorder(null);

        slot2.setBounds(Fenetre.adapterResolutionEnX(840), Fenetre.adapterResolutionEnY(240), Fenetre.adapterResolutionEnX(240), Fenetre.adapterResolutionEnY(280));
        slot2.setBackground(new Color(0, 0, 0, 0));
        slot2.setFocusable(false);
        slot2.setCursor(new Cursor(Cursor.HAND_CURSOR));
        slot2.setBorder(null);

        slot3.setBounds(Fenetre.adapterResolutionEnX(1338), Fenetre.adapterResolutionEnY(240), Fenetre.adapterResolutionEnX(240), Fenetre.adapterResolutionEnY(280));
        slot3.setBackground(new Color(0, 0, 0, 0));
        slot3.setFocusable(false);
        slot3.setCursor(new Cursor(Cursor.HAND_CURSOR));
        slot3.setBorder(null);

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


        nomSlot1.setBounds(Fenetre.adapterResolutionEnX(340), Fenetre.adapterResolutionEnY(340), Fenetre.adapterResolutionEnX(240), Fenetre.adapterResolutionEnY(380));
        nomSlot1.setForeground(Color.WHITE);
        nomSlot1.setBackground(new Color(0, 0, 0, 0));
        nomSlot1.setFocusable(false);
        nomSlot1.setCursor(new Cursor(Cursor.HAND_CURSOR));
        nomSlot1.setBorder(null);

        niveauSlot1.setBounds(Fenetre.adapterResolutionEnX(530), Fenetre.adapterResolutionEnY(340), Fenetre.adapterResolutionEnX(240), Fenetre.adapterResolutionEnY(380));
        niveauSlot1.setForeground(Color.WHITE);
        niveauSlot1.setBackground(new Color(0, 0, 0, 0));
        niveauSlot1.setFocusable(false);
        niveauSlot1.setCursor(new Cursor(Cursor.HAND_CURSOR));
        niveauSlot1.setBorder(null);


        if (3 - jeu.getNbPartieLibre() >= 2) {
            nomSlot2.setBounds(Fenetre.adapterResolutionEnX(840), Fenetre.adapterResolutionEnY(340), Fenetre.adapterResolutionEnX(240), Fenetre.adapterResolutionEnY(380));
            nomSlot2.setForeground(Color.WHITE);
            nomSlot2.setBackground(new Color(0, 0, 0, 0));
            nomSlot2.setFocusable(false);
            nomSlot2.setCursor(new Cursor(Cursor.HAND_CURSOR));
            nomSlot2.setBorder(null);

            niveauSlot2.setBounds(Fenetre.adapterResolutionEnX(1030), Fenetre.adapterResolutionEnY(340), Fenetre.adapterResolutionEnX(240), Fenetre.adapterResolutionEnY(380));
            niveauSlot2.setForeground(Color.WHITE);
            niveauSlot2.setBackground(new Color(0, 0, 0, 0));
            niveauSlot2.setFocusable(false);
            niveauSlot2.setCursor(new Cursor(Cursor.HAND_CURSOR));
            niveauSlot2.setBorder(null);
        }

        if (3 - jeu.getNbPartieLibre() >= 3) {
            nomSlot3.setBounds(Fenetre.adapterResolutionEnX(1338), Fenetre.adapterResolutionEnY(340), Fenetre.adapterResolutionEnX(240), Fenetre.adapterResolutionEnY(380));
            nomSlot3.setForeground(Color.WHITE);
            nomSlot3.setBackground(new Color(0, 0, 0, 0));
            nomSlot3.setFocusable(false);
            nomSlot3.setCursor(new Cursor(Cursor.HAND_CURSOR));
            nomSlot3.setBorder(null);

            niveauSlot3.setBounds(Fenetre.adapterResolutionEnX(1528), Fenetre.adapterResolutionEnY(340), Fenetre.adapterResolutionEnX(240), Fenetre.adapterResolutionEnY(380));
            niveauSlot3.setForeground(Color.WHITE);
            niveauSlot3.setBackground(new Color(0, 0, 0, 0));
            niveauSlot3.setFocusable(false);
            niveauSlot3.setCursor(new Cursor(Cursor.HAND_CURSOR));
            niveauSlot3.setBorder(null);
        }

        g.drawImage(getToolkit().getImage("images/chargerPartie.png"), 0, 0, getWidth(), getHeight(), this);

        try {
            g.drawImage(Entite.decoupage(ImageIO.read(new File("images/Save/texture_hero1.png")), 3, 11)[1], Fenetre.adapterResolutionEnX(310), Fenetre.adapterResolutionEnY(262), Fenetre.adapterResolutionEnX(Entite.TAILLE_SPRITE_LARGEUR), Fenetre.adapterResolutionEnY(Entite.TAILLE_SPRITE_HAUTEUR), this);
            if (3 - jeu.getNbPartieLibre() >= 2) {
                g.drawImage(Entite.decoupage(ImageIO.read(new File("images/Save/texture_hero2.png")), 3, 11)[1], Fenetre.adapterResolutionEnX(810), Fenetre.adapterResolutionEnY(262), Fenetre.adapterResolutionEnX(Entite.TAILLE_SPRITE_LARGEUR), Fenetre.adapterResolutionEnY(Entite.TAILLE_SPRITE_HAUTEUR), this);
            }
            if (3 - jeu.getNbPartieLibre() >= 3) {
                g.drawImage(Entite.decoupage(ImageIO.read(new File("images/Save/texture_hero3.png")), 3, 11)[1], Fenetre.adapterResolutionEnX(1310), Fenetre.adapterResolutionEnY(262), Fenetre.adapterResolutionEnX(Entite.TAILLE_SPRITE_LARGEUR), Fenetre.adapterResolutionEnY(Entite.TAILLE_SPRITE_HAUTEUR), this);
            }
            g.drawImage(getToolkit().getImage("images/feuPorte.png"), Fenetre.adapterResolutionEnX(-194 + 500 * Fenetre.numeroPorte), Fenetre.adapterResolutionEnY(200), Fenetre.adapterResolutionEnX(300), Fenetre.adapterResolutionEnY(300), this);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void setLabelNom1(String nom) {
        nomSlot1.setText(nom);
    }

    public void setLabelNom2(String nom) {
        nomSlot2.setText(nom);
    }

    public void setLabelNom3(String nom) {
        nomSlot3.setText(nom);
    }

    public void setLabelLVL1(String nom) {
        niveauSlot1.setText(nom);
    }

    public void setLabelLVL2(String nom) {
        niveauSlot2.setText(nom);
    }

    public void setLabelLVL3(String nom) {
        niveauSlot3.setText(nom);
    }
}
