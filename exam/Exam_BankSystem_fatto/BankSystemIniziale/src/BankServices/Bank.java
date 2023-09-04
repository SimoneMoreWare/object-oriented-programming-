package BankServices;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Bank {
	
	private String name;
	private Map<Integer, Account> accounts = new HashMap<>();
	private int idAccount = 1;
	private List<Deposit> deposits = new LinkedList<>();
	private List<Withdrawal> withdrawals = new LinkedList<>();
	
	public Bank(String n) {
		this.name = n;
	}
	
	public String getName() {
		return this.name;
	}
	
	public int createAccount(String name, int date, double initial) {
		
		Account account = new Account(name, date, initial, idAccount);
		
		account.newDeposit(new Deposit(account, date, initial));
		accounts.put(idAccount, account);
		
		return idAccount++;
	}
	
	public Account deleteAccount(int code, int date) throws InvalidCode {
		
		if(!accounts.containsKey(code)) {
			System.out.println(accounts.get(code).getName());
			throw new InvalidCode();
		}
		
		if(date<accounts.get(code).getDate()) date = accounts.get(code).getDate();
		
		accounts.get(code).setDate(date);
		accounts.get(code).newWithdrawals(new Withdrawal(accounts.get(code), date, accounts.get(code).getAmount()));
		accounts.get(code).setAmount(0-accounts.get(code).getAmount());
		accounts.get(code).setClosed(true);
		
		return accounts.get(code);
	}
	
	public Account getAccount(int code) throws InvalidCode {
		
		if(!accounts.containsKey(code)) throw new InvalidCode();
		
		return accounts.get(code);
	}

	public void deposit(int code, int date, double value) throws InvalidCode {
		
		if(!accounts.containsKey(code)) throw new InvalidCode();
		
		if(date < accounts.get(code).getDate()) date = accounts.get(code).getDate();
		
		Deposit deposit = new Deposit(accounts.get(code), date, value);
		
		accounts.get(code).newDeposit(deposit);
		accounts.get(code).setAmount(value);
		//????
		accounts.get(code).setDate(date);
		
		deposits.add(deposit);
		
	}

	public void withdraw(int code, int date, double value) throws InvalidCode, InvalidValue {
		
		if(!accounts.containsKey(code)) throw new InvalidCode();

		if(value>accounts.get(code).getAmount()) throw new InvalidValue();
		
		if(date < accounts.get(code).getDate()) date = accounts.get(code).getDate();

		Withdrawal withdrawal = new Withdrawal(accounts.get(code), date, value);
		
		accounts.get(code).newWithdrawals(withdrawal);
		accounts.get(code).setAmount(0-value);
		
		//???
		accounts.get(code).setDate(date);
		
		withdrawals.add(withdrawal);
		
		
	}
	
	public void transfer(int fromCode, int toCode, int date, double value) throws InvalidCode, InvalidValue {
		
		if(!accounts.containsKey(fromCode) || !accounts.containsKey(toCode)) throw new InvalidCode();
		if(value>accounts.get(fromCode).getAmount()) throw new InvalidValue();
		
		int date1 = date;
		int date2 = date;
		
		if(date<accounts.get(fromCode).getDate()) date1 = accounts.get(fromCode).getDate();
		if(date<accounts.get(toCode).getDate()) date2 = accounts.get(toCode).getDate();
		
		accounts.get(fromCode).setDate(date1);
		accounts.get(toCode).setDate(date2);
		
		if(accounts.get(toCode).getDate()>=accounts.get(fromCode).getDate()) {
			
			accounts.get(toCode).setAmount(value);
			accounts.get(fromCode).setAmount(0-value);
			
			accounts.get(fromCode).newWithdrawals(new Withdrawal(accounts.get(fromCode), date1, value));
			
			accounts.get(toCode).newDeposit(new Deposit(accounts.get(toCode), date2, value));
		}
		
	}
	
	public double getTotalDeposit() {
		return accounts.values().stream()
				.filter(a->!a.isClosed())
				.mapToDouble(a->a.getAmount())
				.sum()
				;
	}
	
	public List<Account> getAccounts() {
		return accounts.values().stream()
				.filter(a->!a.isClosed())
				.sorted(Comparator.comparing(Account::getId))
				.collect(Collectors.toList());
	}
	
	public List<Account> getAccountsByBalance(double low, double high) {
		return accounts.values().stream()
				.filter(a->!a.isClosed())
				.filter(a->a.getAmount()<=high)
				.filter(a->a.getAmount()>=low)
				.sorted(Comparator.comparing(Account::getAmount,Collections.reverseOrder()))
				.collect(Collectors.toList())
				;
	}
	
	public long getPerCentHigher(double min) {
		long accountsCompatible = accounts.values().stream()
				.filter(a->!a.isClosed())
				.filter(a->a.getAmount()>=min)
				.count()
				;
		long sizeAccountsOpen = accounts.values().stream()
				.filter(a->!a.isClosed())
				.count()
				;
		double res = ((double) accountsCompatible/sizeAccountsOpen)*100;
		return (long) res;
	}
}
