package pl.altkom.tests.exceptions;

public class CalculatorException extends Exception {
    public CalculatorException() {
    }

    public CalculatorException(String message) {
        super(message);
    }

    public CalculatorException(String message, Throwable cause) {
        super(message, cause);
    }
}
