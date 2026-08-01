package org.json;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

public class StringBuilderWriterWriteMacMutTest {

    private StringBuilderWriter writer;

    @Before
    public void setUp() {
        writer = new StringBuilderWriter();
    }

    @Test
    public void writeCharArrayWithZeroLength() {
        char[] chars = {'a', 'b', 'c'};
        writer.write(chars, 0, 0);
        assertEquals("", writer.toString());
    }

    @Test
    public void writeCharArrayWithInvalidOffset() {
        char[] chars = {'a', 'b', 'c'};
        try {
            writer.write(chars, -1, 1);
            fail("Expected IndexOutOfBoundsException");
        } catch (IndexOutOfBoundsException e) {
            // expected
        }
    }
}
