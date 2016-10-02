package model;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Created by bastien on 29/09/16.
 */

public class Hero extends Personnage {

    private BufferedImage[] tableauSprite;
    public static Image spriteActuelle;
    private int alternerSprite;

    public Hero(String nom, int vie, int vieMax, int degats, int positionX, int positionY, Image texture) throws IOException {
        super(nom, vie, vieMax, degats, positionX, positionY, texture);
        tableauSprite = decoupage(ImageIO.read(new File("images/test3.png")), 3, 4);

        alternerSprite = 0;

    }

    public void deplacer(int deplacementX, int deplacementY) {
        setPositionX(getPositionX() + deplacementX);
        setPositionY(getPositionY() + deplacementY);
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

    public void selectionnerMorceauSpriteDeplacement(int x, int y) {
        if (x > 0)
            switch (alternerSprite) {
                case 0:
                    spriteActuelle = tableauSprite[6];
                    break;

                case 1:
                    spriteActuelle = tableauSprite[7];
                    break;

                case 2:
                    spriteActuelle = tableauSprite[8];
                    break;

                case 3:
                    spriteActuelle = tableauSprite[7];
                    break;
            }
        else if (y < 0)
            switch (alternerSprite) {
                case 0:
                    spriteActuelle = tableauSprite[9];
                    break;

                case 1:
                    spriteActuelle = tableauSprite[10];
                    break;

                case 2:
                    spriteActuelle = tableauSprite[11];
                    break;

                case 3:
                    spriteActuelle = tableauSprite[10];
                    break;
            }
        else if (x < 0)
            switch (alternerSprite) {
                case 0:
                    spriteActuelle = tableauSprite[3];
                    break;

                case 1:
                    spriteActuelle = tableauSprite[4];
                    break;

                case 2:
                    spriteActuelle = tableauSprite[5];
                    break;

                case 3:
                    spriteActuelle = tableauSprite[4];
                    break;
            }
        else if (y > 0)
            switch (alternerSprite) {
                case 0:
                    spriteActuelle = tableauSprite[0];
                    break;

                case 1:
                    spriteActuelle = tableauSprite[1];
                    break;

                case 2:
                    spriteActuelle = tableauSprite[2];
                    break;

                case 3:
                    spriteActuelle = tableauSprite[1];
                    break;
            }

        if (x != 0 && y != 0)
            if ((alternerSprite == 0) ||(alternerSprite == 1) ||(alternerSprite == 2))
                alternerSprite++;

            else if (alternerSprite == 3)
                alternerSprite = 0;

    }
}