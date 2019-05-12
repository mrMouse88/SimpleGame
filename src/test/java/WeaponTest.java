import builders.WeaponBuilder;
import items.Item;
import items.Weapon;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class WeaponTest {
    @Test
    public void weaponBuildTest(){
        Weapon weapon = new WeaponBuilder()
                .size(1)
                .weight(5)
                .minDamage(1)
                .maxDamage(10)
                .chanceOfHit(0.5f)
                .durability(10)
                .build();

        assertThat(weapon instanceof Item).isTrue();
        assertThat(weapon instanceof Weapon).isTrue();
        assertThat(weapon.getSize()).isEqualTo(1);
        assertThat(weapon.getWeight()).isEqualTo(5);
        assertThat(weapon.getMinDamage()).isEqualTo(1);
        assertThat(weapon.getMaxDamage()).isEqualTo(10);
        assertThat(weapon.getChanceOfHit()).isEqualTo(0.5f);
        assertThat(weapon.getDurability()).isEqualTo(10);
    }
}
