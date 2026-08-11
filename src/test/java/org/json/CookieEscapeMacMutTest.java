package org.json;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class CookieEscapeMacMutTest {

    @Test
    public void escapeSpaceCharacter() {
        // covers escape:45
        // Cookie.escape trims the input string first. " " becomes "".
        assertEquals("", Cookie.escape(" "));
    }

    @Test
    public void escapePlusSign() {
        // covers escape:45
        // Cookie.escape uses lowercase hex digits via Character.forDigit(..., 16)
        assertEquals("%2b", Cookie.escape("+"));
    }

    @Test
    public void escapePercentSign() {
        // covers escape:45
        assertEquals("%25", Cookie.escape("%"));
    }

    @Test
    public void escapeEqualsSign() {
        // covers escape:45
        // Cookie.escape uses lowercase hex digits
        assertEquals("%3d", Cookie.escape("="));
    }

    @Test
    public void escapeSemicolon() {
        // covers escape:45
        // Cookie.escape uses lowercase hex digits
        assertEquals("%3b", Cookie.escape(";"));
    }

    @Test
    public void escapeNormalCharacter() {
        // covers escape:45
        assertEquals("a", Cookie.escape("a"));
    }

    @Test
    public void escapeEmptyString() {
        // covers escape:45
        assertEquals("", Cookie.escape(""));
    }

    @Test
    public void escapeWhitespaceOnly() {
        // covers escape:45
        // Cookie.escape trims the input string first. "   " becomes "".
        assertEquals("", Cookie.escape("   "));
    }

    @Test
    public void escapeHighAsciiCharacter() {
        // covers escape:45
        // High ASCII characters (>= 0x80) are NOT escaped by this implementation,
        // they are appended as-is. \\u00FF is a valid char in Java strings.
        assertEquals("\u00FF", Cookie.escape("\u00FF"));
    }
}
