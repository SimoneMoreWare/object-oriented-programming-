package threads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class DeadLock {
	static class Resource {
		int value;
	}
	static Resource resourceA = new Resource();
	static Resource resourceB = new Resource();
	
	static public int read() {
		synchronized(resourceA) {
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			synchronized(resourceB) {
			  return resourceB.value + resourceA.value;
	} } }
	static public void write(int a, int b) {
		synchronized(resourceB) {			
			synchronized(resourceA) {
				resourceA.value = a;
				resourceB.value = b;
	} } } 

	public static void main(String[] args) throws InterruptedException {
		
		for(int i=0; i<20; ++i) {
		ExecutorService es = Executors.newCachedThreadPool();
		es.submit( ()->read() );
		es.submit( ()->write(1,2) );
		es.shutdown();
		
		boolean deadlock = !es.awaitTermination(10, TimeUnit.SECONDS);
		
		if(deadlock) System.err.println("Deadlock!");
		System.out.println("Deadlock: " + deadlock);
		}
	}

}
