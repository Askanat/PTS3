package vue;

import controleur.*;
import model.Jeu;

import javax.swing.*;
import java.awt.*;

import static javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER;
import static javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER;

/**
 * Created by bastien on 28/09/16.
 */

public class Fenetre extends JFrame {

    public static int numeroPorte; // permet de selectionner la porte avec les flammes

    private Jeu jeu;
    public MenuPrincipal panelMenuPrincipal;
    public FenetreCharger panelFenetreCharger;
    public FenetreOptions panelFenetreOptions;
    public FenetreCredits panelFenetreCredits;
    public FenetreDonjon panelFenetreDonjon;
    public FenetreNouvellePartie panelFenetreNouvellePartie;
    public FenetreInventaire panelFenetreInventaire;
    public MenuEnJeu panelMenuEnJeu;
    public FenetreCreationPersonnage panelFenetreCreationPersonnage;
    public FenetreFichePerso panelFenetreFichePerso;
    public FenetreDepart panelFenetreDepart;

    public static JScrollPane scrollPane;
    public JPanel panelScrollFenetreDepart;
    public JLayeredPane layeredPane;

    private static Dimension tailleEcran = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
    public static final double DEFAUT_X = 1920;
    public static final double DEFAUT_Y = 1080;
    public static final int X = 960;//(int) tailleEcran.getWidth();
    public static final int Y = 540;//(int) tailleEcran.getHeight();

    public Fenetre(Jeu jeu) {

        this.jeu = jeu;

        init();
        //setUndecorated(true);
        setContentPane(panelMenuPrincipal);
        pack();
        setTitle("Jeu");
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);

        numeroPorte = -1;
    }

    public void init() {
        panelFenetreCharger = new FenetreCharger(jeu);
        panelFenetreCredits = new FenetreCredits();
        panelFenetreDonjon = new FenetreDonjon(jeu);
        panelFenetreNouvellePartie = new FenetreNouvellePartie(jeu);
        panelMenuPrincipal = new MenuPrincipal();
        panelFenetreInventaire = new FenetreInventaire();
        panelMenuEnJeu = new MenuEnJeu(jeu);
        panelFenetreCreationPersonnage = new FenetreCreationPersonnage(jeu);
        panelFenetreFichePerso = new FenetreFichePerso(jeu);

        panelFenetreDepart = new FenetreDepart(jeu);
        vueJeu();
    }

    public void vueMenuEnJeu() {
        layeredPane = getLayeredPane();
        JPanel top = panelMenuEnJeu;
        top.setBounds((int) (X / 4.0), (int) (Y / 4.0), (int) (X / 2.0), (int) (Y / 2.0));
        layeredPane.add(top, new Integer(1));
    }

    public void vueJeu() {
        scrollPane = new JScrollPane(panelFenetreDepart);
        scrollPane.setHorizontalScrollBarPolicy(HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setVerticalScrollBarPolicy(VERTICAL_SCROLLBAR_NEVER);
        scrollPane.setBounds(0, 0, X, Y);
        panelScrollFenetreDepart = new JPanel(null);
        panelScrollFenetreDepart.setPreferredSize(new Dimension(X, Y));
        panelScrollFenetreDepart.add(scrollPane);
    }

    public void initFenetreOptions(ControlTouche controlTouche) {
        panelFenetreOptions = new FenetreOptions(jeu, controlTouche);
    }

    public static int adapterResolutionEnX(int valeur) {
        return (int) (valeur / DEFAUT_X * X);
    }

    public static int adapterResolutionEnY(int valeur) {
        return (int) (valeur / DEFAUT_Y * Y);
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

    public void setControlFenetreInventaire(ControlFenetreInventaire controlFenetreInventaire) {
        panelFenetreInventaire.setControl(controlFenetreInventaire);
    }

    public void setControlFenetreCreationPersonnage(ControlFenetreCreationPersonnage controlFenetreCreationPersonnage) {
        panelFenetreCreationPersonnage.setControl(controlFenetreCreationPersonnage);
    }

    public void setControlFenetreFichePerso(ControlFenetreFichePerso controlFenetreFichePerso) {
        panelFenetreFichePerso.setControl(controlFenetreFichePerso);
    }

    public void setControlMenuEnJeu(ControlMenuEnJeu controlMenuEnJeu) {
        panelMenuEnJeu.setControl(controlMenuEnJeu);
    }

    public void setControlClavier(ControlClavier controlClavier) {
        addKeyListener(controlClavier);
    }
}