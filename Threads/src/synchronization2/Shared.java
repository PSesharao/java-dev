package synchronization2;

public class Shared {
	
	private int sharedResource ;

	public Shared(int sharedResource) {
		this.sharedResource = sharedResource;
	}
	
	/* synchronized */ public void increment()
	{
		synchronized (this) {
		for(int i=1;i<=10000;i++)
			
				this.sharedResource++;
			}
			
	}
	
	/*public void decrement()
	{
		for(int i=1;i<1000;i++)
			this.sharedResource--;
	}*/

	public int getSharedResource() {
		return sharedResource;
	}

	public void setSharedResource(int sharedResource) {
		this.sharedResource = sharedResource;
	}
	
}
