package org.json;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Test;

public class JSONPointerReadByIndexTokenMacMutTest {

    @Test
    public void indexOutOfBoundsThrowsException() {
        // covers readByIndexToken:229
        JSONArray arr = new JSONArray();
        arr.put("a");
        arr.put("b");
        JSONPointer pointer = new JSONPointer("/2");
        try {
            pointer.queryFrom(arr);
            fail("Expected JSONPointerException for out of bounds index");
        } catch (JSONPointerException e) {
            assertEquals("index 2 is out of bounds - the array has 2 elements", e.getMessage());
        }
    }

    @Test
    public void validIndexReturnsCorrectValue() {
        // covers readByIndexToken:229
        JSONArray arr = new JSONArray();
        arr.put("a");
        arr.put("b");
        JSONPointer pointer = new JSONPointer("/1");
        Object result = pointer.queryFrom(arr);
        assertEquals("b", result);
    }
}
