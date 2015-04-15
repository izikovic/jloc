package com.boothj5.jloc;

import com.boothj5.jloc.handlers.LangHandler;
import com.boothj5.jloc.languages.BlockComment;
import com.boothj5.jloc.languages.LangDef;

import java.io.IOException;

public class JavaCodeCounter {
    public static void main(String[] args) throws IOException {
        BlockComment blockComment = new BlockComment("/*", "*/");

        LangDef javaLang = new LangDef("Java", "java", "//", blockComment);

        LangHandler langHandler = new LangHandler("/home/boothj5/projects-git/jloc/src/test/resources/minions", javaLang);
        int files = langHandler.files();
        int code = langHandler.code();
        int comments = langHandler.comments();
        int blanks = langHandler.blanks();

        System.out.println("Files: " + files);
        System.out.println("Code: " + code);
        System.out.println("Comments: " + comments);
        System.out.println("Whitespace: " + blanks);
    }
}
