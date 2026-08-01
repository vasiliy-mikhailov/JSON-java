package org.json;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class ParserConfigurationWithMaxNestingDepthMacCovTest {

    @Test
    public void withMaxNestingDepthSetsValueWhenPositive() {
        ParserConfiguration config = new ParserConfiguration();
        ParserConfiguration newConfig = config.withMaxNestingDepth(10);
        assertEquals(10, newConfig.getMaxNestingDepth());
    }

    @Test
    public void withMaxNestingDepthResetsToUndefinedWhenNegative() {
        ParserConfiguration config = new ParserConfiguration();
        ParserConfiguration newConfig = config.withMaxNestingDepth(-1);
        assertEquals(ParserConfiguration.UNDEFINED_MAXIMUM_NESTING_DEPTH, newConfig.getMaxNestingDepth());
    }

    @Test
    public void withMaxNestingDepthResetsToUndefinedWhenZero() {
        ParserConfiguration config = new ParserConfiguration();
        ParserConfiguration newConfig = config.withMaxNestingDepth(0);
        assertEquals(0, newConfig.getMaxNestingDepth());
    }
}
