package vue;

import model.*;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import static vue.Fenetre.decoupage;
import static vue.Fenetre.scrollPane;
import static vue.FenetreJeu.TAILLE_TUILE;

/**
 * Created by bastien on 02/10/16.
 */

public class EntiteVue extends JPanel {

    public static final int TAILLE_SPRITE_HAUTEUR = Fenetre.adapterResolutionEnY(300);
    public static final int TAILLE_SPRITE_LARGEUR = Fenetre.adapterResolutionEnX(300);

    private Jeu jeu;
    public Entite entite;

    private BufferedImage[] tableauSprite;
    public Image spriteActuel;

    private int alternerSpriteDeplacement;
    private int alternerSpriteAttaque;

    public EntiteVue(Jeu jeu) {
        this.jeu = jeu;
        entite = null;

        tableauSprite = null;
        spriteActuel = null;

        alternerSpriteDeplacement = 0;
        alternerSpriteAttaque = 0;
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

    public void creationEntite(Entite entite) {

        this.entite = entite;

        try {
            tableauSprite = decoupage(ImageIO.read(new File(entite.getTexture())), 3, 11);
        } catch (IOException e) {
            e.printStackTrace();
        }

        spriteActuel = tableauSprite[2];
    }

    public void selectionnerMorceauSpriteDeplacement() {

        if (!entite.getDeplacement() && entite.getCollision()) { // remet en place les pieds
            if (spriteActuel == tableauSprite[0])
                spriteActuel = tableauSprite[3];
            else if (spriteActuel == tableauSprite[2])
                spriteActuel = tableauSprite[8];
            else if (entite.getDirectionOrientation().getDirection() == Direction.DROITE)
                spriteActuel = tableauSprite[7];
            else if (entite.getDirectionOrientation().getDirection() == Direction.GAUCHE)
                spriteActuel = tableauSprite[4];
            alternerSpriteDeplacement = 1;
        }

        // selectionne le saut
        if (!entite.getCollision() && entite instanceof Personnage) {
            if (!entite.getAttaquer()) { // saut sans attaque
                if (entite.getDirectionOrientation().getDirection() == Direction.DROITE)
                    spriteActuel = tableauSprite[2];
                else if (entite.getDirectionOrientation().getDirection() == Direction.GAUCHE)
                    spriteActuel = tableauSprite[0];
            } else if (entite.getAttaquer()) { // saut avec attaque
                if (entite.getDirectionOrientation().getDirection() == Direction.DROITE) {
                    spriteActuel = tableauSprite[alternerSpriteAttaque == 3 ? 7 : 30 + alternerSpriteAttaque];
                    if (alternerSpriteAttaque == 3) {
                        alternerSpriteAttaque = 0;
                        entite.setAttaquer(false);
                    }
                } else if (entite.getDirectionOrientation().getDirection() == Direction.GAUCHE) {
                    spriteActuel = tableauSprite[alternerSpriteAttaque == 3 ? 4 : 27 + alternerSpriteAttaque];
                    if (alternerSpriteAttaque == 3) {
                        alternerSpriteAttaque = 0;
                        entite.setAttaquer(false);
                    }
                }
            }

            // selectionne le déplacement de droite et de gauche
        } else if (entite.getCollision() || entite instanceof Sort) {
            if (!entite.getAttaquer() && entite.getDeplacement()) { // deplacement sans attaque
                if (entite.getDirectionOrientation().getDirection() == Direction.DROITE)
                    spriteActuel = tableauSprite[alternerSpriteDeplacement == 3 ? 7 : 6 + alternerSpriteDeplacement];
                else if (entite.getDirectionOrientation().getDirection() == Direction.GAUCHE)
                    spriteActuel = tableauSprite[alternerSpriteDeplacement == 3 ? 4 : 3 + alternerSpriteDeplacement];
            } else if (entite.getAttaquer()) { // attaque
                if (entite.getDirectionOrientation().getDirection() == Direction.DROITE) {
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
                            entite.setAttaquer(false);
                            break;
                    }
                } else if (entite.getDirectionOrientation().getDirection() == Direction.GAUCHE) {
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
                            entite.setAttaquer(false);
                            break;
                    }
                }
            }
        }

        // permet d'alterner les mouvements de deplacement
        if (entite.getDeplacement()) {
            if (entite instanceof Personnage)
                alternerSpriteDeplacement = alternerSpriteDeplacement == 3 ? 0 : alternerSpriteDeplacement + 1;
            if (entite instanceof Sort)
                alternerSpriteDeplacement = alternerSpriteDeplacement >= 2 ? 2 : alternerSpriteDeplacement + 1;
        }

