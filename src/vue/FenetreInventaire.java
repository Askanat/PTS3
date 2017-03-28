package vue;
import controleur.ControlFenetreInventaire;
import model.Equipement;

import javax.swing.*;
import java.awt.*;

import static vue.Fenetre.X;
import static vue.Fenetre.Y;

/**
 * Created by MSI-FlorianV on 30/12/2016.
 */

public class FenetreInventaire extends JPanel {
    // pour bastien : à optimiser
    public JButton retour;
    public JButton[] inventaire;
    public JButton casque, plastron, gant, bague, pantalon, botte, bouclier, arme;

    private Image imageFenetreInventaire;

    public FenetreInventaire() {

        this.setLayout(null);
        this.setPreferredSize(new Dimension(X, Y));

        imageFenetreInventaire = getToolkit().getImage("images/menuInventaire.png");

        boutonInventaire();
        boutonEquipement();

        retour = new JButton();
        retour.setActionCommand("Retour");

        this.add(retour);
    }

    public void boutonInventaire() {
        inventaire = new JButton[30];

        for (int i = 0; i < 30; i++) {
            inventaire[i] = new JButton("" + i);
            inventaire[i].setActionCommand("Inventaire" + i);
            this.add(inventaire[i]);
        }
    }

    public void boutonEquipement() {

        casque = new JButton();
        casque.setActionCommand("Casque");
        this.add(casque);

        plastron = new JButton();
        plastron.setActionCommand("Plastron");
        this.add(plastron);

        gant = new JButton();
        gant.setActionCommand("Gant");
        this.add(gant);

        bague = new JButton();
        bague.setActionCommand("Bague");
        this.add(bague);

        pantalon = new JButton();
        pantalon.setActionCommand("Pantalon");
        this.add(pantalon);

        botte = new JButton();
        botte.setActionCommand("Botte");
        this.add(botte);

        bouclier = new JButton();
        bouclier.setActionCommand("Bouclier");
        this.add(bouclier);

        arme = new JButton();
        arme.setActionCommand("Arme");
        this.add(arme);
    }

