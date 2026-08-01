package org.json;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

public class ParserConfigurationWithMaxNumberLengthMacMutTest {

    @Test
    public void withMaxNumberLengthSetsValueWhenPositive() {
        ParserConfiguration config = new ParserConfiguration();
        ParserConfiguration newConfig = config.withMaxNumberLength(10);
        assertNotNull(newConfig);
        assertEquals(10, newConfig.getMaxNumberLength());
    }

    @Test
    public void withMaxNumberLengthResetsToUndefinedWhenNegative() {
        ParserConfiguration config = new ParserConfiguration();
        ParserConfiguration newConfig = config.withMaxNumberLength(-1);
        assertNotNull(newConfig);
        assertEquals(ParserConfiguration.UNDEFINED_MAXIMUM_NUMBER_LENGTH, newConfig.getMaxNumberLength());
    }
}
