import gameplay.Inventory;
import gameplay.Message;
import gameplay.Player;
import items.Item;
import items.builders.ArmorBuilder;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

public class InventoryTest {
    private Inventory inventory = Inventory.getInstance();
    private Player player = Player.getInstance();

    @BeforeEach
    public void initialize() {
        inventory.removeAllItems();
        player.resetPlayer();
    }

    @Test
    public void inventoryCorrectAddingTest() {
        assertThat(inventory.addItem(TestItemFactory.getCorrectItem())).isEqualTo(Message.ITEM_ADDED);
        assertThat(inventory.getFill()).isEqualTo(1);
        assertThat(inventory.getLoad()).isEqualTo(1);
    }

    @Test
    public void inventoryTooBigAddingTest() {
        assertThat(inventory.addItem(TestItemFactory.getBigItem())).isEqualTo(Message.ITEM_TOO_BIG);
        assertThat(inventory.isEmpty()).isTrue();
    }

    @Test
    public void inventoryTooHeavyAddingTest() {
        assertThat(inventory.addItem(TestItemFactory.getHeavyItem())).isEqualTo(Message.ITEM_TOO_HEAVY);
        assertThat(inventory.isEmpty()).isTrue();
    }

    @Test
    public void getItemTest() {
        Item item = TestItemFactory.getCorrectItem();
        inventory.addItem(item);
        assertThat(inventory.getItem(0)).isEqualTo(Optional.of(item));
        assertThat(inventory.getItem(1)).isEqualTo(Optional.empty());
    }

    @Test
    public void removeItemTest() {
        inventory.addItem(TestItemFactory.getCorrectItem());
        assertThat(inventory.getLoad()).isEqualTo(1);
        assertThat(inventory.getFill()).isEqualTo(1);
        assertThat(inventory.removeItem(0)).isEqualTo(Message.ITEM_REMOVED);
        assertThat(inventory.getLoad()).isEqualTo(0);
        assertThat(inventory.getFill()).isEqualTo(0);
        assertThat(inventory.removeItem(0)).isEqualTo(Message.ITEM_NOT_FOUND);
    }

    @Test
    public void removeAllTest() {
        inventory.addItem(TestItemFactory.getCorrectItem());
        inventory.addItem(TestItemFactory.getCorrectItem());
        inventory.addItem(TestItemFactory.getCorrectItem());
        inventory.addItem(TestItemFactory.getCorrectItem());
        assertThat(inventory.isEmpty()).isFalse();
        assertThat(inventory.getLoad()).isEqualTo(4);
        assertThat(inventory.getFill()).isEqualTo(4);
        assertThat(inventory.removeAllItems()).isEqualTo(Message.INVENTORY_CLEARED);
        assertThat(inventory.getLoad()).isEqualTo(0);
        assertThat(inventory.getFill()).isEqualTo(0);
        assertThat(inventory.isEmpty()).isTrue();
    }

    @Test
    public void isTakenTest() {

        inventory.addItem(new ArmorBuilder()
                .size(1)
                .weight(1)
                .health(100)
                .name("Normal armor").build()
        );
        assertThat(inventory.isTaken(0)).isFalse();
        player.takeArmor(0);
        assertThat(inventory.isTaken(0)).isTrue();
        player.putAwayArmor();
        assertThat(inventory.isTaken(0)).isFalse();
    }
}
