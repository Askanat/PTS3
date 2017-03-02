DROP TABLE IF EXISTS lache, spellEquipe, itemEquipe, possede, item, typeItem, monstre, personnage, spell, touches;


CREATE TABLE spell (
  idSpell int AUTO_INCREMENT NOT NULL,
  libelleSpell varchar(25),
  largeurDevant int,
  largeurDerriere int,
  hauteurHaut int,
  hauteurBas int,
  degatSpell int,
  porteSpell int,
  coutManaSpell int,
  rechargeSpell int,
  textureSpell varchar(50),
  vitesseDeDeplacement int,
  niveauSpell int,
  soin int,

  PRIMARY KEY(idSpell)
);

INSERT INTO spell VALUES (default, "Boule de feu", 41, 33, 14, 56, 10,10, 10, 30, "images/Sorts/boule_De_Feu.png", 10,10,0);
INSERT INTO spell VALUES (default, "Boule magique", 33, 30, 11, 50, 20, 10, 20, 30,  "images/Sorts/boule_Magique.png", 10,1,0);
INSERT INTO spell VALUES (default, "Eclaire de givre", 38, 54, 6, 49, 10, 10, 10, 30, "images/Sorts/eclaire_De_Givre.png", 10,1,0);
INSERT INTO spell VALUES (default, "Soin mineur", 27, 49, 31, 62, 0, 0, 10, 30, "images/Sorts/soin_Mineur.png", 0,1,50);
INSERT INTO spell VALUES (default, "Soin majeur", 49, 79, 50, 106, 0, 0, 20, 50, "images/Sorts/soin_Majeur.png", 0,1,100);
INSERT INTO spell VALUES (default, "Eclair", 41, 87, 42, 64, 20, 10, 20, 50,  "images/Sorts/eclair.png", 0,1,0);
INSERT INTO spell VALUES (default, "Tempete de feu", 0, 0, 0, 0, 50, 20, 50, 600, "images/Sorts/tempete_De_Feu.png", 0,1,0);
INSERT INTO spell VALUES (default, "Explosion pyrotechnique", 14, 38, 8, 42, 1000, 100, 0, 10, "images/Sorts/explosion_Pyrotechnique.png", 50,1,0);
INSERT INTO spell VALUES (default, "Goutte boule", 22, 38, 8, 50, 5, 50, 3, 10, "images/Sorts/goutte_Boule.png", 35,1,0);

CREATE TABLE personnage (
  idPerso int AUTO_INCREMENT NOT NULL,
  nomPerso varchar(25),
  niveauPerso int,
  pointCompetence int,
  pointCaracteristique int,
  experiencePerso int,
  experienceMaxPerso int,
  forcePerso float(10,2),
  intelPerso float(10,2),
  constiPerso float(10,2),
  resiPerso float(10,2),
  gold int,
  texturePerso varchar(50),

  PRIMARY KEY(idPerso)
);

INSERT INTO personnage VALUES (default, "", 0, 1, 15, 0, 100, 0, 0, 0, 0, 0, "images/Save/texture_hero1.png");
INSERT INTO personnage VALUES (default, "", 0, 1, 15, 0, 100, 0, 0, 0, 0, 0, "images/Save/texture_hero2.png");
INSERT INTO personnage VALUES (default, "", 0, 1, 15, 0, 100, 0, 0, 0, 0, 0, "images/Save/texture_hero3.png");

CREATE TABLE monstre (
  idMonstre int AUTO_INCREMENT NOT NULL,
  libelleMonstre varchar(25),
  largeurDevant int,
  largeurDerriere int,
  hauteurHaut int,
  hauteurBas int,
  vitesseDeDeplacementEnX int,
  vitesseDeDeplacementEnY int,
  coeffArmure float(10,2),
  coeffVie float(10,2),
  coeffMana float(10,2),
  coeffDegat float(10,2),
  distanceVisibilite int,
  textureMonstre varchar(50),
  spell_id int,

  PRIMARY KEY(idMonstre),

  CONSTRAINT fk_spell_id_monstre FOREIGN KEY (spell_id) REFERENCES spell(idSpell)
);

INSERT INTO monstre VALUES (default, "goutteMana", 53, 64, 73, 42, 20, 20, 2, 3.5, 10, 5.5, 150, "images/Monstres/texture_goutteMana.png", 9);
INSERT INTO monstre VALUES (default, "goutteVie", 53, 64, 73, 42, 25, 25, 5.5, 10, 3.5, 2, 200, "images/Monstres/texture_goutteVie.png", 9);
INSERT INTO monstre VALUES (default, "goutteArmure", 53, 64, 73, 42, 10, 10, 10, 5.5, 3.5, 2, 100, "images/Monstres/texture_goutteArmure.png", 9);
INSERT INTO monstre VALUES (default, "goutteDegats", 53, 64, 73, 42, 15, 15, 2, 3.5, 5.5, 10, 100, "images/Monstres/texture_goutteDegat.png", 9);

CREATE TABLE typeItem (
  typeItem int AUTO_INCREMENT NOT NULL,
  libelleTypeItem varchar(25),

  PRIMARY KEY(typeItem)
);

