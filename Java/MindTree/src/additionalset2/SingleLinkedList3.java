package additionalset2;
public class SingleLinkedList3 {
	public String bookName;
	public int millionsSold;
	public SingleLinkedList3 next;
	public SingleLinkedList3(String bookName,int millionsSold)
	{
		this.bookName=bookName;
		this.millionsSold=millionsSold;
	}
	public void displayBook()
	{
		System.out.println(bookName+": "+millionsSold+",000,000");
	}
	public String toString()
	{
		return bookName;
	}
	public static void main(String[] args) {
		Linked_List theList= new Linked_List();
		theList.insertFirstLink("The Bible", 1000);
		theList.insertFirstLink("Atlas Shrugged", 700);
		theList.insertFirstLink("Don Quixote", 500);
		theList.insertFirstLink("God Father", 300);
		theList.insertFirstLink("Harry Potter", 200);
		theList.displayList();
		theList.removeFirstLink();
		theList.displayList();
		
	}
}
class Linked_List
{
	public SingleLinkedList3 firstLink;
	public Linked_List()
	{
		firstLink=null;
	}
	public boolean isEmpty()
	{
		return (firstLink==null );
	}
	public void insertFirstLink(String bookName,int millionsSold)
	{
		SingleLinkedList3 newLink = new SingleLinkedList3(bookName, millionsSold);
		newLink.next = firstLink;
		firstLink = newLink;
	}
	public SingleLinkedList3 removeFirstLink()
	{
		SingleLinkedList3 linkRef = firstLink;
		if(!isEmpty())
		{
			firstLink = firstLink.next;
		}
		else {
			System.out.println("Empty Linked List");
		}
		return linkRef;
	}
	public void displayList()
	{
		SingleLinkedList3 theLink = firstLink;
		while(theLink!=null)
		{
			theLink.displayBook();
			System.out.println("Next link : "+theLink.next);
			theLink=theLink.next;
			System.out.println();
		}
	}
	public SingleLinkedList3 findBook(String bookName) 
	{
		SingleLinkedList3 theLink = firstLink;
		if(!isEmpty())
		{
			while(theLink.bookName != bookName)
			{
				if(theLink.next == null)
					return null;
				else
					theLink = theLink.next;
			}
		}
		else
			System.out.println("Empty List");
		return theLink;
	}
	public SingleLinkedList3 removeThisBook(String bookName)
	{
		SingleLinkedList3 currentLink = firstLink;
		SingleLinkedList3 previousLink = firstLink;
		while(currentLink.bookName!= bookName)
		{
			if(currentLink.next==null)
				return null;
			else 
			{
				previousLink = currentLink;
				currentLink= currentLink.next;
			}
			if(currentLink==firstLink)
				firstLink=firstLink.next;
			else {
				previousLink.next = currentLink.next;
			}
		}
		return currentLink;
	}
}
