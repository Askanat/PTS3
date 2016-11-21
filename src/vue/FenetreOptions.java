package vue;

import controleur.ControlFenetreOptions;

import javax.swing.*;
import java.awt.*;

import static model.Jeu.X;
import static model.Jeu.Y;

/**
 * Created by bastien on 14/10/16.
 */

public class FenetreOptions extends JPanel {

    public JButton retour, retour1;
    private JLabel options, texte;

    public FenetreOptions() {

        this.setLayout(null);
        setPreferredSize(new Dimension(X, Y));

        retour = new JButton("");
        retour.setActionCommand("Retour");

        add(retour);
    }

    public void setControl(ControlFenetreOptions controlFenetreOptions) {
        retour.addActionListener(controlFenetreOptions);
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        retour.setBounds((int) (1/48.0*X), (int) (49/54.0 * Y), (int) (19/160.0*X), (int) (1/27.0*Y));
        retour.setBackground(new Color(0, 0, 0, 0));
        retour.setFocusable(false);
        retour.setCursor(new Cursor(Cursor.HAND_CURSOR));
        retour.setBorder(null);

        Image img = getToolkit().getImage("images/menuOptionsTest.png");
        g.drawImage(img, 0, 0, getWidth(), getHeight(), this);
    }
}
