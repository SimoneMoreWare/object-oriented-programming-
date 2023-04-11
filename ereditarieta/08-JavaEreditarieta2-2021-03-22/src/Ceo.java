
public class Ceo extends Manager{
	private int stock;

	public Ceo() {
		System.out.println("CEO Constructor");
	}
	
	public Ceo (String name, double wage, String unit, int stock) {
		super (name,wage,unit);
		this.stock = stock;
	}
	
	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}
	
	@Override
	public void print() {
		System.out.println(getName()+
				" "+getWage()+" "+getManagedUnit()
				+" "+stock);
		super.privatePrint();
		//super.super.name="pippo";
	}
}
