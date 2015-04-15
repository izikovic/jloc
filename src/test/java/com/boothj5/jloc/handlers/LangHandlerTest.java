package com.boothj5.jloc.handlers;

import com.boothj5.jloc.languages.BlockComment;
import com.boothj5.jloc.languages.LangDef;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class LangHandlerTest {

    private LangDef javaLang;

    @Before
    public void setup() {
        List<String> lineComments = new ArrayList<>();
        lineComments.add("//");

        BlockComment blockComment = new BlockComment("/*", "*/");
        List<BlockComment> blockComments = new ArrayList<>();
        blockComments.add(blockComment);

        javaLang = new LangDef("Java", "java", lineComments, blockComments);
    }

    @Test
    public void shouldReturnJavaFileCount() throws IOException {
        LangHandler langHandler = new LangHandler("/home/boothj5/projects-git/jloc/src/test/resources/minions", javaLang);

        int result = langHandler.files();

        assertEquals(39, result);
    }

    @Test
    public void shouldReturnJavaBlankCount() throws IOException {
        LangHandler langHandler = new LangHandler("/home/boothj5/projects-git/jloc/src/test/resources/minions", javaLang);

        int result = langHandler.blanks();

        assertEquals(435, result);
    }
}