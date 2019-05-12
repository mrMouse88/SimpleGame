public class TestItemFactory {

    //item class for testing
    static class Item extends items.Item {

        public Item(int weight, int size) {
            super(weight, size);
        }
    }

    public static Item getCorrectItem(){
        return new Item(1,1);
    }

    public static Item getBigItem(){
        return new Item(1,11);
    }

    public static Item getHeavyItem(){
        return new Item(21,1);
    }
}
