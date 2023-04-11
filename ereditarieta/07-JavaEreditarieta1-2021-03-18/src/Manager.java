
public class Manager extends Employee{
	private String managedUnit;
	
	public void changeUnit (String unit) {
		managedUnit=unit;
	}
	
	public String getManagedUnit() {
		return managedUnit;
	}

	@Override
	public void print() {
		System.out.println(getName()+ " "+getWage()+" "+managedUnit);
	}

	//Overloading
	public void print(String s) {
		System.out.println(s);
	}
}
