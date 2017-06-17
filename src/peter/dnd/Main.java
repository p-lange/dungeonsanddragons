package peter.dnd;

import peter.dnd.model.AttackRoll;
import peter.dnd.model.PlayerCharacter;
import peter.dnd.model.dice;

public class Main {

    public static void main(String[] args) {

       // testOne();
       // fireball();
       // attackTest();
        avgTest();

    }

    private static void avgTest() {
        System.out.println(dice.D6.getAvgResult());
        System.out.println(dice.D6.getAvgResult(5));
    }

    /*
        private static void testOne(){
            PlayerCharacter player = new PlayerCharacter();
            System.out.println(player.getProfBonus());/

        }
        */
    private static void fireball(){
        System.out.println("You throw a fireball, which deals "+  dice.D6.rollDice(8) + " fire damage!");
    }
    private static void attackTest(){
        PlayerCharacter player = new PlayerCharacter(15, 12, 14, 10, 8, 12);
        AttackRoll attack = new AttackRoll(player.getStrMod(), player.getProfBonus());
        if(attack.rollAttack(18)){
           System.out.printf("%nYou rolled %d, for a total of %d, you hit!%n",
                   attack.getAttackRoll(),
                   attack.getAttackTotal());
       } else{
           System.out.printf("%nYou rolled %d, for a total of %d, you missed!%n",
                   attack.getAttackRoll(),
                   attack.getAttackTotal());
       }


    }


}