        // permet d'alterner les mouvements de dégats
        if (entite.getAttaquer())
            alternerSpriteAttaque = alternerSpriteAttaque == 3 ? 0 : alternerSpriteAttaque + 1;
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.drawImage(spriteActuel, (int) (entite.getPositionX() - TAILLE_SPRITE_LARGEUR / 2.0), (int) (entite.getPositionY() - TAILLE_SPRITE_HAUTEUR / 2.0), TAILLE_SPRITE_LARGEUR, TAILLE_SPRITE_HAUTEUR, this);

        if (jeu.getEtat().getHitBox()) {
            g.setColor(Color.RED);
            // zone de vue monstre
            if (entite instanceof Monstre) {
                g.drawRect(((Monstre) entite).getHitBoxVue().x, ((Monstre) entite).getHitBoxVue().y, ((Monstre) entite).getHitBoxVue().width, ((Monstre) entite).getHitBoxVue().height);
                // zone de détection pour l'attaque
                g.drawRect(((Monstre) entite).getHitBoxZoneAttaque().x, ((Monstre) entite).getHitBoxZoneAttaque().y, ((Monstre) entite).getHitBoxZoneAttaque().width, ((Monstre) entite).getHitBoxZoneAttaque().height);
            }

            // zone du corps du sprite
            g.drawRect(entite.getHitBoxCorps().x, entite.getHitBoxCorps().y, entite.getHitBoxCorps().width, entite.getHitBoxCorps().height);

            if (entite instanceof Personnage) {
                // zone de l'attaque
                g.drawRect(((Personnage) entite).getHitBoxAttaque().x, ((Personnage) entite).getHitBoxAttaque().y, ((Personnage) entite).getHitBoxAttaque().width, ((Personnage) entite).getHitBoxAttaque().height);

                int x = entite.getPositionX() / TAILLE_TUILE;
                int y = (entite.getPositionY() + entite.getHauteurBas()) / TAILLE_TUILE;
                g.setColor(Color.BLUE);
                g.drawRect(x * TAILLE_TUILE, (y - 1) * TAILLE_TUILE, TAILLE_TUILE, TAILLE_TUILE);

                g.drawRect(x * TAILLE_TUILE, (y - 4) * TAILLE_TUILE, TAILLE_TUILE, TAILLE_TUILE);
                g.drawRect(x * TAILLE_TUILE, (y - 3) * TAILLE_TUILE, TAILLE_TUILE, TAILLE_TUILE);

                g.drawRect((x - 1) * TAILLE_TUILE, (y - 3) * TAILLE_TUILE, TAILLE_TUILE, TAILLE_TUILE);
                g.drawRect((x + 1) * TAILLE_TUILE, (y - 3) * TAILLE_TUILE, TAILLE_TUILE, TAILLE_TUILE);
            }
        }

