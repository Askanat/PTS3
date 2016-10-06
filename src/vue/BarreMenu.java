package vue;

import controleur.ControlBarreMenu;
import model.Jeu;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Florian Vaissiere on 03/10/2016.
 */

public class BarreMenu extends JMenuBar {

    private Jeu jeu;

    public JMenu menu;
    JMenuItem nouvellePartie, menuPrincipal;

    public BarreMenu(Jeu jeu) {

        this.jeu = jeu;

        menu = new JMenu("Menu");
        menu.setActionCommand("Menu");

        nouvellePartie = new JMenuItem("Nouvelle partie");
        nouvellePartie.setActionCommand("nouvellePartie");
        menuPrincipal = new JMenuItem("Menu principal");
        menuPrincipal.setActionCommand("menuPrincipal");

        menu.add(nouvellePartie);
        menu.add(menuPrincipal);
        add(menu);
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        /*menu.setForeground(Color.WHITE);
        menu.setBackground(new Color(0, 0, 0, 0));
        menu.setFocusable(false);
        menu.setCursor(new Cursor(Cursor.HAND_CURSOR));
        menu.setBorder(null);

        //Image img = getToolkit().getImage("images/fondMenuPrinci.jpg");
        //g.drawImage(img, 0, 0, getWidth(), getHeight(), this);*/
    }

    public void setControl(ControlBarreMenu controlBarreMenu) {
        nouvellePartie.addActionListener(controlBarreMenu);
        menuPrincipal.addActionListener(controlBarreMenu);
    }
}