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

        ResultSet update = null;

        try {
            update = instruction.executeQuery("Select * FROM hero WHERE id =" + id + ";");
        } catch (Exception e) {
            System.out.println("Echec pilotes " + e);
        }

        ArrayList<String> valeur = new ArrayList<>();
    }

    public String readHeroTexture(int id) {
        // select retournant le chemin de texture
        return "images/test3.png";
    }

    public void deleteHero() {
    }
}