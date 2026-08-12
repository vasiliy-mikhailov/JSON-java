package org.json;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.io.StringReader;

import org.junit.Test;

public class JSONTokenerMoreMacMutTest {

    @Test
    public void moreReturnsFalseAtEOF() {
        JSONTokener tokener = new JSONTokener(new StringReader(""));
        assertFalse(tokener.more());
    }

    @Test
    public void moreReturnsTrueWhenContentExists() {
        JSONTokener tokener = new JSONTokener(new StringReader("a"));
        assertTrue(tokener.more());
    }
}
