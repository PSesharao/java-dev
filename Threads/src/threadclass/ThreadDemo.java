package threadclass;

public class ThreadDemo {
	public static void main(String[] args) throws InterruptedException {
		Thread1 thread1 = new Thread1();
		Thread2 thread2 = new Thread2();
		
		thread1.start();
		// To avoid arbitrary interleaving of the threads
		/*try {
			Thread.sleep(10);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}*/
		
		thread1.join();
		
		thread2.start();
		thread2.join();
		System.out.println("Main Thread");
		System.out.println(thread1.getId());
	}
}
