package discounts;

import java.util.LinkedList;
import java.util.List;

public class Purchase {
	
	private Card card;
	private List<Item> items = new LinkedList<>();
	private int id;
	private double amount;
	
	public Purchase(Card card, List<Item> items,int id) {
		super();
		this.card = card;
		this.items = items;
		this.id = id;
		this.amount = this.calculateAmountWithDiscounts();
	}

	private double calculateAmountWithDiscounts() {
		double res = 0.0;
		
		for(Item item: items) {
			
			if(item.getProduct().getCategory().getDiscount()!=null) {
				
				int percetange = item.getProduct().getCategory().getDiscount().getPercentage();
				percetange = 100 - percetange;
				double price = item.getProduct().getPrice();
				int n = item.getN();
	
				res = (res + (double) ((percetange/100.0)*price*n));
		
			}else {
				res = (res + item.getProduct().getPrice()*item.getN()); 

			}
			
		}
		
		return res;
	}

	public Purchase(List<Item> items, int id) {
		super();
		this.items = items;
		this.id = id;
		this.card = null;
		this.amount = this.calculateAmount();
	}

	private double calculateAmount() {
		
		double res = 0.0;
		
		for(Item item: items) {
			res = (res + item.getProduct().getPrice()*item.getN()); 
		}
		
		return res;
		
	}

	public Card getCard() {
		return card;
	}

	public void setCard(Card card) {
		this.card = card;
	}

	public List<Item> getItems() {
		return items;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}
	
	public double getDiscount() {
		
		if(card==null) return 0.0;
		else {
			double res1 = 0.0;
			
			for(Item item: items) {
				res1 = (res1 + item.getProduct().getPrice()*item.getN()); 
			}
			
			double res = 0.0;
			
			for(Item item: items) {
				
				if(item.getProduct().getCategory().getDiscount()!=null) {
					
					int percetange = item.getProduct().getCategory().getDiscount().getPercentage();
					percetange = 100 - percetange;
					double price = item.getProduct().getPrice();
					int n = item.getN();
		
					res = (res + (double) ((percetange/100.0)*price*n));
			
				}else {
					res = (res + item.getProduct().getPrice()*item.getN()); 

				}
				
			}
			
			return res1-res;
		}
		
		
		
	}
	
}
