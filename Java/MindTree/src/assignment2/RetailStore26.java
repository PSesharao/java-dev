package assignment2;
import java.util.Scanner;
public class RetailStore26 {
	private int purchase_item_id;
	private String bill_id;
	private double item_price;
	private int item_quantity;
	private double discount_on_item;
	private String customer_id;

	public static void main(String[] args) {
		RetailStore26 [] transaction = new RetailStore26[5];
		int pid,iq;
		double ip,d;
		String bid,cid;
		Scanner sc = new Scanner(System.in);
		for(int i=0;i<5;i++)
		{
			System.out.println("Enter the details of transaction "+(i+1));
			System.out.println("Enter purchase_item_id of "+(i+1)+":");
			pid=sc.nextInt();
			System.out.println("Enter bill_id of "+(i+1)+":");
			bid=sc.next();
			System.out.println("Enter item_price of "+(i+1)+":");
			ip=sc.nextDouble();
			System.out.println("Enter item_quantity of "+(i+1)+":");
			iq=sc.nextInt();
			System.out.println("Enter discount_on_item of "+(i+1)+":");
			d=sc.nextDouble();
			System.out.println("Enter customer_id of "+(i+1)+":");
			cid = sc.next();
			transaction[i] = new RetailStore26(pid, bid, ip, iq, d, cid);
			System.out.println();
		}
		for(int i=0;i<4;i++)
			for(int j=0;j<4-i;j++)
			{
				if(transaction[j].purchase_item_id>transaction[j+1].purchase_item_id)
				{
					RetailStore26 temp = transaction[j];
					transaction[j]=transaction[j+1];
					transaction[j+1]=temp;
				}
			}
		//transaction[0].displayTransaction();
		System.out.println("Enter the purchase id to be found :");
		int id=sc.nextInt();
		RetailStore26 result = binarySearch(id, 0, 4, transaction);
		if(result!=null)
			result.displayTransaction();
		else
			System.out.println(id+" Not found in the transaction");
		sc.close();
	}
	public static RetailStore26 binarySearch(int purchase_item_id,int low,int high,RetailStore26 [] t)
	{
		while(low<=high)
		{
			int mid=(low+high)/2;
			if(t[mid].purchase_item_id<purchase_item_id)
				low=mid+1;
			else if(t[mid].purchase_item_id<purchase_item_id)
				high=mid-1;
			else
				return t[mid];
		}
		return null;
	}

	public RetailStore26(int purchase_item_id, String bid, double item_price, int item_quantity,
			double discount_on_item, String cid) {
		this.purchase_item_id = purchase_item_id;
		this.bill_id = bid;
		this.item_price = item_price;
		this.item_quantity = item_quantity;
		this.discount_on_item = discount_on_item;
		this.customer_id = cid;
	}
	
	private void displayTransaction() {
		System.out.println("The bill id :"+bill_id);
		System.out.println("The customer id :"+customer_id);
		System.out.println("The purchase item's id :"+purchase_item_id);
		System.out.println("The quantity purchased is :"+item_quantity+" units");
		System.out.println("The discount on item is :"+discount_on_item+" Rs/.");
		System.out.println("Total bill amount :"+item_quantity*(item_price-discount_on_item)+" Rs/.");
	}

}
