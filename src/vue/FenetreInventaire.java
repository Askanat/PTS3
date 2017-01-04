package vue;

import com.sun.org.apache.regexp.internal.RE;
import controleur.ControlFenetreInventaire;

import javax.swing.*;
import java.awt.*;

import static vue.Fenetre.X;
import static vue.Fenetre.Y;

/**
 * Created by MSI-FlorianV on 30/12/2016.
 */
public class FenetreInventaire extends JPanel {

    public JButton retour;
    public JButton[] inventaire;
    public JButton casque, plastron, gant, bague, pantalon, botte, bouclier, arme;

    public FenetreInventaire() {

        this.setLayout(null);
        setPreferredSize(new Dimension(X, Y));

        boutonInventaire();

        retour = new JButton("");
        retour.setActionCommand("Retour");

        add(retour);
    }

    public void boutonInventaire(){
        inventaire = new JButton[30];

        for (int i = 0; i < 30; i++ )
        {
            inventaire[i] = new JButton();
            inventaire[i].setActionCommand("inventaire"+i);
            add(inventaire[i]);
        }
    }

    public void boutonEquipement(){

        casque = new JButton("");
        casque.setActionCommand("Retour");
        add(casque);

        plastron = new JButton("");
        plastron.setActionCommand("Retour");
        add(plastron);

        gant = new JButton("");
        gant.setActionCommand("Retour");
        add(gant);

        bague = new JButton("");
        bague.setActionCommand("Retour");
        add(bague);

        pantalon = new JButton("");
        pantalon.setActionCommand("Retour");
        add(pantalon);

        botte = new JButton("");
        botte.setActionCommand("Retour");
        add(botte);

        bouclier = new JButton("");
        bouclier.setActionCommand("Retour");
        add(bouclier);

        arme = new JButton("");
        arme.setActionCommand("Retour");
        add(arme);
    }

    public void setControl(ControlFenetreInventaire controlFenetreInventaire) {
        retour.addActionListener(controlFenetreInventaire);
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Font f=new Font("Arial", Font.BOLD, 18);

        retour.setBounds(Fenetre.adapterResolutionEnX(40), Fenetre.adapterResolutionEnY(980), Fenetre.adapterResolutionEnX(228), Fenetre.adapterResolutionEnX(40));
        retour.setBackground(new Color(0, 0, 0, 0));
        retour.setFocusable(false);
        retour.setCursor(new Cursor(Cursor.HAND_CURSOR));
        retour.setBorder(null);

        int k = 0;
        for (int i = 0; i < 5; i++) {
            for(int j = 0; j < 6; j++) {
                inventaire[k].setBounds(Fenetre.adapterResolutionEnX(1104 + (137 * i)), Fenetre.adapterResolutionEnY(157 + (132 * j)), Fenetre.adapterResolutionEnX(129), Fenetre.adapterResolutionEnX(125));
                inventaire[k].setBackground(new Color(0, 0, 0, 0));
                inventaire[k].setFocusable(false);
                inventaire[k].setCursor(new Cursor(Cursor.HAND_CURSOR));
                inventaire[k].setBorder(null);

                k += 1;
            }
        }

        Image img = getToolkit().getImage("images/menuInventaire.png");
        g.drawImage(img, 0, 0, getWidth(), getHeight(), this);
    }

}
