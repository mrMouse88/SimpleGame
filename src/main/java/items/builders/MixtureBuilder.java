package items.builders;

import items.Mixture;
import items.MixturePurpose;

public class MixtureBuilder {
    private int size;
    private int weight;
    private MixturePurpose mixturePurpose;
    private int addedValue;

    public MixtureBuilder size(int size) {
        this.size = size;
        return this;
    }

    public MixtureBuilder weight(int weight) {
        this.weight = weight;
        return this;
    }

    public MixtureBuilder purpose(MixturePurpose mixturePurpose) {
        this.mixturePurpose = mixturePurpose;
        return this;
    }

    public MixtureBuilder addedValue(int addedValue) {
        this.addedValue = addedValue;
        return this;
    }

    public Mixture build(){
        return new Mixture(weight, size, mixturePurpose, addedValue);
    }
}
