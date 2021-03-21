package kg.geektech.les8player;

import kg.geektech.les8game.RPG_Game;

public class God extends Hero {
    public Boolean godKillAll = false;

    public God(int health, int damage) {
        super(health, damage, SyperAbility.GOD);
    }

    public void applySuperAbility(Boss boss, Hero[] heroes) {
        int chance = RPG_Game.random.nextInt(200);
        if (chance == 15) {
            for (int i = 0; i < heroes.length; i++)
                if (heroes[i].getHealth() > 0 && boss.getHealth() > 0) {
                    if (heroes[i] == heroes[8]) {
                        continue;
                    } godKillAll = true; {
                        heroes[i].getHealth();
                        boss.setHealth(0);
                    }
                }
        }
    }
}
