package org.json;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

public class CDLRowToJSONArrayMacMutTest {

    @Test
    public void rowToJSONArray_returnsArray() {
        // covers rowToJSONArray:90
        JSONTokener x = new JSONTokener("a,b");
        JSONArray result = CDL.rowToJSONArray(x);
        assertNotNull(result);
        assertEquals(2, result.length());
        assertEquals("a", result.getString(0));
        assertEquals("b", result.getString(1));
    }
}
