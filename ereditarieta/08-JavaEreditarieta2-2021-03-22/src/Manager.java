
public class Manager extends Employee{
	private String managedUnit;
	
	
	protected void privatePrint() {
		System.out.println("Questo messaggio è privato");
	}
	
	public Manager() {
		//Chiamo il costruttore di default di Employee
		System.out.println("Manager Constructor");
		name = null;
	}
	
	public Manager(String name) {
		//Chiamo il costruttore di default di Employee
		this.name = name;
	}
	
	public Manager (String name, double wage, String unit) {
		super (name, wage);
		this.managedUnit = unit;
	}
	
	public void changeUnit (String unit) {
		managedUnit=unit;
	}
	
	public String getManagedUnit() {
		return managedUnit;
	}

	@Override
	public void print() {
		System.out.println(getName()+ " "+getWage()+" "+managedUnit);
		
		 System.out.println(name); //E' accessibile perchè definito come protected
		 //System.out.println(this.wage);//Non è possibile perchè name è privato nella classe padre
	}

	//Overloading
	public void print(String s) {
		System.out.println(s);
	}
}
