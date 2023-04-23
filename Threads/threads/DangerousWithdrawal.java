package threads;

class DangerousWithdrawal {
	private static Account account = new Account();
	public static void main (String [] args) {
		
		Runnable multipleWithdraw = () ->{
			for (int x = 0; x < 5; x++) {
				makeWithdrawal(10);
				if (account.getBalance() < 0)
					System.err.println("Oh no!!");
			}};
		Thread one = new Thread(multipleWithdraw, "Kevin");
		Thread two = new Thread(multipleWithdraw, "Bob");
		one.start();  two.start();
	}
	private static synchronized void makeWithdrawal(int amount) {
		String name = Thread.currentThread().getName();
		if (account.getBalance() >= amount)  {
			System.out.println(name + " is going to withdraw");
			try {
				Thread.sleep(500);
			} catch(InterruptedException ex) { }
			account.withdraw(amount);
			System.out.println( name + " completes the withdrawal");
		} else {
			System.err.println("Not enough in account for "+ name + "to withdraw "+ account.getBalance());
		}  }  }
