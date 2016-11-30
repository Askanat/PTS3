package vue;

import model.Direction;
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
    public static final int TAILLE_SPRITE_HAUTEUR = 300;
    public static final int TAILLE_SPRITE_LARGEUR = 300;
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

    public void selectionnerMorceauSpriteDeplacement() {

        if (!personnage.getDeplacement() && personnage.getCollision()) { // remet en place les pieds
            if (spriteActuel == tableauSprite[0])
                spriteActuel = tableauSprite[3];
            else if (spriteActuel == tableauSprite[2])
                spriteActuel = tableauSprite[8];
            else if (personnage.getDirection() == Direction.DROITE)
                spriteActuel = tableauSprite[7];
            else if (personnage.getDirection() == Direction.GAUCHE)
                spriteActuel = tableauSprite[4];
            alternerSpriteDeplacement = 1;
        }

        // selectionne le saut
        if (!personnage.getCollision()) {
            if (!personnage.getAttaquer()) { // saut sans attaque
                if (personnage.getDirection() == Direction.DROITE)
                    spriteActuel = tableauSprite[2];
                else if (personnage.getDirection() == Direction.GAUCHE)
                    spriteActuel = tableauSprite[0];
            } else if (personnage.getAttaquer()) { // saut avec attaque
                if (personnage.getDirection() == Direction.DROITE) {
                    spriteActuel = tableauSprite[alternerSpriteAttaque == 3 ? 7 : 30 + alternerSpriteAttaque];
                    if (alternerSpriteAttaque == 3) {
                        alternerSpriteAttaque = 0;
                        personnage.setAttaquer(false);
                    }
                } else if (personnage.getDirection() == Direction.GAUCHE) {
                    spriteActuel = tableauSprite[alternerSpriteAttaque == 3 ? 4 : 27 + alternerSpriteAttaque];
                    if (alternerSpriteAttaque == 3) {
                        alternerSpriteAttaque = 0;
                        personnage.setAttaquer(false);
                    }
                }
            }

            // selectionne le déplacement de droite et de gauche
        } else if (personnage.getCollision()) {
            if (!personnage.getAttaquer() && personnage.getDeplacement()) { // deplacement sans attaque
                if (personnage.getDirection() == Direction.DROITE)
                    spriteActuel = tableauSprite[alternerSpriteDeplacement == 3 ? 7 : 6 + alternerSpriteDeplacement];
                else if (personnage.getDirection() == Direction.GAUCHE)
                    spriteActuel = tableauSprite[alternerSpriteDeplacement == 3 ? 4 : 3 + alternerSpriteDeplacement];
            } else if (personnage.getAttaquer()) { // attaque
                if (personnage.getDirection() == Direction.DROITE) {
                    switch (alternerSpriteAttaque) {
                        case 0:
                            spriteActuel = tableauSprite[alternerSpriteDeplacement == 3 ? 19 : 18 + alternerSpriteDeplacement];
                            break;
                        case 1:
                            spriteActuel = tableauSprite[alternerSpriteDeplacement == 3 ? 22 : 21 + alternerSpriteDeplacement];
                            break;
                        case 2:
                            spriteActuel = tableauSprite[alternerSpriteDeplacement == 3 ? 25 : 24 + alternerSpriteDeplacement];
                            break;
                        case 3:
                            spriteActuel = tableauSprite[7];
                            alternerSpriteAttaque = 0;
                            personnage.setAttaquer(false);
                            break;
                    }
                } else if (personnage.getDirection() == Direction.GAUCHE) {
                    switch (alternerSpriteAttaque) {
                        case 0:
                            spriteActuel = tableauSprite[alternerSpriteDeplacement == 3 ? 10 : 9 + alternerSpriteDeplacement];
                            break;
                        case 1:
                            spriteActuel = tableauSprite[alternerSpriteDeplacement == 3 ? 13 : 12 + alternerSpriteDeplacement];
                            break;
                        case 2:
                            spriteActuel = tableauSprite[alternerSpriteDeplacement == 3 ? 16 : 15 + alternerSpriteDeplacement];
                            break;
                        case 3:
                            spriteActuel = tableauSprite[4];
                            alternerSpriteAttaque = 0;
                            personnage.setAttaquer(false);
                            break;
                    }
                }
            }
        }

        // permet d'alterner les mouvements de deplacement
        if (personnage.getDeplacement())
            alternerSpriteDeplacement = alternerSpriteDeplacement == 3 ? 0 : alternerSpriteDeplacement + 1;

        // permet d'alterner les mouvements de dégats
        if (personnage.getAttaquer())
            alternerSpriteAttaque = alternerSpriteAttaque == 3 ? 0 : alternerSpriteAttaque + 1;
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(spriteActuel, personnage.getPositionX()-Fenetre.adapterResolutionEnX(TAILLE_SPRITE_LARGEUR/2), personnage.getPositionY()-Fenetre.adapterResolutionEnY(TAILLE_SPRITE_HAUTEUR), Fenetre.adapterResolutionEnX(TAILLE_SPRITE_LARGEUR), Fenetre.adapterResolutionEnY(TAILLE_SPRITE_HAUTEUR), this);
    }

    public int getSpriteWidth() {
        return tableauSprite[0].getWidth();
    }

    public int getSpriteHeight() {
        return tableauSprite[0].getHeight();
    }
}