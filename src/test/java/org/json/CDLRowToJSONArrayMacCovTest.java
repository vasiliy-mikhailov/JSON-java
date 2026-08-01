package org.json;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class CDLRowToJSONArrayMacCovTest {

    @Test
    public void rowToJSONArray_parses_simple_values() {
        JSONTokener tokener = new JSONTokener("one,two,three");
        JSONArray result = CDL.rowToJSONArray(tokener);
        assertEquals(3, result.length());
        assertEquals("one", result.getString(0));
        assertEquals("two", result.getString(1));
        assertEquals("three", result.getString(2));
    }

    @Test
    public void rowToJSONArray_handles_quoted_values() {
        JSONTokener tokener = new JSONTokener("\"one\",\"two\",\"three\"");
        JSONArray result = CDL.rowToJSONArray(tokener);
        assertEquals(3, result.length());
        assertEquals("one", result.getString(0));
        assertEquals("two", result.getString(1));
        assertEquals("three", result.getString(2));
    }

    @Test
    public void rowToJSONArray_handles_empty_string() {
        JSONTokener tokener = new JSONTokener("");
        JSONArray result = CDL.rowToJSONArray(tokener);
        assertEquals(null, result);
    }
}
