package com.boothj5.jloc;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.List;

class Stats {
	public final int numberOfFiles;
	public final int numberOfCode;
	public final int numberOfComments;
	public final int numberOfWhitespace;

	public Stats(int numberOfFiles, int numberOfCode, int numberOfComments, int numberOfWhitespace) {
		super();
		this.numberOfFiles = numberOfFiles;
		this.numberOfCode = numberOfCode;
		this.numberOfComments = numberOfComments;
		this.numberOfWhitespace = numberOfWhitespace;
	}

}

public class JavaCodeCounterApp {
	public static Stats getStatistics(String path) throws IOException {
		List<File> javaFiles = FileCounterApp.getAllFiles(path, "java");

		int numberOfFiles = 0;
		int numberOfCode = 0;
		int numberOfComments = 0;
		int numberOfWhitespace = 0;

		for (File file : javaFiles) {
			Iterator<String> iterator = Files.lines(file.toPath()).iterator();
			numberOfFiles++;

			boolean commentBlock = false;
			while (iterator.hasNext()) {
				String line = iterator.next();

				if (commentBlock) {
					numberOfComments++;
					if (line.contains("*/")) {
						if (line.contains("/*") && line.indexOf("*/") < line.indexOf("/*")) {
							commentBlock = true;
						} else {
							commentBlock = false;
						}
					}
				} else if (line.contains("/*")) {
					numberOfComments++;

					if (line.contains("*/") && line.indexOf("*/") > line.indexOf("/*")) {
						commentBlock = false;
					} else {
						commentBlock = true;
					}
				} else if (line.trim().startsWith("//")) {
					numberOfComments++;
				} else if (line.trim().isEmpty()) {
					numberOfWhitespace++;
				} else {
					numberOfCode++;
				}
			}
		}

		return new Stats(numberOfFiles, numberOfCode, numberOfComments, numberOfWhitespace);
	}

	public static void main(String[] args) {
		String path = "";
		if (args.length == 0) {
			Path currentRelativePath = Paths.get("");
			path = currentRelativePath.toAbsolutePath().toString();
		} else {
			path = args[0];
		}

		try {
			Stats stats = getStatistics(path);

			System.out.println("Files: " + stats.numberOfFiles);
			System.out.println("Code: " + stats.numberOfCode);
			System.out.println("Comments: " + stats.numberOfComments);
			System.out.println("Whitespace: " + stats.numberOfWhitespace);
		} catch (IOException e) {
			System.err.println("Error reading files! " + e.getMessage());
		}

	}
}