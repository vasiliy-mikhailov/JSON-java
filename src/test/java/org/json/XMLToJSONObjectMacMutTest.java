package org.json;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.io.StringReader;

import org.junit.Test;

public class XMLToJSONObjectMacMutTest {

    @Test
    public void testToJSONObjectFromString() {
        String xml = "<root><child>value</child></root>";
        JSONObject result = XML.toJSONObject(xml);
        assertNotNull(result);
        JSONObject root = result.getJSONObject("root");
        assertEquals("value", root.getString("child"));
    }

    @Test
    public void testToJSONObjectFromStringReader() {
        String xml = "<root><child>value</child></root>";
        JSONObject result = XML.toJSONObject(new StringReader(xml));
        assertNotNull(result);
        JSONObject root = result.getJSONObject("root");
        assertEquals("value", root.getString("child"));
    }

    @Test
    public void testToJSONObjectWithKeepStringsFalse() {
        String xml = "<root><child>value</child></root>";
        JSONObject result = XML.toJSONObject(xml, false, false);
        assertNotNull(result);
        JSONObject root = result.getJSONObject("root");
        assertEquals("value", root.getString("child"));
    }

    @Test
    public void testToJSONObjectWithKeepStringsTrue() {
        String xml = "<root><child>value</child></root>";
        JSONObject result = XML.toJSONObject(xml, true, false);
        assertNotNull(result);
        JSONObject root = result.getJSONObject("root");
        assertEquals("value", root.getString("child"));
    }
}
