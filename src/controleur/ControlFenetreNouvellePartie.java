package controleur;

import model.Jeu;
import vue.Fenetre;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by bastien on 29/09/16.
 */

public class ControlFenetreNouvellePartie extends Control implements ActionListener {

    private final int NOMBRE_DE_BOUTON = 3;
    public static boolean boutonEnfoncer[];

    public ControlFenetreNouvellePartie(Jeu jeu, Fenetre fenetre) {
        super(jeu, fenetre);
        fenetre.setControlFenetreNouvellePartie(this);

        boutonEnfoncer = new boolean[NOMBRE_DE_BOUTON];

        for (int i = 0; i < boutonEnfoncer.length; i++)
            boutonEnfoncer[i] = false;
    }

    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "Slot de Sauvegarde n°1":
                boutonEnfoncer[0] = true;
                fenetre.setContentPane(fenetre.panelFenetreDepart);
                fenetre.repaint();
                fenetre.pack();
                fenetre.setLocationRelativeTo(null);
                fenetre.requestFocus();
                break;
            case "Slot de Sauvegarde n°2":
                boutonEnfoncer[1] = true;
                fenetre.setContentPane(fenetre.panelFenetreDepart);
                fenetre.repaint();
                fenetre.pack();
                fenetre.setLocationRelativeTo(null);
                fenetre.requestFocus();
                break;
            case "Slot de Sauvegarde n°3":
                boutonEnfoncer[2] = true;
                fenetre.setContentPane(fenetre.panelFenetreDepart);
                fenetre.repaint();
                fenetre.pack();
                fenetre.setLocationRelativeTo(null);
                fenetre.requestFocus();
                break;
            case "Retour":
                for (int i=0; i<ControlMenuPrincipal.boutonEnfoncer.length; i++)
                    ControlMenuPrincipal.boutonEnfoncer[i] = false;
                fenetre.setContentPane(fenetre.panelMenuPrincipal);
                fenetre.repaint();
                fenetre.pack();
                fenetre.setLocationRelativeTo(null);
                fenetre.requestFocus();
                break;
        }
    }
}