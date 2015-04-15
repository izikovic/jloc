package com.boothj5.jloc.handlers;

import com.boothj5.jloc.languages.LangDef;

import java.io.File;
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

    public LangHandler(String filename, LangDef langDef) {
        this.langDef = langDef;
        this.file = new File(filename);
    }

    public int files() throws IOException {
        countFiles(file.toPath());
        return files;
    }

    private void countFiles(Path path) throws IOException {
        try (DirectoryStream<Path> stream = Files.newDirectoryStream(path)) {
            for (Path entry : stream) {
                if (Files.isDirectory(entry)) {
                    countFiles(entry);
                } else if (entry.toString().endsWith("." + langDef.getExtension())) {
                    files++;
                }
            }
        }
    }

}
