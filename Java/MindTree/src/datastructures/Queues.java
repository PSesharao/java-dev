package datastructures;

import java.util.NoSuchElementException;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

public class Queues {
	public static void main(String[] args) {
		Queue<Integer> q1 = new ArrayBlockingQueue<Integer>(3);
		q1.add(10);
		q1.add(20);
		q1.add(30);
		try {
		q1.add(40);
		} catch (IllegalStateException e) {
			System.out.println("Too many elements to add ");
		}
		System.out.println("Head of queue is :"+q1.element());
		for(Integer e : q1)
		{
			System.out.println("Queue value :"+e);
		}
		System.out.println("Removed value :"+q1.remove());
		
		System.out.println("Removed value :"+q1.remove());
		
		System.out.println("Removed value :"+q1.remove());
		
		try {
			System.out.println("Removed value :"+q1.remove());
		} catch (NoSuchElementException e) {
			System.out.println("Tried to remove too many values from queue");
		}
		/////// II nd Implementation ////////////
		Queue<Integer> q2 = new ArrayBlockingQueue<Integer>(3);
		System.out.println("Queue 2 peek :"+q2.peek());// It does'nt rise an error
		q2.offer(10);
		q2.offer(20);
		q2.offer(30);
		q2.offer(40);// It does'nt rise an error
		System.out.println("Queue 2 peek :"+q2.peek());
		if(q2.offer(50)==false) {
			System.out.println("can't add anymore ");
		}
		
		for(Integer e : q1)
		{
			System.out.println("Queue value :"+e);
		}
		
		System.out.println("Removed value :"+q2.poll());
		
		System.out.println("Removed value :"+q2.poll());
		
		System.out.println("Removed value :"+q2.poll());
		
		System.out.println("Removed value :"+q2.poll());//Does't rise an error
	}
	
}
