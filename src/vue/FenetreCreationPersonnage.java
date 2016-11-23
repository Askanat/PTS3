package vue;

import controleur.ControlFenetreCreationPersonnage;
import model.Jeu;

import javax.swing.*;
import java.awt.*;

import static vue.Fenetre.X;
import static vue.Fenetre.Y;

/**
 * Created by bastien on 21/11/16.
 */
public class FenetreCreationPersonnage extends JPanel {

    private Jeu jeu;
    public JButton jouer, retour;
    public JLabel lNomHero;
    public JTextField tfNomHero;

    public FenetreCreationPersonnage(Jeu jeu) {

        this.jeu = jeu;

        this.setLayout(null);
        setPreferredSize(new Dimension(X, Y));

        jouer = new JButton("");
        jouer.setActionCommand("Jouer");

        lNomHero = new JLabel("");
        tfNomHero = new JTextField();
        tfNomHero.setColumns(10);

        retour = new JButton("");
        retour.setActionCommand("Retour");

        add(jouer);
        add(lNomHero);
        add(tfNomHero);
        add(retour);
    }

    public void setControl(ControlFenetreCreationPersonnage controlFenetreCreationPersonnage) {
        jouer.addActionListener(controlFenetreCreationPersonnage);
        retour.addActionListener(controlFenetreCreationPersonnage);
        tfNomHero.addActionListener(controlFenetreCreationPersonnage);
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        jouer.setBounds(Fenetre.adapterResolutionEnX(1600), Fenetre.adapterResolutionEnY(985), Fenetre.adapterResolutionEnX(256), Fenetre.adapterResolutionEnY(41));
        jouer.setForeground(Color.WHITE);
        jouer.setBackground(new Color(0, 0, 0, 0));
        jouer.setFocusable(false);
        jouer.setCursor(new Cursor(Cursor.HAND_CURSOR));
        jouer.setBorder(null);


        lNomHero.setBounds(Fenetre.adapterResolutionEnX(940), Fenetre.adapterResolutionEnY(850), Fenetre.adapterResolutionEnX(230), Fenetre.adapterResolutionEnY(40));
        lNomHero.setForeground(Color.WHITE);
        lNomHero.setBackground(new Color(0, 0, 0, 0));
        lNomHero.setFocusable(false);
        lNomHero.setCursor(new Cursor(Cursor.HAND_CURSOR));
        lNomHero.setBorder(null);

        tfNomHero.setBounds(Fenetre.adapterResolutionEnX(845), Fenetre.adapterResolutionEnY(890), Fenetre.adapterResolutionEnX(230), Fenetre.adapterResolutionEnY(40));

        retour.setBounds(Fenetre.adapterResolutionEnX(64), Fenetre.adapterResolutionEnY(985), Fenetre.adapterResolutionEnX(256), Fenetre.adapterResolutionEnY(41));
        retour.setBackground(new Color(0, 0, 0, 0));
        retour.setFocusable(false);
        retour.setCursor(new Cursor(Cursor.HAND_CURSOR));
        retour.setBorder(null);

        Image img = getToolkit().getImage("images/menuCreationPersonnage.png");
        g.drawImage(img, 0, 0, getWidth(), getHeight(), this);
    }

    public JTextField getTfNomHero() {
        return tfNomHero;
    }
}
