package com.boothj5.jloc;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class FileLister {
    
    private final File path;
    private final List<String> extensions;
    
    public FileLister(String path, List<String> extensions) {
        this.path = new File(path);
        this.extensions = extensions;
    }
    
    public List<File> getFileListing() {
        List<File> result = getFileListingNoSort(path);
        if (result == null) {
            return result;
        } else {
            Collections.sort(result);
            return result;
        }
    }

    private List<File> getFileListingNoSort(File aStartingDir) {
        List<File> result = new ArrayList<File>();
        File[] filesAndDirs = aStartingDir.listFiles();
        if (filesAndDirs == null) {
            return null;
        }
        List<File> filesDirs = Arrays.asList(filesAndDirs);

        for(File file : filesDirs) {
            if (file.isFile()) {
                for (String extension : extensions) {
                    if (file.getName().endsWith("." + extension)) {
                        result.add(file);
                    }
                }
            }
            if (!file.isFile()) {
                List<File> deeperList = getFileListingNoSort(file);
                result.addAll(deeperList);
            }
        }
    
        return result;
    }

}