package datastructures;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
class PersonClass
{
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
	public PersonClass(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	@Override
	public String toString() {
		return "Person [id=" + id + ", name=" + name + "]";
	}
	
}
public class CustomSort{
	public static void main(String[] args) {
		ArrayList<PersonClass> people = new ArrayList<PersonClass>();
		people.add(new PersonClass(109,"Jack"));
		people.add(new PersonClass(101,"Kate"));
		people.add(new PersonClass(105,"John"));
		people.add(new PersonClass(110,"Hopper"));
		people.add(new PersonClass(107,"George"));
		System.out.println("---- Before Sorting ----");
		for(PersonClass p : people)
		{
			System.out.println(p);
		}
		System.out.println("---- Sorting Based on ID ----");
		Collections.sort(people,new Comparator<PersonClass>()
				{

					@Override
					public int compare(PersonClass p1, PersonClass p2) {
						if(p1.getId()>p2.getId())
						{
							return 1;
						}
						else if(p1.getId()<p2.getId())
						{
							return -1;
						}
						return 0;
					}
				
				});
		for(PersonClass p : people)
		{
			System.out.println(p);
		}
		System.out.println("---- Sorting Based on name ----");
		Collections.sort(people,new Comparator<PersonClass>()
		{

			@Override
			public int compare(PersonClass p1, PersonClass p2) {
				return p1.getName().compareTo(p2.getName());
			}
		
		});
		for(PersonClass p : people)
		{
			System.out.println(p);
		}
	}
}