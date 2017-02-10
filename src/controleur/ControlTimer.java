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
                jeu.getEtat().inversePause();

                if (jeu.getEtat().getPause()) {
                    fenetre.vueMenuEnJeu();

                } else {
                    fenetre.layeredPane.removeAll();
                    fenetre.setContentPane(fenetre.panelScrollFenetreJeu);
                    changerVue();
                }
                ControlClavier.toucheRelacher[ControlTouche.ACTION_MENU] = false;
            }

            if (!jeu.getEtat().getPause()) {
                jeu.getEtat().incrementeTemps();
                if (jeu.getEtat().getTemps() % 300 == 0) {
                    jeu.setMonstre(1, 900, 0); // a enlever d'ici
                    jeu.setMonstre(2, 1400, 0); // a enlever d'ici
                    jeu.setMonstre(3, 1900, 0); // a enlever d'ici
                    jeu.setMonstre(4, 2400, 0); // a enlever d'ici
                    jeu.sauvegardeHero();
                    jeu.getEtat().setSave(true);
                }
                if (jeu.getEtat().getTemps() % 310 == 0) {
                    jeu.getEtat().setSave(false);
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

                        for (int i = 0; i < jeu.getTableauMonstre().size(); i++) {
                            jeu.getHero().attaquer(jeu.getTableauMonstre().get(i));
                        }
                    }
                    ControlClavier.toucheRelacher[ControlTouche.ACTION_ATTAQUE] = false;
                }


                if (ControlClavier.toucheRelacher[ControlTouche.ACTION_SORT1]) {
                    jeu.getTableauSortHero().add(jeu.getHero().appelleSort(jeu.getHero().getSort(0)));
                    ControlClavier.toucheRelacher[ControlTouche.ACTION_SORT1] = false;
                }


                if (ControlClavier.toucheRelacher[ControlTouche.ACTION_SORT2]) {
                    jeu.getTableauSortHero().add(jeu.getHero().appelleSort(jeu.getHero().getSort(1)));
                    ControlClavier.toucheRelacher[ControlTouche.ACTION_SORT2] = false;
                }

                if (ControlClavier.toucheRelacher[ControlTouche.ACTION_SORT3]) {
                    jeu.getTableauSortHero().add(jeu.getHero().appelleSort(jeu.getHero().getSort(2)));
                    ControlClavier.toucheRelacher[ControlTouche.ACTION_SORT3] = false;
                }

                if (ControlClavier.toucheRelacher[ControlTouche.ACTION_SORT4]) {
                    jeu.getTableauSortHero().add(jeu.getHero().appelleSort(jeu.getHero().getSort(3)));
                    ControlClavier.toucheRelacher[ControlTouche.ACTION_SORT4] = false;
                }

                if (ControlClavier.toucheRelacher[ControlTouche.ACTION_SORT5]) {
                    jeu.getTableauSortHero().add(jeu.getHero().appelleSort(jeu.getHero().getSort(4)));
                    ControlClavier.toucheRelacher[ControlTouche.ACTION_SORT5] = false;
                }

                if (ControlClavier.toucheRelacher[ControlTouche.ACTION_SORT6]) {
                    jeu.getTableauSortHero().add(jeu.getHero().appelleSort(jeu.getHero().getSort(5)));
                    ControlClavier.toucheRelacher[ControlTouche.ACTION_SORT6] = false;
                }

                if (ControlClavier.toucheRelacher[ControlTouche.ACTION_SORT7]) {
                    jeu.getTableauSortHero().add(jeu.getHero().appelleSort(jeu.getHero().getSort(6)));
                    ControlClavier.toucheRelacher[ControlTouche.ACTION_SORT7] = false;
                }

                if (ControlClavier.toucheRelacher[ControlTouche.ACTION_SORT8]) {
                    jeu.getTableauSortHero().add(jeu.getHero().appelleSort(jeu.getHero().getSort(7)));
                    ControlClavier.toucheRelacher[ControlTouche.ACTION_SORT8] = false;
                }


                // dessine le héro et le fait se déplacer
                fenetre.panelFenetreJeu.hero.selectionnerMorceauSpriteDeplacement();
                jeu.getHero().update();

                // dessine les monstres et les fait intéragir
                for (int i = 0; i < fenetre.panelFenetreJeu.monstre.size(); i++) {
                    if (jeu.getTableauMonstre().get(i).update(jeu.getHero()))
                        jeu.getEtat().getIndiceSuppressionMonstre().add(i);
                    fenetre.panelFenetreJeu.monstre.get(i).selectionnerMorceauSpriteDeplacement();
                    jeu.getTableauMonstre().get(i).upgrade();
                }

                // dessine les sorts des monstres et les fait intéragir
                for (int i = 0; i < fenetre.panelFenetreJeu.sortMonstre.size(); i++) {
                    fenetre.panelFenetreJeu.sortMonstre.get(i).selectionnerMorceauSpriteDeplacement();
                    if (jeu.getTableauSortMonstre().get(i).update(jeu.getHero()))
                        jeu.getEtat().getIndiceSuppressionSortMonstre().add(i);
                }

                // dessine les sorts du hero et les fait intéragir
                for (int i = 0; i < fenetre.panelFenetreJeu.sortHero.size(); i++) {
                    fenetre.panelFenetreJeu.sortHero.get(i).selectionnerMorceauSpriteDeplacement();
                    if (jeu.getTableauSortHero().get(i).update(jeu.getTableauMonstre()))
                        jeu.getEtat().getIndiceSuppressionSortHero().add(i);
                }

                jeu.updateEntite();
                fenetre.panelFenetreJeu.updateEntite();
            }
        }
        fenetre.repaint();
    }
}