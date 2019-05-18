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
    @BeforeEach
    public void initialize(){
        Inventory inventory = Inventory.getInstance();
        inventory.removeAllItems();
        Player player = Player.getInstance();
        player.resetPlayer();
    }

    @Test
    public void inventoryCorrectAddingTest() {
        Inventory inventory = Inventory.getInstance();
        assertThat(inventory.addItem(TestItemFactory.getCorrectItem())).isEqualTo(Message.ITEM_ADDED);
        assertThat(inventory.getFill()).isEqualTo(1);
        assertThat(inventory.getLoad()).isEqualTo(1);
    }

    @Test
    public void inventoryTooBigAddingTest() {
        Inventory inventory = Inventory.getInstance();
        assertThat(inventory.addItem(TestItemFactory.getBigItem())).isEqualTo(Message.ITEM_TOO_BIG);
        assertThat(inventory.isEmpty()).isTrue();
    }

    @Test
    public void inventoryTooHeavyAddingTest() {
        Inventory inventory = Inventory.getInstance();
        assertThat(inventory.addItem(TestItemFactory.getHeavyItem())).isEqualTo(Message.ITEM_TOO_HEAVY);
        assertThat(inventory.isEmpty()).isTrue();
    }

    @Test
    public void getItemTest() {
        Inventory inventory = Inventory.getInstance();
        Item item = TestItemFactory.getCorrectItem();
        inventory.addItem(item);
        assertThat(inventory.getItem(0)).isEqualTo(Optional.of(item));
        assertThat(inventory.getItem(1)).isEqualTo(Optional.empty());
    }

    @Test
    public void removeItemTest(){
        Inventory inventory = Inventory.getInstance();
        inventory.addItem(TestItemFactory.getCorrectItem());
        assertThat(inventory.getLoad()).isEqualTo(1);
        assertThat(inventory.getFill()).isEqualTo(1);
        assertThat(inventory.removeItem(0)).isEqualTo(Message.ITEM_REMOVED);
        assertThat(inventory.getLoad()).isEqualTo(0);
        assertThat(inventory.getFill()).isEqualTo(0);
        assertThat(inventory.removeItem(0)).isEqualTo(Message.ITEM_NOT_FOUND);
    }

    @Test
    public void removeAllTest(){
        Inventory inventory = Inventory.getInstance();
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
    public void isTakenTest(){
        Inventory inventory = Inventory.getInstance();
        Player player = Player.getInstance();

        inventory.addItem(new ArmorBuilder()
                .weight(1)
                .size(1)
                .name("Normal Armor")
                .health(100)
                .build()
        );
        assertThat(inventory.isTaken(0)).isFalse();
        player.takeArmor(0);
        assertThat(inventory.isTaken(0)).isTrue();
    }
}
