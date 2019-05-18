package items.builders;

import items.Weapon;

public class WeaponBuilder {
    private int size;
    private int weight;
    private int minDamage;
    private int maxDamage;
    private float chanceOfHit;
    private int durability;
    private String name;

    public WeaponBuilder size(int size) {
        this.size = size;
        return this;
    }

    public WeaponBuilder weight(int weight) {
        this.weight = weight;
        return this;
    }

    public WeaponBuilder minDamage(int minDamage){
        this.minDamage = minDamage;
        return this;
    }

    public WeaponBuilder maxDamage(int maxDamage){
        this.maxDamage = maxDamage;
        return this;
    }

    public WeaponBuilder chanceOfHit(float chanceOfHit){
        this.chanceOfHit = chanceOfHit;
        return this;
    }

    public WeaponBuilder durability(int durability){
        this.durability = durability;
        return this;
    }

    public WeaponBuilder name(String name){
        this.name = name;
        return this;
    }

    public Weapon build(){
        return new Weapon(weight, size, minDamage, maxDamage, chanceOfHit, durability, name);
    }
}
