package pl.altkom.tests;

import pl.altkom.tests.exceptions.CalculatorException;
import pl.altkom.tests.exceptions.UnsupportedOperationException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculator {
    private StringArithmetic integerArithmetic;
    private StringArithmetic floatArithmetic;
    private Input in;
    private Output out;

    public void setIntegerArithmetic(StringArithmetic integerArithmetic) {
        this.integerArithmetic = integerArithmetic;
    }

    public void setFloatArithmetic(StringArithmetic floatArithmetic) {
        this.floatArithmetic = floatArithmetic;
    }

    public void setIn(Input in) {
        this.in = in;
    }

    public void setOut(Output out) {
        this.out = out;
    }

    public Calculator() {
    }

    public Calculator(StringArithmetic integerArithmetic, StringArithmetic floatArithmetic, Input in, Output out) {
        this.integerArithmetic = integerArithmetic;
        this.floatArithmetic = floatArithmetic;
        this.in = in;
        this.out = out;
    }

    private static final List<String> ACCEPTABLE = Arrays.asList(
            "=", "log", "sqrt", "prime"
    );

    private static boolean shallFinish(StringBuilder sb) {
        for (String s : ACCEPTABLE) {
            if (sb.toString().endsWith(s)) return true;
        }
        return false;
    }

    public void calculateOneOperation() throws CalculatorException {
        StringBuilder sb = new StringBuilder();
        do {
            Character c = in.get();
            if (c == null) throw new CalculatorException("Unexpected end of input");
            if (!Character.isWhitespace(c)) {
                sb.append(c.toString());
            }
        } while (!shallFinish(sb));

        Expression expression = new Expression(sb.toString());
        String result = expression.calculate() + System.lineSeparator();
        for (int i = 0; i < result.length(); i++) {
            out.put(Character.valueOf(result.charAt(i)));
        }
    }

    public class Expression {
        public final String a;
        public final String b;
        public final String op;

        public Expression(String expression) throws UnsupportedOperationException {
            Pattern p = Pattern.compile("([0-9.,]+)|([\\=\\+\\-\\/\\*\\%])|(log)|(prime)|(sqrt)");
            Matcher m = p.matcher(expression.replace(",", "."));
            List<String> tokens = new ArrayList<>();
            while (m.find()) {
                tokens.add(m.group(0));
            }
            if (tokens.size() == 2) {
                a = tokens.get(0);
                op = tokens.get(1);
                b = null;
            } else if (tokens.size() == 4) {
                a = tokens.get(0);
                op = tokens.get(1);
                b = tokens.get(2);
            } else throw new UnsupportedOperationException("Error during parsing expression");
        }

        public String calculate() throws CalculatorException {
            StringArithmetic arithmetic = null;
            if ((a != null && a.contains(".")) ||
                    (b != null || b.contains("."))) {
                arithmetic = floatArithmetic;
            } else {
                arithmetic = integerArithmetic;
            }
            switch (op) {
                case "+" : return arithmetic.add(a, b);
                case "-" : return arithmetic.sub(a, b);
                case "*" : return arithmetic.mul(a, b);
                case "/" : return arithmetic.div(a, b);
                case "%" : return arithmetic.mod(a, b);
                case "log" : return arithmetic.log2(a);
                case "prime" : return String.valueOf(arithmetic.isPrime(a));
                case "sqrt" : return arithmetic.sqrt(a);
                default: throw new UnsupportedOperationException("Cannot calculate value of expression");
            }
        }
    }
}
