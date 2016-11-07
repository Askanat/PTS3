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

        nouvellePartie.setBounds((int) (13 / 20.0 * X), (int) (7 / 18.0 * Y), (int) (5 / 24.0 * X), (int) (1 / 20.0 * Y));
        nouvellePartie.setBackground(new Color(0, 0, 0, 0));
        nouvellePartie.setFocusable(false);
        nouvellePartie.setCursor(new Cursor(Cursor.HAND_CURSOR));
        nouvellePartie.setBorder(null);

        chargerPartie.setBounds((int) (13 / 20.0 * X), (int) (11 / 24.0 * Y), (int) (5 / 24.0 * X), (int) (1 / 20.0 * Y));
        chargerPartie.setBackground(new Color(0, 0, 0, 0));
        chargerPartie.setFocusable(false);
        chargerPartie.setCursor(new Cursor(Cursor.HAND_CURSOR));
        chargerPartie.setBorder(null);

        options.setBounds((int) (13 / 20.0 * X), (int) (19 / 36.0 * Y), (int) (5 / 24.0 * X), (int) (1 / 20.0 * Y));
        options.setBackground(new Color(0, 0, 0, 0));
        options.setFocusable(false);
        options.setCursor(new Cursor(Cursor.HAND_CURSOR));
        options.setBorder(null);

        credits.setBounds((int) (13 / 20.0 * X), (int) (3 / 5.0 * Y), (int) (5 / 24.0 * X), (int) (1 / 20.0 * Y));
        credits.setBackground(new Color(0, 0, 0, 0));
        credits.setFocusable(false);
        credits.setCursor(new Cursor(Cursor.HAND_CURSOR));
        credits.setBorder(null);

        quitter.setBounds((int) (13 / 20.0 * X), (int) (27 / 40.0 * Y), (int) (5 / 24.0 * X), (int) (1 / 20.0 * Y));
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
