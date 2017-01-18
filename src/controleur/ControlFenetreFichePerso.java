package controleur;

import model.Jeu;
import vue.Fenetre;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by MSI-FlorianV on 05/01/2017.
 */
public class ControlFenetreFichePerso extends Control implements ActionListener {

    public ControlFenetreFichePerso(Jeu jeu, Fenetre fenetre) {
        super(jeu, fenetre);
        fenetre.setControlFenetreFichePerso(this);
    }

    public void actionPerformed(ActionEvent e) {

        int force = (int) jeu.getHero().getForce() - (int) (jeu.getHero().getForce() + 1);
        int intelligence = (int) jeu.getHero().getIntelligence() - (int) (jeu.getHero().getIntelligence() + 1);
        int resistance = (int) jeu.getHero().getResistance() - (int) (jeu.getHero().getResistance() + 1);
        int constitution = (int) jeu.getHero().getConstitution() - (int) (jeu.getHero().getConstitution() + 1);

        switch (e.getActionCommand()) {
            case "PlusForce":
                if (jeu.getHero().getPointCaracteristique() > 0) {
                    jeu.getHero().setForce(jeu.getHero().getForce() + 1);
                    jeu.getHero().setPointCaracteristique(jeu.getHero().getPointCaracteristique() - 1);
                    fenetre.panelFenetreFichePerso.init();
                }
                break;

            case "MoinsForce":
                if (jeu.getHero().getForce() - 1 > force + jeu.getHero().getLimiteForce()) {
                    jeu.getHero().setForce(jeu.getHero().getForce() - 1);
                    jeu.getHero().setPointCaracteristique(jeu.getHero().getPointCaracteristique() + 1);
                    fenetre.panelFenetreFichePerso.init();
                }
                break;

            case "PlusInt":
                if (jeu.getHero().getPointCaracteristique() > 0) {
                    jeu.getHero().setIntelligence(jeu.getHero().getIntelligence() + 1);
                    jeu.getHero().setPointCaracteristique(jeu.getHero().getPointCaracteristique() - 1);
                    fenetre.panelFenetreFichePerso.init();
                }
                break;

            case "MoinsInt":
                if (jeu.getHero().getIntelligence() - 1 > intelligence + jeu.getHero().getLimiteIntelligence()) {
                    jeu.getHero().setIntelligence(jeu.getHero().getIntelligence() - 1);
                    jeu.getHero().setPointCaracteristique(jeu.getHero().getPointCaracteristique() + 1);
                    fenetre.panelFenetreFichePerso.init();
                }
                break;

            case "PlusResist":
                if (jeu.getHero().getPointCaracteristique() > 0) {
                    jeu.getHero().setResistance(jeu.getHero().getResistance() + 1);
                    jeu.getHero().setPointCaracteristique(jeu.getHero().getPointCaracteristique() - 1);
                    fenetre.panelFenetreFichePerso.init();
                }
                break;

            case "MoinsResist":
                if (jeu.getHero().getResistance() - 1 > resistance + jeu.getHero().getLimiteResistance()) {
                    jeu.getHero().setResistance(jeu.getHero().getResistance() - 1);
                    jeu.getHero().setPointCaracteristique(jeu.getHero().getPointCaracteristique() + 1);
                    fenetre.panelFenetreFichePerso.init();
                }
                break;

            case "PlusConst":
                if (jeu.getHero().getPointCaracteristique() > 0) {
                    jeu.getHero().setConstitution(jeu.getHero().getConstitution() + 1);
                    jeu.getHero().setPointCaracteristique(jeu.getHero().getPointCaracteristique() - 1);
                    fenetre.panelFenetreFichePerso.init();
                }
                break;

            case "MoinsConst":
                if (jeu.getHero().getConstitution() - 1 > (constitution + jeu.getHero().getLimiteConstitution())) {
                    jeu.getHero().setConstitution(jeu.getHero().getConstitution() - 1);
                    jeu.getHero().setPointCaracteristique(jeu.getHero().getPointCaracteristique() + 1);
                    fenetre.panelFenetreFichePerso.init();
                }
                break;

            case "Valider":
                jeu.getHero().setLimiteForce(jeu.getHero().getForce());
                jeu.getHero().setLimiteIntelligence(jeu.getHero().getIntelligence());
                jeu.getHero().setLimiteResistance(jeu.getHero().getResistance());
                jeu.getHero().setLimiteConstitution(jeu.getHero().getConstitution());
                jeu.getHero().updateCaracteristique();
                jeu.sauvegardeHero();
                fenetre.panelFenetreFichePerso.init();
                break;

            case "Retour":
                Control.enPartie = true;
                fenetre.setContentPane(fenetre.panelMenuEnJeu);
                changerVue();
                break;
        }
    }
}
