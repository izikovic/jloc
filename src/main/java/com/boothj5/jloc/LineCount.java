package com.boothj5.jloc;

public class LineCount {
    private final int files;
    private final int lines;

    public LineCount(int files, int lines) {
        this.files = files;
        this.lines = lines;
    }

    public int getFiles() {
        return files;
    }

    public int getLines() {
        return lines;
    }
}
