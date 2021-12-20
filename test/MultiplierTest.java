import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MultiplierTest {

    @Test // import org.junit.Test
    void multiply() {
        Multiplier multiplier = new Multiplier();
        assertEquals(multiplier.Multiply(8, 9), 72);
    }

    @Test
    void testMultiply() {
        Multiplier multiplier = new Multiplier();
        assertEquals(multiplier.Multiply(2, 3, 4), 24);
    }
}