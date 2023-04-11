
public class Student implements Comparable {
	private int id;
	private String name;
	
	public Student (int id) {
		this.id=id;
	}
	 public Student (int id, String name) {
		 this.id = id;
		 this.name = name;
	 }
	
	public String getName() {
		return this.name;
	}
	public int getId() {
		return id;
	}



	@Override 
	public int compareTo(Object o) {
		Student other = (Student) o;
		if (this.id < other.id) {
			return -1;
		} else {
			if (this.id == other.id) {
				return 0;
			} else {
				return 1;
			}
		}
	}
	
	public String toString() {
		return Integer.toString(id);
	}
}
