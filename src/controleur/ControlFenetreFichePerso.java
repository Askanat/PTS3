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
        switch (e.getActionCommand()) {
            case "PlusForce":
                jeu.getHero().setForce(jeu.getHero().getForce() + 1);
                jeu.getHero().setPointCaracteristique(jeu.getHero().getPointCaracteristique()-1);
                fenetre.panelFenetreFichePerso.init();
                break;

            case "MoinsForce":
                jeu.getHero().setForce(jeu.getHero().getForce()-1);
                jeu.getHero().setPointCaracteristique(jeu.getHero().getPointCaracteristique()+1);
                fenetre.panelFenetreFichePerso.init();
                break;

            case "PlusInt":
                jeu.getHero().setIntelligence(jeu.getHero().getIntelligence()+1);
                jeu.getHero().setPointCaracteristique(jeu.getHero().getPointCaracteristique()-1);
                fenetre.panelFenetreFichePerso.init();
                break;

            case "MoinsInt":
                jeu.getHero().setIntelligence(jeu.getHero().getIntelligence()-1);
                jeu.getHero().setPointCaracteristique(jeu.getHero().getPointCaracteristique()+1);
                fenetre.panelFenetreFichePerso.init();
                break;

            case "PlusResist":
                jeu.getHero().setResistance(jeu.getHero().getResistance()+1);
                jeu.getHero().setPointCaracteristique(jeu.getHero().getPointCaracteristique()-1);
                fenetre.panelFenetreFichePerso.init();
                break;

            case "MoinsResist":
                jeu.getHero().setResistance(jeu.getHero().getResistance()-1);
                jeu.getHero().setPointCaracteristique(jeu.getHero().getPointCaracteristique()+1);
                fenetre.panelFenetreFichePerso.init();
                break;

            case "PlusConst":
                jeu.getHero().setConstitution(jeu.getHero().getConstitution()+1);
                jeu.getHero().setPointCaracteristique(jeu.getHero().getPointCaracteristique()-1);
                fenetre.panelFenetreFichePerso.init();
                break;

            case "MoinsConst":
                jeu.getHero().setConstitution(jeu.getHero().getConstitution()-1);
                jeu.getHero().setPointCaracteristique(jeu.getHero().getPointCaracteristique()+1);
                fenetre.panelFenetreFichePerso.init();
                break;

            case "Retour":
                    //Permet de réafficher le menu en jeu et superposer les vues
                    fenetre.setContentPane(fenetre.panelFenetreDepart);
                    Control.enPartie = true;
                    changerVue();
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
                break;
        }
    }
}
