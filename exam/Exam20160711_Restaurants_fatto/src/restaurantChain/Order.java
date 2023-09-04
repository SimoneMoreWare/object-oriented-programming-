package restaurantChain;

import java.util.LinkedList;
import java.util.List;

public class Order {

	private Reserve reserve;
	private List<Menu> menus = new LinkedList<>();
	public Order(Reserve reserve) {
		super();
		this.reserve = reserve;
	}
	public Reserve getReserve() {
		return reserve;
	}
	public void setReserve(Reserve reserve) {
		this.reserve = reserve;
	}
	public List<Menu> getMenus() {
		return menus;
	}
	public void setMenus(List<Menu> menus) {
		this.menus = menus;
	}
	
	public void newMenu(Menu menu) {
		menus.add(menu); 
	}
	public double getPayment() {
		
		double res = 0.0;
		
		for(Menu menu: menus) {
			res = res + menu.getPrice();
		}
		
		return res;
		
	}
}
