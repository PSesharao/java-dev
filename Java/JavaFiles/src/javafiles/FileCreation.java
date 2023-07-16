package javafiles;

import java.io.File;
import java.io.IOException;

public class FileCreation {
	private static final String PATH = "C:\\Users\\RR COMPUTERS\\Desktop\\sample.txt";

	public static void main(String[] args) {
		File file = new File(PATH);
		try {
			if (file.createNewFile())
				System.out.println("File Created :" + file.getName());
			else
				System.out.println("File already Exists");
		} catch (IOException e) {
			System.out.println("Error Occured while File Creation");
			e.printStackTrace();
		}
	}
}
