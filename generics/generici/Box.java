package generici;
public class Box<E> {
	private E thing;
	public  boolean put (E t) {	boolean res = thing == null;
	if (res) thing = t; return res;}
public E get () {E res = thing; thing = null;
	return res;}
public String toString() {//thing = (E) new Object();
	if (thing==null) return "null"; else return "box: " + thing.toString();
}
}
