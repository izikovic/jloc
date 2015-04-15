package com.boothj5.jloc.handlers;

import com.boothj5.jloc.handlers.FileHandler;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertEquals;

public class FileHandlerTest {

    @Test
    public void testFilecountFiles() throws IOException {
        FileHandler fileHandler = new FileHandler("/home/boothj5/projects-git/jloc/src/test/resources/filecount");

        int files = fileHandler.fileCount();

        assertEquals(12, files);
    }

    @Test
    public void testMinionsFiles() throws IOException {
        FileHandler fileHandler = new FileHandler("/home/boothj5/projects-git/jloc/src/test/resources/minions");

        int files = fileHandler.fileCount();

        assertEquals(62, files);
    }

    @Test
    public void testFilecountLines() throws IOException {
        FileHandler fileHandler = new FileHandler("/home/boothj5/projects-git/jloc/src/test/resources/filecount");

        int files = fileHandler.lineCount();

        assertEquals(16, files);
    }

    @Test
    public void testMinionsLines() throws IOException {
        FileHandler fileHandler = new FileHandler("/home/boothj5/projects-git/jloc/src/test/resources/minions");

        int files = fileHandler.lineCount();

        assertEquals(4044, files);
    }

}