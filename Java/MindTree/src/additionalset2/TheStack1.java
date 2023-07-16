package additionalset2;

import java.util.Arrays;

public class TheStack1 {
	
	private String[] stackArray;
	private int stackSize;
	
	// Sets stack as empty
	
	private int topOfStack = -1;
	
	TheStack1(int size){
		
		stackSize = size;
		
		stackArray = new String[size];
		
		// Assigns the value of -1 to every value in the array
		// so I control what gets printed to screen
		
		Arrays.fill(stackArray, "-1");
		
	}

	public void push(String input){
		
		if(topOfStack+1 < stackSize){
			
			topOfStack++;
			
			stackArray[topOfStack] = input;
			
		} else System.out.println("Sorry But the Stack is Full");
		
		displayTheStack1();
		
		System.out.println("PUSH " + input + " Was Added to the Stack\n");
		
	}
	
	public String pop(){
		
		if(topOfStack >= 0){
			
			displayTheStack1();
			
			System.out.println("POP " + stackArray[topOfStack] + " Was Removed From the Stack\n");
			
			// Just like in memory an item isn't deleted, but instead is just not available
			
			stackArray[topOfStack] = "-1"; // Assigns -1 so the value won't appear
			
			return stackArray[topOfStack--];
	
			
		} else {
			
			displayTheStack1();
			
			System.out.println("Sorry But the Stack is Empty");
			
			return "-1";
		}
		
		
	}
	
	public String peek(){
		
		displayTheStack1();
		
		System.out.println("PEEK " + stackArray[topOfStack] + " Is at the Top of the Stack\n");
		
		return stackArray[topOfStack];
		
	}
	
	public void pushMany(String multipleValues){
		
		String[] tempString = multipleValues.split(" ");
		
		for(int i = 0; i < tempString.length; i++){
			
			push(tempString[i]);
			
		}
		
	}
	
	public void popAll(){
		
		for(int i = topOfStack; i >= 0; i--){
			
			pop();
			
		}
		
	}
	
	public void popDisplayAll(){
		
		String theReverse = "";
		
		for(int i = topOfStack; i >= 0; i--){
			
			theReverse += stackArray[i];
			
		}
		
		System.out.println("The Reverse: " + theReverse);
		
		popAll();
		
	}
	
	public void displayTheStack1(){
		
			for(int n = 0; n < 61; n++)System.out.print("-");
			
			System.out.println();
			
			for(int n = 0; n < stackSize; n++){
				
				System.out.format("| %2s "+ " ", n);
				
			}
			
			System.out.println("|");
			
			for(int n = 0; n < 61; n++)System.out.print("-");
			
			System.out.println();
			
			for(int n = 0; n < stackSize; n++){
				
				
				
				if(stackArray[n].equals("-1")) System.out.print("|     ");
				
				else System.out.print(String.format("| %2s "+ " ", stackArray[n]));
				
			}
			
			System.out.println("|");
			
			for(int n = 0; n < 61; n++)System.out.print("-");
			
			System.out.println();
		
	}
	
	public static void main(String[] args){
		
		TheStack1 TheStack1 = new TheStack1(10);
		
		TheStack1.push("10");
		TheStack1.push("17");
		TheStack1.push("13");
		
		// Look at the top value on the stack
		
		TheStack1.peek();
		
		// Remove values from the stack (LIFO)
		
		TheStack1.pop();
		TheStack1.pop();
		TheStack1.pop();
		
		// Add many to the stack
		
		TheStack1.pushMany("R E D R U M");
		
		// Remove all from the stack
		
		// TheStack1.popAll();
		
		// Remove all from the stack and print them
		
		TheStack1.popDisplayAll();
		
		TheStack1.displayTheStack1();
		
		
	}
	
}

