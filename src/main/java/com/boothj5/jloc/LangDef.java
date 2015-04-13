package com.boothj5.jloc;

import java.util.List;

public class LangDef {

    private final String name;
    private final List<String> extensions;
    private final List<String> lineComments;
    private final List<BlockComment> blockComments;
    
    public LangDef(String name, List<String> extensions, List<String> lineComments, List<BlockComment> blockComments) {
        this.name = name;
        this.extensions = extensions;
        this.lineComments = lineComments;
        this.blockComments = blockComments;
    }

    public String getName() {
        return name;
    }

    public List<String> getExtensions() {
        return extensions;
    }

    public List<String> getLineComments() {
        return lineComments;
    }

    public List<BlockComment> getBlockComments() {
        return blockComments;
    }
    
    
}
