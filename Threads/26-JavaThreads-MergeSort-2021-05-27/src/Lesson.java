import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.stream.IntStream;

public class Lesson {
	



	public static void main(String[] args) {
		
		
		int v[] = {3,4,5,2,7,1,2, 9, 6, 8};
		   sort(v);
		   for (int n: v) {
			   System.out.print (n+" ");
		   }
		   
	}

	public static void sort(int[] v) {
		Thread t1 = new Thread(new ParallelMergeSorter(0,v.length-1,v,1));
		t1.run();
		try {
			t1.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
