package synchronization1;

public class Thread1 extends Thread{
	private Printer printer;

	public Thread1(Printer printer) {
		
		this.printer = printer;
	}
	
	@Override
	public void run() {
		
		synchronized (printer) {
			this.printer.printDocuments(10, "MachineLearning.pdf");
		}
		
	}

}
