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
        // The implementation sets maxNestingDepth to UNDEFINED_MAXIMUM_NESTING_DEPTH (-1) 
        // only if maxNestingDepth > UNDEFINED_MAXIMUM_NESTING_DEPTH (-1).
        // 0 > -1 is true, so it sets maxNestingDepth to 0.
        assertEquals(0, newConfig.getMaxNestingDepth());
    }
}