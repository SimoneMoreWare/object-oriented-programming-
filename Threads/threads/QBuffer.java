package threads;
public class QBuffer extends SimpleBuffer {
public QBuffer (int size) {super(size);}
public synchronized boolean put (Thread t, String v) throws InterruptedException {
	while (occupiedSlots == size) {
		System.out.println(t.getName() + " waiting before putting " + v);
		wait();
	}
	System.out.println(t.getName() + " put " + v);
	write(v);
	notifyAll();
	return true;
}
public synchronized String get (Thread t) throws InterruptedException {
	while (occupiedSlots == 0) {
		System.out.println(t.getName() + " waiting before getting ");
		wait();
	}
	String res = read();
	System.out.println(t.getName() +" got " + res);
	notifyAll();
	return res;
}
}
