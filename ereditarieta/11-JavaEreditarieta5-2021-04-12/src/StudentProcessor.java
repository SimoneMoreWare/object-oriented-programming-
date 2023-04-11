
public class StudentProcessor implements Processor {

	@Override
	public void handle(Object o) {
		// TODO Auto-generated method stub
		Student s = (Student) o;
		System.out.println(s);
	}

}
