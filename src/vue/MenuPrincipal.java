package vue;

import controleur.ControlMenuPrincipal;

import javax.swing.*;
import java.awt.*;

import static vue.Fenetre.X;
import static vue.Fenetre.Y;

/**
 * Created by bastien on 29/09/16.
 */

public class MenuPrincipal extends JPanel {

    public JButton nouvellePartie, chargerPartie, options, credits, quitter;

    public MenuPrincipal() {

        this.setLayout(null);
        setPreferredSize(new Dimension(X, Y));

        nouvellePartie = new JButton("");
        nouvellePartie.setActionCommand("Nouvelle Partie");
        chargerPartie = new JButton("");
        chargerPartie.setActionCommand("Charger Partie");
        options = new JButton("");
        options.setActionCommand("Options");
        credits = new JButton("");
        credits.setActionCommand("Crédits");
        quitter = new JButton("");
        quitter.setActionCommand("Quitter");

        add(nouvellePartie);
        add(chargerPartie);
        add(options);
        add(credits);
        add(quitter);
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        nouvellePartie.setBounds(1248, 419, 415, 52);
        nouvellePartie.setBackground(new Color(0, 0, 0, 0));
        nouvellePartie.setFocusable(false);
        nouvellePartie.setCursor(new Cursor(Cursor.HAND_CURSOR));
        nouvellePartie.setBorder(null);

        chargerPartie.setBounds(1249, 496, 415, 52);
        chargerPartie.setBackground(new Color(0, 0, 0, 0));
        chargerPartie.setFocusable(false);
        chargerPartie.setCursor(new Cursor(Cursor.HAND_CURSOR));
        chargerPartie.setBorder(null);

        options.setBounds(1249, 572, 415, 52);
        options.setBackground(new Color(0, 0, 0, 0));
        options.setFocusable(false);
        options.setCursor(new Cursor(Cursor.HAND_CURSOR));
        options.setBorder(null);

        credits.setBounds(1248, 649, 418, 52);
        credits.setBackground(new Color(0, 0, 0, 0));
        credits.setFocusable(false);
        credits.setCursor(new Cursor(Cursor.HAND_CURSOR));
        credits.setBorder(null);

        quitter.setBounds(1248, 726, 416, 53);
        quitter.setBackground(new Color(0, 0, 0, 0));
        quitter.setFocusable(false);
        quitter.setCursor(new Cursor(Cursor.HAND_CURSOR));
        quitter.setBorder(null);

        Image img = getToolkit().getImage("images/testMenu.png");
        g.drawImage(img, 0, 0, getWidth(), getHeight(), this);
    }

    public void setControl(ControlMenuPrincipal controlMenuPrincipal) {
        nouvellePartie.addActionListener(controlMenuPrincipal);
        chargerPartie.addActionListener(controlMenuPrincipal);
        options.addActionListener(controlMenuPrincipal);
        credits.addActionListener(controlMenuPrincipal);
        quitter.addActionListener(controlMenuPrincipal);
    }
}