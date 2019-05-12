public class TestItemFactory {

    //item class for testing
    static class DummyItem extends items.Item {

        public DummyItem(int weight, int size) {
            super(weight, size);
        }
    }

    public static DummyItem getCorrectItem(){
        return new DummyItem(1,1);
    }

    public static DummyItem getBigItem(){
        return new DummyItem(1,11);
    }

    public static DummyItem getHeavyItem(){
        return new DummyItem(21,1);
    }
}
