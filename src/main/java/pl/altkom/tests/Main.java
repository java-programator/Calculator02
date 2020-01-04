package pl.altkom.tests;

import pl.altkom.tests.aritmetics.FloatArithmetic;
import pl.altkom.tests.aritmetics.IntegerArithmetic;
import pl.altkom.tests.exceptions.CalculatorException;
import pl.altkom.tests.io.ConsoleOutput;
import pl.altkom.tests.io.KeyboardInput;

public class Main {
    public static void main(String[] args) throws CalculatorException {
        Calculator c = new Calculator(
                new IntegerArithmetic(),
                new FloatArithmetic(),
                new KeyboardInput(),
                new ConsoleOutput()
        );
        while (true) {
            c.calculateOneOperation();
        }
    }
}
