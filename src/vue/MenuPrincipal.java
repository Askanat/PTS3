package vue;

import javax.swing.*;
import java.awt.*;

/**
 * Created by bastien on 29/09/16.
 */
public class MenuPrincipal extends JPanel {

    private JButton nouvellePartie;
    private JButton chargerPartie;
    private JButton credits;
    private JButton Quitter;

    public MenuPrincipal() {
        this.setLayout(null);
        setPreferredSize(new Dimension(800, 600));
        jouer = new JButton("Jouer");
        jouer.setActionCommand("jouer");
        score = new JButton("Scores");
        score.setActionCommand("score");

        add(nouvellePartie);
        add(chargerPartie);
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        jouer.setBounds(290, 343, 228, 40);
        jouer.setBackground(new Color(0, 0, 0, 0));
        jouer.setFocusable(false);
        jouer.setCursor(new Cursor(Cursor.HAND_CURSOR));
        jouer.setBorder(null);

        score.setBounds(290, 413, 228, 40);
        score.setBackground(new Color(0, 0, 0, 0));
        score.setFocusable(false);
        score.setCursor(new Cursor(Cursor.HAND_CURSOR));
        score.setBorder(null);

        Image img = getToolkit().getImage("images/menu.png");
        g.drawImage(img, 0, 0, getWidth(), getHeight(), this);
    }


    public void setControl(ControlMenuPrincipal controlMenuPrincipal) {
        jouer.addActionListener(controlMenuPrincipal);
        score.addActionListener(controlMenuPrincipal);
        score.addActionListener(controlMenuPrincipal);
        score.addActionListener(controlMenuPrincipal);
    }
}
