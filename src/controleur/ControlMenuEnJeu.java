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
                jeu.setPause(false);
                break;
            case "Inventaire":
                Control.enPartie = false;
                fenetre.setContentPane(fenetre.panelFenetreInventaire);
                changerVue();
                break;
            case "Fiche Personnage":
                Control.enPartie = false;
                fenetre.setContentPane(fenetre.panelFenetreFichePerso);
                fenetre.panelFenetreFichePerso.valForce.setText("" + jeu.getHero().getForce());
                fenetre.panelFenetreFichePerso.valInt.setText("" + jeu.getHero().getIntelligence());
                fenetre.panelFenetreFichePerso.valConst.setText("" + jeu.getHero().getConstitution());
                fenetre.panelFenetreFichePerso.valResist.setText("" + jeu.getHero().getResistance());
                fenetre.panelFenetreFichePerso.pointCaracteristique.setText("" + jeu.getHero().getPointCaracteristique());
                fenetre.panelFenetreFichePerso.pointCompetence.setText("" + jeu.getHero().getPointCompetence());
                fenetre.panelFenetreFichePerso.niveau.setText("" + jeu.getHero().getNiveau());
                fenetre.panelFenetreFichePerso.nomHero.setText("" + jeu.getHero().getNom());
                changerVue();
                break;
            case "Option":
                Control.enPartie = false;
                fenetre.setContentPane(fenetre.panelFenetreOptions);
                changerVue();
                break;
            case "Retour au Menu Principal":
                Control.enPartie = false;
                jeu.setPause(false);
                fenetre.barreMenu.setVisible(false);
                fenetre.setContentPane(fenetre.panelMenuPrincipal);
                changerVue();
                // quitte le perso : sauvegarde du perso + mise du perso à null
                break;
            case "Retour Au Bureau":
                // sauvegarde du perso
                System.exit(0);
                break;
        }
    }
}