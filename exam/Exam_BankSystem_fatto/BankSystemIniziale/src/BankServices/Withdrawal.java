package BankServices;

public class Withdrawal extends Operation{	
	
	private Account account;
	private double value;
	
	public Withdrawal(Account account, int date, double value) {
		super(date);
        this.account = account;
        this.value = value;
	}
	
	public Account getAccount() {
		return account;
	}
	public void setAccount(Account account) {
		this.account = account;
	}

	public double getValue() {
		return value;
	}
	public void setValue(double value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return getDate()+","+value+"-";
	}
	
	
	
}
