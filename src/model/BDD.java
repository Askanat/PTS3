package model;

import java.sql.*;
import java.util.ArrayList;

/**
 * Created by bastien on 12/10/16.
 */

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
            resultat = instruction.executeQuery("Select * FROM hero WHERE id =" + id + ";");
        } catch (Exception e) {
            System.out.println("Echec query hero " + e);
        }

        ArrayList<String> valeur = new ArrayList<>();

        try {
            while (resultat.next()) {
                valeur.add(resultat.getString("nom"));
                valeur.add(resultat.getString("niveau"));
                valeur.add(resultat.getString("experience"));
                valeur.add(resultat.getString("experienceMax"));
                valeur.add(resultat.getString("pointCompetence"));
                valeur.add(resultat.getString("pointConstitution"));
                valeur.add(resultat.getString("pointIntelligence"));
                valeur.add(resultat.getString("pointForce"));
                valeur.add(resultat.getString("pointResistance"));
                valeur.add(resultat.getString("pieceOr"));
                valeur.add(resultat.getString("chargeMax"));
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
            resultat = instruction.executeQuery("Select * FROM monstre WHERE id =" + id + ";");
        } catch (Exception e) {
            System.out.println("Echec query monstre " + e);
        }

        ArrayList<String> valMonstre = new ArrayList<>();

        try {
            while (resultat.next()) {
                valMonstre.add(resultat.getString("nom"));
                valMonstre.add(resultat.getString("niveau"));
                valMonstre.add(resultat.getString("coefVie"));
                valMonstre.add(resultat.getString("coefMana"));
                valMonstre.add(resultat.getString("coefDegat"));
                valMonstre.add(resultat.getString("coefArmure"));
                valMonstre.add(resultat.getString("coefDeplacement"));
            }
        } catch (SQLException e) {
            System.out.println("Select monstre problem " + e);
        }

        return valMonstre;
    }

    //MODIFIE LES VALEURS DE LA TABLE HERO
    public void updateHero(int id, String[] tabCaracHero) {
        int update;
        try {
            update = instruction.executeUpdate("UPDATE hero SET nom = " + tabCaracHero[0] + ", niveau = " + tabCaracHero[1] + ", experience = " + tabCaracHero[2] +
                    ", experienceMax =" + tabCaracHero[3] + ", pointCompetence =" + tabCaracHero[4] + ", pointConstitution =" + tabCaracHero[5] + ", pointIntelligence = " + tabCaracHero[6] +
                    ", pointForce =" + tabCaracHero[7] + ", pointResistance =" + tabCaracHero[8] + ", pieceOr =" + tabCaracHero[9] + ", chargeMax =" + tabCaracHero[10] +
                    " WHERE id = " + id + ";");
        } catch (Exception e) {
            System.out.println("Update problem " + e);
        }
    }

    //SELECTIONNE LE NOM DE LA TEXTURE DU HERO
    public String readHeroTexture(int id) {
        ResultSet texture = null;
        String result = new String();
        try {
            texture = instruction.executeQuery("Select texture_hero FROM hero WHERE id =" + id + ";");
            result = texture.getString("texture_hero");
        } catch (Exception e) {
            System.out.println("Texture hero problem " + e);
        }

        return result;
    }

    //SUPPRIME UN HERO
    public void deleteHero(int id) {
        int delete;
        try {
            delete = instruction.executeUpdate("DELETE FROM hero WHERE id =" + id + ";");
        } catch (Exception e) {
            System.out.println("Delete hero problem : " + e);
        }
    }

    //SUPPRIME UN MONSTRE
    public void deleteMonstre(int id) {
        int delete;
        try {
            delete = instruction.executeUpdate("DELETE FROM monstre WHERE id =" + id + ";");
        } catch (Exception e) {
            System.out.println("Delete monstre problem : " + e);
        }
    }

    //AJOUTE UN HERO
    public void insertHero() {
        int insert;
        try {
            insert = instruction.executeUpdate("INSERT INTO hero (nom, niveau, experience, experienceMax, pointCompetence, pointConstitution, pointIntelligence, pointForce, pointResistance, pieceOr, chargeMaX) VALUES ('hero1', 1,0,100,4,0,0,0,0,100,100);");
        } catch (Exception e) {
            System.out.println("Insert problem : " + e);
        }
    }

    //SELECTIONNE LE NOM DE LA TEXTURE D'UN MONSTRE
    public String readMonstreTexture(int id) {
        ResultSet texture = null;
        String result = new String();
        try {
            texture = instruction.executeQuery("Select texture_monstre FROM monstre WHERE id =" + id + ";");
            result = texture.getString("texture_monstre");
        } catch (Exception e) {
            System.out.println("Texture monstre problem " + e);
        }

        return result;
    }
}