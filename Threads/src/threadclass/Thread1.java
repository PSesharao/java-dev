package threadclass;

public class Thread1 extends Thread {
	public void run()
	{
		for (int i = 0; i < 100; i++) {
			show();
		}
	}
	
	public void show()
	{
		System.out.println("Thread1!!");
	}
}
