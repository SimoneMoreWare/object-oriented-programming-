
public class Person implements Comparable<Person> {
	private String name;
	
	public Person (String name) {
		this.name = name;
	}
	
	public String getName() {
		return this.name;
	}
	
	public void setName (String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		return this.name;
	}
	
	@Override
	public int compareTo (Person o) {
		return name.compareTo(o.getName());
	}
	
	@Override 
	public boolean equals(Object o) {
		Person p = (Person) o;
		return this.getName().equals(p.getName());
	}

}
