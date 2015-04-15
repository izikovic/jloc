package com.boothj5.jloc.languages;

import java.util.List;

public class LangDef {
    private final String name;
    private final String extension;
    private final List<String> lineComments;
    private final List<BlockComment> blockComments;

    public LangDef(String name, String extension, List<String> lineComments, List<BlockComment> blockComments) {
        this.name = name;
        this.extension = extension;
        this.lineComments = lineComments;
        this.blockComments = blockComments;
    }
    public String getName() {
        return name;
    }
    public String getExtension() {
        return extension;
    }
    public List<String> getLineComments() {
        return lineComments;
    }
    public List<BlockComment> getBlockComments() {
        return blockComments;
    }
}
