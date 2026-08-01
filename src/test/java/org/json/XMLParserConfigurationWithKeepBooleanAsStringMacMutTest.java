package org.json;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNotSame;

import org.junit.Test;

public class XMLParserConfigurationWithKeepBooleanAsStringMacMutTest {

    @Test
    public void withKeepBooleanAsStringReturnsNewInstance() {
        // covers withKeepBooleanAsString:262
        XMLParserConfiguration original = new XMLParserConfiguration();
        XMLParserConfiguration result = original.withKeepBooleanAsString(true);
        assertNotNull(result);
        assertNotSame(original, result);
    }

    @Test
    public void withKeepBooleanAsStringSetsValue() {
        // covers withKeepBooleanAsString:261
        XMLParserConfiguration original = new XMLParserConfiguration();
        XMLParserConfiguration result = original.withKeepBooleanAsString(true);
        assertEquals(true, result.isKeepBooleanAsString());
    }
}