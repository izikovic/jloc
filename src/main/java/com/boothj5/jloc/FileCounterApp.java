package com.boothj5.jloc;

import com.boothj5.jloc.handlers.FileHandler;

import java.io.IOException;

public class FileCounterApp {
    private static final String PROJECT_ROOT = "/Users/cirrus/projects-git/jloc/";

    public static void main(String[] args) throws IOException {
        FileHandler fileHandler = new FileHandler(PROJECT_ROOT + "src/test/resources/filecount");
        int result = fileHandler.fileCount();
        System.out.println("Files: " + result);
    }
}
