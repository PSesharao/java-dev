package genericsort;
class Person implements Comparable<Person>
{
	public Person(int id, String name, double salary) {
		super();
		this.id = id;
		this.name = name;
		this.salary = salary;
	}

	private int id ;
	private String name;
	private double salary;
	
	@Override
	public int compareTo(Person person) {
		int id1 = this.getId();
		int id2 = person.getId();
		return id1-id2;
	}

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

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "Person [id=" + id + ", name=" + name + ", salary=" + salary + "]";
	}
	
}
public class GenericSort {
	
	public static <T extends Comparable<? super T>> void selectionSort(T[] arr) {
		for (int i = 0; i < arr.length - 1; ++i) {
			int minIndex = i;
			for (int j = i + 1; j < arr.length; ++j) {
				if (arr[j].compareTo(arr[minIndex]) < 0) {
					minIndex = j;
				}
			}
			T temp = arr[i];
			arr[i] = arr[minIndex];
			arr[minIndex] = temp;
		}
	}
	public static void main(String[] args) {
		Integer [] intArray = {1,7,8,2,5}; 
		//System.out.println(array);
		GenericSort.selectionSort(intArray);
		System.out.println("Sorting integer array");
		for (Integer integer : intArray) {
			System.out.println(integer);
		}
		Double [] doubleArray = {1.2,0.5,1.8,2.5};
		
		GenericSort.selectionSort(doubleArray);
		System.out.println("Sorting double array");
		//GenericSort.selectionSort(array);
		for (Double double1 : doubleArray) {
			System.out.println(double1);
		}
		
		Person [] personRecord = new Person[5];
		personRecord[0] = new Person(2, "Sesharao", 12000);
		personRecord[1] = new Person(5, "Hari", 11000);
		personRecord[2] = new Person(6, "Gopi", 15000);
		personRecord[3] = new Person(1, "Timothi", 25000);
		personRecord[4] = new Person(4, "Rohith", 45000);
		//syso
		for (Person person : personRecord) {
			System.out.println(person);
		}
		GenericSort.selectionSort(personRecord);
		System.out.println();
		for (Person person : personRecord) {
			System.out.println(person);
		}
	}

}
