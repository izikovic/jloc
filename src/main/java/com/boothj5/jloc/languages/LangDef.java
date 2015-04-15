package com.boothj5.jloc.languages;

public class LangDef {
    private final String name;
    private final String extension;
    private final String lineComment;
    private final BlockComment blockComment;

    public LangDef(String name, String extension, String lineComment, BlockComment blockComment) {
        this.name = name;
        this.extension = extension;
        this.lineComment = lineComment;
        this.blockComment = blockComment;
    }
    public String getName() {
        return name;
    }
    public String getExtension() {
        return extension;
    }
    public String getLineComment() {
        return lineComment;
    }
    public BlockComment getBlockComment() {
        return blockComment;
    }
}
