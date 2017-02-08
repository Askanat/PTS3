package model;

import java.util.Random;

public class Niveau {
    private int tableau[][];
    private int nb_plateformes;
    private int taille_x;
    private int taille_y;
    private int[] epaisseur;
    private Direction entree;
    private Random rand = new Random();

    private static final int TAILLE_SEGMENT = 20;
    private static final int ESPACE_PLATEFORME = 9;
    private static final int TAILLE_VIDE_MAX = 8;
    private static final int TAILLE_VIDE_FOND_MAX = 2;
    private static final int EPAISSEUR_PLATEFORME_MIN = 1;
    private static final int EPAISSEUR_PLATEFORME_MAX = 2;
    private static final int NB_PICS_MIN = 1;
    private static final int NB_PICS_MAX = 4;
    private static final int ESPACE_MIN_ENTRE_PICS = 3;

    public Niveau(int _taille_x, int _nb_plateformes, Direction _entree) {
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
    }

    private void remplirTabVide() {
        for(int i = 0; i < taille_y; i++) {
            for(int j = 0; j < taille_x; j++)
                tableau[i][j] = Block.MUR_FOND;
        }
    }

    // Construction du cadre limitant le niveau

    private void genCadre() {
        int i;

        for (i = 0; i < taille_x; i++)
            tableau[0][i] = Block.MUR;

        for (i = 0; i < taille_x; i++)
            tableau[taille_y - 1][i] = Block.MUR;

        for (i = 1; i < taille_y - 1; i++)
            tableau[i][0] = Block.MUR;

        for (i = 1; i < taille_y - 1; i++)
            tableau[i][taille_x - 1] = Block.MUR;
    }

    // Calcule l'epaisseur de toutes les lignes et calcule taille_y

    private void genTailleY() {
        int i;

        for (i = 0; i < nb_plateformes; i++)
            epaisseur[i] = rand.nextInt(EPAISSEUR_PLATEFORME_MAX - EPAISSEUR_PLATEFORME_MIN + 1) + 1;

        for (i = 0; i < nb_plateformes; i++)
            taille_y += epaisseur[i] + ESPACE_PLATEFORME;
    }

    // Retourne le nombre de lignes avant le début de la plateforme

    private int getEspaceAvantPlateforme(int plateforme) {
        int i, espace = 1;

        for (i = 0; i < plateforme; i++)
            espace += ESPACE_PLATEFORME + epaisseur[i];

        return espace + ESPACE_PLATEFORME;
    }

    private void ajoutPorteSortie(Direction sortie) {
        int y = getEspaceAvantPlateforme(0) - 1;

        if (sortie == Direction.GAUCHE) {
            tableau[y + 1][taille_x - 5] = Block.MUR;
            tableau[y + 1][taille_x - 4] = Block.MUR;
            tableau[y + 1][taille_x - 3] = Block.MUR;
            tableau[y + 1][taille_x - 2] = Block.MUR;
            tableau[y][taille_x - 4] = Block.PORTE_BAS_GAUCHE;
            tableau[y - 1][taille_x - 4] = Block.PORTE_MILIEU_GAUCHE;
            tableau[y - 2][taille_x - 4] = Block.PORTE_HAUT_GAUCHE;
            tableau[y][taille_x - 3] = Block.PORTE_BAS_DROITE;
            tableau[y - 1][taille_x - 3] = Block.PORTE_MILIEU_DROITE;
            tableau[y - 2][taille_x - 3] = Block.PORTE_HAUT_DROITE;
        } else {
            tableau[y + 1][1] = Block.MUR;
            tableau[y + 1][2] = Block.MUR;
            tableau[y + 1][3] = Block.MUR;
            tableau[y + 1][4] = Block.MUR;
            tableau[y][3] = Block.PORTE_BAS_GAUCHE;
            tableau[y - 1][3] = Block.PORTE_MILIEU_GAUCHE;
            tableau[y - 2][3] = Block.PORTE_HAUT_GAUCHE;
            tableau[y][2] = Block.PORTE_BAS_DROITE;
            tableau[y - 1][2] = Block.PORTE_MILIEU_DROITE;
            tableau[y - 2][2] = Block.PORTE_HAUT_DROITE;
        }
    }

    private void remplirPlateformeFondSup(int plateforme) {
        int y = getEspaceAvantPlateforme(plateforme) - 2;
        int r;

        for (int i = 1; i < taille_x - 1; i++) {
            if (i % 15 == 0)
                tableau[y][i] = Block.TORCHE;
            else if (tableau[y][i] == Block.MUR_FOND) {
                r = rand.nextInt(10);

                if (r == 0)
                    tableau[y][i] = Block.VITRE;
            }
        }
    }

    // Remplis une ligne y avec Block.MUR

    private void remplirLigneMur(int debut, int fin, int y) {
        for(int i = debut; i < fin; i++)
            tableau[y][i] = Block.MUR;
    }

    // Ajoute des pics à une ligne donnée
    
    private void ajoutPicsLigne(int debut, int fin, int y) {
        int i, ajoutPic = 0, videCompteur = 0, espaceAvantPic = 5000, nbPicsAffile = 0;

        for(i = debut; i < fin; i++) {
            if(ajoutPic > 0)
                ajoutPic = rand.nextInt(2) + 1;
            else
                ajoutPic = rand.nextInt(5) + 1;

            if(ajoutPic == 1 && espaceAvantPic >= ESPACE_MIN_ENTRE_PICS) {
                tableau[y][i] = Block.PICS;

                if(tableau[y][i - 1] == Block.PICS)
                    nbPicsAffile++;

                if(nbPicsAffile > NB_PICS_MAX - 2)
                    espaceAvantPic = 0;
            }
            else if(tableau[y][i - 1] == Block.PICS)
                espaceAvantPic = 0;
            else
                espaceAvantPic++;
        }
    }
    
