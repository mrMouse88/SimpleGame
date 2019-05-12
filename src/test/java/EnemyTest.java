import enemy.*;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class EnemyTest {
    @Test
    public void testZombieCreate() {
        EnemyFactory enemyFactory = new EnemyFactory();

        Enemy zombie = enemyFactory.getEnemy(EnemyType.ZOMBIE);

        assertThat(zombie.getHealth()).isEqualTo(EnemyType.ZOMBIE.getHealth());
        assertThat(zombie.getDamage()).isEqualTo(EnemyType.ZOMBIE.getDamage());
    }

    @Test
    public void testSkeletonCreate() {
        EnemyFactory enemyFactory = new EnemyFactory();

        Enemy skeleton = enemyFactory.getEnemy(EnemyType.SKELETON);

        assertThat(skeleton.getHealth()).isEqualTo(EnemyType.SKELETON.getHealth());
        assertThat(skeleton.getDamage()).isEqualTo(EnemyType.SKELETON.getDamage());
    }
}
