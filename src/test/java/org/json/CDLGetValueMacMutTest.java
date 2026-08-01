package org.json;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class CDLGetValueMacMutTest {

    @Test
    public void getValue_emptyValueAtDelimiter() {
        // covers getValue:53
        JSONTokener x = new JSONTokener(",b");
        JSONArray result = CDL.rowToJSONArray(x);
        assertEquals(2, result.length());
        assertEquals("", result.getString(0));
        assertEquals("b", result.getString(1));
    }

    @Test
    public void getValue_quotedValueWithEscapedQuote() {
        // covers getValue:69
        // The source code logic for escaped quotes is: 
        // if (c == q) { char nextC = x.next(); if (nextC != '"') { ... break; } }
        // This means it only treats a quote as escaped if it is followed by ANOTHER quote.
        // It does NOT support backslash escaping (\"), it supports double-quote escaping ("").
        // So to get a literal quote in the output, we must input two quotes inside the string.
        // Input: "a\"\"b",c  -> The parser sees 'a', then '\"', then '\"'. 
        // Wait, let's trace "a\"\"b":
        // 1. Start quote "
        // 2. Read 'a', append 'a'
        // 3. Read '\"', c='\"'. q='\"'. Match.
        // 4. Read nextC. If nextC is '\"', it's an escaped quote. The code does NOT append anything to sb in this branch? 
        //    Let's look closely at the source:
        //    if (c == q) {
        //        char nextC = x.next();
        //        if (nextC != '"') {
        //             ... break;
        //        }
        //    }
        //    if (c == 0 || c == '\n' || c == '\r') { ... }
        //    sb.append(c);
        //
        //    If nextC == '"', the loop continues. c is still '\"'. sb.append('\"').
        //    So "a\"\"b" results in sb containing "a\"". Then it reads 'b', appends 'b'. Result "a\"b".
        //    So the input string should be "a\"\"b",c
        JSONTokener x = new JSONTokener("\"a\"\"b\",c");
        JSONArray result = CDL.rowToJSONArray(x);
        assertEquals(2, result.length());
        assertEquals("a\"b", result.getString(0));
        assertEquals("c", result.getString(1));
    }

    @Test
    public void getValue_quotedValueEndOfFile() {
        // covers getValue:75
        JSONTokener x = new JSONTokener("\"a\"");
        JSONArray result = CDL.rowToJSONArray(x);
        assertEquals(1, result.length());
        assertEquals("a", result.getString(0));
    }

    @Test
    public void getValue_backOnDelimiter() {
        // covers getValue:76
        JSONTokener x = new JSONTokener(",b");
        JSONArray result = CDL.rowToJSONArray(x);
        assertEquals(2, result.length());
        assertEquals("", result.getString(0));
        assertEquals("b", result.getString(1));
    }
}
