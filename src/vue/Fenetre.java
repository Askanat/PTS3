package vue;

import controleur.*;
import model.Jeu;

import javax.swing.*;
import java.awt.*;

/**
 * Created by bastien on 28/09/16.
 */

public class Fenetre extends JFrame {

    private Jeu jeu;
    public MenuPrincipal panelMenuPrincipal;
    public FenetreCharger panelFenetreCharger;
    public FenetreOptions panelFenetreOptions;
    public FenetreCredits panelFenetreCredits;
    public FenetreDepart panelFenetreDepart;
    public FenetreDonjon panelFenetreDonjon;
    public FenetreNouvellePartie panelFenetreNouvellePartie;
    public MenuEnJeu panelMenuEnJeu;
    public BarreMenu barreMenu;
    public FenetreCreationPersonnage panelFenetreCreationPersonnage;

    public Fenetre(Jeu jeu) {

        this.jeu = jeu;

        init();
        barreMenu.setVisible(false);
        setJMenuBar(barreMenu);
        setUndecorated(true);
        setContentPane(panelMenuPrincipal);
        pack();
        setTitle("Jeu");
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void init() {
        panelFenetreCharger = new FenetreCharger(jeu);
        panelFenetreOptions = new FenetreOptions();
        panelFenetreCredits = new FenetreCredits();
        panelFenetreDepart = new FenetreDepart(jeu);
        panelFenetreDonjon = new FenetreDonjon(jeu);
        panelFenetreNouvellePartie = new FenetreNouvellePartie(jeu);
        panelMenuPrincipal = new MenuPrincipal();
        barreMenu = new BarreMenu(jeu);
        panelMenuEnJeu = new MenuEnJeu(jeu);
        panelFenetreCreationPersonnage = new FenetreCreationPersonnage(jeu);
    }

    public void setPaneSelectionnePersonnage() {
        JOptionPane.showMessageDialog(this, "Selectionnez un personnage avant de cliquer sur jouer !", "message", JOptionPane.INFORMATION_MESSAGE);
    }

    public void setPaneSelectionnePersonnageASupprimer() {
        JOptionPane.showMessageDialog(this, "Selectionnez une partie à supprimer avant de cliquer sur continuer !", "message", JOptionPane.INFORMATION_MESSAGE);
    }

    public void setControlMenuPrincipal(ControlMenuPrincipal controlMenuPrincipal) {
        panelMenuPrincipal.setControl(controlMenuPrincipal);
    }

    public void setControlFenetreNouvellePartie(ControlFenetreNouvellePartie controlFenetreNouvellePartie) {
        panelFenetreNouvellePartie.setControl(controlFenetreNouvellePartie);
    }

    public void setControlFenetreCharger(ControlFenetreCharger controlFenetreCharger) {
        panelFenetreCharger.setControl(controlFenetreCharger);
    }

    public void setControlFenetreOptions(ControlFenetreOptions controlFenetreOptions) {
        panelFenetreOptions.setControl(controlFenetreOptions);
    }

    public void setControlFenetreCredits(ControlFenetreCredits controlFenetreCredits) {
        panelFenetreCredits.setControl(controlFenetreCredits);
    }


    public void setControlFenetreDepart(ControlFenetreDepart controlFenetreDepart) {
        panelFenetreDepart.setControl(controlFenetreDepart);
    }

    public void setControlFenetreDonjon(ControlFenetreDonjon controlFenetreDonjon) {
        panelFenetreDonjon.setControl(controlFenetreDonjon);
    }


    public void setControlMenuEnJeu(ControlMenuEnJeu controlMenuEnJeu) {
        panelMenuEnJeu.setControl(controlMenuEnJeu);
    }

    public void setControlBarreMenu(ControlBarreMenu controlBarreMenu) {
        barreMenu.setControl(controlBarreMenu);
    }


    public void setControlClavier(ControlClavier controlClavier) {
        addKeyListener(controlClavier);
    }

    public void setControlFenetreCreationPersonnage(ControlFenetreCreationPersonnage controlFenetreCreationPersonnage) {
        panelFenetreCreationPersonnage.setControl(controlFenetreCreationPersonnage);
    }

}