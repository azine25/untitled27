package kg.geektech.les8player;

public abstract class Hero  extends GameEntity implements HavingSyperAbility {
    private SyperAbility syperAbility;


    public Hero(int health, int damage,SyperAbility syperAbility) {
        super(health, damage);
        this.syperAbility = syperAbility;
    }

    public SyperAbility getSyperAbility(){
        return syperAbility;
    }
    public void setSyperAbility(SyperAbility syperAbility){
        this.syperAbility = syperAbility;
    }

}
