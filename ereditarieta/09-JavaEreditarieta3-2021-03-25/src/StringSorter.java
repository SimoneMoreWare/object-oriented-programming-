
public class StringSorter extends Sorter {

	@Override
	public int compare(Object a, Object b) {
		// TODO Auto-generated method stub
		
		String sa = (String) a;
		String sb = (String) b;
		return sa.compareTo(sb);
	}

}
