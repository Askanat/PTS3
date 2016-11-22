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

        add(slot1);
        add(slot2);
        add(slot3);
        add(continuer);
        add(retour);
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

        continuer.setBounds(Fenetre.adapterResolutionEnX(704), Fenetre.adapterResolutionEnY(792), Fenetre.adapterResolutionEnX(480), Fenetre.adapterResolutionEnY(90));
        continuer.setBackground(new Color(0, 0, 0, 0));
        continuer.setFocusable(false);
        continuer.setCursor(new Cursor(Cursor.HAND_CURSOR));
        continuer.setBorder(null);

        retour.setBounds(Fenetre.adapterResolutionEnX(64), Fenetre.adapterResolutionEnY(985), Fenetre.adapterResolutionEnX(256), Fenetre.adapterResolutionEnY(41));
        retour.setBackground(new Color(0, 0, 0, 0));
        retour.setFocusable(false);
        retour.setCursor(new Cursor(Cursor.HAND_CURSOR));
        retour.setBorder(null);


        g.drawImage(getToolkit().getImage("images/menuNouvellePartie.png"), 0, 0, getWidth(), getHeight(), this); // image a modifier

        try {
            g.drawImage(Entite.decoupage(ImageIO.read(new File("images/texture_hero1.png")), 3, 11)[1], Fenetre.adapterResolutionEnX(360), Fenetre.adapterResolutionEnY(312), Fenetre.adapterResolutionEnX(200), Fenetre.adapterResolutionEnY(200), this);
            g.drawImage(Entite.decoupage(ImageIO.read(new File("images/texture_hero2.png")), 3, 11)[1], Fenetre.adapterResolutionEnX(860), Fenetre.adapterResolutionEnY(312), Fenetre.adapterResolutionEnX(200), Fenetre.adapterResolutionEnY(200), this);
            g.drawImage(Entite.decoupage(ImageIO.read(new File("images/texture_hero3.png")), 3, 11)[1], Fenetre.adapterResolutionEnX(1360), Fenetre.adapterResolutionEnY(312), Fenetre.adapterResolutionEnX(200), Fenetre.adapterResolutionEnY(200), this);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
