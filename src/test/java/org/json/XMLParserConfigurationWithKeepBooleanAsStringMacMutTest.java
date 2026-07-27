package org.json;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class XMLParserConfigurationWithKeepBooleanAsStringMacMutTest {

    @Test
    public void testWithKeepBooleanAsStringReturnsNonNull() {
        XMLParserConfiguration config = new XMLParserConfiguration();
        XMLParserConfiguration newConfig = config.withKeepBooleanAsString(true);
        assertNotNull(newConfig);
        assertTrue(newConfig.isKeepBooleanAsString());
    }
}
