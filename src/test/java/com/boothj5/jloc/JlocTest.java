package com.boothj5.jloc;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class JlocTest {

    @Test
    public void fileCountShouldReturnTotalFilesRecursivelyForFilecount() {
        Jloc jloc = new Jloc("/filecount");

        assertEquals(12, jloc.countFiles());
    }

    @Test
    public void fileCountShouldReturnTotalFilesRecursivelyForChttpclient() {
        Jloc jloc = new Jloc("/chttpclient");

        assertEquals(24, jloc.countFiles());
    }
}