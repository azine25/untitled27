package kg.geektech.les8player;

import kg.geektech.les8game.RPG_Game;

public class Hacker extends Hero {

    public Hacker(int health, int damage) {
        super(health, damage, SyperAbility.HACKER);
    }

    @Override
    public void applySuperAbility(Boss boss, Hero[] heroes) {
        int boosRandom = RPG_Game.random.nextInt(10) + 1;
        int heroesRandom = RPG_Game.random.nextInt(heroes.length);

        for (int i = 0; i < heroes.length; i++) {
            if (heroes[i].getHealth() > 0) {
                if ( RPG_Game.rock % 2 ==  0) {
                    boss.setHealth(boss.getHealth() - boosRandom);
                    if (heroes[heroesRandom] == heroes[8]){
                        continue;
                    }
                    heroes[heroesRandom].setHealth(heroes[heroesRandom].getHealth() + boosRandom);
                    System.out.println("Hacker takes life on:" + boosRandom + " Gives life: " +
                            heroes[heroesRandom].getClass().getSimpleName());

                }
                break;
            }
        }
    }
}
