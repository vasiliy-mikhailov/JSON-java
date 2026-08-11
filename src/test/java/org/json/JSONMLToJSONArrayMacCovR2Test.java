package org.json;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

public class JSONMLToJSONArrayMacCovR2Test {

    @Test
    public void toJSONArrayStringParsesSimpleElement() {
        JSONArray result = JSONML.toJSONArray("<a/>");
        assertNotNull(result);
        assertEquals(1, result.length());
        assertEquals("a", result.getString(0));
    }

    @Test
    public void toJSONArrayXMLTokenerParsesSimpleElement() {
        JSONArray result = JSONML.toJSONArray(new XMLTokener("<b/>"));
        assertNotNull(result);
        assertEquals(1, result.length());
        assertEquals("b", result.getString(0));
    }

    @Test
    public void toJSONArrayStringParsesElementWithText() {
        JSONArray result = JSONML.toJSONArray("<c>text</c>");
        assertNotNull(result);
        assertEquals(2, result.length());
        assertEquals("c", result.getString(0));
        assertEquals("text", result.getString(1));
    }

    @Test
    public void toJSONArrayXMLTokenerParsesElementWithText() {
        JSONArray result = JSONML.toJSONArray(new XMLTokener("<d>value</d>"));
        assertNotNull(result);
        assertEquals(2, result.length());
        assertEquals("d", result.getString(0));
        assertEquals("value", result.getString(1));
    }
}
