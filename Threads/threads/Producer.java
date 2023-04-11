package threads;
import java.util.*;
public class Producer extends Thread{
	int interval; SimpleBuffer b; List<String> log = new ArrayList<String>();
	public Producer(String name, int interval, SimpleBuffer b) {
	super(name); this.interval = interval; this.b = b;}
	public void run() {
	String[] text = "The early part of her life was spent in Paris".split(" ");
	int i = 0;
	try {
	while (true){
		if (b.put(this, text[i])) log.add(text[i]); 
		i = (i+1) % text.length; long p = (long)(Math.random() * 1000 * interval);
		sleep(p);
	} 
	} catch (InterruptedException e) {}
	System.out.println(getName() + " put " + log);}
}
