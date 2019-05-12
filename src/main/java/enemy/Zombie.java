package enemy;

public class Zombie implements Enemy {
    private int health = 50;
    private int damage = 5;

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

    public void setHealth(int health) {
        this.health = health;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }
}
