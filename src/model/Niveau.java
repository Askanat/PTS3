package model;

import java.util.Random;

/*
 * TODO : Bugs à corriger
 *
 * - mur au dessus de l'escalier
 * - trou en dessous de la porte
 */

public class Niveau {

    private int tableau[][];

    // nb_niveaux doit etre impair, pour commencer a gauche et finir a droite

    private int nb_niveaux;
    private int taille_x;
    private int taille_y;
	private int[] epaisseur;
	private Direction sortie;

    private static final int ESPACE_NIVEAU = 3;
    private static final int TAILLE_VIDE_MAX = 8;
    private static final int TAILLE_VIDE_FOND_MAX = 2;
    private static final int EPAISSEUR_PLATEFORME_MIN = 1;
    private static final int EPAISSEUR_PLATEFORME_MAX = 2;

    public Niveau(int _taille_x, int _nb_niveaux) {
        // Ligne du haut et ligne du bas

        taille_y = ESPACE_NIVEAU - (ESPACE_NIVEAU - 2);
        taille_x = _taille_x;
        nb_niveaux = _nb_niveaux;

		if(nb_niveaux % 2 == 0)
			sortie = Direction.DROITE;
		else
			sortie = Direction.GAUCHE;

        gen();
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
        Random rand = new Random();
        int i;

        for (i = 0; i < nb_niveaux; i++)
            epaisseur[i] = rand.nextInt(EPAISSEUR_PLATEFORME_MAX - EPAISSEUR_PLATEFORME_MIN + 1) + 1;

        for (i = 0; i < nb_niveaux; i++)
            taille_y += epaisseur[i] + ESPACE_NIVEAU;
    }

    // Retourne l'espace en block avant le niveau (numero de la plateforme)

    private int getEspaceAvantNiveau(int niveau) {
        int i, espace = 1;

        for (i = 0; i < niveau; i++)
            espace += ESPACE_NIVEAU + epaisseur[i];

        return espace + ESPACE_NIVEAU;
    }

	private void ajoutPorteSortie() {
		int y = getEspaceAvantNiveau(0) - 1;

		if(sortie == Direction.DROITE) {
			tableau[y][taille_x - 4] = Block.PORTE_BAS_GAUCHE;
			tableau[y - 1][taille_x - 4] = Block.PORTE_MILIEU_GAUCHE;
			tableau[y - 2][taille_x - 4] = Block.PORTE_HAUT_GAUCHE;
			tableau[y][taille_x - 3] = Block.PORTE_BAS_DROITE;
			tableau[y - 1][taille_x - 3] = Block.PORTE_MILIEU_DROITE;
			tableau[y - 2][taille_x - 3] = Block.PORTE_HAUT_DROITE;
		}
		else {
			tableau[y][3] = Block.PORTE_BAS_GAUCHE;
			tableau[y - 1][3] = Block.PORTE_MILIEU_GAUCHE;
			tableau[y - 2][3] = Block.PORTE_HAUT_GAUCHE;
			tableau[y][2] = Block.PORTE_BAS_DROITE;
			tableau[y - 1][2] = Block.PORTE_MILIEU_DROITE;
			tableau[y - 2][2] = Block.PORTE_HAUT_DROITE;
		}
	}

    private void remplirPlateformeFondSup(int plateforme) {
        Random rand = new Random();
        int y = getEspaceAvantNiveau(plateforme) - 2;
        int r;

        for(int i = 1; i < taille_x - 1; i++) {
            if(i % 15 == 0)
                tableau[y][i] = Block.TORCHE;
            else if (tableau[y][i] == Block.MUR_FOND)
			{
                r = rand.nextInt(10);

	            if(r == 0)
    	            tableau[y][i] = Block.VITRE;
			}
        }
    }
	
    // posLigne = 0 => debut
    // posLigne = epaisseur - 1 => fin
    // sinon => une des lignes du milieu

