package org.json;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Test;

public class JSONArrayGetFloatMacMutTest {

    @Test
    public void getFloatWithNumberInstance() {
        // covers getFloat:395
        JSONArray array = new JSONArray();
        array.put(1.23f);
        assertEquals(1.23f, array.getFloat(0), 0.0001f);
    }

    @Test
    public void getFloatWithStringNumber() {
        // covers getFloat:399
        JSONArray array = new JSONArray();
        array.put("4.56");
        assertEquals(4.56f, array.getFloat(0), 0.0001f);
    }

    @Test
    public void getFloatWithInvalidStringThrows() {
        // verifies exception on invalid string
        JSONArray array = new JSONArray();
        array.put("not a number");
        try {
            array.getFloat(0);
            fail("Expected JSONException");
        } catch (JSONException e) {
            // expected
        }
    }
}
