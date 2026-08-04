package org.json;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class CDLGetValueMacMutTest {

    @Test
    public void getValue_emptyValueAtDelimiter() {
        JSONTokener x = new JSONTokener(",b");
        JSONArray result = CDL.rowToJSONArray(x);
        assertEquals(2, result.length());
        assertEquals("", result.getString(0));
        assertEquals("b", result.getString(1));
    }

    @Test
    public void getValue_quotedValueWithEscapedQuote() {
        JSONTokener x = new JSONTokener("\"a\"\"b\",c");
        JSONArray result = CDL.rowToJSONArray(x);
        assertEquals(2, result.length());
        assertEquals("a\"b", result.getString(0));
        assertEquals("c", result.getString(1));
    }

    @Test
    public void getValue_quotedValueEndOfFile() {
        JSONTokener x = new JSONTokener("\"a\"");
        JSONArray result = CDL.rowToJSONArray(x);
        assertEquals(1, result.length());
        assertEquals("a", result.getString(0));
    }

    @Test
    public void getValue_backOnDelimiter() {
        JSONTokener x = new JSONTokener(",b");
        JSONArray result = CDL.rowToJSONArray(x);
        assertEquals(2, result.length());
        assertEquals("", result.getString(0));
        assertEquals("b", result.getString(1));
    }
}
