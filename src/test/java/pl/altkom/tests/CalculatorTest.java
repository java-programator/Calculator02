package pl.altkom.tests;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pl.altkom.tests.aritmetics.FloatArithmetic;
import pl.altkom.tests.aritmetics.IntegerArithmetic;
import pl.altkom.tests.exceptions.CalculatorException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class CalculatorTest {
    private Calculator c;
    private StringArithmetic floatArithmetic;
    private StringArithmetic integerArithmetic;
    @Mock private Input in;
    @Mock private Output out;

    @Test
    public void simpleTest() throws CalculatorException {
        floatArithmetic = new FloatArithmetic();
        integerArithmetic = new IntegerArithmetic();
        c = new Calculator(integerArithmetic, floatArithmetic, in, out);

        when(in.get()).thenReturn('2').thenReturn('+').thenReturn('2').thenReturn('=');

        c.calculateOneOperation();

        verify(out, times(1)).put('4');
    }
}