    public void setControl(ControlFenetreInventaire controlFenetreInventaire) {
        retour.addActionListener(controlFenetreInventaire);

        //Equipement
        casque.addActionListener(controlFenetreInventaire);
        plastron.addActionListener(controlFenetreInventaire);
        gant.addActionListener(controlFenetreInventaire);
        bague.addActionListener(controlFenetreInventaire);
        pantalon.addActionListener(controlFenetreInventaire);
        botte.addActionListener(controlFenetreInventaire);
        arme.addActionListener(controlFenetreInventaire);
        bouclier.addActionListener(controlFenetreInventaire);

        //Inventaire
        for (int i = 0; i < 30; i++) {
            inventaire[i].addActionListener(controlFenetreInventaire);
            //inventaire[i].setIcon(new ImageIcon(Equipement.getTexture())); C'EST LA
        }
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.drawImage(imageFenetreInventaire, 0, 0, getWidth(), getHeight(), this);

        retour.setBounds(Fenetre.adapterResolutionEnX(40), Fenetre.adapterResolutionEnY(980), Fenetre.adapterResolutionEnX(228), Fenetre.adapterResolutionEnX(40));
        retour.setBackground(new Color(0, 0, 0, 0));
        retour.setFocusable(false);
        retour.setCursor(new Cursor(Cursor.HAND_CURSOR));
        retour.setBorder(null);

        int k = 0;
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 6; j++) {
                inventaire[k].setBounds(Fenetre.adapterResolutionEnX(1104 + (137 * i)), Fenetre.adapterResolutionEnY(157 + (132 * j)), Fenetre.adapterResolutionEnX(129), Fenetre.adapterResolutionEnX(125));
                inventaire[k].setBackground(new Color(0, 0, 0, 0));
                inventaire[k].setFocusable(false);
                inventaire[k].setCursor(new Cursor(Cursor.HAND_CURSOR));
                inventaire[k].setBorder(null);

                k += 1;
            }
        }

        casque.setBounds(Fenetre.adapterResolutionEnX(540), Fenetre.adapterResolutionEnY(215), Fenetre.adapterResolutionEnX(144), Fenetre.adapterResolutionEnX(137));
        casque.setBackground(new Color(0, 0, 0, 0));
        casque.setForeground(Color.RED);
        casque.setFocusable(false);
        casque.setCursor(new Cursor(Cursor.HAND_CURSOR));
        casque.setBorder(null);

        plastron.setBounds(Fenetre.adapterResolutionEnX(540), Fenetre.adapterResolutionEnY(375), Fenetre.adapterResolutionEnX(144), Fenetre.adapterResolutionEnX(138));
        plastron.setBackground(new Color(0, 0, 0, 0));
        plastron.setForeground(Color.RED);
        plastron.setFocusable(false);
        plastron.setCursor(new Cursor(Cursor.HAND_CURSOR));
        plastron.setBorder(null);

        gant.setBounds(Fenetre.adapterResolutionEnX(340), Fenetre.adapterResolutionEnY(456), Fenetre.adapterResolutionEnX(146), Fenetre.adapterResolutionEnX(138));
        gant.setBackground(new Color(0, 0, 0, 0));
        gant.setForeground(Color.RED);
        gant.setFocusable(false);
        gant.setCursor(new Cursor(Cursor.HAND_CURSOR));
        gant.setBorder(null);

        bague.setBounds(Fenetre.adapterResolutionEnX(740), Fenetre.adapterResolutionEnY(456), Fenetre.adapterResolutionEnX(146), Fenetre.adapterResolutionEnX(138));
        bague.setBackground(new Color(0, 0, 0, 0));
        bague.setForeground(Color.RED);
        bague.setFocusable(false);
        bague.setCursor(new Cursor(Cursor.HAND_CURSOR));
        bague.setBorder(null);

        pantalon.setBounds(Fenetre.adapterResolutionEnX(540), Fenetre.adapterResolutionEnY(529), Fenetre.adapterResolutionEnX(144), Fenetre.adapterResolutionEnX(138));
        pantalon.setBackground(new Color(0, 0, 0, 0));
        pantalon.setForeground(Color.RED);
        pantalon.setFocusable(false);
        pantalon.setCursor(new Cursor(Cursor.HAND_CURSOR));
        pantalon.setBorder(null);

        botte.setBounds(Fenetre.adapterResolutionEnX(540), Fenetre.adapterResolutionEnY(759), Fenetre.adapterResolutionEnX(145), Fenetre.adapterResolutionEnX(138));
        botte.setBackground(new Color(0, 0, 0, 0));
        botte.setForeground(Color.RED);
        botte.setFocusable(false);
        botte.setCursor(new Cursor(Cursor.HAND_CURSOR));
        botte.setBorder(null);

        bouclier.setBounds(Fenetre.adapterResolutionEnX(792), Fenetre.adapterResolutionEnY(724), Fenetre.adapterResolutionEnX(145), Fenetre.adapterResolutionEnX(138));
        bouclier.setBackground(new Color(0, 0, 0, 0));
        bouclier.setForeground(Color.RED);
        bouclier.setFocusable(false);
        bouclier.setCursor(new Cursor(Cursor.HAND_CURSOR));
        bouclier.setBorder(null);

        arme.setBounds(Fenetre.adapterResolutionEnX(290), Fenetre.adapterResolutionEnY(724), Fenetre.adapterResolutionEnX(145), Fenetre.adapterResolutionEnX(138));
        arme.setBackground(new Color(0, 0, 0, 0));
        arme.setForeground(Color.RED);
        arme.setFocusable(false);
        arme.setCursor(new Cursor(Cursor.HAND_CURSOR));
        arme.setBorder(null);
    }

}