        // barre de vie pour les monstres
        if (entite instanceof Monstre) {
            g.setColor(Color.BLACK);
            g.fillRect((int) (entite.getPositionX() - TAILLE_SPRITE_LARGEUR / 8.0) - Fenetre.adapterResolutionEnX(1), (int) (entite.getPositionY() - TAILLE_SPRITE_HAUTEUR / 2.0) - Fenetre.adapterResolutionEnY(1), Fenetre.adapterResolutionEnX(75) + Fenetre.adapterResolutionEnX(2), Fenetre.adapterResolutionEnY(15) + Fenetre.adapterResolutionEnY(2));
            g.setColor(Color.WHITE);
            g.fillRect((int) (entite.getPositionX() - TAILLE_SPRITE_LARGEUR / 8.0), (int) (entite.getPositionY() - TAILLE_SPRITE_HAUTEUR / 2.0), Fenetre.adapterResolutionEnX(75), Fenetre.adapterResolutionEnY(15));
            g.setColor(Color.RED);
            g.fillRect((int) (entite.getPositionX() - TAILLE_SPRITE_LARGEUR / 8.0), (int) (entite.getPositionY() - TAILLE_SPRITE_HAUTEUR / 2.0), Fenetre.adapterResolutionEnX(75 * ((Personnage) entite).getVie() / ((Personnage) entite).getVieMax()), Fenetre.adapterResolutionEnY(15));
        } else if (entite instanceof Hero) {
            // barre de vie pour le héro
            g.setColor(Color.BLACK);
            g.fillRect((int) (scrollPane.getViewport().getViewPosition().getX() + Fenetre.adapterResolutionEnX(100) - Fenetre.adapterResolutionEnX(1)), (int) (scrollPane.getViewport().getViewPosition().getY() + Fenetre.adapterResolutionEnY(40) - Fenetre.adapterResolutionEnY(1)), Fenetre.adapterResolutionEnX(200) + Fenetre.adapterResolutionEnX(2), Fenetre.adapterResolutionEnY(15) + Fenetre.adapterResolutionEnY(2));
            g.setColor(Color.WHITE);
            g.fillRect((int) (scrollPane.getViewport().getViewPosition().getX() + Fenetre.adapterResolutionEnX(100)), (int) (scrollPane.getViewport().getViewPosition().getY() + Fenetre.adapterResolutionEnY(40)), Fenetre.adapterResolutionEnX(200), Fenetre.adapterResolutionEnY(15));
            g.setColor(Color.GREEN);
            g.fillRect((int) (scrollPane.getViewport().getViewPosition().getX() + Fenetre.adapterResolutionEnX(100)), (int) (scrollPane.getViewport().getViewPosition().getY() + Fenetre.adapterResolutionEnY(40)), Fenetre.adapterResolutionEnX(200 * ((Personnage) entite).getVie() / ((Personnage) entite).getVieMax()), Fenetre.adapterResolutionEnY(15));

            // barre de mana pour le Héro
            g.setColor(Color.BLACK);
            g.fillRect((int) (scrollPane.getViewport().getViewPosition().getX() + Fenetre.adapterResolutionEnX(100) - Fenetre.adapterResolutionEnX(1)), (int) (scrollPane.getViewport().getViewPosition().getY() + Fenetre.adapterResolutionEnY(60) - Fenetre.adapterResolutionEnY(1)), Fenetre.adapterResolutionEnX(200) + Fenetre.adapterResolutionEnX(2), Fenetre.adapterResolutionEnY(15) + Fenetre.adapterResolutionEnY(2));
            g.setColor(Color.WHITE);
            g.fillRect((int) (scrollPane.getViewport().getViewPosition().getX() + Fenetre.adapterResolutionEnX(100)), (int) (scrollPane.getViewport().getViewPosition().getY() + Fenetre.adapterResolutionEnY(60)), Fenetre.adapterResolutionEnX(200), Fenetre.adapterResolutionEnY(15));
            g.setColor(Color.BLUE);
            g.fillRect((int) (scrollPane.getViewport().getViewPosition().getX() + Fenetre.adapterResolutionEnX(100)), (int) (scrollPane.getViewport().getViewPosition().getY() + Fenetre.adapterResolutionEnY(60)), Fenetre.adapterResolutionEnX(200 * ((Personnage) entite).getMana() / ((Personnage) entite).getManaMax()), Fenetre.adapterResolutionEnY(15));

            // barre de exp pour le Héro
            g.setColor(Color.BLACK);
            g.fillRect((int) (scrollPane.getViewport().getViewPosition().getX() + Fenetre.adapterResolutionEnX(100) - Fenetre.adapterResolutionEnX(1)), (int) (scrollPane.getViewport().getViewPosition().getY() + Fenetre.adapterResolutionEnY(80) - Fenetre.adapterResolutionEnY(1)), Fenetre.adapterResolutionEnX(200) + Fenetre.adapterResolutionEnX(2), Fenetre.adapterResolutionEnY(15) + Fenetre.adapterResolutionEnY(2));
            g.setColor(Color.WHITE);
            g.fillRect((int) (scrollPane.getViewport().getViewPosition().getX() + Fenetre.adapterResolutionEnX(100)), (int) (scrollPane.getViewport().getViewPosition().getY() + Fenetre.adapterResolutionEnY(80)), Fenetre.adapterResolutionEnX(200), Fenetre.adapterResolutionEnY(15));
            g.setColor(Color.ORANGE);
            g.fillRect((int) (scrollPane.getViewport().getViewPosition().getX() + Fenetre.adapterResolutionEnX(100)), (int) (scrollPane.getViewport().getViewPosition().getY() + Fenetre.adapterResolutionEnY(80)), Fenetre.adapterResolutionEnX(200 * (int) ((Hero) entite).getExperience() / (int) ((Hero) entite).getExperienceMax()), Fenetre.adapterResolutionEnY(15));
        }
    }
}
