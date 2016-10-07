package vue;

import controleur.ControlMenuEnJeu;
import controleur.ControlMenuPrincipal;
import model.Jeu;

import javax.swing.*;
import java.awt.*;

import static vue.Fenetre.X;
import static vue.Fenetre.Y;

/**
 * Created by Florian Vaissiere on 06/10/2016.
 */
public class MenuEnJeu extends JPanel{

    private Jeu jeu;
    public JButton retourJeu, inventaire, fichePersonnage, retourMenuPrincipal;

    public MenuEnJeu(Jeu jeu) {
        this.jeu = jeu;

        this.setLayout(null);
        setPreferredSize(new Dimension(X, Y));

        retourJeu = new JButton("Retour");
        retourJeu.setActionCommand("Retour");
        inventaire = new JButton("Inventaire");
        inventaire.setActionCommand("Inventaire");
        fichePersonnage = new JButton("Fiche Personnage");
        fichePersonnage.setActionCommand("Fiche Personnage");
        retourMenuPrincipal = new JButton("Retour au Menu Principal");
        retourMenuPrincipal.setActionCommand("Retour au Menu Principal");

        add(retourJeu);
        add(inventaire);
        add(fichePersonnage);
        add(retourMenuPrincipal);
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        retourJeu.setBounds(290, 150, 228, 40);
        retourJeu.setForeground(Color.WHITE);
        retourJeu.setBackground(new Color(0, 0, 0, 0));
        retourJeu.setFocusable(false);
        retourJeu.setCursor(new Cursor(Cursor.HAND_CURSOR));
        retourJeu.setBorder(null);

        inventaire.setBounds(290, 200, 228, 40);
        inventaire.setForeground(Color.WHITE);
        inventaire.setBackground(new Color(0, 0, 0, 0));
        inventaire.setFocusable(false);
        inventaire.setCursor(new Cursor(Cursor.HAND_CURSOR));
        inventaire.setBorder(null);

        fichePersonnage.setBounds(290, 250, 228, 40);
        fichePersonnage.setForeground(Color.WHITE);
        fichePersonnage.setBackground(new Color(0, 0, 0, 0));
        fichePersonnage.setFocusable(false);
        fichePersonnage.setCursor(new Cursor(Cursor.HAND_CURSOR));
        fichePersonnage.setBorder(null);

        retourMenuPrincipal.setBounds(290, 300, 228, 40);
        retourMenuPrincipal.setForeground(Color.WHITE);
        retourMenuPrincipal.setBackground(new Color(0, 0, 0, 0));
        retourMenuPrincipal.setFocusable(false);
        retourMenuPrincipal.setCursor(new Cursor(Cursor.HAND_CURSOR));
        retourMenuPrincipal.setBorder(null);

        Image img = getToolkit().getImage("images/fondMenuPrinci.jpg");
        g.drawImage(img, 0, 0, getWidth(), getHeight(), this);
    }

    public void setControl(ControlMenuEnJeu controlMenuEnJeu) {
        retourJeu.addActionListener(controlMenuEnJeu);
        inventaire.addActionListener(controlMenuEnJeu);
        fichePersonnage.addActionListener(controlMenuEnJeu);
        retourMenuPrincipal.addActionListener(controlMenuEnJeu);
    }
}
