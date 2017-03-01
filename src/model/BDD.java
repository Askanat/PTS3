package model;


import java.sql.*;
import java.util.ArrayList;

import static vue.Fenetre.DEFAUT_X;
import static vue.Fenetre.DEFAUT_Y;

public class BDD {

    private Connection connexion;
    private Statement instruction;
    private boolean bddIsOk = false;

    public BDD() {

        String pilote = "com.mysql.jdbc.Driver";

        try {
            Class.forName(pilote);
            connexion = DriverManager.getConnection("jdbc:mysql://localhost/projet", "DUTinfo", "0000");
            instruction = connexion.createStatement();
            bddIsOk = true;
        } catch (Exception e) {
            System.out.println("Echec pilote : " + e);
        }
    }

    //SELECTIONNE LES DONNEES D'UN HERO
    public Hero readHero(int id, Jeu jeu, Hero hero) {

        ResultSet resultat = null;
        Hero hero1 = null;
        ResultSet spell;
        ArrayList<Sort> result = new ArrayList<>();
        try {
            spell = instruction.executeQuery("SELECT * from spell;");
            while (spell.next()) {
                result.add(new Sort(Integer.parseInt(spell.getString("idSpell")), Integer.parseInt(spell.getString("degatSpell")), Integer.parseInt(spell.getString("largeurDevant")), Integer.parseInt(spell.getString("largeurDerriere")), Integer.parseInt(spell.getString("hauteurHaut")), Integer.parseInt(spell.getString("hauteurBas")), Integer.parseInt(spell.getString("porteSpell")), Integer.parseInt(spell.getString("coutManaSpell")), spell.getString("libelleSpell"), spell.getString("textureSpell"), Integer.parseInt(spell.getString("vitesseDeDeplacement")), Integer.parseInt(spell.getString("rechargeSpell")), Integer.parseInt(spell.getString("niveauSpell")), Integer.parseInt(spell.getString("soin"))));
            }
        } catch (Exception e) {
            System.out.println("Donnees charger spell : " + e);
        }

        int[][] loadInventaire = getPossede();
        ArrayList<Equipement> inventaire = new ArrayList<>();

        for (int i = 0; i < placeInventaire(); i++) {
            if (hero.getIdHero() == loadInventaire[i][0]) {
                inventaire.add(dropEquipement(loadInventaire[i][1]));
            }
        }

        try {
            resultat = instruction.executeQuery("Select * FROM personnage WHERE idPerso =" + id + ";");

            while (resultat.next()) {
                hero1 = new Hero(resultat.getString("nomPerso"), Integer.parseInt(resultat.getString("niveauPerso")), Integer.parseInt(resultat.getString("pointCompetence")), Integer.parseInt(resultat.getString("pointCaracteristique")), Double.parseDouble(resultat.getString("experiencePerso")),
                        Double.parseDouble(resultat.getString("experienceMaxPerso")), Double.parseDouble(resultat.getString("forcePerso")), Double.parseDouble(resultat.getString("intelPerso")), Double.parseDouble(resultat.getString("constiPerso")), Double.parseDouble(resultat.getString("resiPerso")),
                        Integer.parseInt(resultat.getString("gold")), resultat.getString("texturePerso"), (int) (DEFAUT_X / 2.0), (int) (DEFAUT_Y / 2.0), jeu, result, inventaire);
            }
        } catch (Exception e) {
            System.out.println("Echec query hero " + e);
            e.printStackTrace();
        }
        return hero1;
    }

