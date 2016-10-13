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
            System.out.println("echec pilote : " + e);
        }
    }

    public ArrayList<String> readHero(int id) {

        ResultSet resultat = null;

        try {
            resultat = instruction.executeQuery("Select * FROM hero WHERE id =" + id + ";");
        } catch (Exception e) {
            System.out.println("Echec pilotes " + e);
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
            e.printStackTrace();
        }

        return valeur;
    }

    public void updateHero(int id, String[] tabCaracHero) {

        int update;

        try {
            update = instruction.executeUpdate("UPDATE hero SET nom = " + tabCaracHero[0] + ", niveau = " + tabCaracHero[1] + ", experience = " + tabCaracHero[2] +
            ", experienceMax =" + tabCaracHero[3] + ", pointCompetence =" + tabCaracHero[4] + ", pointConstitution =" + tabCaracHero[5] + ", pointIntelligence = " + tabCaracHero[6] +
            ", pointForce =" + tabCaracHero[7] + ", pointResistance =" + tabCaracHero[8] + ", pieceOr =" + tabCaracHero[9] + ", chargeMax =" + tabCaracHero[10] +
            " WHERE id = " + id + ";");
        } catch (Exception e) {
            System.out.println("Echec pilotes " + e);
        }
    }

    public String readHeroTexture(int id) {
        // select retournant le chemin de texture
        return "images/test3.png";
    }

    public void deleteHero() {
    }
}