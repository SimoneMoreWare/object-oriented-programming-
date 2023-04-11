
public class Lesson {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Year y;			//Creo una variabile che può contenere
						//una referenza (puntatore) a un oggetto
						//di tipo year.
		
		y = new Year(); //Creo un oggetto di tipo Year e metto 
						//La referenza all'oggetto in y
		
		//y.year = 10; Illecita perchè l'attributo è privato
		//y = setYear(2021); non va bene è quello avreste fatto in C
		y.setYear(2021); 
		System.out.println("Ciao che bello far lezione nel "+y.getYear());
		
		
		Car c = new Car("rosso","alfa");
		c.printState();
		c.paint("verde");
		c.printState();
		c.turnOn();
		c.printState();
		
		
		Car c1;
		c1 = c;
		c1.printState();
		c1.turnOff();
		c.printState();
		
		c1 = new Car("verde","fiat");
		c1.printState();
		
		c1=null;
		c=null;
		
		c1=new Car("rosso");
		c1.turnOn();
		
		
		//In questo momento entra in gioco il garbage collecotr
	
		
	}

}
