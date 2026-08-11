package org.json;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class CookieUnescapeMacMutTest {

    @Test
    public void unescapePlusSign() {
        assertEquals(" ", Cookie.unescape("+"));
    }

    @Test
    public void unescapePercentBoundary() {
        assertEquals("%", Cookie.unescape("%"));
    }

    @Test
    public void unescapePercentWithOneChar() {
        assertEquals("%A", Cookie.unescape("%A"));
    }

    @Test
    public void unescapeValidHex() {
        assertEquals("A", Cookie.unescape("%41"));
    }

    @Test
    public void unescapeInvalidHex() {
        assertEquals("%ZZ", Cookie.unescape("%ZZ"));
    }
}
