package org.json;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Test;

public class JSONObjectGetCollectionMacMutTest {

    @Test
    public void fromJsonListCollection() {
        // covers getCollection:3651
        // covers getCollection:3654
        // covers getCollection:3653
        // Test that fromJson correctly converts a JSON array to a List
        // This exercises the getCollection method for List.class
        String json = "[\"a\", \"b\", \"c\"]";
        JSONArray jsonArray = new JSONArray(json);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("items", jsonArray);
        
        // Create a POJO class with a List field
        ListHolder holder = jsonObject.fromJson(ListHolder.class);
        
        assertNotNull(holder);
        assertNotNull(holder.items);
        assertTrue(holder.items instanceof ArrayList);
        assertEquals(3, holder.items.size());
        assertEquals("a", holder.items.get(0));
        assertEquals("b", holder.items.get(1));
        assertEquals("c", holder.items.get(2));
    }

    @Test
    public void fromJsonSetCollection() {
        // covers getCollection:3651
        // covers getCollection:3654
        // covers getCollection:3653
        // Test that fromJson correctly converts a JSON array to a Set
        // This exercises the getCollection method for Set.class
        String json = "[\"x\", \"y\", \"z\"]";
        JSONArray jsonArray = new JSONArray(json);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("items", jsonArray);
        
        // Create a POJO class with a Set field
        SetHolder holder = jsonObject.fromJson(SetHolder.class);
        
        assertNotNull(holder);
        assertNotNull(holder.items);
        assertTrue(holder.items instanceof HashSet);
        assertEquals(3, holder.items.size());
        assertTrue(holder.items.contains("x"));
        assertTrue(holder.items.contains("y"));
        assertTrue(holder.items.contains("z"));
    }

    // Helper POJO class with a List field
    public static class ListHolder {
        public List<String> items;
    }

    // Helper POJO class with a Set field
    public static class SetHolder {
        public Set<String> items;
    }
}
