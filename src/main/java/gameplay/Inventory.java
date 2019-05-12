package gameplay;

import items.Item;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Inventory {
    private final int CAPACITY = 10;
    private final int MAX_LOAD = 20;
    private int fill = 0;
    private int load = 0;
    private List<Item> itemList = new ArrayList<>();

    private Inventory() {
    }

    //for singleton
    public static Inventory getInstance() {
        return InventoryHolder.INSTANCE;
    }

    //for singleton
    private static class InventoryHolder {
        private static final Inventory INSTANCE = new Inventory();
    }

    public Message addItem(Item item) {
        if (fill + item.getSize() <= CAPACITY) {
            if (load + item.getWeight() <= MAX_LOAD) {
                itemList.add(item);
                load += item.getWeight();
                fill += item.getSize();
                return Message.ITEM_ADDED;
            } else {
                return Message.ITEM_TOO_HEAVY;
            }
        } else {
            return Message.ITEM_TOO_BIG;
        }
    }

    public Optional<Item> getItem(int index) {
        if (index < itemList.size()) {
            return Optional.of(itemList.get(index));
        } else {
            return Optional.empty();
        }
    }

    public Message removeItem(int index){
        if (index < itemList.size()) {
            itemList.remove(index);
            return Message.ITEM_REMOVED;
        } else {
            return Message.ITEM_NOT_FOUND;
        }
    }

    public Message removeAllItems(){
        for (int i = 0; i < itemList.size(); i++) {
            itemList.remove(i);
        }
        return Message.INVENTORY_CLEARED;
    }

    public boolean isEmpty(){
        return itemList.size() == 0;
    }

    public int getCAPACITY() {
        return CAPACITY;
    }

    public int getMAX_LOAD() {
        return MAX_LOAD;
    }

    public int getFill() {
        return fill;
    }

    public int getLoad() {
        return load;
    }

    public List<Item> getItemList() {
        return itemList;
    }
}
