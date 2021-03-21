package kg.geektech.les8player;

import kg.geektech.les8game.RPG_Game;

public class Magic extends Hero {
    public Magic(int health, int damage) {
        super(health, damage, SyperAbility.BOOST);
    }

    private int dopDamage = RPG_Game.random.nextInt(2) + 1;

    @Override
    public void applySuperAbility(Boss boss, Hero[] heroes) {
        for (int i = 0; i < heroes.length; i++) {
            if(heroes[i].getHealth() > 0 )
                if (heroes[i] == heroes[8]){
                    continue;
                }
            heroes[i].setDamage(heroes[i].getDamage() + dopDamage);
        }
        System.out.println("Mage increase damage for: " + dopDamage);
    }
}
