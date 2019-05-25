package enemy;

public enum EnemyType {
    ZOMBIE(50, 5, 15, 0.7f),
    SKELETON(15, 20, 40, 0.3f);

    private int health;
    private int minDamage;
    private int maxDamage;
    private float chanceOfHit;

    EnemyType(int health, int minDamage, int maxDamage, float chanceOfHit) {
        this.health = health;
        this.minDamage = minDamage;
        this.maxDamage = maxDamage;
        this.chanceOfHit = chanceOfHit;
    }

    public int getHealth() {
        return this.health;
    }

    public int getMinDamage() {
        return this.minDamage;
    }

    public int getMaxDamage() {
        return this.maxDamage;
    }

    public float getChanceOfHit(){
        return this.chanceOfHit;
    }
}
