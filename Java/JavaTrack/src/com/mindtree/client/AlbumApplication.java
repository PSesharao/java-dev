package com.mindtree.client;

import java.util.Scanner;

import com.mindtree.entity.Album;
import com.mindtree.entity.Artist;
import com.mindtree.entity.Name;
import com.mindtree.entity.Song;
import com.mindtree.exception.InvalidAgeException;
import com.mindtree.exception.InvalidPriceException;
import com.mindtree.service.implement.AlbumService;

public class AlbumApplication {
	private static Scanner input = new Scanner(System.in);
	private static AlbumService appService = new AlbumService();

	public static void main(String[] args) {
		AlbumApplication appAlbum = new AlbumApplication();
		appAlbum.driverMethod();
	}

	private void driverMethod() {
		Artist artistRecord[] = new Artist[0];
		Song songRecord[] = new Song[0];
		Album albumRecord[] = new Album[0];
		int choice;
		int prevHistory;
		String artistId;
		String songId;
		String albumid;
		boolean isEntered;
		do {
			choice = createMenu();
			switch (choice) {
			case 1:
				do {
					isEntered = true;
					System.out.println("Reading artist id :");
					artistId = getValidatedInput("id");
					prevHistory = appService.getPrevRecord(artistRecord, artistId);
					if (prevHistory == -1) {
						Artist artistEntry = new Artist(artistId,
								new Name(getValidatedInput("firstName"), getValidatedInput("lastName")),
								getValidatedInput("gender"), getValidatedInteger("age"));
						artistRecord = appService.addEntry(artistRecord, artistEntry);
					} else {
						System.out.println("The artist " + (artistId) + " has been registered before!!Try again");
						isEntered = false;
					} 
				} while (!isEntered);
				break;
			case 2:
				do {
					isEntered = true;
					System.out.println("Reading song id :");
					songId = getValidatedInput("id");
					prevHistory = appService.getPrevRecord(songRecord, songId);
					if (prevHistory == -1) {
						Song songEntry = new Song();
						songEntry.setId(songId);
						songEntry.setArtistCrew(new Artist[0]);
						System.out.println("Reading no of artist for recording song :");
						int noOfCrew = getValidatedInteger("no");
						if (noOfCrew > artistRecord.length) {
							System.out.println("You dont have enough artists to add into crew");
						} else {
							boolean isValid;
							System.out.println("Reading song name :");
							songEntry.setName(getValidatedInput("name"));
							System.out.println("Reading crew details ");
							for (int i = 0; i < noOfCrew; i++) {
								do {
									isValid = true;
									System.out.println("Reading artist id of " + (i + 1) + " artist:");
									artistId = getValidatedInput("id");
									prevHistory = appService.getPrevRecord(artistRecord, artistId);
									if (prevHistory == -1) {
										isValid = false;
										System.out.println("The artist " + (artistId)
												+ " has not been registered before, Try again");
									} else {
										int prevLocalHistory = appService.getPrevRecord(songEntry.getArtistCrew(),
												artistId);
										if (prevLocalHistory == -1) {
											songEntry.setArtistCrew(appService.addEntry(songEntry.getArtistCrew(),
													artistRecord[prevHistory]));
										} else {
											System.out.println("The artist " + (artistId)
													+ " has been added to the song already, Try again");
											isValid = false;
										}
									}
								} while (!isValid);

							}
							songEntry.setLanguage(getValidatedInput("language"));
							songEntry.setLikes(getValidatedInteger("likes"));
							songRecord = appService.addEntry(songRecord, songEntry);
						}
					} else {
						System.out.println("The song " + (songId) + " has been registered before Try again");
						isEntered = false;
					} 
				} while (!isEntered);
				break;
			case 3:
				do {
					isEntered = true;
					System.out.println("Reading album id :");
					albumid = getValidatedInput("id");
					prevHistory = appService.getPrevRecord(albumRecord, albumid);
					if (prevHistory == -1) {
						Album albumEntry = new Album();
						albumEntry.setId(albumid);
						albumEntry.setSongList(new Song[0]);
						System.out.println("Reading no of songs in the album:");
						int noOfSongs = getValidatedInteger("no");
						if (noOfSongs > songRecord.length) {
							System.out.println("You dont have enough songs to add into album");
						} else {
							boolean isValid;
							System.out.println("Reading albumname :");
							albumEntry.setName(getValidatedInput("name"));
							System.out.println("Reading songs details ");
							for (int i = 0; i < noOfSongs; i++) {
								do {
									isValid = true;
									System.out.println("Reading song id of " + (i + 1) + " song:");
									songId = getValidatedInput("id");
									prevHistory = appService.getPrevRecord(songRecord, songId);
									if (prevHistory == -1) {
										isValid = false;
										System.out.println(
												"The song " + (songId) + " has not been registered before, Try again");
									} else {
										int prevLocalHistory = appService.getPrevRecord(albumEntry.getSongList(),
												songId);
										if (prevLocalHistory == -1) {
											albumEntry.setSongList(appService.addEntry(albumEntry.getSongList(),
													songRecord[prevHistory]));
										} else {
											System.out.println("The song " + (songId)
													+ " has been added already to album, Try again");
											isValid = false;
										}
									}
								} while (!isValid);

							}
							albumEntry.setPrice(getValidatedInteger("price"));
							albumEntry.setRating(getValidatedDouble("rating"));
							albumRecord = appService.addEntry(albumRecord, albumEntry);
						}
					} else {
						System.out.println("The album " + (albumid) + " has been registered before,try again");
						isEntered = false;
					} 
				} while (!isEntered);
				break;
			case 4:
				System.out.println("Reading artist id:");
				artistId = getValidatedInput("id");
				prevHistory = appService.getPrevRecord(artistRecord, artistId);
				if (prevHistory == -1) {
					System.out.println("The artist "+(artistId)+" has not been registered before");
				} else {
					Song[] artistSongs = appService.getAllSongsByArtist(songRecord, artistId);
					if (artistSongs == null) {
						System.out.println("The artist "+(artistId)+" has not sung so far");
					} else {
						for (int i = 0; i < artistSongs.length; i++) {
							displaySong(artistSongs[i]);
							System.out.println();
						}
					}
				}
				break;
			case 5:
				System.out.println("Reading artist id:");
				artistId = getValidatedInput("id");
				prevHistory = appService.getPrevRecord(artistRecord, artistId);
				if (prevHistory == -1) {
					System.out.println("The artist "+(artistId)+" has not been registered before");
				} else {
					Album expensiveAlbum = appService.getExpensiveAlbum(albumRecord, artistId);
					displayAlbum(expensiveAlbum);
				}
				break;
			case 6:
				System.out.println("Reading artist id:");
				artistId = getValidatedInput("id");
				prevHistory = appService.getPrevRecord(artistRecord, artistId);
				if (prevHistory == -1) {
					System.out.println("The artist "+(artistId)+" has not been registered before");
				} else {
					int noOfLang = appService.getnoOfLang(songRecord, artistId);
					System.out.println("Sofar the artist has worked in " + noOfLang);
				}
				break;
			case 7:
				appService.sortByPriceRating(albumRecord);
				for (int i = 0; i < albumRecord.length; i++)
				{
					displayAlbum(albumRecord[i]);
					System.out.println();
				}
				break;
			case 8:
				appService.sortByName(albumRecord);
				for (int i = 0; i < albumRecord.length; i++)
				{
					displayAlbum(albumRecord[i]);
					System.out.println();
				}
				break;
			case 9:
				System.out.println("Exiting!!");
				break;
			default :
				System.out.println("Enter right choice :");
			}
		} while (choice != 9);
	}

