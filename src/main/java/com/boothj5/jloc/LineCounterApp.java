package com.boothj5.jloc;

import java.io.IOException;

public class LineCounterApp {
    public static void main(String[] args) throws IOException {
        FileHandler fileHandler = new FileHandler("/home/boothj5/projects-git/jloc/src/test/resources/minions");

        int files = fileHandler.fileCount();
        int lines = fileHandler.lineCount();

        System.out.println("Files: " + files);
        System.out.println("Lines: " + lines);
    }
}
