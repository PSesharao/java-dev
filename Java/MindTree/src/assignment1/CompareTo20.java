package assignment1;

public class CompareTo20 {
	private char value[] ;
	public CompareTo20(char value[]) {
		this.value = value;
	}
	public static void main(String[] args) {
		char [] value1 = {'c','a','t'};
		char [] value2 = {'c','a','r'};
		CompareTo20 str1 = new CompareTo20(value1);
		CompareTo20 str2 = new CompareTo20(value2);
		System.out.println(str1.compareTo(str2));
	}
	public int compareTo(CompareTo20 anotherString)
	{
		int len1 = value.length;
		int len2 = anotherString.value.length;
		int lim = Math.min(len1, len2);
		char v1[] = value;
		char v2[] = anotherString.value;
		int k=0;
		while(k<lim)
		{
			char c1 = v1[k];
			char c2 = v2[k];
			if(c1!=c2)
				return c1-c2;
			k++;
		}
		return len1 - len2;
	}
}