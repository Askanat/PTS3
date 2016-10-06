package vue;

import controleur.ControlMenuPrincipal;
import model.Jeu;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Florian Vaissiere on 03/10/2016.
 */
public class BarreMenu extends JMenuBar {

    private Jeu jeu;
    private JMenuBar menuBar = new JMenuBar();
    public JMenu menu;

    public BarreMenu(Jeu jeu) {
        this.jeu = jeu;

        menu = new JMenu("Menu");
        menu.setActionCommand("Menu");

        menuBar.add(menu);
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        menu.setForeground(Color.WHITE);
        menu.setBackground(new Color(0, 0, 0, 0));
        menu.setFocusable(false);
        menu.setCursor(new Cursor(Cursor.HAND_CURSOR));
        menu.setBorder(null);

        Image img = getToolkit().getImage("images/fondMenuPrinci.jpg");
        g.drawImage(img, 0, 0, getWidth(), getHeight(), this);
    }

    public void setControl(ControlMenuPrincipal controlMenuJeu) {
        menu.addActionListener(controlMenuJeu);
    }
}
