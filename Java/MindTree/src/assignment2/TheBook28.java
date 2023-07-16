package assignment2;
public class TheBook28 {
	private String title ;
	private String author ;
	private float price ;
	private int year ;
	TheBook28(String title,String author,float price,int year)
	{
		this.title = title;
		this.author = author;
		this .price = price;
		this.year = year ;
	}
	private void displayBook() {
		System.out.println("The book title :"+this.title);
		System.out.println("The book author :"+this.author);
		System.out.println("The book price :$"+this.price);
		System.out.println("The book year of publication :"+this.year);
	}
	public static void main(String[] args) {
		TheBook28 book1 = new TheBook28("Robinson Crusoe", "Daniel Defoe", 15.50F, 1719);
		TheBook28 book2 = new TheBook28("Heart of Darkness", "Joseph Conrad", 12.80F, 1902);
		TheBook28 book3 = new TheBook28("Beach Music", "Pat Conroy", 9.50F, 1996);
		book1.displayBook();
		book2.displayBook();
		book3.displayBook();
	}
}
