package vue;

import controleur.ControlFenetreCredits;

import javax.swing.*;
import java.awt.*;

import static vue.Fenetre.X;
import static vue.Fenetre.Y;

/**
 * Created by bastien on 29/09/16.
 */

public class FenetreCredits extends JPanel {

    public JButton retour;

    public FenetreCredits() {

        this.setLayout(null);
        setPreferredSize(new Dimension(X, Y));

        retour = new JButton("");
        retour.setActionCommand("Retour");

        add(retour);
    }

    public void setControl(ControlFenetreCredits controlFenetreCredits) {
        retour.addActionListener(controlFenetreCredits);
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        retour.setBounds(Fenetre.adapterResolutionEnX(40), Fenetre.adapterResolutionEnY(980), Fenetre.adapterResolutionEnX(228), Fenetre.adapterResolutionEnX(40));
        retour.setBackground(new Color(0, 0, 0, 0));
        retour.setFocusable(false);
        retour.setCursor(new Cursor(Cursor.HAND_CURSOR));
        retour.setBorder(null);

        Image img = getToolkit().getImage("images/Credits.png");
        g.drawImage(img, 0, 0, getWidth(), getHeight(), this);
    }
}
