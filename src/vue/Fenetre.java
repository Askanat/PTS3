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
    public FenetreCharger panelCharger;
    public FenetreCredits panelCredits;
    public FenetreDepart panelDepart;
    public FenetreDonjon panelDonjon;
    public FenetreNouvellePartie panelNouvellePartie;

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

    public void setControlCharger(ControlFenetreCharger controlCharger){
        panelCharger.setControl(controlCharger);
    }
    public void setControlCredits(ControlFenetreCredits controlCredits){
        panelCredits.setControl(controlCredits);
    }
    public void setControlDepart(ControlFenetreDepart controlDepart){
        panelDepart.setControl(controlDepart);
    }
    public void setControlDonjon(ControlFenetreDonjon controlDonjon){
        panelDonjon.setControl(controlDonjon);
    }
    public void setControlNouvellePartie(ControlFenetreNouvellePartie controlNouvellePartie){
        panelNouvellePartie.setControl(controlNouvellePartie);
    }
    public void setControlMenuPrincipal(ControlMenuPrincipal controlMenuPrincipal){
        panelMenuPrincipal.setControl(controlMenuPrincipal);
    }
}