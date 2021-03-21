package kg.geektech.les8player;

public class Berserk extends Hero {
    public Berserk(int health, int damage) {
        super(health, damage, SyperAbility.SAVE_DAMAGE_AND_REVERT);
    }

    @Override
    public void applySuperAbility(Boss boss, Hero[] heroes) {
        if (boss.getHealth() > 0) {
            int partDamage = boss.getDamage() / 3;
            int damageValue = this.getDamage() + partDamage;
            boss.setHealth(boss.getHealth() - damageValue);
            System.out.println("Berserker hit: " + partDamage);
        }
    }
}
