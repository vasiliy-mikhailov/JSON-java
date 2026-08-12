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
        // Verifies getCollection converts JSON array to List
        String json = "[\"a\", \"b\", \"c\"]";
        JSONArray jsonArray = new JSONArray(json);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("items", jsonArray);
        
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
        // Verifies getCollection converts JSON array to Set
        String json = "[\"x\", \"y\", \"z\"]";
        JSONArray jsonArray = new JSONArray(json);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("items", jsonArray);
        
        SetHolder holder = jsonObject.fromJson(SetHolder.class);
        
        assertNotNull(holder);
        assertNotNull(holder.items);
        assertTrue(holder.items instanceof HashSet);
        assertEquals(3, holder.items.size());
        assertTrue(holder.items.contains("x"));
        assertTrue(holder.items.contains("y"));
        assertTrue(holder.items.contains("z"));
    }

    public static class ListHolder {
        public List<String> items;
    }

    public static class SetHolder {
        public Set<String> items;
    }
}
