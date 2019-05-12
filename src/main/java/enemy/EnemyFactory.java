package enemy;

import static enemy.EnemyType.*;

public class EnemyFactory {
    public Enemy getEnemy(EnemyType enemyType) {
        switch (enemyType) {
            case ZOMBIE:
                return new Enemy(ZOMBIE.getHealth(), ZOMBIE.getDamage());
            case SKELETON:
                return new Enemy(SKELETON.getHealth(), SKELETON.getDamage());
            default:
                return null;
        }
    }
}
