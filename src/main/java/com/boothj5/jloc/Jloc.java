package com.boothj5.jloc;

import java.io.File;
import java.util.List;

public class Jloc {

    private static final List<LangDef> langDefs = Configuration.getDefs();

    public Jloc(String directory) {

    }

    public int countFiles() {
        return -1;
    }

    public LineCount countLines() {
        return null;
    }

    public CodeCount countCode() {
        return null;
    }

//    public static void main(String[] args) {
//        for (LangDef langDef : langDefs) {
//            System.out.println("Analysing " + langDef.getName());
//            FileLister fileLister = new FileLister("/home/james/projects-git/mosaic", langDef.getExtensions());
//
//            List<File> files = fileLister.getFileListing();
//            if (files == null) {
//                System.out.println("No code found.");
//            } else {
//                System.out.println("Num files:" + files.size());
//            }
//        }
//    }
}
