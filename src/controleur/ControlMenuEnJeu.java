package controleur;

import model.Direction;
import model.Equipement;
import model.Jeu;
import model.Niveau;
import vue.Fenetre;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * Created by bastien on 07/10/16.
 */

public class ControlMenuEnJeu extends Control implements ActionListener {

    protected ControlMenuEnJeu(Jeu jeu, Fenetre fenetre) {
        super(jeu, fenetre);
        fenetre.setControlMenuEnJeu(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        switch (e.getActionCommand()) {
            case "Retour":
                jeu.getEtat().setPause(false);
                fenetre.layeredPane.removeAll();
                fenetre.setContentPane(fenetre.panelScrollFenetreJeu);
                changerVue();
                break;
            case "Inventaire":
                Control.enPartie = false;
                fenetre.layeredPane.removeAll();
                fenetre.setContentPane(fenetre.panelFenetreInventaire);
                ArrayList<Equipement> inventaire = jeu.getHero().inventaire;
                for (int i = 0; i < inventaire.size(); i++) {
                    fenetre.panelFenetreInventaire.inventaire[i].setIcon(new ImageIcon(inventaire.get(i).getTexture()));
                }
                changerVue();
                break;
            case "Fiche Personnage":
                Control.enPartie = false;
                fenetre.layeredPane.removeAll();
                fenetre.panelFenetreFichePerso.init();
                fenetre.setContentPane(fenetre.panelFenetreFichePerso);
                changerVue();
                break;
            case "Option":
                Control.enPartie = false;
                fenetre.layeredPane.removeAll();
                fenetre.setContentPane(fenetre.panelFenetreOptions);
                changerVue();
                break;
            case "Retour au Menu Principal":
                jeu.getEtat().setTemps(0);
                fenetre.layeredPane.removeAll();

                jeu.sauvegardeHero();


                // supprime les monstres
                jeu.getEtat().getIndiceSuppressionMonstre().clear();
                fenetre.panelFenetreJeu.monstre.clear();
                jeu.getTableauMonstre().clear();

                // supprime le héro
                fenetre.panelFenetreJeu.hero = null;
                jeu.setHero(null);

                //supprime les sorts du héro
                jeu.getEtat().getIndiceSuppressionSortHero().clear();
                fenetre.panelFenetreJeu.sortHero.clear();
                jeu.getTableauSortHero().clear();

                // supprime les sorts des monstres
                jeu.getEtat().getIndiceSuppressionSortMonstre().clear();
                fenetre.panelFenetreJeu.sortMonstre.clear();
                jeu.getTableauSortMonstre().clear();

                Control.enPartie = false;
                jeu.getEtat().setPause(false);
                fenetre.panelFenetreJeu.changerMap("map/mapFenetreDepart.txt");
                Niveau niveau = new Niveau(50, 2, Direction.GAUCHE, true);
                jeu.getEtat().setZoneSafe(true);
                fenetre.setContentPane(fenetre.panelMenuPrincipal);
                changerVue();
                break;
            case "Retour Au Bureau":
                jeu.sauvegardeHero();
                System.exit(0);
                break;
        }
    }
}