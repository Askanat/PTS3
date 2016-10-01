package controleur;

import model.Jeu;
import vue.Fenetre;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by bastien on 29/09/16.
 */

public class ControlMenuPrincipal extends Control implements ActionListener {

    private final int NOMBRE_DE_BOUTON = 3;
    public static boolean boutonEnfoncer[];

    public ControlMenuPrincipal(Jeu jeu, Fenetre fenetre) {
        super(jeu, fenetre);
        fenetre.setControlMenuPrincipal(this);

        boutonEnfoncer = new boolean[NOMBRE_DE_BOUTON-1];

        for (int i = 0; i < boutonEnfoncer.length; i++)
            boutonEnfoncer[i] = false;
    }

    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "Nouvelle Partie":
                boutonEnfoncer[0] = true;
                fenetre.setContentPane(fenetre.panelFenetreNouvellePartie);
                fenetre.repaint();
                fenetre.pack();
                fenetre.setLocationRelativeTo(null);
                fenetre.requestFocus();
                break;
            case "Charger Partie":
                boutonEnfoncer[1] = true;
                fenetre.setContentPane(fenetre.panelFenetreCharger);
                fenetre.repaint();
                fenetre.pack();
                fenetre.setLocationRelativeTo(null);
                fenetre.requestFocus();
                break;
            case "Crédits":
                boutonEnfoncer[2] = true;
                fenetre.setContentPane(fenetre.panelFenetreCredits);
                fenetre.repaint();
                fenetre.pack();
                fenetre.setLocationRelativeTo(null);
                fenetre.requestFocus();
                break;
            case "Quitter":
                System.exit(0);
                break;
        }
    }
}