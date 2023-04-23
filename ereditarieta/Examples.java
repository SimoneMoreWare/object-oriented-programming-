package inheritance;

import static java.lang.System.*;

public class Examples {

	public static void main(String[] args) {
		// slide 4
		Manager m = new Manager();
		m.changeUnit("IT Dept.");
		m.incrementWage();
		
		// ---
		SortedVector sv = new SortedVector();
		
		sv.add(1); sv.add(2); sv.add(4); sv.add(5); sv.add(3); sv.add(4);
		
		System.out.println(sv);
		
		// slide 7
		
		Employee e1 = new Employee();
		Employee e2 = new Manager(); 
		e1.print(); 
		e2.print(); 
		
		// slide 22
		
		Employee e = new Employee();
		//Manager m = new Manager();
		Employee em = (Employee) m;

		
		// slide 23
		Employee[] team = {
				  new Manager("Mary Black",25000,"IT"),
				  new Employee("John Smith",12000),
				  new Employee("Jane Doe",12000)
				};

		// slide 25
		
		Manager mm = (Manager)em;

		// slide 26
		
		Employee emp = team[0];
		//String s = emp.getUnit();
		Manager mgr = (Manager)team[0];
		String s = mgr.getUnit();

		// slide 28
		
		if(team[1] instanceof Manager){
			mgr = (Manager)team[1];
		}
		
		// slide 27
		try {
		mgr = (Manager)team[1];
		}catch(ClassCastException cce) {
			cce.printStackTrace();
		}

		// slide 30
		Car myCar;
		myCar = new Car(); // same class
		myCar = new ElectricCar(); // subclass

		for(Employee it : team) {
			it.print();
		}
		
		String[] objNames = {"anEmployee","aManager","aCEO"};
		Employee[] objects = {new Employee(), new Manager(), new CEO()};
		
		out.println("v instance of -> Employee  Manager  CEO");
		for(int i=0; i<objects.length; ++i) {
			out.printf("%-16s %-8b  %-7b  %b\n",objNames[i]
						, (objects[i] instanceof Employee)
						, (objects[i] instanceof Manager)
						, (objects[i] instanceof CEO)
						);
		}
	}

}
