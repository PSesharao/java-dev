package synchronization2;

public class SyncApp {
	public static void main(String[] args) throws InterruptedException {
		Shared shared = new Shared(0);

		Thread thread1 = new Thread(new Runnable() {

			@Override
			public void run() {
				shared.increment();
			}
		});

		Thread thread2 = new Thread(new Runnable() {

			@Override
			public void run() {
				shared.increment();
			}
		});
		
		thread1.start();
		
		thread2.start();
		
		thread2.join();
		
		System.out.println(shared.getSharedResource());
	}
}
