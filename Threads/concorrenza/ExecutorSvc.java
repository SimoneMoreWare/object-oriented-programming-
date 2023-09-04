package concorrenza;

import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ExecutorSvc {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		ExecutorService svc = Executors.newCachedThreadPool();
		
//		for(int i=0; i<5; ++i) {
//			//( new Thread( contatore(i*10,(i+1)*10) ) ).start();
//			svc.submit( contatore(i*10,(i+1)*10) );
//		}
//		
		double[] numeri = new double[10000];
		Random r = new Random(20230518);
		for(int i=0; i<numeri.length; ++i) {
			numeri[i] = r.nextDouble();
		}
		
		long t0 = System.nanoTime();
		int N = 5;
		ArrayList<Future<Double>> parti = new ArrayList<>();
		
		int lunghezzaParte = numeri.length / N;
		for(int i=0; i<N; ++i) {
			int ii = i;
			Future<Double> f = svc.submit( () -> {
				int start = ii*lunghezzaParte;
				int end = (ii+1)*lunghezzaParte;
				double somma=0.0;
				for(int j=start; j<end; ++j) {
					somma+=numeri[j];
				}
				return somma / lunghezzaParte;
			});
			parti.add(f);
		}
		
		double somma = 0.0;
		for(Future<Double> f : parti) {
			double p = f.get();
			somma += p;
		}
		
		double media = somma/N;

		System.out.println(media);
		long elapsedParallel = System.nanoTime()-t0;
		
		t0 = System.nanoTime();
		double res = 0.0;
		for(double d : numeri) {
			res+=d;
		}
		res/=numeri.length;
		System.out.println(res);
		long elapsedSequential = System.nanoTime()-t0;
		
		System.out.println("Parallel: " + elapsedParallel);
		System.out.println("Squentia: " + elapsedSequential);

		svc.shutdown();
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
