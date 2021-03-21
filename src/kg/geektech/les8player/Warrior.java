package kg.geektech.les8player;

import kg.geektech.les8game.RPG_Game;

public class Warrior extends Hero {
    public Warrior(int health, int damage) {
        super(health, damage, SyperAbility.CRITICAL_DAMAGE);
    }

    @Override
    public void applySuperAbility(Boss boss, Hero[] heroes) {
        if (boss.getHealth() > 0) {
            int coefficient = RPG_Game.random.nextInt(3) + 2;
            boss.setHealth(boss.getHealth() - this.getDamage() * coefficient);
            System.out.println("Warrior hits critically " + ((this.getDamage() * coefficient) - this.getDamage()));
        }

    }
}
