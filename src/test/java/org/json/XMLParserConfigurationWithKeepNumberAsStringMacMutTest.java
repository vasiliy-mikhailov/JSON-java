package org.json;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class XMLParserConfigurationWithKeepNumberAsStringMacMutTest {

    @Test
    public void testWithKeepNumberAsStringReturnsNonNull() {
        XMLParserConfiguration config = new XMLParserConfiguration();
        XMLParserConfiguration newConfig = config.withKeepNumberAsString(true);
        assertNotNull(newConfig);
        assertTrue(newConfig.isKeepNumberAsString());
    }
}
