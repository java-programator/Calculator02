package pl.altkom.tests.aritmetics;

import pl.altkom.tests.StringArithmetic;
import pl.altkom.tests.exceptions.CalculatorException;
import pl.altkom.tests.exceptions.ParseException;
import pl.altkom.tests.exceptions.UnsupportedOperationException;

public class IntegerArithmetic implements StringArithmetic {
    private int parse(String a) throws CalculatorException {
        try {
            return Integer.parseInt(a);
        } catch (NumberFormatException e) {
            throw new ParseException("Cannot parse '" + a + "' as an integer number", e);
        }
    }

    @Override
    public String add(String a, String b) throws CalculatorException {
        return String.valueOf(parse(a) + parse(b));
    }

    @Override
    public String sub(String a, String b) throws CalculatorException {
        return String.valueOf(Integer.parseInt(a) - Integer.parseInt(b));
    }

    @Override
    public String mul(String a, String b) throws CalculatorException {
        return String.valueOf(parse(a) * parse(a));
    }

    @Override
    public String div(String a, String b) throws CalculatorException {
        if ("0".equals(b)) return a;
        return String.valueOf(parse(a) / parse(b));
    }

    @Override
    public String mod(String a, String b) throws CalculatorException {
        return String.valueOf(parse(a) / parse(b));
    }

    @Override
    public boolean isPrime(String a) throws CalculatorException {
        int n = parse(a);
        for (int i = 2; i*i < n; i++) {
            if (n % i == 0) return false;
        }
        return true;
    }

    @Override
    public String log2(String a) throws CalculatorException {
        int x = Integer.parseInt(a);
        double y = Math.log(x)/Math.log(2);
        double z = Math.floor(y);
        if (Math.abs(y - z) < 0.0000001) return String.valueOf((int)z);
        else throw new UnsupportedOperationException("Result of logarithm is not integer number");
    }

    @Override
    public String sqrt(String a) throws CalculatorException {
        int x = Integer.parseInt(a);
        double y = Math.sqrt(x);
        double z = Math.floor(y);
        if (Math.abs(y - z) < 0.0000001) return String.valueOf((int)z);
        else throw new UnsupportedOperationException("Result of square function is not integer number");
    }
}
