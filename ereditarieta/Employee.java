package inheritance;

public class Employee {
	String name;
	double wage;

	void incrementWage() {
		wage *= 1.1;
	}

	public void print() {
		System.out.println(name);
	}

	public Employee() {
		name = "John";
		wage = 1000.00;
	}
	
	public Employee(String name, double wage) {
		this.name = name;
		this.wage = wage;
	}
	
	@Override
	public boolean equals(Object o){
		  if(!(o instanceof Employee))
					 return false;
		  	Employee other = (Employee)o;
		  	return this.name.equals(other.name);
	}
	
	@Override
	public String toString(){
		return "Employee: " + name;
	}


}