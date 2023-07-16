package localnestedclasses;

class OuterClass {
	public void outerClassMethod()
	{
		String name="Sesharao";
		// If below java JDK 7 , it should be final
		class InnerLocalClass
		{
			private String greet()
			{
				return "Hello!! "+name;
			}
			private String goodBye()
			{
				return "Goodbye!! "+name;
			}
			
		}
		InnerLocalClass innerLocalClassObj = new InnerLocalClass();
		System.out.println(innerLocalClassObj.greet());
		System.out.println(innerLocalClassObj.goodBye());
	}
}

public class LocalNestedDemo {
	public static void main(String[] args) {
		OuterClass outerClassObj = new OuterClass();
		outerClassObj.outerClassMethod();
	}
}
