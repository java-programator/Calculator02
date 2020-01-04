package pl.altkom.tests;

import pl.altkom.tests.exceptions.CalculatorException;

public interface StringArithmetic {
    String add(String a, String b) throws CalculatorException;
    String sub(String a, String b) throws CalculatorException;
    String mul(String a, String b) throws CalculatorException;
    String div(String a, String b) throws CalculatorException;
    String mod(String a, String b) throws CalculatorException;
    boolean isPrime(String a) throws CalculatorException;
    String log2(String a) throws CalculatorException;
    String sqrt(String a) throws CalculatorException;
}
