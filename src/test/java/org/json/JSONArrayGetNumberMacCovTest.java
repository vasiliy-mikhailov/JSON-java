package org.json;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.math.BigDecimal;
import java.math.BigInteger;

import org.junit.Test;

public class JSONArrayGetNumberMacCovTest {

    @Test
    public void getNumberReturnsInteger() {
        JSONArray array = new JSONArray();
        array.put(42);
        Number number = array.getNumber(0);
        assertNotNull(number);
        assertEquals(42, number.intValue());
    }

    @Test
    public void getNumberReturnsDouble() {
        JSONArray array = new JSONArray();
        array.put(3.14);
        Number number = array.getNumber(0);
        assertNotNull(number);
        assertEquals(3.14, number.doubleValue(), 0.0001);
    }

    @Test
    public void getNumberParsesStringAsNumber() {
        JSONArray array = new JSONArray();
        array.put("123.45");
        Number number = array.getNumber(0);
        assertNotNull(number);
        assertEquals(123.45, number.doubleValue(), 0.0001);
    }

    @Test
    public void getNumberReturnsBigDecimal() {
        JSONArray array = new JSONArray();
        array.put(new BigDecimal("999.99"));
        Number number = array.getNumber(0);
        assertNotNull(number);
        assertEquals(new BigDecimal("999.99"), number);
    }

    @Test
    public void getNumberReturnsBigInteger() {
        JSONArray array = new JSONArray();
        array.put(new BigInteger("12345678901234567890"));
        Number number = array.getNumber(0);
        assertNotNull(number);
        assertEquals(new BigInteger("12345678901234567890"), number);
    }
}
