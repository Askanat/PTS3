package controleur;

import model.Jeu;
import vue.Fenetre;

import javax.swing.*;
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

        if (ControlFenetreCharger.chargerPartie) {
            ControlFenetreCharger.chargerPartie = false;
            enPartie();
        }

        if (Control.enPartie) {
            if (jeu.getPause()) {// echap
                fenetre.setContentPane(fenetre.panelMenuEnJeu);
                fenetre.repaint();
                fenetre.pack();
                fenetre.setLocationRelativeTo(null);
                fenetre.requestFocus();
            } else {
                fenetre.setContentPane(fenetre.panelFenetreDepart);
                fenetre.repaint();
                fenetre.pack();
                fenetre.setLocationRelativeTo(null);
                fenetre.requestFocus();
            }

            if (!jeu.getPause()) {
                jeu.incrementeTemps();

                if (ControlClavier.toucheEnfoncer[1]) {// touche de gauche
                    jeu.getHero().deplacerAGauche();
                }
                if (ControlClavier.toucheEnfoncer[2] && !jeu.getHero().getDessendre() && temps == 0) {// touche du haut
                    jeu.getHero().setSauter(true);
                    temps = jeu.getTemps();
                }
                if (ControlClavier.toucheEnfoncer[3]) {// touche de droite
                    jeu.getHero().deplacerADroite();
                }

                if (jeu.getHero().getSauter() && jeu.getTemps() <= temps + 10)
                    jeu.getHero().sauter();
                else if (jeu.getHero().getSauter()){
                    jeu.getHero().setSauter(false);
                    temps = 0;
                }

                jeu.getHero().dessendre(jeu.getHero().getPositionY() > 800);


                fenetre.panelFenetreDepart.hero.selectionnerMorceauSpriteDeplacement(jeu.getHero().getVecteurDeplacementEnX(), jeu.getHero().getVecteurDeplacementEnY());
                jeu.getHero().deplacer();
/*
                for (int i = 0; i < jeu.getSizeTabMonstre(); i++) {
                    Thread monstreThread = new Thread(jeu.getMonstre(i));

                   if(monstreThread.isAlive() == false)
                        monstreThread.start();

                    fenetre.panelFenetreDepart.monstre.get(i).selectionnerMorceauSpriteDeplacement(jeu.getMonstre(i).getVecteurDeplacementEnX(), jeu.getMonstre(i).getVecteurDeplacementEnY());
                }
                */

            }
            // jeu.getHero().setVie(jeu.getHero().getVie() - 1); // enleve vie du hero
        }

        fenetre.repaint();
    }

    void enPartie() {
        Control.enPartie = true;
        fenetre.barreMenu.setVisible(true);
        fenetre.setContentPane(fenetre.panelFenetreDepart);
        fenetre.repaint();
        fenetre.pack();
        fenetre.setLocationRelativeTo(null);
        fenetre.requestFocus();
    }
}