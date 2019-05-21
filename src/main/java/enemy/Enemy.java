package enemy;

public class Enemy {
    private int health;
    private int minDamage;
    private int maxDamage;

    public Enemy(int health, int minDamage, int maxDamage) {
        this.health = health;
        this.minDamage = minDamage;
        this.maxDamage = maxDamage;
    }

    public void attack() {

    }

    public void gainDamage(int damage) {
        this.health -= damage;
    }

    public boolean isDead() {
        return health > 0;
    }

    public int getHealth() {
        return health;
    }

    public int getMinDamage() {
        return minDamage;
    }

    public int getMaxDamage() {
        return maxDamage;
    }

}
