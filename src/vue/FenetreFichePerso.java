package vue;

import controleur.ControlFenetreFichePerso;
import controleur.ControlFenetreOptions;

import javax.swing.*;
import java.awt.*;

import static vue.Fenetre.X;
import static vue.Fenetre.Y;

/**
 * Created by MSI-FlorianV on 05/01/2017.
 */
public class FenetreFichePerso extends JPanel {

    public JButton retour;

    public FenetreFichePerso() {

        this.setLayout(null);
        setPreferredSize(new Dimension(X, Y));

        retour = new JButton("");
        retour.setActionCommand("Retour");

        add(retour);
    }

    public void setControl(ControlFenetreFichePerso controlFenetreFichePerso) {
        retour.addActionListener(controlFenetreFichePerso);
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        retour.setBounds(Fenetre.adapterResolutionEnX(40), Fenetre.adapterResolutionEnY(980), Fenetre.adapterResolutionEnX(228), Fenetre.adapterResolutionEnX(40));
        retour.setBackground(new Color(0, 0, 0, 0));
        retour.setFocusable(false);
        retour.setBorder(null);

        Image img = getToolkit().getImage("images/menuOptionsTest.png");
        g.drawImage(img, 0, 0, getWidth(), getHeight(), this);
    }
}
