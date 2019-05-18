package items.builders;

import items.Armor;

public class ArmorBuilder {
    private int size;
    private int weight;
    private int health;
    private String name;

    public ArmorBuilder size(int size){
        this.size = size;
        return this;
    }

    public ArmorBuilder weight(int weight){
        this.weight = weight;
        return this;
    }

    public ArmorBuilder health(int health){
        this.health = health;
        return this;
    }

    public ArmorBuilder name(String name){
        this.name = name;
        return this;
    }

    public Armor build(){
        return new Armor(weight, size, health, name);
    }
}
