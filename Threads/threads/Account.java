package threads;

class Account {
	private int balance = 50;
	
	public synchronized int getBalance() {
		return balance;
	}
	
	public synchronized void  withdraw(int amount){
		balance = balance - amount;
	}
	
	public synchronized void deposit(int amount) {
		balance = balance + amount;
	}
}

