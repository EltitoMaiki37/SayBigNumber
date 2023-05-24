import net.esliceu.numbers.Numbers;
import net.esliceu.numbers.NumbersCat;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class NumbersCatTest {
    /*
    1. Zero
    2. Unitats
    3. Negatius
    4. Decenes
        4.1 30 - 99
        4.2 20 - 29
        4.3 10 - 19
     */

    private Numbers numbers;

    @BeforeEach
    void setUp() {
        numbers = new NumbersCat();
    }

    @Test
    public void donat_0_retorna_Zero() {
        Assertions.assertEquals("Zero", numbers.say(0l));
    }

    @Test
    public void donat_1_retorna_Un() {
        Assertions.assertEquals("Un", numbers.say(1l));
    }

    @Test
    public void donat_2_retorna_Dos() {
        Assertions.assertEquals("Dos", numbers.say(2l));
    }

    @Test
    public void donat_9_retorna_Nou() {
        Assertions.assertEquals("Nou", numbers.say(9l));
    }

    @Test
    public void donat_menys_5_retorna_Menys_cinc() {
        Assertions.assertEquals("Menys cinc", numbers.say(-5l));
    }

    @Test
    public void donat_30_retorna_Trenta() {
        Assertions.assertEquals("Trenta", numbers.say(30l));
    }

    @Test
    public void donat_31_retorna_Trenta_un() {
        Assertions.assertEquals("Trenta-un", numbers.say(31l));
    }

    @Test
    public void donat_41_retorna_Quaranta_un() {
        Assertions.assertEquals("Quaranta-un", numbers.say(41l));
    }

    @Test
    public void donat_99_retorna_Noranta_nou() {
        Assertions.assertEquals("Noranta-nou", numbers.say(99l));
    }

    @Test
    public void donat_20_retorna_Vint() {
        Assertions.assertEquals("Vint", numbers.say(20l));
    }

    @Test
    public void donat_15_retorna_Quinze() {
        Assertions.assertEquals("Quinze", numbers.say(15l));
    }

    @Test
    public void donat_21_retorna_Vint_i_un() {
        Assertions.assertEquals("Vint-i-un", numbers.say(21l));
    }

    @Test
    public void donat_100_retorna_Cent() {
        Assertions.assertEquals("Cent", numbers.say(100l));
    }

    @Test
    public void donat_999_retorna_Nou_cents_noranta_nou() {
        Assertions.assertEquals("Nou-cents noranta-nou", numbers.say(999l));
    }

    @Test
    public void donat_1000_retorna_Mil() {
        Assertions.assertEquals("Mil", numbers.say(1000l));
    }

    @Test
    public void donat_1057_retorna_Mil_cinquanta_set() {
        Assertions.assertEquals("Mil cinquanta-set", numbers.say(1057l));
    }

    @Test
    public void donat_9999() {
        Assertions.assertEquals("Nou mil nou-cents noranta-nou", numbers.say(9999l));
    }

    @Test
    public void donat_10000() {
        Assertions.assertEquals("Deu mil", numbers.say(10000l));
    }

    @Test
    public void donat_10001() {
        Assertions.assertEquals("Deu mil un", numbers.say(10001l));
    }

    @Test
    public void donat_99999() {
        Assertions.assertEquals("Noranta-nou mil nou-cents noranta-nou", numbers.say(99999l));
    }

    @Test
    public void donat_100000() {
        Assertions.assertEquals("Cent mil", numbers.say(100000l));
    }

    @Test
    public void donat_999999() {
        Assertions.assertEquals("Nou-cents noranta-nou mil nou-cents noranta-nou", numbers.say(999999l));
    }
}