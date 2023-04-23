package threads;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ListSyncEx {

	static class NameList {
		private List<String> names = new LinkedList<>();
		public void add(String name) {
		    names.add(name);
		}
		public String removeFirst() {
		  if (names.size() > 0)
		       return names.remove(0);
		  else return "<empty>";
		} 
	}

	/**
	 * Using a synchronized list
	 */
	static class NameListSL {
		private List<String> names = 
		  Collections.synchronizedList( 
								new LinkedList<>());
		public void add(String name) {
		    names.add(name);
		}
		public String removeFirst() {
		  if (names.size() > 0)
		       return names.remove(0);
		  else return "<empty>";
		} 
	}

	/**
	 * Using a synchronized atomic operation
	 */
	static class NameListA {
		private List<String> names = 
		  Collections.synchronizedList( 
								new LinkedList<>());
		public void add(String name) {
		    names.add(name);
		}
		public String removeFirst() {
		  if (names.size() > 0)
		       return names.remove(0);
		  else return "<empty>";
		} 
	}

	public static void main(String[] args) throws InterruptedException {

		int n = 1000;
		System.out.println("No sync: " + 
		Stream.generate( () -> {
			NameList nl = new NameList();
			nl.add("Hello");
			return multiple(2, nl::removeFirst);
		}).limit(n)
		.collect(Collectors.toSet())
		);
		
		System.out.println("Sync list: " + 
		Stream.generate( () -> {
			NameListSL nl = new NameListSL();
			nl.add("Hello");
			return multiple(2, nl::removeFirst);
		}).limit(n)
		.collect(Collectors.toSet())
		);

		System.out.println("Atomic op: " + 
		Stream.generate( () -> {
			NameListA nl = new NameListA();
			nl.add("Hello");
			return multiple(2, nl::removeFirst);
		}).limit(n)
		.collect(Collectors.toSet())
		);
}

	public static String multiple(int n, Callable<String> task) {
		ExecutorService es = Executors.newCachedThreadPool();
		
		LinkedList<Callable<String>> tasks=new LinkedList<>();
		for(int i=0; i<n; ++i) tasks.add(task);

		String result="";
		try {
			for(Future<String> f : es.invokeAll(tasks)) {
				try {
					result += f.get();
				} catch (ExecutionException e) {
					result += e.getCause().getClass().getSimpleName();
				}
			}
		}catch(InterruptedException ie) {
			return "Interrupted!";
		}
		
		es.shutdown();
		
		return result;
	}

}
