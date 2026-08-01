package org.json;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class XMLParserConfigurationWithKeepBooleanAsStringMacCovTest {

    private XMLParserConfiguration config;

    @Before
    public void setUp() {
        config = new XMLParserConfiguration();
    }

    @Test
    public void withKeepBooleanAsStringSetsValueAndReturnsNewInstance() {
        XMLParserConfiguration newConfig = config.withKeepBooleanAsString(true);
        assertNotSame(config, newConfig);
        assertTrue(newConfig.isKeepBooleanAsString());
        assertFalse(config.isKeepBooleanAsString());
    }

    @Test
    public void withKeepBooleanAsStringFalseResetsKeepStringsWhenKeepNumberIsFalse() {
        XMLParserConfiguration newConfig = config.withKeepBooleanAsString(false);
        assertFalse(newConfig.isKeepBooleanAsString());
        assertFalse(newConfig.isKeepStrings());
    }

    @Test
    public void withKeepBooleanAsStringTrueSetsKeepStringsOnlyIfKeepNumberIsAlsoTrue() {
        XMLParserConfiguration base = config.withKeepNumberAsString(true);
        XMLParserConfiguration newConfig = base.withKeepBooleanAsString(true);
        assertTrue(newConfig.isKeepBooleanAsString());
        assertTrue(newConfig.isKeepStrings());
    }
}