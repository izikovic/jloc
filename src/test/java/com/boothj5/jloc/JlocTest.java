package com.boothj5.jloc;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class JlocTest {

    @Test
    public void fileCountFilecount() {
        Jloc jloc = new Jloc("/filecount");

        assertEquals(12, jloc.countFiles());
    }

    @Test
    public void fileCountChttpclient() {
        Jloc jloc = new Jloc("/chttpclient");

        assertEquals(24, jloc.countFiles());
    }

    @Test
    public void lineCountChttpclient() {
        Jloc jloc = new Jloc("/chttpclient");

        LineCount lineCount = jloc.countLines();

        assertEquals(24, lineCount.getFiles());
        assertEquals(373, lineCount.getLines());
    }
}