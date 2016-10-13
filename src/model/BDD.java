package model;

import java.sql.*;

/**
 * Created by bastien on 12/10/16.
 */
public class BDD {

    public BDD() {

        String pilote = "com.mysql.jdbc.Driver";

        try {
            Class.forName(pilote);
            Connection connexion = DriverManager.getConnection("jdbc:mysql://localhost/projet", "DUTinfo", "0000");
        } catch (Exception e) {
            System.out.println("echec pilote : " + e);
        }
    }

    public ResultSet recupDonneeHero(int id) {

        ResultSet resultat = null;

        try {
            Connection connexion = DriverManager.getConnection("jdbc:mysql://localhost/projet", "DUTinfo", "0000"); //Ici c'est pour ce connecter (localhost/nom_bdd,user,mdp)

            Statement instruction = connexion.createStatement();//Ici on crée un objet qui servira à nous connecter lors des requetes

            resultat = instruction.executeQuery("Select * FROM hero WHERE id =" + id + ";");

        } catch (Exception e) {

            System.out.println("Echec pilotes " + e);
        }

        return resultat;
    }
}
