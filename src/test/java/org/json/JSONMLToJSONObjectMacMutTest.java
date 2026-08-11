package org.json;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNotSame;

import org.junit.Test;

public class JSONMLToJSONObjectMacMutTest {

    @Test
    public void toJSONObjectStringReturnsNonNull() {
        // covers toJSONObject:476
        JSONObject result = JSONML.toJSONObject("<a/>");
        assertNotNull(result);
        assertNotSame(null, result);
    }

    @Test
    public void toJSONObjectStringConfigReturnsNonNull() {
        // covers toJSONObject:494
        JSONObject result = JSONML.toJSONObject("<a/>", JSONMLParserConfiguration.ORIGINAL);
        assertNotNull(result);
        assertNotSame(null, result);
    }

    @Test
    public void toJSONObjectXMLTokenerReturnsNonNull() {
        // covers toJSONObject:514
        JSONObject result = JSONML.toJSONObject(new XMLTokener("<a/>"));
        assertNotNull(result);
        assertNotSame(null, result);
    }

    @Test
    public void toJSONObjectXMLTokenerKeepStringsReturnsNonNull() {
        // covers toJSONObject:536
        JSONObject result = JSONML.toJSONObject(new XMLTokener("<a/>"), true);
        assertNotNull(result);
        assertNotSame(null, result);
    }
}