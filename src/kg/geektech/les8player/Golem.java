package kg.geektech.les8player;

public class Golem extends Hero {
    public Golem(int health, int damage) {
        super(health, damage, SyperAbility.PROTECTION_OF_HEROES);
    }

    @Override
    public void applySuperAbility(Boss boss, Hero[] heroes) {
        if (boss.getHealth() > 0) {
            int golemHits = boss.getDamage() / 5;


            for (int i = 0; i < heroes.length; i++) {
                if(heroes[i].getHealth() > 0){
                    if (heroes[i] == heroes[8]){
                        continue;
                    }
                    heroes[i].setHealth( heroes[i].getHealth() + golemHits);}
            }
            this.setHealth(this.getHealth() - (golemHits * (heroes.length - 1)));
            System.out.println("Golem blocks the blow on: " + golemHits);

        }
    }
}