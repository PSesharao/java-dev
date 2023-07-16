package producerconsumer;

import java.util.ArrayList;

public class ProducerConsumerApp {
	public static void main(String[] args) throws InterruptedException {
		
		Item item = new Item(new ArrayList<String>(), 1);
		Thread thread1 = new Thread(new Runnable() {

			@Override
			public void run() {
				try {
					item.produce();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});

		Thread thread2 = new Thread(new Runnable() {

			@Override
			public void run() {
				try {
					item.consume();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});
		
		thread1.start();
		
		thread2.start();
		
		thread2.join();
	}
}
