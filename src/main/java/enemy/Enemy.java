package enemy;

public class Enemy {
    private int health;
    private int damage;

    public Enemy(int health, int damage) {
        this.health = health;
        this.damage = damage;
    }

    public void attack() {

    }

    public void gainDamage() {

    }

    public boolean isDead() {
        return health > 0;
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
