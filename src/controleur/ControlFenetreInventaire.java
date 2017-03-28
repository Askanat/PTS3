package controleur;

import model.Equipement;
import model.Jeu;
import vue.Fenetre;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * Created by MSI-FlorianV on 30/12/2016.
 */
public class ControlFenetreInventaire extends Control implements ActionListener {

    private Icon iconTampon1 = null;
    private Icon iconTampon2 = null;
    private String buttonclicked1="";

    public ControlFenetreInventaire(Jeu jeu, Fenetre fenetre) {
        super(jeu, fenetre);
        fenetre.setControlFenetreInventaire(this);
    }

    public void actionPerformed(ActionEvent e) {
        ArrayList<Equipement> inventaire = jeu.getHero().inventaire;

        //Système de récupération des boutons d'inventaires différents
        if(e.getActionCommand().contains("Inventaire")){

            if(buttonclicked1.equals("")) {
                for (int i=10;i < e.getActionCommand().length();i++){
                    buttonclicked1 += e.getActionCommand().charAt(i);
                }
                iconTampon1 = fenetre.panelFenetreInventaire.inventaire[Integer.parseInt((buttonclicked1))].getIcon();
            }

            /*else if(buttonclicked2.equals("")){
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
            if (inventaire.size() != 0) {
                switch (e.getActionCommand()) {

                    case "Casque":
                        if (inventaire.get(Integer.parseInt(buttonclicked1)).getTypeItem() == 2) {
                            iconTampon2 = fenetre.panelFenetreInventaire.casque.getIcon();
                            fenetre.panelFenetreInventaire.inventaire[Integer.parseInt(buttonclicked1)].setIcon(iconTampon2);
                            fenetre.panelFenetreInventaire.casque.setIcon(iconTampon1);
                        } else {
                            System.out.println("Mauvais emplacement !!");
                        }
                        break;

                    case "Plastron":
                        if (inventaire.get(Integer.parseInt(buttonclicked1)).getTypeItem() == 1) {
                            iconTampon2 = fenetre.panelFenetreInventaire.plastron.getIcon();
                            fenetre.panelFenetreInventaire.inventaire[Integer.parseInt(buttonclicked1)].setIcon(iconTampon2);
                            fenetre.panelFenetreInventaire.plastron.setIcon(iconTampon1);
                        } else {
                            System.out.println("Mauvais emplacement !!");
                        }
                        break;

                    case "Gant":
                        if (inventaire.get(Integer.parseInt(buttonclicked1)).getTypeItem() == 5) {
                            iconTampon2 = fenetre.panelFenetreInventaire.gant.getIcon();
                            fenetre.panelFenetreInventaire.inventaire[Integer.parseInt(buttonclicked1)].setIcon(iconTampon2);
                            fenetre.panelFenetreInventaire.gant.setIcon(iconTampon1);
                        } else {
                            System.out.println("Mauvais emplacement !!");
                        }
                        break;

                    case "Bague":
                        if (inventaire.get(Integer.parseInt(buttonclicked1)).getTypeItem() == 7) {
                            iconTampon2 = fenetre.panelFenetreInventaire.bague.getIcon();
                            fenetre.panelFenetreInventaire.inventaire[Integer.parseInt(buttonclicked1)].setIcon(iconTampon2);
                            fenetre.panelFenetreInventaire.bague.setIcon(iconTampon1);
                        } else {
                            System.out.println("Mauvais emplacement !!");
                        }
                        break;

                    case "Pantalon":
                        if (inventaire.get(Integer.parseInt(buttonclicked1)).getTypeItem() == 6) {
                            iconTampon2 = fenetre.panelFenetreInventaire.pantalon.getIcon();
                            fenetre.panelFenetreInventaire.inventaire[Integer.parseInt(buttonclicked1)].setIcon(iconTampon2);
                            fenetre.panelFenetreInventaire.pantalon.setIcon(iconTampon1);
                        } else {
                            System.out.println("Mauvais emplacement !!");
                        }
                        break;

                    case "Botte":
                        if (inventaire.get(Integer.parseInt(buttonclicked1)).getTypeItem() == 4) {
                            iconTampon2 = fenetre.panelFenetreInventaire.botte.getIcon();
                            fenetre.panelFenetreInventaire.inventaire[Integer.parseInt(buttonclicked1)].setIcon(iconTampon2);
                            fenetre.panelFenetreInventaire.botte.setIcon(iconTampon1);
                        } else {
                            System.out.println("Mauvais emplacement !!");
                        }
                        break;

                    case "Bouclier":
                        if (inventaire.get(Integer.parseInt(buttonclicked1)).getTypeItem() == 9) {
                            iconTampon2 = fenetre.panelFenetreInventaire.bouclier.getIcon();
                            fenetre.panelFenetreInventaire.inventaire[Integer.parseInt(buttonclicked1)].setIcon(iconTampon2);
                            fenetre.panelFenetreInventaire.bouclier.setIcon(iconTampon1);
                        } else {
                            System.out.println("Mauvais emplacement !!");
                        }
                        break;

                    case "Arme":
                        if (inventaire.get(Integer.parseInt(buttonclicked1)).getTypeItem() == 8) {
                            iconTampon2 = fenetre.panelFenetreInventaire.arme.getIcon();
                            fenetre.panelFenetreInventaire.inventaire[Integer.parseInt(buttonclicked1)].setIcon(iconTampon2);
                            fenetre.panelFenetreInventaire.arme.setIcon(iconTampon1);
                        } else {
                            System.out.println("Mauvais emplacement !!");
                        }
                        break;

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
            iconTampon1 = null;
            iconTampon2 = null;
            buttonclicked1 = "";
        }
    }
}
