package org.json;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertSame;

import org.junit.Before;
import org.junit.Test;

public class StringBuilderWriterAppendMacMutTest {

    private StringBuilderWriter writer;

    @Before
    public void setUp() {
        writer = new StringBuilderWriter();
    }

    @Test
    public void appendCharSequenceReturnsThis() {
        // covers append:63
        CharSequence csq = "test";
        StringBuilderWriter result = writer.append(csq);
        assertNotNull(result);
        assertSame(writer, result);
        assertEquals("test", writer.toString());
    }

    @Test
    public void appendCharSequenceWithRangeReturnsThis() {
        // covers append:71
        CharSequence csq = "hello";
        StringBuilderWriter result = writer.append(csq, 0, 3);
        assertNotNull(result);
        assertSame(writer, result);
        assertEquals("hel", writer.toString());
    }

    @Test
    public void appendCharReturnsThis() {
        // covers append:77
        char c = 'x';
        StringBuilderWriter result = writer.append(c);
        assertNotNull(result);
        assertSame(writer, result);
        assertEquals("x", writer.toString());
    }

    @Test
    public void appendNullCharSequenceWritesNull() {
        // covers append:68
        StringBuilderWriter result = writer.append((CharSequence) null, 0, 4);
        assertNotNull(result);
        assertSame(writer, result);
        assertEquals("null", writer.toString());
    }
}