import enemy.*;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class EnemyTest {
    @Test
    public void testZombieCreate(){
        EnemyFactory enemyFactory = new EnemyFactory();

        Enemy zombie = enemyFactory.getEnemy(EnemyType.ZOMBIE);

        assertThat(zombie.getHealth()).isEqualTo(50);
        assertThat(zombie.getDamage()).isEqualTo(5);
    }

    @Test
    public void testSkeletonCreate(){
        EnemyFactory enemyFactory = new EnemyFactory();

        Enemy skeleton = enemyFactory.getEnemy(EnemyType.SKELETON);

        assertThat(skeleton.getHealth()).isEqualTo(15);
        assertThat(skeleton.getDamage()).isEqualTo(20);
    }
}
