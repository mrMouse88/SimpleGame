public class TestItemFactory {

    //item class for testing
    static class DummyItem extends items.Item {

        public DummyItem(int weight, int size) {
            super(weight, size);
        }
    }

    public static items.Item getCorrectItem() {
        return new DummyItem(1, 1);
    }

    public static items.Item getBigItem() {
        return new DummyItem(1, 11);
    }

    public static items.Item getHeavyItem() {
        return new DummyItem(21, 1);
    }
}
