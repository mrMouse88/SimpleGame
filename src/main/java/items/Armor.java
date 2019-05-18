package items;

public class Armor extends Item {
    private int health;
    private String name;

    public Armor(int weight, int size, int health, String name) {
        super(weight, size);
        this.health = health;
        this.name = name;
    }

    public int getHealth() {
        return health;
    }

    public String getName() {
        return name;
    }
}
