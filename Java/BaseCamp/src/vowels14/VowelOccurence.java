package vowels14;

public class VowelOccurence {
	private String inputString;
	public String getInputString() {
		return inputString;
	}

	public void setInputString(String inputString) {
		this.inputString = inputString;
	}
	public VowelOccurence(String inputString) {
		this.inputString = inputString;
	}
	public void vowelOccurence()
	{
		int countOfa = 0;
		int countOfA = 0;
		int countOfe = 0;
		int countOfE = 0;
		int countOfi = 0;
		int countOfI = 0;
		int countOfo = 0;
		int countOfO = 0;
		int countOfu = 0;
		int countOfU = 0;
		char ch;
		for(int i=0;i<inputString.length();i++)
		{
			ch=inputString.charAt(i);
			if(ch=='A')
			    countOfA++;
			else if(ch=='a')
				countOfa++;
			else if(ch=='E')
				countOfE++;
			else if(ch=='e')
				countOfe++;
			else if(ch=='i')
				countOfi++;
			else if(ch=='I')
				countOfI++;
			else if(ch=='o')
				countOfo++;
			else if(ch=='O')
				countOfO++;
			else if(ch=='u')
				countOfu++;
			else if(ch=='U')
				countOfU++;
	  }
		System.out.println("a->"+countOfa);
		System.out.println("A->"+countOfA);
		System.out.println("e->"+countOfe);
		System.out.println("E->"+countOfE);
		System.out.println("I->"+countOfI);
		System.out.println("i->"+countOfi);
		System.out.println("O->"+countOfO);
		System.out.println("o->"+countOfo);
		System.out.println("U->"+countOfU);
		System.out.println("u->"+countOfu);
	}
}
