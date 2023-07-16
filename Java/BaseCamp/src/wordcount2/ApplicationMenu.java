package wordcount2;

import java.util.Scanner;

public class ApplicationMenu {
	
	private static Scanner input = new Scanner(System.in);
	
	public static void main(String[] args) {
		String inputString;
		WordCount callingObj=null;
		int choice;
		do
		{
			choice = createMenu();
			switch(choice)
			{
			case 1:
				System.out.println("Enter a sentence :");
				input.nextLine();
				inputString = input.nextLine();
				callingObj = new WordCount(inputString);
				callingObj.cleanSpaces();
				break;
			case 2:
				if(callingObj==null)
					System.out.println("Please enter the sentence first");
				else
				{
					String wordArray[] = callingObj.getWordsFromString(callingObj.getInputString());
					System.out.println("The number of words in sentence "+"\""
					+callingObj.getInputString()+"\""+" are:"+wordArray.length);
				}
				break;
			case 3 :
				if(callingObj==null)
					System.out.println("Please enter the sentence first");
				else
				{
					System.out.println("The number of vowels in sentence "+"\""
							+callingObj.getInputString()+"\""+" are:"
							+callingObj.noOfVowels(callingObj.getInputString()));
				}
				break;
			case 4 :
				if(callingObj==null)
					System.out.println("Please enter the sentence first");
				else
				{
					String wordArray[] = callingObj.getWordsFromString(callingObj.getInputString());
					int length = wordArray.length;
					System.out.println("The words in sentence "+"\""
							+callingObj.getInputString()+"\""+" are:");
					for(int i=0;i<length;i++)
						System.out.println(wordArray[i]);
					
				}
				break;
			case 5:
				System.out.println("Exiting!");
				break;
			default :
				System.out.println("Enter the right choice:");
			}
			
		}while(choice!=5);
	}
	
	private static int createMenu() {
		int choice ;
		System.out.println("Enter your choice:");
		System.out.println("1. Input a sentence");
		System.out.println("2. Count the words in the sentence");
		System.out.println("3. Count the vowels in the sentence");
		System.out.println("4. Return wordArray from sentence");
		System.out.println("5. Exit");
		choice = getValidatedInteger();
		return choice;
	}
	
	private static int getValidatedInteger() {
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
}
