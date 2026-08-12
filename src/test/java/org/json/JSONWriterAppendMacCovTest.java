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
     * Verifies array() appends open bracket.
     */
    @Test
    public void testArrayAppendsOpenBracket() {
        jsonWriter.array();
        assertEquals("[", writer.toString());
    }

    /**
     * Verifies object() appends open brace.
     */
    @Test
    public void testObjectAppendsOpenBrace() {
        jsonWriter.object();
        assertEquals("{", writer.toString());
    }

    /**
     * Verifies value(boolean) appends true/false string.
     */
    @Test
    public void testValueBooleanAppendsString() {
        jsonWriter.array();
        jsonWriter.value(true);
        assertEquals("[true", writer.toString());
    }

    /**
     * Verifies value(null) appends null string.
     */
    @Test
    public void testValueNullAppendsNullString() {
        jsonWriter.array();
        jsonWriter.value(null);
        assertEquals("[null", writer.toString());
    }

    /**
     * Verifies append throws exception when called out of sequence.
     */
    @Test
    public void testAppendOutOfSequenceThrowsException() {
        try {
            jsonWriter.object();
            jsonWriter.value("test");
            fail("Expected JSONException");
        } catch (JSONException e) {
            // Expected
        }
    }
}
