
public class Student {
	private int id;
	private int oopscore;
	
	private enum Status {
		PASSED, NOTPASSED
	}
	
	private Status oopstatus;
	
	public int getOopscore() {
		return oopscore;
	}

	public Student (int id, int oopscore) {
		this.id = id;
		this.oopscore = oopscore;
	}
	
	public void computeStatus() {
		if (oopscore >= 18) {
			this.oopstatus = Status.PASSED;
		} else {
			this.oopstatus = Status.NOTPASSED;
		}
	}
	
	public void printStudent() {
		System.out.println (id + " " + oopscore + " "+ oopstatus);
	}
	
	public void finalize() {
		System.out.println ("Lo studente "+id+" sta morendo di noia");
	}
}
