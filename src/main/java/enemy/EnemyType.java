package enemy;

public enum EnemyType {
    ZOMBIE(50,5),
    SKELETON(15,20);

    private int health;
    private int damage;

    EnemyType(int health, int damage){
        this.health = health;
        this.damage = damage;
    }

    public int getHealth(){
        return this.health;
    }

    public int getDamage(){
        return this.damage;
    }
}