    //SELECTIONNE LES DONNEES D'UN MONSTRE
    public Monstre readMonstre(int id, Jeu jeu, int x, int y) {

        ResultSet resultat = null;
        Monstre monstre = null;
        Sort sort = new Sort(getSpell(9));

        try {
            resultat = instruction.executeQuery("Select * FROM monstre WHERE idMonstre =" + id + ";");
            while (resultat.next()) {
                monstre = new Monstre(resultat.getString("libelleMonstre"), 1, Integer.parseInt(resultat.getString("largeurDevant")), Integer.parseInt(resultat.getString("largeurDerriere")), Integer.parseInt(resultat.getString("hauteurHaut")), Integer.parseInt(resultat.getString("hauteurBas")),
                        Double.parseDouble(resultat.getString("coeffArmure")), Double.parseDouble(resultat.getString("coeffVie")), Double.parseDouble(resultat.getString("coeffMana")), Double.parseDouble(resultat.getString("coeffDegat")), resultat.getString("textureMonstre"),
                        x, y, Integer.parseInt(resultat.getString("vitesseDeDeplacementEnX")), Integer.parseInt(resultat.getString("vitesseDeDeplacementEnY")), Integer.parseInt(resultat.getString("distanceVisibilite")), sort, jeu);
            }
        } catch (Exception e) {
            System.out.println("Echec query monstre " + e);
        }

        //ArrayList<String> valMonstre = new ArrayList<>();

                /*valMonstre.add(resultat.getString("libelleMonstre"));
                valMonstre.add(resultat.getString("largeurDevant"));
                valMonstre.add(resultat.getString("largeurDerriere"));
                valMonstre.add(resultat.getString("hauteurHaut"));
                valMonstre.add(resultat.getString("hauteurBas"));
                valMonstre.add(resultat.getString("coeffArmure"));
                valMonstre.add(resultat.getString("coeffVie"));
                valMonstre.add(resultat.getString("coeffMana"));
                valMonstre.add(resultat.getString("coeffDegat"));
                valMonstre.add(resultat.getString("vitesseDeDeplacementEnX"));
                valMonstre.add(resultat.getString("vitesseDeDeplacementEnY"));
                valMonstre.add(resultat.getString("distanceVisibilite"));
                valMonstre.add(resultat.getString("textureMonstre"));
                valMonstre.add(resultat.getString("spell_id"));*/

        return monstre;
    }

    //MODIFIE LES VALEURS DE LA TABLE HERO
    public void updateHero(int id, String[] tabCaracHero) {
        try {
            instruction.executeUpdate("UPDATE personnage SET nomPerso = '" + tabCaracHero[0] + "', niveauPerso = " + tabCaracHero[1] + ", pointCompetence = " + tabCaracHero[2] + ", pointCaracteristique = " + tabCaracHero[3] +
                    ", experiencePerso = " + tabCaracHero[4] + ", experienceMaxPerso =" + tabCaracHero[5] + ", forcePerso =" + tabCaracHero[6] + ", intelPerso = " + tabCaracHero[7] +
                    ", constiPerso =" + tabCaracHero[8] + ", resiPerso =" + tabCaracHero[9] + ", gold =" + tabCaracHero[10] +
                    " WHERE idPerso = " + id + ";");
        } catch (Exception e) {
            System.out.println("Update perso problem " + e);
        }
    }

    //SELECTIONNE LE NOM DU PERSONNAGE
    public String readNomPerso(int id) {
        ResultSet perso = null;
        String result = "";
        try {
            perso = instruction.executeQuery("Select nomPerso FROM personnage WHERE idPerso =" + id + ";");
            while (perso.next()) {
                result = perso.getString("nomPerso");
            }
        } catch (Exception e) {
            System.out.println("Donnees nom hero problem " + e);
        }
        return result;
    }

    //SELECTIONNE LE NIVEAU DU PERSONNAGE
    public String readNiveauPerso(int id) {
        ResultSet perso = null;
        String result = "0";
        try {
            perso = instruction.executeQuery("Select niveauPerso FROM personnage WHERE idPerso =" + id + ";");
            while (perso.next()) {
                result = perso.getString("niveauPerso");
            }
        } catch (Exception e) {
            System.out.println("Donnees LVL hero problem " + e);
        }
        return result;
    }

    //Requete nombre de partie disponible sur les 3
    public int nbPartieLibre() {
        ResultSet nbPartie;
        int result = 0;
        int i = 0;
        try {
            nbPartie = instruction.executeQuery("SELECT COUNT(nomPerso) AS count FROM personnage WHERE niveauPerso=0;");
            while (nbPartie.next()) {
                result = Integer.parseInt(nbPartie.getString("count"));
            }
        } catch (Exception e) {
            System.out.println("Donnees nb partie probleme : " + e);
        }
        return result;
    }

