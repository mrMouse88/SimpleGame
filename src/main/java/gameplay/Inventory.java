package gameplay;

import items.Item;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Inventory {
    private static Inventory instance = new Inventory();

    private final int CAPACITY = 10;
    private final int MAX_LOAD = 20;
    private int fill = 0;
    private int load = 0;
    private List<Item> itemList = new ArrayList<>();

    private Inventory() {
    }

    //for singleton
    public static Inventory getInstance() {
        return instance;
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

    public Message removeItem(int index) {
        if (index < itemList.size()) {
            if (itemList.get(index).isTaken()) {
                return Message.ITEM_USED;
            } else {
                load -= itemList.get(index).getWeight();
                fill -= itemList.get(index).getSize();
                itemList.remove(index);
                return Message.ITEM_REMOVED;
            }
        } else {
            return Message.ITEM_NOT_FOUND;
        }
    }

    public Message removeItem(Item item){
        if(item.isTaken()){
            return Message.ITEM_USED;
        }else{
            if(itemList.contains(item)){
                load -= itemList.get(itemList.indexOf(item)).getWeight();
                fill -= itemList.get(itemList.indexOf(item)).getSize();
                itemList.remove(item);
                return Message.ITEM_REMOVED;
            }
            return Message.ITEM_NOT_FOUND;
        }
    }

    public Message removeAllItems() {
        if (!isEmpty()) {
            for (int i = itemList.size() - 1; i >= 0; i--) {
                removeItem(i);
            }
        }
        return Message.INVENTORY_CLEARED;
    }

    public boolean isTaken(int index) {
        return itemList.get(index).isTaken();
    }

    public boolean isEmpty() {
        return itemList.isEmpty();
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
