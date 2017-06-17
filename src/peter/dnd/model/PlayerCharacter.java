package peter.dnd.model;

public class PlayerCharacter{

    private String charClass;
    private String charArchetype;
    private String hitDie;
    private int level;
    private String[] proficiencies;
    private int profBonus = 2;
    private int strScore;
    private int conScore;
    private int dexScore;
    private int intScore;
    private int wisScore;
    private int chaScore;
    private int strMod;
    //don't store mods as variables just make a method that returns the mod in this class.



    public PlayerCharacter(int str, int dex, int con, int intel, int wis, int cha){
        this.strScore = str;
        this.dexScore = dex;
        this.conScore = con;
        this.intScore = intel;
        this.wisScore = wis;
        this.chaScore = cha;
        this.strMod = (str-10)/2;

    }

    public int getStrMod(){
        return strMod;
    }
    public int getProfBonus(){
        return profBonus;
    }



}