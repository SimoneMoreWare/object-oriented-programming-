package concorrenza;

public class Threads {

	public static void main(String[] args) throws InterruptedException {
		
		Thread t = new Thread(
				()-> {// Threads.main(null) // quello che fa la JVM all'avvio
					System.out.println("Nel thread " + Thread.currentThread().getName());
					for(int i=0; i<10; ++i) {
						try {
							Thread.sleep(500);
						} catch (InterruptedException e) {
							System.out.println("Ops! Mi hanno interrotto!");
							return;
						}
						if( Thread.interrupted() ) {
							System.out.println("Ops! Mi hanno interrotto!");
						}
						System.out.println(i);
					}
				}
				);
		t.start();
		
		System.out.println("Nel thread " + Thread.currentThread().getName());
		
		//t.join(1000);  // aspetto che il thread t finisca
		Thread.sleep(1200);
		
		t.interrupt();
		
		for(int i=0; i<5; ++i) {
			( new Thread( contatore(i*10,(i+1)*10) ) ).start();
		}

	}
	
	/**
	 * Factory method per un runnable contatore
	 * 
	 * @param inizio
	 * @param fine
	 * @return
	 */
	static Runnable contatore(int inizio, int fine) {
		return () -> {
			String nome = Thread.currentThread().getName();
			for(int i=inizio; i<fine; ++i) {
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					System.out.println("[ " + nome + "] Ops! Mi hanno interrotto!");
					return;
				}
				if( Thread.interrupted() ) {
					System.out.println("[ " + nome + "] Ops! Mi hanno interrotto!");
					return;
				}
				System.out.println("[ " + nome + "] " + i);
			}

		};
	}

}
