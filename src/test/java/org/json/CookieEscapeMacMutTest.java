package org.json;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class CookieEscapeMacMutTest {

    @Test
    public void escapeSpaceCharacter() {
        assertEquals("", Cookie.escape(" "));
    }

    @Test
    public void escapePlusSign() {
        assertEquals("%2b", Cookie.escape("+"));
    }

    @Test
    public void escapePercentSign() {
        assertEquals("%25", Cookie.escape("%"));
    }

    @Test
    public void escapeEqualsSign() {
        assertEquals("%3d", Cookie.escape("="));
    }

    @Test
    public void escapeSemicolon() {
        assertEquals("%3b", Cookie.escape(";"));
    }

    @Test
    public void escapeNormalCharacter() {
        assertEquals("a", Cookie.escape("a"));
    }

    @Test
    public void escapeEmptyString() {
        assertEquals("", Cookie.escape(""));
    }

    @Test
    public void escapeWhitespaceOnly() {
        assertEquals("", Cookie.escape("   "));
    }

    @Test
    public void escapeHighAsciiCharacter() {
        assertEquals("\u00FF", Cookie.escape("\u00FF"));
    }
}
