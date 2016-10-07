package vue;

import controleur.ControlMenuPrincipal;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Florian Vaissiere on 06/10/2016.
 */
public class MenuEnJeu extends JPanel{
    public JButton inventaire, fichePersonnage, chargerPartie, retourMenuPrincipal, retourBurreau, retourJeu;

    public MenuEnJeu() {
        this.setLayout(null);

        inventaire = new JButton("Inventaire");
        inventaire.setActionCommand("Inventaire");
        fichePersonnage = new JButton("Fiche Personnage");
        fichePersonnage.setActionCommand("Fiche Personnage");
        chargerPartie = new JButton("Charger Partie");
        chargerPartie.setActionCommand("Charger Partie");
        retourMenuPrincipal = new JButton("Retour au Menu Principal");
        retourMenuPrincipal.setActionCommand("Retour au Menu Principal");
        retourBurreau = new JButton("Retour au Bureau");
        retourBurreau.setActionCommand("Retour au Bureau");
        retourJeu = new JButton("Retour au Jeu");
        retourJeu.setActionCommand("Retour au Jeu");

        add(inventaire);
        add(fichePersonnage);
        add(chargerPartie);
        add(retourMenuPrincipal);
        add(retourBurreau);
        add(retourJeu);
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        inventaire.setBounds(290, 150, 228, 40);
        inventaire.setForeground(Color.WHITE);
        inventaire.setBackground(new Color(0, 0, 0, 0));
        inventaire.setFocusable(false);
        inventaire.setCursor(new Cursor(Cursor.HAND_CURSOR));
        inventaire.setBorder(null);

        fichePersonnage.setBounds(290, 200, 228, 40);
        fichePersonnage.setForeground(Color.WHITE);
        fichePersonnage.setBackground(new Color(0, 0, 0, 0));
        fichePersonnage.setFocusable(false);
        fichePersonnage.setCursor(new Cursor(Cursor.HAND_CURSOR));
        fichePersonnage.setBorder(null);

        chargerPartie.setBounds(290, 250, 228, 40);
        chargerPartie.setForeground(Color.WHITE);
        chargerPartie.setBackground(new Color(0, 0, 0, 0));
        chargerPartie.setFocusable(false);
        chargerPartie.setCursor(new Cursor(Cursor.HAND_CURSOR));
        chargerPartie.setBorder(null);

        retourMenuPrincipal.setBounds(290, 300, 228, 40);
        retourMenuPrincipal.setForeground(Color.WHITE);
        retourMenuPrincipal.setBackground(new Color(0, 0, 0, 0));
        retourMenuPrincipal.setFocusable(false);
        retourMenuPrincipal.setCursor(new Cursor(Cursor.HAND_CURSOR));
        retourMenuPrincipal.setBorder(null);

        retourBurreau.setBounds(290, 350, 228, 40);
        retourBurreau.setForeground(Color.WHITE);
        retourBurreau.setBackground(new Color(0, 0, 0, 0));
        retourBurreau.setFocusable(false);
        retourBurreau.setCursor(new Cursor(Cursor.HAND_CURSOR));
        retourBurreau.setBorder(null);

        retourJeu.setBounds(40, 980, 228, 40);
        retourJeu.setForeground(Color.WHITE);
        retourJeu.setBackground(new Color(0, 0, 0, 0));
        retourJeu.setFocusable(false);
        retourJeu.setCursor(new Cursor(Cursor.HAND_CURSOR));
        retourJeu.setBorder(null);

        Image img = getToolkit().getImage("images/fondMenuPrinci.jpg");
        g.drawImage(img, 0, 0, getWidth(), getHeight(), this);
    }

    public void setControl(ControlMenuPrincipal controlMenuPrincipal) {
        inventaire.addActionListener(controlMenuPrincipal);
        fichePersonnage.addActionListener(controlMenuPrincipal);
        chargerPartie.addActionListener(controlMenuPrincipal);
        retourMenuPrincipal.addActionListener(controlMenuPrincipal);
        retourBurreau.addActionListener(controlMenuPrincipal);
        retourJeu.addActionListener(controlMenuPrincipal);
    }
}
