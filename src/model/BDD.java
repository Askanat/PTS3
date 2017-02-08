package model;


import java.io.*;
import java.sql.*;
import java.util.ArrayList;

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
            //System.out.println("Hello bdd" + bddIsOk);
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
                valeur.add(resultat.getString("niveauPerso"));
                valeur.add(resultat.getString("pointCompetence"));
                valeur.add(resultat.getString("pointCaracteristique"));
                valeur.add(resultat.getString("experiencePerso"));
                valeur.add(resultat.getString("experienceMaxPerso"));
                valeur.add(resultat.getString("forcePerso"));
                valeur.add(resultat.getString("intelPerso"));
                valeur.add(resultat.getString("constiPerso"));
                valeur.add(resultat.getString("resiPerso"));
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
            instruction.executeUpdate("UPDATE personnage SET nomPerso = '" + tabCaracHero[0] + "', niveauPerso = " + tabCaracHero[1] + ", pointCompetence = " + tabCaracHero[2] + ", pointCaracteristique = " + tabCaracHero[3] +
                    ", experiencePerso = " + tabCaracHero[4] + ", experienceMaxPerso =" + tabCaracHero[5] + ", forcePerso =" + tabCaracHero[6] + ", intelPerso = " + tabCaracHero[7] +
                    ", constiPerso =" + tabCaracHero[8] + ", resiPerso =" + tabCaracHero[9] + ", gold =" + tabCaracHero[10] +
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
    public ArrayList<Sort> chargerSort() {
        ResultSet spell;
        boolean bool = false;
        ArrayList<Sort> result = new ArrayList<>();
        try {
            spell = instruction.executeQuery("SELECT * from spell;");
            while (spell.next()) {
                if (spell.getString("unlockSpell").equals("0")) {
                    bool = false;
                } else {
                    bool = true;
                }


                result.add(new Sort(Integer.parseInt(spell.getString("idSpell")), Integer.parseInt(spell.getString("degatSpell")), Integer.parseInt(spell.getString("largeurDevant")), Integer.parseInt(spell.getString("largeurDerriere")), Integer.parseInt(spell.getString("hauteurHaut")), Integer.parseInt(spell.getString("hauteurBas")), Integer.parseInt(spell.getString("effet_id")), Integer.parseInt(spell.getString("porteSpell")), Integer.parseInt(spell.getString("coutManaSpell")), spell.getString("libelleSpell"), spell.getString("textureSpell"), bool, Integer.parseInt(spell.getString("vitesseDeDeplacement"))));
            }
        } catch (Exception e) {
            System.out.println("Donnees charger spell : " + e);
        }
        return result;
    }

    //Requete qui recup tout les effets
    public ArrayList<Effet> chargerEffet() {
        ResultSet effet;
        ArrayList<Effet> result = new ArrayList<>();

        try {
            effet = instruction.executeQuery("SELECT * FROM effet;");
            while (effet.next()) {
                result.add(new Effet(Integer.parseInt(effet.getString("idEffet")), effet.getString("libelleEffet"), Integer.parseInt(effet.getString("duree")), Integer.parseInt(effet.getString("degatParSec")), effet.getString("textureEffet")));
            }
        } catch (Exception e) {
            System.out.println("Donnees charger effet : " + e);
        }

        return result;
    }

    public void sauvegardeFlux(int idHero, Hero hero) throws IOException {
        System.out.print("Sauvegarde : " + hero.toString());
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("Save/Save" + idHero + ".txt"));
        oos.writeObject(hero);
        oos.close();
    }

    public Hero chargementFlux(int idHero) throws IOException, ClassNotFoundException {
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("Save/Save" + idHero + ".txt"));
        Hero loadHero = new Hero((Hero) ois.readObject());
        System.out.print("Chargement : " + loadHero.toString());
        return loadHero;
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
                result.add(new Equipement(item.getString("libelleItem"), Float.parseFloat(item.getString("armureItem")), Float.parseFloat(item.getString("constiItem")), Float.parseFloat(item.getString("intelItem")), Float.parseFloat(item.getString("forceItem")), Float.parseFloat(item.getString("resiItem")), Float.parseFloat(item.getString("degatItem")), item.getString("textureItem"), Integer.parseInt(item.getString("item_type"))));
            }
        } catch (Exception e) {
            System.out.println("Chargement item : " + e);
        }
        return result;
    }

}