package model;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Random;

public class Niveau {
    private static final int TAILLE_SEGMENT = 20;
    private static final int NB_LIGNES_MUR_PROFONDEUR = 2;
    private static final int ESPACE_PLATEFORME = 9;
    private static final int TAILLE_VIDE_MAX = 6;
    private static final int TAILLE_VIDE_FOND_MAX = 2;
    private static final int EPAISSEUR_PLATEFORME_MUR2 = 3;
    private static final int EPAISSEUR_PLATEFORME_MIN = 1 + EPAISSEUR_PLATEFORME_MUR2;
    private static final int EPAISSEUR_PLATEFORME_MAX = 1 + EPAISSEUR_PLATEFORME_MUR2;
    private static final int NB_PICS_MIN = 1;
    private static final int NB_PICS_MAX = 4;
    private static final int ESPACE_MIN_ENTRE_PICS = 3;
    private static final int LARGEUR_PLATEFORME_NIV_SUP = 4;
    private static final int NB_PLATEFORMES_ACCESS_NIV_SUP = 4;

    private int tableau[][];
    private int nb_plateformes;
    private int taille_x;
    private int taille_y;
    private int[] epaisseur;

    private Direction entree;
    private Random rand = new Random();

    public Niveau(int _taille_x, int _nb_plateformes, Direction _entree, boolean _sauvegarder) {
        // Ligne du haut et ligne du bas

        taille_y = ESPACE_PLATEFORME - (ESPACE_PLATEFORME - 2);
        taille_x = _taille_x;
        nb_plateformes = _nb_plateformes;

        if (nb_plateformes % 2 != 0) {
            if (_entree == Direction.DROITE)
                entree = Direction.GAUCHE;
            else
                entree = Direction.DROITE;
        } else
            entree = _entree;

        gen();

        if (_sauvegarder)
            sauvegarder();
    }

    public void sauvegarder() {
        try {
            String str = "", nomFichier = "mapFenetreDonjon.txt";
            PrintWriter pw = new PrintWriter(nomFichier);
            int i, j;

            for (i = 0; i < taille_y; i++) {
                for (j = 0; j < taille_x; j++) {
                    str += tableau[i][j] + ",";
                }

                str += "\n";
            }

            pw.print(str);
            pw.close();
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }

    }

    private void remplirTabVide() {
        for (int i = 0; i < taille_y; i++) {
            for (int j = 0; j < taille_x; j++)
                tableau[i][j] = Block.MUR_FOND;
        }
    }

    // Construction du cadre limitant le niveau

    private void genCadre() {
        int i;

        for (i = 0; i < taille_x; i++)
            tableau[0][i] = Block.MUR2;

        for (i = 0; i < taille_x; i++)
            tableau[taille_y - 1][i] = Block.MUR2;

        for (i = 1; i < taille_y - 1; i++)
            tableau[i][0] = Block.MUR2;

        for (i = 1; i < taille_y - 1; i++)
            tableau[i][taille_x - 1] = Block.MUR2;
    }

    // Calcule l'epaisseur de toutes les lignes et calcule taille_y

    private void genTailleY() {
        int i;

        for (i = 0; i < nb_plateformes; i++)
            epaisseur[i] = rand.nextInt(EPAISSEUR_PLATEFORME_MAX - EPAISSEUR_PLATEFORME_MIN + 1) + EPAISSEUR_PLATEFORME_MIN;

        for (i = 0; i < nb_plateformes; i++)
            taille_y += epaisseur[i] + ESPACE_PLATEFORME;
    }

    // Retourne le nombre de Block.MUR dans l'épaisseur d'une plateforme

    private int getTailleMurPlateforme(int plateforme) {
        return epaisseur[plateforme] - EPAISSEUR_PLATEFORME_MUR2;
    }

    // Retourne le nombre de lignes avant le début de la plateforme

    private int getEspaceAvantPlateforme(int plateforme) {
        int i, espace = 1;

        for (i = 0; i < plateforme; i++)
            espace += ESPACE_PLATEFORME + epaisseur[i];

        return espace + ESPACE_PLATEFORME;
    }

