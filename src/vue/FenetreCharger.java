package vue;

import controleur.ControlFenetreCharger;
import model.Jeu;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

import static vue.Fenetre.X;
import static vue.Fenetre.Y;

/**
 * Created by bastien on 29/09/16.
 */

public class FenetreCharger extends JPanel {

    private Jeu jeu;
    public JButton slot1, slot2, slot3, jouer, retour;

    public FenetreCharger(Jeu jeu) {

        this.jeu = jeu;

        this.setLayout(null);
        setPreferredSize(new Dimension(X, Y));

        slot1 = new JButton("");
        slot1.setActionCommand("Slot de Sauvegarde n°1");
        slot2 = new JButton("");
        slot2.setActionCommand("Slot de Sauvegarde n°2");
        slot3 = new JButton("");
        slot3.setActionCommand("Slot de Sauvegarde n°3");
        jouer = new JButton("");
        jouer.setActionCommand("Jouer");
        retour = new JButton("");
        retour.setActionCommand("Retour");

        add(slot1);
        add(slot2);
        add(slot3);
        add(jouer);
        add(retour);
    }

    public void setControl(ControlFenetreCharger controlFenetreCharger) {
        slot1.addActionListener(controlFenetreCharger);
        slot2.addActionListener(controlFenetreCharger);
        slot3.addActionListener(controlFenetreCharger);
        jouer.addActionListener(controlFenetreCharger);
        retour.addActionListener(controlFenetreCharger);
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        slot1.setBounds(Fenetre.adapterResolutionEnX(340), Fenetre.adapterResolutionEnY(240), Fenetre.adapterResolutionEnX(240), Fenetre.adapterResolutionEnY(280));
        slot1.setBackground(new Color(0, 0, 0, 0));
        slot1.setFocusable(false);
        slot1.setCursor(new Cursor(Cursor.HAND_CURSOR));
        slot1.setBorder(null);

        slot2.setBounds(Fenetre.adapterResolutionEnX(840), Fenetre.adapterResolutionEnY(240), Fenetre.adapterResolutionEnX(240), Fenetre.adapterResolutionEnY(280));
        slot2.setBackground(new Color(0, 0, 0, 0));
        slot2.setFocusable(false);
        slot2.setCursor(new Cursor(Cursor.HAND_CURSOR));
        slot2.setBorder(null);

        slot3.setBounds(Fenetre.adapterResolutionEnX(1338), Fenetre.adapterResolutionEnY(240), Fenetre.adapterResolutionEnX(240), Fenetre.adapterResolutionEnY(280));
        slot3.setBackground(new Color(0, 0, 0, 0));
        slot3.setFocusable(false);
        slot3.setCursor(new Cursor(Cursor.HAND_CURSOR));
        slot3.setBorder(null);

        jouer.setBounds( Fenetre.adapterResolutionEnX(704),  Fenetre.adapterResolutionEnY(792),  Fenetre.adapterResolutionEnX(480), Fenetre.adapterResolutionEnY(90));
        jouer.setBackground(new Color(0, 0, 0, 0));
        jouer.setFocusable(false);
        jouer.setCursor(new Cursor(Cursor.HAND_CURSOR));
        jouer.setBorder(null);

        retour.setBounds(Fenetre.adapterResolutionEnX(64), Fenetre.adapterResolutionEnY(985), Fenetre.adapterResolutionEnX(256), Fenetre.adapterResolutionEnY(41));
        retour.setBackground(new Color(0, 0, 0, 0));
        retour.setFocusable(false);
        retour.setCursor(new Cursor(Cursor.HAND_CURSOR));
        retour.setBorder(null);


        g.drawImage(getToolkit().getImage("images/chargerPartie.png"), 0, 0, getWidth(), getHeight(), this);

        try {
            g.drawImage(Entite.decoupage(ImageIO.read(new File("images/texture_hero1.png")), 3, 11)[1], Fenetre.adapterResolutionEnX(310), Fenetre.adapterResolutionEnY(262), Fenetre.adapterResolutionEnX(Entite.TAILLE_SPRITE_LARGEUR), Fenetre.adapterResolutionEnY(Entite.TAILLE_SPRITE_HAUTEUR), this);
            g.drawImage(Entite.decoupage(ImageIO.read(new File("images/texture_hero2.png")), 3, 11)[1], Fenetre.adapterResolutionEnX(810), Fenetre.adapterResolutionEnY(262), Fenetre.adapterResolutionEnX(Entite.TAILLE_SPRITE_LARGEUR), Fenetre.adapterResolutionEnY(Entite.TAILLE_SPRITE_HAUTEUR), this);
            g.drawImage(Entite.decoupage(ImageIO.read(new File("images/texture_hero3.png")), 3, 11)[1], Fenetre.adapterResolutionEnX(1310), Fenetre.adapterResolutionEnY(262), Fenetre.adapterResolutionEnX(Entite.TAILLE_SPRITE_LARGEUR), Fenetre.adapterResolutionEnY(Entite.TAILLE_SPRITE_HAUTEUR), this);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
