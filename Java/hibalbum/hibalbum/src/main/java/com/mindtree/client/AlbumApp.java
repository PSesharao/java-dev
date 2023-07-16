package com.mindtree.client;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import com.mindtree.entity.Album;
import com.mindtree.entity.Artist;
import com.mindtree.entity.Song;
import com.mindtree.exception.serviceexception.AlbumServiceException;
import com.mindtree.service.AlbumService;
import com.mindtree.service.impl.AlbumServiceImpl;

public class AlbumApp {
	private static Scanner input = new Scanner(System.in);
	private static AlbumService albSer = new AlbumServiceImpl();

	public static void main(String[] args) {
		int choice;
		List<Album> albumList = new ArrayList<>();
		AlbumApp app = new AlbumApp();
		do {
			choice = app.createMenu();
			switch (choice) {
			case 1:
				app.enterNewAlbum(albumList);
				break;
			case 2:
				System.out.println("Enter artist id :");
				String artistId1 = app.getValidatedInput("id");
				List<Song> songList = null;
				try {
					songList = albSer.getAllSongsByArtist(artistId1);
				} catch (AlbumServiceException e) {
					e.printStackTrace();
				} catch (Exception e) {
					e.printStackTrace();
				}
				if (songList == null)
					System.out.println("The song list is empty.");
				else
					app.dispalySongs(songList);
				break;
			case 3:
				System.out.println("Enter artist id :");
				String artistId2 = app.getValidatedInput("id");
				List<Album> albumList1 = null;
				try {
					albumList1 = albSer.getMostExpensiveAlbumByArtist(artistId2);
				} catch (AlbumServiceException e) {
					e.printStackTrace();
				} catch (Exception e) {
					e.printStackTrace();
				}
				if (albumList1 == null)
					System.out.println("The album entity is empty");
				else
					app.displayAlbum(albumList1);
				break;

			case 4:
				System.out.println("Enter artist id :");
				String artistId3 = app.getValidatedInput("id");
				int noOfLang = 0;
				try {
					noOfLang = albSer.getNoOfLangByArtist(artistId3);
				} catch (AlbumServiceException e) {
					e.printStackTrace();
				} catch (Exception e) {
					e.printStackTrace();
				}
				System.out.println(noOfLang);
				break;
			case 5:
				List<Album> albumList2 = null;
				try {
					albumList2 = albSer.sortAlbumsByPriceAndRating();
				} catch (AlbumServiceException e) {
					e.printStackTrace();
				} catch (Exception e) {
					e.printStackTrace();
				}
				if (albumList2 == null)
					System.out.println("The album entity is empty");
				else
					app.displayAlbum(albumList2);
				break;
			case 6:
				List<Album> albumList3 = null;
				try {
					albumList3 = albSer.sortAlbumsByPriceAndRating();
				} catch (AlbumServiceException e) {
					e.printStackTrace();
				} catch (Exception e) {
					e.printStackTrace();
				}
				if (albumList3 == null)
					System.out.println("The album entity is empty");
				else
					app.displayAlbum(albumList3);
				break;
			case 7:
				System.out.println("Exiting!");
				break;
			default:
				System.out.println("Wrong choice,Try again");
			}
		} while (choice != 7);

	}

