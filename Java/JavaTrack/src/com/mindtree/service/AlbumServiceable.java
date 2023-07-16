package com.mindtree.service;

import com.mindtree.entity.Album;
import com.mindtree.entity.Artist;
import com.mindtree.entity.Song;

public interface AlbumServiceable {
	int getnoOfLang(Song[] songRecord, String artistId);
	void sortByName(Album[] albumRecord);
	void sortByPriceRating(Album[] albumRecord);
	Album getExpensiveAlbum(Album[] albumRecord, String artistId) ;
	Song[] getAllSongsByArtist(Song[] songRecord, String artistId) ;
	Artist[] addEntry(Artist artistRecord[], Artist artistEntry);
	Song[] addEntry(Song songRecord[], Song songEntry);
	Album[] addEntry(Album albumRecord[], Album albumEntry) ;
	int getPrevRecord(Artist artistRecord[], String id);
	int getPrevRecord(Song songRecord[], String id) ;
	int getPrevRecord(Album albumRecord[], String id);
}
