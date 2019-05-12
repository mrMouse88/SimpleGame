package gameplay;

import items.Weapon;

public class Player {
    private static Player instance = new Player();

    private int health;
    private Weapon weapon;
    private Amulet amulet;
    private Armor armor;

    private Player(){}

    public Player getInstance(){
        return instance;
    }

    public
}
