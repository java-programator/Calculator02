package pl.altkom.tests.io;

import pl.altkom.tests.Output;

public class ConsoleOutput implements Output {
    @Override
    public void put(Character c) {
        System.out.print(c.charValue());
    }
}
