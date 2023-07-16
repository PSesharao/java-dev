package assignment1;
import java.util.Scanner;
public class TripletSum25 {
	private static Scanner input = new Scanner(System.in);
	public static int getValidatedPositiveInteger() {
		int number;
		do {
			System.out.println("Enter a positive integer :");
			while (!input.hasNextInt()) {
				String userInput = input.next();
				System.out.printf("\"%s\" is not a valid number,try again.\nEnter a positive integer :", userInput);
			}
			number = input.nextInt();
			if (number < 0)
				System.out.println("You have entered a negative number " + number + " try again.");
		} while (number < 0);
		System.out.printf("You have entered a positive number %d.\n", number);

		return number;
	}
	public static int getValidatedInteger() {
		int number;

		System.out.println("Enter an integer :");
		while (!input.hasNextInt()) {
			String userInput = input.next();
			System.out.printf("\"%s\" is not a valid number,try again.\nEnter an integer :", userInput);
		}
		number = input.nextInt();
		System.out.printf("You have entered a number %d.\n", number);
		return number;
	}
	public static void main(String[] args) {
		int arr[] ;
		System.out.println("Enter size :");
		int n= getValidatedPositiveInteger();
		arr = new int [n];
		System.out.println("Enter the elements into array :");
		for(int i=0;i<n;i++)
			arr[i] = getValidatedInteger();
		sortArray(arr);
		int tuples[][]=formTuples(arr);
		//printTuples(tuples);
		int sortedTuples[][] = sortTuples(tuples,0);
		//System.out.println();
		printTuples(sortedTuples);
	}
	private static int[][] sortTuples(int[][] tuples,int c)
	{
		int rows = tuples.length;
		for(int row1 =0;row1<rows-1;row1++)
		{
			for(int row2 =row1+1; row2<rows;row2++)
			{
				if(is_swap(tuples[row1],tuples[row2]))
				{
					int tempTuple[] = tuples[row1];
					  tuples[row1] =tuples[row2] ;
					  tuples[row2]= tempTuple;
				}
			}
		}
		return tuples;
	}
	private static boolean is_swap(int[] r1, int[] r2) {
		int col =0;
		while(col<3 && r1[col]==r2[col])
			col++;
		return r1[col]>r2[col];
	}
	private static void printTuples(int [][] tuples) {
		for(int i=0;i<tuples.length;i++) {
			System.out.print("<");
			for(int j=0;j<3;j++)
				if(j==2)
					System.out.print(tuples[i][j]);
				else 
					System.out.print(tuples[i][j] + ",");
			System.out.print(">");
			System.out.println();
	   }		
	}
	private static int[][] formTuples(int [] arr)
	{
		int tuples[][] = new int[0][3];
		for(int i=0;i<arr.length-2;i++)
		{
			if(i==0||(i>0 && arr[i]!=arr[i-1])) {
				int lo = i+1,hi =arr.length-1,sum=arr[i]; 
				while(lo<hi)
				{
					if(arr[lo]+arr[hi]==sum)
					{
						int temp[] = new int[3];
						temp[0] = arr[hi];temp[1] = arr[lo];temp[2]=sum;
						tuples = addTuple(tuples, temp);
						while (lo < hi && arr[lo] == arr[lo+1]) lo++;
	                    while (lo < hi && arr[hi] == arr[hi-1]) hi--;
	                    lo++; hi--;
					}
					else if(arr[lo] + arr[hi] > sum) lo++;
					else hi--;
				}
			}
		}
		return tuples;
	}
	private static int [][] addTuple(int tuples[][],int [] tuple)
	{
		int currLen = tuples.length;
		int temp[][] = new int[currLen+1][3];
		//copying into temp 
		for(int i=0;i<currLen;i++)
			temp[i] = tuples[i];
		// Adding last element
		temp[currLen] = tuple;
		return temp;
	}
	private static void sortArray(int array[])
	{
		int i,j,temp,num=array.length;
		   for (i = 0; i < num; i++)
		    {
		        for (j = 0; j < (num - i - 1); j++)
		        {
		            if (array[j] < array[j + 1])
		            {
		                temp = array[j];
		                array[j] = array[j + 1];
		                array[j + 1] = temp;
		            }
		        }
		    }
	 }
}
