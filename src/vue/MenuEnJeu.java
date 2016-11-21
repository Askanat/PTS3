package vue;

import controleur.ControlMenuEnJeu;
import model.Jeu;

import javax.swing.*;
import java.awt.*;

import static model.Jeu.X;
import static model.Jeu.Y;

/**
 * Created by Florian Vaissiere on 06/10/2016.
 */

public class MenuEnJeu extends JPanel {

    private Jeu jeu;
    public JButton retourJeu, inventaire, fichePersonnage, option, retourMenuPrincipal, retourBureau;

    public MenuEnJeu(Jeu jeu) {
        this.jeu = jeu;

        this.setLayout(null);
        setPreferredSize(new Dimension(X / 2, Y / 2));

        retourJeu = new JButton("Retour");
        retourJeu.setActionCommand("Retour");
        inventaire = new JButton("Inventaire");
        inventaire.setActionCommand("Inventaire");
        fichePersonnage = new JButton("Fiche Personnage");
        fichePersonnage.setActionCommand("Fiche Personnage");
        option = new JButton("Option");
        option.setActionCommand("Option");
        retourMenuPrincipal = new JButton("Retour au Menu Principal");
        retourMenuPrincipal.setActionCommand("Retour au Menu Principal");
        retourBureau = new JButton("Retour Au Bureau");
        retourBureau.setActionCommand("Retour Au Bureau");

        add(retourJeu);
        add(inventaire);
        add(fichePersonnage);
        add(option);
        add(retourMenuPrincipal);
        add(retourBureau);
    }

    public void setControl(ControlMenuEnJeu controlMenuEnJeu) {
        retourJeu.addActionListener(controlMenuEnJeu);
        inventaire.addActionListener(controlMenuEnJeu);
        fichePersonnage.addActionListener(controlMenuEnJeu);
        option.addActionListener(controlMenuEnJeu);
        retourMenuPrincipal.addActionListener(controlMenuEnJeu);
        retourBureau.addActionListener(controlMenuEnJeu);
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        retourJeu.setBounds((int) (37 / 96.0 * (X / 2.0)), (int) (5 / 18.0 * (Y / 2.0)), (int) (11 / 48.0 * (X / 2.0)), (int) (2 / 27.0 * (Y / 2.0)));
        retourJeu.setForeground(Color.WHITE);
        retourJeu.setBackground(new Color(0, 0, 0, 0));
        retourJeu.setFocusable(false);
        retourJeu.setCursor(new Cursor(Cursor.HAND_CURSOR));
        retourJeu.setBorder(null);

        inventaire.setBounds((int) (37 / 96.0 * (X / 2.0)), (int) (10 / 27.0 * Y / 2.0), (int) (11 / 48.0 * (X / 2.0)), (int) (2 / 27.0 * (Y / 2.0)));
        inventaire.setForeground(Color.WHITE);
        inventaire.setBackground(new Color(0, 0, 0, 0));
        inventaire.setFocusable(false);
        inventaire.setCursor(new Cursor(Cursor.HAND_CURSOR));
        inventaire.setBorder(null);

        fichePersonnage.setBounds((int) (37 / 96.0 * (X / 2.0)), (int) (25 / 54.0 * Y / 2.0), (int) (11 / 48.0 * (X / 2.0)), (int) (2 / 27.0 * (Y / 2.0)));
        fichePersonnage.setForeground(Color.WHITE);
        fichePersonnage.setBackground(new Color(0, 0, 0, 0));
        fichePersonnage.setFocusable(false);
        fichePersonnage.setCursor(new Cursor(Cursor.HAND_CURSOR));
        fichePersonnage.setBorder(null);

        option.setBounds((int) (37 / 96.0 * (X / 2.0)), (int) (5 / 9.0 * Y / 2.0), (int) (11 / 48.0 * (X / 2.0)), (int) (2 / 27.0 * (Y / 2.0)));
        option.setForeground(Color.WHITE);
        option.setBackground(new Color(0, 0, 0, 0));
        option.setFocusable(false);
        option.setCursor(new Cursor(Cursor.HAND_CURSOR));
        option.setBorder(null);

        retourMenuPrincipal.setBounds((int) (37 / 96.0 * (X / 2.0)), (int) (35 / 54.0 * Y / 2.0), (int) (11 / 48.0 * (X / 2.0)), (int) (2 / 27.0 * (Y / 2.0)));
        retourMenuPrincipal.setForeground(Color.WHITE);
        retourMenuPrincipal.setBackground(new Color(0, 0, 0, 0));
        retourMenuPrincipal.setFocusable(false);
        retourMenuPrincipal.setCursor(new Cursor(Cursor.HAND_CURSOR));
        retourMenuPrincipal.setBorder(null);

        retourBureau.setBounds((int) (37 / 96.0 * (X / 2.0)), (int) (20 / 27.0 * Y / 2.0), (int) (11 / 48.0 * (X / 2.0)), (int) (2 / 27.0 * (Y / 2.0)));
        retourBureau.setForeground(Color.WHITE);
        retourBureau.setBackground(new Color(0, 0, 0, 0));
        retourBureau.setFocusable(false);
        retourBureau.setCursor(new Cursor(Cursor.HAND_CURSOR));
        retourBureau.setBorder(null);

        Image img = getToolkit().getImage("images/fondMenuPrinci.jpg");
        g.drawImage(img, 0, 0, getWidth(), getHeight(), this);
    }
}