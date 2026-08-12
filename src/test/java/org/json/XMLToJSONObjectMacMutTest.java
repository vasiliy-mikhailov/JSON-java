package org.json;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.io.StringReader;

import org.junit.Test;

public class XMLToJSONObjectMacMutTest {

    @Test
    public void testToJSONObjectFromString() {
        // covers toJSONObject:786
        String xml = "<root><child>value</child></root>";
        JSONObject result = XML.toJSONObject(xml);
        assertNotNull(result);
        JSONObject root = result.getJSONObject("root");
        assertEquals("value", root.getString("child"));
    }

    @Test
    public void testToJSONObjectFromStringReader() {
        // covers toJSONObject:876
        String xml = "<root><child>value</child></root>";
        JSONObject result = XML.toJSONObject(new StringReader(xml));
        assertNotNull(result);
        JSONObject root = result.getJSONObject("root");
        assertEquals("value", root.getString("child"));
    }

    @Test
    public void testToJSONObjectWithKeepStringsFalse() {
        // covers toJSONObject:780
        String xml = "<root><child>value</child></root>";
        JSONObject result = XML.toJSONObject(xml, false, false);
        assertNotNull(result);
        JSONObject root = result.getJSONObject("root");
        assertEquals("value", root.getString("child"));
    }

    @Test
    public void testToJSONObjectWithKeepStringsTrue() {
        // covers toJSONObject:783
        String xml = "<root><child>value</child></root>";
        JSONObject result = XML.toJSONObject(xml, true, false);
        assertNotNull(result);
        JSONObject root = result.getJSONObject("root");
        assertEquals("value", root.getString("child"));
    }
}
