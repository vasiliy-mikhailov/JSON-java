package org.json;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.io.StringWriter;

import org.junit.Before;
import org.junit.Test;

public class JSONWriterAppendMacMutTest {

    private StringWriter stringWriter;
    private JSONWriter jsonWriter;

    @Before
    public void setUp() {
        stringWriter = new StringWriter();
        jsonWriter = new JSONWriter(stringWriter);
    }

    @Test
    public void appendInObjectModeWritesValue() {
        // covers append:93
        try {
            jsonWriter.object();
            jsonWriter.key("key");
            jsonWriter.value("value");
            jsonWriter.endObject();
            assertEquals("{\"key\":\"value\"}", stringWriter.toString());
        } catch (JSONException e) {
            fail("Unexpected exception: " + e.getMessage());
        }
    }

    @Test
    public void appendInArrayModeWritesValue() {
        // covers append:96
        try {
            jsonWriter.array();
            jsonWriter.value("value");
            jsonWriter.endArray();
            assertEquals("[\"value\"]", stringWriter.toString());
        } catch (JSONException e) {
            fail("Unexpected exception: " + e.getMessage());
        }
    }

    @Test
    public void appendInArrayModeWithCommaWritesComma() {
        // covers append:98
        try {
            jsonWriter.array();
            jsonWriter.value("first");
            jsonWriter.value("second");
            jsonWriter.endArray();
            assertEquals("[\"first\",\"second\"]", stringWriter.toString());
        } catch (JSONException e) {
            fail("Unexpected exception: " + e.getMessage());
        }
    }

    @Test
    public void appendOutOfSequenceThrowsException() {
        // covers append:108
        try {
            jsonWriter.value("value");
            fail("Expected JSONException for out of sequence value");
        } catch (JSONException e) {
            assertEquals("Value out of sequence.", e.getMessage());
        }
    }
}