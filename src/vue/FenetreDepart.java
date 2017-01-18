package vue;

import controleur.ControlFenetreDepart;
import model.Jeu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import static vue.Fenetre.X;
import static vue.Fenetre.Y;

/**
 * Created by bastien on 29/09/16.
 */

public class FenetreDepart extends JPanel {

    private Jeu jeu;
    private ActionListener control;

    public Entite hero; // le héro
    public ArrayList<Entite> monstre; // a déplacer

    public JButton menu;

    private Image imageFenetreDepart, imageIconeSave;

    public FenetreDepart(Jeu jeu) {

        this.jeu = jeu;

        setLayout(null);
        setPreferredSize(new Dimension(X * 2, (int) (Y * 1.5)));
        imageFenetreDepart = getToolkit().getImage("images/fondJeux.png");
        imageIconeSave = getToolkit().getImage("images/iconeSave.png");

        hero = new Entite(jeu);


        monstre = new ArrayList<Entite>(); // a enlever d'ici

        bouttonMenu();
    }

    public void bouttonMenu() {
        menu = new JButton("");
        menu.setActionCommand("Menu");
        Image img = getToolkit().getImage("images/iconeMenu.png").getScaledInstance(Fenetre.adapterResolutionEnX(40), Fenetre.adapterResolutionEnY(40), java.awt.Image.SCALE_SMOOTH);
        menu.setIcon(new ImageIcon(img));
        add(menu);
        menu.addActionListener(control);
    }

    public void dessineHero() {
        hero.creationEntite(jeu.getHero());
    }

    public void dessineMonstre(int id) {
        monstre.add(new Entite(jeu));
        monstre.get(monstre.size() - 1).creationEntite(jeu.getMonstre(jeu.getSizeTabMonstre() - 1));
    }

    public void setControl(ControlFenetreDepart controlFenetreDepart) {
        menu.addActionListener(controlFenetreDepart);
        control = controlFenetreDepart;
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.drawImage(imageFenetreDepart, 0, 0, getWidth(), getHeight(), this);

        menu.setBounds((int) (jeu.getHero().getPositionX() - X / 2.0 + Fenetre.adapterResolutionEnX(1860)), (int) (jeu.getHero().getPositionY() - Y / 2.0 + Fenetre.adapterResolutionEnY(10)), Fenetre.adapterResolutionEnX(40), Fenetre.adapterResolutionEnY(40));
        menu.setBackground(new Color(0, 0, 0, 0));
        menu.setFocusable(false);
        menu.setCursor(new Cursor(Cursor.HAND_CURSOR));
        menu.setBorder(null);

        for (Entite e : monstre)
            e.paintComponent(g);

        hero.paintComponent(g);

        if (jeu.getSave())
            g.drawImage(imageIconeSave, (int) (jeu.getHero().getPositionX() - X / 2.0 + Fenetre.adapterResolutionEnX(5)), (int) (jeu.getHero().getPositionY() - Y / 2.0 + Fenetre.adapterResolutionEnY(5)), Fenetre.adapterResolutionEnX(50), Fenetre.adapterResolutionEnY(50), this);
    }
}