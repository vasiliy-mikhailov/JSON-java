package org.json;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.Test;

public class CDLToJSONArrayMacMutTest {

    @Test
    public void toJSONArray_emptyDatasetReturnsNull() {
        // Verifies empty dataset returns null
        JSONArray result = CDL.toJSONArray(new JSONTokener(""));
        assertNull(result);
    }

    @Test
    public void toJSONArray_singleEmptyRowReturnsNull() {
        // Verifies single empty row returns null
        JSONArray result = CDL.toJSONArray(new JSONTokener(","));
        assertNull(result);
    }

    @Test
    public void toJSONArray_validDataReturnsArray() {
        // Verifies valid data returns non-null array with correct length
        JSONArray result = CDL.toJSONArray(new JSONTokener("a,b\nc,d"));
        assertNotNull(result);
        assertEquals(1, result.length());
    }
}
