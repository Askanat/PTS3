package controleur;

import model.Direction;
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

        if (ControlClavier.toucheRelacher[ControlTouche.ECHAP]) {
            if (Control.enPartie)
                jeu.inversePause();
            ControlClavier.toucheRelacher[ControlTouche.ECHAP] = false;
        }

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

                if (ControlClavier.toucheEnfoncer[ControlTouche.GAUCHE]) {
                    jeu.getHero().setDirection(Direction.GAUCHE);
                    jeu.getHero().deplacerAGauche();
                }

                if (ControlClavier.toucheEnfoncer[ControlTouche.HAUT] && jeu.getHero().getCollision()) {
                    jeu.getHero().sauter();
                }

                if (ControlClavier.toucheEnfoncer[ControlTouche.DROITE]) {
                    jeu.getHero().setDirection(Direction.DROITE);
                    jeu.getHero().deplacerADroite();
                }

                if (ControlClavier.toucheRelacher[ControlTouche.A]) {
                    jeu.getHero().setAttaquer(true);
                    fenetre.panelFenetreDepart.hero.setAlternerSprite(0);

                    // Problème, il faut seulement attaquer lorsque la touche est relachée. C'est pas géré pour le moment.
                    int nbMonstre = jeu.getSizeTabMonstre(), i;

                    for (i = 0; i < nbMonstre; i++) {
                        jeu.getHero().attaquer(jeu.getMonstre(i));
                        System.out.println("Attaque du personnage");
                    }

                    ControlClavier.toucheRelacher[ControlTouche.A] = false;
                }

                jeu.getHero().setCollision();
                fenetre.panelFenetreDepart.hero.selectionnerMorceauSpriteDeplacement(jeu.getHero().getVecteurDeplacementEnX());
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