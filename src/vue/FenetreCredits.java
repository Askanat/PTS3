package vue;

import controleur.ControlFenetreCredits;

import javax.swing.*;
import java.awt.*;

/**
 * Created by bastien on 29/09/16.
 */

public class FenetreCredits extends JPanel {

    public JButton retour;
    private JLabel credits, texte;

    public FenetreCredits() {

        this.setLayout(null);
        setPreferredSize(new Dimension(960, 540));

        retour = new JButton("Retour");
        retour.setActionCommand("Retour");

        add(retour);
    }

    public void setControl(ControlFenetreCredits controlFenetreCredits) {
        retour.addActionListener(controlFenetreCredits);
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        retour.setBounds(40, 500, 228, 40);
        retour.setForeground(Color.WHITE);
        retour.setBackground(new Color(0, 0, 0, 0));
        retour.setFocusable(false);
        retour.setCursor(new Cursor(Cursor.HAND_CURSOR));
        retour.setBorder(null);

        Image img = getToolkit().getImage("images/Credits.png");
        g.drawImage(img, 0, 0, getWidth(), getHeight(), this);
    }
}