package pl.altkom.tests.aritmetics;

import org.junit.jupiter.api.Test;
import pl.altkom.tests.exceptions.CalculatorException;

import static org.junit.jupiter.api.Assertions.*;

class FloatArithmeticTest {
    @Test
    public void simpleTest() throws CalculatorException {
        FloatArithmetic a = new FloatArithmetic();
        assertEquals("4.0", a.add("2.0", "2"));
    }

}