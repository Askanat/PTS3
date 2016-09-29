package vue;

import model.Jeu;

import javax.swing.*;

/**
 * Created by bastien on 28/09/16.
 */
public class Fenetre extends JFrame {

    public Jeu jeu;

    public Fenetre(Jeu jeu) {

        this.jeu = jeu;

        init();
        //menu = new BarMenu(jeu);
        //menu.setVisible(false);
        //setJMenuBar(menu);
        //setContentPane(panelMenu);
        pack();
        setTitle("Jeu");
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //setLocationRelativeTo(null);
        setVisible(true);
    }

    public void init() {
    }
}