    private void addPorteSortie(Direction sortie) {
        int y = getEspaceAvantPlateforme(0) - 1, i;

        if (sortie == Direction.GAUCHE) {
            for (i = 2; i <= 5; i++) {
                tableau[y + 1][taille_x - i] = Block.MUR;
                tableau[y + 2][taille_x - i] = Block.MUR;
                tableau[y + 3][taille_x - i] = Block.MUR2;
                tableau[y + 4][taille_x - i] = Block.MUR2;
            }

            tableau[y][taille_x - 4] = Block.PORTE_BAS_GAUCHE;
            tableau[y - 1][taille_x - 4] = Block.PORTE_MILIEU_GAUCHE;
            tableau[y - 2][taille_x - 4] = Block.PORTE_HAUT_GAUCHE;
            tableau[y][taille_x - 3] = Block.PORTE_BAS_DROITE;
            tableau[y - 1][taille_x - 3] = Block.PORTE_MILIEU_DROITE;
            tableau[y - 2][taille_x - 3] = Block.PORTE_HAUT_DROITE;
        } else {
            for (i = 1; i <= 4; i++) {
                tableau[y + 1][i] = Block.MUR;
                tableau[y + 2][i] = Block.MUR;
                tableau[y + 3][i] = Block.MUR2;
                tableau[y + 4][i] = Block.MUR2;
            }

            tableau[y][2] = Block.PORTE_BAS_GAUCHE;
            tableau[y - 1][2] = Block.PORTE_MILIEU_GAUCHE;
            tableau[y - 2][2] = Block.PORTE_HAUT_GAUCHE;
            tableau[y][3] = Block.PORTE_BAS_DROITE;
            tableau[y - 1][3] = Block.PORTE_MILIEU_DROITE;
            tableau[y - 2][3] = Block.PORTE_HAUT_DROITE;
        }
    }

    // Construit des plateformes afin d'accéder au niveau suivant

    private void addPlateformeAccessNivSup(Direction dir, int plateforme) {
        int i, j, y = 3, fin, debut = (dir == Direction.GAUCHE) ? (taille_x - LARGEUR_PLATEFORME_NIV_SUP - 1) : (1);
        ;
        int espace = getEspaceAvantPlateforme(plateforme);

        for (i = 0; i < NB_PLATEFORMES_ACCESS_NIV_SUP; i++) {
            fin = debut + LARGEUR_PLATEFORME_NIV_SUP;

            for (j = debut; j < fin; j++) {
                int block = Block.MUR;

                if (rand.nextInt(3) == 0) {
                    if (dir == Direction.DROITE) {
                        // Plateforme de gauche

                        if (i % 2 == 0 && j <= debut + 1)
                            block = Block.PICS;
                        else if (i % 2 != 0 && j >= debut + 2)
                            block = Block.PICS;
                    } else {
                        // Plateforme de gauche

                        if (i % 2 != 0 && j <= debut + 1)
                            block = Block.PICS;
                        else if (i % 2 == 0 && j >= debut + 2)
                            block = Block.PICS;
                    }
                }

                tableau[espace - y][j] = block;
                tableau[espace - y + 1][j] = Block.MUR2;
            }


            // Si pair c'est une plateforme de gauche

            if (i % 2 == 0) {
                if (dir == Direction.DROITE)
                    debut = ESPACE_PLATEFORME - LARGEUR_PLATEFORME_NIV_SUP;
                else
                    debut = taille_x - ESPACE_PLATEFORME;
            } else {
                if (dir == Direction.DROITE)
                    debut = 1;
                else
                    debut = taille_x - LARGEUR_PLATEFORME_NIV_SUP - 1;
            }

            y += 3;
        }

    }

    // Construit un escalier afin d'accéder à une plateforme

    private void addEscalier(Direction dir, int espaceBase, int epaisseurN, int plateforme) {
        int debut = espaceBase;
        int fin = debut + epaisseurN + ESPACE_PLATEFORME - (EPAISSEUR_PLATEFORME_MUR2 * 3);
        int i, j;

        if (getTailleMurPlateforme(plateforme) == 1)
            fin++;

        if (dir == Direction.GAUCHE) {
            i = ESPACE_PLATEFORME;

            for (j = debut; j < fin; j++) {
                tableau[j][i] = Block.MUR;
                i--;
            }
        } else {
            i = taille_x - ESPACE_PLATEFORME - 1;

            for (j = debut; j < fin; j++) {
                tableau[j][i] = Block.MUR;
                i++;
            }
        }
    }

    private void addEffetProfondeurAll(int debut, int fin, int y) {
        for (int i = debut; i < fin; i++) {
            if (tableau[y][i] == Block.PICS && tableau[y - 1][i] != Block.PICS)
                tableau[y + 1][i] = Block.PICS;
            if (tableau[y][i] == Block.MUR_FOND && tableau[y + 1][i] != Block.MUR_FOND && tableau[y + 1][i] != Block.MUR_FOND) {
                tableau[y + 1][i] = tableau[y + 2][i] = Block.MUR;
            }
        }
    }

