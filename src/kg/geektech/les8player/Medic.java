package kg.geektech.les8player;

public class Medic extends Hero {
    private int healPoints;

    public Medic(int health, int damage,int healPoints) {
        super(health, damage, SyperAbility.HEAL);
        this.healPoints = healPoints;
    }

    public int getHealPoints() {
        return healPoints;
    }

    public void setHealPoints(int healPoints) {
        this.healPoints = healPoints;
    }

    @Override
    public void applySuperAbility(Boss boss, Hero[] heroes) {
        for (int i = 0; i < heroes.length; i++) {
            if (heroes[i].getHealth() > 0 && this != heroes[i] ) {
                if (heroes[i] == heroes[8]){
                    continue;
                }
                heroes[i].setHealth(heroes[i].getHealth() + healPoints);
            }

        }
    }

}








