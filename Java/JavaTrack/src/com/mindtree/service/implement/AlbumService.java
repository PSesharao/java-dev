package com.mindtree.service.implement;

import com.mindtree.entity.Album;
import com.mindtree.entity.Artist;
import com.mindtree.entity.Song;
import com.mindtree.service.AlbumServiceable;

public class AlbumService implements AlbumServiceable {

	@Override
	public int getnoOfLang(Song[] songRecord, String artistId) {
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

	@Override
	public void sortByName(Album[] albumRecord) {
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

	@Override
	public void sortByPriceRating(Album[] albumRecord) {
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

	@Override
	public Album getExpensiveAlbum(Album[] albumRecord, String artistId) {
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

	@Override
	public Song[] getAllSongsByArtist(Song[] songRecord, String artistId) {
		Song[] artistSongs = new Song[0];
		for (int i = 0; i < songRecord.length; i++) {
			for (int j = 0; j < songRecord[i].getArtistCrew().length; j++) {
				if (songRecord[i].getArtistCrew()[j].getId().compareTo(artistId) == 0)
					artistSongs = addEntry(artistSongs, songRecord[i]);
			}
		}
		return artistSongs;
	}

	@Override
	public Artist[] addEntry(Artist[] artistRecord, Artist artistEntry) {
		int currLen = artistRecord.length;
		Artist temp[] = new Artist[currLen + 1];
		for (int i = 0; i < currLen; i++)
			temp[i] = artistRecord[i];
		temp[currLen] = artistEntry;
		return temp;
	}

	@Override
	public Song[] addEntry(Song[] songRecord, Song songEntry) {
		int currLen = songRecord.length;
		Song temp[] = new Song[currLen + 1];
		for (int i = 0; i < currLen; i++)
			temp[i] = songRecord[i];
		temp[currLen] = songEntry;
		return temp;
	}

	@Override
	public Album[] addEntry(Album[] albumRecord, Album albumEntry) {
		int currLen = albumRecord.length;
		Album temp[] = new Album[currLen + 1];
		for (int i = 0; i < currLen; i++)
			temp[i] = albumRecord[i];
		temp[currLen] = albumEntry;
		return temp;
	}

	@Override
	public int getPrevRecord(Artist[] artistRecord, String id) {
		int prevHist = -1;
		for (int i = 0; i < artistRecord.length; i++) {
			if (artistRecord[i].getId().compareTo(id) == 0) {
				prevHist = i;
				break;
			}
		}
		return prevHist;
	}

	@Override
	public int getPrevRecord(Song[] songRecord, String id) {
		int prevHist = -1;
		for (int i = 0; i < songRecord.length; i++) {
			if (songRecord[i].getId().compareTo(id) == 0) {
				prevHist = i;
				break;
			}
		}
		return prevHist;
	}

	@Override
	public int getPrevRecord(Album[] albumRecord, String id) {
		int prevHist = -1;
		for (int i = 0; i < albumRecord.length; i++) {
			if (albumRecord[i].getId().compareTo(id) == 0) {
				prevHist = i;
				break;
			}
		}
		return prevHist;
	}

}
