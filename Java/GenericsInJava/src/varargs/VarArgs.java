package varargs;

public class VarArgs {
	public static void main(String[] args) {
		System.out.println(add(1,2,3,4,5,6));
		
		//System.out.println(addArray({1,2}));
	}
	
	private static int add(int...a)
	{
		int sum=0;
		for(int i:a)
			sum+= i;
		return sum;
	}
	
	private static int addArray(int [] a)
	{
		int sum=0;
		for(int i:a)
			sum+= i;
		return sum;
	}
}
