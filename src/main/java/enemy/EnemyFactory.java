package enemy;

public class EnemyFactory {
    public Enemy getEnemy(EnemyType enemyType){
        switch (enemyType){
            case ZOMBIE:
                return new Zombie();
            case SKELETON:
                return new Skeleton();
            default:
                return null;
        }
    }
}
