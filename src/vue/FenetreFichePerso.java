package vue;

import controleur.ControlFenetreFichePerso;
import model.Jeu;

import javax.swing.*;
import java.awt.*;

import static vue.Fenetre.X;
import static vue.Fenetre.Y;

/**
 * Created by MSI-FlorianV on 05/01/2017.
 */
public class FenetreFichePerso extends JPanel {

    private Jeu jeu;

    public JButton retour, plusForce, moinsForce, plusInt, moinsInt, plusConst, moinsConst, plusResist, moinsResist, valider;
    public JLabel valForce, valInt, valConst, valResist, niveau, pointCaracteristique, pointCompetence, nomHero;

    public FenetreFichePerso(Jeu jeu) {
        this.jeu = jeu;

        this.setLayout(null);
        setPreferredSize(new Dimension(X, Y));

        //JButton
        retour = new JButton();
        retour.setActionCommand("Retour");

        plusForce = new JButton();
        plusForce.setActionCommand("PlusForce");
        moinsForce = new JButton();
        moinsForce.setActionCommand("MoinsForce");

        plusInt = new JButton();
        plusInt.setActionCommand("PlusInt");
        moinsInt = new JButton();
        moinsInt.setActionCommand("MoinsInt");

        plusConst = new JButton();
        plusConst.setActionCommand("PlusConst");
        moinsConst = new JButton();
        moinsConst.setActionCommand("MoinsConst");

        plusResist = new JButton();
        plusResist.setActionCommand("PlusResist");
        moinsResist = new JButton();
        moinsResist.setActionCommand("MoinsResist");

        valider = new JButton();
        valider.setActionCommand("Valider les Modifications");

        //JLabel
        valForce = new JLabel("");
        valInt = new JLabel("");
        valConst = new JLabel("");
        valResist = new JLabel("");
        niveau = new JLabel("");
        pointCaracteristique = new JLabel("");
        pointCompetence = new JLabel("");
        nomHero = new JLabel("");

        //Ajout JButton
        add(retour);
        add(plusForce);
        add(moinsForce);
        add(plusInt);
        add(moinsInt);
        add(plusConst);
        add(moinsConst);
        add(plusResist);
        add(moinsResist);

        //Ajout JLabel
        add(valForce);
        add(valInt);
        add(valConst);
        add(valResist);
        add(niveau);
        add(pointCaracteristique);
        add(pointCompetence);
        add(nomHero);
    }

    public void setControl(ControlFenetreFichePerso controlFenetreFichePerso) {
        retour.addActionListener(controlFenetreFichePerso);

        plusForce.addActionListener(controlFenetreFichePerso);
        moinsForce.addActionListener(controlFenetreFichePerso);

        plusInt.addActionListener(controlFenetreFichePerso);
        moinsInt.addActionListener(controlFenetreFichePerso);

        plusConst.addActionListener(controlFenetreFichePerso);
        moinsConst.addActionListener(controlFenetreFichePerso);

        plusResist.addActionListener(controlFenetreFichePerso);
        moinsResist.addActionListener(controlFenetreFichePerso);
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        retour.setBounds(Fenetre.adapterResolutionEnX(40), Fenetre.adapterResolutionEnY(980), Fenetre.adapterResolutionEnX(228), Fenetre.adapterResolutionEnX(40));
        retour.setBackground(new Color(0, 0, 0, 0));
        retour.setFocusable(false);
        retour.setBorder(null);

        plusForce.setBounds(Fenetre.adapterResolutionEnX(1388), Fenetre.adapterResolutionEnY(265), Fenetre.adapterResolutionEnX(38), Fenetre.adapterResolutionEnX(38));
        plusForce.setBackground(new Color(0, 0, 0, 0));
        plusForce.setFocusable(false);
        plusForce.setBorder(null);

        moinsForce.setBounds(Fenetre.adapterResolutionEnX(1337), Fenetre.adapterResolutionEnY(265), Fenetre.adapterResolutionEnX(38), Fenetre.adapterResolutionEnX(38));
        moinsForce.setBackground(new Color(0, 0, 0, 0));
        moinsForce.setFocusable(false);
        moinsForce.setBorder(null);

        plusResist.setBounds(Fenetre.adapterResolutionEnX(1388), Fenetre.adapterResolutionEnY(367), Fenetre.adapterResolutionEnX(38), Fenetre.adapterResolutionEnX(38));
        plusResist.setBackground(new Color(0, 0, 0, 0));
        plusResist.setFocusable(false);
        plusResist.setBorder(null);

        moinsResist.setBounds(Fenetre.adapterResolutionEnX(1337), Fenetre.adapterResolutionEnY(367), Fenetre.adapterResolutionEnX(38), Fenetre.adapterResolutionEnX(38));
        moinsResist.setBackground(new Color(0, 0, 0, 0));
        moinsResist.setFocusable(false);
        moinsResist.setBorder(null);

        plusInt.setBounds(Fenetre.adapterResolutionEnX(1388), Fenetre.adapterResolutionEnY(470), Fenetre.adapterResolutionEnX(38), Fenetre.adapterResolutionEnX(38));
        plusInt.setBackground(new Color(0, 0, 0, 0));
        plusInt.setFocusable(false);
        plusInt.setBorder(null);

        moinsInt.setBounds(Fenetre.adapterResolutionEnX(1337), Fenetre.adapterResolutionEnY(470), Fenetre.adapterResolutionEnX(38), Fenetre.adapterResolutionEnX(38));
        moinsInt.setBackground(new Color(0, 0, 0, 0));
        moinsInt.setFocusable(false);
        moinsInt.setBorder(null);

        plusConst.setBounds(Fenetre.adapterResolutionEnX(1388), Fenetre.adapterResolutionEnY(572), Fenetre.adapterResolutionEnX(38), Fenetre.adapterResolutionEnX(39));
        plusConst.setBackground(new Color(0, 0, 0, 0));
        plusConst.setFocusable(false);
        plusConst.setBorder(null);

        moinsConst.setBounds(Fenetre.adapterResolutionEnX(1337), Fenetre.adapterResolutionEnY(572), Fenetre.adapterResolutionEnX(38), Fenetre.adapterResolutionEnX(38));
        moinsConst.setBackground(new Color(0, 0, 0, 0));
        moinsConst.setFocusable(false);
        moinsConst.setBorder(null);

        Image img = getToolkit().getImage("images/fichePerso.png");
        g.drawImage(img, 0, 0, getWidth(), getHeight(), this);
    }

    public void init() {
        valForce.setText("" + jeu.getHero().getForce());
        valInt.setText("" + jeu.getHero().getIntelligence());
        valConst.setText("" + jeu.getHero().getConstitution());
        valResist.setText("" + jeu.getHero().getResistance());
        pointCaracteristique.setText("" + jeu.getHero().getPointCaracteristique());
        pointCompetence.setText("" + jeu.getHero().getPointCompetence());
        niveau.setText("" + jeu.getHero().getNiveau());
        nomHero.setText("" + jeu.getHero().getNom());
    }
}
