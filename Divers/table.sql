DROP TABLE IF EXISTS hero;
DROP TABLE IF EXISTS monstre;  
CREATE TABLE hero (
	id INT AUTO_INCREMENT NOT NULL,
	nom VARCHAR(25), 
	niveau INT,
	experience INT,
	experienceMax INT,
	pointCompetence INT,
	pointConstitution INT,
	pointIntelligence INT,
	pointForce INT,
	pointResistance INT,
	pieceOr INT,
	chargeMax INT,
	texture_hero varchar(40),
	PRIMARY KEY (id)
);

CREATE TABLE monstre (
	id int AUTO_INCREMENT NOT NULL,
	nom varchar(25),
	niveau int,
	coefVie int,
	coefMana int,
	coefDegat int,
	coefArmure int,
	coefDeplacement int,
	texture_monstre varchar(40),
	PRIMARY KEY(id)
);

INSERT INTO hero VALUES (NULL, 'hero1', 1, 0, 100, 4,0, 0, 0, 0, 100, 100,"images/texture_hero.png");
INSERT INTO hero VALUES (NULL, 'hero2', 1, 0, 100, 4,0, 0, 0, 0, 100, 100,"images/texture_hero.png");
INSERT INTO hero VALUES (NULL, 'hero3', 1, 0, 100, 4,0, 0, 0, 0, 100, 100,"images/texture_hero.png");

INSERT INTO monstre VALUES (NULL, 'monstre1', 1, 0, 0, 0,0, 20,"images/texture_monstre.png");
INSERT INTO monstre VALUES (NULL, 'monstre2', 1, 0, 0, 0,0, 20,"images/texture_monstre.png");
INSERT INTO monstre VALUES (NULL, 'monstre3', 1, 0, 0, 0,0, 20,"images/texture_monstre.png");
