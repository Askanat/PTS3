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

    public ControlFenetreInventaire(Jeu jeu, Fenetre fenetre) {
        super(jeu, fenetre);
        fenetre.setControlFenetreInventaire(this);
    }

    public void actionPerformed(ActionEvent e) {
        String nombre1="";
        String nombre2="";
        JButton valeurInventaire[] = new JButton[1];

        //Système de récupération des boutons d'inventaires différents
        if(e.getActionCommand().contains("Inventaire")){

            for (int i=10;i < e.getActionCommand().length();i++){
                nombre1+=e.getActionCommand().charAt(i);
            }

            if (e.getActionCommand().contains("Inventaire")){
                for (int j=10;j < e.getActionCommand().length();j++){
                    nombre2+=e.getActionCommand().charAt(j);
                }
                //Echange entre les deux cases de l'inventaire
                valeurInventaire[0] = fenetre.panelFenetreInventaire.inventaire[Integer.parseInt(nombre1)];
                fenetre.panelFenetreInventaire.inventaire[Integer.parseInt(nombre1)] = fenetre.panelFenetreInventaire.inventaire[Integer.parseInt(nombre2)];
                fenetre.panelFenetreInventaire.inventaire[Integer.parseInt(nombre2)] =  valeurInventaire[0];
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

            System.out.println("Bouton : " + Integer.parseInt(nombre1));
            System.out.println("Bouton : " + Integer.parseInt(nombre2));
        }else{

            switch (e.getActionCommand()) {
                case "Casque":
                    if (e.getActionCommand().contains("Inventaire")) {

                        for (int i = 10; i < e.getActionCommand().length(); i++) {
                            nombre1 += e.getActionCommand().charAt(i);
                        }
                    }

                    break;

                case "Plastron":
                    if (e.getActionCommand().contains("Inventaire")) {

                        for (int i = 10; i < e.getActionCommand().length(); i++) {
                            nombre1 += e.getActionCommand().charAt(i);
                        }
                    }

                    break;

                case "Gant":
                    if (e.getActionCommand().contains("Inventaire")) {

                        for (int i = 10; i < e.getActionCommand().length(); i++) {
                            nombre1 += e.getActionCommand().charAt(i);
                        }
                    }

                    break;

                case "Bague":
                    if (e.getActionCommand().contains("Inventaire")) {

                        for (int i = 10; i < e.getActionCommand().length(); i++) {
                            nombre1 += e.getActionCommand().charAt(i);
                        }
                    }

                    break;

                case "Pantalon":
                    if (e.getActionCommand().contains("Inventaire")) {

                        for (int i = 10; i < e.getActionCommand().length(); i++) {
                            nombre1 += e.getActionCommand().charAt(i);
                        }
                    }

                    break;

                case "Botte":
                    if (e.getActionCommand().contains("Inventaire")) {

                        for (int i = 10; i < e.getActionCommand().length(); i++) {
                            nombre1 += e.getActionCommand().charAt(i);
                        }
                    }

                    break;

                case "Bouclier":
                    if (e.getActionCommand().contains("Inventaire")) {

                        for (int i = 10; i < e.getActionCommand().length(); i++) {
                            nombre1 += e.getActionCommand().charAt(i);
                        }
                    }

                    break;

                case "Arme":
                    if (e.getActionCommand().contains("Inventaire")) {

                        for (int i = 10; i < e.getActionCommand().length(); i++) {
                            nombre1 += e.getActionCommand().charAt(i);
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
