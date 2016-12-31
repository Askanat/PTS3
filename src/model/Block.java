package model;

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
	MUR_FOND = 0,

	COFFRE = -49,

	VASE = -24,

	MUR = 1,

	CAISSE = 26,

	PICS = 51;
}
