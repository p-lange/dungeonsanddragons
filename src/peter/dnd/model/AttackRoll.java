package peter.dnd.model;


public class AttackRoll {

    private int armor;
    private boolean isHit = false;
    private int abilityMod;
    private int profMod;
    private int attackTotal;
    private int attackRoll;

    public int getAttackTotal() {
        return attackTotal;
    }

    public int getAttackRoll() {
        return attackRoll;
    }


   public AttackRoll(int abilityMod, int profMod){
        this.abilityMod = abilityMod;
        this.profMod = profMod;
    }

    public boolean rollAttack(int armor){
       this.attackRoll = dice.D20.rollDice();
       this.attackTotal = attackRoll + this.abilityMod + this.profMod;
        isHit = false;
        if ((attackTotal) >= armor){
            isHit = true;
        }
        return isHit;
    }


}