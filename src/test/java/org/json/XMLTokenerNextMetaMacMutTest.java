package org.json;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class XMLTokenerNextMetaMacMutTest {

    @Test
    public void nextMetaReturnsGTForGreaterThan() {
        XMLTokener tokener = new XMLTokener(">");
        Object result = tokener.nextMeta();
        assertEquals(XML.GT, result);
    }

    @Test
    public void nextMetaReturnsSLASHForForwardSlash() {
        XMLTokener tokener = new XMLTokener("/");
        Object result = tokener.nextMeta();
        assertEquals(XML.SLASH, result);
    }

    @Test
    public void nextMetaReturnsEQForEquals() {
        XMLTokener tokener = new XMLTokener("=");
        Object result = tokener.nextMeta();
        assertEquals(XML.EQ, result);
    }

    @Test
    public void nextMetaReturnsBANGForExclamation() {
        XMLTokener tokener = new XMLTokener("!");
        Object result = tokener.nextMeta();
        assertEquals(XML.BANG, result);
    }

    @Test
    public void nextMetaReturnsQUESTForQuestionMark() {
        XMLTokener tokener = new XMLTokener("?");
        Object result = tokener.nextMeta();
        assertEquals(XML.QUEST, result);
    }

    @Test
    public void nextMetaReturnsBooleanTrueForDoubleQuotedString() {
        XMLTokener tokener = new XMLTokener("\"value\"");
        Object result = tokener.nextMeta();
        assertTrue(result instanceof Boolean);
        assertEquals(Boolean.TRUE, result);
    }

    @Test
    public void nextMetaReturnsBooleanTrueForSingleQuotedString() {
        XMLTokener tokener = new XMLTokener("'value'");
        Object result = tokener.nextMeta();
        assertTrue(result instanceof Boolean);
        assertEquals(Boolean.TRUE, result);
    }

    @Test
    public void nextMetaReturnsBooleanTrueForWordEndingInWhitespace() {
        XMLTokener tokener = new XMLTokener("word ");
        Object result = tokener.nextMeta();
        assertTrue(result instanceof Boolean);
        assertEquals(Boolean.TRUE, result);
    }

    @Test
    public void nextMetaReturnsBooleanTrueForWordEndingInSpecialChar() {
        XMLTokener tokener = new XMLTokener("word<");
        Object result = tokener.nextMeta();
        assertTrue(result instanceof Boolean);
        assertEquals(Boolean.TRUE, result);
    }

    @Test
    public void nextMetaThrowsOnUnterminatedDoubleQuote() {
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
        XMLTokener tokener = new XMLTokener("");
        try {
            tokener.nextMeta();
            throw new AssertionError("Expected JSONException");
        } catch (JSONException e) {
            // Expected
        }
    }
}