    //Requete l'id de partie disponible sur les 3
    public ArrayList<Integer> idPartieLibre() {
        ResultSet idPartie;
        ArrayList<Integer> result = new ArrayList<>();
        try {
            idPartie = instruction.executeQuery("SELECT idPerso FROM personnage WHERE niveauPerso=0;");
            while (idPartie.next()) {
                result.add(idPartie.getInt("idPerso"));
            }
        } catch (Exception e) {
            System.out.println("Donnees id partie dispo probleme : " + e);
        }
        return result;
    }

    //update la partie correspondante a 0
    public void resetPartie(int id) {
        try {
            instruction.executeUpdate("UPDATE personnage SET nomPerso='', niveauPerso =0, pointCompetence=1, pointCaracteristique=15," +
                    " experiencePerso=0, experienceMaxPerso=100, forcePerso=0," +
                    " intelPerso=0, constiPerso=0, resiPerso=0, gold=0 WHERE idPerso=" + id + ";");
        } catch (Exception e) {
            System.out.println("Probleme reset partie : " + e);
        }
    }

    //update remplacer le nom et mettre niveau a 1
    public void createPerso(String nom, int id) {
        try {
            instruction.executeUpdate("UPDATE personnage SET nomPerso='" + nom + "', niveauPerso=1 WHERE idPerso=" + id + ";");
        } catch (Exception e) {
            System.out.println("Probleme create partie : " + e);
        }
    }

    //Requete qui recup tous les spell
    public ArrayList<Sort> chargerSpell() {
        ResultSet spell;
        ArrayList<Sort> result = new ArrayList<>();
        try {
            spell = instruction.executeQuery("SELECT * from spell;");
            while (spell.next()) {
                result.add(new Sort(Integer.parseInt(spell.getString("idSpell")), Integer.parseInt(spell.getString("degatSpell")), Integer.parseInt(spell.getString("largeurDevant")), Integer.parseInt(spell.getString("largeurDerriere")), Integer.parseInt(spell.getString("hauteurHaut")), Integer.parseInt(spell.getString("hauteurBas")), Integer.parseInt(spell.getString("porteSpell")), Integer.parseInt(spell.getString("coutManaSpell")), spell.getString("libelleSpell"), spell.getString("textureSpell"), Integer.parseInt(spell.getString("vitesseDeDeplacement")), Integer.parseInt(spell.getString("rechargeSpell")), Integer.parseInt(spell.getString("niveauSpell")), Integer.parseInt(spell.getString("soin"))));
            }
        } catch (Exception e) {
            System.out.println("Donnees charger spell : " + e);
        }
        return result;
    }

    public boolean isBDD() {
        return bddIsOk;
    }

    //Récupération des données d'un équipement
    public ArrayList<Equipement> chargerEquipement() {
        ResultSet item;
        ArrayList<Equipement> result = new ArrayList<>();

        try {
            item = instruction.executeQuery("SELECT * FROM item;");
            while (item.next()) {
                result.add(new Equipement(Integer.parseInt(item.getString("idItem")), item.getString("libelleItem"), Float.parseFloat(item.getString("armureItem")), Float.parseFloat(item.getString("constiItem")), Float.parseFloat(item.getString("intelItem")), Float.parseFloat(item.getString("forceItem")), Float.parseFloat(item.getString("resiItem")), Float.parseFloat(item.getString("degatItem")), item.getString("textureItem"), Integer.parseInt(item.getString("item_type"))));
            }
        } catch (Exception e) {
            System.out.println("Chargement item : " + e);
        }
        return result;
    }

