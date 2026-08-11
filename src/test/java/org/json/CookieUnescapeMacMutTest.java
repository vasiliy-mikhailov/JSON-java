package org.json;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class CookieUnescapeMacMutTest {

    @Test
    public void unescapePlusSign() {
        // covers unescape:200
        assertEquals(" ", Cookie.unescape("+"));
    }

    @Test
    public void unescapePercentBoundary() {
        // covers unescape:203
        assertEquals("%", Cookie.unescape("%"));
    }

    @Test
    public void unescapePercentWithOneChar() {
        // covers unescape:203
        assertEquals("%A", Cookie.unescape("%A"));
    }

    @Test
    public void unescapeValidHex() {
        // covers unescape:203
        assertEquals("A", Cookie.unescape("%41"));
    }

    @Test
    public void unescapeInvalidHex() {
        // covers unescape:203
        assertEquals("%ZZ", Cookie.unescape("%ZZ"));
    }
}
