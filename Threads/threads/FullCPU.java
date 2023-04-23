package threads;

import java.util.Arrays;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class FullCPU {

	public static void main(String[] args) throws InterruptedException {
		long markerLength = 25000; //ms
		System.out.println("Starting..." + markerLength);

		generateMarker(markerLength);

		System.out.println("Done.");
		
	}

	final static int N_THREADS = Runtime.getRuntime().availableProcessors();
	private static void generateMarker(long markerLength) throws InterruptedException {
	  //SLEEP
	  Thread.sleep(markerLength);
	  // BUSY
	  final long endBusy = System.currentTimeMillis() + markerLength; 
	  final Thread[] ts = new Thread[N_THREADS];
	  Runnable busy = ()->{ // Busy code
		    while(endBusy>System.currentTimeMillis()){ 
		      for(int i=0; i<markerLength;++i){ }
		    }};
	  Arrays.setAll(ts, t ->  // busy threads
		         new Thread(busy,"Marker " + t));		
	  for(Thread t: ts) t.start(); // busy start
	  // wait for all busy threads to complete
	  for(Thread t:ts) t.join(); 
	  // SLEEP
	  Thread.sleep(markerLength);
	}
	
//	private static void generateMarkerJ5(long markerLength) throws InterruptedException {
//		ExecutorService service = Executors.newFixedThreadPool(N);
//
//		Thread.sleep(markerLength);//SLEEP
//
//		final long temp=System.currentTimeMillis()+markerLength; // end time for BUSY partle 
//		Runnable busy = ()->{
//			int count=0;
//			while(temp>System.currentTimeMillis()){//BUSY
//				for(int i=0; i<markerLength;++i){count+=i;}
//			}
//		};
//
//		Arrays.setAll(ts, t -> { // BUSY
//			Thread m = new Thread(busy);
//			m.start();
//			return m;
//		});
//
//		for(int t=0; t<ts.length; ++t) { // wait for all busy thrads to complete
//			ts[t].join();
//		}
//
//		Thread.sleep(markerLength); // SLEEP
//
//	}

}
