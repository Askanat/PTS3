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
    public JLabel valForce, valInt, valConst, valResist, niveau, pointCaracteristique, pointCompetence, nomHero, vie, mana, exp;

    public FenetreFichePerso(Jeu jeu) {
        this.jeu = jeu;

        this.setLayout(null);
        setPreferredSize(new Dimension(X, Y));

        //JButton
        retour = new JButton();
        retour.setActionCommand("Retour");

        valider = new JButton();
        valider.setActionCommand("Valider");

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

        //JLabel
        valForce = new JLabel("");
        valInt = new JLabel("");
        valConst = new JLabel("");
        valResist = new JLabel("");
        niveau = new JLabel("");
        pointCaracteristique = new JLabel("");
        pointCompetence = new JLabel("");
        nomHero = new JLabel("");
        vie = new JLabel("");
        mana = new JLabel("");
        exp = new JLabel("");

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
        add(valider);

        //Ajout JLabel
        add(valForce);
        add(valInt);
        add(valConst);
        add(valResist);
        add(valider);
        add(niveau);
        add(pointCaracteristique);
        add(pointCompetence);
        add(nomHero);
        add(vie);
        add(mana);
        add(exp);
    }

    public void setControl(ControlFenetreFichePerso controlFenetreFichePerso) {
        retour.addActionListener(controlFenetreFichePerso);
        valider.addActionListener(controlFenetreFichePerso);

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

        Font fontCompetence = new Font("Arial", Font.BOLD, Fenetre.adapterResolutionEnX (20));

        //JButton
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

        plusResist.setBounds(Fenetre.adapterResolutionEnX(1389), Fenetre.adapterResolutionEnY(316), Fenetre.adapterResolutionEnX(38), Fenetre.adapterResolutionEnX(38));
        plusResist.setBackground(new Color(0, 0, 0, 0));
        plusResist.setFocusable(false);
        plusResist.setBorder(null);

        moinsResist.setBounds(Fenetre.adapterResolutionEnX(1338), Fenetre.adapterResolutionEnY(316), Fenetre.adapterResolutionEnX(38), Fenetre.adapterResolutionEnX(38));
        moinsResist.setBackground(new Color(0, 0, 0, 0));
        moinsResist.setFocusable(false);
        moinsResist.setBorder(null);

        plusInt.setBounds(Fenetre.adapterResolutionEnX(1388), Fenetre.adapterResolutionEnY(367), Fenetre.adapterResolutionEnX(38), Fenetre.adapterResolutionEnX(38));
        plusInt.setBackground(new Color(0, 0, 0, 0));
        plusInt.setFocusable(false);
        plusInt.setBorder(null);

        moinsInt.setBounds(Fenetre.adapterResolutionEnX(1337), Fenetre.adapterResolutionEnY(367), Fenetre.adapterResolutionEnX(38), Fenetre.adapterResolutionEnX(38));
        moinsInt.setBackground(new Color(0, 0, 0, 0));
        moinsInt.setFocusable(false);
        moinsInt.setBorder(null);

        plusConst.setBounds(Fenetre.adapterResolutionEnX(1389), Fenetre.adapterResolutionEnY(418), Fenetre.adapterResolutionEnX(38), Fenetre.adapterResolutionEnX(39));
        plusConst.setBackground(new Color(0, 0, 0, 0));
        plusConst.setFocusable(false);
        plusConst.setBorder(null);

        moinsConst.setBounds(Fenetre.adapterResolutionEnX(1338), Fenetre.adapterResolutionEnY(418), Fenetre.adapterResolutionEnX(38), Fenetre.adapterResolutionEnX(38));
        moinsConst.setBackground(new Color(0, 0, 0, 0));
        moinsConst.setFocusable(false);
        moinsConst.setBorder(null);

        valider.setBounds(Fenetre.adapterResolutionEnX(1365), Fenetre.adapterResolutionEnY(932), Fenetre.adapterResolutionEnX(228), Fenetre.adapterResolutionEnX(40));
        valider.setBackground(new Color(0, 0, 0, 0));
        valider.setFocusable(false);
        valider.setBorder(null);

        //JLabel avec adaptation de taille
            //Force
                if (valForce.getText().length() == 1) {
                    valForce.setBounds(Fenetre.adapterResolutionEnX(1470), Fenetre.adapterResolutionEnY(265), Fenetre.adapterResolutionEnX(45), Fenetre.adapterResolutionEnX(40));
                    valForce.setForeground(Color.WHITE);
                    valForce.setFont(fontCompetence);
                    valForce.setBorder(null);
                }
                if (valForce.getText().length() == 2) {
                    valForce.setBounds(Fenetre.adapterResolutionEnX(1464), Fenetre.adapterResolutionEnY(265), Fenetre.adapterResolutionEnX(45), Fenetre.adapterResolutionEnX(40));
                    valForce.setForeground(Color.WHITE);
                    valForce.setFont(fontCompetence);
                    valForce.setBorder(null);
                }
                if (valForce.getText().length() == 3) {
                    valForce.setBounds(Fenetre.adapterResolutionEnX(1460), Fenetre.adapterResolutionEnY(265), Fenetre.adapterResolutionEnX(45), Fenetre.adapterResolutionEnX(40));
                    valForce.setForeground(Color.WHITE);
                    valForce.setFont(fontCompetence);
                    valForce.setBorder(null);
                }
                if (valForce.getText().length() == 4) {
                    valForce.setBounds(Fenetre.adapterResolutionEnX(1454), Fenetre.adapterResolutionEnY(265), Fenetre.adapterResolutionEnX(45), Fenetre.adapterResolutionEnX(40));
                    valForce.setForeground(Color.WHITE);
                    valForce.setFont(fontCompetence);
                    valForce.setBorder(null);
                }

            //Resistance
                if(valResist.getText().length() == 1) {
                    valResist.setBounds(Fenetre.adapterResolutionEnX(1470), Fenetre.adapterResolutionEnY(316), Fenetre.adapterResolutionEnX(45), Fenetre.adapterResolutionEnX(40));
                    valResist.setForeground(Color.WHITE);
                    valResist.setFont(fontCompetence);
                    valResist.setBorder(null);
                }
                if (valResist.getText().length() == 2) {
                    valResist.setBounds(Fenetre.adapterResolutionEnX(1464), Fenetre.adapterResolutionEnY(316), Fenetre.adapterResolutionEnX(45), Fenetre.adapterResolutionEnX(40));
                    valResist.setForeground(Color.WHITE);
                    valResist.setFont(fontCompetence);
                    valResist.setBorder(null);
                }
                if (valResist.getText().length() == 3) {
                    valResist.setBounds(Fenetre.adapterResolutionEnX(1460), Fenetre.adapterResolutionEnY(316), Fenetre.adapterResolutionEnX(45), Fenetre.adapterResolutionEnX(40));
                    valResist.setForeground(Color.WHITE);
                    valResist.setFont(fontCompetence);
                    valResist.setBorder(null);
                }
                if (valResist.getText().length() == 4) {
                    valResist.setBounds(Fenetre.adapterResolutionEnX(1454), Fenetre.adapterResolutionEnY(316), Fenetre.adapterResolutionEnX(45), Fenetre.adapterResolutionEnX(40));
                    valResist.setForeground(Color.WHITE);
                    valResist.setFont(fontCompetence);
                    valResist.setBorder(null);
                }

            //Intelligence
                if(valInt.getText().length() == 1) {
                    valInt.setBounds(Fenetre.adapterResolutionEnX(1470), Fenetre.adapterResolutionEnY(367), Fenetre.adapterResolutionEnX(45), Fenetre.adapterResolutionEnX(40));
                    valInt.setForeground(Color.WHITE);
                    valInt.setFont(fontCompetence);
                    valInt.setBorder(null);
                }
                if (valInt.getText().length() == 2) {
                    valInt.setBounds(Fenetre.adapterResolutionEnX(1464), Fenetre.adapterResolutionEnY(367), Fenetre.adapterResolutionEnX(45), Fenetre.adapterResolutionEnX(40));
                    valInt.setForeground(Color.WHITE);
                    valInt.setFont(fontCompetence);
                    valInt.setBorder(null);
                }
                if (valInt.getText().length() == 3) {
                    valInt.setBounds(Fenetre.adapterResolutionEnX(1460), Fenetre.adapterResolutionEnY(367), Fenetre.adapterResolutionEnX(45), Fenetre.adapterResolutionEnX(40));
                    valInt.setForeground(Color.WHITE);
                    valInt.setFont(fontCompetence);
                    valInt.setBorder(null);
                }
                if (valInt.getText().length() == 4) {
                    valInt.setBounds(Fenetre.adapterResolutionEnX(1454), Fenetre.adapterResolutionEnY(367), Fenetre.adapterResolutionEnX(45), Fenetre.adapterResolutionEnX(40));
                    valInt.setForeground(Color.WHITE);
                    valInt.setFont(fontCompetence);
                    valInt.setBorder(null);
                }

            //Constitution
                if(valConst.getText().length() == 1) {
                    valConst.setBounds(Fenetre.adapterResolutionEnX(1470), Fenetre.adapterResolutionEnY(418), Fenetre.adapterResolutionEnX(45), Fenetre.adapterResolutionEnX(40));
                    valConst.setForeground(Color.WHITE);
                    valConst.setFont(fontCompetence);
                    valConst.setBorder(null);
                }
                if (valConst.getText().length() == 2) {
                    valConst.setBounds(Fenetre.adapterResolutionEnX(1464), Fenetre.adapterResolutionEnY(418), Fenetre.adapterResolutionEnX(45), Fenetre.adapterResolutionEnX(40));
                    valConst.setForeground(Color.WHITE);
                    valConst.setFont(fontCompetence);
                    valConst.setBorder(null);
                }
                if (valConst.getText().length() == 3) {
                    valConst.setBounds(Fenetre.adapterResolutionEnX(1460), Fenetre.adapterResolutionEnY(418), Fenetre.adapterResolutionEnX(45), Fenetre.adapterResolutionEnX(40));
                    valConst.setForeground(Color.WHITE);
                    valConst.setFont(fontCompetence);
                    valConst.setBorder(null);
                }
                if (valConst.getText().length() == 4) {
                    valConst.setBounds(Fenetre.adapterResolutionEnX(1454), Fenetre.adapterResolutionEnY(418), Fenetre.adapterResolutionEnX(45), Fenetre.adapterResolutionEnX(40));
                    valConst.setForeground(Color.WHITE);
                    valConst.setFont(fontCompetence);
                    valConst.setBorder(null);
                }

            //Point de Caractéristique
                if(pointCaracteristique.getText().length() == 1) {
                    pointCaracteristique.setBounds(Fenetre.adapterResolutionEnX(1791), Fenetre.adapterResolutionEnY(210), Fenetre.adapterResolutionEnX(80), Fenetre.adapterResolutionEnX(40));
                    pointCaracteristique.setForeground(Color.WHITE);
                    pointCaracteristique.setFont(fontCompetence);
                    pointCaracteristique.setBorder(null);
                }
                if (pointCaracteristique.getText().length() == 2) {
                    pointCaracteristique.setBounds(Fenetre.adapterResolutionEnX(1785), Fenetre.adapterResolutionEnY(210), Fenetre.adapterResolutionEnX(80), Fenetre.adapterResolutionEnX(40));
                    pointCaracteristique.setForeground(Color.WHITE);
                    pointCaracteristique.setFont(fontCompetence);
                    pointCaracteristique.setBorder(null);
                }
                if (pointCaracteristique.getText().length() == 3) {
                    pointCaracteristique.setBounds(Fenetre.adapterResolutionEnX(1781), Fenetre.adapterResolutionEnY(210), Fenetre.adapterResolutionEnX(80), Fenetre.adapterResolutionEnX(40));
                    pointCaracteristique.setForeground(Color.WHITE);
                    pointCaracteristique.setFont(fontCompetence);
                    pointCaracteristique.setBorder(null);
                }
                if (pointCaracteristique.getText().length() == 4) {
                    pointCaracteristique.setBounds(Fenetre.adapterResolutionEnX(1775), Fenetre.adapterResolutionEnY(210), Fenetre.adapterResolutionEnX(80), Fenetre.adapterResolutionEnX(40));
                    pointCaracteristique.setForeground(Color.WHITE);
                    pointCaracteristique.setFont(fontCompetence);
                    pointCaracteristique.setBorder(null);
                }

            //Point de Caractéristique
                if(pointCompetence.getText().length() == 1) {
                    pointCompetence.setBounds(Fenetre.adapterResolutionEnX(1791), Fenetre.adapterResolutionEnY(572), Fenetre.adapterResolutionEnX(80), Fenetre.adapterResolutionEnX(40));
                    pointCompetence.setForeground(Color.WHITE);
                    pointCompetence.setFont(fontCompetence);
                    pointCompetence.setBorder(null);
                }
                if (pointCompetence.getText().length() == 2) {
                    pointCompetence.setBounds(Fenetre.adapterResolutionEnX(1785), Fenetre.adapterResolutionEnY(572), Fenetre.adapterResolutionEnX(80), Fenetre.adapterResolutionEnX(40));
                    pointCompetence.setForeground(Color.WHITE);
                    pointCompetence.setFont(fontCompetence);
                    pointCompetence.setBorder(null);
                }
                if (pointCompetence.getText().length() == 3) {
                    pointCompetence.setBounds(Fenetre.adapterResolutionEnX(1781), Fenetre.adapterResolutionEnY(572), Fenetre.adapterResolutionEnX(80), Fenetre.adapterResolutionEnX(40));
                    pointCompetence.setForeground(Color.WHITE);
                    pointCompetence.setFont(fontCompetence);
                    pointCompetence.setBorder(null);
                }
                if (pointCompetence.getText().length() == 4) {
                    pointCompetence.setBounds(Fenetre.adapterResolutionEnX(1775), Fenetre.adapterResolutionEnY(572), Fenetre.adapterResolutionEnX(80), Fenetre.adapterResolutionEnX(40));
                    pointCompetence.setForeground(Color.WHITE);
                    pointCompetence.setFont(fontCompetence);
                    pointCompetence.setBorder(null);
                }

        //Fond Nom et Niveau
        Font fontNomLVL = new Font("Arial", Font.BOLD, Fenetre.adapterResolutionEnX (32));


        nomHero.setBounds(Fenetre.adapterResolutionEnX(160), Fenetre.adapterResolutionEnY(592), Fenetre.adapterResolutionEnX(400), Fenetre.adapterResolutionEnX(40));
        nomHero.setForeground(Color.WHITE);
        nomHero.setFont(fontNomLVL);
        nomHero.setBorder(null);

        niveau.setBounds(Fenetre.adapterResolutionEnX(1040), Fenetre.adapterResolutionEnY(592), Fenetre.adapterResolutionEnX(80), Fenetre.adapterResolutionEnX(40));
        niveau.setFocusable(false);
        niveau.setForeground(Color.WHITE);
        niveau.setFont(fontNomLVL);
        niveau.setBorder(null);

        Image img = getToolkit().getImage("images/fichePerso.png");
        g.drawImage(img, 0, 0, getWidth(), getHeight(), this);

        //Fond Barre
        Font fontBarre = new Font("Arial", Font.BOLD, Fenetre.adapterResolutionEnX (20));

        //Texte Barre
        vie.setBounds(Fenetre.adapterResolutionEnX(540), Fenetre.adapterResolutionEnY(280), Fenetre.adapterResolutionEnX(100), Fenetre.adapterResolutionEnY(32));
        vie.setForeground(Color.BLACK);
        vie.setFont(fontBarre);
        vie.setBorder(null);

        mana.setBounds(Fenetre.adapterResolutionEnX(540), Fenetre.adapterResolutionEnY(375), Fenetre.adapterResolutionEnX(100), Fenetre.adapterResolutionEnY(32));
        mana.setForeground(Color.BLACK);
        mana.setFont(fontBarre);
        mana.setBorder(null);

        exp.setBounds(Fenetre.adapterResolutionEnX(540), Fenetre.adapterResolutionEnY(470), Fenetre.adapterResolutionEnX(100), Fenetre.adapterResolutionEnY(32));
        exp.setForeground(Color.BLACK);
        exp.setFont(fontBarre);
        exp.setBorder(null);

        // barre de mana pour le Héro
        g.setColor(Color.BLACK);
        g.fillRect(Fenetre.adapterResolutionEnX(126) - Fenetre.adapterResolutionEnX(1), Fenetre.adapterResolutionEnY(280) - Fenetre.adapterResolutionEnY(1), Fenetre.adapterResolutionEnX(932) + Fenetre.adapterResolutionEnX(2), Fenetre.adapterResolutionEnY(32) + Fenetre.adapterResolutionEnY(2));
        g.setColor(Color.WHITE);
        g.fillRect(Fenetre.adapterResolutionEnX(126), Fenetre.adapterResolutionEnY(280), Fenetre.adapterResolutionEnX(932), Fenetre.adapterResolutionEnY(32));
        g.setColor(Color.GREEN);
        g.fillRect(Fenetre.adapterResolutionEnX(126), Fenetre.adapterResolutionEnY(280), Fenetre.adapterResolutionEnX(932 * jeu.getHero().getVie() / jeu.getHero().getVieMax()), Fenetre.adapterResolutionEnY(32));

        // barre de mana pour le Héro
        g.setColor(Color.BLACK);
        g.fillRect(Fenetre.adapterResolutionEnX(126) - Fenetre.adapterResolutionEnX(1), Fenetre.adapterResolutionEnY(375) - Fenetre.adapterResolutionEnY(1), Fenetre.adapterResolutionEnX(932) + Fenetre.adapterResolutionEnX(2), Fenetre.adapterResolutionEnY(32) + Fenetre.adapterResolutionEnY(2));
        g.setColor(Color.WHITE);
        g.fillRect(Fenetre.adapterResolutionEnX(126), Fenetre.adapterResolutionEnY(375), Fenetre.adapterResolutionEnX(932), Fenetre.adapterResolutionEnY(32));
        g.setColor(Color.BLUE);
        g.fillRect(Fenetre.adapterResolutionEnX(126), Fenetre.adapterResolutionEnY(375), Fenetre.adapterResolutionEnX(932 * jeu.getHero().getMana() / jeu.getHero().getManaMax()), Fenetre.adapterResolutionEnY(32));

        // barre de mana pour le Héro
        g.setColor(Color.BLACK);
        g.fillRect(Fenetre.adapterResolutionEnX(126) - Fenetre.adapterResolutionEnX(1), Fenetre.adapterResolutionEnY(470) - Fenetre.adapterResolutionEnY(1), Fenetre.adapterResolutionEnX(932) + Fenetre.adapterResolutionEnX(2), Fenetre.adapterResolutionEnY(32) + Fenetre.adapterResolutionEnY(2));
        g.setColor(Color.WHITE);
        g.fillRect(Fenetre.adapterResolutionEnX(126), Fenetre.adapterResolutionEnY(470), Fenetre.adapterResolutionEnX(932), Fenetre.adapterResolutionEnY(32));
        g.setColor(Color.ORANGE);
        g.fillRect(Fenetre.adapterResolutionEnX(126), Fenetre.adapterResolutionEnY(470), Fenetre.adapterResolutionEnX(932 * (int)jeu.getHero().getExperience() / (int)jeu.getHero().getExperienceMax()), Fenetre.adapterResolutionEnY(32));

    }

    public void init() {
        valForce.setText("" + (int)jeu.getHero().getForce());
        valInt.setText("" + (int)jeu.getHero().getIntelligence());
        valConst.setText("" + (int)jeu.getHero().getConstitution());
        valResist.setText("" + (int)jeu.getHero().getResistance());
        pointCaracteristique.setText("" + jeu.getHero().getPointCaracteristique());
        pointCompetence.setText("" + jeu.getHero().getPointCompetence());
        niveau.setText("" + jeu.getHero().getNiveau());
        nomHero.setText("" + jeu.getHero().getNom());
        exp.setText((int)jeu.getHero().getExperience() + " / " + (int)jeu.getHero().getExperienceMax());
        vie.setText(jeu.getHero().getVie() + " / " + jeu.getHero().getVieMax());
        mana.setText(jeu.getHero().getMana() + " / " + jeu.getHero().getManaMax());
    }
}
