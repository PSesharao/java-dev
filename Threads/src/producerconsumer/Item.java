package producerconsumer;

import java.util.List;

public class Item {
	List<String> containerBox ;
	int capacity ;
	
	public Item(List<String> containerBox, int capacity) {
		this.containerBox = containerBox;
		this.capacity = capacity;
	}
	
	public void produce() throws InterruptedException 
    { 
        int value = 0; 
        while (true) { 
            synchronized (this) 
            { 
                // producer thread waits while list 
                // is full 
                if(containerBox.size() == capacity) 
                    wait(); 
                
                String item = "Item-"+value;
                
                System.out.println("Producer produced-"
                                   + item); 

                // to insert the jobs in the list 
                containerBox.add(item); 
                value++;
                // notifies the consumer thread that 
                // now it can start consuming 
                notify(); 

                // makes the working of program easier 
                // to  understand 
                Thread.sleep(1000); 
            } 
        } 
    } 
	
	 public void consume() throws InterruptedException 
     { 
         while (true) { 
             synchronized (this) 
             { 
                 // consumer thread waits while list 
                 // is empty 
                 if (containerBox.size() == 0) 
                     wait(); 

                 // to remove the first job in the list 
                 String item = containerBox.remove(0);

                 System.out.println("Consumer consumed-"
                                    + item); 

                 // Wake up producer thread 
                 notify(); 

                 // and sleep 
                 Thread.sleep(1000); 
             } 
         } 
     } 
	
	
	
}
