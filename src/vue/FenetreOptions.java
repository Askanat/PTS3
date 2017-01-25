package vue;

import controleur.ControlFenetreOptions;
import controleur.ControlTouche;
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
    ControlTouche controlTouche;
    public JButton retour, hitBox;
    public JButton[] controlButton;

    private Image imageFenetreOption;
    private Font f, fControlTouche;

    public FenetreOptions(Jeu jeu, ControlTouche controlTouche) {
        this.controlTouche = controlTouche;
        this.jeu = jeu;

        this.setLayout(null);
        this.setPreferredSize(new Dimension(X, Y));

        imageFenetreOption = getToolkit().getImage("images/menuOptionsTest.png");
        f = new Font("Arial", Font.BOLD, Fenetre.adapterResolutionEnX(20));
        fControlTouche = new Font("Arial", Font.BOLD, Fenetre.adapterResolutionEnX(35));

        retour = new JButton("");
        retour.setActionCommand("Retour");
        hitBox = new JButton("Hitbox");
        hitBox.setActionCommand("Hitbox");

        controlButton = new JButton[controlTouche.getNbActions() - 1];
        String[] repAction = new String[]{"Avancer", "Sauter", "Attaquer", "Reculer"};

        for(int i = 0; i < controlButton.length; i++) {
            controlButton[i] = new JButton(controlTouche.getNomTouche(i + 1));
            controlButton[i].setActionCommand(repAction[i]);
        }

        this.add(retour);
        this.add(hitBox);

        for(JButton b: controlButton)
            this.add(b);
    }

    public void setControl(ControlFenetreOptions controlFenetreOptions) {
        retour.addActionListener(controlFenetreOptions);
        hitBox.addActionListener(controlFenetreOptions);

        for(JButton b: controlButton) {
            b.addActionListener(controlFenetreOptions);
            b.addKeyListener(controlFenetreOptions);
        }
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.drawImage(imageFenetreOption, 0, 0, getWidth(), getHeight(), this);

        retour.setBounds(Fenetre.adapterResolutionEnX(40), Fenetre.adapterResolutionEnY(980), Fenetre.adapterResolutionEnX(228), Fenetre.adapterResolutionEnX(40));
        retour.setBackground(new Color(0, 0, 0, 0));
        retour.setFocusable(false);
        retour.setBorder(null);

        hitBox.setBounds(Fenetre.adapterResolutionEnX(1285), Fenetre.adapterResolutionEnY(300), Fenetre.adapterResolutionEnX(228), Fenetre.adapterResolutionEnX(40));
        hitBox.setBackground(new Color(0, 0, 0, 0));
        hitBox.setFont(f);
        if (!jeu.getHitBox())
            hitBox.setForeground(Color.RED);
        else
            hitBox.setForeground(Color.GREEN);

        hitBox.setFocusable(false);
        hitBox.setBorder(null);

        int x = 600, y = 355;

        for(JButton b: controlButton) {
            b.setBounds(Fenetre.adapterResolutionEnX(x), Fenetre.adapterResolutionEnY(y), Fenetre.adapterResolutionEnX(270), Fenetre.adapterResolutionEnY(55));
            b.setBackground(new Color(0, 0, 0, 0));
            b.setFont(fControlTouche);
            b.setBorder(null);

            y += 70;
        }
    }
}