    private void remplirLigne(int debut, int fin, int posLigne, int epaisseur, int y, int videMax) {
        int i, faireVide, videCompteur = 0;
        Random rand = new Random();

        // S'il s'agit d'une des premières lignes

        if (debut == 1 && fin == taille_x - 1) {
            for (i = debut; i < fin; i++) {
                // Si c'est la toute première ligne du block

                if (posLigne == 0) {
                    if (videCompteur > 0)   
                        faireVide = rand.nextInt(2) + 1;
                    else
                        faireVide = rand.nextInt(3) + 1;

                    if (i > 2 && i < taille_x - 2 && faireVide == 1 &&
                            videCompteur < videMax) {
                        videCompteur++;
                    } else {
                        tableau[y][i] = Block.MUR;
                        videCompteur = 0;
                    }
                } else {
                    // Optimisation possible

                    tableau[y][i] = Block.MUR;

                    if (tableau[y - 1][i] == 0 &&
                            tableau[y - 1][i - 1] == 0 &&
                            tableau[y - 1][i + 1] == 0) {
                        faireVide = rand.nextInt(4) + 1;

                        if (faireVide > 1)
                            tableau[y][i] = Block.MUR_FOND;
                    }
                }
            }
        } else {
            for (i = debut; i < fin; i++) {
                if (posLigne == 0) {
                    if (videCompteur > 0)
                        faireVide = rand.nextInt(2) + 1;
                    else
                        faireVide = rand.nextInt(3) + 1;

                    if (((debut > 1 && i < taille_x - 4) ||
                            (debut == 1 && i > 2)) &&
                            (faireVide == 1 && videCompteur < videMax)) {
                        videCompteur++;
                    } else {
                        tableau[y][i] = Block.MUR;
                        videCompteur = 0;
                    }
                } else {
                    faireVide = rand.nextInt(4) + 1;

                    if (posLigne == epaisseur - 1) {
                        if (videCompteur < videMax)
                            videCompteur++;
                        else
                            videCompteur = 0;
                    }

                    if (!(((debut > 1 && i < taille_x - 5) ||
                            (debut == 1 && i > 3)) &&
                            tableau[y - 1][i] == 0 &&
                            tableau[y - 1][i - 1] == 0 &&
                            tableau[y - 1][i + 1] == 0 &&
                            faireVide > 1)) {
                        tableau[y][i] = Block.MUR;
                    }
                }
            }
        }
    }

    private void remplirNiveau(int niveau, int dir) {
        int i, j, k, debut, fin;
		int espaceBase, espace, tailleVide = TAILLE_VIDE_MAX;
		int epaisseurN = epaisseur[niveau];

        // Note : dir == 0 => accès à la plateforme supérieure par la gauche
        //        dir != 0 => accès à la plateforme supérieure par la droite

        for (i = 0; i < epaisseurN; i++) {
            espaceBase = getEspaceAvantNiveau(niveau);
            espace = espaceBase + i;

            // S'il ne s'agit pas d'une des premières lignes du bas

            if (espaceBase + epaisseurN != taille_y - 1) {
                if (dir == 0) {
                    debut = ESPACE_NIVEAU + 2;
                    fin = taille_x - 1;
                } else {
                    debut = 1;
                    fin = taille_x - (ESPACE_NIVEAU + 2);
                }

                if (i == epaisseurN - 1)
                    tailleVide = TAILLE_VIDE_FOND_MAX;
                else
                    tailleVide = TAILLE_VIDE_MAX;

                remplirLigne(debut, fin, i, epaisseurN, espace, tailleVide);

                // Escaliers pour pouvoir passer à la plateforme suivante

                debut = espaceBase + epaisseurN - 1;
                fin = espaceBase + epaisseurN + (ESPACE_NIVEAU - 2);

                if (dir == 0) {
                    k = ESPACE_NIVEAU + 1;

                    for (j = debut; j <= fin; j++) {
                        tableau[j][k] = 2;
                        k--;
                    }
                } else {
                    k = taille_x - ESPACE_NIVEAU * 2;

                    for (j = debut; j <= fin; j++) {
                        tableau[j][k] = 2;
                        k++;
                    }
                }
            } else {
                if (i == epaisseurN - 1)
                    tailleVide = TAILLE_VIDE_FOND_MAX;

                remplirLigne(1, taille_x - 1, i, epaisseurN, espace, tailleVide);
            }
        }
    }

    // Generation du niveau

    public void gen() {
        Random rand = new Random();
        int i;

		epaisseur = new int[nb_niveaux];
        genTailleY();
        tableau = new int[taille_y][taille_x];
        genCadre();

        for (i = 0; i < nb_niveaux; i++) {
            remplirNiveau(i, (i + 1) % 2);
            remplirPlateformeFondSup(i);
        }

		ajoutPorteSortie();
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