	private void enterNewAlbum(List<Album> albumList) {
		boolean insertToAlbum = false;
		boolean insertToSong = false;
		boolean insertToArtist = false;
		Album album = null;
		Song song = null;
		Artist artist = null;
		album = getAlbumDetails();
		try {
			insertToAlbum = albSer.insertIntoAlbumDB(album);
		} catch (AlbumServiceException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (insertToAlbum) {
			System.out.println("Album got inserted ");
			album.setSongList(new ArrayList<>());
			System.out.println("Enter no of songs :");
			int noOfSongs = input.nextInt();
			for (int i = 0; i < noOfSongs; i++) {
				System.out.println("Enter song " + (i + 1) + " details ");
				song = getSongDetails();
				song.setAlbum(album);
				try {
					insertToSong = albSer.insertIntoSongDB(song);
				} catch (AlbumServiceException e) {
					e.printStackTrace();
				} catch (Exception e) {
					e.printStackTrace();
				}
				if (insertToSong) {
					System.out.println("Song data" + (i + 1) + " got inserted");
					album.getSongList().add(song);
					song.setArtistList(new ArrayList<>());
					System.out.println("Enter number of artists :");
					int noOfArt = input.nextInt();
					for (int j = 0; j < noOfArt; j++) {
						System.out.println("Enter artist " + (j + 1) + " details ");
						artist = getArtistDetails();
						artist.setSong(song);
						try {
							insertToArtist = albSer.insertIntoArtistDB(artist);
						} catch (AlbumServiceException e) {
							e.printStackTrace();
						} catch (Exception e) {
							e.printStackTrace();
						}
						if (insertToArtist) {
							System.out.println(
									"The artist details " + (j + 1) + " for song " + (i + 1) + " got inserted.");
							song.getArtistList().add(artist);
						} else
							System.out.println(
									"The artist details " + (j + 1) + " for song " + (i + 1) + "did not get inserted.");
					}

				} else
					System.out.println("Song data" + (i + 1) + " did not get inserted");
			}
			albumList.add(album);
		} else
			System.out.println("Album did not get inserted");
	}

	private void displayAlbum(List<Album> albumList1) {
		for (int i = 0; i < 45; i++)
			System.out.print("-");
		System.out.println();
		System.out.printf("|%10s|%10s|%10s|%10s|\n", "Id", "Name", "Price", "Rating");
		albumList1.forEach(album -> {
			for (int i = 0; i < 45; i++)
				System.out.printf("-");
			System.out.println();
			System.out.printf("|%10s|%10s|%10s|%10s|\n", album.getId(), album.getName(), album.getPrice(), album.getRating());
		});
		for (int i = 0; i < 45; i++)
			System.out.print("-");
		System.out.println();

	}

	private void dispalySongs(List<Song> songList) {
		for (int i = 0; i < 45; i++)
			System.out.print("-");
		System.out.println();
		System.out.printf("|%10s|%10s|%10s|%10s|\n", "Id", "Name", "Likes", "Language");
		songList.forEach(song -> {
			for (int i = 0; i < 45; i++)
				System.out.printf("-");
			System.out.println();
			System.out.printf("|%10s|%10s|%10s|%10s|\n", song.getId(), song.getName(), song.getLikes(), song.getLanguage());
		});
		for (int i = 0; i < 45; i++)
			System.out.print("-");
		System.out.println();
	}

	private int createMenu() {
		int choice;
		System.out.println("Enter your choice:");
		System.out.println("1. Create Album");
		System.out.println("2. Get all songs sang by an given artist");
		System.out.println("3. Get most expensive album in which a given artist have worked");
		System.out.println("4. Find in how many languages an artist has worked on");
		System.out.println("5. Sort albums by price and the rating");
		System.out.println("6. Sort albums by name");
		System.out.println("7. Exit");
		choice = getValidatedInteger("Integer");
		return choice;
	}

	private int getValidatedInteger(String validationType) {
		int number;
		boolean isValid;
		switch (validationType) {
		case "Integer":
			// System.out.println("Enter an integer :");
			while (!input.hasNextInt()) {
				String userInput = input.next();
				System.out.printf("\"%s\" is not a valid number,try again.\nEnter an integer :", userInput);
			}
			number = input.nextInt();
			return number;
		case "age":
			do {
				isValid = true;
				// System.out.println("Enter artist age :");
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
				// System.out.println("Enter size :");
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
				// System.out.println("Enter the price :");
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
				// System.out.println("Enter no of likes so far :");
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
				// System.out.println("Enter the rating for album from 0 to
				// 5:");
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
				// System.out.println("Enter name in alphastring :");
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
				// System.out.println("Enter your gender:");
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
				// System.out.println("Enter language:");
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
				// System.out.println("Enter the id:");
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
		System.out.println("Enter artist id :");
		String id = getValidatedInput("id");
		System.out.println("Enter artist name :");
		String name = getValidatedInput("name");
		System.out.println("Enter artist gender :");
		String gender = getValidatedInput("gender");
		System.out.println("Enter artist age :");
		int age = getValidatedInteger("age");
		return new Artist(id, name, gender, age);
	}

	private Song getSongDetails() {
		System.out.println("Enter song Id :");
		String id = getValidatedInput("id");
		System.out.println("Enter song name :");
		String name = getValidatedInput("name");
		System.out.println("Enter no of likes so far for song :");
		int likes = getValidatedInteger("likes");
		System.out.println("Enter the language of the song :");
		String language = getValidatedInput("language");
		return new Song(id, name, likes, language);
	}

	private Album getAlbumDetails() {
		System.out.println("Enter album Id :");
		String id = getValidatedInput("id");
		System.out.println("Enter album name :");
		String name = getValidatedInput("name");
		System.out.println("Enter album price :");
		int price = getValidatedInteger("price");
		System.out.println("Enter the rating for album from 0 to 5:");
		float rating = (float) getValidatedDouble("rating");
		return new Album(id, name, price, rating);
	}

}
