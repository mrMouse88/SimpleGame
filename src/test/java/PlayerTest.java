import gameplay.Inventory;
import gameplay.Message;
import gameplay.Player;
import items.builders.ArmorBuilder;
import items.builders.WeaponBuilder;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.swing.text.MaskFormatter;

import static org.assertj.core.api.Assertions.assertThat;

public class PlayerTest {
    private Player player = Player.getInstance();
    private Inventory inventory = Inventory.getInstance();

    @BeforeEach // fresh player and inventory instance
    public void initialize() {
        player.resetPlayer();
        inventory.removeAllItems();
    }

    //Damage test
    @Test
    public void gainDamageTest() {
        assertThat(player.getHealth()).isEqualTo(100);
        assertThat(player.gainDamage(50)).isEqualTo(Message.DAMAGE_GAINED);
        assertThat(player.getHealth()).isEqualTo(50);
        assertThat(player.gainDamage(50)).isEqualTo(Message.PLAYER_DEAD);
        assertThat(player.getHealth()).isEqualTo(0);
    }

    @Test
    public void gainDamageWithArmorTest() {
        inventory.addItem(new ArmorBuilder()
                .size(1)
                .weight(1)
                .name("normal Armor")
                .health(100)
                .build());

        player.takeArmor(0);
        assertThat(player.hasArmor()).isTrue();
        assertThat(player.getHealth()).isEqualTo(100);
        assertThat(player.gainDamage(50)).isEqualTo(Message.DAMAGE_GAINED);

        assertThat(player.hasArmor()).isTrue();
        assertThat(player.getHealth()).isEqualTo(100);
        assertThat(player.gainDamage(50)).isEqualTo(Message.ITEM_DESTROYED);
        assertThat(player.hasArmor()).isFalse();
        assertThat(inventory.isEmpty()).isTrue();

        assertThat(player.getHealth()).isEqualTo(100);
        assertThat(player.gainDamage(100)).isEqualTo(Message.PLAYER_DEAD);
        assertThat(player.getHealth()).isEqualTo(0);
    }

    @Test
    public void attackTest() {
        inventory.addItem(new WeaponBuilder()
                .size(1)
                .weight(1)
                .size(1)
                .durability(10)
                .minDamage(5)
                .maxDamage(10)
                .name("sword")
                .chanceOfHit(1)
                .build()
        );
        int attack = player.attack();
        System.out.println(attack);
        assertThat(attack).isBetween(0,2);

        attack = player.attack();
        System.out.println(attack);
        assertThat(attack).isBetween(0,2);

        player.takeWeapon(0);
        attack = player.attack();
        System.out.println(attack);
        assertThat(attack).isBetween(5,10);

        attack = player.attack();
        System.out.println(attack);
        assertThat(attack).isBetween(5,10);
    }

    //Armor tests
    @Test
    public void takeArmorTest() {
        inventory.addItem(new ArmorBuilder()
                .size(1)
                .weight(1)
                .health(100)
                .name("Normal armor").build()
        );
        assertThat(player.getArmor()).isEqualTo(null);
        assertThat(player.takeArmor(0)).isEqualTo(Message.ARMOR_TAKEN);
        assertThat(player.getArmor().getHealth()).isEqualTo(100);
    }

    @Test
    public void putAwayArmorTest() {
        inventory.addItem(new ArmorBuilder()
                .size(1)
                .weight(1)
                .health(100)
                .name("Normal armor").build()
        );
        assertThat(player.getArmor()).isEqualTo(null);
        assertThat(player.takeArmor(0)).isEqualTo(Message.ARMOR_TAKEN);
        assertThat(player.getArmor().getHealth()).isEqualTo(100);
        assertThat(player.putAwayArmor()).isEqualTo(Message.ARMOR_PUT_AWAY);
        assertThat(player.getArmor()).isEqualTo(null);
    }

    @Test
    public void takeNotArmorTest() {
        inventory.addItem(new WeaponBuilder()
                .size(1)
                .weight(1)
                .chanceOfHit(0.1f)
                .durability(1)
                .minDamage(1)
                .maxDamage(2)
                .name("Normal sword")
                .build());

        assertThat(player.getArmor()).isEqualTo(null);
        assertThat(player.takeArmor(0)).isEqualTo(Message.IS_NOT_ARMOR);
        assertThat(player.getArmor()).isEqualTo(null);
    }

    @Test
    public void takeNotExistingArmorTest() {
        assertThat(player.getArmor()).isEqualTo(null);
        assertThat(player.takeArmor(0)).isEqualTo(Message.INVENTORY_EMPTY);
        assertThat(player.getArmor()).isEqualTo(null);
    }

    //Waepon tests
}
