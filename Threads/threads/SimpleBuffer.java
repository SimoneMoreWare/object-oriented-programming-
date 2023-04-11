package threads;
public class SimpleBuffer {
int size; private String[] b; int iw, ir; 
protected int occupiedSlots = 0;
public SimpleBuffer (int size) {b = new String[size]; this.size = size;}
protected void write (String v) {
	b[iw] = v; iw = (iw + 1) % size; occupiedSlots++;
}
protected String read () {
	String v = b[ir]; ir = (ir + 1) % size; occupiedSlots--;
	return v;
}
public synchronized boolean put (Thread t, String v) throws InterruptedException {
	boolean res = occupiedSlots < size;
	if (res) write(v);
	return res;
}
public synchronized String get (Thread t) throws InterruptedException {
	String res = null;
	if (occupiedSlots > 0) res = read();
	return res;
}}
