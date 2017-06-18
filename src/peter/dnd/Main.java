package peter.dnd;

import peter.dnd.model.PlayerCharacter;
import peter.dnd.model.characters.Creature;
import peter.dnd.model.dice;
import peter.dnd.model.rolls.AttackRoll;
import peter.dnd.model.rolls.DamageRoll;

public class Main {

    public static void main(String[] args) {

        // testOne();
        // fireball();
        // attackTest();
        //   avgTest();
       combatLoop();


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
    private static void fireball() {
        System.out.println("You throw a fireball, which deals " + dice.D6.rollDice(8) + " fire DamageRoll!");
    }

    private static void attackTest() {
        PlayerCharacter player = new PlayerCharacter(15, 12, 14, 10, 8, 12);
        peter.dnd.model.AttackRoll attack = new peter.dnd.model.AttackRoll(player.getStrMod(), player.getProfBonus());
        if (attack.rollAttack(18)) {
            System.out.printf("%nYou rolled %d, for a total of %d, you hit!%n",
                    attack.getAttackRoll(),
                    attack.getAttackTotal());
        } else {
            System.out.printf("%nYou rolled %d, for a total of %d, you missed!%n",
                    attack.getAttackRoll(),
                    attack.getAttackTotal());
        }


    }


    private static void combatLoop() {
        Creature player = new Creature("Peter", 16, 12, 14, 10, 10, 10, 20, 16, 2);
        Creature monster = new Creature("Goblin", 12, 14, 12, 10, 10, 10, 15, 14, 2);
        int damage;

        do {
            AttackRoll playerAttack = new AttackRoll(player, monster,false, false);
            System.out.println(player.getName() + " has rolled a " + playerAttack.getRoll() + ", for a total of " + playerAttack.getTotalRoll() + ".");
            if (playerAttack.isHit()) {

                //roll the damage dice
                DamageRoll damageRoll = new DamageRoll(1, dice.D8, (player.calculateMod(player.getStrength())), playerAttack.isCrit());
                damage = damageRoll.getTotal();

                System.out.println(player.getName() + " has hit the " + monster.getName() + " for " + damage + " damage!");

                //reduce monster HP by damage
                monster.takeDamage(damage);

                System.out.println("The " + monster.getName() + " has " + monster.getHitPointsCurrent() + " HP remaining.");

            } else {
                System.out.println(player.getName() + " has missed the " + monster.getName() + "!");
            }
            if (!monster.isAlive()) {
                System.out.println("The Goblin is dead!");
                break;
            }
            AttackRoll monsterAttack = new AttackRoll(monster, player,false, false);
            System.out.println(monster.getName() + " has rolled a " + monsterAttack.getRoll() + ", for a total of " + monsterAttack.getTotalRoll() + ".");
            if (monsterAttack.isHit()) {

                DamageRoll damageRoll = new DamageRoll(1, dice.D8, (monster.calculateMod(player.getStrength())), monsterAttack.isCrit());
                damage = damageRoll.getTotal();

                System.out.println(monster.getName() + " has hit " + player.getName() + " for " + damage + " damage!");

                player.takeDamage(damage);

                System.out.println(player.getName() + " has " + player.getHitPointsCurrent() + " HP remianing.");

            } else {
                System.out.println("The " + monster.getName() + " has missed " + player.getName() + "!");
            }
            if (!player.isAlive()) {
                System.out.println("Peter is dead!");
                break;
            }

        } while (player.getHitPointsCurrent() > 0 || monster.getHitPointsCurrent() > 0);
        System.out.println("Combat Over!");

    }


}
