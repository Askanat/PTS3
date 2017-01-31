DROP TABLE IF EXISTS lache, spellEquipe, itemEquipe, possede, item, typeItem, monstre, personnage, spell, effet, touches;


CREATE TABLE effet (
  idEffet int AUTO_INCREMENT NOT NULL,
  libelleEffet varchar(25),
  duree int,
  degatParSec int,
  textureEffet varchar(25),

  PRIMARY KEY(idEffet)
);

INSERT INTO effet VALUES (default, "brule", 10, 2, "machin");
INSERT INTO effet VALUES (default, "soin", 10, 4, "machin");
INSERT INTO effet VALUES (default, "givre", 10, 0, "machin");
INSERT INTO effet VALUES (default, "rien", 0, 0, "machin");
INSERT INTO effet VALUES (DEFAULT, "etourdis", 2, 0, "machin");

CREATE TABLE spell (
  idSpell int AUTO_INCREMENT NOT NULL,
  libelleSpell varchar(25),
  degatSpell int,
  effet_id int,
  porteSpell int,
  coutManaSpell int,
  rechargeSpell int,
  textureSpell varchar(25),
  unlockSpell boolean,

  PRIMARY KEY(idSpell),

  CONSTRAINT fk_effet_id_spell FOREIGN KEY (effet_id) REFERENCES effet(idEffet)
);

INSERT INTO spell VALUES (default, "Boule de feu", 10, 1,10, 10, 3, "images/Sorts/boule_de_feu.png", false);
INSERT INTO spell VALUES (default, "La boule magique", 20, 4, 10, 20, 3,  "images/Sorts/boule_magique.png", false);
INSERT INTO spell VALUES (default, "Eclaire de givre", 10, 3, 10, 10, 3, "images/Sorts/eclaire_de_givre.png", false);
INSERT INTO spell VALUES (default, "Soin mineur", 0, 4, 10, 10, 3, "images/Sorts/soin_mineur.png", false);
INSERT INTO spell VALUES (default, "Soin majeur", 20, 2, 0, 20, 5, "images/Sorts/soin_majeur.png", false);
INSERT INTO spell VALUES (default, "Eclair", 20, 5, 10, 20, 5,  "images/Sorts/eclair.png", false);
INSERT INTO spell VALUES (default, "Tempete de feu", 50, 1, 20, 50, 60, "images/Sorts/tempete_de_feu.png", false);
INSERT INTO spell VALUES (default, "Explosion pyrotechnique", 1000, 1, 100, 0, 1, "images/Sorts/explosion_pyrotechnique.png", false);
INSERT INTO spell VALUES (default, "Boule de mana", 5, null, 100, 20, 1, "images/Sorts/boule_Mana.png", false);
INSERT INTO spell VALUES (default, "Boule de vie", 5, null, 100, 20, 1, "images/Sorts/boule_Vie.png", false);
INSERT INTO spell VALUES (default, "Boule d'armure", 5, null, 100, 20, 1, "images/Sorts/boule_Armure.png", false);
INSERT INTO spell VALUES (default, "Boule de degat", 5, null, 100, 20, 1, "images/Sorts/boule_Degat.png", false);

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
  libelleMonstre varchar(10),
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
INSERT INTO monstre VALUES (default, "goutteVie", 53, 64, 73, 42, 25, 25, 5.5, 10, 3.5, 2, 200, "images/Monstres/texture_goutteVie.png", 10);
INSERT INTO monstre VALUES (default, "goutteArmure", 53, 64, 73, 42, 10, 10, 10, 5.5, 3.5, 2, 100, "images/Monstres/texture_goutteArmure.png", 11);
INSERT INTO monstre VALUES (default, "goutteDegats", 53, 64, 73, 42, 15, 15, 2, 3.5, 5.5, 10, 80, "images/Monstres/texture_goutteDegat.png", 12);

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
  coeffPotion float(10,2),
  armureItem float(10,2),
  constiItem float(10,2),
  forceItem float(10,2),
  intelItem float(10,2),
  degatItem float(10,2),
  textureItem varchar(50),
  item_type int,

  PRIMARY KEY(idItem),

  CONSTRAINT fk_typeItem FOREIGN KEY (item_type) REFERENCES typeItem(typeItem)
);

INSERT INTO item VALUES (default, "Casque en fer", default, 1.2, default, default, default, default, "images/Equipements/Casques/casque_en_fer.png", 2);
INSERT INTO item VALUES (default, "Epaulieres en fer", default, 1.2, default, default, default, default, "images/Equipements/Epaulieres/epaulieres_en_fer.png", 3);
INSERT INTO item VALUES (default, "Plastron en fer", default, 1.6, default, default, default, default, "images/Equipements/Plastrons/plastron_en_fer.png", 1);
INSERT INTO item VALUES (default, "Pantalon en fer", default, 1.4, default, default, default, default, "images/Equipements/Pantalons/pantalon_en_fer.png", 6);
INSERT INTO item VALUES (default, "Bottes en fer", default, 1.2, default, default, default, default, "images/Equipements/Bottes/bottes_en_fer.png", 4);
INSERT INTO item VALUES (default, "Gants en fer", default, 1.2, default, default, default, default, "images/Equipements/Gants/gants_en_fer.png", 5);
INSERT INTO item VALUES (default, "Pierre enchantee", default, default, 1.1, 1.1, 1.1, default, "images/Equipements/Bijous/pierre_enchantee.png", 7);
INSERT INTO item VALUES (default, "Epee en fer", default, default, default, default, default, 1.1, "images/Equipements/Armes/epee_en_fer.png", 8);
INSERT INTO item VALUES (default, "Epee noir", default, default, default, default, default, 1.2, "images/Equipements/Armes/epee_noir.png", 8);


CREATE TABLE possede (
  idPersoPossede int,
  idItemPossede int,

  PRIMARY KEY(idPersoPossede,idItemPossede),

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







