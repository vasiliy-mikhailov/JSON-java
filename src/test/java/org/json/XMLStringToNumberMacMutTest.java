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
        // Verifies decimal notation parsing returns BigDecimal
        Object result = XML.stringToValue("1.23", new XMLParserConfiguration());
        assertNotNull(result);
        assertTrue(result instanceof BigDecimal);
        assertEquals(new BigDecimal("1.23"), result);
    }

    @Test
    public void stringToNumberNegativeZero() {
        // Verifies negative zero parsing returns Double
        Object result = XML.stringToValue("-0.0", new XMLParserConfiguration());
        assertNotNull(result);
        assertTrue(result instanceof Double);
        assertEquals(-0.0, (Double) result, 0.0);
    }

    @Test
    public void stringToNumberHexFloat() {
        // Verifies hex float parsing returns Double
        Object result = XML.stringToValue("0x1.0P-1074", new XMLParserConfiguration());
        assertNotNull(result);
        assertTrue(result instanceof Double);
        assertEquals(Double.MIN_VALUE, (Double) result, 0.0);
    }

    @Test
    public void stringToNumberInteger() {
        // Verifies integer parsing returns Integer
        Object result = XML.stringToValue("123", new XMLParserConfiguration());
        assertNotNull(result);
        assertTrue(result instanceof Integer);
        assertEquals(123, result);
    }

    @Test
    public void stringToNumberLong() {
        // Verifies long parsing returns Long
        Object result = XML.stringToValue("1234567890123456789", new XMLParserConfiguration());
        assertNotNull(result);
        assertTrue(result instanceof Long);
        assertEquals(1234567890123456789L, result);
    }

    @Test
    public void stringToNumberBigInteger() {
        // Verifies big integer parsing returns BigInteger
        Object result = XML.stringToValue("123456789012345678901234567890", new XMLParserConfiguration());
        assertNotNull(result);
        assertTrue(result instanceof BigInteger);
        assertEquals(new BigInteger("123456789012345678901234567890"), result);
    }

    @Test
    public void stringToNumberNegativeInteger() {
        // Verifies negative integer parsing returns Integer
        Object result = XML.stringToValue("-123", new XMLParserConfiguration());
        assertNotNull(result);
        assertTrue(result instanceof Integer);
        assertEquals(-123, result);
    }

    @Test
    public void stringToNumberNegativeLong() {
        // Verifies negative long parsing returns Long
        Object result = XML.stringToValue("-1234567890123456789", new XMLParserConfiguration());
        assertNotNull(result);
        assertTrue(result instanceof Long);
        assertEquals(-1234567890123456789L, result);
    }

    @Test
    public void stringToNumberNegativeBigInteger() {
        // Verifies negative big integer parsing returns BigInteger
        Object result = XML.stringToValue("-123456789012345678901234567890", new XMLParserConfiguration());
        assertNotNull(result);
        assertTrue(result instanceof BigInteger);
        assertEquals(new BigInteger("-123456789012345678901234567890"), result);
    }
}
