CREATE TABLE spell (
  idSpell int AUTO_INCREMENT NOT NULL,
  libelleSpell varchar(25),
  degatSpell int,
  effetSpell varchar(10),
  textureSpell varchar(25),

  PRIMARY KEY(idSpell)
);

CREATE TABLE personnage (
  idPerso int AUTO_INCREMENT NOT NULL,
  nomPerso varchar(25),
  LVLPerso int,
  xpPerso int,
  xpMaxPerso int,
  forcePerso float(2,2),
  intelPerso float(2,2),
  constiPerso float(2,2),
  armurePerso float(2,2),
  resiPerso float(2,2),
  degatArmePerso int,
  gold int,
  texturePerso varchar(50),
  spell_id int,

  PRIMARY KEY(idPerso),

  CONSTRAINT fk_idSpellPerso FOREIGN KEY (spell_id) REFERENCES spell(idSpell)
);

CREATE TABLE monstre (
  idMonstre int AUTO_INCREMENT NOT NULL,
  libelleMonstre varchar(10),
  coeffMonstre float(2,2),
  coeffArmure float(2,2),
  coeffVie float(2,2),
  coeffMana float(2,2),
  coeffDegat float(2,2),
  textureMonstre varchar(50),
  spell_id int,

  PRIMARY KEY(idMonstre),

  CONSTRAINT fk_spell_id_monstre FOREIGN KEY (spell_id) REFERENCES spell(idSpell)
);

CREATE TABLE item (
  idItem int AUTO_INCREMENT NOT NULL,
  typeItem varchar(25),
  libelleItem varchar(40),
  coeffPotion float(2,2),
  armureItem float(2,2),
  constiItem float(2,2),
  forceItem float(2,2),
  intelItem float(2,2),
  degatItem float(2,2),
  textureItem varchar(50),

  PRIMARY KEY(idItem)
);

CREATE TABLE possede (
  idPersoPossede int,
  idItemPossede int,

  PRIMARY KEY(idPersoPossede,idItemPossede),

  CONSTRAINT fk_idItemPossede_perso FOREIGN KEY (idItemPossede) REFERENCES item(idItem),
  CONSTRAINT fk_idPersoPossede_item FOREIGN KEY (idPersoPossede) REFERENCES personnage(idPerso)
);

CREATE TABLE equipe (
  idPersoEquip int,
  idItemEquip int,

  PRIMARY KEY(idPersoEquip, idItemEquip),

  CONSTRAINT fk_idPersoEquip FOREIGN KEY (idPersoEquip) REFERENCES personnage(idPerso),
  CONSTRAINT fk_idItemEquip FOREIGN KEY (idItemEquip) REFERENCES item(idItem)
);

CREATE TABLE typeItem (
  typeItem int AUTO_INCREMENT NOT NULL,
  libelleTypeItem varchar(25),

  PRIMARY KEY(typeItem)
);

CREATE TABLE est(
  idItemEst int,
  idTypeItemEst int,

  PRIMARY KEY(idItemEst, idTypeItemEst),

  CONSTRAINT fk_idItem_est FOREIGN KEY (idItemEst) REFERENCES item(idItem),
  CONSTRAINT fk_idTypeItem_est FOREIGN KEY (idTypeItemEst) REFERENCES typeItem(typeItem)
);

CREATE TABLE lache (
  idMonstreLache int,
  idItemLache int,

  PRIMARY KEY(idItemLache, idMonstreLache),

  CONSTRAINT fk_idMonstre_lache FOREIGN KEY (idMonstreLache) REFERENCES monstre(idMonstre),
  CONSTRAINT fk_idItem_lache FOREIGN KEY (idItemLache) REFERENCES item(idItem)
);







