package BankServices;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class Account {
	
	private String name;
	private int date;
	private double initial;
	private int id;
	private List<Deposit> deposits = new LinkedList<>();
	private double amount;
	private List<Withdrawal> withdrawals = new LinkedList<>();
	private boolean closed;
	private List<Operation> operations = new LinkedList<>();
	
	public Account(String name, int date, double initial, int id) {
		super();
		this.name = name;
		this.date = date;
		this.initial = initial;
		this.id = id;
		this.amount = initial;
		this.closed = false;
	}

	public String toString() {
		return id+","+name+","+date+","+amount;
	}
		
	public List<Operation> getMovements() {
		return operations.stream().sorted(Comparator.comparing(Operation::getDate,Collections.reverseOrder())).collect(Collectors.toList());
	}
	
	public List<Deposit> getDeposits() {
		return deposits.stream().sorted(Comparator.comparing(Deposit::getValue,Collections.reverseOrder())).collect(Collectors.toList());
	}

	public List<Withdrawal> getWithdrawals() {
		return withdrawals.stream().sorted(Comparator.comparing(Withdrawal::getValue,Collections.reverseOrder())).collect(Collectors.toList());
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getDate() {
		return date;
	}

	public void setDate(int date) {
		this.date = date;
	}

	public double getInitial() {
		return initial;
	}

	public void setInitial(double initial) {
		this.initial = initial;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setDeposits(List<Deposit> deposits) {
		this.deposits = deposits;
	}
	
	public void newDeposit(Deposit deposit) {
		deposits.add(deposit);
		this.newOperation(deposit);
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = this.amount + amount;
	}

	public void setWithdrawals(List<Withdrawal> withdrawals) {
		this.withdrawals = withdrawals;
	}
	
	public void newWithdrawals(Withdrawal withdrawal) {
		withdrawals.add(withdrawal);
		this.newOperation(withdrawal);
	}

	public boolean isClosed() {
		return closed;
	}

	public void setClosed(boolean closed) {
		this.closed = closed;
	}

	public List<Operation> getOperations() {
		return operations;
	}

	public void setOperations(List<Operation> operations) {
		this.operations = operations;
	}
	
	public void newOperation(Operation operation) {
		operations.add(operation);
	}
}
