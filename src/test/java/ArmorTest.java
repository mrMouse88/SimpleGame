import gameplay.Message;
import items.Armor;
import items.builders.ArmorBuilder;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class ArmorTest {
    @Test
    public void ArmorBuildTest(){
        Armor armor = new ArmorBuilder()
                .size(1)
                .weight(1)
                .health(100)
                .name("Normal Armor")
                .build();

        assertThat(armor instanceof Armor).isTrue();
        assertThat(armor.getHealth()).isEqualTo(100);
    }

    @Test
    public void ArmorGainDamageTest(){
        Armor armor = new ArmorBuilder()
                .size(1)
                .weight(1)
                .health(100)
                .name("Normal Armor")
                .build();

        assertThat(armor.gainDamage(50)).isEqualTo(Message.DAMAGE_GAINED);
        assertThat(armor.gainDamage(50)).isEqualTo(Message.ITEM_DESTROYED);
    }

    @Test
    public void ArmorIsDamaged(){
        Armor armor = new ArmorBuilder()
                .size(1)
                .weight(1)
                .health(100)
                .name("Normal Armor")
                .build();
        assertThat(armor.isDamaged()).isFalse();
        armor.gainDamage(100);
        assertThat(armor.isDamaged()).isTrue();
    }
}
