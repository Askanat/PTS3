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
	 * [0; 20]
	 * collision = non; interraction = oui; destructible = non; degats = non
	 */

	COFFRE_FERME = 6,
	PORTE_HAUT_GAUCHE = 0,
	PORTE_HAUT_DROITE = 1,
	PORTE_MILIEU_GAUCHE = 7,
	PORTE_MILIEU_DROITE = 8,
	PORTE_BAS_GAUCHE = 14,
	PORTE_BAS_DROITE = 15,
	ECHELLE_GAUCHE = -1, // pas définie
	ECHELLE_DROITE = -1, // pas définie

	/*
	 * [21; 62]
	 * collision = non; interraction = non; destructible = non; degats = non
	 */

	TORCHE = 34,
	VITRE = 41,
	COFFRE_OUVERT = 26,
	MUR_FOND = 40,

	/*
	 * [63; 78]
	 * collision = oui; interraction = non; destructible = non; degats = non
	 */

	MUR = 65,
	MUR2 = 72,

	/*
	 * [79; 87]
	 * collision = oui; interraction = non; destructible = non; degats = oui
	 */

	PICS = 79;

	public static int getNbBlocks() {
		Field[] fields = Block.class.getDeclaredFields();
		return fields.length;
	}
}
