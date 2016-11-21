package controleur;

import model.Jeu;
import vue.Entite;
import vue.Fenetre;

import javax.swing.*;
import javax.swing.plaf.BorderUIResource;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by bastien on 30/09/16.
 */

public class ControlTimer extends Control implements ActionListener {

    private int temps = 0;

    public ControlTimer(Jeu jeu, Fenetre fenetre) {
        super(jeu, fenetre);

        Timer timer = new Timer(100, this);
        timer.start();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (ControlClavier.toucheRelacher[ControlTouche.ECHAP]) {
            jeu.inversePause();
            ControlClavier.toucheRelacher[ControlTouche.ECHAP] = false;
        }

        if (Control.enPartie) {
            if (jeu.getPause()) {
                fenetre.getContentPane().setLayout( new GridBagLayout());
                fenetre.getContentPane().isOpaque();
                GridBagConstraints gbc = new GridBagConstraints();
                gbc.weightx = 1;
                gbc.weighty = 1;

                gbc.gridx = 0;
                gbc.gridwidth = 2;
                gbc.gridheight = 2;
                gbc.gridy = 0;

                fenetre.getContentPane().add(fenetre.panelMenuEnJeu, gbc);
                fenetre.getContentPane().validate();
            } else {
                fenetre.getContentPane().removeAll();
                fenetre.setContentPane(fenetre.panelFenetreDepart);
                changerVue();
            }

            if (!jeu.getPause()) {
                jeu.incrementeTemps();

                if (ControlClavier.toucheEnfoncer[ControlTouche.GAUCHE]) {
                    jeu.getHero().deplacerAGauche();
                }

                if (ControlClavier.toucheEnfoncer[ControlTouche.HAUT]) {
                    jeu.getHero().sauter();
                }

                if (ControlClavier.toucheEnfoncer[ControlTouche.DROITE]) {
                    jeu.getHero().deplacerADroite();
                }

                if (ControlClavier.toucheRelacher[ControlTouche.A]) {
                    if (!jeu.getHero().getAttaquer()) {
                        jeu.getHero().setAttaquer(true);

                        /*
                        int nbMonstre = jeu.getSizeTabMonstre(), i;

                        for (i = 0; i < nbMonstre; i++) {
                            jeu.getHero().attaquer(jeu.getMonstre(i));
                            System.out.println("Attaque du personnage");
                        }*/

                        ControlClavier.toucheRelacher[ControlTouche.A] = false;
                    }
                }


                for (Entite entite : fenetre.panelFenetreDepart.hero)
                    entite.selectionnerMorceauSpriteDeplacement();

                jeu.getHero().deplacer();

                /*for (int i = 0; i < jeu.getSizeTabMonstre(); i++) {
                    Thread monstreThread = new Thread(jeu.getMonstre(i));

                    if (monstreThread.isAlive() == false)
                        monstreThread.start();

                    fenetre.panelFenetreDepart.monstre.get(i).selectionnerMorceauSpriteDeplacement(jeu.getMonstre(i).getVecteurDeplacementEnX(), jeu.getMonstre(i).getVecteurDeplacementEnY());
                }*/


            }
            // jeu.getHero().setVie(jeu.getHero().getVie() - 1); // enleve vie du hero
        }

        fenetre.repaint();
    }
}