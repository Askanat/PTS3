package model;


import java.sql.*;
import java.util.ArrayList;

public class BDD {

    private Connection connexion;
    private Statement instruction;

    public BDD() {

        String pilote = "com.mysql.jdbc.Driver";

        try {
            Class.forName(pilote);
            connexion = DriverManager.getConnection("jdbc:mysql://localhost/projet", "DUTinfo", "0000");
            instruction = connexion.createStatement();
        } catch (Exception e) {
            System.out.println("Echec pilote : " + e);
        }
    }

    //SELECTIONNE LES DONNEES D'UN HERO
    public ArrayList<String> readHero(int id) {

        ResultSet resultat = null;

        try {
            resultat = instruction.executeQuery("Select * FROM personnage WHERE idPerso =" + id + ";");
        } catch (Exception e) {
            System.out.println("Echec query hero " + e);
        }

        ArrayList<String> valeur = new ArrayList<>();

        try {
            while (resultat.next()) {
                valeur.add(resultat.getString("nomPerso"));
                valeur.add(resultat.getString("LVLPerso"));
                valeur.add(resultat.getString("xpPerso"));
                valeur.add(resultat.getString("xpMaxPerso"));
                valeur.add(resultat.getString("forcePerso"));
                valeur.add(resultat.getString("intelPerso"));
                valeur.add(resultat.getString("constiPerso"));
                valeur.add(resultat.getString("armurePerso"));
                valeur.add(resultat.getString("resiPerso"));
                valeur.add(resultat.getString("degatArmePerso"));
                valeur.add(resultat.getString("gold"));
                valeur.add(resultat.getString("texturePerso"));
            }
        } catch (SQLException e) {
            System.out.println("Select hero problem " + e);
        }

        return valeur;
    }

    //SELECTIONNE LES DONNEES D'UN MONSTRE
    public ArrayList<String> readMonstre(int id) {

        ResultSet resultat = null;

        try {
            resultat = instruction.executeQuery("Select * FROM monstre WHERE idMonstre =" + id + ";");
        } catch (Exception e) {
            System.out.println("Echec query monstre " + e);
        }

        ArrayList<String> valMonstre = new ArrayList<>();

        try {
            while (resultat.next()) {
                valMonstre.add(resultat.getString("libelleMonstre"));
                valMonstre.add(resultat.getString("largeur"));
                valMonstre.add(resultat.getString("hauteur"));
                valMonstre.add(resultat.getString("coeffArmure"));
                valMonstre.add(resultat.getString("coeffVie"));
                valMonstre.add(resultat.getString("coeffMana"));
                valMonstre.add(resultat.getString("coeffDegat"));
                valMonstre.add(resultat.getString("vitesseDeDeplacementEnX"));
                valMonstre.add(resultat.getString("vitesseDeDeplacementEnY"));
                valMonstre.add(resultat.getString("distanceVisibilite"));
                valMonstre.add(resultat.getString("textureMonstre"));
                valMonstre.add(resultat.getString("spell_id"));
            }
        } catch (SQLException e) {
            System.out.println("Select monstre problem " + e);
        }

        return valMonstre;
    }

    //MODIFIE LES VALEURS DE LA TABLE HERO
    public void updateHero(int id, String[] tabCaracHero) {
        try {
            instruction.executeUpdate("UPDATE personnage SET nomPerso = " + tabCaracHero[0] + ", LVLPerso = " + tabCaracHero[1] + ", xpPerso = " + tabCaracHero[2] +
                    ", xpMaxPerso =" + tabCaracHero[3] + ", pointCompetencePerso =" + tabCaracHero[4] + ", forcePerso =" + tabCaracHero[5] + ", intelPerso = " + tabCaracHero[6] +
                    ", constiPerso =" + tabCaracHero[7] + ", armurePerso =" + tabCaracHero[8] + ", resiPerso =" + tabCaracHero[9] + ", degatArmePerso =" + tabCaracHero[10] +
                    ", gold =" + tabCaracHero[11] + ", texturePerso =" + tabCaracHero[12] + " spell_id =" + tabCaracHero[13] +
                    " WHERE idPerso = " + id + ";");
        } catch (Exception e) {
            System.out.println("Update perso problem " + e);
        }
    }

    //SUPPRIME UN HERO
    public void deleteHero(int id) {
        try {
            instruction.executeUpdate("DELETE FROM personnage WHERE idPerso =" + id + ";");
        } catch (Exception e) {
            System.out.println("Delete hero problem : " + e);
        }
    }

    //SUPPRIME UN MONSTRE
    public void deleteMonstre(int id) {
        try {
            instruction.executeUpdate("DELETE FROM monstre WHERE idMonstre =" + id + ";");
        } catch (Exception e) {
            System.out.println("Delete monstre problem : " + e);
        }
    }

    //AJOUTE UN HERO
    public void insertHero() {
        try {
            instruction.executeUpdate("INSERT INTO personnage (nomPerso, LVLPerso, xpPerso, xpMaxPerso, pointCompetencePerso, forcePerso, intelPerso, constiPerso, armurePerso, resiPerso, degatArmePerso, gold, texturePerso, spell_id) VALUES ('hero1', 1,0,100,4,0,0,0,0,100,100,100,'bidule.png',42);");
        } catch (Exception e) {
            System.out.println("Insert perso problem : " + e);
        }
    }

    //SELECTIONNE LE NOM DE LA TEXTURE DU HERO
    public String readHeroTexture(int id) {
        ResultSet texture = null;
        String result = new String();
        try {
            texture = instruction.executeQuery("Select texturePerso FROM personnage WHERE idPerso =" + id + ";");
            while (texture.next())
                result = texture.getString("texturePerso");
        } catch (Exception e) {
            System.out.println("Texture hero problem " + e);
        }
        return result;
    }

    //SELECTIONNE LE NOM DE LA TEXTURE D'UN MONSTRE
    public String readMonstreTexture(int id) {
        ResultSet texture = null;
        String result = new String();
        try {
            texture = instruction.executeQuery("Select textureMonstre FROM monstre WHERE idMonstre =" + id + ";");
            while (texture.next())
                result = texture.getString("textureMonstre");
        } catch (Exception e) {
            System.out.println("Texture monstre problem " + e);
        }
        return result;
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
            perso = instruction.executeQuery("Select LVLPerso FROM personnage WHERE idPerso =" + id + ";");
            while (perso.next()) {
                result = perso.getString("LVLPerso");
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
            nbPartie = instruction.executeQuery("SELECT COUNT(nomPerso) AS count FROM personnage WHERE LVLPerso=0;");
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
            idPartie = instruction.executeQuery("SELECT idPerso FROM personnage WHERE LVLPerso=0;");
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
            instruction.executeUpdate("UPDATE personnage SET nomPerso='perso1', LVLPerso =0, xpPerso=0, xpMaxPerso=0, forcePerso=0," +
                    " intelPerso=0, constiPerso=0, armurePerso=0, resiPerso=0, degatArmePerso=0, gold=0 WHERE idPerso=" + id + ";");
        } catch (Exception e) {
            System.out.println("Probleme reset partie : " + e);
        }
    }

    //update remplacer le nom et mettre niveau a 1
    public void createPerso(String nom, int id) {
        try {
            instruction.executeUpdate("UPDATE personnage SET nomPerso='" + nom + "', LVLPerso=1 WHERE idPerso=" + id + ";");
        } catch (Exception e) {
            System.out.println("Probleme create partie : " + e);
        }
    }
}