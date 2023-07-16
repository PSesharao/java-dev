package runnableinterface;

public class RunnableDemo {
	
		public static void main(String[] args) {
			Runnable run1 = new Thread1();
			Runnable run2 = new Thread2();
			
			Thread thread1 = new Thread(run1);
			Thread thread2 = new Thread(run2);
			
			thread1.start();
			thread2.start();
		}
		
}
