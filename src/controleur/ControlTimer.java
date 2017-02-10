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
                    jeu.setMonstre(1, 900, 0); // a enlever d'ici
                    jeu.setMonstre(2, 1400, 0); // a enlever d'ici
                    jeu.setMonstre(3, 1900, 0); // a enlever d'ici
                    jeu.setMonstre(4, 2400, 0); // a enlever d'ici
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
                }

                if (ControlClavier.toucheEnfoncer[ControlTouche.ACTION_DROITE]) {
                    jeu.getHero().deplacerADroite();
                }

                if (ControlClavier.toucheRelacher[ControlTouche.ACTION_ATTAQUE]) {
                    if (!jeu.getHero().getAttaquer()) {
                        jeu.getHero().setAttaquer(true);

                        for (int i = 0; i < jeu.getSizeTabMonstre(); i++) {
                            jeu.getHero().attaquer(jeu.getMonstre(i));
                        }
                    }
                    ControlClavier.toucheRelacher[ControlTouche.ACTION_ATTAQUE] = false;
                }


                if (ControlClavier.toucheRelacher[ControlTouche.ACTION_SORT1]) {
                    jeu.setSortHero(jeu.getHero().appelleSort(jeu.getHero().getSort(0)));
                    ControlClavier.toucheRelacher[ControlTouche.ACTION_SORT1] = false;
                }


                if (ControlClavier.toucheRelacher[ControlTouche.ACTION_SORT2]) {
                    jeu.setSortHero(jeu.getHero().appelleSort(jeu.getHero().getSort(1)));
                    ControlClavier.toucheRelacher[ControlTouche.ACTION_SORT2] = false;
                }

                if (ControlClavier.toucheRelacher[ControlTouche.ACTION_SORT3]) {
                    jeu.setSortHero(jeu.getHero().appelleSort(jeu.getHero().getSort(2)));
                    ControlClavier.toucheRelacher[ControlTouche.ACTION_SORT3] = false;
                }

                if (ControlClavier.toucheRelacher[ControlTouche.ACTION_SORT4]) {
                    jeu.setSortHero(jeu.getHero().appelleSort(jeu.getHero().getSort(3)));
                    ControlClavier.toucheRelacher[ControlTouche.ACTION_SORT4] = false;
                }

                if (ControlClavier.toucheRelacher[ControlTouche.ACTION_SORT5]) {
                    jeu.setSortHero(jeu.getHero().appelleSort(jeu.getHero().getSort(4)));
                    ControlClavier.toucheRelacher[ControlTouche.ACTION_SORT5] = false;
                }

                if (ControlClavier.toucheRelacher[ControlTouche.ACTION_SORT6]) {
                    jeu.setSortHero(jeu.getHero().appelleSort(jeu.getHero().getSort(5)));
                    ControlClavier.toucheRelacher[ControlTouche.ACTION_SORT6] = false;
                }

                if (ControlClavier.toucheRelacher[ControlTouche.ACTION_SORT7]) {
                    jeu.setSortHero(jeu.getHero().appelleSort(jeu.getHero().getSort(6)));
                    ControlClavier.toucheRelacher[ControlTouche.ACTION_SORT7] = false;
                }

                if (ControlClavier.toucheRelacher[ControlTouche.ACTION_SORT8]) {
                    jeu.setSortHero(jeu.getHero().appelleSort(jeu.getHero().getSort(7)));
                    ControlClavier.toucheRelacher[ControlTouche.ACTION_SORT8] = false;
                }


                // dessine le héro et le fait se déplacer
                fenetre.panelFenetreJeu.hero.selectionnerMorceauSpriteDeplacement();
                jeu.getHero().update();

                // dessine les monstres et les fait intéragir
                for (int i = 0; i < fenetre.panelFenetreJeu.monstre.size(); i++) {
                    if (jeu.getMonstre(i).update(jeu.getHero()))
                        jeu.addIndiceSuppressionMonstre(i);
                    fenetre.panelFenetreJeu.monstre.get(i).selectionnerMorceauSpriteDeplacement();
                    jeu.getMonstre(i).upgrade();
                }

                // dessine les sorts des monstres et les fait intéragir
                for (int i = 0; i < fenetre.panelFenetreJeu.sortMonstre.size(); i++) {
                    fenetre.panelFenetreJeu.sortMonstre.get(i).selectionnerMorceauSpriteDeplacement();
                    if (jeu.getSortMonstre(i).update(jeu.getHero()))
                        jeu.addIndiceSuppressionSortMonstre(i);
                }

                // dessine les sorts du hero et les fait intéragir
                for (int i = 0; i < fenetre.panelFenetreJeu.sortHero.size(); i++) {
                    fenetre.panelFenetreJeu.sortHero.get(i).selectionnerMorceauSpriteDeplacement();
                    if (jeu.getSortHero(i).update(jeu.getAllMonstre()))
                        jeu.addIndiceSuppressionSortHero(i);
                }

                jeu.updateEntite();
                fenetre.panelFenetreJeu.updateEntite();
            }
        }
        fenetre.repaint();
    }
}