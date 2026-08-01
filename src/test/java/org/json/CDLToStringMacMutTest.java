package org.json;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.Test;

public class CDLToStringMacMutTest {

    @Test
    public void toStringWithNullNamesReturnsNull() {
        // covers toString:429
        JSONArray names = null;
        JSONArray ja = new JSONArray();
        ja.put(new JSONObject());
        String result = CDL.toString(names, ja);
        assertNull(result);
    }

    @Test
    public void toStringWithEmptyNamesReturnsNull() {
        // covers toString:433
        JSONArray names = new JSONArray();
        JSONArray ja = new JSONArray();
        ja.put(new JSONObject());
        String result = CDL.toString(names, ja);
        assertNull(result);
    }
}
