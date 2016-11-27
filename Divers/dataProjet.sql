DROP TABLE IF EXISTS lache, spellEquipe, itemEquipe, possede, item, typeItem, monstre, personnage, spell;


CREATE TABLE spell (
  idSpell int AUTO_INCREMENT NOT NULL,
  libelleSpell varchar(25),
  degatSpell int,
  effetSpell varchar(10),
  textureSpell varchar(25),

  PRIMARY KEY(idSpell)
);

INSERT INTO spell VALUES (default, "Boule de feu", 10, "brule", "boule_de_feu.png");
INSERT INTO spell VALUES (default, "La boule magique", 20, "aucun", "boule_magique.png");
INSERT INTO spell VALUES (default, "Eclaire de givre", 50, "givre", "eclaire_de_givre.png");

CREATE TABLE personnage (
  idPerso int AUTO_INCREMENT NOT NULL,
  nomPerso varchar(25),
  LVLPerso int,
  xpPerso int,
  xpMaxPerso int,
  forcePerso float(3,2),
  intelPerso float(3,2),
  constiPerso float(3,2),
  armurePerso float(3,2),
  resiPerso float(3,2),
  degatArmePerso int,
  gold int,
  texturePerso varchar(50),

  PRIMARY KEY(idPerso)
);

INSERT INTO personnage VALUES (default, "0", 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, "images/texture_hero1.png");
INSERT INTO personnage VALUES (default, "0", 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, "images/texture_hero2.png");
INSERT INTO personnage VALUES (default, "0", 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, "images/texture_hero3.png");

CREATE TABLE monstre (
  idMonstre int AUTO_INCREMENT NOT NULL,
  libelleMonstre varchar(10),
  coeffMonstre float(3,2),
  coeffArmure float(3,2),
  coeffVie float(3,2),
  coeffMana float(3,2),
  coeffDegat float(3,2),
  textureMonstre varchar(50),
  spell_id int,

  PRIMARY KEY(idMonstre),

  CONSTRAINT fk_spell_id_monstre FOREIGN KEY (spell_id) REFERENCES spell(idSpell)
);

INSERT INTO monstre VALUES (default, "Monstre1", 1.1, 1.1, 1.4, 1.1, 1.1, "images/texture_monstre1.png", null);
INSERT INTO monstre VALUES (default, "Monstre2", 1.1, 1.1, 1.1, 1.4, 1.1, "images/texture_monstre2.png", null);
INSERT INTO monstre VALUES (default, "Monstre3", 1.1, 1.1, 1.1, 1.1, 1.4, "images/texture_monstre3.png", null);

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
  coeffPotion float(3,2),
  armureItem float(3,2),
  constiItem float(3,2),
  forceItem float(3,2),
  intelItem float(3,2),
  degatItem float(3,2),
  textureItem varchar(50),
  item_type int,

  PRIMARY KEY(idItem),

  CONSTRAINT fk_typeItem FOREIGN KEY (item_type) REFERENCES typeItem(typeItem)
);

INSERT INTO item VALUES (default, "Casque en fer", null, 1.2, null, null, null, null, "casque_en_fer.png", 2);
INSERT INTO item VALUES (default, "Epaulieres en fer", null, 1.2, null, null, null, null, "epaulieres_en_fer.png", 3);
INSERT INTO item VALUES (default, "Plastron en fer", null, 1.6, null, null, null, null, "plastron_en_fer.png", 1);
INSERT INTO item VALUES (default, "Pantalon en fer", null, 1.4, null, null, null, null, "pantalon_en_fer.png", 6);
INSERT INTO item VALUES (default, "Bottes en fer", null, 1.2, null, null, null, null, "bottes_en_fer.png", 4);
INSERT INTO item VALUES (default, "Gants en fer", null, 1.2, null, null, null, null, "gants_en_fer.png", 5);
INSERT INTO item VALUES (default, "Pierre enchantee", null, null, 1.1, 1.1, 1.1, null, "pierre_enchantee.png", 7);
INSERT INTO item VALUES (default, "Epee en fer", null, null, null, null, null, 1.1, "epee_en_fer.png", 8);

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







