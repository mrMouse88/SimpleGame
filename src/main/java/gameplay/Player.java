package gameplay;

import items.*;
import items.builders.WeaponBuilder;

import java.util.Optional;
import java.util.Random;

public class Player {
    private static Player instance = new Player(100);
    private Inventory inventory = Inventory.getInstance();

    //HANDS as weapon
    private final Weapon HANDS = new WeaponBuilder()
            .size(0)
            .weight(0)
            .durability(1)
            .minDamage(1)
            .maxDamage(2)
            .chanceOfHit(0.5f)
            .build();

    private int health;
    private Weapon weapon = HANDS;
    private Amulet amulet = null;
    private Armor armor = null;

    private Player(int health) {
        this.health = health;
    }

    public static Player getInstance() {
        return instance;
    }

    public void resetPlayer() {
        this.health = 100;
        this.armor = null;
        this.weapon = HANDS;
        this.amulet = null;
    }

    public int attack() {
        if (!weapon.equals(HANDS)) {
            weapon.wear();
            if (weapon.getDurability() <= 0) {
                putAwayWeapon();
            }
        }
        Random random = new Random();
        if (random.nextDouble() < weapon.getChanceOfHit()) {
            return random.nextInt(weapon.getMaxDamage() - weapon.getMinDamage() + 1) + weapon.getMinDamage();
        } else {
            return 0;
        }

    }

    public Message gainDamage(int damage) {
        if (hasArmor()) {
            armor.gainDamage(damage);
            if (armor.isDamaged()) {
                int index = inventory.getItemList().indexOf(armor);
                putAwayArmor();
                inventory.removeItem(index);
                return Message.ITEM_DESTROYED;
            }
            return Message.DAMAGE_GAINED;
        } else {
            if (damage >= health) {
                health = 0;
                return Message.PLAYER_DEAD;
            } else {
                health -= damage;
                return Message.DAMAGE_GAINED;
            }
        }
    }

    public Message takeArmor(int index) {
        if (inventory.isEmpty()) {
            return Message.INVENTORY_EMPTY;
        } else {
            Optional item = inventory.getItem(index);
            if (item.get() instanceof Armor) {
                this.armor = (Armor) item.get();
                armor.setTaken(true);
                return Message.ARMOR_TAKEN;
            } else if (item.get() instanceof Item) {
                return Message.IS_NOT_ARMOR;
            } else {
                return Message.ITEM_NOT_FOUND;
            }
        }
    }

    public Message putAwayArmor() {
        armor.setTaken(false);
        armor = null;
        return Message.ARMOR_PUT_AWAY;
    }

    public boolean hasArmor() {
        return !(armor == null);
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

    public Message putAwayWeapon() {
        weapon = HANDS;
        return Message.WEAPON_PUT_AWAY;
    }

    public boolean isDead() {
        return health > 0;
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
