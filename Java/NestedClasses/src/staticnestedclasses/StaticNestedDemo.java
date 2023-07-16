package staticnestedclasses;

class OuterClass {
	static int outerStaticVar = 10;
	int outerVar = 20;

	static class InnerStaticClass {
		public void innerStaticMethod() {
			System.out.println("Inside inner static class");
		}
	}
}

public class StaticNestedDemo {
	public static void main(String[] args) {
		System.out.println(OuterClass.outerStaticVar);
		OuterClass.InnerStaticClass innerStaticObj = new OuterClass.InnerStaticClass();
		innerStaticObj.innerStaticMethod();
	}
}
