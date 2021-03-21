package kg.geektech.les8game;

import kg.geektech.les8player.*;

import java.util.Random;

public class RPG_Game {
    private static int randomNumer = 0;
    public static Random random = new Random();
    public static int rock;


    public static void start() {
        Boss boss = new Boss(1000, 50);

        Warrior warrior = new Warrior(250, 20);
        Medic medic = new Medic(220, 10, 15);
        Magic magic = new Magic(270, 25);
        Berserk berserk = new Berserk(260, 20);
        Medic assistant = new Medic(270, 15, 5);
        Golem golem = new Golem(300, 10);
        Witcher witcher = new Witcher(290, 0);
        Hacker hacker = new Hacker(280, 20);
        God god = new God(1000000, 0);



        Hero[] heroes = {warrior, medic, magic, berserk, assistant, golem, witcher, hacker, god};
        printStatistics(boss, heroes);
        while (!isGameFinished(boss, heroes ) || god.godKillAll ) {
            round(boss, heroes);
        }

    }

    private static void round(Boss boss, Hero[] heroes) {
        rock++;
        System.out.println("__________________________");
        System.out.println(++randomNumer + " -ROUHD");
        if (boss.getHealth() > 0) {
            bossHits(boss, heroes);
        }
        heroesHit(boss, heroes);
        heroesApplySuperPower(boss, heroes);
        printStatistics(boss, heroes);


    }

    private static void bossHits(Boss boss, Hero[] heroes) {
        for (int i = 0; i < heroes.length; i++) {
            if (heroes[i].getHealth() > 0) {
                if (heroes[i] == heroes[8]){
                    continue;
                }
                heroes[i].setHealth(heroes[i].getHealth() - boss.getDamage());
            }
        }
    }

    private static void heroesApplySuperPower(Boss boss, Hero[] heroes) {
        for (int i = 0; i < heroes.length; i++) {
            if (heroes[i].getHealth() > 0 && boss.getHealth() > 0) {
                heroes[i].applySuperAbility(boss, heroes);
            }
        }
    }

    private static void heroesHit(Boss boss, Hero[] heroes) {
        for (int i = 0; i < heroes.length; i++) {
            if (heroes[i].getHealth() > 0 && boss.getHealth() > 0 &&
                    heroes[i].getSyperAbility() != SyperAbility.CRITICAL_DAMAGE
                    && heroes[i].getSyperAbility() != SyperAbility.SAVE_DAMAGE_AND_REVERT) {
                boss.setHealth(boss.getHealth() - heroes[i].getDamage());
            }
        }
    }

    private static boolean isGameFinished(Boss boss, Hero[] heroes) {

        if (boss.getHealth() <= 0) {
            System.out.println("Heroes won!!!");
            return true;
        }
        boolean allHeroesDead = true;
        for (int i = 0; i < heroes.length; i++) {
            if (heroes[i].getHealth() > 0) {
                if (heroes[i] == heroes[8]){
                    continue;
                }
                allHeroesDead = false;
                
            }
        }if (allHeroesDead && boss.getHealth() < 0){
            System.out.println("GOD WON !!! \uD83D\uDE31");
        }

         if (allHeroesDead) {
            System.out.println("Boss won!!!");
        }
        return allHeroesDead;
    }

     public static void printStatistics(Boss boss, Hero[] heroes) {
        System.out.println("             ");
        System.out.println("Boss health: " + boss.getHealth() + " [" + boss.getDamage() + "]\n");
        for (int i = 0; i < heroes.length; i++) {
            System.out.println(heroes[i].getClass().getSimpleName() +
                    " health: " + heroes[i].getHealth() + "  [" +
                    heroes[i].getDamage() + "]");
            {
            }
        }
    }
}
