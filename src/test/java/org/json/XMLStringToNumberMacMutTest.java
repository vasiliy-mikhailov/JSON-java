package org.json;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;
import java.math.BigInteger;

import org.junit.Test;

public class XMLStringToNumberMacMutTest {

    @Test
    public void stringToNumberDecimalNotation() {
        // covers stringToNumber:541
        // covers stringToNumber:549
        // covers stringToNumber:550
        // covers stringToNumber:557
        // covers stringToNumber:560
        // covers stringToNumber:569
        // covers stringToNumber:572
        // covers stringToNumber:575
        // covers stringToNumber:588
        // covers stringToNumber:591
        // covers stringToNumber:592
        // covers stringToNumber:594
        
        Object result = XML.stringToValue("1.23", new XMLParserConfiguration());
        assertNotNull(result);
        assertTrue(result instanceof BigDecimal);
        assertEquals(new BigDecimal("1.23"), result);
    }

    @Test
    public void stringToNumberNegativeZero() {
        // covers stringToNumber:541
        // covers stringToNumber:549
        // covers stringToNumber:550
        // covers stringToNumber:557
        
        Object result = XML.stringToValue("-0.0", new XMLParserConfiguration());
        assertNotNull(result);
        assertTrue(result instanceof Double);
        assertEquals(-0.0, (Double) result, 0.0);
    }

    @Test
    public void stringToNumberHexFloat() {
        // covers stringToNumber:541
        // covers stringToNumber:549
        // covers stringToNumber:560
        // covers stringToNumber:569
        // covers stringToNumber:572
        // covers stringToNumber:575
        // covers stringToNumber:588
        // covers stringToNumber:591
        // covers stringToNumber:592
        // covers stringToNumber:594
        
        Object result = XML.stringToValue("0x1.0P-1074", new XMLParserConfiguration());
        assertNotNull(result);
        assertTrue(result instanceof Double);
        assertEquals(Double.MIN_VALUE, (Double) result, 0.0);
    }

    @Test
    public void stringToNumberInteger() {
        // covers stringToNumber:541
        // covers stringToNumber:549
        // covers stringToNumber:569
        // covers stringToNumber:572
        // covers stringToNumber:575
        // covers stringToNumber:588
        // covers stringToNumber:591
        // covers stringToNumber:592
        // covers stringToNumber:594
        
        Object result = XML.stringToValue("123", new XMLParserConfiguration());
        assertNotNull(result);
        assertTrue(result instanceof Integer);
        assertEquals(123, result);
    }

    @Test
    public void stringToNumberLong() {
        // covers stringToNumber:541
        // covers stringToNumber:549
        // covers stringToNumber:569
        // covers stringToNumber:572
        // covers stringToNumber:575
        // covers stringToNumber:588
        // covers stringToNumber:591
        // covers stringToNumber:592
        // covers stringToNumber:594
        
        Object result = XML.stringToValue("1234567890123456789", new XMLParserConfiguration());
        assertNotNull(result);
        assertTrue(result instanceof Long);
        assertEquals(1234567890123456789L, result);
    }

    @Test
    public void stringToNumberBigInteger() {
        // covers stringToNumber:541
        // covers stringToNumber:549
        // covers stringToNumber:569
        // covers stringToNumber:572
        // covers stringToNumber:575
        // covers stringToNumber:588
        // covers stringToNumber:591
        // covers stringToNumber:594
        
        Object result = XML.stringToValue("123456789012345678901234567890", new XMLParserConfiguration());
        assertNotNull(result);
        assertTrue(result instanceof BigInteger);
        assertEquals(new BigInteger("123456789012345678901234567890"), result);
    }

    @Test
    public void stringToNumberNegativeInteger() {
        // covers stringToNumber:541
        // covers stringToNumber:549
        // covers stringToNumber:569
        // covers stringToNumber:572
        // covers stringToNumber:575
        // covers stringToNumber:588
        // covers stringToNumber:591
        // covers stringToNumber:592
        // covers stringToNumber:594
        
        Object result = XML.stringToValue("-123", new XMLParserConfiguration());
        assertNotNull(result);
        assertTrue(result instanceof Integer);
        assertEquals(-123, result);
    }

    @Test
    public void stringToNumberNegativeLong() {
        // covers stringToNumber:541
        // covers stringToNumber:549
        // covers stringToNumber:569
        // covers stringToNumber:572
        // covers stringToNumber:575
        // covers stringToNumber:588
        // covers stringToNumber:591
        // covers stringToNumber:592
        // covers stringToNumber:594
        
        Object result = XML.stringToValue("-1234567890123456789", new XMLParserConfiguration());
        assertNotNull(result);
        assertTrue(result instanceof Long);
        assertEquals(-1234567890123456789L, result);
    }

    @Test
    public void stringToNumberNegativeBigInteger() {
        // covers stringToNumber:541
        // covers stringToNumber:549
        // covers stringToNumber:569
        // covers stringToNumber:572
        // covers stringToNumber:575
        // covers stringToNumber:588
        // covers stringToNumber:591
        // covers stringToNumber:594
        
        Object result = XML.stringToValue("-123456789012345678901234567890", new XMLParserConfiguration());
        assertNotNull(result);
        assertTrue(result instanceof BigInteger);
        assertEquals(new BigInteger("-123456789012345678901234567890"), result);
    }
}
