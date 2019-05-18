package items;

import gameplay.Message;

public class Armor extends Item {
    private int health;
    private String name;

    public Armor(int weight, int size, int health, String name) {
        super(weight, size);
        this.health = health;
        this.name = name;
    }

    public boolean isDamaged() {
        return health <= 0;
    }

    public Message gainDamage(int damage) {
        if (damage >= health) {
            health = 0;
            return Message.ITEM_DESTROYED;
        } else {
            health -= damage;
            return Message.DAMAGE_GAINED;
        }
    }

    public int getHealth() {
        return health;
    }

    public String getName() {
        return name;
    }
}
