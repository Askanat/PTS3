package vue;

import controleur.ControlFenetreCreationPersonnage;
import controleur.ControlFenetreNouvellePartie;
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
    public JButton retour;

    public FenetreCreationPersonnage(Jeu jeu) {

        this.jeu = jeu;

        this.setLayout(null);
        setPreferredSize(new Dimension(X, Y));

        retour = new JButton("Retour");
        retour.setActionCommand("Retour");

        add(retour);
    }

    public void setControl(ControlFenetreCreationPersonnage controlFenetreCreationPersonnage) {

        retour.addActionListener(controlFenetreCreationPersonnage);
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        retour.setBounds(40, 500, 228, 40);
        retour.setForeground(Color.WHITE);
        retour.setBackground(new Color(0, 0, 0, 0));
        retour.setFocusable(false);
        retour.setCursor(new Cursor(Cursor.HAND_CURSOR));
        retour.setBorder(null);

        Image img = getToolkit().getImage("images/fondMenuPrinci.jpg");
        g.drawImage(img, 0, 0, getWidth(), getHeight(), this);
    }

}
