package model;

import controleur.Control;
import vue.Fenetre;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import static vue.Fenetre.DEFAUT_X;
import static vue.Fenetre.DEFAUT_Y;

/**
 * Created by bastien on 28/09/16.
 */

public class Jeu {

    public static final int GRAVITE = Fenetre.adapterResolutionEnY(8);

    private int temps;

    private ArrayList<Spell> allSpell;
    private ArrayList<Effet> allEffet;

    private Niveau niveau;
    private Hero hero;
    private ArrayList<Monstre> tableauMonstre;
    private BDD bdd;

    private boolean hitBox;
    private boolean save;

    private int nbPartieLibre;
    private boolean pause;
    private boolean zoneSafe;

    public Jeu() throws SQLException {

        bdd = new BDD();

        /*Hero hero1 = new Hero("Hero1", 0, 0, 0, 0, 100, 0, 0, 0, 0, 0, "images/Save/texture_hero1.png", 0, 0);
        Hero hero2 = new Hero("Hero2", 0, 0, 0, 0, 100, 0, 0, 0, 0, 0, "images/Save/texture_hero2.png", 0, 0);
        Hero hero3 = new Hero("Hero3", 0, 0, 0, 0, 100, 0, 0, 0, 0, 0, "images/Save/texture_hero3.png", 0, 0);

        try {
            bdd.sauvegardeFlux(1, hero1);
            bdd.sauvegardeFlux(2, hero2);
            bdd.sauvegardeFlux(3, hero3);
        } catch (IOException e) {
            e.printStackTrace();
        }*/

        tableauMonstre = new ArrayList<>();
        temps = 0;
        pause = false;
        zoneSafe = true;

        allSpell = bdd.chargerSpell();
        allEffet = bdd.chargerEffet();

    }

    public void sauvegardeHero() {
        if(!bdd.isBDD()) {
            bdd.updateHero(hero.getIdHero(), hero.sauvegardeDonneesHeros());
        } else {
            try {
                bdd.sauvegardeFlux(hero.getIdHero(), hero);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void supprimerPartie(int idPartie) {
        bdd.resetPartie(idPartie);
    }


    public void setPause(boolean pause) {
        this.pause = pause;
    }

    public final boolean getPause() {
        return pause;
    }

    public void inversePause() {
        if (Control.enPartie) setPause(!getPause());
    }

    public void setZoneSafe(boolean zoneSafe) {
        this.zoneSafe = zoneSafe;
    }

    public boolean getZoneSafe() {
        return zoneSafe;
    }

    public void setHero(int id) {
        ArrayList<String> donneesHero;

       if(!bdd.isBDD()) {
           donneesHero = bdd.readHero(id);
           hero = new Hero(donneesHero.get(0), Integer.parseInt(donneesHero.get(1)), Integer.parseInt(donneesHero.get(2)), Integer.parseInt(donneesHero.get(3)),
                   Double.parseDouble(donneesHero.get(4)), Double.parseDouble(donneesHero.get(5)), Double.parseDouble(donneesHero.get(6)),
                   Double.parseDouble(donneesHero.get(7)), Double.parseDouble(donneesHero.get(8)), Double.parseDouble(donneesHero.get(9)),
                   Integer.parseInt(donneesHero.get(10)), donneesHero.get(11), (int) (DEFAUT_X / 2.0), (int) (DEFAUT_Y / 2.0));
       } else {
           try {
               hero = bdd.chargementFlux(id);
           } catch (Exception e) {
               System.out.println("Chargement hero impossible : " + e);
           }
       }
    }

    public void updateMonstre(int i) {
        if (!tableauMonstre.get(i).estVivant()) {
            getHero().recevoirExperience(getMonstre(i));
            supprimeMonstre(i);
        }
    }

    public void supprimeMonstre(int i) {
        tableauMonstre.remove(i);
    }

    public void supprimeMonstre() {
        tableauMonstre.clear();
    }

    public void supprimeHero() {
        hero = null;
    }

    public Hero getHero() {
        return hero;
    }

    public void setMonstre(int id, int positionX, int positionY) {
        ArrayList<String> donneesMonstre;

        donneesMonstre = bdd.readMonstre(id);

        tableauMonstre.add(new Monstre(donneesMonstre.get(0), getHero().niveau, Integer.parseInt(donneesMonstre.get(1)), Integer.parseInt(donneesMonstre.get(2)),
                Integer.parseInt(donneesMonstre.get(3)), Integer.parseInt(donneesMonstre.get(4)), Double.parseDouble(donneesMonstre.get(5)),
                Double.parseDouble(donneesMonstre.get(6)), Double.parseDouble(donneesMonstre.get(7)), Double.parseDouble(donneesMonstre.get(8)),
                donneesMonstre.get(12), positionX, positionY, Integer.parseInt(donneesMonstre.get(9)), Integer.parseInt(donneesMonstre.get(10)), Integer.parseInt(donneesMonstre.get(11))));
    }

    public Monstre getMonstre(int i) {

        return tableauMonstre.get(i);
    }

    public int getSizeTabMonstre() {
        return tableauMonstre.size();
    }

    public void setTemps(int temps) {
        this.temps = temps;
    }

    public void incrementeTemps() {
        temps++;
    }

    public int getTemps() {
        return temps;
    }

    public int getidPartieLibre() {

        ArrayList<Integer> idPartieDispo = bdd.idPartieLibre();
        int partieDispo = 0;

        for (int i = 0; i < idPartieDispo.size(); i++) {
            if (idPartieDispo.get(i) > 0)
                System.out.println(i);
            partieDispo = idPartieDispo.get(i);
        }

        if (partieDispo > 0) {
            return partieDispo;
        } else {
            return 0;
        }
    }

    public int getBDDNbPartieLibre() {
        return bdd.nbPartieLibre();
    }

    public void setNbPartieLibre(int nbPartieLibre) {
        this.nbPartieLibre = nbPartieLibre;
    }

    public int getNbPartieLibre() {
        return nbPartieLibre;
    }

    public void createHeroBDD(String nom, int id) {
        bdd.createPerso(nom, id);
    }

    public String readLVLPerso(int id) {
        if(bdd.isBDD()) {
            return bdd.readNiveauPerso(id);
        } else {
            return ""+hero.getNieau();
        }
    }

    public String readNomPerso(int id) {
        return bdd.readNomPerso(id);
    }

    public void setHitBox(boolean hitBox) {
        this.hitBox = hitBox;
    }

    public boolean getHitBox() {
        return hitBox;
    }

    public void setSave(boolean save) {
        this.save = save;
    }

    public boolean getSave() {
        return save;
    }

    public void setAllSpell() {
        allSpell = bdd.chargerSpell();
    }

    public void setAllEffet() {
        allEffet = bdd.chargerEffet();
    }

    public ArrayList<Effet> getAllEffet() {
        return allEffet;
    }

    public ArrayList<Spell> getAllSpell() {
        return allSpell;
    }

    public Spell getSpell(int idSpell) {
        return allSpell.get(idSpell);
    }
}