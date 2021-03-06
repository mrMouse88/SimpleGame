package enemy;

import static enemy.EnemyType.SKELETON;
import static enemy.EnemyType.ZOMBIE;

public class EnemyFactory {
    public Enemy getEnemy(EnemyType enemyType) {
        switch (enemyType) {
            case ZOMBIE:
                return new Enemy(ZOMBIE.getHealth(), ZOMBIE.getMinDamage(), ZOMBIE.getMaxDamage(), ZOMBIE.getChanceOfHit());
            case SKELETON:
                return new Enemy(SKELETON.getHealth(), SKELETON.getMinDamage(), SKELETON.getMaxDamage(), SKELETON.getChanceOfHit());
            default:
                return null;
        }
    }
}
