package kg.geektech.les8player;

public class Witcher extends Hero {
    public Witcher(int health, int damage) {
        super(health, damage, SyperAbility.REVIVES_THE_HIRO);
    }

    @Override
    public void applySuperAbility(Boss boss, Hero[] heroes) {
        for (int i = 0; i < heroes.length ; i++) {
            if (heroes[i].getHealth() == 0){
                heroes[i].setHealth(this.getHealth());
                this.setHealth(0);
                System.out.println("Witcher revived: " + heroes[i].getClass().getSimpleName());
                break;
            }
        }

    }
}
