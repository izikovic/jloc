import java.io.File;
import java.util.List;

/*
 * Copyright 2013 Corelogic Ltd All Rights Reserved.
 */

public class Jloc {

    private static final List<LangDef> langDefs = Configuration.getDefs();
    private static final 
    
    public static void main(String[] args) {
        
            for (LangDef langDef : langDefs) {
                System.out.println("Analysing " + langDef.getName());
                FileLister fileLister = new FileLister("/home/james/projects-git/mosaic", langDef.getExtensions());
                
                List<File> files = fileLister.getFileListing();
                if (files == null) {
                    System.out.println("No code found.");
                } else {
                    System.out.println("Num files:" + files.size());
            }
        }
    }
}
