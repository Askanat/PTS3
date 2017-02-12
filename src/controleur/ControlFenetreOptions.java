package controleur;

import model.Jeu;
import vue.Fenetre;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Created by bastien on 14/10/16.
 */

public class ControlFenetreOptions extends Control implements ActionListener, KeyListener {
    private ControlClavier controlClavier;
    private boolean[] toucheSelectionne;


    public ControlFenetreOptions(Jeu jeu, Fenetre fenetre, ControlClavier controlClavier) {
        super(jeu, fenetre);
        fenetre.setControlFenetreOptions(this);

        this.controlClavier = controlClavier;
        this.toucheSelectionne = new boolean[controlClavier.getControlTouche().getNbActions() - 1];

        setTouchesSelectionneesToFalse();
    }

    private void setTouchesSelectionneesToFalse() {
        for(int i = 0; i < toucheSelectionne.length; i++)
            toucheSelectionne[i] = false;
    }

    private int getNumToucheSelectionneTrue()  {
        for(int i = 0; i < toucheSelectionne.length; i++) {
            if(toucheSelectionne[i])
                return i;
        }

        System.out.println();
        return -1;
    }

    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "Hitbox":
                if (!jeu.getEtat().getHitBox()) {
                    jeu.getEtat().setHitBox(true);
                    fenetre.panelFenetreOptions.hitBox.setForeground(Color.GREEN);
                    changerVue();
                } else {
                    jeu.getEtat().setHitBox(false);
                    fenetre.panelFenetreOptions.hitBox.setForeground(Color.RED);
                    changerVue();
                }
                break;

            case "Retour":
                if (!jeu.getEtat().getPause()) {
                    fenetre.setContentPane(fenetre.panelMenuPrincipal);
                    changerVue();
                } else {
                    Control.enPartie = true;
                    fenetre.setContentPane(fenetre.panelScrollFenetreJeu);
                    changerVue();
                    fenetre.vueMenuEnJeu();
                }
                break;
            case "Avancer":
                setTouchesSelectionneesToFalse();
                toucheSelectionne[ControlTouche.ACTION_DROITE - 1] = true;
                break;
            case "Reculer":
                setTouchesSelectionneesToFalse();
                toucheSelectionne[ControlTouche.ACTION_GAUCHE - 1] = true;
                break;
            case "Sauter":
                setTouchesSelectionneesToFalse();
                toucheSelectionne[ControlTouche.ACTION_SAUT - 1] = true;
                break;
            case "Attaquer":
                setTouchesSelectionneesToFalse();
                toucheSelectionne[ControlTouche.ACTION_ATTAQUE - 1] = true;
                break;
            case "Sort1":
                setTouchesSelectionneesToFalse();
                toucheSelectionne[ControlTouche.ACTION_SORT1 - 1] = true;
                break;
            case "Sort2":
                setTouchesSelectionneesToFalse();
                toucheSelectionne[ControlTouche.ACTION_SORT2 - 1] = true;
                break;
            case "Sort3":
                setTouchesSelectionneesToFalse();
                toucheSelectionne[ControlTouche.ACTION_SORT3 - 1] = true;
                break;
            case "Sort4":
                setTouchesSelectionneesToFalse();
                toucheSelectionne[ControlTouche.ACTION_SORT4 - 1] = true;
                break;
            case "Sort5":
                setTouchesSelectionneesToFalse();
                toucheSelectionne[ControlTouche.ACTION_SORT5 - 1] = true;
                break;
            case "Sort6":
                setTouchesSelectionneesToFalse();
                toucheSelectionne[ControlTouche.ACTION_SORT6 - 1] = true;
                break;
            case "Sort7":
                setTouchesSelectionneesToFalse();
                toucheSelectionne[ControlTouche.ACTION_SORT7 - 1] = true;
                break;
            case "Sort8":
                setTouchesSelectionneesToFalse();
                toucheSelectionne[ControlTouche.ACTION_SORT8 - 1] = true;
                break;
        }
    }

    @Override
    public void keyTyped(KeyEvent keyEvent) {

    }

    @Override
    public void keyPressed(KeyEvent keyEvent) {
        int key;
        if((key = keyEvent.getKeyCode()) != keyEvent.VK_ESCAPE) {
            int index = getNumToucheSelectionneTrue() - 1, actionConcernee;

            if(index < 0)
                index = ControlTouche.ACTION_ATTAQUE - 1;
            else if(index >= 3)
                index++;

            actionConcernee = index + 1;

            toucheSelectionne[index] = false;
            controlClavier.getControlTouche().setActionTouche(actionConcernee, key);

            System.out.println(controlClavier.getControlTouche().getNomTouche(actionConcernee));

            fenetre.panelFenetreOptions.controlButton[index].
                    setText(controlClavier.getControlTouche().getNomTouche(actionConcernee));
        }
    }

    @Override
    public void keyReleased(KeyEvent keyEvent) {

    }
}
