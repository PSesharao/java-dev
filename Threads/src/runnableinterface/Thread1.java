package runnableinterface;

public class Thread1 implements Runnable {

	@Override
	public void run() {
		for(int i=0;i<100;i++)
			show();
	}
	
	public void show()
	{
		System.out.println("Thread1!! ");
	}
	

}
