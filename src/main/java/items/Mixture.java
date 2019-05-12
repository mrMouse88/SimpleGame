package items;

public class Mixture extends Item {
    private MixturePurpose mixturePurpose;
    private int addedValue;

    public Mixture(int weight, int size, MixturePurpose mixturePurpose, int addedValue) {
        super(weight, size);
        this.mixturePurpose = mixturePurpose;
        this.addedValue = addedValue;
    }

    public MixturePurpose getMixturePurpose() {
        return mixturePurpose;
    }

    public int getAddedValue() {
        return addedValue;
    }
}
