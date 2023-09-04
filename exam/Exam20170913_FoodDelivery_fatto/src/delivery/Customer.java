package delivery;

public class Customer {
	
	private String name;
	private String address;
	private String phone;
	private String email;
	private int id;
	
	public Customer(String name, String address, String phone, String email, int id) {
		super();
		this.name = name;
		this.address = address;
		this.phone = phone;
		this.email = email;
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	@Override
	public String toString() {
		return name + ", " + address + ", " + phone + ", " + email; 
	}

}
