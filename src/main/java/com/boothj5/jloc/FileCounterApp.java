package com.boothj5.jloc;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class FileCounterApp {
	public static List<File> getAllFiles(String path, String extension) {
		List<File> files = new ArrayList<>();

		File[] currentFiles = new File(path).listFiles();

		for (File file : currentFiles) {
			if (file.isDirectory()) {
				files.addAll(getAllFiles(file.getAbsolutePath(), extension));
			} else {
				if (file.getAbsolutePath().toUpperCase().endsWith(extension.toUpperCase())) {
				files.add(file);
				}
			}

		}

		return files;
	}
	
	public static List<File> getAllFiles(String path) {
		return getAllFiles(path, "");
	}

	public static int countFiles(String path) {
		return getAllFiles(path).size();
	}

	public static void main(String[] args) {
		String path = "";
		if (args.length == 0) {
			Path currentRelativePath = Paths.get("");
			path = currentRelativePath.toAbsolutePath().toString();
		} else {
			path = args[0];
		}

		int result = countFiles(path);

		System.out.println("Files: " + result);
	}
}
