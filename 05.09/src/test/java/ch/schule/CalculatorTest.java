package ch.schule;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    private Calculator calc;

    @BeforeEach
    void setUp() {
        calc = new Calculator();
    }

    @Test
    void add_works() {
        assertEquals(5.0, calc.add(2, 3), 1e-9);
        assertEquals(-1.0, calc.add(2, -3), 1e-9);
    }

    @Test
    void sub_works() {
        assertEquals(-1.0, calc.sub(2, 3), 1e-9);
    }

    @Test
    void mul_works() {
        assertEquals(6.0, calc.mul(2, 3), 1e-9);
    }

    @Test
    void div_works() {
        assertEquals(2.0, calc.div(6, 3), 1e-9);
    }

    @Test
    void div_by_zero_throws() {
        assertThrows(IllegalArgumentException.class, () -> calc.div(1, 0));
    }
}
