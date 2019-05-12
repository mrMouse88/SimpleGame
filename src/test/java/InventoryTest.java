import gameplay.Inventory;
import gameplay.Message;
import items.Item;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

public class InventoryTest {

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
    }

    @Test
    public void inventoryTooHeavyAddingTest() {
        Inventory inventory = Inventory.getInstance();
        assertThat(inventory.addItem(TestItemFactory.getHeavyItem())).isEqualTo(Message.ITEM_TOO_HEAVY);
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
        assertThat(inventory.removeItem(0)).isEqualTo(Message.ITEM_REMOVED);
        assertThat(inventory.removeItem(0)).isEqualTo(Message.ITEM_NOT_FOUND);
    }

    @Test
    public void removeAllTest(){
        Inventory inventory = Inventory.getInstance();
        inventory.addItem(TestItemFactory.getCorrectItem());
        assertThat(inventory.isEmpty()).isFalse();
        assertThat(inventory.removeAllItems()).isEqualTo(Message.INVENTORY_CLEARED);
        assertThat(inventory.isEmpty()).isTrue();
    }
}
