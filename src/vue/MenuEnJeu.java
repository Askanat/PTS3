package vue;

import controleur.ControlMenuEnJeu;
import model.Jeu;

import javax.swing.*;
import java.awt.*;

import static vue.Fenetre.X;
import static vue.Fenetre.Y;

/**
 * Created by Florian Vaissiere on 06/10/2016.
 */

public class MenuEnJeu extends JPanel {

    private Jeu jeu;
    public JButton retourJeu, inventaire, fichePersonnage, option, retourMenuPrincipal, retourBureau;

    private Image imageMenuEnJeu;

    public MenuEnJeu(Jeu jeu) {
        this.jeu = jeu;

        this.setLayout(null);
        this.setPreferredSize(new Dimension(X / 2, Y / 2));
        this.setOpaque(false);
        imageMenuEnJeu = getToolkit().getImage("images/menuPause.png");

        retourJeu = new JButton("");
        retourJeu.setActionCommand("Retour");
        inventaire = new JButton("");
        inventaire.setActionCommand("Inventaire");
        fichePersonnage = new JButton("");
        fichePersonnage.setActionCommand("Fiche Personnage");
        option = new JButton("");
        option.setActionCommand("Option");
        retourMenuPrincipal = new JButton("");
        retourMenuPrincipal.setActionCommand("Retour au Menu Principal");
        retourBureau = new JButton("");
        retourBureau.setActionCommand("Retour Au Bureau");

        this.add(retourJeu);
        this.add(inventaire);
        this.add(fichePersonnage);
        this.add(option);
        this.add(retourMenuPrincipal);
        this.add(retourBureau);
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

        g.drawImage(imageMenuEnJeu, 0, 0, getWidth(), getHeight(), this);

        retourJeu.setBounds(Fenetre.adapterResolutionEnX(289), Fenetre.adapterResolutionEnY(92), Fenetre.adapterResolutionEnX(378), Fenetre.adapterResolutionEnY(55));
        retourJeu.setBackground(new Color(0, 0, 0, 0));
        retourJeu.setFocusable(false);
        retourJeu.setCursor(new Cursor(Cursor.HAND_CURSOR));
        retourJeu.setBorder(null);

        inventaire.setBounds(Fenetre.adapterResolutionEnX(289), Fenetre.adapterResolutionEnY(160), Fenetre.adapterResolutionEnX(378), Fenetre.adapterResolutionEnY(54));
        inventaire.setBackground(new Color(0, 0, 0, 0));
        inventaire.setFocusable(false);
        inventaire.setCursor(new Cursor(Cursor.HAND_CURSOR));
        inventaire.setBorder(null);

        fichePersonnage.setBounds(Fenetre.adapterResolutionEnX(289), Fenetre.adapterResolutionEnY(227), Fenetre.adapterResolutionEnX(378), Fenetre.adapterResolutionEnY(55));
        fichePersonnage.setBackground(new Color(0, 0, 0, 0));
        fichePersonnage.setFocusable(false);
        fichePersonnage.setCursor(new Cursor(Cursor.HAND_CURSOR));
        fichePersonnage.setBorder(null);

        option.setBounds(Fenetre.adapterResolutionEnX(289), Fenetre.adapterResolutionEnY(293), Fenetre.adapterResolutionEnX(379), Fenetre.adapterResolutionEnY(55));
        option.setBackground(new Color(0, 0, 0, 0));
        option.setFocusable(false);
        option.setCursor(new Cursor(Cursor.HAND_CURSOR));
        option.setBorder(null);

        retourMenuPrincipal.setBounds(Fenetre.adapterResolutionEnX(289), Fenetre.adapterResolutionEnY(358), Fenetre.adapterResolutionEnX(379), Fenetre.adapterResolutionEnY(55));
        retourMenuPrincipal.setBackground(new Color(0, 0, 0, 0));
        retourMenuPrincipal.setFocusable(false);
        retourMenuPrincipal.setCursor(new Cursor(Cursor.HAND_CURSOR));
        retourMenuPrincipal.setBorder(null);

        retourBureau.setBounds(Fenetre.adapterResolutionEnX(289), Fenetre.adapterResolutionEnY(426), Fenetre.adapterResolutionEnX(378), Fenetre.adapterResolutionEnY(55));
        retourBureau.setBackground(new Color(0, 0, 0, 0));
        retourBureau.setFocusable(false);
        retourBureau.setCursor(new Cursor(Cursor.HAND_CURSOR));
        retourBureau.setBorder(null);
    }
}
