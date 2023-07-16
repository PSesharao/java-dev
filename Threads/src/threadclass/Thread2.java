package threadclass;

public class Thread2 extends Thread {
	public void run() {

		for (int i = 0; i < 100; i++) {
			show();
		}
	}

	public void show() {
		System.out.println("Thread2!!");
	}
}