	private int createMenu() {
		int choice;
		System.out.println("Enter your choice:");
		System.out.println("1. Add new artist details:");
		System.out.println("2. Add new song details:");
		System.out.println("3. Add new album details:");
		System.out.println("4. Get all songs sang by an given artist");
		System.out.println("5. Get most expensive album in which a given artist have worked");
		System.out.println("6. Find in how many languages an artist has worked on");
		System.out.println("7. Sort albums by price and the rating");
		System.out.println("8. Sort albums by name");
		System.out.println("9. Exit");
		choice = getValidatedInteger("Integer");
		return choice;
	}
	
	private void displayAlbum(Album expensiveAlbum) {
		System.out.println("Album id :" + expensiveAlbum.getId());
		System.out.println("Album name :" + expensiveAlbum.getName());
		System.out.println("Album price :" + expensiveAlbum.getPrice());
		System.out.println("Album rating :" + expensiveAlbum.getRating());
	}

	private void displaySong(Song song) {
		System.out.println("song id:" + song.getId());
		System.out.println("song name:" + song.getName());
		System.out.println("No of likes for song :" + song.getLikes());
		System.out.println("lanuage of song:" + song.getLanguage());
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
				try {
					if (number < 0 || number > 150) {
						isValid = false;
						//System.out.println("The age is invalid try again!!");
						throw new InvalidAgeException("The age is invalid try again!!");
					}
				} catch (InvalidAgeException e) {
					System.out.println(e.getMessage());
					//e.printStackTrace();
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
				try {
					if (number < 0 || number > 5000) {
						isValid = false;
						throw new InvalidPriceException("The price is invalid try again!!");
						//System.out.println("The price is invalid try again!!");
					}
				} catch (InvalidPriceException e) {
					//e.printStackTrace();
					System.out.println(e.getMessage());
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
		case "firstName":
			do {
				isValid = true;
				System.out.println("Enter artist firstname in alphastring :");
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
		case "lastName":
			do {
				isValid = true;
				System.out.println("Enter artist lastname in alphastring :");
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
}
