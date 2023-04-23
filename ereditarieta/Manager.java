package inheritance;

public class Manager extends Employee {
	String managedUnit;
	
	void changeUnit(String newUnit) {
		managedUnit = newUnit;
	}

	@Override
	public void print(){ //override
		System.out.print(name + ", mangages " + managedUnit);
	}

	public String getUnit() {
		return managedUnit;
	}
	
	public Manager(String name, double wage, String unit) {
		super(name,wage);
		managedUnit = unit;
	}
	
	public Manager() {
		managedUnit = "Logistics";
	}

}
