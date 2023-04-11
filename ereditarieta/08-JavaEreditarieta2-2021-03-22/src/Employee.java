
public class Employee {
	protected String name;
	private double wage;
	
	public Employee() {
		System.out.println("Employee Constructor");
		name = null;
		wage = 0;
	}
	
	public Employee (String name, double wage) {
		this.name = name;
		this.wage = wage;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getWage() {
		return wage;
	}
	public void setWage(double wage) {
		this.wage = wage;
	}
	
	public void incrementWage() {
		wage = wage +1;
	}
	
	public void print() {
		System.out.println (name+" "+wage);
	}
}
