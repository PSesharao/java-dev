package javafiles;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileReading {
	private static final String PATH = "C:\\Users\\RR COMPUTERS\\Desktop\\sample.txt";
	public static void main(String[] args) {
		File file = new File(PATH);
		Scanner readFile = null;
		try {
			readFile = new Scanner(file);
			while(readFile.hasNextLine())
			{
				String line = readFile.nextLine();
				System.out.println(line);
			}
		} catch (FileNotFoundException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}finally
		{
			readFile.close();
		}
	}
}
