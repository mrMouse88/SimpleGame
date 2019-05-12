package gameplay;

import items.*;

import java.util.Optional;

public class Player {
    private static Player instance = new Player();
    private Inventory inventory = Inventory.getInstance();

    private int health;
    private Weapon weapon = null;
    private Amulet amulet = null;
    private Armor armor = null;

    private Player() {
    }

    public static Player getInstance() {
        return instance;
    }

    public Message takeWeapon(int index) {
        Optional item = inventory.getItem(index);
        if (item.get() instanceof Weapon) {
            this.weapon = (Weapon) item.get();
            return Message.WEAPON_TAKEN;
        } else if (item.get() instanceof Item) {
            return Message.IS_NOT_WEAPON;
        } else {
            return Message.ITEM_NOT_FOUND;
        }
    }

    public Message putAwayWeapon(){
        weapon = null;
        return Message.WEAPON_PUT_AWAY;
    }

    public int getHealth() {
        return health;
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public Amulet getAmulet() {
        return amulet;
    }

    public Armor getArmor() {
        return armor;
    }
}
