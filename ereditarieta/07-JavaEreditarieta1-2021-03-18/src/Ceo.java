
public class Ceo extends Manager{
	private int stock;

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
	}
}
