package wordcount2;

public class WordCount {
	private String inputString;
	
	public String getInputString() {
		return inputString;
	}

	public void setInputString(String inputString) {
		this.inputString = inputString;
	}

	public WordCount(String inputString) {
		this.inputString = inputString;
	}
	
	public void cleanSpaces() {
		String cleanSentence="";
		int n = inputString.length();
	    int  j = 0; 
	    while (j < n) {
	      while (j < n && inputString.charAt(j)== ' ') j++;             // skip leading spaces
	      while (j < n && inputString.charAt(j) != ' ')  {cleanSentence+=inputString.charAt(j);j++;} // keep non spaces 
	      while (j < n && inputString.charAt(j) == ' ') j++;               // skip spaces
	      if (j < n) {cleanSentence+=" ";}  // keep only one space
         }
	    inputString = cleanSentence;
	}
	public String[] getWordsFromString(String inputString) {
		String word = "";
		String[] wordArray = new String[0];
		for (int index = 0; index < inputString.length(); index++) {
			if (inputString.charAt(index) == ' ' || (index == inputString.length() - 1)) {
				if (index == inputString.length() - 1) {
					word  += inputString.charAt(index);
				     wordArray=addWord(wordArray,word );
				} else {
					wordArray=addWord(wordArray,word );
					word  = "";
				}
			} else
				word  += inputString.charAt(index);
		}
		return wordArray;
	}
	
	public String[] addWord(String wordArray[],String word)
	{
		int currLen = wordArray.length;
		String temp[] = new String[currLen+1];
		for(int i=0;i<currLen;i++)
			temp[i] = wordArray[i];
		temp[currLen] = word;
		return temp;
	}
	
	public int noOfVowels(String inputString)
	{
		int vowelCount = 0;
		char ch;
		for(int i=0;i<inputString.length();i++)
		{
			ch=inputString.charAt(i);
			if(ch=='A'||ch=='a'||ch=='E'||ch=='e'||ch=='i'||ch=='I'||ch=='o'||ch=='O'||ch=='u'||ch=='U')
				vowelCount++;
		}
		return vowelCount;
	}

}
