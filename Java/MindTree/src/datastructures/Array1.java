package datastructures;
public class Array1 {
	private int array[] = new int[50];
	private int len = 10;
	public void generateArray()
	{
		for(int i=0;i<len;i++)
		{
			array[i] = (int) (Math.random()*10)+10;
		}
	}
	public void printArray()
	{
		System.out.println("-----------");
		for(int i=0;i<len;i++)
		{
			System.out.print("| "+i+"  |");
			System.out.println(" "+array[i]+" |");
			System.out.println("-----------");
		}
	}
	public static void main(String[] args) {
		 Array1 theArray = new Array1();
		 theArray.generateArray();
		 theArray.printArray();
		 theArray.deleteIndex(3);
		 theArray.printArray();
		 theArray.insertAtIndex(3, 45);
		 theArray.printArray();
	}
	public int getValueAtIndex(int index)
	{
		if(index<len) return array[index];
		return -1;
	}
	public boolean doesArrayContainThisValue(int key)
	{
		boolean flag = false;
		for(int i=0; i <len; i++)
			if(array[i]==key)
				flag= true;
		return flag;
	}
	public void deleteIndex(int index)
	{
		for(int i=index;i<len-1;i++)
			array[i]=array[i+1];
		len--;
	}
	public void insertAtIndex(int index,int value)
	{
		for(int i=len;i>index;i--)
			array[i]=array[i-1];
		array[index]=value;
		len++;
	}
}

