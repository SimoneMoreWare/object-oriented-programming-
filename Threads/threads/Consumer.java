package threads;
import java.util.*;
public class Consumer extends Thread{
	int interval; SimpleBuffer b; List<String> log = new ArrayList<String>();
	public Consumer(String name, int interval, SimpleBuffer b) {
	super(name); this.interval = interval; this.b = b;}
	public void run() {
	try {
	while (true){
		String s = b.get(this);
		if (s != null) log.add(s);
		long p = (long)(Math.random() * 1000 * interval);
		sleep(p);
	} 
	} catch (InterruptedException e) {}
	System.out.println(getName() + " put " + log);}
}
