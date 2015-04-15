package com.boothj5.jloc.handlers;

import com.boothj5.jloc.languages.BlockComment;
import com.boothj5.jloc.languages.LangDef;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertEquals;

public class LangHandlerTest {
    private static final String PROJECT_ROOT = "/Users/cirrus/projects-git/jloc/";

    private LangDef javaLang;

    @Before
    public void setup() {
        BlockComment blockComment = new BlockComment("/*", "*/");
        javaLang = new LangDef("Java", "java", "//", blockComment);
    }

    @Test
    public void shouldReturnJavaFileCount() throws IOException {
        LangHandler langHandler = new LangHandler(PROJECT_ROOT + "src/test/resources/minions", javaLang);

        int result = langHandler.files();

        assertEquals(39, result);
    }

    @Test
    public void shouldReturnJavaBlankCount() throws IOException {
        LangHandler langHandler = new LangHandler(PROJECT_ROOT + "src/test/resources/minions", javaLang);

        int result = langHandler.blanks();

        assertEquals(436, result);
    }

    @Test
    public void shouldReturnJavaCommentCount() throws IOException {
        LangHandler langHandler = new LangHandler(PROJECT_ROOT + "src/test/resources/minions", javaLang);

        int result = langHandler.comments();

        assertEquals(264, result);
    }

    @Test
    public void shouldReturnJavaCodeCount() throws IOException {
        LangHandler langHandler = new LangHandler(PROJECT_ROOT + "src/test/resources/minions", javaLang);

        int result = langHandler.code();

        assertEquals(1978, result);
    }

    @Test
    public void shouldReturnJavaStats() throws IOException {
        LangHandler langHandler = new LangHandler(PROJECT_ROOT + "src/test/resources/minions", javaLang);

        int files = langHandler.files();
        int code = langHandler.code();
        int comments = langHandler.comments();
        int blanks = langHandler.blanks();

        assertEquals(39, files);
        assertEquals(1978, code);
        assertEquals(264, comments);
        assertEquals(436, blanks);
    }
}