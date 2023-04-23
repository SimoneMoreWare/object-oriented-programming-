package threads;

public class SpikeInterruptSync {
	
	

	public static void main(String[] args) {
		Thread t1 = new Thread(()->{
			try {
				Thread.sleep(20);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			synchronized(SpikeInterruptSync.class) {
				System.out.println("Here I am!");
				System.out.println("interrupted: " + Thread.interrupted());
			}
		});
		
		Thread t2 = new Thread(()->{
			synchronized(SpikeInterruptSync.class) {
				System.out.println("Got here first!");
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("Interrupting the other thread");
				t1.interrupt();
			}
		});
		
		t2.start();
		t1.start();

	}

}
