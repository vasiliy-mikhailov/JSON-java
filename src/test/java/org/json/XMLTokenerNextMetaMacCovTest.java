package org.json;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class XMLTokenerNextMetaMacCovTest {

    @Test
    public void nextMetaReturnsLTForLessThan() {
        XMLTokener tokener = new XMLTokener("<");
        Object result = tokener.nextMeta();
        assertEquals(XML.LT, result);
    }

    @Test
    public void nextMetaReturnsBooleanTrueForWord() {
        XMLTokener tokener = new XMLTokener("word ");
        Object result = tokener.nextMeta();
        assertTrue(result instanceof Boolean);
        assertEquals(Boolean.TRUE, result);
    }

    @Test
    public void nextMetaReturnsBooleanTrueForQuotedString() {
        XMLTokener tokener = new XMLTokener("\"quoted\"");
        Object result = tokener.nextMeta();
        assertTrue(result instanceof Boolean);
        assertEquals(Boolean.TRUE, result);
    }
}