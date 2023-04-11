package generici1;
import java.util.*; import generici.*;
@SuppressWarnings("unchecked")
public class SimpleQueue1<E> extends SimpleQueue<E>{
	public SimpleQueue1(int size) {super(size); }
	public Enumeration<E> enumerator() {return new QueueEnum<E>();}
	private class QueueEnum<T> implements Enumeration<T> {
		int i = ir;
		public boolean hasMoreElements() {return (i != iw);}
		public T nextElement() {
			if (!hasMoreElements()) 
				throw new NoSuchElementException();
	            else return (T)b[i++]; 
			    //senza @SuppressWarnings("unchecked")
			    //Type safety: Unchecked cast from E to T
		}		}}
