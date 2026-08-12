package org.json;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class XMLTokenerNextMetaMacMutTest {

    @Test
    public void nextMetaReturnsGTForGreaterThan() {
        // covers nextMeta:282
        XMLTokener tokener = new XMLTokener(">");
        Object result = tokener.nextMeta();
        assertEquals(XML.GT, result);
    }

    @Test
    public void nextMetaReturnsSLASHForForwardSlash() {
        // covers nextMeta:284
        XMLTokener tokener = new XMLTokener("/");
        Object result = tokener.nextMeta();
        assertEquals(XML.SLASH, result);
    }

    @Test
    public void nextMetaReturnsEQForEquals() {
        // covers nextMeta:286
        XMLTokener tokener = new XMLTokener("=");
        Object result = tokener.nextMeta();
        assertEquals(XML.EQ, result);
    }

    @Test
    public void nextMetaReturnsBANGForExclamation() {
        // covers nextMeta:288
        XMLTokener tokener = new XMLTokener("!");
        Object result = tokener.nextMeta();
        assertEquals(XML.BANG, result);
    }

    @Test
    public void nextMetaReturnsQUESTForQuestionMark() {
        // covers nextMeta:290
        XMLTokener tokener = new XMLTokener("?");
        Object result = tokener.nextMeta();
        assertEquals(XML.QUEST, result);
    }

    @Test
    public void nextMetaReturnsBooleanTrueForDoubleQuotedString() {
        // covers nextMeta:292
        XMLTokener tokener = new XMLTokener("\"value\"");
        Object result = tokener.nextMeta();
        assertTrue(result instanceof Boolean);
        assertEquals(Boolean.TRUE, result);
    }

    @Test
    public void nextMetaReturnsBooleanTrueForSingleQuotedString() {
        // covers nextMeta:302
        XMLTokener tokener = new XMLTokener("'value'");
        Object result = tokener.nextMeta();
        assertTrue(result instanceof Boolean);
        assertEquals(Boolean.TRUE, result);
    }

    @Test
    public void nextMetaReturnsBooleanTrueForWordEndingInWhitespace() {
        // covers nextMeta:309
        XMLTokener tokener = new XMLTokener("word ");
        Object result = tokener.nextMeta();
        assertTrue(result instanceof Boolean);
        assertEquals(Boolean.TRUE, result);
    }

    @Test
    public void nextMetaReturnsBooleanTrueForWordEndingInSpecialChar() {
        // covers nextMeta:323
        // covers nextMeta:322
        XMLTokener tokener = new XMLTokener("word<");
        Object result = tokener.nextMeta();
        assertTrue(result instanceof Boolean);
        assertEquals(Boolean.TRUE, result);
    }

    @Test
    public void nextMetaThrowsOnUnterminatedDoubleQuote() {
        // covers nextMeta:298
        XMLTokener tokener = new XMLTokener("\"unterminated");
        try {
            tokener.nextMeta();
            throw new AssertionError("Expected JSONException");
        } catch (JSONException e) {
            // Expected
        }
    }

    @Test
    public void nextMetaThrowsOnUnterminatedSingleQuote() {
        // covers nextMeta:301
        XMLTokener tokener = new XMLTokener("'unterminated");
        try {
            tokener.nextMeta();
            throw new AssertionError("Expected JSONException");
        } catch (JSONException e) {
            // Expected
        }
    }

    @Test
    public void nextMetaThrowsOnUnterminatedWord() {
        // covers nextMeta:308
        XMLTokener tokener = new XMLTokener("unterminated");
        try {
            tokener.nextMeta();
            throw new AssertionError("Expected JSONException");
        } catch (JSONException e) {
            // Expected
        }
    }

    @Test
    public void nextMetaThrowsOnEmptyString() {
        // covers nextMeta:277
        XMLTokener tokener = new XMLTokener("");
        try {
            tokener.nextMeta();
            throw new AssertionError("Expected JSONException");
        } catch (JSONException e) {
            // Expected
        }
    }
}
