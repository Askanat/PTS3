package model;

/**
 * Created by leo on 23/01/17.
 */
public class Spell {

    private int degatSpell, effet_id, porteSpell, coutManaSpell;
    private String libelleSpell, textureSpell;

    public Spell(int degatSpell,int effet_id, int porteSpell, int coutManaSpell, String libelleSpell, String textureSpell) {
        this.degatSpell = degatSpell;
        this.effet_id = effet_id;
        this.porteSpell = porteSpell;
        this.coutManaSpell = coutManaSpell;
        this.libelleSpell = libelleSpell;
        this.textureSpell = textureSpell;
    }
}
