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
                if(fenetre.panelFenetreCreationPersonnage.getTfNomHero().getText().isEmpty()) {
                    fenetre.panelFenetreCreationPersonnage.nomVide();
                } else {
                    String nomPerso = fenetre.panelFenetreCreationPersonnage.getTfNomHero().getText();
                    int idHero = jeu.getidPartieLibre();
                    fenetre.panelFenetreCreationPersonnage.sauvegardeSprite(idHero);
                    jeu.createHeroBDD(nomPerso, idHero);
                    jeu.setHero(idHero);
                    fenetre.panelFenetreDepart.dessineHero(idHero);

                    spawnHero(idHero);
                    fenetre.barreMenu.test(); // ajout du composant vie dans la barre menu
                    spawnMonstre(1, Fenetre.adapterResolutionEnX(300), Fenetre.adapterResolutionEnY(250)); // a enlever d'ici
                    spawnMonstre(2, Fenetre.adapterResolutionEnX(600), Fenetre.adapterResolutionEnY(700)); // a enlever d'ici
                    spawnMonstre(3, Fenetre.adapterResolutionEnX(900), Fenetre.adapterResolutionEnY(900)); // a enlever d'ici

                    Control.enPartie = true;
                    fenetre.barreMenu.setVisible(true);
                    fenetre.setContentPane(fenetre.panelFenetreDepart);
                    changerVue();
                    Control.enPartie = true;
                    fenetre.barreMenu.setVisible(true);
                    fenetre.setContentPane(fenetre.panelFenetreDepart);
                    changerVue();
                }
                break;
            case "Retour":
                fenetre.setContentPane(fenetre.panelMenuPrincipal);
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

    private void spawnHero(int i) {
        jeu.setHero(i);
        fenetre.panelFenetreDepart.dessineHero(i);
    }

    private void spawnMonstre(int i, int positionX, int positionY) { // a enlever d'ici
        jeu.setMonstre(i, positionX, positionY);
        fenetre.panelFenetreDepart.dessineMonstre(i);
    }
}
