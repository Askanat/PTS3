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

    private Image imageFenetreCredits;

    public JButton retour;

    public FenetreCredits() {

        this.setLayout(null);
        this.setPreferredSize(new Dimension(X, Y));

        imageFenetreCredits = getToolkit().getImage("images/Credits.png");

        retour = new JButton("");
        retour.setActionCommand("Retour");

        this.add(retour);
    }

    public void setControl(ControlFenetreCredits controlFenetreCredits) {
        retour.addActionListener(controlFenetreCredits);
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.drawImage(imageFenetreCredits, 0, 0, getWidth(), getHeight(), this);

        retour.setBounds(Fenetre.adapterResolutionEnX(40), Fenetre.adapterResolutionEnY(980), Fenetre.adapterResolutionEnX(228), Fenetre.adapterResolutionEnX(40));
        retour.setBackground(new Color(0, 0, 0, 0));
        retour.setFocusable(false);
        retour.setCursor(new Cursor(Cursor.HAND_CURSOR));
        retour.setBorder(null);
    }
}