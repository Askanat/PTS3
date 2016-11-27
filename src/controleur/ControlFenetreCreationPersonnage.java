package controleur;

import model.Jeu;
import vue.Fenetre;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
                jeu.createHeroBDD(nomPerso, idHero);
                jeu.setHero(idHero);
                fenetre.panelFenetreDepart.dessineHero(idHero);

                spawnHero(idHero);
                fenetre.barreMenu.test(); // ajout du composant vie dans la bare menu
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
