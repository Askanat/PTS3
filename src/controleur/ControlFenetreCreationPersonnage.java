package controleur;

import model.Jeu;
import vue.Fenetre;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

import static vue.FenetreCreationPersonnage.*;

/**
 * Created by bastien on 21/11/16.
 */
public class ControlFenetreCreationPersonnage extends Control implements ActionListener {

    public ControlFenetreCreationPersonnage(Jeu jeu, Fenetre fenetre) {
        super(jeu, fenetre);
        fenetre.setControlFenetreCreationPersonnage(this);
    }

    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "Jouer":
                if (fenetre.panelFenetreCreationPersonnage.getTfNomHero().getText().isEmpty()) {
                    fenetre.panelFenetreCreationPersonnage.nomVide();
                } else {
                    String nomPerso = fenetre.panelFenetreCreationPersonnage.getTfNomHero().getText();
                    int idHero = 3 - jeu.getNbPartieLibre() + 1;
                    if (jeu.getNbPartieLibre() == 1)
                        idHero = jeu.getidPartieLibre();
                    fenetre.panelFenetreCreationPersonnage.sauvegardeSprite(idHero);
                    jeu.createHeroBDD(nomPerso, idHero);
                    spawnHero(idHero);
                    Control.enPartie = true;
                    fenetre.panelFenetreCreationPersonnage.initCreationPerso();
                    fenetre.setContentPane(fenetre.panelScrollFenetreDepart);
                    changerVue();
                }
                break;
            case "Retour":
                fenetre.setContentPane(fenetre.panelMenuPrincipal);
                fenetre.panelFenetreCreationPersonnage.initCreationPerso();
                changerVue();
                break;
            case "cheveuxGauche":
                fenetre.panelFenetreCreationPersonnage.choixCheveux--;
                if (fenetre.panelFenetreCreationPersonnage.choixCheveux < 0)
                    fenetre.panelFenetreCreationPersonnage.choixCheveux = NB_CHEVEUX - 1;
                break;
            case "cheveuxDroite":
                fenetre.panelFenetreCreationPersonnage.choixCheveux++;
                if (fenetre.panelFenetreCreationPersonnage.choixCheveux >= NB_CHEVEUX)
                    fenetre.panelFenetreCreationPersonnage.choixCheveux = 0;
                break;
            case "yeuxDroite":
                fenetre.panelFenetreCreationPersonnage.choixYeux++;
                if (fenetre.panelFenetreCreationPersonnage.choixYeux >= NB_YEUX)
                    fenetre.panelFenetreCreationPersonnage.choixYeux = 0;
                break;
            case "yeuxGauche":
                fenetre.panelFenetreCreationPersonnage.choixYeux--;
                if (fenetre.panelFenetreCreationPersonnage.choixYeux < 0)
                    fenetre.panelFenetreCreationPersonnage.choixYeux = NB_YEUX - 1;
                break;
            case "sexeFemme":
                fenetre.panelFenetreCreationPersonnage.choixSexe = 1;
                break;
            case "sexeHomme":
                fenetre.panelFenetreCreationPersonnage.choixSexe = 0;
                break;
            case "peauGauche":
                fenetre.panelFenetreCreationPersonnage.choixPeau--;
                if (fenetre.panelFenetreCreationPersonnage.choixPeau < 0)
                    fenetre.panelFenetreCreationPersonnage.choixPeau = NB_PEAUX - 1;
                break;
            case "peauDroite":
                fenetre.panelFenetreCreationPersonnage.choixPeau++;
                if (fenetre.panelFenetreCreationPersonnage.choixPeau >= NB_PEAUX)
                    fenetre.panelFenetreCreationPersonnage.choixPeau = 0;
                break;
            case "pilositeGauche":
                fenetre.panelFenetreCreationPersonnage.choixPilosite--;
                if (fenetre.panelFenetreCreationPersonnage.choixPilosite < 0)
                    fenetre.panelFenetreCreationPersonnage.choixPilosite = NB_PILOSITE - 1;
                break;
            case "pilositeDroite":
                fenetre.panelFenetreCreationPersonnage.choixPilosite++;
                if (fenetre.panelFenetreCreationPersonnage.choixPilosite >= NB_PILOSITE)
                    fenetre.panelFenetreCreationPersonnage.choixPilosite = 0;
                break;
        }
        for (int i = 0; i < NB_COULEUR; i++) {
            if (Objects.equals(e.getActionCommand(), "cheveuxCouleur" + i))
                fenetre.panelFenetreCreationPersonnage.choixCouleurCheveux = i;
            if (Objects.equals(e.getActionCommand(), "yeuxCouleur" + i))
                fenetre.panelFenetreCreationPersonnage.choixCouleurYeux = i;
            if (Objects.equals(e.getActionCommand(), "pilositeCouleur" + i))
                fenetre.panelFenetreCreationPersonnage.choixCouleurPilosite = i;
        }
    }
}
