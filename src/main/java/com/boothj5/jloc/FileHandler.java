package com.boothj5.jloc;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileHandler {
    private final File file;
    private int files;
    private int lines;
    private boolean handled = false;

    public FileHandler(String filename) {
        file = new File(filename);
    }

    public int fileCount() throws IOException {
        if (!handled) {
            count(file.toPath());
        }
        return files;
    }

    public int lineCount() throws IOException {
        if (!handled) {
            count(file.toPath());
        }
        return lines;
    }

    private void count(Path path) throws IOException {
        try (DirectoryStream<Path> stream = Files.newDirectoryStream(path)) {
            for (Path entry : stream) {
                if (Files.isDirectory(entry)) {
                    count(entry);
                } else {
                    files++;
                    FileReader fileReader = new FileReader(entry.toFile());
                    BufferedReader bufferedReader = new BufferedReader(fileReader);
                    while (bufferedReader.readLine() != null)
                        lines++;
                    bufferedReader.close();
                }
            }
        }
    }
}
