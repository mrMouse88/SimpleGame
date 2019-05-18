import gameplay.Inventory;
import gameplay.Message;
import gameplay.Player;
import items.builders.ArmorBuilder;
import items.builders.WeaponBuilder;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class PlayerTest {
    private Player player = Player.getInstance();
    private Inventory inventory = Inventory.getInstance();

    @BeforeEach // fresh player and inventory instance
    public void initialize(){
        player.resetPlayer();
        inventory.removeAllItems();
    }

    //Armor tests
    @Test
    public void takeArmorTest(){
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
    public void takeNotArmorTest(){
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
    public void takeNotExistingArmorTest(){
        assertThat(player.getArmor()).isEqualTo(null);
        assertThat(player.takeArmor(0)).isEqualTo(Message.INVENTORY_EMPTY);
        assertThat(player.getArmor()).isEqualTo(null);
    }

    //Waepon tests
}
