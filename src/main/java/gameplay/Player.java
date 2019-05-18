package gameplay;

import items.*;

import java.util.Optional;

public class Player {
    private static Player instance = new Player(100);
    private Inventory inventory = Inventory.getInstance();

    private int health;
    private Weapon weapon = null;
    private Amulet amulet = null;
    private Armor armor = null;

    private Player(int health) {
        this.health = health;
    }

    public static Player getInstance() {
        return instance;
    }

    public void resetPlayer(){
        this.health = 100;
        this.armor = null;
        this.weapon = null;
        this.amulet = null;
    }

    public Message gainDamage(int damage){
        if(armor.isDamaged() || armor.equals(null)){
            if(damage > health){
                health = 0;
                return Message.PLAYER_DEAD;
            }else{
                health -= damage;
                return Message.DAMAGE_GAINED;
            }
        }else{
            armor.gainDamage(damage);
            if(armor.isDamaged()){
                int index = inventory.getItemList().indexOf(armor);
                armor = null;
                inventory.removeItem(index);
                return Message.ITEM_DESTROYED;
            }
            return Message.DAMAGE_GAINED;
        }
    }

    public Message takeArmor(int index){
        if(inventory.isEmpty()){
            return Message.INVENTORY_EMPTY;
        }else {
            Optional item = inventory.getItem(index);
            if (item.get() instanceof Armor) {
                this.armor = (Armor) item.get();
                return Message.ARMOR_TAKEN;
            } else if (item.get() instanceof Item) {
                return Message.IS_NOT_ARMOR;
            } else {
                return Message.ITEM_NOT_FOUND;
            }
        }
    }

    public Message putAwayArmor(){
        armor = null;
        return Message.ARMOR_PUT_AWAY;
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
        weapon = null;
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
