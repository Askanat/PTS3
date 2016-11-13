package vue;

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
            tableauSprite = decoupage(ImageIO.read(new File(chemin)), 3, 4);
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

    public void selectionnerMorceauSpriteDeplacement(int x, int y) {

        // remet le sprite sur ses 2 jambes quand il ne bouge pas
        if (x == 0 && y == 0)
            if (spriteActuel == tableauSprite[6] || spriteActuel == tableauSprite[8])
                spriteActuel = tableauSprite[7];
            else if (spriteActuel == tableauSprite[3] || spriteActuel == tableauSprite[5])
                spriteActuel = tableauSprite[4];

        // selectionne le sens de déplacement
        if (!personnage.getCollision() && (x > 0 || (spriteActuel == tableauSprite[6] || spriteActuel == tableauSprite[7] || spriteActuel == tableauSprite[8])))
            spriteActuel = tableauSprite[2];
        else if (x > 0 && personnage.getCollision())
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

        else if (!personnage.getCollision() && (x > 0 || (spriteActuel == tableauSprite[3] || spriteActuel == tableauSprite[4] || spriteActuel == tableauSprite[5])))
            spriteActuel = tableauSprite[0];
        else if (x < 0 && personnage.getCollision())
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

        else if (personnage.getCollision() && spriteActuel == tableauSprite[0]) {
            spriteActuel = tableauSprite[3];
            alternerSprite++;
        } else if (personnage.getCollision() && spriteActuel == tableauSprite[2]) {
            spriteActuel = tableauSprite[8];
            alternerSprite--;
        }


        // permet d'alterner les mouvement
        if (x != 0)
            if ((alternerSprite == 0) || (alternerSprite == 1) || (alternerSprite == 2))
                alternerSprite++;

            else if (alternerSprite == 3)
                alternerSprite = 0;
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
}