package enemy;

public class Skeleton implements Enemy {
    private int health = 25;
    private int damage = 15;

    @Override
    public void attack() {

    }

    @Override
    public void gainDamage() {

    }

    @Override
    public boolean isDead() {
        return false;
    }

    public int getHealth() {
        return health;
    }

    public int getDamage(){
        return damage;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }
}
