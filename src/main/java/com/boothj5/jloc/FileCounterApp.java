package com.boothj5.jloc;

import com.boothj5.jloc.handlers.FileHandler;

import java.io.IOException;

public class FileCounterApp {
    public static void main(String[] args) throws IOException {
        FileHandler fileHandler = new FileHandler("/home/boothj5/projects-git/jloc/src/test/resources/filecount");
        int result = fileHandler.fileCount();
        System.out.println("Files: " + result);
    }
}
