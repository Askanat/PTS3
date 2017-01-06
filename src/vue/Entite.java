package vue;

import model.Direction;
import model.Monstre;
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
    public static final int TAILLE_SPRITE_HAUTEUR = Fenetre.adapterResolutionEnY(300);
    public static final int TAILLE_SPRITE_LARGEUR = Fenetre.adapterResolutionEnX(300);
    private BufferedImage[] tableauSprite;
    public Image spriteActuel;
    private int alternerSpriteDeplacement, alternerSpriteAttaque;

    private JProgressBar barreDeVie;

    public Entite() {
        alternerSpriteDeplacement = 0;
    }

    public static BufferedImage createComposite(BufferedImage image1, BufferedImage image2, float alpha) {
        BufferedImage buffer = new BufferedImage(Math.max(image1.getWidth(), image2.getWidth()),
                Math.max(image1.getHeight(), image2.getHeight()),
                BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2 = buffer.createGraphics();

        g2.drawImage(image1, null, null);
        Composite newComposite = AlphaComposite.getInstance(AlphaComposite.SRC_OVER, alpha);

        g2.setComposite(newComposite);
        g2.drawImage(image2, null, null);
        g2.dispose();

        return buffer;
    }

    public void creationEntite(Personnage personnage) {

        this.personnage = personnage;

        try {
            tableauSprite = decoupage(ImageIO.read(new File(personnage.getTexture())), 3, 11);
        } catch (IOException e) {
            e.printStackTrace();
        }

        spriteActuel = tableauSprite[2];

        barreDeVie = new JProgressBar();
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
            else if (personnage.getDirectionOrientation() == Direction.DROITE)
                spriteActuel = tableauSprite[7];
            else if (personnage.getDirectionOrientation() == Direction.GAUCHE)
                spriteActuel = tableauSprite[4];
            alternerSpriteDeplacement = 1;
        }

        // selectionne le saut
        if (!personnage.getCollision()) {
            if (!personnage.getAttaquer()) { // saut sans attaque
                if (personnage.getDirectionOrientation() == Direction.DROITE)
                    spriteActuel = tableauSprite[2];
                else if (personnage.getDirectionOrientation() == Direction.GAUCHE)
                    spriteActuel = tableauSprite[0];
            } else if (personnage.getAttaquer()) { // saut avec attaque
                if (personnage.getDirectionOrientation() == Direction.DROITE) {
                    spriteActuel = tableauSprite[alternerSpriteAttaque == 3 ? 7 : 30 + alternerSpriteAttaque];
                    if (alternerSpriteAttaque == 3) {
                        alternerSpriteAttaque = 0;
                        personnage.setAttaquer(false);
                    }
                } else if (personnage.getDirectionOrientation() == Direction.GAUCHE) {
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
                if (personnage.getDirectionOrientation() == Direction.DROITE)
                    spriteActuel = tableauSprite[alternerSpriteDeplacement == 3 ? 7 : 6 + alternerSpriteDeplacement];
                else if (personnage.getDirectionOrientation() == Direction.GAUCHE)
                    spriteActuel = tableauSprite[alternerSpriteDeplacement == 3 ? 4 : 3 + alternerSpriteDeplacement];
            } else if (personnage.getAttaquer()) { // attaque
                if (personnage.getDirectionOrientation() == Direction.DROITE) {
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
                } else if (personnage.getDirectionOrientation() == Direction.GAUCHE) {
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
        g.drawImage(spriteActuel, (int) (personnage.getPositionX() - TAILLE_SPRITE_LARGEUR / 2.0), (int) (personnage.getPositionY() - TAILLE_SPRITE_HAUTEUR / 2.0), TAILLE_SPRITE_LARGEUR, TAILLE_SPRITE_HAUTEUR, this);

        // test zone détection monstre
        if (personnage instanceof Monstre) {
            g.drawRect(personnage.getPositionX() - (personnage.getDirectionOrientation() == Direction.GAUCHE ? personnage.getLargeurDevant() : personnage.getLargeurDerriere()) - ((Monstre) personnage).getDistanceVisibilite(),
                    personnage.getPositionY() - personnage.getHauteurHaut() - ((Monstre) personnage).getDistanceVisibilite(),
                    ((personnage.getDirectionOrientation() == Direction.GAUCHE ? personnage.getLargeurDevant() : personnage.getLargeurDerriere()) + ((Monstre) personnage).getDistanceVisibilite()),
                    (personnage.getHauteurHaut() + ((Monstre) personnage).getDistanceVisibilite()));

            g.drawRect(personnage.getPositionX(),
                    personnage.getPositionY() - personnage.getHauteurHaut() - ((Monstre) personnage).getDistanceVisibilite(),
                    ((personnage.getDirectionOrientation() == Direction.GAUCHE ? personnage.getLargeurDevant() : personnage.getLargeurDerriere()) + ((Monstre) personnage).getDistanceVisibilite()),
                    (personnage.getHauteurHaut() + ((Monstre) personnage).getDistanceVisibilite()));

            g.drawRect(personnage.getPositionX() - (personnage.getDirectionOrientation() == Direction.GAUCHE ? personnage.getLargeurDevant() : personnage.getLargeurDerriere()) - ((Monstre) personnage).getDistanceVisibilite(),
                    personnage.getPositionY(),
                    ((personnage.getDirectionOrientation() == Direction.GAUCHE ? personnage.getLargeurDevant() : personnage.getLargeurDerriere()) + ((Monstre) personnage).getDistanceVisibilite()),
                    (personnage.getHauteurBas() + ((Monstre) personnage).getDistanceVisibilite()));

            g.drawRect(personnage.getPositionX(),
                    personnage.getPositionY(),
                    ((personnage.getDirectionOrientation() == Direction.GAUCHE ? personnage.getLargeurDevant() : personnage.getLargeurDerriere()) + ((Monstre) personnage).getDistanceVisibilite()),
                    (personnage.getHauteurBas() + ((Monstre) personnage).getDistanceVisibilite()));
        }

        // test zone hitbox du sprite
        g.drawRect(personnage.getPositionX() - (personnage.getDirectionOrientation() == Direction.GAUCHE ? personnage.getLargeurDevant() : personnage.getLargeurDerriere()),
                personnage.getPositionY() - personnage.getHauteurHaut(),
                personnage.getLargeurDevant() + (personnage.getDirectionOrientation() == Direction.GAUCHE ? personnage.getLargeurDevant() : personnage.getLargeurDerriere()),
                personnage.getHauteurHaut() + personnage.getHauteurBas());

        // test zone hitbox de l'attaque
            // a faire


        // barre de vie avec une barre de progression
        barreDeVie.setMaximum(personnage.getVieMax());
        barreDeVie.setMinimum(0);
        barreDeVie.setValue(50);
        barreDeVie.setAlignmentX(personnage.getPositionX());
        barreDeVie.setAlignmentY(personnage.getPositionY());
        barreDeVie.setBorderPainted(true);
        barreDeVie.setBackground(Color.red);
        barreDeVie.paintComponents(g);

        // barre de vie avec des rectangles
        g.setColor(Color.BLACK);
        g.fillRect((int) (personnage.getPositionX() - TAILLE_SPRITE_LARGEUR / 8.0) - Fenetre.adapterResolutionEnX(1), (int) (personnage.getPositionY() - TAILLE_SPRITE_HAUTEUR / 2.0) - Fenetre.adapterResolutionEnY(1), Fenetre.adapterResolutionEnX(75) + Fenetre.adapterResolutionEnX(2), Fenetre.adapterResolutionEnY(15) + Fenetre.adapterResolutionEnY(2));
        g.setColor(Color.WHITE);
        g.fillRect((int) (personnage.getPositionX() - TAILLE_SPRITE_LARGEUR / 8.0), (int) (personnage.getPositionY() - TAILLE_SPRITE_HAUTEUR / 2.0), Fenetre.adapterResolutionEnX(75), Fenetre.adapterResolutionEnY(15));
        g.setColor(Color.RED);
        g.fillRect((int) (personnage.getPositionX() - TAILLE_SPRITE_LARGEUR / 8.0), (int) (personnage.getPositionY() - TAILLE_SPRITE_HAUTEUR / 2.0), Fenetre.adapterResolutionEnX(75 * personnage.getVie() / personnage.getVieMax()), Fenetre.adapterResolutionEnY(15));


        // remet la couleur par defaut
        g.setColor(Color.BLACK);
    }
}