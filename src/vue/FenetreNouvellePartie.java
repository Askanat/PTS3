package vue;

import controleur.ControlFenetreNouvellePartie;
import model.Jeu;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

import static model.Jeu.X;
import static model.Jeu.Y;


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

        slot1.setBounds((int) (17 / 96.0 * X), (int) (2 / 9.0 * Y), (int) (1 / 8.0 * X), (int) (7 / 27.0 * Y));
        slot1.setBackground(new Color(0, 0, 0, 0));
        slot1.setFocusable(false);
        slot1.setCursor(new Cursor(Cursor.HAND_CURSOR));
        slot1.setBorder(null);

        slot2.setBounds((int) (7 / 16.0 * X), (int) (2 / 9.0 * Y), (int) (1 / 8.0 * X), (int) (7 / 27.0 * Y));
        slot2.setBackground(new Color(0, 0, 0, 0));
        slot2.setFocusable(false);
        slot2.setCursor(new Cursor(Cursor.HAND_CURSOR));
        slot2.setBorder(null);

        slot3.setBounds((int) (223 / 320.0 * X), (int) (2 / 9.0 * Y), (int) (1 / 8.0 * X), (int) (7 / 27.0 * Y));
        slot3.setBackground(new Color(0, 0, 0, 0));
        slot3.setFocusable(false);
        slot3.setCursor(new Cursor(Cursor.HAND_CURSOR));
        slot3.setBorder(null);

        continuer.setBounds((int) (11 / 30.0 * X), (int) (11 / 15.0 * Y), (int) (1 / 4.0 * X), (int) (1 / 12.0 * Y));
        continuer.setBackground(new Color(0, 0, 0, 0));
        continuer.setFocusable(false);
        continuer.setCursor(new Cursor(Cursor.HAND_CURSOR));
        continuer.setBorder(null);

        retour.setBounds((int) (1 / 30.0 * X), (int) (49 / 54.0 * Y), (int) (2 / 15.0 * X), (int) (2 / 45.0 * Y));
        retour.setBackground(new Color(0, 0, 0, 0));
        retour.setFocusable(false);
        retour.setCursor(new Cursor(Cursor.HAND_CURSOR));
        retour.setBorder(null);


        g.drawImage(getToolkit().getImage("images/menuNouvellePartie.png"), 0, 0, getWidth(), getHeight(), this); // image a modifier

        try {
            g.drawImage(Entite.decoupage(ImageIO.read(new File("images/texture_hero1.png")), 3, 11)[1], (int) (3 / 16.0 * X), (int) (13 / 45.0 * Y), (int) (5 / 48.0 * X), (int) (5 / 27.0 * Y), this);
            g.drawImage(Entite.decoupage(ImageIO.read(new File("images/texture_hero2.png")), 3, 11)[1], (int) (43 / 96.0 * X), (int) (13 / 45.0 * Y), (int) (5 / 48.0 * X), (int) (5 / 27.0 * Y), this);
            g.drawImage(Entite.decoupage(ImageIO.read(new File("images/texture_hero3.png")), 3, 11)[1], (int) (17 / 24.0 * X), (int) (13 / 45.0 * Y), (int) (5 / 48.0 * X), (int) (5 / 27.0 * Y), this);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
