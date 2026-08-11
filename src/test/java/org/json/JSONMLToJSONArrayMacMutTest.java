package org.json;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNotSame;

import org.junit.Test;

public class JSONMLToJSONArrayMacMutTest {

    @Test
    public void toJSONArrayStringReturnsNonNull() {
        // covers toJSONArray:353
        JSONArray result = JSONML.toJSONArray("<a/>", false);
        assertNotNull(result);
        assertNotSame(null, result);
    }

    @Test
    public void toJSONArrayStringConfigReturnsNonNull() {
        // covers toJSONArray:377
        JSONArray result = JSONML.toJSONArray("<a/>", JSONMLParserConfiguration.ORIGINAL);
        assertNotNull(result);
        assertNotSame(null, result);
    }

    @Test
    public void toJSONArrayXMLTokenerConfigReturnsNonNull() {
        // covers toJSONArray:399
        JSONArray result = JSONML.toJSONArray(new XMLTokener("<a/>"), JSONMLParserConfiguration.ORIGINAL);
        assertNotNull(result);
        assertNotSame(null, result);
    }

    @Test
    public void toJSONArrayXMLTokenerKeepStringsReturnsNonNull() {
        // covers toJSONArray:416
        JSONArray result = JSONML.toJSONArray(new XMLTokener("<a/>"), true);
        assertNotNull(result);
        assertNotSame(null, result);
    }
}