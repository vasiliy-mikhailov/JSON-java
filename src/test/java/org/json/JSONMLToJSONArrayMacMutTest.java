package org.json;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNotSame;

import org.junit.Test;

public class JSONMLToJSONArrayMacMutTest {

    @Test
    public void toJSONArrayString() {
        // covers toJSONArray:353
        String xml = "<root><child>value</child></root>";
        JSONArray result = JSONML.toJSONArray(xml);
        assertNotNull(result);
        assertNotSame(null, result);
    }

    @Test
    public void toJSONArrayStringConfig() {
        // covers toJSONArray:377
        String xml = "<root><child>value</child></root>";
        JSONMLParserConfiguration config = JSONMLParserConfiguration.ORIGINAL;
        JSONArray result = JSONML.toJSONArray(xml, config);
        assertNotNull(result);
        assertNotSame(null, result);
    }

    @Test
    public void toJSONArrayXMLTokenerConfig() {
        // covers toJSONArray:399
        String xml = "<root><child>value</child></root>";
        XMLTokener tokener = new XMLTokener(xml);
        JSONMLParserConfiguration config = JSONMLParserConfiguration.ORIGINAL;
        JSONArray result = JSONML.toJSONArray(tokener, config);
        assertNotNull(result);
        assertNotSame(null, result);
    }

    @Test
    public void toJSONArrayXMLTokenerKeepStrings() {
        // covers toJSONArray:416
        String xml = "<root><child>value</child></root>";
        XMLTokener tokener = new XMLTokener(xml);
        JSONArray result = JSONML.toJSONArray(tokener, true);
        assertNotNull(result);
        assertNotSame(null, result);
    }
}
