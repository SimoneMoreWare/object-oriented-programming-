import java.util.Comparator;

public class StudentComparatorIdDesc implements Comparator {
	@Override
	public int compare (Object a, Object b) {
		Student sa = (Student) a;
		Student sb = (Student) b;
		if (sa.getId() < sb.getId()) {
			return 1;
		} else {
			if (sa.getId() == sb.getId()) {
				return 0;
			} else {
				return -1;
			}
		}
	}
}
