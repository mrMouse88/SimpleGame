package items;

public class Weapon extends Item {
    private int minDamage;
    private int maxDamage;
    private float chanceOfHit;
    private int durability;

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
