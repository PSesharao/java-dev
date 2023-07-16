package datastructures.maps;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

class Employee implements Comparable<Employee> {
	private int id;
	private String name;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + "]";
	}

	public Employee(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	/*
	 * @Override public int hashCode() { final int prime = 31; int result = 1;
	 * result = prime * result + id; result = prime * result + ((name == null) ? 0 :
	 * name.hashCode()); return result; }
	 * 
	 * @Override public boolean equals(Object obj) { if (this == obj) return true;
	 * if (obj == null) return false; if (getClass() != obj.getClass()) return
	 * false; Employee other = (Employee) obj; if (id != other.id) return false; if
	 * (name == null) { if (other.name != null) return false; } else if
	 * (!name.equals(other.name)) return false; return true; }
	 */

	@Override
	public int compareTo(Employee employee) {
		int id1 = this.getId();
		int id2 = employee.getId();
		return id2 - id1;
	}

}

public class HashMapDemo {
	public static void main(String[] args) {
		Map<Employee, String> employeeMap = new TreeMap<>();

		/*
		 * //employeeMap.put(1, new Employee(101, "Sesharao")); //employeeMap.put(2, new
		 * Employee(101, "Sesharao"));
		 * 
		 * employeeMap.put( new Employee(101, "Sesharao"), "Java Developer");
		 * employeeMap.put( new Employee(101, "Sesharao"), "Full Stack Developer");
		 */

		// employeeMap.put(1, new Employee(101, "Suresh"));
		/*
		 * employeeMap.put(3, new Employee(101, "Sesharao"));
		 * 
		 * employeeMap.put(6, new Employee(102, "Ramesh"));
		 * 
		 * employeeMap.put(2, new Employee(103, "Ravi"));
		 */

		employeeMap.put(new Employee(102, "Sesharao"), "Analyst");

		employeeMap.put(new Employee(101, "Suresh"), "Programmer");

		employeeMap.put(new Employee(103, "Sesharao"), "Tester");
		
		//employeeMap.put(new Employee(103, "Ramesh"), "Tester1");

		for (Employee key : employeeMap.keySet()) {
			System.out.println(key + " : " + employeeMap.get(key));
		}
	}
}
