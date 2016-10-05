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

    public JButton nouvellePartie, chargerPartie, credits, quitter;

    public MenuPrincipal() {
        this.setLayout(null);
        setPreferredSize(new Dimension(X, Y));

        nouvellePartie = new JButton("Nouvelle Partie");
        nouvellePartie.setActionCommand("Nouvelle Partie");
        chargerPartie = new JButton("Charger Partie");
        chargerPartie.setActionCommand("Charger Partie");
        credits = new JButton("Crédits");
        credits.setActionCommand("Crédits");
        quitter = new JButton("Quitter");
        quitter.setActionCommand("Quitter");

        add(nouvellePartie);
        add(chargerPartie);
        add(credits);
        add(quitter);
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        nouvellePartie.setBounds(290, 150, 228, 40);
        nouvellePartie.setForeground(Color.WHITE);
        nouvellePartie.setBackground(new Color(0, 0, 0, 0));
        nouvellePartie.setFocusable(false);
        nouvellePartie.setCursor(new Cursor(Cursor.HAND_CURSOR));
        nouvellePartie.setBorder(null);

        chargerPartie.setBounds(290, 225, 228, 40);
        chargerPartie.setForeground(Color.WHITE);
        chargerPartie.setBackground(new Color(0, 0, 0, 0));
        chargerPartie.setFocusable(false);
        chargerPartie.setCursor(new Cursor(Cursor.HAND_CURSOR));
        chargerPartie.setBorder(null);

        credits.setBounds(290, 300, 228, 40);
        credits.setForeground(Color.WHITE);
        credits.setBackground(new Color(0, 0, 0, 0));
        credits.setFocusable(false);
        credits.setCursor(new Cursor(Cursor.HAND_CURSOR));
        credits.setBorder(null);

        quitter.setBounds(290, 375, 228, 40);
        quitter.setForeground(Color.WHITE);
        quitter.setBackground(new Color(0, 0, 0, 0));
        quitter.setFocusable(false);
        quitter.setCursor(new Cursor(Cursor.HAND_CURSOR));
        quitter.setBorder(null);

        Image img = getToolkit().getImage("images/fondMenuPrinci.jpg");
        g.drawImage(img, 0, 0, getWidth(), getHeight(), this);
    }

    public void setControl(ControlMenuPrincipal controlMenuPrincipal) {
        nouvellePartie.addActionListener(controlMenuPrincipal);
        chargerPartie.addActionListener(controlMenuPrincipal);
        credits.addActionListener(controlMenuPrincipal);
        quitter.addActionListener(controlMenuPrincipal);
    }
}