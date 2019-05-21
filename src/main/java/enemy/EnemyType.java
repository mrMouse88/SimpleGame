package enemy;

public enum EnemyType {
    ZOMBIE(50, 5, 15),
    SKELETON(15, 20, 40);

    private int health;
    private int minDamage;
    private int maxDamage;

    EnemyType(int health, int minDamage, int maxDamage) {
        this.health = health;
        this.minDamage = minDamage;
        this.maxDamage = maxDamage;
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
}
