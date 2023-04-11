package generici;
import java.util.*;
public class SimpleStack<E extends Comparable<E>> {
	// SimpleStack è una classe generica
	// E è un parametro che sta per un tipo (E, K, T, V)
private String name;
public String getName() {return name;}
private List<E> list = new ArrayList<E>();
public SimpleStack(String name){this.name = name;}
public void push(E element){list.add(element);}
public E pop() {if (list.size() == 0) return null; else return list.remove(0);}
public String getContents() {return list.toString();}
public E get(int index) {return list.get(index);}
public int size() {return list.size();}
public E getMax() {return Collections.max(list);}
public <T> T[] toArray(T[] v) { // metodo generico
	int length = v.length; if (length > size()) length = size();
	Object[] tmp = v;
	for (int i = 0; i < length; i++) {tmp[i] = list.get(i);}
	for (int i = length; i < v.length; i++) v[i] = null;
	return v;
}
public E[] toArray(E[] v) {
	int length = v.length; if (length > size()) length = size();
	for (int i = 0; i < length; i++) {v[i] = list.get(i);}
	for (int i = length; i < v.length; i++) v[i] = null;
	return v;
}
}