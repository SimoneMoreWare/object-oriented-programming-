
public class StudentStatistics {
	static public float oopaverage (Student ...students) {
		float average=0;
		for (Student s: students) {
			average += (float) s.getOopscore();
		}
		return average/students.length;
	}
}
