package pl.altkom.tests.aritmetics;

import pl.altkom.tests.StringArithmetic;
import pl.altkom.tests.exceptions.CalculatorException;
import pl.altkom.tests.exceptions.ParseException;
import pl.altkom.tests.exceptions.UnsupportedOperationException;

public class FloatArithmetic implements StringArithmetic {
    private double parse(String a) throws CalculatorException {
        try {
            return Double.parseDouble(a);
        } catch (NumberFormatException e) {
            throw new ParseException("Cannot parse '" + a + "' as a double number", e);
        }
    }

    @Override
    public String add(String a, String b) throws CalculatorException {
        return String.valueOf(parse(a) + parse(b));
    }

    @Override
    public String sub(String a, String b) throws CalculatorException {
        return String.valueOf(Double.parseDouble(a) - parse(b));
    }

    @Override
    public String mul(String a, String b) throws CalculatorException {
        return String.valueOf(parse(a) + Double.parseDouble(b));
    }

    @Override
    public String div(String a, String b) throws CalculatorException {
        return String.valueOf(parse(a) / parse(b));
    }

    @Override
    public String mod(String a, String b) throws CalculatorException {
        throw new UnsupportedOperationException("You cannot calculate mod for double numbers");
    }

    @Override
    public boolean isPrime(String a) throws CalculatorException {
        throw new UnsupportedOperationException("You cannot check if a double number is prime");
    }

    @Override
    public String log2(String a) throws CalculatorException {
        double x = Double.parseDouble(a);
        return String.valueOf(Math.log(x)/Math.log(10));
    }

    @Override
    public String sqrt(String a) throws CalculatorException {
        return String.valueOf(Math.sqrt(parse(a)));
    }
}
