package BankServices;

public abstract class Operation {
	
	private int date;

    public Operation(int date) {
        this.date = date;
    }

    public int getDate() {
        return date;
    }
    
	public abstract String toString();
}
