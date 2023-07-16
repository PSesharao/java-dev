package anonymousnestedclasses;
abstract class Anonymous
{
	void getName()
	{
		System.out.println("Hello ,Welcome");
	}
	 abstract void getName1();
}
public class AnonymousNestedDemo {
	
	public static void main(String[] args) {
		Anonymous anonymous = new Anonymous()
				{
					void getName1()
					{
						System.out.println("Hello , Sesharao");
					}
			
					//System.out.println("Hello "+name);
				};
				anonymous.getName();
				anonymous.getName1();
	}
}
