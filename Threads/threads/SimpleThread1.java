package threads;
public class SimpleThread1 extends Thread {
	public SimpleThread1(String name) {super(name); }
	public void run() {
	int i = 0;
	try {
	while (true){
	System.out.println(i++ + " " + getName());
	sleep((long)(Math.random() * 1000));
	} 
	} catch (InterruptedException e) {}
	System.out.println("DONE! " + getName());}}
