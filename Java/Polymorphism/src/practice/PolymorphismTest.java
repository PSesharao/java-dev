package practice;

import java.io.IOException;
import java.sql.SQLException;

class Parent
{
	void show() throws Exception
	{
		System.out.println("I'm Parent");
	}
	void parentMethod()
	{
		System.out.println("I'm parent method");
	}
}

class Child extends Parent
{
    void show() /* throws IOException */
	{
		System.out.println("I'm Child");
	}
	
	void childMethod()
	{
		System.out.println("I'm child method");
	}
	
}

public class PolymorphismTest {
	public static void main(String[] args) throws Exception {
		/*
		 * Parent parent = new Parent(); parent.show(); parent.parentMethod();
		 * 
		 * Child child = new Child(); child.childMethod(); child.parentMethod();
		 * child.show();
		 */
		
		Parent parent1 = new Child();
		parent1.show();
		parent1.parentMethod();
		//parent1.childMethod();
	}
}
