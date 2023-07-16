package synchronization1;

public class Printer {
	/* synchronized */void printDocuments(int noOfCopies , String documentName)
	{
		for(int i=1;i<=noOfCopies;i++)
		{
			System.out.println(">> Printing "+documentName+" "+i);
		}
	}
}
