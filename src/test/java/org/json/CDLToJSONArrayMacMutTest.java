package org.json;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.Test;

public class CDLToJSONArrayMacMutTest {

    @Test
    public void toJSONArray_emptyDatasetReturnsNull() {
        // covers toJSONArray:344
        // covers toJSONArray:282
        // covers toJSONArray:331
        // Empty dataset (no keys or vals) should return null
        JSONArray result = CDL.toJSONArray(new JSONTokener(""));
        assertNull(result);
    }

    @Test
    public void toJSONArray_singleEmptyRowReturnsNull() {
        // covers toJSONArray:344
        // A single row with empty key and empty value should return null
        JSONArray result = CDL.toJSONArray(new JSONTokener(","));
        assertNull(result);
    }

    @Test
    public void toJSONArray_validDataReturnsArray() {
        // covers toJSONArray:344
        // Valid data should return a non-null array
        // The input "a,b\nc,d" has headers "a,b" and one data row "c,d".
        // Therefore, the resulting JSONArray contains 1 JSONObject.
        JSONArray result = CDL.toJSONArray(new JSONTokener("a,b\nc,d"));
        assertNotNull(result);
        assertEquals(1, result.length());
    }
}
