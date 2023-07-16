package datastructures.maps;

import java.util.HashMap;

public class MapEx1 {
	public static void main(String[] args) {
		HashMap<Integer,String> map = new HashMap<Integer,String>();
		map.put(1,"One");
		map.put(2,"Two");
		map.put(3,"Three");
		map.put(4,"Four");
		map.put(5,"Five"); 
		map.put(4,"four");
		System.out.println(map.get(4));
		// Doesn't maintain anyorder
		for(HashMap.Entry<Integer, String> entry :map.entrySet() )
		{
			int key = entry.getKey();
			String value = entry.getValue();
			System.out.println(key + " : " + value);
		}
	}
}
