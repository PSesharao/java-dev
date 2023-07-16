package uniquecharacters10;

public class UniqueChars {
	private String inputString;

	public String getInputString() {
		return inputString;
	}

	public void setInputString(String inputString) {
		this.inputString = inputString;
	}

	public UniqueChars(String inputString) {
		this.inputString = inputString;
	}
	
	public boolean isUnique() {
		int MAX_SIZE = 300;
		
		boolean lookUpChars[] = new boolean[MAX_SIZE];
		
		for(int i=0;i<inputString.length();i++)
		{
			int lookUpIndex = (int)inputString.charAt(i);
			if(lookUpChars[lookUpIndex]==true)
				return false;
			else 
				lookUpChars[lookUpIndex]=true;
		}
		return true;
	}
}
