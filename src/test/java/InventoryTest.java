import gameplay.Inventory;
import gameplay.Message;
import items.Item;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

public class InventoryTest {

    @Test
    public void inventoryCorrectAddingTest(){
        Inventory inventory = Inventory.getInstance();
        assertThat(inventory.addItem(TestItemFactory.getCorrectItem())).isEqualTo(Message.ITEM_ADDED);
    }

    @Test
    public void inventoryTooBigAddingTest(){
        Inventory inventory = Inventory.getInstance();
        assertThat(inventory.addItem(TestItemFactory.getBigItem())).isEqualTo(Message.ITEM_TOO_BIG);
    }

    @Test
    public void inventoryTooHeavyAddingTest(){
        Inventory inventory = Inventory.getInstance();
        assertThat(inventory.addItem(TestItemFactory.getHeavyItem())).isEqualTo(Message.ITEM_TOO_HEAVY);
    }

    @Test
    public void getItemTest(){
        Inventory inventory = Inventory.getInstance();
        Item item = TestItemFactory.getCorrectItem();
        inventory.addItem(item);
        assertThat(inventory.getItem(0)).isEqualTo(Optional.of(item));
        assertThat(inventory.getItem(1)).isEqualTo(Optional.empty());
    }
}
