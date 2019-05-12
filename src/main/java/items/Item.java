package items;

public abstract class Item {
    private int weight;
    private int size;

    public Item(int weight, int size) {
        this.weight = weight;
        this.size = size;
    }

    public int getWeight() {
        return weight;
    }

    public int getSize() {
        return size;
    }
}
