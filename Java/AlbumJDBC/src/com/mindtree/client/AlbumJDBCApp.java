package com.mindtree.client;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.mindtree.entity.Album;
import com.mindtree.entity.Album_Song;
import com.mindtree.entity.Artist;
import com.mindtree.entity.Song;
import com.mindtree.entity.Song_Artist;
import com.mindtree.exception.AlbumException;
import com.mindtree.service.AlbumService;
import com.mindtree.service.impl.AlbumServiceImpl;

public class AlbumJDBCApp {
	private static Scanner input = new Scanner(System.in);
	private static AlbumService albSer = new AlbumServiceImpl();

	public static void main(String[] args) {
		AlbumJDBCApp app = new AlbumJDBCApp();
		app.driverMethod();
	}

	private void driverMethod() {
		int choice;
		do {
			choice = createMenu();
			switch (choice) {
			case 1:
				try {
					albSer.insertIntoDB(getArtistDetails());
				} catch (AlbumException e) {
					e.printStackTrace();
				}
				break;
			case 2:
				try {
					albSer.insertIntoDB(getSongDetails());
				} catch (AlbumException e) {
					e.printStackTrace();
				}
				break;
			case 3:
				try {
					albSer.insertIntoDB(getAlbumDetails());
				} catch (AlbumException e) {
					e.printStackTrace();
				}
				break;
			case 4:
				try {
					albSer.insertIntoDB(getSong_ArtistDetails());
				} catch (AlbumException e) {
					e.printStackTrace();
				}
				break;
			case 5:
				try {
					albSer.insertIntoDB(getAlbum_SongDetails());
				} catch (AlbumException e) {
					e.printStackTrace();
				}
				break;
			case 6:
				ResultSet resultTable = null;
				System.out.println("Reading artist Id");
				String artId = getValidatedInput("id");
				try {
					resultTable = albSer.getAllSongsByArtist(artId);
					while(resultTable.next())
					{
						System.out.println(resultTable.getString(1));
					}
				} catch (AlbumException e) {
					
					e.printStackTrace();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				
				break;
			case 7:
				System.out.println("Reading artist Id");
				artId = getValidatedInput("id");
				try {
					resultTable = albSer.getMostExpensiveAlbumByArtist(artId);
					while(resultTable.next())
					{
						System.out.println(resultTable.getString(1));
					}
				} catch (AlbumException e) {
					
					e.printStackTrace();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				break;
			case 8:
				System.out.println("Reading artist Id");
				artId = getValidatedInput("id");
				try {
					resultTable = albSer.getNoOfLangByArtist(artId);
					while(resultTable.next())
					{
						System.out.println(resultTable.getString(1));
					}
				} catch (AlbumException e) {
					
					e.printStackTrace();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				break;
			case 9:
				try {
					resultTable = albSer.sortAlbumsByPriceAndRating();
					while(resultTable.next())
					{
						System.out.println(resultTable.getString(1));
					}
				} catch (AlbumException e) {
					
					e.printStackTrace();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				break;
			case 10:
				try {
					resultTable = albSer.sortAlbumsByName();
					while(resultTable.next())
					{
						System.out.println(resultTable.getString(1));
					}
				} catch (AlbumException e) {
					
					e.printStackTrace();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				break;
			case 11:
				System.out.println("Exiting!");
				break;
			default:
				System.out.println("Wrong choice,Try again");
			}
		} while (choice != 11);
	}

	private int createMenu() {
		int choice;
		System.out.println("Enter your choice:");
		System.out.println("1. Enter artist details:");
		System.out.println("2. Enter song details:");
		System.out.println("3. Enter album details:");
		System.out.println("4. Enter song_artist details:");
		System.out.println("5. Enter album_song details:");
		System.out.println("6. Get all songs sang by an given artist");
		System.out.println("7. Get most expensive album in which a given artist have worked");
		System.out.println("8. Find in how many languages an artist has worked on");
		System.out.println("9. Sort albums by price and the rating");
		System.out.println("10. Sort albums by name");
		System.out.println("11. Exit");
		choice = getValidatedInteger("Integer");
		return choice;
	}

	private int getValidatedInteger(String validationType) {
		int number;
		boolean isValid;
		switch (validationType) {
		case "Integer":
			System.out.println("Enter an integer :");
			while (!input.hasNextInt()) {
				String userInput = input.next();
				System.out.printf("\"%s\" is not a valid number,try again.\nEnter an integer :", userInput);
			}
			number = input.nextInt();
			return number;
		case "age":
			do {
				isValid = true;
				System.out.println("Enter artist age :");
				number = getValidatedInteger("Integer");
				if (number < 0 || number > 150) {
					isValid = false;
					System.out.println("The age is invalid try again!!");
				}
			} while (!isValid);
			return number;
		case "no":
			do {
				isValid = true;
				System.out.println("Enter size :");
				number = getValidatedInteger("Integer");
				if (number < 0 || number > 10) {
					isValid = false;
					System.out.println("The size invalid try again!!");
				}
			} while (!isValid);
			return number;
		case "price":
			do {
				isValid = true;
				System.out.println("Enter the price :");
				number = getValidatedInteger("Integer");
				if (number < 0 || number > 5000) {
					isValid = false;
					System.out.println("The price is invalid try again!!");
				}
			} while (!isValid);
			return number;
		case "likes":
			do {
				isValid = true;
				System.out.println("Enter no of likes so far :");
				number = getValidatedInteger("Integer");
				if (number < 0) {
					isValid = false;
					System.out.println("The likes are invalid try again!!");
				}
			} while (!isValid);
			return number;
		}
		return -1;
	}

	private double getValidatedDouble(String validationType) {
		double number;
		boolean isValid;
		switch (validationType) {
		case "rating":
			do {
				isValid = true;
				System.out.println("Enter the rating for album from 0 to 5:");
				while (!input.hasNextDouble()) {
					String userInput = input.next();
					System.out.printf("\"%s\" is not a valid rating,try again.\nEnter a number :", userInput);
				}
				number = input.nextDouble();
				if (number < 0) {
					System.out.println("You have entered a negative rating " + number + " try again.");
					isValid = false;
				}
			} while (!isValid);
			return number;
		}
		return -1;
	}

	private String getValidatedInput(String validationType) {
		String inputString;
		boolean isValid;
		int inputChoice;
		switch (validationType) {
		case "name":
			do {
				isValid = true;
				System.out.println("Enter name in alphastring :");
				inputString = input.next();
				for (int i = 0; i < inputString.length(); i++)
					if (!((inputString.charAt(i) >= 'A' && inputString.charAt(i) <= 'Z')
							|| (inputString.charAt(i) >= 'a' && inputString.charAt(i) <= 'z'))) {
						System.out.println("You have not entered a alphastring!Try again!!");
						isValid = false;
						break;
					}
			} while (!isValid);
			return inputString;
		case "gender":
			do {
				isValid = true;
				System.out.println("Enter your gender:");
				System.out.println("1.Male");
				System.out.println("2.Female");
				inputChoice = getValidatedInteger("Integer");
				if (inputChoice == 1)
					inputString = "Male";
				else if (inputChoice == 2)
					inputString = "Female";
				else {
					inputString = null;
					isValid = false;
					System.out.println("Wrong choice try again!!");
				}
			} while (!isValid);
			return inputString;
		case "language":
			do {
				isValid = true;
				System.out.println("Enter language:");
				System.out.println("1.Hindi");
				System.out.println("2.Telugu");
				System.out.println("3.English");
				System.out.println("4.Tamil");
				System.out.println("5.Kannada");
				System.out.println("6.Malayalam");
				inputChoice = getValidatedInteger("Integer");
				if (inputChoice == 1)
					inputString = "Hindi";
				else if (inputChoice == 2)
					inputString = "Telugu";
				else if (inputChoice == 3)
					inputString = "English";
				else if (inputChoice == 4)
					inputString = "Tamil";
				else if (inputChoice == 5)
					inputString = "Kannada";
				else if (inputChoice == 6)
					inputString = "Malayalam";
				else {
					inputString = null;
					isValid = false;
					System.out.println("Wrong choice try again!!");
				}
			} while (!isValid);
			return inputString;
		case "id":
			do {
				isValid = true;
				System.out.println("Enter the id:");
				inputString = input.next();
				if (inputString.length() > 10) {
					System.out.println("The id should not be more than 10 character long");
					isValid = false;
				} else {
					for (int i = 0; i < inputString.length(); i++)
						if (!(inputString.charAt(i) >= '0' && inputString.charAt(i) <= '9')
								&& !(inputString.charAt(i) >= 'A' && inputString.charAt(i) <= 'Z')
								&& !(inputString.charAt(i) >= 'a' && inputString.charAt(i) <= 'z')) {
							isValid = false;
							System.out.println("id should be alphanumeric,try again");
							break;

						}
				}
			} while (!isValid);
			return inputString;
		}
		return null;
	}

	private Artist getArtistDetails() {
		String id = getValidatedInput("id");
		String name = getValidatedInput("name");
		String gender = getValidatedInput("gender");
		int age = getValidatedInteger("age");
		return new Artist(id, name, gender, age);
	}

	private Song getSongDetails() {
		String id = getValidatedInput("id");
		String name = getValidatedInput("name");
		int likes = getValidatedInteger("likes");
		String language = getValidatedInput("language");
		return new Song(id, name, likes, language);
	}

	private Album getAlbumDetails() {
		String id = getValidatedInput("id");
		String name = getValidatedInput("name");
		int price = getValidatedInteger("price");
		float rating = (float) getValidatedDouble("rating");
		return new Album(id, name, price, rating);
	}

	private Song_Artist getSong_ArtistDetails() {
		System.out.println("Reading song id");
		String songId = getValidatedInput("id");
		System.out.println("Reading artistId");
		String artistId = getValidatedInput("id");
		return new Song_Artist(songId, artistId);
	}

	private Album_Song getAlbum_SongDetails() {
		System.out.println("Reading albumId");
		String albumId = getValidatedInput("id");
		System.out.println("Reading song id");
		String songId = getValidatedInput("id");
		return new Album_Song(albumId, songId);
	}
}