    // Ajoute des trous à une ligne donnée

    private void remplirLigneVide(int debut, int fin, int posLigne, int epaisseur, int y, int videMax) {
        int i, faireVide = 0, videCompteur = 0;

        if(debut == 1)
            debut = 2;
        if(fin == taille_x - 1)
            fin = taille_x - 2;

        for(i = debut; i < fin; i++) {
            /* Si c'est la première ligne du haut de la plateforme.
             * Sinon si c'est une des lignes de dessous et que la case dessus à gauche,
             * la case dessus à droite et la case dessus est vide.
             * Sinon faireVide = 0.
             *
             * Si on entre dans un des deux premiers if :
             * 
             * Si on a déjà commencé à faire des trous, c'est que videCompteur > 0,
             * alors on a un peu plus de chance de continuer d'en faire.
             * On réduit l'écart lorsqu'il faut tirer un nombre aléatoire pour savoir
             * s'il faut continuer à faire des trous.
             *
             * Sinon, on tire un nombre pour savoir si l'on commence à faire des trous
             */

            if(posLigne == 0) {
                if(videCompteur > 0)
                    faireVide = rand.nextInt(2) + 1;
                else
                    faireVide = rand.nextInt(5) + 1;
            }
            else if(tableau[y - 1][i - 1] == 0 && tableau[y - 1][i + 1] == 0 && tableau[y - 1][i] == 0) {
                if(videCompteur > 0)
                    faireVide = rand.nextInt(2) + 1;
                else
                    faireVide = rand.nextInt(4) + 1;
            }
            else
                faireVide = 0;

            /*
             * On fait du vide si faireVide == 1 et que le nombre maximum de 
             * cases vide d'affilé n'a pas été dépassé
             */

            if(faireVide == 1 && videCompteur < videMax) {
                tableau[y][i] = Block.MUR_FOND;
                videCompteur++;
            }
            else
                videCompteur = 0;
        }
    }

    /*
     * posLigne = 0 => debut
     * posLigne = epaisseur - 1 => fin
     * sinon => une des lignes du milieu
     */

    private void remplirLigne(int debut, int fin, int posLigne, int epaisseur, int y, int videMax) {
        final int VIDE = 0, PICS = 1;
        final int NB_CASES = (fin - debut);
        int curSegment = 0, debutSegment = debut, finSegment = TAILLE_SEGMENT;

        remplirLigneMur(debut, fin, y);

        for(int i = 0; i < NB_CASES; i++) {
            if(i % TAILLE_SEGMENT == 0) {
                int type = rand.nextInt(PICS + 1);

                if(type == VIDE)
                    remplirLigneVide(debutSegment, finSegment, posLigne, epaisseur, y, videMax);
                else if(type == PICS && posLigne == 0 && debutSegment > debut && finSegment < fin)
                    ajoutPicsLigne(debutSegment, finSegment, y);

                debutSegment = finSegment;
                
                if((finSegment = debutSegment + TAILLE_SEGMENT) > fin)
                    finSegment = fin;

                curSegment++;
            }
        }
    }

    // Construit un escalier afin d'accéder à une plateforme

    private void addEscalier(Direction dir, int espaceBase, int epaisseurN) {
        int debut = espaceBase + epaisseurN - 1;
        int fin = espaceBase + epaisseurN + ESPACE_PLATEFORME - 3;
        int i, j;

        if(dir == Direction.GAUCHE) {
            i = ESPACE_PLATEFORME;

            for(j = debut; j < fin; j++) {
                tableau[j][i] = Block.MUR;
                i--;
            }
        } else {
            i = taille_x - ESPACE_PLATEFORME - 1;

            for(j = debut; j < fin; j++) {
                tableau[j][i] = Block.MUR;
                i++;
            }
        }
    }

    private void remplirPlateforme(int plateforme, Direction dir) {
        int i, debut = 1, fin = taille_x - 1;
        int espaceBase, espace, tailleVide = TAILLE_VIDE_MAX;
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
             * puis on calcule l'espace avant la ligne actuelle en ajoutant i
             */

            espaceBase = getEspaceAvantPlateforme(plateforme);
            espace = espaceBase + i;

            /* Si ce n'est pas la première plateforme */

            if (plateforme < nb_plateformes - 1) {
                if (i == epaisseurN - 1)
                    tailleVide = TAILLE_VIDE_FOND_MAX;
                else
                    tailleVide = TAILLE_VIDE_MAX;

                remplirLigne(debut, fin, i, epaisseurN, espace, tailleVide);

                /* 
                 * On appele la fonction permettant de construire 
                 * l'escalier si i correspond à la dernière ligne de la plateforme.
                 */

                if (i == epaisseurN - 1)
                    addEscalier(dir, espace, epaisseurN);
            } else {
                /*
                 * Sinon on remplis la première plateforme tout en
                 * évitant qu'il y ait des trous au début et à la fin.
                 */

                if (i == epaisseurN - 1)
                    tailleVide = TAILLE_VIDE_FOND_MAX;

                remplirLigne(1, taille_x - 1, i, epaisseurN, espace, tailleVide);
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
        }

        if (i % 2 == 0) {
            if (dir == Direction.GAUCHE)
                dir = Direction.DROITE;
            else
                dir = Direction.GAUCHE;
        }

        ajoutPorteSortie(dir);
    }

    public void print() {
        int i, j;

        for (i = 0; i < taille_y; i++) {
            for (j = 0; j < taille_x; j++) {
                System.out.print(tableau[i][j] + " ");
            }

            System.out.println();
            System.out.println();
        }
    }
}
