import enemy.Enemy;
import enemy.EnemyFactory;
import enemy.EnemyType;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class EnemyTest {
    @Test
    public void testZombieCreate() {
        EnemyFactory enemyFactory = new EnemyFactory();

        Enemy zombie = enemyFactory.getEnemy(EnemyType.ZOMBIE);

        assertThat(zombie.getHealth()).isEqualTo(EnemyType.ZOMBIE.getHealth());
        assertThat(zombie.getMinDamage()).isEqualTo(EnemyType.ZOMBIE.getMinDamage());
        assertThat(zombie.getMaxDamage()).isEqualTo(EnemyType.ZOMBIE.getMaxDamage());
    }

    @Test
    public void testSkeletonCreate() {
        EnemyFactory enemyFactory = new EnemyFactory();

        Enemy skeleton = enemyFactory.getEnemy(EnemyType.SKELETON);

        assertThat(skeleton.getHealth()).isEqualTo(EnemyType.SKELETON.getHealth());
        assertThat(skeleton.getMinDamage()).isEqualTo(EnemyType.SKELETON.getMinDamage());
        assertThat(skeleton.getMaxDamage()).isEqualTo(EnemyType.SKELETON.getMaxDamage());
    }
}
