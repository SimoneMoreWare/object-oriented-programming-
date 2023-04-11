package threads;
import java.io.*;
import java.util.Scanner;
public class TestProdCons {
	public static void main(String[] args) throws IOException, Exception {
		BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("input duration in s, size, producer rate, consumer rate, buffer (S,Q): "); 
		String line = keyboard.readLine(); Scanner s = new Scanner(line);
		int duration = s.nextInt(); int size = s.nextInt(); 
		int pRate = s.nextInt(); int cRate = s.nextInt();
		String bufferType = s.next();
		SimpleBuffer b;
		if (bufferType.equalsIgnoreCase("S")) b = new SimpleBuffer(size);
		else b = new QBuffer(size);
		Producer p1 = new Producer("p1", pRate, b);
		Consumer c1 = new Consumer("c1", cRate, b);
		Consumer c2 = new Consumer("c2", cRate, b);
		TimerThread tt = new TimerThread(duration, p1, c1, c2);
		tt.start();
	}
}
