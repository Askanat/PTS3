package vue;

import model.Personnage;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Created by bastien on 02/10/16.
 */

public class Entite extends JPanel {

    public Personnage personnage;

    private BufferedImage[] tableauSprite;
    public Image spriteActuelle;
    private int alternerSprite;

    public Entite(Personnage personnage, String chemin) throws IOException {

        this.personnage = personnage;

        tableauSprite = decoupage(ImageIO.read(new File(chemin)), 3, 4);

        alternerSprite = 0;
        spriteActuelle = tableauSprite[1];
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
            if (spriteActuelle == tableauSprite[6] || spriteActuelle == tableauSprite[8])
                spriteActuelle = tableauSprite[7];
            else if (spriteActuelle == tableauSprite[9] || spriteActuelle == tableauSprite[11])
                spriteActuelle = tableauSprite[10];
            else if (spriteActuelle == tableauSprite[3] || spriteActuelle == tableauSprite[5])
                spriteActuelle = tableauSprite[4];
            else if (spriteActuelle == tableauSprite[0] || spriteActuelle == tableauSprite[2])
                spriteActuelle = tableauSprite[1];

        // selectionne le sens de déplacement
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

        // permet d'alterner les mouvement
        if (x != 0 || y != 0)
            if ((alternerSprite == 0) || (alternerSprite == 1) || (alternerSprite == 2))
                alternerSprite++;

            else if (alternerSprite == 3)
                alternerSprite = 0;
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.drawImage(spriteActuelle, personnage.getPositionX(), personnage.getPositionY(), this);
    }
}