    private void addEffetProfondeur(int plateforme, Direction dir) {
        int i, debut = 1, fin = taille_x - 1;
        int espaceBase, espace, tailleVide = TAILLE_VIDE_MAX;
        int epaisseurN = getTailleMurPlateforme(plateforme);

        /* 
         * dir = la direction par laquelle on accéde à la plateforme
         *       cela permet d'initialiser correctement debut et fin
         */

        if (plateforme != nb_plateformes - 1) {
            if (dir == Direction.GAUCHE) {
                debut = ESPACE_PLATEFORME + 1;
                fin = taille_x - 1;
            } else {
                debut = 1;
                fin = taille_x - ESPACE_PLATEFORME - 1;
            }
        }

        /* On parcours toutes les lignes de la plateforme */

        for (i = 0; i <= epaisseurN; i++) {
            /* 
             * On récupère l'espace avant la plateforme, 
             * puis on calcule l'espace avant la ligne actuelle en addant i
             */

            espaceBase = getEspaceAvantPlateforme(plateforme);
            espace = espaceBase + i;

            addEffetProfondeurAll(debut, fin, espace);
        }
    }

    private void remplirPlateformeFondSup(int plateforme) {
        int y = getEspaceAvantPlateforme(plateforme) - 3;

        for (int i = 1; i < taille_x - 1; i++) {
            if (i % 15 == 0)
                tableau[y][i] = Block.TORCHE;
            else if (tableau[y][i] == Block.MUR_FOND) {
                // Une chance sur dix de placer une vitre

                if (rand.nextInt(10) == 0)
                    tableau[y][i] = Block.VITRE;
            }
        }
    }

    // Remplis une ligne y avec block

    private void remplirLigneMur(int debut, int fin, int y, int block) {
        for (int i = debut; i < fin; i++)
            tableau[y][i] = block;
    }

    // Ajoute des pics à une ligne donnée

    private void addPicsLigne(int debut, int fin, int y) {
        int i, addPic = 0, videCompteur = 0, espaceAvantPic = 5000, nbPicsAffile = 0;

        for (i = debut; i < fin; i++) {
            if (addPic > 0)
                addPic = rand.nextInt(2) + 1;
            else
                addPic = rand.nextInt(5) + 1;

            if (addPic == 1 && espaceAvantPic >= ESPACE_MIN_ENTRE_PICS) {
                tableau[y][i] = Block.PICS;

                if (tableau[y][i - 1] == Block.PICS)
                    nbPicsAffile++;

                if (nbPicsAffile > NB_PICS_MAX - 2)
                    espaceAvantPic = 0;
            } else if (tableau[y][i - 1] == Block.PICS)
                espaceAvantPic = 0;
            else
                espaceAvantPic++;
        }
    }

    // Ajoute des trous à une ligne donnée

    private void remplirLigneVide(int debut, int fin, int posLigne, int epaisseur, int y) {
        int i, faireVide = 0, videCompteur = 0;

        if (debut == 1)
            debut = 2;
        if (fin == taille_x - 1)
            fin = taille_x - 2;

        for (i = debut; i < fin; i++) {
            if (videCompteur > 0)
                faireVide = rand.nextInt(2);
            else
                faireVide = rand.nextInt(3);


            if (tableau[y - 1][i] == Block.MUR_FOND && videCompteur < TAILLE_VIDE_MAX && (videCompteur == 1 || faireVide == 0)) {
                tableau[y][i] = Block.MUR_FOND;
                videCompteur++;
            } else
                videCompteur = 0;
        }
    }

    /*
     * posLigne = 0 => debut
     * posLigne = epaisseur - 1 => fin
     * sinon => une des lignes du milieu
     */

