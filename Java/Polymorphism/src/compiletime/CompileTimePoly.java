package compiletime;

public class CompileTimePoly {
	public static void main(String[] args) {
		CompileTimePoly compileTimePoly = new CompileTimePoly();
		compileTimePoly.method();
		compileTimePoly.method("Sesharao");
	}
	
	private void method()
	{
		System.out.println("Hello");
	}
	
	private void method(String name)
	{
		System.out.println("Hello "+ name);
	}

}
