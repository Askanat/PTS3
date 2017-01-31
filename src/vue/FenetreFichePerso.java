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
    public JButton[] competence;
    public JLabel valForce, valInt, valConst, valResist, niveau, pointCaracteristique, pointCompetence, nomHero, vie, mana, exp;

    private Image imageFenetreFichePerso;
    private Font fontCompetence, fontBarre, fontNomLVL;

    public FenetreFichePerso(Jeu jeu) {
        this.jeu = jeu;

        this.setLayout(null);
        this.setPreferredSize(new Dimension(X, Y));

        boutonCompetence();

        imageFenetreFichePerso = getToolkit().getImage("images/fichePerso.png");
        fontCompetence = new Font("Arial", Font.BOLD, Fenetre.adapterResolutionEnX(20));
        fontBarre = new Font("Arial", Font.BOLD, Fenetre.adapterResolutionEnX(20));
        fontNomLVL = new Font("Arial", Font.BOLD, Fenetre.adapterResolutionEnX(32));

        //JButton Caractéristique
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
        valForce = new JLabel("", JLabel.CENTER);
        valInt = new JLabel("", JLabel.CENTER);
        valConst = new JLabel("", JLabel.CENTER);
        valResist = new JLabel("", JLabel.CENTER);
        niveau = new JLabel("");
        pointCaracteristique = new JLabel("", JLabel.CENTER);
        pointCompetence = new JLabel("", JLabel.CENTER);
        nomHero = new JLabel("");
        vie = new JLabel("", JLabel.CENTER);
        mana = new JLabel("", JLabel.CENTER);
        exp = new JLabel("", JLabel.CENTER);

        //Ajout JButton
        this.add(retour);
        this.add(plusForce);
        this.add(moinsForce);
        this.add(plusInt);
        this.add(moinsInt);
        this.add(plusConst);
        this.add(moinsConst);
        this.add(plusResist);
        this.add(moinsResist);
        this.add(valider);

        //Ajout JLabel
        this.add(valForce);
        this.add(valInt);
        this.add(valConst);
        this.add(valResist);
        this.add(valider);
        this.add(niveau);
        this.add(pointCaracteristique);
        this.add(pointCompetence);
        this.add(nomHero);
        this.add(vie);
        this.add(mana);
        this.add(exp);
    }

    public void boutonCompetence() {
        competence = new JButton[8];

        for (int i = 0; i < 8; i++) {
            competence[i] = new JButton("pouet");
            competence[i].setActionCommand("Competence" + i);
            this.add(competence[i]);
        }
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

        g.drawImage(imageFenetreFichePerso, 0, 0, getWidth(), getHeight(), this);

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
        valForce.setBounds(Fenetre.adapterResolutionEnX(1454), Fenetre.adapterResolutionEnY(265), Fenetre.adapterResolutionEnX(45), Fenetre.adapterResolutionEnX(40));
        valForce.setForeground(Color.WHITE);
        valForce.setFont(fontCompetence);
        valForce.setBorder(null);

        //Resistance
        valResist.setBounds(Fenetre.adapterResolutionEnX(1454), Fenetre.adapterResolutionEnY(316), Fenetre.adapterResolutionEnX(45), Fenetre.adapterResolutionEnX(40));
        valResist.setForeground(Color.WHITE);
        valResist.setFont(fontCompetence);
        valResist.setBorder(null);

        //Intelligence
        valInt.setBounds(Fenetre.adapterResolutionEnX(1454), Fenetre.adapterResolutionEnY(367), Fenetre.adapterResolutionEnX(45), Fenetre.adapterResolutionEnX(40));
        valInt.setForeground(Color.WHITE);
        valInt.setFont(fontCompetence);
        valInt.setBorder(null);

        //Constitution
        valConst.setBounds(Fenetre.adapterResolutionEnX(1454), Fenetre.adapterResolutionEnY(418), Fenetre.adapterResolutionEnX(45), Fenetre.adapterResolutionEnX(40));
        valConst.setForeground(Color.WHITE);
        valConst.setFont(fontCompetence);
        valConst.setBorder(null);

        //Point de Caractéristique
        pointCaracteristique.setBounds(Fenetre.adapterResolutionEnX(1775), Fenetre.adapterResolutionEnY(210), Fenetre.adapterResolutionEnX(45), Fenetre.adapterResolutionEnX(40));
        pointCaracteristique.setForeground(Color.WHITE);
        pointCaracteristique.setFont(fontCompetence);
        pointCaracteristique.setBorder(null);

        //Point de competence
        pointCompetence.setBounds(Fenetre.adapterResolutionEnX(1775), Fenetre.adapterResolutionEnY(572), Fenetre.adapterResolutionEnX(45), Fenetre.adapterResolutionEnX(40));
        pointCompetence.setForeground(Color.WHITE);
        pointCompetence.setFont(fontCompetence);
        pointCompetence.setBorder(null);


        nomHero.setBounds(Fenetre.adapterResolutionEnX(160), Fenetre.adapterResolutionEnY(592), Fenetre.adapterResolutionEnX(400), Fenetre.adapterResolutionEnX(40));
        nomHero.setForeground(Color.WHITE);
        nomHero.setFont(fontNomLVL);
        nomHero.setBorder(null);

        niveau.setBounds(Fenetre.adapterResolutionEnX(1040), Fenetre.adapterResolutionEnY(592), Fenetre.adapterResolutionEnX(70), Fenetre.adapterResolutionEnX(40));
        niveau.setFocusable(false);
        niveau.setForeground(Color.WHITE);
        niveau.setFont(fontNomLVL);
        niveau.setBorder(null);

        //Placement des Buttons de Caractéristique
        int k = 0;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 2; j++) {
                competence[k].setBounds(Fenetre.adapterResolutionEnX(1225 + (131 * i)), Fenetre.adapterResolutionEnY(645 + (130 * j)), Fenetre.adapterResolutionEnX(115), Fenetre.adapterResolutionEnX(115));
                competence[k].setBackground(new Color(0, 0, 0, 0));
                competence[k].setFocusable(false);
                competence[k].setCursor(new Cursor(Cursor.HAND_CURSOR));
                competence[k].setBorder(null);

                k += 1;
            }
        }

        //Texte Barre
        vie.setBounds(Fenetre.adapterResolutionEnX(126), Fenetre.adapterResolutionEnY(280), Fenetre.adapterResolutionEnX(932), Fenetre.adapterResolutionEnY(32));
        vie.setForeground(Color.BLACK);
        vie.setFont(fontBarre);
        vie.setBorder(null);

        mana.setBounds(Fenetre.adapterResolutionEnX(126), Fenetre.adapterResolutionEnY(375), Fenetre.adapterResolutionEnX(932), Fenetre.adapterResolutionEnY(32));
        mana.setForeground(Color.BLACK);
        mana.setFont(fontBarre);
        mana.setBorder(null);

        exp.setBounds(Fenetre.adapterResolutionEnX(126), Fenetre.adapterResolutionEnY(470), Fenetre.adapterResolutionEnX(932), Fenetre.adapterResolutionEnY(32));
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
        g.fillRect(Fenetre.adapterResolutionEnX(126), Fenetre.adapterResolutionEnY(470), Fenetre.adapterResolutionEnX(932 * (int) jeu.getHero().getExperience() / (int) jeu.getHero().getExperienceMax()), Fenetre.adapterResolutionEnY(32));

    }

    public void init() {
        valForce.setText("" + (int) jeu.getHero().getForce());
        valInt.setText("" + (int) jeu.getHero().getIntelligence());
        valConst.setText("" + (int) jeu.getHero().getConstitution());
        valResist.setText("" + (int) jeu.getHero().getResistance());
        pointCaracteristique.setText("" + jeu.getHero().getPointCaracteristique());
        pointCompetence.setText("" + jeu.getHero().getPointCompetence());
        niveau.setText("" + jeu.getHero().getNiveau());
        nomHero.setText("" + jeu.getHero().getNom());
        exp.setText((int) jeu.getHero().getExperience() + " / " + (int) jeu.getHero().getExperienceMax());
        vie.setText(jeu.getHero().getVie() + " / " + jeu.getHero().getVieMax());
        mana.setText(jeu.getHero().getMana() + " / " + jeu.getHero().getManaMax());
    }
}
