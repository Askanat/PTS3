package model;

import java.lang.reflect.Field;

/*
 * Les blocks constituant un niveau
 *
 *
 * [-21; -11]
 *    collision = non; interraction = oui; destructible = non; degats = non
 * [-10; 0]
 *    collision = non; interraction = non; destructible = non; degats = non
 *
 * [1; 11]
 *    collision = oui; interraction = non; destructible = non; degats = non
 *
 * [12; 22]
 *    collision = oui; interraction = non; destructible = non; degats = oui
 *
 * [23; 33]
 *    collision = oui; interraction = oui; destructible = non; degats = non
 */

public class Block {
	public static final int
	/*
	 * [-21; -11]
	 * collision = non; interraction = oui; destructible = non; degats = non
	 */

	COFFRE_FERME = -21,
	PORTE_HAUT_GAUCHE = -20,
	PORTE_HAUT_DROITE = -19,
	PORTE_MILIEU_GAUCHE = -18,
	PORTE_MILIEU_DROITE = -17,
	PORTE_BAS_GAUCHE = -16,
	PORTE_BAS_DROITE = -15,
	ECHELLE_GAUCHE = -14,
	ECHELLE_DROITE = -13,

	/*
	 * [-10; 0]
	 * collision = non; interraction = non; destructible = non; degats = non
	 */

	TORCHE = -10,
	VITRE = -9,
	COFFRE_OUVERT = -8,
	MUR_FOND = 0,

	/*
	 * [1; 11]
	 * collision = oui; interraction = non; destructible = non; degats = non
	 */

	MUR = 1,
	MUR2 = 2,

	/*
	 * [12; 22]
	 * collision = oui; interraction = non; destructible = non; degats = oui
	 */

	PICS = 12;

	public static int getNbBlocks() {
		Field[] fields = Block.class.getDeclaredFields();
		return fields.length;
	}
}
