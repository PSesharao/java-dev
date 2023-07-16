package testclass;

public class MyStack {
	private static final int MAX_SIZE = 1000;

	private int stack[] = new int[MAX_SIZE];

	private int topOfStack = -1;

	public int getTopOfStack() {
		return topOfStack;
	}

	public void setTopOfStack(int topOfStack) {
		this.topOfStack = topOfStack;
	}

	public int[] getStack() {
		return stack;
	}

	public void setStack(int[] stack) {
		this.stack = stack;
	}

	public void push(int input) {
		if (!isFull()) {
			topOfStack++;
			stack[topOfStack] = input;
		}
	}

	public void pop() {
		topOfStack--;
	}

	public int peek() {
		return stack[topOfStack];
	}

	public boolean isEmpty() {
		return !(topOfStack >= 0);
	}

	public boolean isFull() {
		return topOfStack == MAX_SIZE - 1;
	}
	
	public void displayStack()
	{
		for(int i=topOfStack;i>=0;i--)
			System.out.println(stack[i]+" ");
	}
}
