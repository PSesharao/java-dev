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

public class AlbumJDBCApp {
	private static Scanner input = new Scanner(System.in);
	private static AlbumService albSer = new AlbumServiceImpl();

	public static void main(String[] args) {
		AlbumJDBCApp app = new AlbumJDBCApp();
		app.driverMethod();
	}

	private void driverMethod() {
		List<Album> albumList = new ArrayList<>();
		int choice;
		do {
			choice = createMenu();
			switch (choice) {
			case 1:
				Album album = getAlbumDetails();
				Song song = null;
				Artist artist = null;
				boolean insertToAlbum = false;
				boolean insertToSong = false;
				boolean insertToAlbumSong = false;
				boolean insertToArtist = false;
				boolean insertToSongArtist = false;
				album.setSongList(new ArrayList<>());
				try {
					insertToAlbum = albSer.insertIntoAlbumDB(album.getId(), album.getName(), album.getPrice(),
							album.getRating());
				} catch (AlbumServiceException e) {
					e.printStackTrace();
				} catch (Exception e) {
					e.printStackTrace();
				}
				if (insertToAlbum) {
					System.out.println("Album data got inserted ");
					System.out.println("Enter no of songs :");
					int noOfSongs = input.nextInt();
					for (int i = 0; i < noOfSongs; i++) {
						System.out.println("Enter song " + (i + 1) + " details ");
						song = getSongDetails();
						try {
							insertToSong = albSer.insertIntoSongDB(song.getId(), song.getName(), song.getLikes(),
									song.getLanguage());
						} catch (AlbumServiceException e) {
							e.printStackTrace();
						} catch (Exception e) {
							e.printStackTrace();
						}
						if (insertToSong) {
							System.out.println("Song data" + (i + 1) + " got inserted");
							song.setArtistList(new ArrayList<>());
							try {
								insertToAlbumSong = albSer.insertIntoAlbumSongDB(album.getId(), song.getId());
							} catch (AlbumServiceException e) {
								e.printStackTrace();
							} catch (Exception e) {
								e.printStackTrace();
							}
							if (insertToAlbumSong)
								System.out.println("The Song data " + (i + 1) + " got inserted into AlbumSong");
							else
								System.out.println("The Song data " + (i + 1) + " did not inserted into AlbumSong");
							System.out.println("Enter number of artists :");
							int noOfArt = input.nextInt();
							for (int j = 0; j < noOfArt; j++) {
								artist = getArtistDetails();
								try {
									insertToArtist = albSer.insertIntoArtistDB(artist.getId(), artist.getName(),
											artist.getGender(), artist.getAge());
								} catch (AlbumServiceException e) {

									e.printStackTrace();
								} catch (Exception e) {
									e.printStackTrace();
								}
								if (insertToArtist) {
									System.out.println(
											"The artist details " + (j + 1) + "for song " + (i + 1) + " got inserted.");
									try {
										insertToSongArtist = albSer.insertIntoSongArtistDB(song.getId(),
												artist.getId());
									} catch (AlbumServiceException e) {
										e.printStackTrace();
									} catch (Exception e) {
										e.printStackTrace();
									}
									if (insertToSongArtist)
										System.out
												.println("The artist details " + (j + 1) + "inserted into SongArtist");
									else
										System.out.println(
												"The artist details " + (j + 1) + "not inserted into SongArtist");
									song.getArtistList().add(artist);
								} else
									System.out.println("The artist details " + (j + 1) + "for song " + (i + 1)
											+ " did not inserted.");
							}
						} else
							System.out.println("Song data " + (i + 1) + " not inserted ");
					}
					album.getSongList().add(song);
					albumList.add(album);
				} else {
					System.out.println("Album is not inserted into DB ");
				}
				break;
			case 2:
				System.out.println("Enter artist id :");
				String artistId1 = getValidatedInput("id");
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
					dispalySongs(songList);
				break;
			case 3:
				System.out.println("Enter artist id :");
				String artistId2 = getValidatedInput("id");
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
					displayAlbum(albumList1);
				break;
			case 4:
				System.out.println("Enter artist id :");
				String artistId3 = getValidatedInput("id");
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
					displayAlbum(albumList2);
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
					displayAlbum(albumList3);
				break;
			case 7:
				System.out.println("Exiting!");
				break;
			default:
				System.out.println("Wrong choice,Try again");
			}
		} while (choice != 7);
	}

	private void displayAlbum(List<Album> albumList1) {
		System.out.println("Album Name");
		albumList1.forEach(album -> System.out.println(album.getName()));

	}

	private void dispalySongs(List<Song> songList) {
		System.out.println("Song Name");
		songList.forEach(song -> System.out.println(song.getName()));
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
		String language = getValidatedInput("language");
		System.out.println("Enter the language of the song :");
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
