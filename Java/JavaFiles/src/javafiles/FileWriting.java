package javafiles;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class FileWriting {
	private static final String PATH = "C:\\Users\\RR COMPUTERS\\Desktop\\sample.txt";

	public static void main(String[] args) {
		FileWriter writeFile = null;
		PrintWriter printWriter = null;
		try {

			writeFile = new FileWriter(PATH);
			printWriter = new PrintWriter(writeFile);
			// writeFile.write("Hello World\nHow are you doing today\nWelcome to
			// possible.");
			// writeFile.
			printWriter.print("Hello World\nHow are you doing today\nWelcome to possible.");
			System.out.println("Successfully wrote to the file ");
		} catch (IOException e) {
			System.out.println("An error occurred while writing to file ");
			e.printStackTrace();
		} finally {
			printWriter.close();
			try {
				writeFile.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
