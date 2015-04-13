package com.boothj5.jloc;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class JlocTest {

    @Test
    public void fileCountShouldReturnTotalFilesRecursively() {
        Jloc jloc = new Jloc("filecount");

        assertEquals(12, jloc.countFiles());
    }
}