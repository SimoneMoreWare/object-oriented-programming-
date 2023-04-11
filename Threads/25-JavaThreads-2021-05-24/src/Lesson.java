import java.util.Scanner;

public class Lesson {
	
	/*
	 * A class representing a counter
	 * with a method for incrementing
	 * the counter.
	 */
	
	 static class Counter {
		int count;
		void inc() {
			count = count +1;
		}
		int getCount() {
			return count;
		}
	}
	
	/* Dati condivisi che possono generare race condition */
	static Counter counter;
	static int numberOfIncrements;
	
	/* Class that defines one of the threads */
	
	static class IncrementerThread extends Thread {
		public void run() {
			for (int i=0; i<numberOfIncrements; i++) {
				synchronized(counter) {
					counter.inc();
				}
			}
		}
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		/* Get number of threads and number of increment
		 * per thread
		 */
		
		Scanner in = new Scanner(System.in);
		
		System.out.println ("How many thread do you want to run?");
		int numOfThreads = in.nextInt();
		
		System.out.println ("How many increment per thread?");
		numberOfIncrements = in.nextInt();
		
		/* Create threads */
		
		System.out.println("Working ...");
		
		counter = new Counter();
		
		IncrementerThread[] workers = new IncrementerThread[numOfThreads];
		
		/* Creo tutti i thread */
		for (int i=0; i<numOfThreads;i++) {
			workers[i] = new IncrementerThread();
		}
		
		/* Avvio tutti i thread */
		for (int i=0; i<numOfThreads; i++) {
			workers[i].start();
		}
		
		/* Attendo il completamento di tutti i thread */
		for (int i=0 ; i<numOfThreads; i++) {
			try {
				workers[i].join();
			} catch (InterruptedException e) {
				
			}
		}
		
		System.out.println ("The final value of the counter should be "+numOfThreads*numberOfIncrements);
		System.out.println ("The actual value of the coutner is "+counter.getCount());
	
	}

}
