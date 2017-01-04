package controleur;

import model.Jeu;
import vue.Fenetre;

import javax.swing.*;
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
                fenetre.getContentPane().setLayout(new GridBagLayout());
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

                        int nbMonstre = jeu.getSizeTabMonstre(), i;

                        for (i = 0; i < nbMonstre; i++) {
                            jeu.getHero().attaquer(jeu.getMonstre(i));
                        }

                        ControlClavier.toucheRelacher[ControlTouche.A] = false;
                    }
                }

                // dessine le héro et le fait se déplacer
                fenetre.panelFenetreDepart.hero.selectionnerMorceauSpriteDeplacement();
                jeu.getHero().deplacer();

                // dessine les monstres et les fait intéragir
                for (int i = 0; i < jeu.getSizeTabMonstre(); i++) {
                    jeu.getMonstre(i).update(jeu.getHero());
                    fenetre.panelFenetreDepart.monstre.get(i).selectionnerMorceauSpriteDeplacement();
                    if (!jeu.getMonstre(i).estVivant())
                        fenetre.panelFenetreDepart.monstre.remove(i);
                    jeu.getMonstre(i).upgrade();




                   // jeu.getMonstre(i).afficherEtat();



                    jeu.updateMonstre(i); // supprime les montres si ils sont morts
                }
            }
            //jeu.getHero().afficherEtat();
            // jeu.getHero().setVie(jeu.getHero().getVie() - 1); // enleve vie du hero
        }

        fenetre.repaint();
    }
}