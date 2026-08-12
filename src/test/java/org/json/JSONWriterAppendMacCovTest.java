package org.json;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.io.StringWriter;

import org.junit.Before;
import org.junit.Test;

public class JSONWriterAppendMacCovTest {

    private StringWriter writer;
    private JSONWriter jsonWriter;

    @Before
    public void setUp() {
        writer = new StringWriter();
        jsonWriter = new JSONWriter(writer);
    }

    /**
     * Pins down the behavior of array() which internally calls append("[").
     * Covers lines 94, 102, 106, 114.
     */
    @Test
    public void testArrayAppendsOpenBracket() {
        jsonWriter.array();
        assertEquals("[", writer.toString());
    }

    /**
     * Pins down the behavior of object() which internally calls append("{").
     * Covers lines 152, 156.
     */
    @Test
    public void testObjectAppendsOpenBrace() {
        jsonWriter.object();
        assertEquals("{", writer.toString());
    }

    /**
     * Pins down the behavior of value(boolean) which internally calls append("true"/"false").
     * Covers lines 199, 210, 214.
     */
    @Test
    public void testValueBooleanAppendsString() {
        // Must start with array or object to set mode to 'a' or 'o'
        jsonWriter.array();
        jsonWriter.value(true);
        assertEquals("[true", writer.toString());
    }

    /**
     * Pins down the behavior of value(Object) with null, which internally calls append("null").
     * Covers lines 252, 256.
     */
    @Test
    public void testValueNullAppendsNullString() {
        // Must start with array or object to set mode to 'a' or 'o'
        jsonWriter.array();
        jsonWriter.value(null);
        assertEquals("[null", writer.toString());
    }

    /**
     * Pins down the error path when append is called out of sequence (mode is not 'o' or 'a').
     * Covers line 329.
     */
    @Test
    public void testAppendOutOfSequenceThrowsException() {
        // covers append:329
        try {
            jsonWriter.object();
            jsonWriter.value("test");
            fail("Expected JSONException");
        } catch (JSONException e) {
            // Expected
        }
    }
}
