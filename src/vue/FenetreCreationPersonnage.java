package vue;

import controleur.ControlFenetreCreationPersonnage;
import model.Jeu;

import javax.swing.*;
import java.awt.*;

import static model.Jeu.X;
import static model.Jeu.Y;

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

        jouer = new JButton("Jouer");
        jouer.setActionCommand("Jouer");

        lNomHero = new JLabel("Nom");
        tfNomHero = new JTextField();
        tfNomHero.setColumns(10);

        retour = new JButton("Retour");
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

        jouer.setBounds((int) (413/480.0*X), (int) (49/54.0 * Y), (int) (19/160.0*X), (int) (1/27.0*Y));
        jouer.setForeground(Color.WHITE);
        jouer.setBackground(new Color(0, 0, 0, 0));
        jouer.setFocusable(false);
        jouer.setCursor(new Cursor(Cursor.HAND_CURSOR));
        jouer.setBorder(null);


        lNomHero.setBounds(940, 850, 230, 40);
        lNomHero.setForeground(Color.WHITE);
        lNomHero.setBackground(new Color(0, 0, 0, 0));
        lNomHero.setFocusable(false);
        lNomHero.setCursor(new Cursor(Cursor.HAND_CURSOR));
        lNomHero.setBorder(null);

        tfNomHero.setBounds(845, 890, 230, 40);

        retour.setBounds((int) (1/48.0*X), (int) (49/54.0 * Y), (int) (19/160.0*X), (int) (1/27.0*Y));
        retour.setForeground(Color.WHITE);
        retour.setBackground(new Color(0, 0, 0, 0));
        retour.setFocusable(false);
        retour.setCursor(new Cursor(Cursor.HAND_CURSOR));
        retour.setBorder(null);

        Image img = getToolkit().getImage("images/fondMenuPrinci.jpg");
        g.drawImage(img, 0, 0, getWidth(), getHeight(), this);
    }

    public JTextField getTfNomHero() {
        return tfNomHero;
    }
}
