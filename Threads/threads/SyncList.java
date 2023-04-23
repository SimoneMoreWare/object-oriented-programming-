package threads;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class SyncList {
	
	static Callable<String> adder(List<String> list){
		return () -> {
			try {
				return ""+list.add(Thread.currentThread().toString());
			}catch(Throwable t) {
				return t.toString();
			}
		};
	}
	
	static Callable<String> getFirst(List<String> list){
		return () -> {
			try {
				if(list.size()>0)
					return list.remove(0);
				else
					return "<>";
			}catch(Throwable t) {
				return t.getClass().getName();
			}
		};
	}

	static Callable<String> getFirstAtomic(List<String> list){
		return () -> {
			try {
				synchronized(list){
				if(list.size()>0)
					return list.remove(0);
				else
					return "<>";
				}
			}catch(Throwable t) {
				return t.getClass().getName();
			}
		};
	}

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		System.out.println("Plain list:");
		HashSet<String> outputs = new HashSet<>();
		for(int i=0; i<10000; ++i) {
			LinkedList<String> plainList = new LinkedList<>();
			plainList.add("Hello");
			outputs.add( multiple(2,getFirst(plainList)) );
		}
		System.out.println(outputs);

		System.out.println("Synch list:");
		outputs = new HashSet<>();
		for(int i=0; i<10000; ++i) {
			List<String> synchList = Collections.synchronizedList( new LinkedList<>() );
			synchList.add("Hello");
			outputs.add( multiple(2,getFirst(synchList)) );
		}
		System.out.println(outputs);

		System.out.println("Atomic op list:");
		outputs = new HashSet<>();
		for(int i=0; i<10000; ++i) {
			List<String> plainList = new LinkedList<>();
			plainList.add("Hello");
			outputs.add( multiple(2,getFirst(plainList)) );
		}
		System.out.println(outputs);
	}
	
	public static String multiple(int n, Callable<String> task) throws InterruptedException {
		ExecutorService es = Executors.newCachedThreadPool();
		
		LinkedList<Callable<String>> tasks=new LinkedList<>();
		for(int i=0; i<n; ++i) tasks.add(task);

		String result="";
		for(Future<String> f : es.invokeAll(tasks)) {
			try {
				result += f.get();
			} catch (ExecutionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		es.shutdown();
		
		return result;
	}
	
}
