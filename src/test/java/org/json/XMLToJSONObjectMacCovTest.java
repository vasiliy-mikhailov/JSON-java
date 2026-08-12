package org.json;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.Test;

public class XMLToJSONObjectMacCovTest {

    @Test
    public void testToJSONObjectBasic() {
        String xml = "<root><child>value</child></root>";
        JSONObject result = XML.toJSONObject(xml);
        assertNotNull(result);
        JSONObject root = result.getJSONObject("root");
        assertEquals("value", root.getString("child"));
    }

    @Test
    public void testToJSONObjectWithAttributes() {
        String xml = "<root attr='val'><child>text</child></root>";
        JSONObject result = XML.toJSONObject(xml);
        assertNotNull(result);
        JSONObject root = result.getJSONObject("root");
        assertEquals("val", root.getString("attr"));
    }

    @Test
    public void testToJSONObjectEmptyElement() {
        String xml = "<root><empty/></root>";
        JSONObject result = XML.toJSONObject(xml);
        assertNotNull(result);
        JSONObject root = result.getJSONObject("root");
        assertNull(root.optJSONObject("empty"));
    }
}