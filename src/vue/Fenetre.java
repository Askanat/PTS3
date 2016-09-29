package vue;

import controleur.*;
import model.Jeu;

import javax.swing.*;

/**
 * Created by bastien on 28/09/16.
 */

public class Fenetre extends JFrame {

    public Jeu jeu;
    public MenuPrincipal panelMenuPrincipal;
    public FenetreCharger panelFenetreCharger;
    public FenetreCredits panelFenetreCredits;
    public FenetreDepart panelFenetreDepart;
    public FenetreDonjon panelFenetreDonjon;
    public FenetreNouvellePartie panelFenetreNouvellePartie;

    public Fenetre(Jeu jeu) {

        this.jeu = jeu;

        init();
        //menu = new BarMenu(jeu);
        //menu.setVisible(false);
        //setJMenuBar(menu);
        setContentPane(panelMenuPrincipal);
        pack();
        setTitle("Jeu");
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //setLocationRelativeTo(null);
        setVisible(true);
    }

    public void init() {
        panelMenuPrincipal = new MenuPrincipal();
    }

    public void setControlFenetreCharger(ControlFenetreCharger controlCharger){
        panelFenetreCharger.setControl(controlCharger);
    }
    public void setControlFenetreCredits(ControlFenetreCredits controlCredits){
        panelFenetreCredits.setControl(controlCredits);
    }
    public void setControlFenetreDepart(ControlFenetreDepart controlDepart){
        panelFenetreDepart.setControl(controlDepart);
    }
    public void setControlFenetreDonjon(ControlFenetreDonjon controlDonjon){
        panelFenetreDonjon.setControl(controlDonjon);
    }
    public void setControlFenetreNouvellePartie(ControlFenetreNouvellePartie controlNouvellePartie){
        panelFenetreNouvellePartie.setControl(controlNouvellePartie);
    }
    public void setControlMenuPrincipal(ControlMenuPrincipal controlMenuPrincipal){
        panelMenuPrincipal.setControl(controlMenuPrincipal);
    }
}