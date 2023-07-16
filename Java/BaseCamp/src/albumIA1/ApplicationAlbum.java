package albumIA1;

import java.util.Scanner;

public class ApplicationAlbum {
	private static Scanner input = new Scanner(System.in);

	public static void main(String[] args) {
		ApplicationAlbum appAlbum = new ApplicationAlbum();
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
		do {
			choice = createMenu();
			switch (choice) {
			case 1:
				System.out.println("Reading artist id :");
				artistId = getValidatedInput("id");
				prevHistory = getPrevRecord(artistRecord, artistId);
				if (prevHistory == -1) {
					Artist artistEntry = new Artist(artistId,
							new Name(getValidatedInput("firstName"), getValidatedInput("lastName")),
							getValidatedInput("gender"), getValidatedInteger("age"));
					artistRecord = addEntry(artistRecord, artistEntry);
				} else {
					System.out.println("The artist has been registered before");
				}
				break;
			case 2:
				System.out.println("Reading song id :");
				songId = getValidatedInput("id");
				prevHistory = getPrevRecord(songRecord, songId);
				if (prevHistory == -1) {
					Song songEntry = new Song();
					songEntry.setId(songId);
					songEntry.setArtistCrew(new Artist[0]);
					System.out.println("Reading no of crewArtist for recording song :");
					int noOfCrew = getValidatedInteger("no");
					if (noOfCrew > artistRecord.length) {
						System.out.println("You dont have enough artists to add into crew");
					} else {
						boolean isValid;
						songEntry.setName(getValidatedInput("name"));
						System.out.println("Reading crew details ");
						for (int i = 0; i < noOfCrew; i++) {
							do {
								isValid = true;
								System.out.println("Reading artist id :");
								artistId = getValidatedInput("id");
								prevHistory = getPrevRecord(artistRecord, artistId);
								if (prevHistory == -1) {
									isValid = false;
									System.out.println("The artist has not been registered before, Try again");
								} else {
									int prevLocalHistory = getPrevRecord(songEntry.getArtistCrew(), artistId);
									if (prevLocalHistory == -1) {
										songEntry.setArtistCrew(
												addEntry(songEntry.getArtistCrew(), artistRecord[prevHistory]));
									} else {
										System.out.println("The artist has been registered before locally , Try again");
										isValid = false;
									}
								}
							} while (!isValid);

						}
						songEntry.setLanguage(getValidatedInput("language"));
						songEntry.setLikes(getValidatedInteger("likes"));
						songRecord = addEntry(songRecord, songEntry);
					}
				} else {
					System.out.println("The song has been registered before");
				}
				break;
			case 3:
				System.out.println("Reading album id :");
				albumid = getValidatedInput("id");
				prevHistory = getPrevRecord(albumRecord, albumid);
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
						albumEntry.setName(getValidatedInput("name"));
						System.out.println("Reading songs details ");
						for (int i = 0; i < noOfSongs; i++) {
							do {
								isValid = true;
								System.out.println("Reading artist id :");
								songId = getValidatedInput("id");
								prevHistory = getPrevRecord(songRecord, songId);
								if (prevHistory == -1) {
									isValid = false;
									System.out.println("The song has not been registered before, Try again");
								} else {
									int prevLocalHistory = getPrevRecord(albumEntry.getSongList(), songId);
									if (prevLocalHistory == -1) {
										albumEntry.setSongList(
												addEntry(albumEntry.getSongList(), songRecord[prevHistory]));
									} else {
										System.out.println("The song has been registered before locally , Try again");
										isValid = false;
									}
								}
							} while (!isValid);

						}
						albumEntry.setPrice(getValidatedInteger("price"));
						albumEntry.setRating(getValidatedDouble("rating"));
						albumRecord = addEntry(albumRecord, albumEntry);
					}
				} else {
					System.out.println("The album has been registered before");
				}
				break;
			case 4:
				System.out.println("Reading artist id:");
				artistId = getValidatedInput("id");
				prevHistory = getPrevRecord(artistRecord, artistId);
				if (prevHistory == -1) {
					System.out.println("The artist has not been registered before");
				} else {
					Song[] artistSongs = getAllSongsByArtist(songRecord, artistId);
					if (artistSongs == null) {
						System.out.println("The artist has not sung so far");
					} else {
						for (int i = 0; i < artistSongs.length; i++) {
							displaySong(artistSongs[i]);
						}
					}
				}
				break;
			case 5:
				System.out.println("Reading artist id:");
				artistId = getValidatedInput("id");
				prevHistory = getPrevRecord(artistRecord, artistId);
				if (prevHistory == -1) {
					System.out.println("The artist has not been registered before");
				} else {
					Album expensiveAlbum = getExpensiveAlbum(albumRecord, artistId);
					displayAlbum(expensiveAlbum);
				}
				break;
			case 6:
				System.out.println("Reading artist id:");
				artistId = getValidatedInput("id");
				prevHistory = getPrevRecord(artistRecord, artistId);
				if (prevHistory == -1) {
					System.out.println("The artist has not been registered before");
				} else {
					int noOfLang = getnoOfLang(songRecord, artistId);
					System.out.println("Sofar the artist has worked in" + noOfLang);
				}
				break;
			case 7:
				sortByPriceRating(albumRecord);
				for (int i = 0; i < albumRecord.length; i++)
					displayAlbum(albumRecord[i]);
				break;
			case 8:
				sortByName(albumRecord);
				for (int i = 0; i < albumRecord.length; i++)
					displayAlbum(albumRecord[i]);
				break;
			case 9:
				System.out.println("Exiting!!");
				break;
			}
		} while (choice != 9);
	}

	private int getnoOfLang(Song[] songRecord, String artistId) {
		String langArray[] = { "Hindi", "Telugu", "English", "Tamil", "Kannada", "Malayalam" };
		int totalLang = 0, currLang;
		for (int i = 0; i < langArray.length; i++) {
			currLang = 0;
			for (int j = 0; j < songRecord.length; j++) {
				if (langArray[i].compareTo(songRecord[j].getLanguage()) == 0) {
					for (int k = 0; k < songRecord[j].getArtistCrew().length; k++) {
						if (songRecord[j].getArtistCrew()[k].getId().compareTo(artistId) == 0)
							currLang++;
					}
				}
			}
			if (currLang > 0)
				totalLang++;
		}
		return totalLang;
	}

	private void sortByName(Album[] albumRecord) {
		int arraySize = albumRecord.length;
		for (int i = 1; i < arraySize; i++) {
			int j = i;
			Album toInsert = albumRecord[i];
			while ((j > 0) && (albumRecord[j - 1].getName().compareTo(toInsert.getName()) < 0)) {
				albumRecord[j] = albumRecord[j - 1];
				j--;
			}
			albumRecord[j] = toInsert;
		}
	}

	private void sortByPriceRating(Album[] albumRecord) {
		int arraySize = albumRecord.length;
		for (int i = 0; i < arraySize - 1; i++) {
			for (int j = 0; j < arraySize - 1 - i; j++) {
				if (albumRecord[j].getPrice() > albumRecord[j + 1].getPrice()) {
					Album albumTemp = albumRecord[j];
					albumRecord[j] = albumRecord[j + 1];
					albumRecord[j + 1] = albumTemp;
				} else if (albumRecord[j].getPrice() == albumRecord[j + 1].getPrice()) {
					if (albumRecord[j].getRating() > albumRecord[j + 1].getRating()) {
						Album albumTemp = albumRecord[j];
						albumRecord[j] = albumRecord[j + 1];
						albumRecord[j + 1] = albumTemp;
					}
				}
			}
		}
	}

	private void displayAlbum(Album expensiveAlbum) {
		System.out.println("Album id :" + expensiveAlbum.getId());
		System.out.println("Album name :" + expensiveAlbum.getName());
		System.out.println("Album price :" + expensiveAlbum.getPrice());
		System.out.println("Album rating :" + expensiveAlbum.getRating());
	}

	private Album getExpensiveAlbum(Album[] albumRecord, String artistId) {
		int index = -1, maxCost = -1;
		for (int i = 0; i < albumRecord.length; i++) {
			for (int j = 0; j < albumRecord[i].getSongList().length; j++)
				for (int k = 0; k < albumRecord[i].getSongList()[j].getArtistCrew().length; k++) {
					if (albumRecord[i].getSongList()[j].getArtistCrew()[k].getId().compareTo(artistId) == 0) {
						if (maxCost < albumRecord[i].getPrice()) {
							index = i;
							maxCost = albumRecord[i].getPrice();
						}
					}
				}
		}
		if (index != -1)
			return albumRecord[index];
		return null;
	}

	private void displayArtist(Artist artist) {
		System.out.println("The artist name " + artist.getName().getFirstName() + " " + artist.getName().getLastName());
	}

	private void displaySong(Song song) {
		System.out.println("song id:" + song.getId());
		System.out.println("song name:" + song.getName());
		System.out.println("The crew details :");
		for (int i = 0; i < song.getArtistCrew().length; i++)
			displayArtist(song.getArtistCrew()[i]);
		System.out.println("No of likes for song :" + song.getLikes());
		System.out.println("lanuage of song:" + song.getLanguage());
	}

	private Song[] getAllSongsByArtist(Song[] songRecord, String artistId) {
		Song[] artistSongs = new Song[0];
		for (int i = 0; i < songRecord.length; i++) {
			for (int j = 0; j < songRecord[i].getArtistCrew().length; j++) {
				if (songRecord[i].getArtistCrew()[j].getId().compareTo(artistId) == 0)
					artistSongs = addEntry(artistSongs, songRecord[i]);
			}
		}
		return artistSongs;
	}

	private int createMenu() {
		int choice;
		System.out.println("Enter your choice:");
		System.out.println("1. Add new artist details:");
		System.out.println("2. Add new song details:");
		System.out.println("3. Add new album details:");
		System.out.println("4. Get All Songs sang by an given artist");
		System.out.println("5. Get most expensive album in which a given artist have worked");
		System.out.println("6. Find in how many languages an artist has worked on");
		System.out.println("7. Sort albums by price and the rating");
		System.out.println("8. Sort albums by name");
		System.out.println("9. Exit");
		choice = getValidatedInteger("Integer");
		return choice;
	}

	private Artist[] addEntry(Artist artistRecord[], Artist artistEntry) {
		int currLen = artistRecord.length;
		Artist temp[] = new Artist[currLen + 1];
		for (int i = 0; i < currLen; i++)
			temp[i] = artistRecord[i];
		temp[currLen] = artistEntry;
		return temp;
	}

	private Song[] addEntry(Song songRecord[], Song songEntry) {
		int currLen = songRecord.length;
		Song temp[] = new Song[currLen + 1];
		for (int i = 0; i < currLen; i++)
			temp[i] = songRecord[i];
		temp[currLen] = songEntry;
		return temp;
	}

	private Album[] addEntry(Album albumRecord[], Album albumEntry) {
		int currLen = albumRecord.length;
		Album temp[] = new Album[currLen + 1];
		for (int i = 0; i < currLen; i++)
			temp[i] = albumRecord[i];
		temp[currLen] = albumEntry;
		return temp;
	}

	private int getPrevRecord(Artist artistRecord[], String id) {
		int prevHist = -1;
		for (int i = 0; i < artistRecord.length; i++) {
			if (artistRecord[i].getId().compareTo(id) == 0) {
				prevHist = i;
				break;
			}
		}
		return prevHist;
	}

	private int getPrevRecord(Song songRecord[], String id) {
		int prevHist = -1;
		for (int i = 0; i < songRecord.length; i++) {
			if (songRecord[i].getId().compareTo(id) == 0) {
				prevHist = i;
				break;
			}
		}
		return prevHist;
	}

	private int getPrevRecord(Album albumRecord[], String id) {
		int prevHist = -1;
		for (int i = 0; i < albumRecord.length; i++) {
			if (albumRecord[i].getId().compareTo(id) == 0) {
				prevHist = i;
				break;
			}
		}
		return prevHist;
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
				System.out.println("Enter age :");
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
		case "firstName":
			do {
				isValid = true;
				System.out.println("Enter your firstname in alphastring :");
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
				System.out.println("Enter your lastname in alphastring :");
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
