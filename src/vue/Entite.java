package vue;

import model.*;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import static vue.Fenetre.*;
import static vue.FenetreJeu.ZONE;


/**
 * Created by bastien on 02/10/16.
 */

public class Entite extends JPanel {

    Jeu jeu;
    public Personnage personnage;
    public static final int TAILLE_SPRITE_HAUTEUR = Fenetre.adapterResolutionEnY(300);
    public static final int TAILLE_SPRITE_LARGEUR = Fenetre.adapterResolutionEnX(300);
    private BufferedImage[] tableauSprite;
    public Image spriteActuel;
    private int alternerSpriteDeplacement, alternerSpriteAttaque;

    public Entite(Jeu jeu) {
        this.jeu = jeu;
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

        if (jeu.getHitBox()) {
            g.setColor(Color.RED);
            // zone de vue monstre
            if (personnage instanceof Monstre)
                g.drawRect(((Monstre) personnage).getHitBoxVue().x, ((Monstre) personnage).getHitBoxVue().y, ((Monstre) personnage).getHitBoxVue().width, ((Monstre) personnage).getHitBoxVue().height);

            // zone du corps du sprite
            g.drawRect(personnage.getHitBoxCorps().x, personnage.getHitBoxCorps().y, personnage.getHitBoxCorps().width, personnage.getHitBoxCorps().height);

            // zone de l'attaque
            g.drawRect(personnage.getHitBoxAttaque().x, personnage.getHitBoxAttaque().y, personnage.getHitBoxAttaque().width, personnage.getHitBoxAttaque().height);
        }

        // barre de vie pour les monstres 
        if (personnage instanceof Monstre) {
            g.setColor(Color.BLACK);
            g.fillRect((int) (personnage.getPositionX() - TAILLE_SPRITE_LARGEUR / 8.0) - Fenetre.adapterResolutionEnX(1), (int) (personnage.getPositionY() - TAILLE_SPRITE_HAUTEUR / 2.0) - Fenetre.adapterResolutionEnY(1), Fenetre.adapterResolutionEnX(75) + Fenetre.adapterResolutionEnX(2), Fenetre.adapterResolutionEnY(15) + Fenetre.adapterResolutionEnY(2));
            g.setColor(Color.WHITE);
            g.fillRect((int) (personnage.getPositionX() - TAILLE_SPRITE_LARGEUR / 8.0), (int) (personnage.getPositionY() - TAILLE_SPRITE_HAUTEUR / 2.0), Fenetre.adapterResolutionEnX(75), Fenetre.adapterResolutionEnY(15));
            g.setColor(Color.RED);
            g.fillRect((int) (personnage.getPositionX() - TAILLE_SPRITE_LARGEUR / 8.0), (int) (personnage.getPositionY() - TAILLE_SPRITE_HAUTEUR / 2.0), Fenetre.adapterResolutionEnX(75 * personnage.getVie() / personnage.getVieMax()), Fenetre.adapterResolutionEnY(15));
        } else if (personnage instanceof Hero) {
            // barre de vie pour le héro
            g.setColor(Color.BLACK);
            g.fillRect((int) (scrollPane.getViewport().getViewPosition().getX() + Fenetre.adapterResolutionEnX(100) - Fenetre.adapterResolutionEnX(1)), (int) (scrollPane.getViewport().getViewPosition().getY() + Fenetre.adapterResolutionEnY(40) - Fenetre.adapterResolutionEnY(1)), Fenetre.adapterResolutionEnX(200) + Fenetre.adapterResolutionEnX(2), Fenetre.adapterResolutionEnY(15) + Fenetre.adapterResolutionEnY(2));
            g.setColor(Color.WHITE);
            g.fillRect((int) (scrollPane.getViewport().getViewPosition().getX() + Fenetre.adapterResolutionEnX(100)), (int) (scrollPane.getViewport().getViewPosition().getY() + Fenetre.adapterResolutionEnY(40)), Fenetre.adapterResolutionEnX(200), Fenetre.adapterResolutionEnY(15));
            g.setColor(Color.GREEN);
            g.fillRect((int) (scrollPane.getViewport().getViewPosition().getX() + Fenetre.adapterResolutionEnX(100)), (int) (scrollPane.getViewport().getViewPosition().getY() + Fenetre.adapterResolutionEnY(40)), Fenetre.adapterResolutionEnX(200 * personnage.getVie() / personnage.getVieMax()), Fenetre.adapterResolutionEnY(15));

            // barre de mana pour le Héro
            g.setColor(Color.BLACK);
            g.fillRect((int) (scrollPane.getViewport().getViewPosition().getX() + Fenetre.adapterResolutionEnX(100) - Fenetre.adapterResolutionEnX(1)), (int) (scrollPane.getViewport().getViewPosition().getY() + Fenetre.adapterResolutionEnY(60) - Fenetre.adapterResolutionEnY(1)), Fenetre.adapterResolutionEnX(200) + Fenetre.adapterResolutionEnX(2), Fenetre.adapterResolutionEnY(15) + Fenetre.adapterResolutionEnY(2));
            g.setColor(Color.WHITE);
            g.fillRect((int) (scrollPane.getViewport().getViewPosition().getX() + Fenetre.adapterResolutionEnX(100)), (int) (scrollPane.getViewport().getViewPosition().getY() + Fenetre.adapterResolutionEnY(60)), Fenetre.adapterResolutionEnX(200), Fenetre.adapterResolutionEnY(15));
            g.setColor(Color.BLUE);
            g.fillRect((int) (scrollPane.getViewport().getViewPosition().getX() + Fenetre.adapterResolutionEnX(100)), (int) (scrollPane.getViewport().getViewPosition().getY() + Fenetre.adapterResolutionEnY(60)), Fenetre.adapterResolutionEnX(200 * personnage.getMana() / personnage.getManaMax()), Fenetre.adapterResolutionEnY(15));

            // barre de exp pour le Héro
            g.setColor(Color.BLACK);
            g.fillRect((int) (scrollPane.getViewport().getViewPosition().getX() + Fenetre.adapterResolutionEnX(100) - Fenetre.adapterResolutionEnX(1)), (int) (scrollPane.getViewport().getViewPosition().getY() + Fenetre.adapterResolutionEnY(80) - Fenetre.adapterResolutionEnY(1)), Fenetre.adapterResolutionEnX(200) + Fenetre.adapterResolutionEnX(2), Fenetre.adapterResolutionEnY(15) + Fenetre.adapterResolutionEnY(2));
            g.setColor(Color.WHITE);
            g.fillRect((int) (scrollPane.getViewport().getViewPosition().getX() + Fenetre.adapterResolutionEnX(100)), (int) (scrollPane.getViewport().getViewPosition().getY() + Fenetre.adapterResolutionEnY(80)), Fenetre.adapterResolutionEnX(200), Fenetre.adapterResolutionEnY(15));
            g.setColor(Color.ORANGE);
            g.fillRect((int) (scrollPane.getViewport().getViewPosition().getX() + Fenetre.adapterResolutionEnX(100)), (int) (scrollPane.getViewport().getViewPosition().getY() + Fenetre.adapterResolutionEnY(80)), Fenetre.adapterResolutionEnX(200 * (int) ((Hero) personnage).getExperience() / (int) ((Hero) personnage).getExperienceMax()), Fenetre.adapterResolutionEnY(15));


            // permet le défilement par rapport à la position du héro et centré sur le héro tout en évitant de scroll quand on ne peut pas (sortir de la zone-safe par exemple)
            if (jeu.getHero().getPositionY() > (int) (Y / 2.0) && jeu.getHero().getPositionY() < ZONE.height - (int) (Y / 2.0))
                scrollPane.getViewport().setViewPosition(new Point((int) scrollPane.getViewport().getViewPosition().getX(), (int) (jeu.getHero().getPositionY() - Y / 2.0)));
            if (jeu.getHero().getPositionX() > (int) (X / 2.0) && jeu.getHero().getPositionX() < ZONE.width - (int) (X / 2.0))
                scrollPane.getViewport().setViewPosition(new Point((int) (jeu.getHero().getPositionX() - X / 2.0), (int) scrollPane.getViewport().getViewPosition().getY()));
        }
    }
}