    private void remplirLigne(int debut, int fin, int posLigne, int epaisseur, int y, int plateforme) {
        final int VIDE = 0, PICS = 1;
        final int NB_CASES = (fin - debut);
        int curSegment = 0, debutSegment = debut, finSegment = TAILLE_SEGMENT;
        int block = (posLigne > getTailleMurPlateforme(plateforme)) ? Block.MUR2 : Block.MUR;

        /* Remplis la ligne avec Block.MUR si c'est une des premières lignes de la plateforme, sinon
         * remplis avec Block.MUR2 si c'est une ligne addEffetProfondeur
         */

        remplirLigneMur(debut, fin, y, block);

        for (int i = 0; i < NB_CASES; i++) {
            if (i % TAILLE_SEGMENT == 0) {
                int type = rand.nextInt(PICS + 1);

                // On fait du vide seulement s'il s'agit d'une des deux premières lignes de la plateforme

                if (posLigne == 0 && type == PICS && debutSegment > debut && finSegment < fin)
                    addPicsLigne(debutSegment, finSegment, y);
                else if (posLigne < 2 && type == VIDE)
                    remplirLigneVide(debutSegment, finSegment, posLigne, epaisseur, y);

                debutSegment = finSegment;

                if ((finSegment = debutSegment + TAILLE_SEGMENT) > fin)
                    finSegment = fin;

                curSegment++;
            }
        }
    }

    private void remplirPlateforme(int plateforme, Direction dir) {
        int i, debut = 1, fin = taille_x - 1;
        int espaceBase, espace;
        int epaisseurN = epaisseur[plateforme];

        /* 
         * dir = la direction par laquelle on accéde à la plateforme
         *       cela permet d'initialiser correctement debut et fin
         */

        if (dir == Direction.GAUCHE) {
            debut = ESPACE_PLATEFORME + 1;
            fin = taille_x - 1;
        } else {
            debut = 1;
            fin = taille_x - ESPACE_PLATEFORME - 1;
        }

        /* On parcours toutes les lignes de la plateforme */

        for (i = 0; i < epaisseurN; i++) {
            /* 
             * On récupère l'espace avant la plateforme, 
             * puis on calcule l'espace avant la ligne actuelle en addant i
             */

            espaceBase = getEspaceAvantPlateforme(plateforme);
            espace = espaceBase + i;

            /* Si ce n'est pas la première plateforme */

            if (plateforme < nb_plateformes - 1) {
                remplirLigne(debut, fin, i, epaisseurN, espace, plateforme);
            } else {
                /*
                 * Sinon on remplis la première plateforme tout en
                 * évitant qu'il y ait des trous au début et à la fin.
                 */

                remplirLigne(1, taille_x - 1, i, epaisseurN, espace, plateforme);
            }
        }
    }

    // Découpe une plateforme en plusieurs segments

    private void decoupePlateforme(int plateforme, Direction dir) {
        int i, j, k, debut = 1, fin = taille_x - 1;

        if (dir == Direction.GAUCHE) {
            debut = ESPACE_PLATEFORME + 1;
            fin = taille_x - 1;
        } else {
            debut = 1;
            fin = taille_x - ESPACE_PLATEFORME - 1;
        }

        for (i = debut; i < fin; i++) {
            if (rand.nextInt(2) == 1 && i % TAILLE_SEGMENT == 0) {

                for (j = 0; j < epaisseur[plateforme]; j++) {
                    for (k = 0; k <= 2; k++) {
                        if (dir == Direction.GAUCHE)
                            tableau[getEspaceAvantPlateforme(plateforme) + j][i - k] = Block.MUR_FOND;
                        else
                            tableau[getEspaceAvantPlateforme(plateforme) + j][i + k] = Block.MUR_FOND;
                    }
                }
            }
        }
    }

    // Generation du niveau

    public void gen() {
        int i;
        Direction dir = entree;

        epaisseur = new int[nb_plateformes];
        genTailleY();
        tableau = new int[taille_y][taille_x];
        remplirTabVide();
        genCadre();

        for (i = 0; i < nb_plateformes; i++) {
            if (dir == Direction.GAUCHE)
                dir = Direction.DROITE;
            else
                dir = Direction.GAUCHE;

            remplirPlateforme(i, dir);
            remplirPlateformeFondSup(i);
            addEffetProfondeur(i, dir);

            if (i > 0)
                addPlateformeAccessNivSup(dir, i);

            if (i < nb_plateformes - 1)
                decoupePlateforme(i, dir);
        }

        if (i % 2 == 0) {
            if (dir == Direction.GAUCHE)
                dir = Direction.DROITE;
            else
                dir = Direction.GAUCHE;
        }

        addPorteSortie(dir);
    }

    public void print() {
        int i, j;

        for (i = 0; i < taille_y; i++) {
            for (j = 0; j < taille_x; j++) {
                System.out.print(tableau[i][j] + ",");
            }

            System.out.println();
        }
    }
}
