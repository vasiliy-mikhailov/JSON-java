package org.json;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class CDLRowToStringMacCovTest {

    @Test
    public void rowToString_returnsCommaSeparatedValues() {
        JSONArray ja = new JSONArray();
        ja.put("a");
        ja.put("b");
        assertEquals("a,b\n", CDL.rowToString(ja));
    }

    @Test
    public void rowToString_handlesEmptyArray() {
        JSONArray ja = new JSONArray();
        assertEquals("\n", CDL.rowToString(ja));
    }

    @Test
    public void rowToString_handlesSingleElement() {
        JSONArray ja = new JSONArray();
        ja.put("single");
        assertEquals("single\n", CDL.rowToString(ja));
    }
}
