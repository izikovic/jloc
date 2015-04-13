package com.boothj5.jloc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Configuration {

    public static final List<LangDef> getDefs() {
        LangDef java = new LangDef(
                "Java", 
                new ArrayList<String>(Arrays.asList("java")), 
                new ArrayList<String>(Arrays.asList("//")), 
                new ArrayList<BlockComment>(Arrays.asList(new BlockComment("/*", "*/"))));
        
        List<LangDef> result = new ArrayList<LangDef>();
        result.add(java);
        
        return result;
    }
}
