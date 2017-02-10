package controleur;

import model.Jeu;
import vue.Fenetre;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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

                // supprime les monstre
                fenetre.panelFenetreJeu.monstre.clear();
                jeu.getTableauMonstre().clear();

                // supprime le héro
                fenetre.panelFenetreJeu.hero = null;
                jeu.setHero(null);

                //supprime les sorts du héro
                fenetre.panelFenetreJeu.sortHero.clear();
                jeu.getTableauSortHero().clear();

                // supprime les sorts des mosntres
                fenetre.panelFenetreJeu.sortMonstre.clear();
                jeu.getTableauSortMonstre().clear();

                Control.enPartie = false;
                jeu.getEtat().setPause(false);
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