    //Drop d'équipement
    public Equipement dropEquipement(int idRand) {
        ResultSet item;
        Equipement result = null;
        try {
            item = instruction.executeQuery("SELECT * FROM item WHERE idItem =" + idRand + ";");
            while (item.next())
                result = new Equipement(Integer.parseInt(item.getString("idItem")), item.getString("libelleItem"), Float.parseFloat(item.getString("armureItem")), Float.parseFloat(item.getString("constiItem")), Float.parseFloat(item.getString("intelItem")), Float.parseFloat(item.getString("forceItem")), Float.parseFloat(item.getString("resiItem")), Float.parseFloat(item.getString("degatItem")), item.getString("textureItem"), Integer.parseInt(item.getString("item_type")));
        } catch (Exception e) {
            System.out.println("Drop item : " + e);
        }

        return result;
    }

    public int nbItem() {
        ResultSet nbItem;
        int result = 0;

        try {
            nbItem = instruction.executeQuery("SELECT count(*) as count FROM item;");
            while (nbItem.next())
                result = Integer.parseInt(nbItem.getString("count"));
        } catch (Exception e) {
            System.out.println("Count item : " + e);
        }
        return result;
    }

    public int placeInventaire() {
        ResultSet place;
        int result = 0;

        try {
            place = instruction.executeQuery("SELECT count(*) AS count FROM possede;");
            while (place.next())
                result = Integer.parseInt(place.getString("count"));
        } catch (Exception e) {
            System.out.println("Place inventaire : " + e);
        }

        return result;
    }

    public String getTextureEquipement(int idItem) {
        ResultSet place;
        String result = "Rien";

        try {
            place = instruction.executeQuery("SELECT textureItem  FROM item where idItem =" + idItem + ";");
            while (place.next())
                result = place.getString("TextureItem");
        } catch (Exception e) {
            System.out.println("Texture equipement : " + e);
        }

        return result;
    }

    public int getPrixItem(int idItem) {
        ResultSet place;
        int result = 0;

        try {
            place = instruction.executeQuery("SELECT prixItem  FROM item where idItem =" + idItem + ";");
            while (place.next())
                result = Integer.parseInt(place.getString("prixItem"));
        } catch (Exception e) {
            System.out.println("Prix equipement : " + e);
        }

        return result;
    }

    public void possede(int idHero, int idItem) {
        try {
            instruction.executeUpdate("INSERT INTO possede VALUES(default," + idHero + "," + idItem + ");");
        } catch (Exception e) {
            System.out.println("Possede problem : " + e);
        }
    }

    public int[][] getPossede() {
        ResultSet possede;
        int[][] result = new int[placeInventaire()][2];
        int i = 0, j = 0;

        try {
            possede = instruction.executeQuery("SELECT * FROM possede");
            while (possede.next()) {
                System.out.println("IdPerso(i) : " + Integer.parseInt(possede.getString("idPersoPossede")) + ", IdItem(j) : " + Integer.parseInt(possede.getString("idItemPossede")));
                result[i][j] = Integer.parseInt(possede.getString("idPersoPossede"));
                result[i][j + 1] = Integer.parseInt(possede.getString("idItemPossede"));
                i++;
            }
        } catch (Exception e) {
            System.out.println("Recup possede : " + e);
        }

        return result;
    }

    public Sort getSpell(int idSort) {
        ResultSet spell;
        Sort result = null;

        try {
            spell = instruction.executeQuery("SELECT * FROM spell WHERE idSpell = "+idSort+";");
            while(spell.next())
                result = new Sort(idSort, Integer.parseInt(spell.getString("degatSpell")), Integer.parseInt(spell.getString("largeurDevant")), Integer.parseInt(spell.getString("largeurDerriere")), Integer.parseInt(spell.getString("hauteurHaut")), Integer.parseInt(spell.getString("hauteurBas")), Integer.parseInt(spell.getString("porteSpell")), Integer.parseInt(spell.getString("coutManaSpell")), spell.getString("libelleSpell"), spell.getString("textureSpell"), Integer.parseInt(spell.getString("vitesseDeDeplacement")), Integer.parseInt(spell.getString("rechargeSpell")), Integer.parseInt(spell.getString("niveauSpell")), Integer.parseInt(spell.getString("soin")));
        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }
}