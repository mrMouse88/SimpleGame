import enemy.*;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class EnemyTest {
    @Test
    public void testZombieCreate(){
        EnemyFactory enemyFactory = new EnemyFactory();

        Enemy zombie = enemyFactory.getEnemy(EnemyType.ZOMBIE);

        assertThat(zombie instanceof Zombie).isTrue();
    }

    @Test
    public void testSkeletonCreate(){
        EnemyFactory enemyFactory = new EnemyFactory();

        Enemy skeleton = enemyFactory.getEnemy(EnemyType.SKELETON);

        assertThat(skeleton instanceof Skeleton).isTrue();
    }
}
