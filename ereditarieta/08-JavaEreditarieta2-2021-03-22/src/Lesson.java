
public class Lesson {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Employee e = new Employee ();
		e.setName("Stefano");
		
		Manager m = new Manager();
		m.setName("Marco");
		
		Employee em = (Employee) m;
	
		
		Manager mm = (Manager) em;

		//mm.getManagedUnit();
		
		m.name = "pippo";
		m.print();
		
		Ceo c = new Ceo();
		
		
	}

}
