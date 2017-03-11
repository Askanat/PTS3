package controleur;

import model.Jeu;
import vue.Fenetre;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by MSI-FlorianV on 30/12/2016.
 */
public class ControlFenetreInventaire extends Control implements ActionListener {

    private JButton iconTampon1 = null;
    private JButton iconTampon2 = null;
    private String buttonclicked1="";
    private String buttonclicked2="";

    public ControlFenetreInventaire(Jeu jeu, Fenetre fenetre) {
        super(jeu, fenetre);
        fenetre.setControlFenetreInventaire(this);
    }

    public void actionPerformed(ActionEvent e) {
        String buttonclicked = "";

        //Système de récupération des boutons d'inventaires différents
        if(e.getActionCommand().contains("Inventaire")){

            if(buttonclicked1.equals("")) {
                for (int i=10;i < e.getActionCommand().length();i++){
                    buttonclicked1 += e.getActionCommand().charAt(i);
                }
            } else {
                for (int i=10;i < e.getActionCommand().length();i++){
                    buttonclicked2 += e.getActionCommand().charAt(i);
                }
            }

            System.out.println("Bouton 1 : " + buttonclicked1);
            System.out.println("Bouton 2 : " + buttonclicked2);

            //Echange entre les deux cases de l'inventaire
            if(iconTampon1 == null) {
                iconTampon1 = fenetre.panelFenetreInventaire.inventaire[Integer.parseInt(buttonclicked1)];
            } else {
                iconTampon2 = fenetre.panelFenetreInventaire.inventaire[Integer.parseInt((buttonclicked2))];
                fenetre.panelFenetreInventaire.inventaire[Integer.parseInt(buttonclicked2)] = iconTampon1;
                fenetre.panelFenetreInventaire.inventaire[Integer.parseInt(buttonclicked1)] = iconTampon2;

                iconTampon1 = null;
                iconTampon2 = null;
                buttonclicked1 = "";
                buttonclicked2 = "";
            }

            if (e.getActionCommand().contains("Casque")){

            }

            if (e.getActionCommand().contains("Plastron")){

            }

            if (e.getActionCommand().contains("Gant")){

            }

            if (e.getActionCommand().contains("Bague")){

            }

            if (e.getActionCommand().contains("Pantalon")){

            }

            if (e.getActionCommand().contains("Botte")){

            }

            if (e.getActionCommand().contains("Bouclier")){

            }

            if (e.getActionCommand().contains("Arme")){

            }

        } else {

            switch (e.getActionCommand()) {
                case "Casque":
                    if (e.getActionCommand().contains("Inventaire")) {

                        for (int i = 10; i < e.getActionCommand().length(); i++) {
                            buttonclicked += e.getActionCommand().charAt(i);
                        }
                    }

                    break;

                case "Plastron":
                    if (e.getActionCommand().contains("Inventaire")) {

                        for (int i = 10; i < e.getActionCommand().length(); i++) {
                            buttonclicked += e.getActionCommand().charAt(i);
                        }
                    }

                    break;

                case "Gant":
                    if (e.getActionCommand().contains("Inventaire")) {

                        for (int i = 10; i < e.getActionCommand().length(); i++) {
                            buttonclicked += e.getActionCommand().charAt(i);
                        }
                    }

                    break;

                case "Bague":
                    if (e.getActionCommand().contains("Inventaire")) {

                        for (int i = 10; i < e.getActionCommand().length(); i++) {
                            buttonclicked += e.getActionCommand().charAt(i);
                        }
                    }

                    break;

                case "Pantalon":
                    if (e.getActionCommand().contains("Inventaire")) {

                        for (int i = 10; i < e.getActionCommand().length(); i++) {
                            buttonclicked += e.getActionCommand().charAt(i);
                        }
                    }

                    break;

                case "Botte":
                    if (e.getActionCommand().contains("Inventaire")) {

                        for (int i = 10; i < e.getActionCommand().length(); i++) {
                            buttonclicked += e.getActionCommand().charAt(i);
                        }
                    }

                    break;

                case "Bouclier":
                    if (e.getActionCommand().contains("Inventaire")) {

                        for (int i = 10; i < e.getActionCommand().length(); i++) {
                            buttonclicked += e.getActionCommand().charAt(i);
                        }
                    }

                    break;

                case "Arme":
                    if (e.getActionCommand().contains("Inventaire")) {

                        for (int i = 10; i < e.getActionCommand().length(); i++) {
                            buttonclicked += e.getActionCommand().charAt(i);
                        }
                    }

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
}
