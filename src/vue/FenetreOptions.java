package vue;

import controleur.ControlFenetreOptions;
import model.Jeu;

import javax.swing.*;
import java.awt.*;

import static vue.Fenetre.X;
import static vue.Fenetre.Y;

/**
 * Created by bastien on 14/10/16.
 */

public class FenetreOptions extends JPanel {

    Jeu jeu;
    public JButton retour, hitBox;
    private JLabel options, texte;
    public JTextField avancer, sauter, attaquer, reculer;

    public FenetreOptions(Jeu jeu) {
        this.jeu = jeu;
        this.setLayout(null);
        setPreferredSize(new Dimension(X, Y));

        retour = new JButton("");
        retour.setActionCommand("Retour");
        hitBox = new JButton("Hitbox");
        hitBox.setActionCommand("Hitbox");
        avancer = new JTextField("");
        avancer.setActionCommand("Avancer");
        sauter = new JTextField("");
        sauter.setActionCommand("Sauter");
        attaquer = new JTextField("");
        attaquer.setActionCommand("Attaquer");
        reculer = new JTextField("");
        reculer.setActionCommand("Reculer");

        add(retour);
        add(hitBox);
        add(avancer);
        add(sauter);
        add(attaquer);
        add(reculer);
    }

    public void setControl(ControlFenetreOptions controlFenetreOptions) {
        retour.addActionListener(controlFenetreOptions);
        hitBox.addActionListener(controlFenetreOptions);
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Font f=new Font("Arial", Font.BOLD, 20);

        retour.setBounds(Fenetre.adapterResolutionEnX(40), Fenetre.adapterResolutionEnY(980), Fenetre.adapterResolutionEnX(228), Fenetre.adapterResolutionEnX(40));
        retour.setBackground(new Color(0, 0, 0, 0));
        retour.setFocusable(false);
        retour.setBorder(null);

        hitBox.setBounds(Fenetre.adapterResolutionEnX(300), Fenetre.adapterResolutionEnY(980), Fenetre.adapterResolutionEnX(228), Fenetre.adapterResolutionEnX(40));
        hitBox.setBackground(new Color(0, 0, 0, 0));
        hitBox.setFont(f);
        if(!jeu.getHitBox()) {
            hitBox.setForeground(Color.RED);
        }else{
            hitBox.setForeground(Color.GREEN);
        }
        hitBox.setFocusable(false);
        hitBox.setBorder(null);

        avancer.setBounds(Fenetre.adapterResolutionEnX(289), Fenetre.adapterResolutionEnY(92), Fenetre.adapterResolutionEnX(378), Fenetre.adapterResolutionEnY(55));
        avancer.setBackground(new Color(0, 0, 0, 0));
        avancer.setFocusable(false);
        avancer.setBorder(null);

        sauter.setBounds(Fenetre.adapterResolutionEnX(289), Fenetre.adapterResolutionEnY(160), Fenetre.adapterResolutionEnX(378), Fenetre.adapterResolutionEnY(54));
        sauter.setBackground(new Color(0, 0, 0, 0));
        sauter.setFocusable(false);
        sauter.setBorder(null);

        attaquer.setBounds(Fenetre.adapterResolutionEnX(289), Fenetre.adapterResolutionEnY(227), Fenetre.adapterResolutionEnX(378), Fenetre.adapterResolutionEnY(55));
        attaquer.setBackground(new Color(0, 0, 0, 0));
        attaquer.setFocusable(false);
        attaquer.setBorder(null);

        reculer.setBounds(Fenetre.adapterResolutionEnX(289), Fenetre.adapterResolutionEnY(293), Fenetre.adapterResolutionEnX(379), Fenetre.adapterResolutionEnY(55));
        reculer.setBackground(new Color(0, 0, 0, 0));
        reculer.setFocusable(false);
        reculer.setBorder(null);

        Image img = getToolkit().getImage("images/menuOptionsTest.png");
        g.drawImage(img, 0, 0, getWidth(), getHeight(), this);
    }
}
