package controleur;

import model.Direction;
import model.Jeu;
import model.Niveau;
import vue.Fenetre;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static vue.FenetreJeu.*;

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
                    //jeu.setMonstre(1, 900, 100); // a enlever d'ici
                    //jeu.setMonstre(2, 1400, 100); // a enlever d'ici
                    //jeu.setMonstre(3, 1900, 100); // a enlever d'ici
                    //jeu.setMonstre(4, 2400, 100); // a enlever d'ici
                    jeu.sauvegardeHero();
                    jeu.getEtat().setSave(true);
                }
                if (jeu.getEtat().getTemps() % 310 == 0) {
                    jeu.getEtat().setSave(false);
                }

                if (ControlClavier.toucheEnfoncer[ControlTouche.ACTION_GAUCHE]) {
                    jeu.getHero().deplacerAGauche();
                }

                if (ControlClavier.toucheEnfoncer[ControlTouche.ACTION_DROITE]) {
                    jeu.getHero().deplacerADroite();
                }

                if (ControlClavier.toucheEnfoncer[ControlTouche.ACTION_SAUT]) {
                    jeu.getHero().sauter();
                }

                if (ControlClavier.toucheEnfoncer[ControlTouche.ACTION_DESCENDRE]) {
                    int x = jeu.getHero().getPositionX() / TAILLE_TUILE;
                    int y = (jeu.getHero().getPositionY() + jeu.getHero().getHauteurBas()) / TAILLE_TUILE;

                    if (!(63 <= tuileInt[y + 2][x] && tuileInt[y + 2][x] <= 79))
                        jeu.getHero().setDescendre(true);
                }

                if (ControlClavier.toucheRelacher[ControlTouche.ACTION_ATTAQUE]) {

                    int x = jeu.getHero().getPositionX() / TAILLE_TUILE;
                    int y = (jeu.getHero().getPositionY() + jeu.getHero().getHauteurBas()) / TAILLE_TUILE;
                    if (0 <= tuileInt[y - 3][x] && tuileInt[y - 3][x] <= 15 && !jeu.getEtat().getZoneSafe()) {
                        // monte de niveau ou dessend en fonction de si il utilise la porte en haut ou la porte en bas

                        Direction directionPorte = null;
                        if (jeu.getHero().getPositionY() < ZONE.height / 2.0) {
                            jeu.setNiveauDonjonActuelle(jeu.getNiveauDonjonActuelle() + 1);
                            if (jeu.getHero().getPositionX() < ZONE.width / 2.0)
                                directionPorte = new Direction(Direction.DROITE);
                            else
                                directionPorte = new Direction(Direction.GAUCHE);
                        } else {
                            jeu.setNiveauDonjonActuelle(jeu.getNiveauDonjonActuelle() - 1);
                            if (jeu.getNiveauDonjonActuelle() + 1 % 2 == 0) {
                                if (jeu.getHero().getPositionX() < ZONE.width / 2.0)
                                    directionPorte = new Direction(Direction.DROITE);
                                else
                                    directionPorte = new Direction(Direction.GAUCHE);
                            } else {
                                if (jeu.getHero().getPositionX() < ZONE.width / 2.0)
                                    directionPorte = new Direction(Direction.GAUCHE);
                                else
                                    directionPorte = new Direction(Direction.DROITE);
                            }
                        }


                        // change de map si il est dans le donjon ou si il sort du donjon (sort du donjon quand niveau 0)
                        if (jeu.getNiveauDonjonActuelle() > 0) {
                            int largeurMap = (int) (30 + (Math.random() * (150 - 30)));
                            int nbPlateforme = jeu.getNiveauDonjonActuelle() + 1;
                            Niveau niveau = new Niveau(largeurMap, nbPlateforme, directionPorte.getDirection(), true);
                            fenetre.panelFenetreJeu.changerMap("map/mapFenetreDonjon.txt");
                        } else {
                            jeu.getEtat().setZoneSafe(true);
                            fenetre.panelFenetreJeu.changerMap("map/mapFenetreDepart.txt");
                        }
                    } else if (!jeu.getHero().getAttaquer()) {
                        jeu.getHero().setAttaquer(true);

                        for (int i = 0; i < jeu.getTableauMonstre().size(); i++)
                            jeu.getHero().attaquer(jeu.getTableauMonstre().get(i));
                    }
                    ControlClavier.toucheRelacher[ControlTouche.ACTION_ATTAQUE] = false;
                }


                if (ControlClavier.toucheRelacher[ControlTouche.ACTION_SORT1]) {
                    if (jeu.getHero().getMana() >= jeu.getHero().getSort(0).getCoutManaSpell() && jeu.getHero().getTempsAvantDisponibiliteSort()[0] == 0) {
                        jeu.getTableauSortHero().add(jeu.getHero().appelleSort(jeu.getHero().getSort(0)));
                        jeu.getHero().getTempsAvantDisponibiliteSort()[0] = jeu.getHero().getSort(0).getTempsDeRechargement();
                    }
                    ControlClavier.toucheRelacher[ControlTouche.ACTION_SORT1] = false;
                }


                if (ControlClavier.toucheRelacher[ControlTouche.ACTION_SORT2]) {
                    if (jeu.getHero().getMana() >= jeu.getHero().getSort(1).getCoutManaSpell() && jeu.getHero().getTempsAvantDisponibiliteSort()[1] == 0) {
                        jeu.getTableauSortHero().add(jeu.getHero().appelleSort(jeu.getHero().getSort(1)));
                        jeu.getHero().getTempsAvantDisponibiliteSort()[1] = jeu.getHero().getSort(1).getTempsDeRechargement();
                    }
                    ControlClavier.toucheRelacher[ControlTouche.ACTION_SORT2] = false;
                }

                if (ControlClavier.toucheRelacher[ControlTouche.ACTION_SORT3]) {
                    if (jeu.getHero().getMana() >= jeu.getHero().getSort(2).getCoutManaSpell() && jeu.getHero().getTempsAvantDisponibiliteSort()[2] == 0) {
                        jeu.getTableauSortHero().add(jeu.getHero().appelleSort(jeu.getHero().getSort(2)));
                        jeu.getHero().getTempsAvantDisponibiliteSort()[2] = jeu.getHero().getSort(2).getTempsDeRechargement();
                    }
                    ControlClavier.toucheRelacher[ControlTouche.ACTION_SORT3] = false;
                }

                if (ControlClavier.toucheRelacher[ControlTouche.ACTION_SORT4]) {
                    if (jeu.getHero().getMana() >= jeu.getHero().getSort(3).getCoutManaSpell() && jeu.getHero().getTempsAvantDisponibiliteSort()[3] == 0) {
                        jeu.getTableauSortHero().add(jeu.getHero().appelleSort(jeu.getHero().getSort(3)));
                        jeu.getHero().getTempsAvantDisponibiliteSort()[3] = jeu.getHero().getSort(3).getTempsDeRechargement();
                    }
                    ControlClavier.toucheRelacher[ControlTouche.ACTION_SORT4] = false;
                }

                if (ControlClavier.toucheRelacher[ControlTouche.ACTION_SORT5]) {
                    if (jeu.getHero().getMana() >= jeu.getHero().getSort(4).getCoutManaSpell() && jeu.getHero().getTempsAvantDisponibiliteSort()[4] == 0) {
                        jeu.getTableauSortHero().add(jeu.getHero().appelleSort(jeu.getHero().getSort(4)));
                        jeu.getHero().getTempsAvantDisponibiliteSort()[4] = jeu.getHero().getSort(4).getTempsDeRechargement();
                    }
                    ControlClavier.toucheRelacher[ControlTouche.ACTION_SORT5] = false;
                }

                if (ControlClavier.toucheRelacher[ControlTouche.ACTION_SORT6]) {
                    if (jeu.getHero().getMana() >= jeu.getHero().getSort(5).getCoutManaSpell() && jeu.getHero().getTempsAvantDisponibiliteSort()[5] == 0) {
                        jeu.getTableauSortHero().add(jeu.getHero().appelleSort(jeu.getHero().getSort(5)));
                        jeu.getHero().getTempsAvantDisponibiliteSort()[5] = jeu.getHero().getSort(5).getTempsDeRechargement();
                    }
                    ControlClavier.toucheRelacher[ControlTouche.ACTION_SORT6] = false;
                }

                if (ControlClavier.toucheRelacher[ControlTouche.ACTION_SORT7]) {
                    if (jeu.getHero().getMana() >= jeu.getHero().getSort(6).getCoutManaSpell() && jeu.getHero().getTempsAvantDisponibiliteSort()[6] == 0) {
                        jeu.getTableauSortHero().add(jeu.getHero().appelleSort(jeu.getHero().getSort(6)));
                        jeu.getHero().getTempsAvantDisponibiliteSort()[6] = jeu.getHero().getSort(6).getTempsDeRechargement();
                    }
                    ControlClavier.toucheRelacher[ControlTouche.ACTION_SORT7] = false;
                }

                if (ControlClavier.toucheRelacher[ControlTouche.ACTION_SORT8]) {
                    if (jeu.getHero().getMana() >= jeu.getHero().getSort(7).getCoutManaSpell() && jeu.getHero().getTempsAvantDisponibiliteSort()[7] == 0) {
                        jeu.getTableauSortHero().add(jeu.getHero().appelleSort(jeu.getHero().getSort(7)));
                        jeu.getHero().getTempsAvantDisponibiliteSort()[7] = jeu.getHero().getSort(7).getTempsDeRechargement();
                    }
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
                    if (jeu.getTableauSortHero().get(i).update(jeu.getTableauMonstre(), jeu.getHero()))
                        jeu.getEtat().getIndiceSuppressionSortHero().add(i);
                }

                jeu.updateEntite();
                fenetre.panelFenetreJeu.updateEntite();
            }
        }

        fenetre.repaint();
    }
}
