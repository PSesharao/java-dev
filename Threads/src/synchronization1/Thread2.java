package synchronization1;

public class Thread2 extends Thread {
	private Printer printer;

	public Thread2(Printer printer) {

		this.printer = printer;
	}

	@Override
	public void run() {
		synchronized (printer) {
		this.printer.printDocuments(10, "DistributedSystems.docx");
		}
	}
}
