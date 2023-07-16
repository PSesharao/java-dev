package client;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;

import entity.Car;

public class SerApp {
	private static Scanner input = new Scanner(System.in);
	private static final String PATH = "C:\\Users\\RR COMPUTERS\\Desktop\\carObj.ser";

	public static void main(String[] args) {
		
		File file = new File(PATH);
		//serializeObject(file);
		deserializeObject(file);
	}

	private static Car getCarDetails() {
		System.out.println("Enter the car Id :");
		int id = input.nextInt();
		System.out.println("Enter car name :");
		String name = input.next();
		System.out.println("Enter car price");
		double price = input.nextDouble();
		System.out.println("Enter car color");
		String color = input.next();
		return new Car(id, name, price, color);
	}

	private static String serializeObject(File file) {
		Car car = getCarDetails();
		try {
			FileOutputStream fos = new FileOutputStream(file);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(car);
			oos.close();
			System.out.println("Before serialization :");
			System.out.println(car);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "The object is serialized into file";
	}

	private static String deserializeObject(File file) {
		Car deserCar;
		try {
			FileInputStream fis = new FileInputStream(file);
			ObjectInputStream ois = new ObjectInputStream(fis);
			deserCar = (Car) ois.readObject();
			ois.close();
			System.out.println("After deserialization :");
			System.out.println(deserCar);
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return "The file is deserialized into the Object";
	}
}
