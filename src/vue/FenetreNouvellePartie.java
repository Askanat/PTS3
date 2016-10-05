package vue;

import controleur.ControlFenetreNouvellePartie;
import model.Jeu;

import javax.swing.*;
import java.awt.*;

import static vue.Fenetre.X;
import static vue.Fenetre.Y;

/**
 * Created by bastien on 29/09/16.
 */

public class FenetreNouvellePartie extends JPanel {

    private Jeu jeu;
    public JButton slot1, slot2, slot3, retour;

    public FenetreNouvellePartie(Jeu jeu) {
        this.jeu = jeu;

        this.setLayout(null);
        setPreferredSize(new Dimension(X, Y));

        slot1 = new JButton("Slot de Sauvegarde n°1");
        slot1.setActionCommand("Slot de Sauvegarde n°1");
        slot2 = new JButton("Slot de Sauvegarde n°2");
        slot2.setActionCommand("Slot de Sauvegarde n°2");
        slot3 = new JButton("Slot de Sauvegarde n°3");
        slot3.setActionCommand("Slot de Sauvegarde n°3");
        retour = new JButton("Retour");
        retour.setActionCommand("Retour");

        add(slot1);
        add(slot2);
        add(slot3);
        add(retour);
    }

    public void setControl(ControlFenetreNouvellePartie controlFenetreNouvellePartie) {
        slot1.addActionListener(controlFenetreNouvellePartie);
        slot2.addActionListener(controlFenetreNouvellePartie);
        slot3.addActionListener(controlFenetreNouvellePartie);
        retour.addActionListener(controlFenetreNouvellePartie);
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        slot1.setBounds(290, 150, 228, 40);
        slot1.setForeground(Color.WHITE);
        slot1.setBackground(new Color(0, 0, 0, 0));
        slot1.setFocusable(false);
        slot1.setCursor(new Cursor(Cursor.HAND_CURSOR));
        slot1.setBorder(null);

        slot2.setBounds(290, 250, 228, 40);
        slot2.setForeground(Color.WHITE);
        slot2.setBackground(new Color(0, 0, 0, 0));
        slot2.setFocusable(false);
        slot2.setCursor(new Cursor(Cursor.HAND_CURSOR));
        slot2.setBorder(null);

        slot3.setBounds(290, 350, 228, 40);
        slot3.setForeground(Color.WHITE);
        slot3.setBackground(new Color(0, 0, 0, 0));
        slot3.setFocusable(false);
        slot3.setCursor(new Cursor(Cursor.HAND_CURSOR));
        slot3.setBorder(null);

        retour.setBounds(40, 500, 228, 40);
        retour.setForeground(Color.WHITE);
        retour.setBackground(new Color(0, 0, 0, 0));
        retour.setFocusable(false);
        retour.setCursor(new Cursor(Cursor.HAND_CURSOR));
        retour.setBorder(null);

        Image img = getToolkit().getImage("images/fondMenuPrinci.jpg");
        g.drawImage(img, 0, 0, getWidth(), getHeight(), this);
    }
}