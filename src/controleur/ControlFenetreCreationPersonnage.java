package controleur;

import model.Jeu;
import vue.Fenetre;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
            case "cheveuxCouleur0":
                fenetre.panelFenetreCreationPersonnage.choixCouleurCheveux = 3;
                break;
            case "cheveuxCouleur1":
                fenetre.panelFenetreCreationPersonnage.choixCouleurCheveux = 1;
                break;
            case "cheveuxCouleur2":
                fenetre.panelFenetreCreationPersonnage.choixCouleurCheveux = 0;
                break;
            case "cheveuxCouleur3":
                fenetre.panelFenetreCreationPersonnage.choixCouleurCheveux = 5;
                break;
            case "cheveuxCouleur4":
                fenetre.panelFenetreCreationPersonnage.choixCouleurCheveux = 4;
                break;
            case "cheveuxCouleur5":
                fenetre.panelFenetreCreationPersonnage.choixCouleurCheveux = 6;
                break;
            case "cheveuxCouleur6":
                fenetre.panelFenetreCreationPersonnage.choixCouleurCheveux = 7;
                break;
            case "cheveuxCouleur7":
                fenetre.panelFenetreCreationPersonnage.choixCouleurCheveux = 2;
                break;
            case "yeuxCouleur0":
                fenetre.panelFenetreCreationPersonnage.choixCouleurYeux = 3;
                break;
            case "yeuxCouleur1":
                fenetre.panelFenetreCreationPersonnage.choixCouleurYeux = 1;
                break;
            case "yeuxCouleur2":
                fenetre.panelFenetreCreationPersonnage.choixCouleurYeux = 0;
                break;
            case "yeuxCouleur3":
                fenetre.panelFenetreCreationPersonnage.choixCouleurYeux = 5;
                break;
            case "yeuxCouleur4":
                fenetre.panelFenetreCreationPersonnage.choixCouleurYeux = 4;
                break;
            case "yeuxCouleur5":
                fenetre.panelFenetreCreationPersonnage.choixCouleurYeux = 6;
                break;
            case "yeuxCouleur6":
                fenetre.panelFenetreCreationPersonnage.choixCouleurYeux = 7;
                break;
            case "yeuxCouleur7":
                fenetre.panelFenetreCreationPersonnage.choixCouleurYeux = 2;
                break;
            case "pilositeCouleur0":
                fenetre.panelFenetreCreationPersonnage.choixCouleurPilosite = 3;
                break;
            case "pilositeCouleur1":
                fenetre.panelFenetreCreationPersonnage.choixCouleurPilosite = 1;
                break;
            case "pilositeCouleur2":
                fenetre.panelFenetreCreationPersonnage.choixCouleurPilosite = 0;
                break;
            case "pilositeCouleur3":
                fenetre.panelFenetreCreationPersonnage.choixCouleurPilosite = 5;
                break;
            case "pilositeCouleur4":
                fenetre.panelFenetreCreationPersonnage.choixCouleurPilosite = 4;
                break;
            case "pilositeCouleur5":
                fenetre.panelFenetreCreationPersonnage.choixCouleurPilosite = 6;
                break;
            case "pilositeCouleur6":
                fenetre.panelFenetreCreationPersonnage.choixCouleurPilosite = 7;
                break;
            case "pilositeCouleur7":
                fenetre.panelFenetreCreationPersonnage.choixCouleurPilosite = 2;
                break;
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
