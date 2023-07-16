package sortingnames;

public class ApplicationSort {

	public static void main(String[] args) {
		String name[] = { "Ankita Roy", "Bhaskar Bist", "Souvik Mukherjee", "Mohanapriya G", "Vikas Kumar",
				"Kushal Mukerjee", "Sesharao Paritala", "Priyanka Sabat", "Anshul Chaudary",
				"Karthikeyan Shanmughasundaran" };
		int noOfNames = name.length;
		SortNames theNames[] = new SortNames[noOfNames];
		SortNames callObject = new SortNames();
		for (int i = 0; i < noOfNames; i++) {
			String[] splittedNames = callObject.splitNames(name[i]);
			theNames[i] = new SortNames(splittedNames[0], splittedNames[1]);
		}
		callObject.insertionSortStringArray(theNames);
		callObject.printTable(theNames);
	}
}
