package controleur;

import model.Jeu;
import vue.Fenetre;

import java.io.IOException;

/**
 * Created by bastien on 28/09/16.
 */

public class ControlGroup {

    public Fenetre fenetre;

    public ControlGroup(Jeu jeu) throws IOException {
        fenetre = new Fenetre(jeu);

        ControlMenuPrincipal controlMenuPrincipal = new ControlMenuPrincipal(jeu, fenetre);
        ControlFenetreNouvellePartie controlFenetreNouvellePartie = new ControlFenetreNouvellePartie(jeu, fenetre);
        ControlFenetreCreationPersonnage controlFenetreCreationPersonnage = new ControlFenetreCreationPersonnage(jeu, fenetre);
        ControlFenetreCharger controlFenetreCharger = new ControlFenetreCharger(jeu, fenetre);
        ControlFenetreCredits controlFenetreCredits = new ControlFenetreCredits(jeu, fenetre);
        ControlFenetreInventaire controlFenetreInventaire = new ControlFenetreInventaire(jeu, fenetre);
        ControlFenetreFichePerso controlFenetreFichePerso = new ControlFenetreFichePerso(jeu, fenetre);

        ControlFenetreDepart controlFenetreDepart = new ControlFenetreDepart(jeu, fenetre);
        ControlFenetreDonjon controlFenetreDonjon = new ControlFenetreDonjon(jeu, fenetre);

        ControlMenuEnJeu controlMenuEnJeu = new ControlMenuEnJeu(jeu, fenetre);

        ControlClavier controlClavier = new ControlClavier(jeu, fenetre);
        ControlTimer controlTimer = new ControlTimer(jeu, fenetre);

        fenetre.initFenetreOptions(controlClavier.getControlTouche());
        ControlFenetreOptions controlFenetreOptions = new ControlFenetreOptions(jeu, fenetre, controlClavier);
    }
}