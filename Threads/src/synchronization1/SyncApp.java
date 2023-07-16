package synchronization1;

public class SyncApp {
	public static void main(String[] args) throws InterruptedException {
		
		System.out.println("==Application Started==");
		
		Printer printer = new Printer();
		
		Thread1 thread1 = new Thread1(printer);
		//Thread1 thread2 = new Thread1(printer);
		Thread2 thread2 = new Thread2(printer);
		
		thread1.start();
		//thread1.join();
		//thread2.start();
		//thread2.join();
		//printer.printDocuments(10, "MachineLearning.pdf");
		thread2.start();
		thread2.join();
		System.out.println("==Application Finished==");
	
	}
}
