package circularstring3;

public class CircularString {
	private String firstString;
	private String secondString;
	
	public CircularString(String firstString, String secondString) {
		this.firstString = firstString;
		this.secondString = secondString;
	}
	
	public String getFirstString() {
		return firstString;
	}
	
	public void setFirstString(String firstString) {
		this.firstString = firstString;
	}
	
	public String getSecondString() {
		return secondString;
	}
	
	public void setSecondString(String secondString) {
		this.secondString = secondString;
	}
	
	public boolean circularityCheck()
	{
		return (firstString.length()==secondString.length())&&
				((firstString+firstString).indexOf(secondString)!=-1);
	}
	
}
