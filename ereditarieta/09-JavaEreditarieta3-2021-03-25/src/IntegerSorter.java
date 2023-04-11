
public class IntegerSorter extends Sorter{

	@Override
	public int compare(Object a, Object b) {
		// TODO Auto-generated method stub
		Integer ai = (Integer) a;
		Integer bi = (Integer) b;
		return ai.compareTo(bi);
	}

}
