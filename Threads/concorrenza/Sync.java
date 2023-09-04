package concorrenza;

import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class Sync {

	public static void main(String[] args) throws InterruptedException {
		ExecutorService svc = Executors.newCachedThreadPool();
		
		double[] numeri = new double[10000];
		Random r = new Random(20230518);
		for(int i=0; i<numeri.length; ++i) {
			numeri[i] = r.nextDouble();
		}
		
		int N = 50;
		
		int lunghezzaParte = numeri.length / N;
		for(int i=0; i<N; ++i) {
			int ii = i;
			svc.submit( () -> {
				int start = ii*lunghezzaParte;
				int end = (ii+1)*lunghezzaParte;
				double somma=0.0;
				for(int j=start; j<end; ++j) {
					somma+=numeri[j];
				}
				aggiornaMedia(somma / lunghezzaParte);
			});
		}
		
		svc.shutdown();
		// 0.49889355036490535  synch
		svc.awaitTermination(0, TimeUnit.SECONDS);
		
		System.out.println("Media: " + Math.round(media*10000));
	}
	
	static double media;
	static int numeroRisultati = 0;
	static synchronized void aggiornaMedia(double mediaParziale) {
		media = (media*numeroRisultati + mediaParziale) / (numeroRisultati+1);
		System.out.println(media);
		++numeroRisultati;
	}
}
