import items.builders.MixtureBuilder;
import items.Item;
import items.Mixture;
import items.MixturePurpose;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class MixtureTest {
    @Test
    public void testMixtureBuild(){
        Mixture mixture = new MixtureBuilder()
                .size(1)
                .weight(5)
                .addedValue(10)
                .purpose(MixturePurpose.HEALING)
                .build();

        assertThat(mixture instanceof Item).isTrue();
        assertThat(mixture instanceof Mixture).isTrue();
        assertThat(mixture.getSize()).isEqualTo(1);
        assertThat(mixture.getWeight()).isEqualTo(5);
        assertThat(mixture.getAddedValue()).isEqualTo(10);
        assertThat(mixture.getMixturePurpose()).isEqualTo(MixturePurpose.HEALING);
    }
}
