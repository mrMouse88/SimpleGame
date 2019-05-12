package enemy;

public class EnemyFactory {
    public Enemy getEnemy(EnemyType enemyType) {
        switch (enemyType) {
            case ZOMBIE:
                return new Enemy(50, 5);
            case SKELETON:
                return new Enemy(15, 20);
            default:
                return null;
        }
    }
}
