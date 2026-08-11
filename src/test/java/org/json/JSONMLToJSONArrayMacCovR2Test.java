package org.json;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class JSONMLToJSONArrayMacCovR2Test {

    @Test
    public void testToJSONArrayFromSimpleString() {
        String xml = "<root><child>value</child></root>";
        JSONArray result = JSONML.toJSONArray(xml);
        assertNotNull(result);
        assertEquals(2, result.length());
        assertEquals("root", result.getString(0));
        assertTrue(result.getJSONArray(1).length() > 0);
    }

    @Test
    public void testToJSONArrayFromXMLTokener() {
        String xml = "<root><child>value</child></root>";
        XMLTokener tokener = new XMLTokener(xml);
        JSONArray result = JSONML.toJSONArray(tokener);
        assertNotNull(result);
        assertEquals(2, result.length());
        assertEquals("root", result.getString(0));
    }

    @Test
    public void testToJSONArrayWithAttributes() {
        String xml = "<root attr1='val1' attr2='val2'><child>value</child></root>";
        JSONArray result = JSONML.toJSONArray(xml);
        assertNotNull(result);
        // When attributes are present, the structure is [tagName, attributesObject, childrenArray]
        // So length is 3: 0=tagName, 1=attributes, 2=children
        assertEquals(3, result.length());
        assertEquals("root", result.getString(0));
        JSONObject attrs = result.getJSONObject(1);
        assertEquals("val1", attrs.getString("attr1"));
        assertEquals("val2", attrs.getString("attr2"));
    }
}