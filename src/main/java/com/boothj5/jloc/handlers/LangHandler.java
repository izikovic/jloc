package com.boothj5.jloc.handlers;

import com.boothj5.jloc.languages.LangDef;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;

public class LangHandler {
    private final LangDef langDef;
    private final File file;
    private int files;
    private int blank;
    private int comment;
    private int code;
    private boolean handled = false;

    public LangHandler(String filename, LangDef langDef) {
        this.langDef = langDef;
        this.file = new File(filename);
    }

    public int files() throws IOException {
        if (!handled) {
            count(file.toPath());
        }
        handled = true;
        return files;
    }

    public int blanks() throws IOException {
        if (!handled) {
            count(file.toPath());
        }
        handled = true;
        return blank;
    }

    private void count(Path path) throws IOException {
        try (DirectoryStream<Path> stream = Files.newDirectoryStream(path)) {
            for (Path entry : stream) {
                if (Files.isDirectory(entry)) {
                    count(entry);
                } else if (entry.toString().endsWith("." + langDef.getExtension())) {
                    files++;
                    FileReader fileReader = new FileReader(entry.toFile());
                    BufferedReader bufferedReader = new BufferedReader(fileReader);
                    String line = bufferedReader.readLine();
                    while (line != null) {
                        if (line.trim().equals(""))
                            blank++;
                        line = bufferedReader.readLine();
                    }
                    bufferedReader.close();
                }
            }
        }
    }
}
