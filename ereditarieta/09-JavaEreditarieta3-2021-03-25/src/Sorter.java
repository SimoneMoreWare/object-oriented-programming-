
public abstract class Sorter {
	public void sort (Object v[]) {
		for (int i=0; i< v.length; i++) {
			for (int j=0; j< v.length; j++) {
				if (compare(v[i],v[j]) > 0) {
					Object tmp = v[i];
					v[i] = v[j];
					v[j] = tmp;
				}
			}
		}
	}
	
	//Compare ritorna:
	//0 se a = b
	//1 se a > b
	//-1 se a < b
	public abstract int compare (Object a, Object b);

}
