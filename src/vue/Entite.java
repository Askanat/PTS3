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
    private int alternerSprite;

    public Entite() {

        alternerSprite = 0;
    }

    public void creationEntite(Personnage personnage, String chemin) {

        this.personnage = personnage;

        try {
            tableauSprite = decoupage(ImageIO.read(new File(chemin)), 3, 5);
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

        // selectionne le sens de déplacement
        if (!personnage.getCollision())
            if (x > 0 || (spriteActuel == tableauSprite[6] || spriteActuel == tableauSprite[7] || spriteActuel == tableauSprite[8]))
                spriteActuel = tableauSprite[2];
            else if (x < 0 || (spriteActuel == tableauSprite[3] || spriteActuel == tableauSprite[4] || spriteActuel == tableauSprite[5]))
                spriteActuel = tableauSprite[0];

        // permet le déplacement de droite et de gauche
        if (personnage.getCollision())
            if (x > 0 || personnage.getDirection() == Direction.DROITE)
                switch (alternerSprite) {
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
            else if (x < 0 || personnage.getDirection() == Direction.GAUCHE)
                switch (alternerSprite) {
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
                alternerSprite++;
            } else if (spriteActuel == tableauSprite[2]) {
                spriteActuel = tableauSprite[8];
                alternerSprite--;
            }

        // permet d'attaquer
        if (personnage.getAttaquer()) {
            if (personnage.getDirection() == Direction.GAUCHE) {
                switch (alternerSprite) {
                    case 0:
                        spriteActuel = tableauSprite[9];
                        break;

                    case 1:
                        spriteActuel = tableauSprite[10];
                        break;

                    case 2:
                        spriteActuel = tableauSprite[11];
                        break;

                    case 3:
                        spriteActuel = tableauSprite[4];
                        personnage.setAttaquer(false);
                        break;
                }
            } else if (personnage.getDirection() == Direction.DROITE) {
                switch (alternerSprite) {
                    case 0:
                        spriteActuel = tableauSprite[12];
                        break;

                    case 1:
                        spriteActuel = tableauSprite[13];
                        break;

                    case 2:
                        spriteActuel = tableauSprite[14];
                        break;

                    case 3:
                        spriteActuel = tableauSprite[7];
                        personnage.setAttaquer(false);
                        break;
                }
            }
        }

        // permet d'alterner les mouvement
        if (x != 0 || personnage.getAttaquer()) {
            alternerSprite++;

            if (alternerSprite == 4)
                alternerSprite = 0;
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

    public void setAlternerSprite(int alternerSprite) {
        this.alternerSprite = alternerSprite;
    }
}