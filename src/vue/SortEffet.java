package vue;

import model.Jeu;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

/**
 * Created by bastien on 01/02/17.
 */

public class SortEffet extends JPanel {

    private Jeu jeu;
    private Image imageSort;

    public SortEffet(Jeu jeu, String chemin) {
        this.jeu = jeu;

        try {
            imageSort = ImageIO.read(new File(chemin));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.drawImage(imageSort, 1000, 1000, 20, 20, this);
    }
}
