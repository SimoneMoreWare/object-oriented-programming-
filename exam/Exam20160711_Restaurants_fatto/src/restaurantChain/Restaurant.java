package restaurantChain;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import restaurantChain.Reserve.PayStatus;
import restaurantChain.Reserve.Status;

public class Restaurant {
	
	private String name;
	private int tables;
	private Map<String, Menu> menus = new HashMap<>();
	private Map<String, Reserve> reserves = new HashMap<>();
	private int tablesReserve;
	private int refused;
	private Map<String, Order> orders = new HashMap<>();
	private double income;
	
	public Restaurant(String name, int tables) {
		super();
		this.name = name;
		this.tables = tables;
		this.tablesReserve = 0;
		this.refused = 0;
		this.income = 0.0;
	}

	public String getName(){
		return name;
	}
	
	public void addMenu(String name, double price) throws InvalidName{
		
		if(menus.containsKey(name)) throw new InvalidName();
		
		Menu menu = new Menu(name, price);
		
		menus.put(name, menu);
		
	}
	
	public int reserve(String name, int persons) throws InvalidName{
		
		if(reserves.containsKey(name)) throw new InvalidName();
		
		//creazione reserve 
		if(Restaurant.calcolaTavoli(persons, 4)+tablesReserve<=tables) {
			tablesReserve = (int) (tablesReserve + Restaurant.calcolaTavoli(persons, 4));
			Reserve reserve = new Reserve(name, persons);
			reserves.put(name, reserve);
			return Restaurant.calcolaTavoli(persons, 4);
		}
		refused=refused+persons;
		return 0;
	}
	
	public int getRefused(){
		return refused;
	}
	
	public int getUnusedTables(){
		return tables-tablesReserve;
	}
	
	public boolean order(String name, String... menu) throws InvalidName{
		
		if(!reserves.containsKey(name)) throw new InvalidName();
		for(String m: menu) if(!menus.containsKey(m)) throw new InvalidName();
		
		if(menu.length >= reserves.get(name).getPersons()) {
			Order order = new Order(reserves.get(name));
			reserves.get(name).setStatus(Status.ORDERED);
			for(String m: menu) order.newMenu(menus.get(m));
			orders.put(name, order);
			return true;
		}
		
		return false;
	}
	
	public List<String> getUnordered(){
		return reserves.values().stream().filter(r->r.getStatus()==Status.BOOKED).sorted(Comparator.comparing(Reserve::getName)).map(Reserve::getName).collect(Collectors.toList());
	}
	
	public double pay(String name) throws InvalidName{
		
		if(!reserves.containsKey(name)) throw new InvalidName();
		
		if(reserves.get(name).getStatus()==Status.ORDERED) {
			reserves.get(name).setPayStatus(PayStatus.YES);
			income = income + orders.get(name).getPayment();
			return orders.get(name).getPayment();
		}
		
		return 0.0;
	}
	
	public List<String> getUnpaid(){
		return reserves.values().stream().filter(r->r.getStatus()==Status.ORDERED).filter(r->r.getPayStatus()==PayStatus.NO).sorted(Comparator.comparing(Reserve::getName)).map(Reserve::getName).collect(Collectors.toList());
	}
	
	public double getIncome(){
		return income;
	}
	
	public static int calcolaTavoli(int numeroPersone, int personePerTavolo) {
        int tavoliNecessari = numeroPersone / personePerTavolo;
        if (numeroPersone % personePerTavolo != 0) {
            tavoliNecessari++;
        }
        return tavoliNecessari;
    }


}
