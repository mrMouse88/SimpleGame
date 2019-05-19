import gameplay.Inventory;
import gameplay.Player;
import items.builders.WeaponBuilder;
import items.Item;
import items.Weapon;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class WeaponTest {
    @Test
    public void weaponBuildTest() {
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

    @Test
    public void wearTest() {
        Player player = Player.getInstance();
        Inventory inventory = Inventory.getInstance();
        Weapon weapon = new WeaponBuilder()
                .size(1)
                .weight(5)
                .minDamage(1)
                .maxDamage(10)
                .chanceOfHit(0.5f)
                .durability(2)
                .build();

        inventory.addItem(weapon);

        assertThat(player.getWeapon()).isNotEqualTo(weapon);
        player.takeWeapon(0);
        assertThat(player.getWeapon()).isEqualTo(weapon);
        assertThat(player.getWeapon().getDurability()).isEqualTo(2);
        player.attack();
        assertThat(player.getWeapon().getDurability()).isEqualTo(1);
        player.attack();
        assertThat(player.getWeapon()).isNotEqualTo(weapon);

    }
}
