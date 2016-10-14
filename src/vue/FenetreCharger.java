package vue;

import controleur.ControlFenetreCharger;
import model.Jeu;

import javax.swing.*;
import java.awt.*;

import static vue.Fenetre.X;
import static vue.Fenetre.Y;

/**
 * Created by bastien on 29/09/16.
 */

public class FenetreCharger extends JPanel {

    private Jeu jeu;
    public JButton slot1, slot2, slot3, jouer, retour;

    public FenetreCharger(Jeu jeu) {

        this.jeu = jeu;

        this.setLayout(null);
        setPreferredSize(new Dimension(X, Y));

        slot1 = new JButton("Slot de Sauvegarde n°1");
        slot1.setActionCommand("Slot de Sauvegarde n°1");
        slot2 = new JButton("Slot de Sauvegarde n°2");
        slot2.setActionCommand("Slot de Sauvegarde n°2");
        slot3 = new JButton("Slot de Sauvegarde n°3");
        slot3.setActionCommand("Slot de Sauvegarde n°3");
        jouer = new JButton("Jouer");
        jouer.setActionCommand("Jouer");
        retour = new JButton("Retour");
        retour.setActionCommand("Retour");

        add(slot1);
        add(slot2);
        add(slot3);
        add(jouer);
        add(retour);
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

        slot1.setBounds(300, 150, 320, 480);
        slot1.setForeground(Color.WHITE);
        slot1.setBackground(new Color(0, 0, 0, 0));
        slot1.setFocusable(false);
        slot1.setCursor(new Cursor(Cursor.HAND_CURSOR));
        slot1.setBorder(null);

        slot2.setBounds(800, 150, 320, 480);
        slot2.setForeground(Color.WHITE);
        slot2.setBackground(new Color(0, 0, 0, 0));
        slot2.setFocusable(false);
        slot2.setCursor(new Cursor(Cursor.HAND_CURSOR));
        slot2.setBorder(null);

        slot3.setBounds(1300, 150, 320, 480);
        slot3.setForeground(Color.WHITE);
        slot3.setBackground(new Color(0, 0, 0, 0));
        slot3.setFocusable(false);
        slot3.setCursor(new Cursor(Cursor.HAND_CURSOR));
        slot3.setBorder(null);

        jouer.setBounds(760, 800, 400, 100);
        jouer.setForeground(Color.WHITE);
        jouer.setBackground(new Color(0, 0, 0, 0));
        jouer.setFocusable(false);
        jouer.setCursor(new Cursor(Cursor.HAND_CURSOR));
        jouer.setBorder(null);

        retour.setBounds(40, 1000, 228, 40);
        retour.setForeground(Color.WHITE);
        retour.setBackground(new Color(0, 0, 0, 0));
        retour.setFocusable(false);
        retour.setCursor(new Cursor(Cursor.HAND_CURSOR));
        retour.setBorder(null);

        Image img = getToolkit().getImage("images/fondMenuPrinci.jpg");
        g.drawImage(img, 0, 0, getWidth(), getHeight(), this);
    }
}