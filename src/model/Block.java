package model;

import java.lang.reflect.Field;

/*
 * Les blocks constituant un niveau
 *
 * [-75; -50]
 *    collision = non; interraction = non; destructible = non; degats = non
 *
 * [-49; -25]
 *    collision = non; interraction = oui; destructible = non; degats = non
 *
 * [-24; 0]
 *    collision = non; interraction = non; destructible = oui; degats = non
 *
 * [1; 25]
 *    collision = oui; interraction = non; destructible = non; degats = non
 *
 * [26; 50]
 *    collision = oui; interraction = non; destructible = oui; degats = non
 *
 * [51; 75]
 *    collision = oui; interraction = non; destructible = non; degats = oui
 *
 * [76; 100]
 *    collision = oui; interraction = oui; destructible = non; degats = non
 */

public class Block {
	public static final int
	TORCHE = -75,
	VITRE = -74,
	COFFRE_OUVERT = -73,
	MUR_FOND = -72,

	COFFRE_FERME = -49,
	PORTE_HAUT_GAUCHE = -48,
	PORTE_HAUT_DROITE = -47,
	PORTE_MILIEU_GAUCHE = -46,
	PORTE_MILIEU_DROITE = -45,
	PORTE_BAS_GAUCHE = -44,
	PORTE_BAS_DROITE = -43,
	ECHELLE_GAUCHE = -42,
	ECHELLE_DROITE = -41,

	VASE = -24,

	MUR = 1,

	CAISSE = 26,

	PICS = 51;
	
	public static int getNbBlocks() {
		Field[] fields = Block.class.getDeclaredFields();
		return fields.length;
	}
}
