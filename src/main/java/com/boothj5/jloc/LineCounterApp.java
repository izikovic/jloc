package com.boothj5.jloc;

import hr.zika.FileCounterApp;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class LineCounterApp {
	public static long countLines(String path) {
		List<File> files = FileCounterApp.getAllFiles(path);
		long numberOfLines = 0;
		
		for (File file : files) {
			try {
				numberOfLines += Files.lines(file.toPath()).count();
				
			} catch (IOException e) { }
		}

		return numberOfLines;
	}

	public static void main(String[] args) {
		String path = "";
		if (args.length == 0) {
			Path currentRelativePath = Paths.get("");
			path = currentRelativePath.toAbsolutePath().toString();
		} else {
			path = args[0];
		}

		System.out.println("Files: " + FileCounterApp.countFiles(path));
		System.out.println("Lines: " + countLines(path));
	}
}
