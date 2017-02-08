package controleur;

import model.Jeu;
import vue.Fenetre;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by MSI-FlorianV on 30/12/2016.
 */
public class ControlFenetreInventaire extends Control implements ActionListener {

    public ControlFenetreInventaire(Jeu jeu, Fenetre fenetre) {
        super(jeu, fenetre);
        fenetre.setControlFenetreInventaire(this);
    }

    public void actionPerformed(ActionEvent e) {
        String nombre="";

        //Système de récupération des boutons d'inventaires différents
        if(e.getActionCommand().contains("Inventaire")){

            for (int i=10;i < e.getActionCommand().length();i++){
                nombre+=e.getActionCommand().charAt(i);
            }

            System.out.println("Bouton : " + Integer.parseInt(nombre));
        }

        switch (e.getActionCommand()) {
            case "Casque":

                break;

            case "Plastron":

                break;

            case "Gant":

                break;

            case "Bague":

                break;

            case "Pantalon":

                break;

            case "Botte":

                break;

            case "Bouclier":

                break;

            case "Arme":

                break;

            case "Retour":
                Control.enPartie = true;
                fenetre.setContentPane(fenetre.panelScrollFenetreJeu);
                changerVue();
                fenetre.vueMenuEnJeu();
                break;
        }
    }
}
