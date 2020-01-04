package pl.altkom.tests;

import pl.altkom.tests.exceptions.CalculatorException;

public interface Input {
    Character get() throws CalculatorException;
}
