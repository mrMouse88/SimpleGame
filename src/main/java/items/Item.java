package items;

public abstract class Item {
    private int weight;
    private int size;
    private boolean isTaken = false;

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

    public boolean isTaken() {
        return isTaken;
    }

    public void setTaken(boolean taken) {
        isTaken = taken;
    }
}
