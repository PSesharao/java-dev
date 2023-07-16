package runnablelambda;

public class RunnableDemo {
	
	/*// Creating anonymous class 
	Runnable run1 = new Runnable() {
		
		@Override
		public void run() {
			for(int i=0;i<100;i++)
				System.out.println("Thread1!! ");
		}
	};*/
	
	/*
	// Using lamda expressions for runnable since it's functional interface
	Runnable run1 = () ->
	{
		for(int i=0;i<100;i++)
			System.out.println("Thread1!! ");
	};*/
	
	
	// directly passing anonymous runnable instance
	
	public static void main(String[] args) {
		Thread thread1 = new Thread(
				() ->
				{
					for(int i=0;i<100;i++)
						System.out.println("Thread1!! ");
				}
				);
		
		Thread thread2 = new Thread(
					() ->
					{
						for(int i=0;i<100;i++)
							System.out.println("Thread2!! ");
					}
					);
		
		thread1.start();
		thread2.start();
		
	}
	
	
	
}