INSERT INTO typeItem VALUES (default, "plastron");
INSERT INTO typeItem VALUES (default, "casque");
INSERT INTO typeItem VALUES (default, "epaulieres");
INSERT INTO typeItem VALUES (default, "bottes");
INSERT INTO typeItem VALUES (default, "gants");
INSERT INTO typeItem VALUES (default, "pantalon");
INSERT INTO typeItem VALUES (default, "bijou");
INSERT INTO typeItem VALUES (default, "arme");

CREATE TABLE item (
  idItem int AUTO_INCREMENT NOT NULL,
  libelleItem varchar(50),
  coeffPotion float(4,2),
  armureItem float(4,2),
  constiItem float(4,2),
  forceItem float(4,2),
  intelItem float(4,2),
  degatItem float(4,2),
  resiItem float(4,2),
  textureItem varchar(80),
  prixItem int,
  item_type int,

  PRIMARY KEY(idItem),

  CONSTRAINT fk_typeItem FOREIGN KEY (item_type) REFERENCES typeItem(typeItem)
);

INSERT INTO item VALUES (default, "Casque en fer", 0, 0, 0, 0, 0, 0, 1.2,"images/Equipements/Casques/casque_en_fer.png", 10,2);
INSERT INTO item VALUES (default, "Epaulieres en fer", 0, 0, 0, 0, 0, 0, 1.2, "images/Equipements/Epaulieres/epaulieres_en_fer.png", 11,3);
INSERT INTO item VALUES (default, "Plastron en fer", 0, 0, 0, 0, 0, 0, 1.6,"images/Equipements/Plastrons/plastron_en_fer.png", 12,1);
INSERT INTO item VALUES (default, "Pantalon en fer", 0, 0, 0, 0, 0, 0, 1.4,"images/Equipements/Pantalons/pantalon_en_fer.png", 13,6);
INSERT INTO item VALUES (default, "Bottes en fer", 0, 0, 0, 0, 0, 0, 1.2,"images/Equipements/Bottes/bottes_en_fer.png", 14,4);
INSERT INTO item VALUES (default, "Gants en fer", 0, 0, 0, 0, 0, 0, 1.2,"images/Equipements/Gants/gants_en_fer.png", 15,5);
INSERT INTO item VALUES (default, "Pierre enchantee", 0, 0, 1.1, 1.1, 1.1, 0, 0,"images/Equipements/Bijous/pierre_enchantee.png", 16,7);
INSERT INTO item VALUES (default, "Epee en fer", 0, 0, 0, 0, 0, 1.1, 0,"images/Equipements/Armes/epee_en_fer.png",17, 8);
INSERT INTO item VALUES (default, "Epee noir", 0, 0, 0, 0, 0, 1.2, 0,"images/Equipements/Armes/epee_noir.png", 18,8);


CREATE TABLE possede (
  idPossede int AUTO_INCREMENT NOT NULL,
  idPersoPossede int,
  idItemPossede int,

  PRIMARY KEY(idPossede),

  CONSTRAINT fk_idItemPossede_perso FOREIGN KEY (idItemPossede) REFERENCES item(idItem),
  CONSTRAINT fk_idPersoPossede_item FOREIGN KEY (idPersoPossede) REFERENCES personnage(idPerso)
);

CREATE TABLE itemEquipe (
  idPersoEquip int,
  idItemEquip int,

  PRIMARY KEY(idPersoEquip, idItemEquip),

  CONSTRAINT fk_idPersoItemEquip FOREIGN KEY (idPersoEquip) REFERENCES personnage(idPerso),
  CONSTRAINT fk_idItemEquip FOREIGN KEY (idItemEquip) REFERENCES item(idItem)
);

CREATE TABLE spellEquipe (
  idPersoEquip int,
  idSpellEquip int,

  PRIMARY KEY(idPersoEquip, idSpellEquip),

  CONSTRAINT fk_idPersoSpellEquip FOREIGN KEY (idPersoEquip) REFERENCES personnage(idPerso),
  CONSTRAINT fk_idSpellEquip FOREIGN KEY (idSpellEquip) REFERENCES spell(idSpell)
);

INSERT INTO spellEquipe VALUES (1,1);
INSERT INTO spellEquipe VALUES (2,1);
INSERT INTO spellEquipe VALUES (3,1);

CREATE TABLE lache (
  idMonstreLache int,
  idItemLache int,

  PRIMARY KEY(idItemLache, idMonstreLache),

  CONSTRAINT fk_idMonstre_lache FOREIGN KEY (idMonstreLache) REFERENCES monstre(idMonstre),
  CONSTRAINT fk_idItem_lache FOREIGN KEY (idItemLache) REFERENCES item(idItem)
);

INSERT INTO lache VALUES (1, 1);
INSERT INTO lache VALUES (2, 2);

CREATE TABLE touches (
  idTouche int AUTO_INCREMENT NOT NULL,
  libelleTouche varchar(25),
  bind varchar(25),

  PRIMARY KEY (idTouche)
);

INSERT INTO touches VALUES (default, "Droite", "VK_RIGHT");
INSERT INTO touches VALUES (default, "Gauche", "VK_LEFT");
INSERT INTO touches VALUES (default, "Menu", "VK_ESCAPE");
INSERT INTO touches VALUES (default, "Saut", "VK_UP");
INSERT INTO touches VALUES (default, "Attaque", "VK_A");