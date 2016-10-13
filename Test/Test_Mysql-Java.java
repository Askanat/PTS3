/*Salut les coupains !! Voila ce que j'ai fait pour la co SQL/Java :)
* C'est simple !!
* Utilisé vos tables produits des TP de millet pour executer mon code (modifier ligne 18) :P*/

import java.sql.*;
/**
 * Created by leo on 02/10/16.
 */
public class Test {

    public static void main(String[] args){

        String pilote = "com.mysql.jdbc.Driver"; //Charger le pilote de JDBC (super important !!)

        try{
            Class.forName(pilote);

            Connection connexion = DriverManager.getConnection("jdbc:mysql://localhost/projet","DUTinfo","0000"); //Ici c'est pour ce connecter (localhost/nom_bdd,user,mdp)

            Statement instruction = connexion.createStatement();//Ici on crée un objet qui servira à nous connecter lors des requetes

            int resultat = instruction.executeUpdate("INSERT INTO produits VALUES (2,1,'cammenbert',12.5,'tomate.png');"); //On utilise executeUpdate() pour INSERT, DELETE, UPDATE etc...

            ResultSet resultat2 = instruction.executeQuery("Select * FROM produits;");//Et exectuteQuery() uniquement pour les SELECT

            while(resultat2.next()){
                System.out.println("Id produit: "+ resultat2.getInt("id"));
                System.out.println("Type de produit: "+resultat2.getInt("typeProduit_id"));
                System.out.println("Nom produit: "+resultat2.getString("nom")); //Attention aux types des variables sql !!
                System.out.print("\n");
            }
        }
        catch (Exception e){

            System.out.println("echec pilote : " + e); //Ici c'est quand c'est cassé lel
        }
    }
}
