package com.boothj5.jloc;

public class CodeCount {

    private final int files;
    private final int code;
    private final int comments;
    private final int whitespace;

    public CodeCount(int files, int code, int comments, int whitespace) {
        this.files = files;
        this.code = code;
        this.comments = comments;
        this.whitespace = whitespace;
    }

    public int getFiles() {
        return files;
    }

    public int getCode() {
        return code;
    }

    public int getComments() {
        return comments;
    }

    public int getWhitespace() {
        return whitespace;
    }
}
