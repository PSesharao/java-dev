package collectiongenerics;

import java.util.ArrayList;
import java.util.List;

public class CollectionGenerics {

	public static void main(String[] args) {
		List listGeneric = new ArrayList();
		listGeneric.add("Gui");
		listGeneric.add(10);
		listGeneric.add(true);

		System.out.println(listGeneric);
		List<String> listStr = new ArrayList<>();
		listStr.add("One");
		listStr.add("Two");
		// Compilation Error
		//listStr.add(3);
		
		System.out.println(listStr);
	}

}
