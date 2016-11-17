package vue;

import model.Direction;
import model.Personnage;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import static model.Jeu.X;
import static model.Jeu.Y;

/**
 * Created by bastien on 02/10/16.
 */

public class Entite extends JPanel {

    public Personnage personnage;

    private BufferedImage[] tableauSprite;
    public Image spriteActuel;
    private int alternerSpriteDeplacement, alternerSpriteAttaque;

    public Entite() {

        alternerSpriteDeplacement = 0;
    }

    public void creationEntite(Personnage personnage, String chemin) {

        this.personnage = personnage;

        try {
            tableauSprite = decoupage(ImageIO.read(new File(chemin)), 3, 11);
        } catch (IOException e) {
            e.printStackTrace();
        }

        spriteActuel = tableauSprite[1];
    }

    public static BufferedImage[] decoupage(BufferedImage origin, int divisionHorizontale, int divisionVerticale) {
        BufferedImage tab[] = new BufferedImage[divisionHorizontale * divisionVerticale];
        int tailleBaseHeight = origin.getHeight() / divisionVerticale;
        int tailleBaseWidth = origin.getWidth() / divisionHorizontale;
        int k = 0;
        for (int i = 0; i < divisionVerticale; i++) {
            for (int j = 0; j < divisionHorizontale; j++) {
                tab[k] = origin.getSubimage(j * tailleBaseWidth, i * tailleBaseHeight, tailleBaseWidth, tailleBaseHeight);
                k++;
            }
        }

        return tab;
    }

