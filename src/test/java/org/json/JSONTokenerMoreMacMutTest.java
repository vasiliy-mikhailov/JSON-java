package org.json;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.io.StringReader;

import org.junit.Test;

public class JSONTokenerMoreMacMutTest {

    // covers more:199
    // covers more:189
    @Test
    public void moreReturnsFalseAtEOF() {
        JSONTokener tokener = new JSONTokener(new StringReader(""));
        assertFalse(tokener.more());
    }

    // covers more:193
    // covers more:203
    // covers more:207
    // covers more:190
    @Test
    public void moreReturnsTrueWhenContentExists() {
        JSONTokener tokener = new JSONTokener(new StringReader("a"));
        assertTrue(tokener.more());
    }
}
