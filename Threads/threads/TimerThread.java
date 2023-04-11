package threads;
import java.io.*; 
public class TimerThread extends Thread{
	private int durata; private Thread[] threads;
	public TimerThread(int durata, Thread... threads) {
	super("timerThread"); this.durata = durata; this.threads = threads;
	}
	public void run() {
	for (Thread t: threads) t.start();
	try {
		sleep((long)(durata * 1000 ));
	} catch (InterruptedException e) {}
	for (Thread t: threads) t.interrupt();
	}
	public static void main(String[] args) throws IOException, Exception {
		BufferedReader keyboard = 	new BufferedReader(new InputStreamReader(System.in));
		System.out.print("input durata in s: "); int durata = Integer.parseInt(keyboard.readLine());
		TimerThread tt =new TimerThread(durata, new SimpleThread1("Torino"), new SimpleThread1("Milano"));
		tt.start();
	}
}
