package pl.altkom.tests.aritmetics;

import org.junit.jupiter.api.*;
import pl.altkom.tests.exceptions.CalculatorException;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class FloatArithmeticTest {
    @Test
    @Disabled
    public void simpleAdditionTest() throws CalculatorException{
        FloatArithmetic a = new FloatArithmetic();
        assertEquals("4.1",a.add("2","2"));
        assertNotEquals("4.0", a.add("2", "2"));
    }

    @Test
    @Disabled
    public void additionTest() throws CalculatorException{
        FloatArithmetic a = new FloatArithmetic();
        assertAll("dodawanie",
                () -> assertEquals("4.1",a.add("2","2") ),
                () -> assertNotEquals("4.0", a.add("2", "2")));
    }

    @Test
    public void parseFailedError() {
        FloatArithmetic a = new FloatArithmetic();
        assertThrows(CalculatorException.class,
                () -> a.add("nic", "hahah"));
    }

    @Tag("dobry_test")
    @DisplayName("dobry_test")
    @Test
    public void SubtractionTest(TestInfo info, TestReporter reporter) throws CalculatorException {
        FloatArithmetic a = new FloatArithmetic();
        assertEquals("3.0", a.sub("6","3"));
        System.out.println(info.toString());
        reporter.publishEntry("Klucz", "Wartość");
    }

    @RepeatedTest(20)
    public void repeatTest(TestReporter reporter, RepetitionInfo info) {
        reporter.publishEntry(
                String.valueOf(info.getCurrentRepetition()),
                String.valueOf(info.getTotalRepetitions()));
        Random r = new Random();
        if (r.nextBoolean()) fail();
    }
}
