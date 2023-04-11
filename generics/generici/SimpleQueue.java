package generici;
@SuppressWarnings("unchecked")
public class SimpleQueue <E> implements Queue <E>{
private int size; protected E[] b; protected int iw, ir; 
private int occupiedSlots = 0;
public SimpleQueue (int size) {
	b = (E[])new Object[size]; 
	//b = new E[size]; //Cannot create a generic array of E
	this.size = size;}
private void write (E v) {b[iw] = v; iw = (iw + 1) % size; occupiedSlots++;}
private E read () {E v = b[ir]; ir = (ir + 1) % size; occupiedSlots--;
	return v;}
public  boolean put (E v) {	boolean res = occupiedSlots < size;
	if (res) write(v); return res;}
public E get () {E res = null;
	if (occupiedSlots > 0) res = read();return res;}
public int size() {return occupiedSlots;}}
