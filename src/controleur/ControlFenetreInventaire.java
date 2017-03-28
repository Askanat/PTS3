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
    private String buttonclickedInv1 = "";

    public ControlFenetreInventaire(Jeu jeu, Fenetre fenetre) {
        super(jeu, fenetre);
        fenetre.setControlFenetreInventaire(this);
    }

    public void actionPerformed(ActionEvent e) {
        String buttonclicked = "";

        //Système de récupération des boutons d'inventaires différents
        if(e.getActionCommand().contains("Inventaire")){

            /*if(buttonclicked1.equals("")) {
                for (int i=10;i < e.getActionCommand().length();i++){
                    buttonclicked1 += e.getActionCommand().charAt(i);
                }
            } else if(buttonclicked2.equals("")){
                for (int i=10;i < e.getActionCommand().length();i++){
                    buttonclicked2 += e.getActionCommand().charAt(i);
                }
            }

            switch(buttonclickedInv1) {
                case "Casque" :
                    System.out.println("Coucou1");
                    iconTampon1 = fenetre.panelFenetreInventaire.casque;
                    System.out.println(buttonclicked2);
                    break;
            }

            if(buttonclicked2.length() < 2) {
                System.out.println("Coucou2");
                iconTampon2 = fenetre.panelFenetreInventaire.inventaire[Integer.parseInt((buttonclicked2))];
                fenetre.panelFenetreInventaire.inventaire[Integer.parseInt(buttonclicked2)] = iconTampon1;
                fenetre.panelFenetreInventaire.casque = iconTampon2;

                iconTampon1 = null;
                iconTampon2 = null;
                buttonclicked1 = "";
                buttonclicked2 = "";
            }


            //Echange entre les deux cases de l'inventaire
            if(iconTampon1 == null) {
                iconTampon1 = fenetre.panelFenetreInventaire.inventaire[Integer.parseInt(buttonclicked1)];
            } else if(buttonclicked1.length() > 10 && buttonclicked2.length() > 10) {
                iconTampon2 = fenetre.panelFenetreInventaire.inventaire[Integer.parseInt((buttonclicked2))];
                fenetre.panelFenetreInventaire.inventaire[Integer.parseInt(buttonclicked2)] = iconTampon1;
                fenetre.panelFenetreInventaire.inventaire[Integer.parseInt(buttonclicked1)] = iconTampon2;

                iconTampon1 = null;
                iconTampon2 = null;
                buttonclicked1 = "";
                buttonclicked2 = "";
            }*/

        } else {

            switch (e.getActionCommand()) {

                case "Retour":
                    Control.enPartie = true;
                    fenetre.setContentPane(fenetre.panelScrollFenetreJeu);
                    changerVue();
                    fenetre.vueMenuEnJeu();
                    break;

                default:
                        /*if(buttonclicked1.equals("")) {
                            for (int i = 0; i < e.getActionCommand().length(); i++) {
                                buttonclicked1 += e.getActionCommand().charAt(i);
                            }
                        } else {
                            for (int i = 0; i < e.getActionCommand().length(); i++) {
                                buttonclicked2 += e.getActionCommand().charAt(i);
                            }
                        }
                    System.out.println("Bouton 1 : " + buttonclicked1);
                    System.out.println("Bouton 2 : " + buttonclicked2);*/
                    break;
            }
        }
    }
}
