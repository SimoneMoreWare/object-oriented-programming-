package generici;
public interface Queue <E> {
	boolean put (E v);
	E get ();
	int size();
}
