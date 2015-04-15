package com.boothj5.jloc.languages;

public class BlockComment {
    private final String start;
    private final String end;
    public BlockComment(String start, String end) {
        this.start = start;
        this.end = end;
    }
    public String getStart() {
        return start;
    }
    public String getEnd() {
        return end;
    }
}
