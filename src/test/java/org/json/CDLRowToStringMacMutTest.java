package org.json;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class CDLRowToStringMacMutTest {

    @Test
    public void rowToString_returnsCommaSeparatedValues() {
        // covers rowToString:168
        JSONArray ja = new JSONArray();
        ja.put("a");
        ja.put("b");
        String result = CDL.rowToString(ja);
        assertEquals("a,b\n", result);
    }
}
