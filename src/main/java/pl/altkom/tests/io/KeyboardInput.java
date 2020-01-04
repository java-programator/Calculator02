package pl.altkom.tests.io;

import pl.altkom.tests.Input;
import pl.altkom.tests.exceptions.CalculatorException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class KeyboardInput implements Input {
    private BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    @Override
    public Character get() throws CalculatorException {
        try {
            int res = in.read();
            if (res == -1) {
                return null;
            } else {
                return Character.valueOf((char) res);
            }
        } catch (IOException e) {
            throw new CalculatorException("Error during reading data from keyboard", e);
        }
    }
}