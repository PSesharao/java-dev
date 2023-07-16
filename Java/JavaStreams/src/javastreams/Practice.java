package javastreams;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class SortEmployee implements Comparator<Employee> {

	@Override
	public int compare(Employee o1, Employee o2) {

		return o1.getId() - o2.getId();
	}

}

public class Practice {
	public static void main(String[] args) {

		List<Employee> empList = new ArrayList<>();
		empList.add(new Employee(101, "Sesharao", 10000));
		empList.add(new Employee(103, "Ramesh", 5000));
		empList.add(new Employee(102, "Giri", 8000));

		empList.forEach(System.out::println);
		System.out.println();
		empList.forEach(empl -> System.out.println(empl));
		System.out.println();

		empList.sort(new SortEmployee());
		empList.forEach(System.out::println);

		empList.stream().filter(emp -> emp.getId() == 101).forEach(System.out::println);

		empList.stream().filter(emp -> emp.getId() == 102).map(emp -> {
			String str = emp.getName().substring(0, 1).toLowerCase()+emp.getName().substring(1);
			emp.setName(str);
			return emp;
		}).forEach(System.out::println);

		empList.sort((Employee o1, Employee o2) -> {
			return o1.getName().compareTo(o2.getName());
		});

		empList.sort((Employee o1, Employee o2) -> o1.getName().compareTo(o2.getName()));

		System.out.println(empList);

		Map<Integer, String> map = new HashMap<>();
		map.put(1, "Sesharao");
		map.put(2, "Ravi");
		map.put(3, "Giri");
		map.put(4, "Ramesh");
		map.forEach((k, v) -> System.out.println(k + ":" + v));

		map.entrySet().stream().forEach(mapE -> System.out.println(mapE.getKey() + ":" + mapE.getValue()));

		map.entrySet().stream().sorted(Map.Entry.comparingByKey(Comparator.reverseOrder()))
				.forEach(System.out::println);

		map.entrySet().stream().sorted(Map.Entry.comparingByValue()).forEach(System.out::println);

		Map<Employee, String> empMap = new HashMap<>();

		empMap.put(new Employee(101, "Sesharao", 10000), "One");
		empMap.put(new Employee(103, "Ramesh", 5000), "Two");
		empMap.put(new Employee(102, "Giri", 8000), "Three");

		empMap.entrySet().stream()
				.sorted(Map.Entry.comparingByKey((Employee o1, Employee o2) -> o1.getName().compareTo(o2.getName())))
				.forEach(System.out::println);
		
		//int sum = map.entrySet().stream().map(m -> m.getKey().intValue()).reduce(0,(m1,m2)-> m1+m2);
		
		String append = empMap.entrySet().stream().map(m -> m.getKey().getName()).reduce("",(m1,m2)-> m1+"-"+m2);
		System.out.println(append);
		//System.out.println(sum);
	}
}
