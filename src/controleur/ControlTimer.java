package controleur;

import model.Jeu;
import vue.Fenetre;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static vue.Fenetre.scrollPane;
import static vue.FenetreJeu.ZONE;

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
                    spawnMonstre(1, 900, 0); // a enlever d'ici
                    spawnMonstre(2, 1400, 0); // a enlever d'ici
                    spawnMonstre(3, 1900, 0); // a enlever d'ici
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

                        int nbMonstre = jeu.getSizeTabMonstre(), i;

                        for (i = 0; i < nbMonstre; i++) {
                            jeu.getHero().attaquer(jeu.getMonstre(i));
                        }

                        ControlClavier.toucheRelacher[ControlTouche.ACTION_ATTAQUE] = false;
                    }
                }

                // dessine le héro et le fait se déplacer
                fenetre.panelFenetreJeu.hero.selectionnerMorceauSpriteDeplacement();
                jeu.getHero().deplacer();


                // dessine les monstres et les fait intéragir
                for (int i = 0; i < jeu.getSizeTabMonstre(); i++) {
                    jeu.getMonstre(i).update(jeu.getHero());
                    fenetre.panelFenetreJeu.monstre.get(i).selectionnerMorceauSpriteDeplacement();
                    if (!jeu.getMonstre(i).estVivant()) {
                        jeu.getHero().recevoirExperience(jeu.getMonstre(i));
                        fenetre.panelFenetreJeu.monstre.remove(i);
                    }
                    jeu.getMonstre(i).upgrade();

                    // jeu.getMonstre(i).afficherEtat();


                    jeu.updateMonstre(i); // supprime les montres si ils sont morts
                }


                //Sauvegarde quand gain Niveau
                int niveau = jeu.getHero().getNiveau();
                jeu.getHero().upNiveau();
                if (niveau < jeu.getHero().getNiveau()) {
                    jeu.sauvegardeHero();
                }

                // changement de zone : zone-safe <-> zone-donjon
                if (jeu.getHero().getPositionX() > ZONE.width) {
                    fenetre.panelFenetreJeu.changerMap("map/mapFenetreDonjon.txt");
                } else if (jeu.getHero().getPositionX() < 0) {
                    fenetre.panelFenetreJeu.changerMap("map/mapFenetreDepart.txt");
                }

            }
            //jeu.getHero().afficherEtat();
        }
        fenetre.repaint();
    }
}