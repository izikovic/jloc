package com.boothj5.jloc;

import com.boothj5.jloc.handlers.LangHandler;
import com.boothj5.jloc.languages.BlockComment;
import com.boothj5.jloc.languages.LangDef;

public class JavaCodeCounter {
    public static void main(String[] args) {
        BlockComment blockComment = new BlockComment("/*", "*/");

        LangDef javaLang = new LangDef("Java", "java", "//", blockComment);

        LangHandler langHandler = new LangHandler("/home/boothj5/projects-git/jloc/src/test/resources/minions", javaLang);

        System.out.println("Files: 0");
        System.out.println("Code: 0");
        System.out.println("Comments: 0");
        System.out.println("Whitespace: 0");
    }
}
