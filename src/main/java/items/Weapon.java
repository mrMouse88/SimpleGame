package items;

public class Weapon extends Item {
    private int minDamage;
    private int maxDamage;
    private float chanceOfHit;
    private int durability;
    private String name;

    public Weapon(int weight, int size, int minDamage, int maxDamage, float chanceOfHit, int durability, String name) {
        super(weight, size);
        this.minDamage = minDamage;
        this.maxDamage = maxDamage;
        this.chanceOfHit = chanceOfHit;
        this.durability = durability;
        this.name = name;
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

    public void wear() {
        durability--;
    }
}
