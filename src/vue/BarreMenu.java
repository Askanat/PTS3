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

    public JMenu test;
    public JMenuItem menu;

    public BarreMenu(Jeu jeu) {

        this.jeu = jeu;

        menu = new JMenuItem("Menu");
        menu.setActionCommand("Menu");

        test = null;

        add(menu);
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        test.setText("" + jeu.getHero().getVie());
        test.repaint();
    }

    public void test() {
        System.out.println("menu ajout vie");
        test = new JMenu("" + jeu.getHero().getVie());
        add(test);
    }

    public void setControl(ControlBarreMenu controlBarreMenu) {
        menu.addActionListener(controlBarreMenu);
    }
}