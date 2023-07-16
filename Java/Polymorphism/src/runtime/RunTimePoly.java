package runtime;

public class RunTimePoly {
	public static void main(String[] args) {
		//RunTimePoly runTimePoly = new RunTimePoly();
		
		
		/*
		 * Child child = new Child(); child.show(); child.childMethod();
		 * child.parentMethod();
		 */
		
		
		Parent parent = new Child();
		
		parent.show();
		parent.parentMethod();
		
		
		//parent.childMethod();  Doesn't work bcz parent ref does not know about
		// childMethod .
		
		
		
		//Child child = (Child) new Parent();   Class Cast Exception
		
		//child.show();  
		
	}
}
