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

    public ControlTimer(Jeu jeu, Fenetre fenetre) {
        super(jeu, fenetre);

        Timer timer = new Timer(100, this);
        timer.start();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (Control.enPartie) {
            if (ControlClavier.toucheRelacher[ControlTouche.ACTION_MENU]) {
                jeu.inversePause();

                if (jeu.getPause()) {
                    fenetre.vueMenuEnJeu();

                } else {
                    fenetre.layeredPane.removeAll();
                    fenetre.setContentPane(fenetre.panelScrollFenetreJeu);
                    changerVue();
                }
                ControlClavier.toucheRelacher[ControlTouche.ACTION_MENU] = false;
            }

            if (!jeu.getPause()) {
                jeu.incrementeTemps();
                if (jeu.getTemps() % 300 == 0) {
                    jeu.sauvegardeHero();
                    jeu.setSave(true);
                }
                if (jeu.getTemps() % 310 == 0) {
                    jeu.setSave(false);
                }

                if (ControlClavier.toucheEnfoncer[ControlTouche.ACTION_GAUCHE]) {
                    jeu.getHero().deplacerAGauche();
                }

                if (ControlClavier.toucheEnfoncer[ControlTouche.ACTION_SAUT]) {
                    jeu.getHero().sauter();

                    jeu.setMonstre(1, 900, 0); // a enlever d'ici
                    jeu.setMonstre(2, 1400, 0); // a enlever d'ici
                    jeu.setMonstre(3, 1900, 0); // a enlever d'ici
                    //jeu.setMonstre(4, 2400, 0); // a enlever d'ici
                }

                if (ControlClavier.toucheEnfoncer[ControlTouche.ACTION_DROITE]) {
                    jeu.getHero().deplacerADroite();
                }

                if (ControlClavier.toucheRelacher[ControlTouche.ACTION_ATTAQUE]) {
                    if (!jeu.getHero().getAttaquer()) {
                        jeu.getHero().setAttaquer(true);

                        int nbMonstre = jeu.getSizeTabMonstre(), i;

                        for (i = 0; i < nbMonstre; i++) {
                            jeu.getHero().attaquer(jeu.getMonstre(i));
                        }
                    }
                    ControlClavier.toucheRelacher[ControlTouche.ACTION_ATTAQUE] = false;
                }

                if (ControlClavier.toucheEnfoncer[ControlTouche.ACTION_SORT1]) {
                    System.out.println("touche f1 enfoncer");
                }
                if (ControlClavier.toucheRelacher[ControlTouche.ACTION_SORT1]) {
                    System.out.println("touche f1 relacher");
                    ControlClavier.toucheRelacher[ControlTouche.ACTION_SORT1] = false;
                }


                if (ControlClavier.toucheRelacher[ControlTouche.ACTION_SORT2]) {

                    ControlClavier.toucheRelacher[ControlTouche.ACTION_SORT2] = false;
                }

                if (ControlClavier.toucheRelacher[ControlTouche.ACTION_SORT3]) {

                    ControlClavier.toucheRelacher[ControlTouche.ACTION_SORT3] = false;
                }

                if (ControlClavier.toucheRelacher[ControlTouche.ACTION_SORT4]) {

                    ControlClavier.toucheRelacher[ControlTouche.ACTION_SORT4] = false;
                }

                if (ControlClavier.toucheRelacher[ControlTouche.ACTION_SORT5]) {

                    ControlClavier.toucheRelacher[ControlTouche.ACTION_SORT5] = false;
                }

                if (ControlClavier.toucheRelacher[ControlTouche.ACTION_SORT6]) {

                    ControlClavier.toucheRelacher[ControlTouche.ACTION_SORT6] = false;
                }

                if (ControlClavier.toucheRelacher[ControlTouche.ACTION_SORT7]) {

                    ControlClavier.toucheRelacher[ControlTouche.ACTION_SORT7] = false;
                }

                if (ControlClavier.toucheRelacher[ControlTouche.ACTION_SORT8]) {

                    ControlClavier.toucheRelacher[ControlTouche.ACTION_SORT8] = false;
                }


                // dessine le héro et le fait se déplacer
                fenetre.panelFenetreJeu.hero.selectionnerMorceauSpriteDeplacement();
                jeu.getHero().deplacer();

                // dessine les monstres et les fait intéragir
                for (int i = 0; i < fenetre.panelFenetreJeu.monstre.size(); i++) {
                    jeu.getMonstre(i).update(jeu.getHero());
                    fenetre.panelFenetreJeu.monstre.get(i).selectionnerMorceauSpriteDeplacement();
                    if (!jeu.getMonstre(i).estVivant())
                        jeu.addIndiceSuppressionMonstre(i);

                    jeu.getMonstre(i).upgrade();
                }

                // dessine les sorts des monstres et les fait intéragir
                for (int i = 0; i < fenetre.panelFenetreJeu.sortMonstre.size(); i++) {
                    fenetre.panelFenetreJeu.sortMonstre.get(i).selectionnerMorceauSpriteDeplacement();
                    jeu.getSortMonstre(i).deplacer();
                }

                jeu.updateEntite();
                fenetre.panelFenetreJeu.updateEntite();
            }
        }
        fenetre.repaint();
    }
}