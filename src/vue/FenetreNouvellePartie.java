package vue;

import controleur.ControlFenetreNouvellePartie;
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

public class FenetreNouvellePartie extends JPanel {

    private Jeu jeu;
    public JButton slot1, slot2, slot3, continuer, retour;
    public JLabel nomSlot1, nomSlot2, nomSlot3, niveauSlot1, niveauSlot2, niveauSlot3;

    public FenetreNouvellePartie(Jeu jeu) {

        this.jeu = jeu;

        this.setLayout(null);
        setPreferredSize(new Dimension(X, Y));

        slot1 = new JButton("");
        slot1.setActionCommand("Slot n°1");
        slot2 = new JButton("");
        slot2.setActionCommand("Slot n°2");
        slot3 = new JButton("");
        slot3.setActionCommand("Slot n°3");
        continuer = new JButton("");
        continuer.setActionCommand("Continuer");
        retour = new JButton("");
        retour.setActionCommand("Retour");
        nomSlot1 = new JLabel(jeu.readNomPerso(1));
        nomSlot2 = new JLabel(jeu.readNomPerso(2));
        nomSlot3 = new JLabel(jeu.readNomPerso(3));
        niveauSlot1 = new JLabel(jeu.readLVLPerso(1));
        niveauSlot2 = new JLabel(jeu.readLVLPerso(1));
        niveauSlot3 = new JLabel(jeu.readLVLPerso(3));

        add(slot1);
        add(slot2);
        add(slot3);
        add(continuer);
        add(retour);
        add(nomSlot1);
        add(nomSlot2);
        add(nomSlot3);
        add(niveauSlot1);
        add(niveauSlot2);
        add(niveauSlot3);
    }

    public void setControl(ControlFenetreNouvellePartie controlFenetreNouvellePartie) {
        slot1.addActionListener(controlFenetreNouvellePartie);
        slot2.addActionListener(controlFenetreNouvellePartie);
        slot3.addActionListener(controlFenetreNouvellePartie);
        continuer.addActionListener(controlFenetreNouvellePartie);
        retour.addActionListener(controlFenetreNouvellePartie);
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

        nomSlot1.setBounds(Fenetre.adapterResolutionEnX(340), Fenetre.adapterResolutionEnY(340), Fenetre.adapterResolutionEnX(240), Fenetre.adapterResolutionEnY(380));
        nomSlot1.setForeground(Color.WHITE);
        nomSlot1.setBackground(new Color(0, 0, 0, 0));
        nomSlot1.setFocusable(false);
        nomSlot1.setCursor(new Cursor(Cursor.HAND_CURSOR));
        nomSlot1.setBorder(null);

        nomSlot2.setBounds(Fenetre.adapterResolutionEnX(840), Fenetre.adapterResolutionEnY(340), Fenetre.adapterResolutionEnX(240), Fenetre.adapterResolutionEnY(380));
        nomSlot2.setForeground(Color.WHITE);
        nomSlot2.setBackground(new Color(0, 0, 0, 0));
        nomSlot2.setFocusable(false);
        nomSlot2.setCursor(new Cursor(Cursor.HAND_CURSOR));
        nomSlot2.setBorder(null);

        nomSlot3.setBounds(Fenetre.adapterResolutionEnX(1338), Fenetre.adapterResolutionEnY(340), Fenetre.adapterResolutionEnX(240), Fenetre.adapterResolutionEnY(380));
        nomSlot3.setForeground(Color.WHITE);
        nomSlot3.setBackground(new Color(0, 0, 0, 0));
        nomSlot3.setFocusable(false);
        nomSlot3.setCursor(new Cursor(Cursor.HAND_CURSOR));
        nomSlot3.setBorder(null);

        niveauSlot1.setBounds(Fenetre.adapterResolutionEnX(530), Fenetre.adapterResolutionEnY(340), Fenetre.adapterResolutionEnX(240), Fenetre.adapterResolutionEnY(380));
        niveauSlot1.setForeground(Color.WHITE);
        niveauSlot1.setBackground(new Color(0, 0, 0, 0));
        niveauSlot1.setFocusable(false);
        niveauSlot1.setCursor(new Cursor(Cursor.HAND_CURSOR));
        niveauSlot1.setBorder(null);

        niveauSlot2.setBounds(Fenetre.adapterResolutionEnX(1030), Fenetre.adapterResolutionEnY(340), Fenetre.adapterResolutionEnX(240), Fenetre.adapterResolutionEnY(380));
        niveauSlot2.setForeground(Color.WHITE);
        niveauSlot2.setBackground(new Color(0, 0, 0, 0));
        niveauSlot2.setFocusable(false);
        niveauSlot2.setCursor(new Cursor(Cursor.HAND_CURSOR));
        niveauSlot2.setBorder(null);

        niveauSlot3.setBounds(Fenetre.adapterResolutionEnX(1528), Fenetre.adapterResolutionEnY(340), Fenetre.adapterResolutionEnX(240), Fenetre.adapterResolutionEnY(380));
        niveauSlot3.setForeground(Color.WHITE);
        niveauSlot3.setBackground(new Color(0, 0, 0, 0));
        niveauSlot3.setFocusable(false);
        niveauSlot3.setCursor(new Cursor(Cursor.HAND_CURSOR));
        niveauSlot3.setBorder(null);


        g.drawImage(getToolkit().getImage("images/menuNouvellePartie.png"), 0, 0, getWidth(), getHeight(), this);

        try {
            g.drawImage(Entite.decoupage(ImageIO.read(new File("images/Save/texture_hero1.png")), 3, 11)[1], Fenetre.adapterResolutionEnX(310), Fenetre.adapterResolutionEnY(262), Entite.TAILLE_SPRITE_LARGEUR, Entite.TAILLE_SPRITE_HAUTEUR, this);
            g.drawImage(Entite.decoupage(ImageIO.read(new File("images/Save/texture_hero2.png")), 3, 11)[1], Fenetre.adapterResolutionEnX(810), Fenetre.adapterResolutionEnY(262), Entite.TAILLE_SPRITE_LARGEUR, Entite.TAILLE_SPRITE_HAUTEUR, this);
            g.drawImage(Entite.decoupage(ImageIO.read(new File("images/Save/texture_hero3.png")), 3, 11)[1], Fenetre.adapterResolutionEnX(1310), Fenetre.adapterResolutionEnY(262), Entite.TAILLE_SPRITE_LARGEUR, Entite.TAILLE_SPRITE_HAUTEUR, this);
            g.drawImage(getToolkit().getImage("images/feuPorte.png"), Fenetre.adapterResolutionEnX(-194+500*Fenetre.numeroPorte), Fenetre.adapterResolutionEnY(200), Entite.TAILLE_SPRITE_LARGEUR, Entite.TAILLE_SPRITE_HAUTEUR, this);
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

    public void setPaneSelectionnePersonnageASupprimer() {
        JOptionPane.showMessageDialog(this, "Selectionnez une partie à supprimer avant de cliquer sur continuer !", "message", JOptionPane.INFORMATION_MESSAGE);
    }
}
