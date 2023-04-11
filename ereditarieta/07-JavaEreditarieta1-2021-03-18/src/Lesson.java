public class Lesson {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Employee e1 = new Employee();
		e1.setName("Stefano Di Carlo");
		e1.setWage(0);
		e1.incrementWage();
		//System.out.println(e1.getName()+ " " + e1.getWage());
		e1.print();
		
		Manager m1 = new Manager();
		//Richiamo metodi definiti nella classe
		//Employeee
		m1.setName("Marco Torchiano");
		m1.setWage(3);
		//Richiamo metodi definiti nella classe figlia
		//manager
		m1.changeUnit("Programmazione a oggetti");
		//Mix di metodi delle due classi
		//System.out.println (m1.getName()+" "+m1.getWage()+" "+ m1.getManagedUnit());
		m1.print();
		m1.print("pippo");
		
		Ceo c1 = new Ceo();
		c1.setName("Guido Saracco");
		c1.setWage(0);
		c1.setStock(10000);
		c1.print();
		
		
		//Polimorfismo
		Employee e;
		
		e = new Employee();
		e.setName("Stefano Di Carlo");
		e.setWage(3);
		e.incrementWage();
		e.print();
		
		e = new Manager();
		e.setName("Marco Torchiano");
		e.setWage(3);
		e.incrementWage();
		//Operazione vietata perchè posso accedere solo ai metodi
		//della classe Employee
		//e.changeUnit("OOP");
		
		
		e = new Ceo();

		//Posso definire un vettore di impiegati che contiene 
		//impiegati, manager e ceo.
		
		Employee[] ve = {e1,m1,c1};
		
		System.out.println("Dynamic bindin");
		//Stampare tutti gli impiegati nel vettore ve.
		for (Employee it: ve) {
			it.print();
		}
		
		//Non lecito perchè e1 sta nella gerarchia sopra manager
		//Manager[] vm = {e1,m1,c1};
		
		Employee e3 = c1;
		e3.print();
		
		
	}

}
