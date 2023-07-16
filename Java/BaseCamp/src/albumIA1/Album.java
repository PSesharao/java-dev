package albumIA1;

public class Album {
	private String id;
	private String name;
	private int price;
	private Song songList[];
	private double rating;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public Song[] getSongList() {
		return songList;
	}

	public void setSongList(Song[] songList) {
		this.songList = songList;
	}

	public double getRating() {
		return rating;
	}

	public void setRating(double rating) {
		this.rating = rating;
	}

	public Album(String id, String name, int price, Song[] songList, double rating) {
		this.id = id;
		this.name = name;
		this.price = price;
		this.songList = songList;
		this.rating = rating;
	}

	public Album() {

	}
}
