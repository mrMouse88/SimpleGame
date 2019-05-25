package enemy;

import java.util.Random;

public class Enemy {
    private int health;
    private int minDamage;
    private int maxDamage;
    private float chanceOfHit;

    public Enemy(int health, int minDamage, int maxDamage, float chanceOfHit) {
        this.health = health;
        this.minDamage = minDamage;
        this.maxDamage = maxDamage;
        this.chanceOfHit = chanceOfHit;
    }

    public int attack() {
        Random random = new Random();
        if (random.nextDouble() < chanceOfHit) {
            return random.nextInt(maxDamage - minDamage + 1) + minDamage;
        } else {
            return 0;
        }

    }

    public void gainDamage(int damage) {
        this.health -= damage;
    }

    public boolean isDead() {
        return health <= 0;
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

    public float getChanceOfHit(){
        return chanceOfHit;
    }

}
