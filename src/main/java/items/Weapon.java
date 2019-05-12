package items;

public class Weapon extends Item {
    private int minDamage;
    private int maxDamage;
    private float chanceOfHit;
    private int durability;

    public Weapon(int weight, int size, int minDamage, int maxDamage, float chanceOfHit, int durability) {
        super(weight, size);
        this.minDamage = minDamage;
        this.maxDamage = maxDamage;
        this.chanceOfHit = chanceOfHit;
        this.durability = durability;
    }

    public int getMinDamage() {
        return minDamage;
    }

    public int getMaxDamage() {
        return maxDamage;
    }

    public float getChanceOfHit() {
        return chanceOfHit;
    }

    public int getDurability() {
        return durability;
    }
}
