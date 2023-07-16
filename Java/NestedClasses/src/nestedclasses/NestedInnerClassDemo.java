package nestedclasses;

class OuterClass {

	int outerVar = 20;

	class InnerClass {
		public void innerStaticMethod() {
			System.out.println("Inside inner class");
		}
	}
}

public class NestedInnerClassDemo {
	public static void main(String[] args) {
		OuterClass outerClassObj = new OuterClass();
		OuterClass.InnerClass innerClassObj = outerClassObj.new InnerClass();
		innerClassObj.innerStaticMethod();
	}
}
