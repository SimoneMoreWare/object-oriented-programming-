package groups;

import java.util.LinkedList;
import java.util.List;

public class Product {
	
	private String typeName;
	private List<Supplier> suppliers = new LinkedList<>();
	
	public Product(String typeName) {
		this.typeName = typeName;
	}
	
	public String getTypeName() {
		return typeName;
	}
	
	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}
	
	public void addSupplier(Supplier supplier) {
		suppliers.add(supplier);
	}
	
	
	
	
}
