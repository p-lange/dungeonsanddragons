package peter.dnd.model.rolls;

import peter.dnd.model.dice;

/**
 * Created by Peter on 6/17/2017.
 */
public class roll {

    private int difficulty;
    private int modifier;
   // private boolean advantage;
   // private boolean disadvantage;

    public static boolean makeRoll(int difficulty,int modifier, boolean advantage, boolean disadvantage){

        int result = 0;
        if ((advantage && disadvantage)||(!advantage && !disadvantage)){
            result = dice.D20.rollDice();
        } else {
            if (!advantage && disadvantage){
                //roll with disadvantage
                int rollOne = dice.D20.rollDice();
                int rollTwo = dice.D20.rollDice();
                result = Math.min(rollOne, rollTwo);
            } else {
                if (advantage && !disadvantage){
                    //roll with advantage
                    int rollOne = dice.D20.rollDice();
                    int rollTwo = dice.D20.rollDice();
                    result = Math.max(rollOne, rollTwo);
                }
            }
        }

        if (result + modifier >= difficulty ){
            return true;
        }
        return false;
    }

}