    public void selectionnerMorceauSpriteDeplacement(int x) {

        // remet le sprite sur ses 2 jambes quand il ne bouge pas
        if (x == 0 && personnage.getCollision())
            if (spriteActuel == tableauSprite[6] || spriteActuel == tableauSprite[8])
                spriteActuel = tableauSprite[7];
            else if (spriteActuel == tableauSprite[3] || spriteActuel == tableauSprite[5])
                spriteActuel = tableauSprite[4];

        // selectionne le saut
        if (!personnage.getCollision()) {
            if (!personnage.getAttaquer()) {
                if (personnage.getDirection() == Direction.DROITE)
                    spriteActuel = tableauSprite[2];
                else if (personnage.getDirection() == Direction.GAUCHE)
                    spriteActuel = tableauSprite[0];
            } else if (personnage.getAttaquer()) {
                if (personnage.getDirection() == Direction.DROITE)
                    switch (alternerSpriteAttaque) {
                        case 0:
                            spriteActuel = tableauSprite[30];
                            break;

                        case 1:
                            spriteActuel = tableauSprite[31];
                            break;

                        case 2:
                            spriteActuel = tableauSprite[32];
                            break;

                        case 3:
                            spriteActuel = tableauSprite[7];
                            personnage.setAttaquer(false);
                            break;
                    }
                else if (personnage.getDirection() == Direction.GAUCHE)
                    switch (alternerSpriteAttaque) {
                        case 0:
                            spriteActuel = tableauSprite[27];
                            break;

                        case 1:
                            spriteActuel = tableauSprite[28];
                            break;

                        case 2:
                            spriteActuel = tableauSprite[29];
                            break;

                        case 3:
                            spriteActuel = tableauSprite[4];
                            personnage.setAttaquer(false);
                            break;
                    }
            }

            // permet le déplacement de droite et de gauche
        } else if (personnage.getCollision()) {
            if (!personnage.getAttaquer()) {
                if (x > 0)
                    switch (alternerSpriteDeplacement) {
                        case 0:
                            spriteActuel = tableauSprite[6];
                            break;

                        case 1:
                            spriteActuel = tableauSprite[7];
                            break;

                        case 2:
                            spriteActuel = tableauSprite[8];
                            break;

                        case 3:
                            spriteActuel = tableauSprite[7];
                            break;
                    }
                else if (x < 0)
                    switch (alternerSpriteDeplacement) {
                        case 0:
                            spriteActuel = tableauSprite[3];
                            break;

                        case 1:
                            spriteActuel = tableauSprite[4];
                            break;

                        case 2:
                            spriteActuel = tableauSprite[5];
                            break;

                        case 3:
                            spriteActuel = tableauSprite[4];
                            break;
                    }

                    // permet la remise en place des pieds à l'aterrisage après le saut
                else if (spriteActuel == tableauSprite[0]) {
                    spriteActuel = tableauSprite[3];
                    alternerSpriteDeplacement++;
                } else if (spriteActuel == tableauSprite[2]) {
                    spriteActuel = tableauSprite[8];
                    alternerSpriteDeplacement--;
                }
            }

            // permet d'attaquer
            else if (personnage.getAttaquer()) {

                if (x > 0 || personnage.getDirection() == Direction.DROITE)
                    switch (alternerSpriteDeplacement) {
                        case 0:
                            switch (alternerSpriteAttaque) {
                                case 0:
                                    spriteActuel = tableauSprite[18];
                                    break;

                                case 1:
                                    spriteActuel = tableauSprite[21];
                                    break;

                                case 2:
                                    spriteActuel = tableauSprite[24];
                                    break;

                                case 3:
                                    spriteActuel = tableauSprite[7];
                                    personnage.setAttaquer(false);
                                    break;
                            }
                            break;

                        case 1:
                            switch (alternerSpriteAttaque) {
                                case 0:
                                    spriteActuel = tableauSprite[19];
                                    break;

                                case 1:
                                    spriteActuel = tableauSprite[22];
                                    break;

                                case 2:
                                    spriteActuel = tableauSprite[25];
                                    break;

                                case 3:
                                    spriteActuel = tableauSprite[7];
                                    personnage.setAttaquer(false);
                                    break;
                            }
                            break;

                        case 2:
                            switch (alternerSpriteAttaque) {
                                case 0:
                                    spriteActuel = tableauSprite[20];
                                    break;

                                case 1:
                                    spriteActuel = tableauSprite[23];
                                    break;

                                case 2:
                                    spriteActuel = tableauSprite[26];
                                    break;

                                case 3:
                                    spriteActuel = tableauSprite[7];
                                    personnage.setAttaquer(false);
                                    break;
                            }
                            break;

                        case 3:
                            switch (alternerSpriteAttaque) {
                                case 0:
                                    spriteActuel = tableauSprite[19];
                                    break;

                                case 1:
                                    spriteActuel = tableauSprite[22];
                                    break;

                                case 2:
                                    spriteActuel = tableauSprite[25];
                                    break;

                                case 3:
                                    spriteActuel = tableauSprite[7];
                                    personnage.setAttaquer(false);
                                    break;
                            }
                            break;
                    }
                else if (x < 0 || personnage.getDirection() == Direction.GAUCHE)
                    switch (alternerSpriteDeplacement) {
                        case 0:
                            switch (alternerSpriteAttaque) {
                                case 0:
                                    spriteActuel = tableauSprite[9];
                                    break;

                                case 1:
                                    spriteActuel = tableauSprite[12];
                                    break;

                                case 2:
                                    spriteActuel = tableauSprite[15];
                                    break;

                                case 3:
                                    spriteActuel = tableauSprite[4];
                                    personnage.setAttaquer(false);
                                    break;
                            }
                            break;

                        case 1:
                            switch (alternerSpriteAttaque) {
                                case 0:
                                    spriteActuel = tableauSprite[10];
                                    break;

                                case 1:
                                    spriteActuel = tableauSprite[13];
                                    break;

                                case 2:
                                    spriteActuel = tableauSprite[16];
                                    break;

                                case 3:
                                    spriteActuel = tableauSprite[4];
                                    personnage.setAttaquer(false);
                                    break;
                            }
                            break;

                        case 2:
                            switch (alternerSpriteAttaque) {
                                case 0:
                                    spriteActuel = tableauSprite[11];
                                    break;

                                case 1:
                                    spriteActuel = tableauSprite[14];
                                    break;

                                case 2:
                                    spriteActuel = tableauSprite[17];
                                    break;

                                case 3:
                                    spriteActuel = tableauSprite[4];
                                    personnage.setAttaquer(false);
                                    break;
                            }
                            break;

                        case 3:
                            switch (alternerSpriteAttaque) {
                                case 0:
                                    spriteActuel = tableauSprite[10];
                                    break;

                                case 1:
                                    spriteActuel = tableauSprite[13];
                                    break;

                                case 2:
                                    spriteActuel = tableauSprite[16];
                                    break;

                                case 3:
                                    spriteActuel = tableauSprite[4];
                                    personnage.setAttaquer(false);
                                    break;
                            }
                            break;
                    }
            }
        }


        // permet d'alterner les mouvements de deplacement
        if (x != 0) {
            alternerSpriteDeplacement++;

            if (alternerSpriteDeplacement == 4)
                alternerSpriteDeplacement = 0;
        }

        // permet d'alterner les mouvements de dégats
        if (personnage.getAttaquer()) {
            alternerSpriteAttaque++;

            if (alternerSpriteAttaque == 4)
                alternerSpriteAttaque = 0;
        }
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(spriteActuel, personnage.getPositionX(), personnage.getPositionY(), (int) (5 / 48.0 * X), (int) (5 / 27.0 * Y), this);
    }

    public int getSpriteWidth() {
        return tableauSprite[0].getWidth();
    }

    public int getSpriteHeight() {
        return tableauSprite[0].getHeight();
    }

    public void setAlternerSpriteAttaque(int alternerSpriteAttaque) {
        this.alternerSpriteAttaque = alternerSpriteAttaque;
    }
}