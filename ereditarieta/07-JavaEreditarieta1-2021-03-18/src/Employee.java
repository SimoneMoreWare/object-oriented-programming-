
public class Employee {
	private String name;
	private double wage;
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
