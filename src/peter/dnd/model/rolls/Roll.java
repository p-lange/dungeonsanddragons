package peter.dnd.model.rolls;

import peter.dnd.model.dice;

/**
 * Created by Peter on 6/17/2017.
 */
public class Roll {

    private int dieRoll;
    private int totalRoll;
    private boolean isHit;
    private boolean isCrit;


    public Roll(int difficulty, int modifier, boolean advantage, boolean disadvantage){

        dieRoll = 0;
        if ((advantage && disadvantage)||(!advantage && !disadvantage)){
            dieRoll = dice.D20.rollDice();
        } else {
            if (!advantage && disadvantage){
                //Roll with disadvantage
                int rollOne = dice.D20.rollDice();
                int rollTwo = dice.D20.rollDice();
                dieRoll = Math.min(rollOne, rollTwo);

            } else {
                if (advantage && !disadvantage){
                    //Roll with advantage
                    int rollOne = dice.D20.rollDice();
                    int rollTwo = dice.D20.rollDice();
                    dieRoll = Math.max(rollOne, rollTwo);
                }

            }
        }
        totalRoll = dieRoll + modifier;

        if (dieRoll == 20){
            isCrit = true;
            isHit = true;
        } else {
            if(totalRoll >= difficulty) {
                isHit = true;
            }
        }

    }


    public int getTotalRoll() {
        return totalRoll;
    }

    public void setTotalRoll(int totalRoll) {
        this.totalRoll = totalRoll;
    }

    public boolean isCrit() {
        return isCrit;
    }

    public void setCrit(boolean crit) {
        isCrit = crit;
    }

    public int getRoll() {
        return dieRoll;
    }

    public void setRoll(int roll) {
        this.dieRoll = roll;
    }

    public boolean isHit() {
        return isHit;
    }

    public void setHit(boolean hit) {
        isHit = hit;
    }
}
